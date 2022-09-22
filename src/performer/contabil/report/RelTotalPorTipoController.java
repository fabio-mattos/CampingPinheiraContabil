
package performer.contabil.report;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.CheckBox;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.DateEdit;
import framework.web.gui.widget.RadioGroup;
import framework.web.gui.widget.Text;
import performer.contabil.controller.BaseControllerReport;
import performer.contabil.persistence.DSEmpresa;
import performer.contabil.persistence.DSHistoricoLancamento;
import performer.contabil.persistence.DSTipoLancamento;
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class RelTotalPorTipoController extends BaseControllerReport {

	private DSTipoLancamento _DSTipoLancamentoPesquisa;
	private DSHistoricoLancamento _DSHistoricoLancamentoPesquisa;
	private DSEmpresa _DSEmpresaPesquisa;
	private RadioGroup _rgSaidaRelatorio;
	private RadioGroup _rgCreditoDebito;
	private RadioGroup _rgTipoOrdenacao;
	private RadioGroup _rgOrdenacao;
	private static final String VALUE_1 = "1"; // Pdf
	private static final String VALUE_2 = "2"; // Excel
	private DateEdit _edtDataInicio;
	private DateEdit _edtDataFim;
	private Text _txtEmpresa;
	private Text _txtBranco;
	private ComboBoxLookup _cbxTipoLancamentoPesquisa;
	private ComboBoxLookup _cbxHistoricoPesquisa;
	private ComboBoxLookup _cbxEmpresaPesquisa;

	@Override
	protected void setupReportFilter() {

		this.setReportInnerLayout(this.createFilterLayout());

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub

		return "Total por Tipo de Lançamento";

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

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
			detail.setHeight(350);
			detail.setWidth(500);
		}

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		_txtBranco = new Text("", this);

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

		_rgCreditoDebito = new RadioGroup("Radio2", this);
		_rgCreditoDebito.setCaption("Credito/Debito");
		_rgCreditoDebito.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgCreditoDebito.addOption("C", "Crédito");
		_rgCreditoDebito.addOption("D", "Débito");
		_rgCreditoDebito.addOption("A", "Crédito/Débito");
		_rgCreditoDebito.setSelectedIndex(0);

		
		
		_rgOrdenacao = new RadioGroup("Radio3", this);
		_rgOrdenacao.setCaption("Ordenação");
		_rgOrdenacao.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgOrdenacao.addOption("N", "Nome");
		_rgOrdenacao.addOption("C", "Crédito");
		_rgOrdenacao.addOption("D", "Débito");
		_rgOrdenacao.setSelectedIndex(0);
		

		_rgTipoOrdenacao = new RadioGroup("Radio4", this);
		_rgTipoOrdenacao.setCaption("Tipo Ordenação");
		_rgTipoOrdenacao.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgTipoOrdenacao.addOption("C", "Cresc.");
		_rgTipoOrdenacao.addOption("D", "Decresc.");
		_rgTipoOrdenacao.setSelectedIndex(0);
		
		
		_rgOrdenacao.setSelectedIndex(0);
		
		
		
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

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1 });
		{

			detail.addField("Empresa: ", _cbxEmpresaPesquisa);
			detail.addField("Histório: ", _cbxHistoricoPesquisa);
			detail.addField("Tipo Histórico: ", _cbxTipoLancamentoPesquisa);
		}
		detail.addTable(new int[] { 1, 1 });
		{
			detail.addField("Data Início", _edtDataInicio);
			detail.addField("Data Fim", _edtDataFim);

		}
		detail.addTable(new int[] { 2, 1 });
		{
			detail.addField("  ", _rgCreditoDebito);
			detail.addField("  ", _rgSaidaRelatorio);

		}
		
		
		detail.addTable(new int[] { 2, 1 });
		{
			detail.addField("  ", _rgOrdenacao);
			detail.addField("  ", _rgTipoOrdenacao);

		}

	}

	@Override
	protected void performReportView() {

		this.generatePDF();

	}

	private void generatePDF() {

		String strdataInicioBR = new SimpleDateFormat("dd/MM/yyyy").format(_edtDataInicio.getValue());
		String strdataFimBR = new SimpleDateFormat("dd/MM/yyyy").format(_edtDataFim.getValue());

		StaticReportManager report = new StaticReportManager();
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("PERIODO", strdataInicioBR + " A " + strdataFimBR);
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

		String strdataInicioUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataInicio.getValue());
		String strdataFimUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataFim.getValue());

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
		SqlReport.append("en_ativo_passivo.cd_empresa = " + empresa_selecionada + " AND ");
		SqlReport.append("en_ativo_passivo.dt_historico BETWEEN '" + strdataInicioUS + "' AND '" + strdataFimUS + "'  ");

		if (_rgCreditoDebito.getValue().equals("C")) {
			SqlReport.append(" and  en_ativo_passivo.vl_credito > 0 ");
		} else if (_rgCreditoDebito.getValue().equals("D")) {
			SqlReport.append(" and en_ativo_passivo.vl_debito > 0 ");
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
		
		
		
		
		
		SqlReport.append("ORDER BY " + MontaOrderBy());
		
		
		 

		try {

			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}
	
	public String MontaOrderBy() {
		String retorno = "";
		
		if (_rgOrdenacao.getValue().equals("N")) {
			
			retorno = " 1 ";
		} else if (_rgOrdenacao.getValue().equals("C")) {
			
			retorno = " 2 ";
		} else   {
			
			retorno = " 3 ";
		}
		
		if (_rgTipoOrdenacao.getValue().equals("D")) {
			retorno = retorno + " desc " ;
		}
		
		return retorno;
	}

}
