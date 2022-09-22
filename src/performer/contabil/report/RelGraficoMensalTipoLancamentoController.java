package performer.contabil.report;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.synth.SynthStyle;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.RadioGroup;
import framework.web.gui.widget.Text;
import performer.contabil.controller.BaseControllerReport;
import performer.contabil.persistence.DSHistoricoLancamento;
import performer.contabil.persistence.DSTipoLancamento;
import performer.contabil.persistence.DSVwAno;
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class RelGraficoMensalTipoLancamentoController extends BaseControllerReport {

	private RadioGroup _rgSaidaRelatorio;
	private RadioGroup _rgValorQtdade1;
	private RadioGroup _rgValorQtdade2;
	private static final String VALUE_1 = "1"; // Pdf
	private static final String VALUE_2 = "2"; // Excel

	private Text _txtEmpresa;
	private Text _txtBranco;
	private ComboBoxLookup _cbxTipoLancamento1;
	private ComboBoxLookup _cbxTipoLancamento2;
	private DSVwAno _DSVwAno1;
	private DSVwAno _DSVwAno2;

	private ComboBoxLookup _cbxAno1;
	private ComboBoxLookup _cbxAno2;
	private DSTipoLancamento _DSTipoLancamento1;
	private DSTipoLancamento _DSTipoLancamento2;

	@Override
	protected void setupReportFilter() {

		this.setReportInnerLayout(this.createFilterLayout());

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub

		return "Imprime Gráfico Mensal Por Tipo de Lançamento";

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {
		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSTipoLancamento1 = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamento1
				.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada);

		_DSTipoLancamento2 = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamento2
				.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada);

		_DSVwAno1 = new DSVwAno(this.getApplicationName());
		_DSVwAno1.retrieve(DSVwAno.VW_ANO_CD_EMPRESA + " = " + empresa_selecionada);

		_DSVwAno2 = new DSVwAno(this.getApplicationName());
		_DSVwAno2.retrieve(DSVwAno.VW_ANO_CD_EMPRESA + " = " + empresa_selecionada);

	}

	private PeWidget<?> createFilterLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, new DataStore(), true);
		{
			detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
			detail.setCaptionTop(true);
			detail.setHeight(300);
			detail.setWidth(550);
		}

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		_cbxTipoLancamento1  = new ComboBoxLookup("tp1", this);
		_cbxTipoLancamento1.setLookupInfo(_DSTipoLancamento1,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);

		_cbxTipoLancamento2   = new ComboBoxLookup("tp2", this);
		_cbxTipoLancamento2.setLookupInfo(_DSTipoLancamento2,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);

		_txtBranco = new Text("", this);

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("NOME_EMPRESA_SELECIONADA");
		_txtEmpresa = new Text(empresa, this);
		_txtEmpresa.setCustomStyle("color: blue;");

		_cbxAno1 = new ComboBoxLookup("ai1", this);
		_cbxAno1.setLookupInfo(_DSVwAno1, DSVwAno.VW_ANO_NU_ANO, DSVwAno.VW_ANO_NU_ANO);

		_cbxAno2 = new ComboBoxLookup("ai2", this);
		_cbxAno2.setLookupInfo(_DSVwAno2, DSVwAno.VW_ANO_NU_ANO, DSVwAno.VW_ANO_NU_ANO);

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
		detail.addTable(new int[] { 1, 4, 4, });
		{
			detail.addField("Ano1 ", _cbxAno1);
			detail.addField("Tipo Lançamento1 ", _cbxTipoLancamento1);
			detail.addField(".", _rgValorQtdade1);
		}
		detail.addTable(new int[] { 1, 4, 4, });
		{
			detail.addField("Ano1 ", _cbxAno2);
			detail.addField("Tipo Lançamento2", _cbxTipoLancamento2);
			detail.addField(". ", _rgValorQtdade2);
		}
		detail.addTable(new int[] { 1 });
		{

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

		if (_rgValorQtdade1.getValue().equals("V")) {
			params.put("QDADE_VALOR1", "Valor");
		} else {
			params.put("QDADE_VALOR1", "Quantidade");
		}

		if (_rgValorQtdade2.getValue().equals("V")) {
			params.put("QDADE_VALOR2", "Valor");
		} else {
			params.put("QDADE_VALOR2", "Quantidade");
		}

		
		if (_rgSaidaRelatorio.getValue().equals("1")) {
			report.generateReport("RelGraficoTipoLancamentoMensal", params, this.getSQL());
		} else {
			report.generateXLS("RelGraficoTipoLancamentoMensal", params, this.getSQL());

		}
	}

	private String getSQL() {

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		String quantidade_valor1 = "";
		String quantidade_valor2 = "";
		
		if (_rgValorQtdade1.getValue().equals("Q")) {
			quantidade_valor1 = "soma_quantidade_por_tipo_historico";
		} else {
			quantidade_valor1 = "soma_valor_por_tipo_historico";
		}
		if (_rgValorQtdade2.getValue().equals("Q")) {
			quantidade_valor2 = "soma_quantidade_por_tipo_historico";
		} else {
			quantidade_valor2 = "soma_valor_por_tipo_historico";
		}
		
		
		String vl_ou_qtd1 = "";
		if (_rgValorQtdade1.getValue().equals("V")) {
			vl_ou_qtd1 = "ABS(COALESCE(vl_credito,0) - COALESCE(vl_debito,0))";
		} else {
			vl_ou_qtd1 = "qt_consumo";
		}

		String vl_ou_qtd2 = "";
		if (_rgValorQtdade1.getValue().equals("V")) {
			vl_ou_qtd2 = "ABS(COALESCE(vl_credito,0) - COALESCE(vl_debito,0))";
		} else {
			vl_ou_qtd2 = "qt_consumo";
		}

		StringBuffer SqlReport = new StringBuffer();

		SqlReport.append("SELECT ");
		SqlReport.append("	en_empresa.nm_empresa, ");
		SqlReport.append("	en_parametro.nm_empresa_instalacao, ");
		SqlReport.append("	en_parametro.fones_empresa_instalacao, ");
		SqlReport.append("	en_parametro.de_email_empresa_instalacao, ");
		SqlReport.append("	en_parametro.nu_cnpj_empresa_instalacao, ");
		SqlReport.append("	en_parametro.de_endereco_empresa_instalacao, ");
		SqlReport.append("	consulta.ano_mes1, ");
		SqlReport.append("	consulta.ano1, ");
		SqlReport.append("	consulta.ano_mes2, ");
		SqlReport.append("	consulta.ano2, ");
		SqlReport.append("	consulta.nm_historico1, ");
		SqlReport.append("	consulta.nm_historico2, ");
		SqlReport.append("	consulta.nm_ano1, ");
		SqlReport.append("	consulta.nm_ano2 ");
		SqlReport.append("FROM ");
		SqlReport.append("	( ");

		SqlReport.append("SELECT ");
		SqlReport.append("	'01'  AS ano_mes1, ");
		SqlReport.append(
				"	abs(" + quantidade_valor1 + "(" + empresa +" , " + (String) _cbxAno1.getValue() +", 1," + (String)_cbxTipoLancamento1.getValue() + ")) AS ano1, ");
		SqlReport.append("	'01' AS ano_mes2, ");
		SqlReport.append(
				"	abs(" + quantidade_valor2 +  "(" + empresa +" , " + (String) _cbxAno1.getValue() +", 1," + (String)_cbxTipoLancamento2.getValue() + "))  AS ano2, ");
		SqlReport.append("	'" + _DSTipoLancamento1.getEnTipoLancamentoNmTipoLancamento(
				_cbxTipoLancamento1.getSelectedIndex()) + "' AS nm_historico1, ");
		SqlReport.append("	'" + _DSTipoLancamento2.getEnTipoLancamentoNmTipoLancamento(
				_cbxTipoLancamento2.getSelectedIndex()) + "' AS nm_historico2, ");
		SqlReport.append("	'" + _cbxAno1.getValue() + "' AS nm_ano1, '" + _cbxAno2.getValue() + "' AS nm_ano2 ");

		for (int i = 2; i < 13; i++) {

			SqlReport.append("union all SELECT ");
			SqlReport.append("	'" + Utils.zeroEsquerda(i + "", 2) + "' AS ano_mes1, ");
			
			SqlReport.append("	abs(" + quantidade_valor1 + "(" + empresa +" , " + (String) _cbxAno1.getValue() +", " + i +"," + (String)_cbxTipoLancamento1.getValue() + "))  , ");
		
			
			
			SqlReport.append("	'" + Utils.zeroEsquerda(i + "", 2)  + "' AS ano_mes2, ");
			SqlReport.append("	abs( " + quantidade_valor2 + "(" + empresa +" , " + (String) _cbxAno2.getValue() +", " + i +"," + (String)_cbxTipoLancamento1.getValue() + "))  , ");
			SqlReport.append("	'" + _DSTipoLancamento1.getEnTipoLancamentoNmTipoLancamento(_cbxTipoLancamento1.getSelectedIndex()) + "' AS nm_historico1, ");
			SqlReport.append("	'" + _DSTipoLancamento2.getEnTipoLancamentoNmTipoLancamento(_cbxTipoLancamento2.getSelectedIndex()) + "' AS nm_historico2, ");
			SqlReport.append("	'" + _cbxAno1.getValue() + "' AS nm_ano1, '" + _cbxAno2.getValue() + "' AS nm_ano2 ");
		}

		SqlReport.append("		)AS consulta ");
		SqlReport.append("	INNER JOIN en_empresa ON en_empresa.cd_empresa = 1 ");
		SqlReport.append("	CROSS JOIN en_parametro ");

		 
		
		
		try {
			return SqlReport.toString();
		} finally {
			SqlReport = null;

		}

	}

}
