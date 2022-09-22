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

public class RelGraficoSaldoAnualController extends BaseControllerReport {

	private RadioGroup _rgSaidaRelatorio;
	private static final String VALUE_1 = "1"; // Pdf
	private static final String VALUE_2 = "2"; // Excel
	 
	private Text _txtEmpresa;
	private Text _txtBranco;

	@Override
	protected void setupReportFilter() {

		this.setReportInnerLayout(this.createFilterLayout());

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub

		return "Imprime Gráfico Saldo Anual";

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
		detail.addTable(new int[] { 1 });
		{
			 

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
			report.generateReport("RelGraficoSaldoAnual", params, this.getSQLSaldoAnual( ));
			report.generateReport("RelGraficoSaldoAnualTipo", params, this.getSQLSaldoAnualTipo( ));
		} else {
			report.generateXLS("RelGraficoSaldoAnual", params, this.getSQLSaldoAnual( ));
			report.generateXLS("RelGraficoSaldoAnualTipo", params, this.getSQLSaldoAnualTipo( ));
		}
	}

	private String getSQLSaldoAnual( ) {

		StringBuffer SqlReport = new StringBuffer();

		
		
		SqlReport.append("SELECT NU_ANO, en_empresa.nm_empresa, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append("(SUM(vl_jan_credito) + SUM(vl_fev_credito) + SUM(vl_mar_credito) +  ");
		SqlReport.append("SUM(vl_abr_credito) + SUM(vl_mai_credito) + SUM(vl_jun_credito) + ");
		SqlReport.append("SUM(vl_jul_credito) + SUM(vl_ago_credito) + SUM(vl_set_credito) + ");
		SqlReport.append("SUM(vl_out_credito) + SUM(vl_nov_credito) + SUM(vl_dez_credito)) - ");
		SqlReport.append("(SUM(vl_jan_debito) + SUM(vl_fev_debito) + SUM(vl_mar_debito) +  ");
		SqlReport.append("SUM(vl_abr_debito) + SUM(vl_mai_debito) + SUM(vl_jun_debito) + ");
		SqlReport.append("SUM(vl_jul_debito) + SUM(vl_ago_debito) + SUM(vl_set_debito) + ");
		SqlReport.append("SUM(vl_out_debito) + SUM(vl_nov_debito) + SUM(vl_dez_debito)) ");
		SqlReport.append(" ");
		SqlReport.append(" ");
		SqlReport.append("as saldo_anual ");
		SqlReport.append("from en_historico_anual cross join ");
		SqlReport.append("en_parametro ");
		SqlReport.append("inner join en_empresa on en_empresa.cd_empresa = en_historico_anual.cd_empresa ");
		SqlReport.append("where en_historico_anual.cd_empresa =    " +  (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA") + " ");
		SqlReport.append("group by NU_ANO ,en_empresa.nm_empresa, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao ");
		SqlReport.append("order  by nu_ano ");
		
		
			 

		try {
			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}
	
	private String getSQLSaldoAnualTipo( ) {

		StringBuffer SqlReport = new StringBuffer();

		
		
		SqlReport.append("SELECT ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append("vw_historico_anual.nu_ano, ");
		SqlReport.append("vw_historico_anual.nm_tipo_lancamento, ");
		SqlReport.append("vw_historico_anual.saldo_anual, ");
		SqlReport.append(" ");
		SqlReport.append("vw_historico_anual.cd_empresa, ");
		SqlReport.append("en_empresa.nm_empresa ");
		SqlReport.append("FROM ");
		SqlReport.append("vw_historico_anual cross join en_parametro ");
		SqlReport.append("inner join en_empresa on en_empresa.cd_empresa =  vw_historico_anual.cd_empresa ");
		SqlReport.append("WHERE ");
		SqlReport.append("vw_historico_anual.cd_empresa = " +  (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA") +  " ");
		SqlReport.append("ORDER BY ");
		SqlReport.append("vw_historico_anual.nm_tipo_lancamento, ");
		SqlReport.append("vw_historico_anual.nu_ano ");

		
			 

		try {
			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}

}
