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
import framework.web.gui.widget.RadioGroup;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import performer.contabil.controller.BaseControllerReport;
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class RelGraficoFaturamentoController extends BaseControllerReport {

	private RadioGroup _rgSaidaRelatorio;
	private static final String VALUE_1 = "1"; // Pdf
	private static final String VALUE_2 = "2"; // Excel
	private TextEdit _edtAno;
	private Text _txtEmpresa;
	private Text _txtBranco;

	@Override
	protected void setupReportFilter() {

		this.setReportInnerLayout(this.createFilterLayout());

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub

		return "Imprime Gráfico Faturamento Mensal";

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

	}

	private PeWidget<?> createFilterLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, new DataStore(), true);
		{
			detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
			detail.setCaptionTop(true);
			detail.setHeight(150);
			detail.setWidth(350);
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
		int year = cal.get(Calendar.YEAR);
		_edtAno = new TextEdit("ano", this);
		_edtAno.setValue(year + "");

		_rgSaidaRelatorio = new RadioGroup("Radio_Sexo", this);
		_rgSaidaRelatorio.setCaption("Tipo Saída");
		_rgSaidaRelatorio.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgSaidaRelatorio.addOption(VALUE_1, "PDF");
		_rgSaidaRelatorio.addOption(VALUE_2, "Excel");
		_rgSaidaRelatorio.setSelectedIndex(0);

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1 });
		{

			detail.addField("Empresa: ", _txtEmpresa);
		}
		detail.addTable(new int[] { 3, 6 });
		{
			detail.addField("Ano", _edtAno);

			detail.addField("Tipo Saída: ", _rgSaidaRelatorio);

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
			report.generateReport("RelGraficoFaturamento", params, this.getSQL(_edtAno.getValue()));
		} else {
			report.generateXLS("RelGraficoFaturamento", params, this.getSQL(_edtAno.getValue()));

		}
	}

	private String getSQL(String ano) {

		StringBuffer SqlReport = new StringBuffer();

		SqlReport.append("SELECT ");
		SqlReport.append("en_faturamento_mensal.cd_empresa, ");
		SqlReport.append("en_faturamento_mensal.nu_mes, ");
		SqlReport.append("en_faturamento_mensal.nu_ano, ");
		SqlReport.append("en_faturamento_mensal.vl_faturamento, ");
		SqlReport.append("en_faturamento_mensal.vl_despesas, ");
		SqlReport.append("en_empresa.nm_empresa, ");
		SqlReport.append("en_mes.nm_mes,en_mes.sg_mes, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao ");
		SqlReport.append("FROM ");
		SqlReport.append("en_faturamento_mensal ");
		SqlReport.append("INNER JOIN en_empresa ON en_empresa.cd_empresa = en_faturamento_mensal.cd_empresa ");
		SqlReport.append("INNER JOIN en_mes ON en_mes.nu_mes = en_faturamento_mensal.nu_mes ");
		SqlReport.append("cross join ");
		SqlReport.append("en_parametro ");
		SqlReport.append("where  en_faturamento_mensal.nu_ano = " + ano + " and ");
		SqlReport.append("en_faturamento_mensal.cd_empresa = "
				+ (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA"));
		SqlReport.append("order by en_faturamento_mensal.nu_mes ");

		 
		
		try {
			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}

}
