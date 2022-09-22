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

public class RelFaturamentoAnualController extends BaseControllerReport {

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

		return "Imprime  Faturamento Anual";

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
		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		

		StaticReportManager report = new StaticReportManager();
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("SUBREPORT_DIR", Utils.getReportPath());
		params.put("IMAGE_DIRECTORY", Utils.getImagePath());
		if (_rgSaidaRelatorio.getValue().equals("1")) {
			report.generateReport("RelFaturamentoAnual", params,this.getSQL(empresa));
		} else {
			report.generateXLS("RelFaturamentoAnual", params,this.getSQL(empresa));

		}
	}

	 
	private String getSQL(String empresa) {

		StringBuffer SqlReport = new StringBuffer();

		SqlReport.append("select ");
		SqlReport.append("en_faturamento_anual.nu_ano, ");
		SqlReport.append("en_faturamento_anual.cd_empresa, ");
		SqlReport.append("en_faturamento_anual.id_usuario_cad, ");
		SqlReport.append("en_faturamento_anual.id_usuario_alt, ");
		SqlReport.append("en_faturamento_anual.dt_cadastro, ");
		SqlReport.append("en_faturamento_anual.dt_alteracao, ");
		SqlReport.append("en_faturamento_anual.vl_jan_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_jan_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_fev_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_fev_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_mar_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_mar_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_abr_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_abr_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_mai_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_mai_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_jun_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_jun_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_jul_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_jul_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_ago_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_ago_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_set_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_set_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_out_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_out_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_nov_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_nov_despesas, ");
		SqlReport.append("en_faturamento_anual.vl_dez_faturamento, ");
		SqlReport.append("en_faturamento_anual.vl_dez_despesas, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append("en_empresa.nm_empresa, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_jan_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_jan_despesas,0) as saldo_jan, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_fev_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_fev_despesas,0) as saldo_fev, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_mar_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_mar_despesas,0) as saldo_mar, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_abr_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_abr_despesas,0) as saldo_abr, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_mai_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_mai_despesas,0) as saldo_mai, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_jun_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_jun_despesas,0) as saldo_jun, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_jul_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_jul_despesas,0) as saldo_jul, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_ago_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_ago_despesas,0) as saldo_ago, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_set_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_set_despesas,0) as saldo_set, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_out_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_out_despesas,0) as saldo_out, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_nov_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_nov_despesas,0) as saldo_nov, ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_dez_faturamento,0) - ");
		SqlReport.append("coalesce(en_faturamento_anual.vl_dez_despesas,0) as saldo_dez, ");
		SqlReport.append(" ");
		SqlReport.append("(coalesce(en_faturamento_anual.vl_jan_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_fev_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_mar_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_abr_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_mai_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_jun_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_jul_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_ago_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_set_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_out_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_nov_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_dez_faturamento,0) ) as total_faturamento_anual, ");
		SqlReport.append(" ");
		SqlReport.append("(coalesce(en_faturamento_anual.vl_jan_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_fev_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_mar_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_abr_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_mai_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_jun_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_jul_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_ago_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_set_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_out_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_nov_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_dez_despesas,0) ) as total_despesas_anual, ");
		SqlReport.append(" ");
		SqlReport.append(" ");
		SqlReport.append(" ( ");
		SqlReport.append(" (coalesce(en_faturamento_anual.vl_jan_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_fev_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_mar_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_abr_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_mai_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_jun_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_jul_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_ago_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_set_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_out_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_nov_faturamento,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_dez_faturamento,0) ) - ");
		SqlReport.append(" ");
		SqlReport.append("(coalesce(en_faturamento_anual.vl_jan_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_fev_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_mar_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_abr_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_mai_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_jun_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_jul_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_ago_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_set_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_out_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_nov_despesas,0) + ");
		SqlReport.append(" coalesce(en_faturamento_anual.vl_dez_despesas,0) ) ");
		SqlReport.append(" ");
		SqlReport.append(" ");
		SqlReport.append(" ");
		SqlReport.append(" ) saldo_anual ");
		SqlReport.append(" ");
		SqlReport.append(" ");
		SqlReport.append("from ");
		SqlReport.append("en_faturamento_anual ");
		SqlReport.append("cross join en_parametro ");
		SqlReport.append("inner join en_empresa on en_empresa.cd_empresa =  ");
		SqlReport.append("en_faturamento_anual.cd_empresa ");
		 
		
		
		SqlReport.append("where en_faturamento_anual.cd_empresa = " + empresa + " ");
		
		SqlReport.append("order by en_faturamento_anual.nu_ano ");


		try {
			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}
}
