
package performer.contabil.report;

import java.sql.SQLException;
import java.text.Normalizer;
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
import framework.web.gui.widget.TextEdit;
import performer.contabil.controller.BaseControllerReport;
import performer.contabil.persistence.DSEmpresa;
import performer.contabil.persistence.DSHistoricoLancamento;
import performer.contabil.persistence.DSTipoLancamento;
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class RelLancamentosAtivosPassivosController extends BaseControllerReport {

	private DSTipoLancamento _DSTipoLancamentoPesquisa;
	private DSHistoricoLancamento _DSHistoricoLancamentoPesquisa1;
	private DSHistoricoLancamento _DSHistoricoLancamentoPesquisa2;
	private DSEmpresa _DSEmpresaPesquisa;
	private RadioGroup _rgSaidaRelatorio;
	private static final String VALUE_1 = "1"; // Pdf
	private static final String VALUE_2 = "2"; // Excel
	private DateEdit _edtDataInicio;
	private DateEdit _edtDataFim;
	private Text _txtEmpresa;
	private Text _txtBranco;
	private ComboBoxLookup _cbxTipoLancamentoPesquisa;
	private ComboBoxLookup _cbxHistoricoPesquisa1;
	private ComboBoxLookup _cbxHistoricoPesquisa2;
	private TextEdit _edtHistoricoPalavraPesquisa;
	private ComboBoxLookup _cbxEmpresaPesquisa;
	private CheckBox _ckbAgruparTipo;

	@Override
	protected void setupReportFilter() {

		this.setReportInnerLayout(this.createFilterLayout());

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub

		return "Lançamento Ativos x Passivos";

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSTipoLancamentoPesquisa = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamentoPesquisa
				.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada);

		_DSHistoricoLancamentoPesquisa1 = new DSHistoricoLancamento(this.getApplicationName());
		_DSHistoricoLancamentoPesquisa1.retrieve(DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_EMPRESA + " = "
				+ empresa_selecionada + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_FG_ATIVO + " = 'S'");

		
		_DSHistoricoLancamentoPesquisa2 = new DSHistoricoLancamento(this.getApplicationName());
		_DSHistoricoLancamentoPesquisa2.retrieve(DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_EMPRESA + " = "
				+ empresa_selecionada + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_FG_ATIVO + " = 'S'");

		
				
		
		
		_DSEmpresaPesquisa = new DSEmpresa(this.getApplicationName());
		_DSEmpresaPesquisa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa_selecionada);

	}

	private PeWidget<?> createFilterLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, new DataStore(), true);
		{
			detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
			detail.setCaptionTop(true);
			detail.setHeight(380);
			detail.setWidth(350);
		}

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		_ckbAgruparTipo = new CheckBox("ckTipo", this, "Agrupar por Tipo de Lançamento ", "1", "0");

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

		_rgSaidaRelatorio = new RadioGroup("Radio_Sexo", this);
		_rgSaidaRelatorio.setCaption("Tipo Saída");
		_rgSaidaRelatorio.setCaptionLayout(RadioGroup.CAPTIONS_ON_RIGHT);
		_rgSaidaRelatorio.addOption(VALUE_1, "PDF");
		_rgSaidaRelatorio.addOption(VALUE_2, "Excel");
		_rgSaidaRelatorio.setSelectedIndex(0);

		_cbxEmpresaPesquisa = new ComboBoxLookup("emp", this);
		_cbxEmpresaPesquisa.setLookupInfo(_DSEmpresaPesquisa, DSEmpresa.EN_EMPRESA_CD_EMPRESA,
				DSEmpresa.EN_EMPRESA_DE_SIGLA);
		_cbxEmpresaPesquisa.setValue((String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA"));
		_cbxEmpresaPesquisa.setEnable(false);

		_cbxTipoLancamentoPesquisa = new ComboBoxLookup("tp", this);
		_cbxTipoLancamentoPesquisa.setLookupInfo(_DSTipoLancamentoPesquisa,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);

		_cbxHistoricoPesquisa1 = new ComboBoxLookup("hp", this);
		_cbxHistoricoPesquisa1.setLookupInfo(_DSHistoricoLancamentoPesquisa1,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);

		
		
		
		_cbxHistoricoPesquisa2 = new ComboBoxLookup("hp", this);
		_cbxHistoricoPesquisa2.setLookupInfo(_DSHistoricoLancamentoPesquisa2,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);

		
		_edtHistoricoPalavraPesquisa = new TextEdit("palavra",this);
		
	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1 });
		{

			detail.addField("Empresa: ", _cbxEmpresaPesquisa);
			detail.addField("Histórico1: ", _cbxHistoricoPesquisa1);
			detail.addField("Histórico2: ", _cbxHistoricoPesquisa2);
			detail.addField("Histórico com a Palavra: ", _edtHistoricoPalavraPesquisa);
			detail.addField("Tipo Histórico: ", _cbxTipoLancamentoPesquisa);
		}
		detail.addTable(new int[] { 1, 1 });
		{
			detail.addField("Data Início", _edtDataInicio);
			detail.addField("Data Fim", _edtDataFim);

		}
		detail.addTable(new int[] { 2, 1 });
		{

			detail.addField("Tipo Saída: ", _rgSaidaRelatorio);
			detail.addField(" ", _ckbAgruparTipo);
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

		if (_ckbAgruparTipo.getValue() != null && _ckbAgruparTipo.getValue() == true) {
			
			if (_rgSaidaRelatorio.getValue().equals("1")) {
				report.generateReport("RelLancamentosAtivosPassivosPorTipo", params, this.getSQLAgrupado());
			} else {
				params.put("IS_IGNORE_PAGINATION", true);
				report.generateXLS("RelLancamentosAtivosPassivosPorTipoXLS", params, this.getSQLAgrupado());

			}

		} else {

			if (_rgSaidaRelatorio.getValue().equals("1")) {
				report.generateReport("RelLancamentosAtivosPassivos", params, this.getSQL());
			} else {
				params.put("IS_IGNORE_PAGINATION", true);
				report.generateXLS("RelLancamentosAtivosPassivosXLS", params, this.getSQL());

			}
		}
	}

	private String getSQL() {

		StringBuffer SqlReport = new StringBuffer();

		String strdataInicioUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataInicio.getValue());
		String strdataFimUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataFim.getValue());

		SqlReport.append("SELECT ");
		SqlReport.append("to_char(en_ativo_passivo.dt_historico,'dd/MM/yyyy') as dt_historico, ");
		SqlReport.append("en_historico_lancamento.nm_historico_lancamento, ");
		SqlReport.append("en_empresa.nm_empresa, ");
		SqlReport.append("en_tipo_lancamento.nm_tipo_lancamento, ");
		SqlReport.append("coalesce(en_ativo_passivo.vl_debito,0) AS debi, ");
		SqlReport.append("coalesce(en_ativo_passivo.vl_credito,0) AS cred, ");
		SqlReport.append("CASE en_ativo_passivo.vl_debito ");
		SqlReport.append("WHEN 0 THEN NULL ");
		SqlReport.append("ELSE en_ativo_passivo.vl_debito END AS  vl_debito, ");
		SqlReport.append(" ");
		SqlReport.append("CASE en_ativo_passivo.vl_credito ");
		SqlReport.append("WHEN 0 THEN NULL ");
		SqlReport.append("ELSE en_ativo_passivo.vl_credito END AS  vl_credito, ");
		SqlReport.append(" ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao ");
		SqlReport.append("FROM ");
		SqlReport.append("en_ativo_passivo ");
		SqlReport.append("INNER JOIN en_historico_lancamento ON  ");
		SqlReport.append("(en_ativo_passivo.cd_historico_lancamento =  ");
		SqlReport.append("en_historico_lancamento.cd_historico_lancamento) ");
		SqlReport.append("INNER JOIN en_empresa ON (en_ativo_passivo.cd_empresa =  ");
		SqlReport.append("en_empresa.cd_empresa) ");
		SqlReport.append("INNER JOIN en_tipo_lancamento ON (en_ativo_passivo.cd_empresa =  ");
		SqlReport.append("en_tipo_lancamento.cd_empresa AND  ");
		SqlReport.append("en_historico_lancamento.cd_tipo_lancamento =  ");
		SqlReport.append("en_tipo_lancamento.cd_tipo_lancamento) ");
		SqlReport.append(" ");
		SqlReport.append("cross join en_parametro ");
		SqlReport.append("WHERE ");

		SqlReport.append(
				"  (en_ativo_passivo.dt_historico between  '" + strdataInicioUS + " 00:00:00' and  '" + strdataFimUS + " 23:59:59') ");
		SqlReport.append("and en_ativo_passivo.fg_excluido IS NULL  ");
		SqlReport.append("and en_ativo_passivo.cd_empresa =  " + (String) _cbxEmpresaPesquisa.getValue());

		
		String h1 = (String) _cbxHistoricoPesquisa1.getValue();
		String h2 = (String) _cbxHistoricoPesquisa2.getValue();
		
		if (h1 != null && h2 == null) {
			SqlReport.append("and en_ativo_passivo.cd_historico_lancamento = "
					+ h1 + " ");
		}
		
		if (h1 != null && h2 != null) {
			SqlReport.append("and (en_ativo_passivo.cd_historico_lancamento = "	+ h1 + "  or " +
		       " en_ativo_passivo.cd_historico_lancamento = "	+ h2 + ") ");
		}
		
		
		
		if ((String) _cbxTipoLancamentoPesquisa.getValue() != null) {
			SqlReport.append("and en_historico_lancamento.cd_tipo_lancamento = "
					+ (String) _cbxTipoLancamentoPesquisa.getValue() + " ");
		}
		
		 
		
		
		String palavra = _edtHistoricoPalavraPesquisa.getValue();
		if (palavra != null) {
			palavra = palavra.toLowerCase();
			palavra = Normalizer.normalize(palavra, Normalizer.Form.NFD);
			palavra = palavra.replaceAll("[^\\p{ASCII}]", "");
		 
			SqlReport.append(" and (lower(sem_acento(en_historico_lancamento.nm_historico_lancamento"
					+ ")) like   '%"	+ palavra.toLowerCase() + "%')");
		}


		
		
		
		
		
		

		SqlReport.append("ORDER BY ");
		SqlReport.append("en_ativo_passivo.dt_historico ");

 
		try {

			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}
	
	private String getSQLAgrupado() {

		StringBuffer SqlReport = new StringBuffer();

		String strdataInicioUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataInicio.getValue());
		String strdataFimUS = new SimpleDateFormat("yyyy/MM/dd").format(_edtDataFim.getValue());

		SqlReport.append("SELECT ");
		SqlReport.append("en_empresa.nm_empresa, ");
		SqlReport.append("en_tipo_lancamento.nm_tipo_lancamento, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append("sum(coalesce(en_ativo_passivo.vl_debito,0)) AS debi, ");
		SqlReport.append("sum(coalesce(en_ativo_passivo.vl_credito,0)) AS cred, ");
		SqlReport.append("sum( ");
		SqlReport.append("CASE en_ativo_passivo.vl_debito ");
		SqlReport.append("WHEN 0 THEN NULL ");
		SqlReport.append("ELSE en_ativo_passivo.vl_debito END) AS  vl_debito, ");
		SqlReport.append(" ");
		SqlReport.append("sum(CASE en_ativo_passivo.vl_credito ");
		SqlReport.append("WHEN 0 THEN NULL ");
		SqlReport.append("ELSE en_ativo_passivo.vl_credito END) AS  vl_credito ");
		SqlReport.append(" ");
		SqlReport.append("FROM ");
		SqlReport.append("en_ativo_passivo ");
		SqlReport.append("INNER JOIN en_historico_lancamento ON  ");
		SqlReport.append("(en_ativo_passivo.cd_historico_lancamento =  ");
		SqlReport.append("en_historico_lancamento.cd_historico_lancamento) ");
		SqlReport.append("INNER JOIN en_empresa ON (en_ativo_passivo.cd_empresa =  ");
		SqlReport.append("en_empresa.cd_empresa) ");
		SqlReport.append("INNER JOIN en_tipo_lancamento ON (en_ativo_passivo.cd_empresa =  ");
		SqlReport.append("en_tipo_lancamento.cd_empresa AND  ");
		SqlReport.append("en_historico_lancamento.cd_tipo_lancamento =  ");
		SqlReport.append("en_tipo_lancamento.cd_tipo_lancamento) ");
		SqlReport.append(" ");
		SqlReport.append("cross join en_parametro ");
		SqlReport.append("WHERE ");
	 
		

		SqlReport.append(
				"  (en_ativo_passivo.dt_historico between  '" + strdataInicioUS + "' and  '" + strdataFimUS + "') ");
		SqlReport.append("and en_ativo_passivo.fg_excluido IS NULL  ");
		SqlReport.append("and en_ativo_passivo.cd_empresa =  " + (String) _cbxEmpresaPesquisa.getValue());

		String h1 = (String) _cbxHistoricoPesquisa1.getValue();
		String h2 = (String) _cbxHistoricoPesquisa2.getValue();
		
		if (h1 != null && h2 == null) {
			SqlReport.append("and en_ativo_passivo.cd_historico_lancamento = "
					+ h1 + " ");
		}
		
		if (h1 != null && h2 != null) {
			SqlReport.append("and (en_ativo_passivo.cd_historico_lancamento = "	+ h1 + "  or " +
		       " en_ativo_passivo.cd_historico_lancamento = "	+ h2 + ") ");
		}
		
		
		
		
		if ((String) _cbxTipoLancamentoPesquisa.getValue() != null) {
			SqlReport.append("and en_historico_lancamento.cd_tipo_lancamento = "
					+ (String) _cbxTipoLancamentoPesquisa.getValue() + " ");
		}

		SqlReport.append("GROUP BY en_empresa.nm_empresa, ");
		SqlReport.append("en_tipo_lancamento.nm_tipo_lancamento, ");
		SqlReport.append("en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("en_parametro.de_endereco_empresa_instalacao ");
		SqlReport.append(" ");
		SqlReport.append("ORDER BY ");
		SqlReport.append("en_tipo_lancamento.nm_tipo_lancamento ");

		 
		try {

			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}

}
