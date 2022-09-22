package performer.contabil.report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DBConnection;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.RadioGroup;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import performer.contabil.controller.BaseControllerReport;
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class RelHistoricoAnualController extends BaseControllerReport {

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

		return "Imprime  Historico Anual";

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
		Calendar cal = Calendar.getInstance();
         int year = cal.get(Calendar.YEAR);
		
		_edtAno = new TextEdit("ano",this);
		_edtAno.setValue(year+"");
		
		
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
		detail.addTable(new int[] { 1,1});
		{
			 
			detail.addField("Ano: ", _edtAno);
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

	 
		
		DBConnection dbconn = null;
		PeFacesApplication app = PeFacesApplication.getInstance();
		try {
			dbconn = DBConnection.getConnection(app.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		conn = dbconn.getJDBCConnection();

		params.put("SUBREPORT_DIR", Utils.getReportPath());
		params.put("REPORT_CONNECTION", conn);
		params.put("IMAGE_DIRECTORY", Utils.getImagePath());
		
		
		
		
		
		if (_rgSaidaRelatorio.getValue().equals("1")) {
			report.generateReport("RelHistoricoAnual", params,this.getSQL(empresa));
		} else {
			report.generateXLS("RelHistoricoAnual", params,this.getSQL(empresa));

		}
	}

	 
	private String getSQL(String empresa) {

		StringBuffer SqlReport = new StringBuffer();

		SqlReport.append("select ");
		SqlReport.append("consulta.nu_ano, ");
		SqlReport.append("consulta.cd_empresa, ");
		SqlReport.append("consulta.nm_empresa_instalacao, ");
		SqlReport.append("consulta.fones_empresa_instalacao, ");
		SqlReport.append("consulta.de_email_empresa_instalacao, ");
		SqlReport.append("consulta.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("consulta.de_endereco_empresa_instalacao, ");
		SqlReport.append("consulta.nm_empresa, ");
		SqlReport.append("consulta.nm_tipo_lancamento, ");
		SqlReport.append("consulta.saldo_jan, ");
		SqlReport.append("consulta.vl_jan_rel, ");
		SqlReport.append("consulta.saldo_fev, ");
		SqlReport.append("consulta.vl_fev_rel, ");
		SqlReport.append("consulta.saldo_mar, ");
		SqlReport.append("consulta.vl_mar_rel, ");
		SqlReport.append("consulta.saldo_abr, ");
		SqlReport.append("consulta.vl_abr_rel, ");
		SqlReport.append("consulta.saldo_mai, ");
		SqlReport.append("consulta.vl_mai_rel, ");
		SqlReport.append("consulta.saldo_jun, ");
		SqlReport.append("consulta.vl_jun_rel, ");
		SqlReport.append("consulta.saldo_jul, ");
		SqlReport.append("consulta.vl_jul_rel, ");
		SqlReport.append("consulta.saldo_ago, ");
		SqlReport.append("consulta.vl_ago_rel, ");
		SqlReport.append("consulta.saldo_set, ");
		SqlReport.append("consulta.vl_set_rel, ");
		SqlReport.append("consulta.saldo_out, ");
		SqlReport.append("consulta.vl_out_rel, ");
		SqlReport.append("consulta.saldo_nov, ");
		SqlReport.append("consulta.vl_nov_rel, ");
		SqlReport.append("consulta.saldo_dez, ");
		SqlReport.append("consulta.vl_dez_rel, ");
		SqlReport.append("( ");
		SqlReport.append(" consulta.saldo_jan + ");
		SqlReport.append(" consulta.saldo_fev + ");
		SqlReport.append(" consulta.saldo_mar + ");
		SqlReport.append(" consulta.saldo_abr + ");
		SqlReport.append(" consulta.saldo_mai + ");
		SqlReport.append(" consulta.saldo_jun + ");
		SqlReport.append(" consulta.saldo_jul + ");
		SqlReport.append(" consulta.saldo_ago + ");
		SqlReport.append(" consulta.saldo_set + ");
		SqlReport.append(" consulta.saldo_out + ");
		SqlReport.append(" consulta.saldo_nov + ");
		SqlReport.append(" consulta.saldo_dez ");
		SqlReport.append(" ");
		SqlReport.append(") as saldo_anual , ");
		SqlReport.append("( ");
		SqlReport.append(" consulta.vl_jan_rel + ");
		SqlReport.append(" consulta.vl_fev_rel + ");
		SqlReport.append(" consulta.vl_mar_rel + ");
		SqlReport.append(" consulta.vl_abr_rel + ");
		SqlReport.append(" consulta.vl_mai_rel + ");
		SqlReport.append(" consulta.vl_jun_rel + ");
		SqlReport.append(" consulta.vl_jul_rel + ");
		SqlReport.append(" consulta.vl_ago_rel + ");
		SqlReport.append(" consulta.vl_set_rel + ");
		SqlReport.append(" consulta.vl_out_rel + ");
		SqlReport.append(" consulta.vl_nov_rel + ");
		SqlReport.append(" consulta.vl_dez_rel ");
		SqlReport.append(" ");
		SqlReport.append(") as saldo_anual_rel ");
		SqlReport.append("from ( ");
		SqlReport.append(" ");
		SqlReport.append(" ");
		SqlReport.append("select ");
		SqlReport.append("en_historico_anual.nu_ano, ");
		SqlReport.append("en_historico_anual.cd_empresa, ");
		SqlReport.append("coalesce(en_historico_anual.vl_jan_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_jan_debito) as saldo_jan, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_jan_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_jan_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_jan_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_jan_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_jan_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_jan_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_jan_credito - ");
		SqlReport.append("en_historico_anual.vl_jan_debito ");
		SqlReport.append("end as vl_jan_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_fev_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_fev_debito) as saldo_fev, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_fev_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_fev_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_fev_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_fev_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_fev_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_fev_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_fev_credito - ");
		SqlReport.append("en_historico_anual.vl_fev_debito ");
		SqlReport.append("end as vl_fev_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_mar_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_mar_debito) as saldo_mar, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_mar_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_mar_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_mar_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_mar_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_mar_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_mar_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_mar_credito - ");
		SqlReport.append("en_historico_anual.vl_mar_debito ");
		SqlReport.append("end as vl_mar_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_abr_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_abr_debito) as saldo_abr, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_abr_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_abr_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_abr_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_abr_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_abr_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_abr_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_abr_credito - ");
		SqlReport.append("en_historico_anual.vl_abr_debito ");
		SqlReport.append("end as vl_abr_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_mai_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_mai_debito) as saldo_mai, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_mai_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_mai_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_mai_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_mai_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_mai_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_mai_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_mai_credito - ");
		SqlReport.append("en_historico_anual.vl_mai_debito ");
		SqlReport.append("end as vl_mai_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_jun_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_jun_debito) as saldo_jun, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_jun_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_jun_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_jun_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_jun_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_jun_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_jun_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_jun_credito - ");
		SqlReport.append("en_historico_anual.vl_jun_debito ");
		SqlReport.append("end as vl_jun_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_jul_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_jul_debito) as saldo_jul, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_jul_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_jul_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_jul_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_jul_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_jul_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_jul_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_jul_credito - ");
		SqlReport.append("en_historico_anual.vl_jul_debito ");
		SqlReport.append("end as vl_jul_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_ago_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_ago_debito) as saldo_ago, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_ago_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_ago_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_ago_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_ago_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_ago_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_ago_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_ago_credito - ");
		SqlReport.append("en_historico_anual.vl_ago_debito ");
		SqlReport.append("end as vl_ago_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_set_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_set_debito) as saldo_set, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_set_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_set_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_set_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_set_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_set_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_set_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_set_credito - ");
		SqlReport.append("en_historico_anual.vl_set_debito ");
		SqlReport.append("end as vl_set_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_out_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_out_debito) as saldo_out, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_out_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_out_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_out_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_out_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_out_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_out_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_out_credito - ");
		SqlReport.append("en_historico_anual.vl_out_debito ");
		SqlReport.append("end as vl_out_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_nov_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_nov_debito) as saldo_nov, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_nov_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_nov_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_nov_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_nov_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_nov_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_nov_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_nov_credito - ");
		SqlReport.append("en_historico_anual.vl_nov_debito ");
		SqlReport.append("end as vl_nov_rel, ");
		SqlReport.append("coalesce(en_historico_anual.vl_dez_credito)  -  coalesce ");
		SqlReport.append("(en_historico_anual.vl_dez_debito) as saldo_dez, ");
		SqlReport.append("case when   (coalesce(en_historico_anual.vl_dez_credito)  > 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_dez_debito)  = 0) then ");
		SqlReport.append("en_historico_anual.vl_dez_credito ");
		SqlReport.append("when   (coalesce(en_historico_anual.vl_dez_credito)  = 0 and coalesce ");
		SqlReport.append("(en_historico_anual.vl_dez_debito)  > 0)  then ");
		SqlReport.append("en_historico_anual.vl_dez_debito ");
		SqlReport.append("else ");
		SqlReport.append("en_historico_anual.vl_dez_credito - ");
		SqlReport.append("en_historico_anual.vl_dez_debito ");
		SqlReport.append("end as vl_dez_rel, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append("en_empresa.nm_empresa, ");
		SqlReport.append("en_tipo_lancamento.nm_tipo_lancamento ");
		SqlReport.append("from ");
		SqlReport.append("en_historico_anual ");
		SqlReport.append("cross join en_parametro ");
		SqlReport.append("inner join en_empresa on en_empresa.cd_empresa =  ");
		SqlReport.append("en_historico_anual.cd_empresa ");
		SqlReport.append("inner join en_tipo_lancamento on en_tipo_lancamento.cd_tipo_lancamento =  ");
		SqlReport.append("en_historico_anual.cd_tipo_lancamento ");
		SqlReport.append("where ");
		SqlReport.append("en_historico_anual.nu_ano = " + _edtAno.getValue() + " and ");
		SqlReport.append("en_historico_anual.cd_empresa = " + empresa + "  ");
		SqlReport.append(") consulta ");
		SqlReport.append("order by consulta.nm_tipo_lancamento ");


		try {
			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}
}
