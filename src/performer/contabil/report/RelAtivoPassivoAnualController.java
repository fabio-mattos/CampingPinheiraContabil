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
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.RadioGroup;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import performer.contabil.controller.BaseControllerReport;
import performer.contabil.persistence.DSVwAno;
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class RelAtivoPassivoAnualController extends BaseControllerReport {

	private RadioGroup _rgSaidaRelatorio;
	private static final String VALUE_1 = "1"; // Pdf
	private static final String VALUE_2 = "2"; // Excel
	private DSVwAno _DSVwAno;
	private ComboBoxLookup _cbxAno;

	private Text _txtEmpresa;
	private Text _txtBranco;

	@Override
	protected void setupReportFilter() {

		this.setReportInnerLayout(this.createFilterLayout());

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub

		return "Imprime  Historico Ativo x Passivo Anual";

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {
		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		_DSVwAno = new DSVwAno(this.getApplicationName());
		_DSVwAno.retrieve(DSVwAno.VW_ANO_CD_EMPRESA + " = " + empresa_selecionada);
	}

	private PeWidget<?> createFilterLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, new DataStore(), true);
		{
			detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
			detail.setCaptionTop(true);
			detail.setHeight("150");
			detail.setWidth(350);
		}

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		_cbxAno = new ComboBoxLookup("ano", this);
		_cbxAno.setLookupInfo(_DSVwAno, DSVwAno.VW_ANO_NU_ANO, DSVwAno.VW_ANO_NU_ANO);
		_cbxAno.setValue(year + "");

		
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
		detail.addTable(new int[] { 1, 1 });
		{

			detail.addField("Ano: ", _cbxAno);
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
			report.generateReport("RelAtivoPassivoAnual", params, this.getSQL(empresa, (String) _cbxAno.getValue()));
		} else {
			report.generateXLS("RelAtivoPassivoAnualXLS", params, this.getSQL(empresa, (String) _cbxAno.getValue()));

		}
	}

	private String getSQL(String strEmpresa, String strAno) {

		StringBuffer SqlReport = new StringBuffer();

		SqlReport.append("select ");
		SqlReport.append("" + strAno + " as nu_ano, ");
		SqlReport.append("consulta.cd_tipo_lancamento, ");
		SqlReport.append("consulta.nm_tipo_lancamento, ");
		SqlReport.append("consulta.saldo_jan, ");
		SqlReport.append("consulta.saldo_fev, ");
		SqlReport.append("consulta.saldo_mar, ");
		SqlReport.append("consulta.saldo_abr, ");
		SqlReport.append("consulta.saldo_mai, ");
		SqlReport.append("consulta.saldo_jun, ");
		SqlReport.append("consulta.saldo_jul, ");
		SqlReport.append("consulta.saldo_ago, ");
		SqlReport.append("consulta.saldo_set, ");
		SqlReport.append("consulta.saldo_out, ");
		SqlReport.append("consulta.saldo_nov, ");
		SqlReport.append("consulta.saldo_dez, ");
		SqlReport.append("abs( ");
		SqlReport.append("(coalesce(consulta.saldo_jan,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_fev,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_mar,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_abr,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_mai,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_jun,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_jul,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_ago,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_set,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_out,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_nov,0)+ ");
		SqlReport.append("coalesce(consulta.saldo_dez,0))) as saldo_anual, ");
		SqlReport.append(" ");
		SqlReport.append(" ");
		SqlReport.append("abs(consulta.saldo_jan) saldo_jan_rel, ");
		SqlReport.append("abs(consulta.saldo_fev) saldo_fev_rel , ");
		SqlReport.append("abs(consulta.saldo_mar) saldo_mar_rel, ");
		SqlReport.append("abs(consulta.saldo_abr) saldo_abr_rel, ");
		SqlReport.append("abs(consulta.saldo_mai) saldo_mai_rel, ");
		SqlReport.append("abs(consulta.saldo_jun) saldo_jun_rel, ");
		SqlReport.append("abs(consulta.saldo_jul) saldo_jul_rel, ");
		SqlReport.append("abs(consulta.saldo_ago) saldo_ago_rel, ");
		SqlReport.append("abs(consulta.saldo_set) saldo_set_rel, ");
		SqlReport.append("abs(consulta.saldo_out) saldo_out_rel, ");
		SqlReport.append("abs(consulta.saldo_nov) saldo_nov_rel, ");
		SqlReport.append("abs(consulta.saldo_dez) saldo_dez_rel, ");
		SqlReport.append("consulta.nm_empresa_instalacao, ");
		SqlReport.append("consulta.fones_empresa_instalacao, ");
		SqlReport.append("consulta.de_email_empresa_instalacao, ");
		SqlReport.append("consulta.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("consulta.de_endereco_empresa_instalacao, ");
		SqlReport.append("consulta.nm_empresa ");
		SqlReport.append("from ( ");
		SqlReport.append("SELECT ");
		SqlReport.append("DISTINCT ");
		SqlReport.append("en_tipo_lancamento.cd_tipo_lancamento, ");
		SqlReport.append("en_tipo_lancamento.nm_tipo_lancamento, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",1,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_jan, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",2,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_fev, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",3,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_mar, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",4,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_abr, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",5,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_mai, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",6,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_jun, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",7,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_jul, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",8,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_ago, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",9,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_set, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",10,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_out, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",11,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_nov, ");
		SqlReport.append("COALESCE(saldo_do_tipo(" + strEmpresa + "," + strAno
				+ ",12,en_tipo_lancamento.cd_tipo_lancamento),0) as saldo_dez, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append("en_empresa.nm_empresa ");
		SqlReport.append("FROM ");
		SqlReport.append("en_ativo_passivo inner join en_historico_lancamento on   ");
		SqlReport.append("en_historico_lancamento.cd_historico_lancamento = en_ativo_passivo.cd_historico_lancamento ");
		SqlReport.append("INNER JOIN en_tipo_lancamento ON  en_tipo_lancamento.cd_tipo_lancamento =  ");
		SqlReport.append("en_historico_lancamento.cd_tipo_lancamento ");
		SqlReport.append("inner join en_empresa on en_empresa.cd_empresa =  ");
		SqlReport.append("en_ativo_passivo.cd_empresa ");
		SqlReport.append("cross join en_parametro ");
		SqlReport.append("WHERE ");
		SqlReport.append("Extract('Year' from dt_historico) = " + strAno + " ");
		SqlReport.append(" and en_ativo_passivo.cd_empresa = " + strEmpresa + "  ");
		SqlReport.append(" ) consulta ");
		SqlReport.append(" order by consulta.nm_tipo_lancamento ");

		try {
			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}
}
