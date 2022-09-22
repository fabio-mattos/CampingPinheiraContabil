package performer.contabil.report;

import java.sql.SQLException;
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
import framework.web.gui.widget.RadioGroup;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import performer.contabil.controller.BaseControllerReport;
import performer.contabil.persistence.DSTipoLancamento;
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class RelGraficoTipoLancamentoController extends BaseControllerReport {

	private RadioGroup _rgSaidaRelatorio;
	private RadioGroup _rgValorQtdade1;
	private RadioGroup _rgValorQtdade2;
	private static final String VALUE_1 = "1"; // Pdf
	private static final String VALUE_2 = "2"; // Excel
	private CheckBox _cbxEliminarAnoAtual;
	private Text _txtEmpresa;
	private Text _txtBranco;
	private ComboBoxLookup _cbxTipoLancamento1;
	private ComboBoxLookup _cbxTipoLancamento2;

	private DSTipoLancamento _DSTipoLancamento1;
	private DSTipoLancamento _DSTipoLancamento2;

	@Override
	protected void setupReportFilter() {

		this.setReportInnerLayout(this.createFilterLayout());

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub

		return "Imprime Gráfico Por Tipo de Lançamento";

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {
		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSTipoLancamento1 = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamento1.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada);

		_DSTipoLancamento2 = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamento2.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada);
	}

	private PeWidget<?> createFilterLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, new DataStore(), true);
		{
			detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
			detail.setCaptionTop(true);
			detail.setHeight(300);
			detail.setWidth(400);
		}

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		_cbxTipoLancamento1 = new ComboBoxLookup("tp1", this);
		_cbxTipoLancamento1.setLookupInfo(_DSTipoLancamento1, DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);

		_cbxTipoLancamento2 = new ComboBoxLookup("tp2", this);
		_cbxTipoLancamento2.setLookupInfo(_DSTipoLancamento2, DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);

		_txtBranco = new Text("", this);

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("NOME_EMPRESA_SELECIONADA");
		_txtEmpresa = new Text(empresa, this);
		_txtEmpresa.setCustomStyle("color: blue;");

		_cbxEliminarAnoAtual = new CheckBox("ckAA", this, "Elinimar Ano Atual ", "1", "0");
		_cbxEliminarAnoAtual.setValue(true);

		_rgSaidaRelatorio = new RadioGroup("Radio_Sexo", this);
		_rgSaidaRelatorio.setCaption("Tipo Saída");
		_rgSaidaRelatorio.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgSaidaRelatorio.addOption(VALUE_1, "PDF");
		_rgSaidaRelatorio.addOption(VALUE_2, "Excel");
		_rgSaidaRelatorio.setSelectedIndex(0);

		_rgValorQtdade1 = new RadioGroup("R1", this);
		_rgValorQtdade1.setCaption("Tipo Soma");
		_rgValorQtdade1.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgValorQtdade1.addOption("V", "Valor");
		_rgValorQtdade1.addOption("Q", "Quantidade");
		_rgValorQtdade1.setSelectedIndex(0);

		_rgValorQtdade2 = new RadioGroup("R2", this);
		_rgValorQtdade2.setCaption("Tipo Soma");
		_rgValorQtdade2.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgValorQtdade2.addOption("V", "Valor");
		_rgValorQtdade2.addOption("Q", "Quantidade");
		_rgValorQtdade2.setSelectedIndex(0);

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1 });
		{

			detail.addField("Empresa: ", _txtEmpresa);
		}
		detail.addTable(new int[] { 1, 1 });
		{
			detail.addField("Tipo Lançamento1 ", _cbxTipoLancamento1);
			detail.addField(".", _rgValorQtdade1);
			detail.addField("Tipo Lançamento2", _cbxTipoLancamento2);
			detail.addField(". ", _rgValorQtdade2);
		}
		detail.addTable(new int[] { 3, 6 });
		{
			detail.addField(" ", _cbxEliminarAnoAtual);

			detail.addField("  ", _rgSaidaRelatorio);

		}

	}

	@Override
	protected void performReportView() {

		this.generatePDF();

	}

	private void generatePDF() {

		StaticReportManager report = new StaticReportManager();
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("SUBREPORT_DIR", Utils.getReportPath());
		params.put("IMAGE_DIRECTORY", Utils.getImagePath());
		if (_rgSaidaRelatorio.getValue().equals("1")) {
			report.generateReport("RelGraficoTipoLancamento", params, this.getSQL());
		} else {
			report.generateXLS("RelGraficoTipoLancamento", params, this.getSQL());

		}
	}

	private String getSQL() {

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		String lanc1 = (String) _cbxTipoLancamento1.getValue();
		String lanc2 = (String) _cbxTipoLancamento2.getValue();
		String nome2 = "";

		if (lanc2 != null) {
			nome2 = _DSTipoLancamento2.getEnTipoLancamentoNmTipoLancamento(_cbxTipoLancamento2.getSelectedIndex());
		} else {
			lanc2 = " -1";
		}

		StringBuffer SqlReport = new StringBuffer();

		SqlReport.append(" SELECT ");
		SqlReport.append("en_empresa.nm_empresa, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append(" en_ativo_passivo.nu_ano, ");
		SqlReport.append("en_tipo_lancamento.nm_tipo_lancamento as nome1, ");

		if (_rgValorQtdade1.getValue().equals("V")) {
			SqlReport.append(
					"sum( abs( COALESCE(en_ativo_passivo.vl_credito,0) - COALESCE(en_ativo_passivo.vl_debito,0))) as vl_saldo1, ");
		} else {
			SqlReport.append(
					"sum(COALESCE(en_ativo_passivo.qt_consumo,0))  as vl_saldo1, ");
		}
		SqlReport.append(" ");
		SqlReport.append("'" + nome2 + "' as nome2, ");
		SqlReport.append("(SELECT ");
		SqlReport.append(" ");

		if (_rgValorQtdade2.getValue().equals("V")) {

			SqlReport.append("sum(abs(COALESCE(ap.vl_credito,0) - COALESCE(ap.vl_debito,0)))  ");
		} else {
			SqlReport.append("sum(COALESCE(ap.qt_consumo,0))  ");
		}
		SqlReport.append(" ");
		SqlReport.append("FROM ");
		SqlReport.append("en_ativo_passivo  ap ");
		SqlReport.append(" ");
		SqlReport.append("INNER JOIN en_historico_lancamento hl ON hl.cd_historico_lancamento =  ");
		SqlReport.append("ap.cd_historico_lancamento ");
		SqlReport.append(" ");
		SqlReport.append("inner JOIN en_tipo_lancamento tl on ");
		SqlReport.append("tl.cd_tipo_lancamento = hl.cd_tipo_lancamento ");
		SqlReport.append(" ");
		SqlReport.append("where ");
		SqlReport.append("  ap.cd_empresa =  " + empresa + " ");
		SqlReport.append("and tl.cd_tipo_lancamento   =  " + lanc2 + " ");
		SqlReport.append(" and ap.nu_ano =  en_ativo_passivo.nu_ano) as vl_saldo2 ");
		SqlReport.append(" ");
		SqlReport.append(" ");
		SqlReport.append("FROM ");
		SqlReport.append("en_ativo_passivo ");
		SqlReport.append(" ");
		SqlReport.append("INNER JOIN en_historico_lancamento ON  ");
		SqlReport.append("en_historico_lancamento.cd_historico_lancamento =  ");
		SqlReport.append("en_ativo_passivo.cd_historico_lancamento ");
		SqlReport.append("inner JOIN en_tipo_lancamento on ");
		SqlReport.append("en_tipo_lancamento.cd_tipo_lancamento =  ");
		SqlReport.append("en_historico_lancamento.cd_tipo_lancamento ");
		SqlReport.append("inner join en_empresa on en_empresa.cd_empresa =  ");
		SqlReport.append("en_ativo_passivo.cd_empresa ");
		SqlReport.append("cross join en_parametro ");
		SqlReport.append("where ");

		if (_cbxEliminarAnoAtual.getValue() != null && _cbxEliminarAnoAtual.getValue() == true) {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			SqlReport.append(" en_ativo_passivo.nu_ano <>  " + year + " and ");
		}

		SqlReport.append("  en_ativo_passivo .cd_empresa  =  " + empresa + " ");
		SqlReport.append("and en_tipo_lancamento.cd_tipo_lancamento =  " + lanc1 + " ");
		SqlReport.append("GROUP BY en_empresa.nm_empresa,en_ativo_passivo.nu_ano,  ");
		SqlReport.append("en_tipo_lancamento.nm_tipo_lancamento  ");
		SqlReport.append(",en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao ");
		SqlReport.append("order by  en_ativo_passivo.nu_ano ");

		 

		try {
			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}

}
