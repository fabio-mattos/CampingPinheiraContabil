package performer.contabil.report;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.CheckBox;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.DateEdit;
import framework.web.gui.widget.ListView;
import framework.web.gui.widget.RadioGroup;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import framework.web.gui.widget.events.ChangeEvent;
import framework.web.gui.widget.events.IChangeListener;
import performer.contabil.controller.BaseControllerReport;
import performer.contabil.persistence.DSAtivoPassivo;
import performer.contabil.persistence.DSEmpresa;
import performer.contabil.persistence.DSHistoricoLancamento;
import performer.contabil.persistence.DSTipoLancamento;
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class RelConferenciaTotaisController extends BaseControllerReport {

	private DSAtivoPassivo _DSAtivoPassivo;
	private DSTipoLancamento _DSTipoLancamentoPesquisa;
	private DSHistoricoLancamento _DSHistoricoLancamentoPesquisa;
	private DSEmpresa _DSEmpresaPesquisa;
	private RadioGroup _rgSaidaRelatorio;

	private static final String VALUE_1 = "1"; // Pdf
	private static final String VALUE_2 = "2"; // Excel
	private DateEdit _edtDataInicio;
	private DateEdit _edtDataFim;
	private Text _txtEmpresa;
	private Text _txtBranco;
	private ComboBoxLookup _cbxTipoLancamentoPesquisa;
	private ComboBoxLookup _cbxHistoricoPesquisa;
	private ComboBoxLookup _cbxEmpresaPesquisa;
	private PeButton _btnPesquisa;
	private PeButton _btnTotaliza;
	public ListView _listaTotais;
	private CheckBox _cbxTodos;
	private Text _txtTotalCredito;
	private Text _txtTotalDebito;
	private Text _txtTotalSaldo;
	private TextEdit _edtNuPagina;

	@Override
	protected void setupReportFilter() {

		this.setReportInnerLayout(this.createFilterLayout());

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub

		return "Conferência Totais";

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSAtivoPassivo = new DSAtivoPassivo(this.getApplicationName());
		_DSAtivoPassivo.addBucket("fg_sel", DataStore.DATATYPE_STRING);

		_DSTipoLancamentoPesquisa = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamentoPesquisa
				.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada);

		_DSHistoricoLancamentoPesquisa = new DSHistoricoLancamento(this.getApplicationName());
		_DSHistoricoLancamentoPesquisa.retrieve(DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_EMPRESA + " = "
				+ empresa_selecionada + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_FG_ATIVO + " = 'S'");

		_DSEmpresaPesquisa = new DSEmpresa(this.getApplicationName());
		_DSEmpresaPesquisa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa_selecionada);

	}

	private PeWidget<?> createFilterLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, new DataStore(), true);
		{
			detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
			detail.setCaptionTop(true);
			detail.setHeight(650);
			detail.setWidth(750);
		}

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		_cbxTodos = new CheckBox("Todos", this, "Todos", "1", "0");
		_cbxTodos.setChangeListener(new onChangeTodos(), EventType.WAIT);

		_txtBranco = new Text("", this);

		_txtTotalDebito = new Text("0", this);
		_txtTotalDebito.setCustomStyle("color:red;");

		_txtTotalCredito = new Text("0", this);
		_txtTotalCredito.setCustomStyle("color:blue;");

		_txtTotalSaldo = new Text("0", this);
		_txtTotalSaldo.setCustomStyle("color:green;");

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("NOME_EMPRESA_SELECIONADA");
		_txtEmpresa = new Text(empresa, this);
		_txtEmpresa.setCustomStyle("color: blue;");

		Calendar cal = Calendar.getInstance();
		int ano = cal.get(Calendar.YEAR);
		int mes = cal.get(Calendar.MONTH);
		mes = mes + 1;

		_edtDataInicio = new DateEdit("idt", this);
		_edtDataInicio.setValue(Utils.PrimeiroDiaMes(Short.parseShort(mes + ""), ano));

		_edtDataFim = new DateEdit("fdt", this);
		_edtDataFim.setValue(cal.getTime());

		_rgSaidaRelatorio = new RadioGroup("Radio1", this);
		_rgSaidaRelatorio.setCaption("Tipo Saída");
		_rgSaidaRelatorio.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgSaidaRelatorio.addOption(VALUE_1, "PDF");
		_rgSaidaRelatorio.addOption(VALUE_2, "Excel");
		_rgSaidaRelatorio.setSelectedIndex(0);

		_edtNuPagina = new TextEdit("", this);

		_cbxEmpresaPesquisa = new ComboBoxLookup("emp", this);
		_cbxEmpresaPesquisa.setLookupInfo(_DSEmpresaPesquisa, DSEmpresa.EN_EMPRESA_CD_EMPRESA,
				DSEmpresa.EN_EMPRESA_DE_SIGLA);
		_cbxEmpresaPesquisa.setValue((String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA"));
		_cbxEmpresaPesquisa.setEnable(false);

		_cbxTipoLancamentoPesquisa = new ComboBoxLookup("tp", this);
		_cbxTipoLancamentoPesquisa.setLookupInfo(_DSTipoLancamentoPesquisa,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);

		_cbxHistoricoPesquisa = new ComboBoxLookup("hp", this);
		_cbxHistoricoPesquisa.setLookupInfo(_DSHistoricoLancamentoPesquisa,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);

		PeButton.Attributes attr = new PeButton.Attributes();
		attr.setText("Pesquisa");
		_btnPesquisa = new PeButton(attr);
		_btnPesquisa.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotPesquisaClick"));

		attr.setText("Totaliza Selecionados");
		_btnTotaliza = new PeButton(attr);
		_btnTotaliza.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotTotalizaClick"));

		_listaTotais = new ListView("ListaTotais", this);
		_listaTotais.setDataStore(_DSAtivoPassivo);
		_listaTotais.addColumn("fg_sel", ListView.CTYPE_CHECK, "Sel", 50, "center", "#d5f1ff");
		_listaTotais.addColumn(DSAtivoPassivo.EN_ATIVO_PASSIVO_DT_HISTORICO, ListView.CTYPE_DATE, "Data", 100, "center",
				"#d5f1ff");
		_listaTotais.addColumn(DSAtivoPassivo.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO, ListView.CTYPE_READONLY,
				"Histórico", 100, "center", "#d5f1ff");

		_listaTotais.addColumn(DSAtivoPassivo.EN_ATIVO_PASSIVO_VL_DEBITO, ListView.CTYPE_PRICE, "Débito", 100, "center",
				"#d5f1ff");
		_listaTotais.addColumn(DSAtivoPassivo.EN_ATIVO_PASSIVO_VL_CREDITO, ListView.CTYPE_PRICE, "Crédito", 100,
				"center", "#d5f1ff");
		_listaTotais.setHeight(350);
		_listaTotais.setWidth(650);

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1 });
		{

			detail.addField("Empresa: ", _cbxEmpresaPesquisa);
			detail.addField("Histório: ", _cbxHistoricoPesquisa);
			detail.addField("Tipo Histórico: ", _cbxTipoLancamentoPesquisa);
		}
		detail.addTable(new int[] { 1, 1, 1, 1, 1, 1, 1 });
		{
			detail.addField("Data Início", _edtDataInicio);
			detail.addField("Data Fim", _edtDataFim);
			detail.addField("Nº Página", _edtNuPagina);

			detail.addField("  ", _btnPesquisa).setInlineStyle("margin-top:15px");
			detail.addField("  ", _btnTotaliza).setInlineStyle("margin-top:15px");
			detail.addField("  ", _rgSaidaRelatorio);
			detail.addField("  ", _cbxTodos).setInlineStyle("margin-top:15px");

		}

		detail.addTable(new int[] { 1 });
		{
			detail.addField("  ", _listaTotais);

		}

		detail.addTable(new int[] { 1, 1, 1 });
		{
			detail.addField("  ", _txtTotalDebito);
			detail.addField("  ", _txtTotalCredito);
			detail.addField("  ", _txtTotalSaldo);

		}

	}

	@Override
	protected void performReportView() {

		this.generatePDF();

	}

	private void generatePDF() {

		String strdataInicioBR = null;
		String strdataFimBR = null;
		String periodo = "";

		if (_edtDataInicio.getValue() != null) {
			strdataInicioBR = new SimpleDateFormat("dd/MM/yyyy").format(_edtDataInicio.getValue());
		}

		if (_edtDataFim.getValue() != null) {
			strdataFimBR = new SimpleDateFormat("dd/MM/yyyy").format(_edtDataFim.getValue());
		}

		StaticReportManager report = new StaticReportManager();
		Map<String, Object> params = new HashMap<String, Object>();

		if (strdataInicioBR != null && strdataFimBR != null) {
			periodo = strdataInicioBR + " A " + strdataFimBR;
		} else if (strdataInicioBR != null && strdataFimBR == null) {
			periodo = strdataInicioBR;
		}
		
		
		if (_edtNuPagina.getValue() != null) {
			periodo  = periodo  + " Página: " + _edtNuPagina.getValue();
		}

		params.put("PERIODO", periodo);

		params.put("IMAGE_DIRECTORY", Utils.getImagePath());

		if (_rgSaidaRelatorio.getValue().equals("1")) {
			report.generateReport("RelTotalizadorTipo", params, this.getSQL());
		} else {
			params.put("IS_IGNORE_PAGINATION", true);
			report.generateXLS("RelTotalizadorTipoXLS", params, this.getSQL());

		}

	}

	private String getSQL() {

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		StringBuffer SqlReport = new StringBuffer();

		String strdataInicioUS = null;
		String strdataFimUS = null;

		if (_edtDataInicio.getValue() != null) {
			strdataInicioUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataInicio.getValue());
		}

		if (_edtDataFim.getValue() != null) {
			strdataFimUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataFim.getValue());
		}

		SqlReport.append("SELECT ");
		SqlReport.append("en_historico_lancamento.nm_historico_lancamento, ");

		SqlReport.append("Sum(en_ativo_passivo.vl_credito) AS totalCredito, ");
		SqlReport.append("Sum(en_ativo_passivo.vl_debito) AS totalDebito, ");

		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append("en_empresa.nm_empresa ");
		SqlReport.append("FROM ");
		SqlReport.append("en_ativo_passivo ");
		SqlReport.append("INNER JOIN en_historico_lancamento ON  ");
		SqlReport.append("en_historico_lancamento.cd_historico_lancamento =  ");
		SqlReport.append("en_ativo_passivo.cd_historico_lancamento ");
		SqlReport.append("CROSS JOIN en_parametro ");
		SqlReport.append("INNER JOIN en_empresa ON en_empresa.cd_empresa =  ");
		SqlReport.append("en_ativo_passivo.cd_empresa ");
		SqlReport.append("WHERE ");
		SqlReport.append("en_ativo_passivo.cd_empresa = " + empresa_selecionada + "  ");

		if (_edtNuPagina.getValue() != null) {
			SqlReport.append(" and en_ativo_passivo.nu_pagina = " + _edtNuPagina.getValue() + " ");
		}

		if (strdataInicioUS != null && strdataFimUS != null) {

			SqlReport.append("and en_ativo_passivo.dt_historico BETWEEN '" + strdataInicioUS + " 00:00:00' AND '"
					+ strdataFimUS + " 23:59:59'  ");
		} else if (strdataInicioUS != null && strdataFimUS == null) {

			SqlReport.append("and en_ativo_passivo.dt_historico BETWEEN '" + strdataInicioUS + " 00:00:00' AND '"
					+ strdataInicioUS + " 23:59:59'  ");
		}

		if ((String) _cbxHistoricoPesquisa.getValue() != null) {
			SqlReport.append("and en_ativo_passivo.cd_historico_lancamento = "
					+ (String) _cbxHistoricoPesquisa.getValue() + " ");
		}
		if ((String) _cbxTipoLancamentoPesquisa.getValue() != null) {
			SqlReport.append("and en_historico_lancamento.cd_tipo_lancamento = "
					+ (String) _cbxTipoLancamentoPesquisa.getValue() + " ");
		}

		SqlReport.append("GROUP BY ");
		SqlReport.append("en_empresa.nm_empresa, ");
		SqlReport.append("en_historico_lancamento.nm_historico_lancamento, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao ");

		try {

			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}
	}

	public void slotPesquisaClick(PeEventObject e) {

		String strdataInicioUS = null;
		String strdataFimUS = null;
		String filtro = "0 = 0 ";

		if (_edtDataInicio.getValue() != null) {
			strdataInicioUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataInicio.getValue());
		}

		if (_edtDataFim.getValue() != null) {

			strdataFimUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataFim.getValue());
		}

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		if (_edtDataInicio.getValue() != null && _edtDataFim.getValue() == null) {
			filtro = filtro + " and " +  DSAtivoPassivo.EN_ATIVO_PASSIVO_DT_HISTORICO + " between '" + strdataInicioUS
					+ " 00:00:00' and '" + strdataInicioUS + " 23:59:59'   ";
		} else if (_edtDataInicio.getValue() != null && _edtDataFim.getValue() != null) {
			filtro = filtro + " and " + DSAtivoPassivo.EN_ATIVO_PASSIVO_DT_HISTORICO + " between '" + strdataInicioUS
					+ " 00:00:00' and '" + strdataFimUS + " 23:59:59'   ";
		}

		if (_edtNuPagina.getValue() != null && !(_edtNuPagina.getValue().trim().equals(""))) {
			filtro = filtro + " and " + DSAtivoPassivo.EN_ATIVO_PASSIVO_NU_PAGINA + " = " + _edtNuPagina.getValue();
		}

		try {
			_DSAtivoPassivo.retrieve(filtro + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_EMPRESA + " = "
					+ empresa_selecionada + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_FG_ATIVO
					+ " = 'S'");

		} catch (DataStoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i <= _DSAtivoPassivo.getRowCount() - 1; i++) {
			_DSAtivoPassivo.setString(i, "fg_sel", "1");
		}

		slotTotalizaClick(null);

		_listaTotais.refresh();

	}

	public void slotTotalizaClick(PeEventObject e) {

		double totalCredito = 0D;
		double totalDebito = 0D;

		for (int i = 0; i <= _DSAtivoPassivo.getRowCount() - 1; i++) {

			if (_DSAtivoPassivo.getString(i, "fg_sel") != null && _DSAtivoPassivo.getString(i, "fg_sel").equals("1")) {

				if (_DSAtivoPassivo.getEnAtivoPassivoVlCredito(i) > 0) {
					totalCredito = totalCredito + _DSAtivoPassivo.getEnAtivoPassivoVlCredito(i);
				}

				if (_DSAtivoPassivo.getEnAtivoPassivoVlDebito(i) > 0) {
					totalDebito = totalDebito + _DSAtivoPassivo.getEnAtivoPassivoVlDebito(i);
				}
			}

		}

		_txtTotalCredito.setText("Crédito: " + Utils.doubleToStr(totalCredito, 1));
		_txtTotalDebito.setText("Débito: " + Utils.doubleToStr(totalDebito, 1));

		_txtTotalSaldo.setText("Saldo:" + Utils.doubleToStr(totalCredito - totalDebito, 1));

		if ((totalCredito - totalDebito) < 0) {
			_txtTotalSaldo.setCustomStyle("color:red;");
		} else {
			_txtTotalSaldo.setCustomStyle("color:green;");
		}

	}

	class onChangeTodos implements IChangeListener {

		@Override
		public void onChangeEvent(ChangeEvent e) {

			if (_cbxTodos.getValue() != null && _cbxTodos.getValue() == true) {

				for (int i = 0; i <= _DSAtivoPassivo.getRowCount() - 1; i++) {
					_DSAtivoPassivo.setString(i, "fg_sel", "1");
				}

			} else {
				for (int i = 0; i <= _DSAtivoPassivo.getRowCount() - 1; i++) {
					_DSAtivoPassivo.setString(i, "fg_sel", "2");
				}
			}
			_listaTotais.refresh();
		}
	}
}
