package performer.contabil.viewcontroller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.ListView;
import framework.web.gui.widget.TextEdit;
import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSFaturamentoAnual;
import performer.contabil.persistence.DSFaturamentoMensal;
import performer.contabil.persistence.DSMes;
import performer.contabil.persistence.DSUsuario;
import performer.contabil.utils.Utils;

public class CadFaturamentoMensalController extends BaseControllerForm {

	// Data Store
	private DSFaturamentoMensal _DSFaturamentoMensal;
	private DSFaturamentoAnual _DSFaturamentoAnual;
	private DSMes _DSMes;
	private DSMes _DSMesPesquisa;

	// Visual Comps Pesquisa
	private ComboBoxLookup _cbxMesPesquisa;
	private TextEdit _edtAnoPesquisa;
	// Visual Comps
	private TextEdit _edtAno;
	private ComboBoxLookup _cbxMes;

	private TextEdit _edtValorFaturamento;
	private TextEdit _edtValorDespesas;

	public CadFaturamentoMensalController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public CadFaturamentoMensalController(ModalArgument modalArgument) {
		super(modalArgument);

	}

	@Override
	protected String getCaption() {

		return "Cadastro de Faturamentos Mensais";

	}

	@Override
	protected void afterOpen() {

		String valor = "";

		if (_DSFaturamentoMensal.getEnFaturamentoMensalVlDespesas() >0 ) {
			valor = Utils.doubleToStr(_DSFaturamentoMensal.getEnFaturamentoMensalVlDespesas(),0 );
		}
		_edtValorDespesas.setValue(valor);

		valor = "";

		if (_DSFaturamentoMensal.getEnFaturamentoMensalVlFaturamento() > 0) {
			valor = Utils.doubleToStr(_DSFaturamentoMensal.getEnFaturamentoMensalVlFaturamento(),0 );
		}
		_edtValorFaturamento.setValue(valor);

	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSFaturamentoMensal;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub
		this.setKey(DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_CD_EMPRESA);
		this.setKey(DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_NU_ANO);
		this.setKey(DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_NU_MES);
		this.setDataFormInnerLayout(this.createFormLayout());

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, _DSFaturamentoMensal, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(720);
		detail.setHeight(350);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		_edtAno = new TextEdit("pg", this);
		_edtAno.setColumn(_DSFaturamentoMensal, DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_NU_ANO);

	 
	 

		_cbxMes = new ComboBoxLookup("mes", this);
		_cbxMes.setLookupInfo(_DSMes, DSMes.en_mes_nu_mes, DSMes.en_mes_nm_mes);
		_cbxMes.setColumn(_DSFaturamentoMensal, DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_NU_MES);

		_edtValorDespesas = new TextEdit("dataD", this);

		_edtValorFaturamento = new TextEdit("valorF", this);

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 6, 1 });
		{
			detail.addField("Mês: ", _cbxMes);
			detail.addField("Ano: ", _edtAno);
		}

		detail.addTable(new int[] { 1, 1 });
		{

			detail.addField("Faturamento", _edtValorFaturamento);
			detail.addField("Despesas", _edtValorDespesas);
		}

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		_DSFaturamentoAnual = new DSFaturamentoAnual(this.getApplicationName());

		_DSFaturamentoMensal = new DSFaturamentoMensal(this.getApplicationName());

		_DSMes = new DSMes(this.getApplicationName());
		_DSMes.retrieve();

		_DSMesPesquisa = new DSMes(this.getApplicationName());
		_DSMesPesquisa.retrieve();

	}

	@Override
	protected String getSQLSearch() {
		// TODO Auto-generated method stub

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		String criteria = DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_CD_EMPRESA + " =  " + empresa_selecionada;

		String mes = (String) _cbxMesPesquisa.getValue();
		String ano = _edtAnoPesquisa.getValue();

		if (ano != null) {

			criteria = criteria + " and " + DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_NU_ANO + " = " + ano + " ";
		} else {
			criteria = criteria + " and " + DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_NU_ANO + " = -1 ";
		}

		return criteria;
	}

	@Override
	protected void setupSearch() {
		setListViewSize("750", "380");
		this.initSearchFields();
		this.setSearchFields();
		this.setSearchView();
	}

	private void initSearchFields() {

		_cbxMesPesquisa = new ComboBoxLookup("mesP", this);
		_cbxMesPesquisa.setLookupInfo(_DSMesPesquisa, DSMes.en_mes_nu_mes, DSMes.en_mes_nm_mes);

		_cbxMesPesquisa.setLookupInfo(_DSMesPesquisa, DSMes.en_mes_nu_mes, DSMes.en_mes_nm_mes);

		_edtAnoPesquisa = new TextEdit("fat", this);

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		_edtAnoPesquisa.setValue(year + "");

		_edtAnoPesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

	}

	private void setSearchFields() {
		this.addSearchFieldComponent("Mes:", _cbxMesPesquisa);
		this.addSearchFieldComponent("Ano:", _edtAnoPesquisa);

	}

	private void setSearchView() {
		this.addListColumn("Mês", "left", 100, DSFaturamentoMensal.EN_MES_NM_MES);
		this.addListColumn("Ano", "left", 100, DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_NU_ANO);
		this.addListColumn("Faturamento", "rigth", 100, DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_VL_FATURAMENTO  ,	ListView.CTYPE_PRICE);
		this.addListColumn("Despesas", "rigth", 100, DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_VL_DESPESAS  ,	ListView.CTYPE_PRICE);
		
		 	
	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub

		String mes = (String) _cbxMes.getValue();
		String ano = _edtAno.getValue();

		if (mes == null) {
			this.showErrorMessage("O mês deve ser informado!");
			return false;
		} else if (ano == null) {
			this.showErrorMessage("O Ano deve ser informado!");
			return false;
		} else
			return true;

	}

	@Override
	protected void beforeSave() {

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSFaturamentoMensal.setEnFaturamentoMensalCdEmpresa(Short.parseShort(empresa));

		if (_edtValorDespesas.getValue() != null && !(_edtValorDespesas.getValue().trim().equals(""))) {
			_DSFaturamentoMensal.setEnFaturamentoMensalVlDespesas(Utils.strToDouble(_edtValorDespesas.getValue()));
		} else {
			_DSFaturamentoMensal.setEnFaturamentoMensalVlDespesas(0);
		}

		if (_edtValorFaturamento.getValue() != null && !(_edtValorFaturamento.getValue().trim().equals(""))) {
			_DSFaturamentoMensal
					.setEnFaturamentoMensalVlFaturamento(Utils.strToDouble(_edtValorFaturamento.getValue()));
		} else {
			_DSFaturamentoMensal.setEnFaturamentoMensalVlFaturamento(0);
		}

		
		gravaFaturamentoAnual(empresa);
	}

	
	
	@Override
	protected void beforeDelete() {
		deletaFaturamentoAnual((String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA"));
	}

	@Override
	protected void onNewRecord() {
		_edtValorFaturamento.setValue(null);
		_edtValorDespesas.setValue(null);

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);

		_edtAno.setValue(year + "");

		_cbxMes = new ComboBoxLookup("mes", this);
		_cbxMes.setLookupInfo(_DSMes, DSMes.en_mes_nu_mes, DSMes.en_mes_nm_mes);
		_cbxMes.setColumn(_DSFaturamentoMensal, DSFaturamentoMensal.EN_FATURAMENTO_MENSAL_NU_MES);
		_cbxMes.setValue(month + 1);

	}

	public void gravaFaturamentoAnual(String empresa) {
		Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
		String usuario = (String) PeFacesApplication.getInstance().getAttribute(DSUsuario.EN_USUARIO_ID_USUARIO);
		
		

		if (_edtValorDespesas.getValue() == null) {
			_edtValorDespesas.setValue("");
		}
		if (_edtValorFaturamento.getValue() == null) {
			_edtValorFaturamento.setValue("");
		}

		double vlDespesas = Utils.strToDouble(_edtValorDespesas.getValue());
		double vlFaturamento = Utils.strToDouble(_edtValorFaturamento.getValue());

		try {
			_DSFaturamentoAnual.retrieve(DSFaturamentoAnual.EN_FATURAMENTO_ANUAL_NU_ANO + " = " + _edtAno.getValue() + " and " +
		DSFaturamentoAnual.EN_FATURAMENTO_ANUAL_CD_EMPRESA + " = " + empresa);
		} catch (DataStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (_DSFaturamentoAnual.getRowCount() == 0) {
			_DSFaturamentoAnual.insertRow();
			_DSFaturamentoAnual.setEnFaturamentoAnualCdEmpresa(Short.parseShort(empresa)); ;
			_DSFaturamentoAnual.setEnFaturamentoAnualNuAno(0,Short.parseShort(_edtAno.getValue()));
			_DSFaturamentoAnual.setEnFaturamentoAnualDtCadastro(0, dataDeHoje);
			_DSFaturamentoAnual.setEnFaturamentoAnualIdUsuarioCad(0, usuario);
		} else {
			_DSFaturamentoAnual.setEnFaturamentoAnualDtAlteracao(0, dataDeHoje);
			_DSFaturamentoAnual.setEnFaturamentoAnualIdUsuarioAlt(0, usuario);
		}
		

		
		short mes = _DSMes.geten_mesnu_mes(_cbxMes.getSelectedIndex());

		switch (mes) {
		case 1:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlJanDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlJanFaturamento(0,vlFaturamento);

			break;
		case 2:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlFevDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlFevFaturamento(0,vlFaturamento);
			break;
		case 3:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlMarDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlMarFaturamento(0,vlFaturamento);
			break;
		case 4:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlAbrDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlAbrFaturamento(0,vlFaturamento);
			break;
		case 5:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlMaiDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlMaiFaturamento(0,vlFaturamento);
			break;
		case 6:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlJunDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlJunFaturamento(0,vlFaturamento);
			break;
		case 7:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlJulDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlJulFaturamento(0,vlFaturamento);
			break;
		case 8:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlAgoDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlAgoFaturamento(0,vlFaturamento);
			break;
		case 9:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlSetDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlSetFaturamento(0,vlFaturamento);
			break;
		case 10:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlOutDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlOutFaturamento(0,vlFaturamento);
			break;
		case 11:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlNovDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlNovFaturamento(0,vlFaturamento);
			break;
		case 12:
			_DSFaturamentoAnual.setEnFaturamentoAnualVlDezDespesas(0,vlDespesas);
			_DSFaturamentoAnual.setEnFaturamentoAnualVlDezFaturamento(0,vlFaturamento);
			break;

		}

		try {
			_DSFaturamentoAnual.update();
		} catch (DataStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deletaFaturamentoAnual(String empresa) {

		
		Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
		String usuario = (String) PeFacesApplication.getInstance().getAttribute(DSUsuario.EN_USUARIO_ID_USUARIO);

		
		try {
			_DSFaturamentoAnual.retrieve(DSFaturamentoAnual.EN_FATURAMENTO_ANUAL_NU_ANO + " = " + _edtAno.getValue() + " and " + 
		DSFaturamentoAnual.EN_FATURAMENTO_ANUAL_CD_EMPRESA + " = " + empresa);
		} catch (DataStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (_DSFaturamentoAnual.getRowCount() == 1) {
			
			_DSFaturamentoAnual.setEnFaturamentoAnualDtAlteracao(0, dataDeHoje);
			_DSFaturamentoAnual.setEnFaturamentoAnualIdUsuarioAlt(0, usuario);
	

			short mes = _DSMes.geten_mesnu_mes(_cbxMes.getSelectedIndex());

			switch (mes) {
			case 1:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlJanDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlJanFaturamento(0, 0);

				break;
			case 2:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlFevDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlFevFaturamento(0, 0);
				break;
			case 3:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlMarDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlMarFaturamento(0, 0);
				break;
			case 4:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlAbrDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlAbrFaturamento(0, 0);
				break;
			case 5:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlMaiDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlMaiFaturamento(0, 0);
				break;
			case 6:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlJunDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlJunFaturamento(0, 0);
				break;
			case 7:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlJulDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlJulFaturamento(0, 0);
				break;
			case 8:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlAgoDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlAgoFaturamento(0, 0);
				break;
			case 9:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlSetDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlSetFaturamento(0, 0);
				break;
			case 10:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlOutDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlOutFaturamento(0, 0);
				break;
			case 11:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlNovDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlNovFaturamento(0, 0);
				break;
			case 12:
				_DSFaturamentoAnual.setEnFaturamentoAnualVlDezDespesas(0, 0);
				_DSFaturamentoAnual.setEnFaturamentoAnualVlDezFaturamento(0, 0);
				break;

			}
		}
		
		try {
			_DSFaturamentoAnual.update();
		} catch (DataStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
