package performer.contabil.viewcontroller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.performer.core.IPeEventListener;
import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeImage;
import com.performer.faces.PeMessages;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.CheckBox;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.DateEdit;
import framework.web.gui.widget.ListView;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import framework.web.gui.widget.events.ICloseListener;
import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSBoleto;
import performer.contabil.persistence.DSEmpresa;
import performer.contabil.persistence.DSFornecedor;
import performer.contabil.persistence.DSHistoricoAnual;
import performer.contabil.persistence.DSHistoricoLancamento;
import performer.contabil.persistence.DSTipoLancamento;
import performer.contabil.utils.Utils;

public class CadHistoricoAnualController extends BaseControllerForm {

	// Data Store
	private DSEmpresa _DSEmpresa;
	private DSEmpresa _DSEmpresaPesquisa;
	private DSHistoricoAnual _DSHistoricoAnual;
    private DSTipoLancamento  _DSTipoLancamento;
    private DSTipoLancamento _DSTipoLancamentoPesquisa;
    private Text _txtBrancoPesquisa;
	
	// Visual Comps Pesquisa
	private ComboBoxLookup _cbxEmpresaPesquisa;
	private ComboBoxLookup _cbxTipoLancamentoPesquisa;
	private TextEdit _edtAnoPesquisa;

	// Visual Comps
	private TextEdit _edtAno;
	private ComboBoxLookup _cbxEmpresa;
	private ComboBoxLookup _cbxTipoLancamento;
    private Text _txtBranco1;	 

	private PeImage _btnIncluirTipoLancamento;
	private PeImage _btnAlterarTipoLancamento;

	private TextEdit _edtCreditoJan;
	private TextEdit _edtDebitoJan;
	
	private TextEdit _edtCreditoFev;
	private TextEdit _edtDebitoFev;
	
	private TextEdit _edtCreditoMar;
	private TextEdit _edtDebitoMar;
	
	private TextEdit _edtCreditoAbr;
	private TextEdit _edtDebitoAbr;
	
	private TextEdit _edtCreditoMai;
	private TextEdit _edtDebitoMai;

	private TextEdit _edtCreditoJun;
	private TextEdit _edtDebitoJun;
	
	private TextEdit _edtCreditoJul;
	private TextEdit _edtDebitoJul;
	
	private TextEdit _edtCreditoAgo;
	private TextEdit _edtDebitoAgo;
	
	private TextEdit _edtCreditoSet;
	private TextEdit _edtDebitoSet;
	
	private TextEdit _edtCreditoOut;
	private TextEdit _edtDebitoOut;
	
	private TextEdit _edtCreditoNov;
	private TextEdit _edtDebitoNov;

	private TextEdit _edtCreditoDez;
	private TextEdit _edtDebitoDez;
	
	public CadHistoricoAnualController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public CadHistoricoAnualController(ModalArgument modalArgument) {
		super(modalArgument);

	}

	@Override
	protected String getCaption() {

		return "Cadastro de Historico Anual";

	}

	@Override
	protected void afterOpen() {

		_cbxEmpresa.setValue(_DSHistoricoAnual.getEnHistoricoAnualCdEmpresa());

		String valor = null;

		if (_DSHistoricoAnual.getEnHistoricoAnualVlJanCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlJanCredito(), 0);
		}
		_edtCreditoJan.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlJanDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlJanDebito(), 0);
		}
		_edtDebitoJan.setValue(valor);
		valor = null;
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlFevCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlFevCredito(), 0);
		}
		_edtCreditoFev.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlFevDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlFevDebito(), 0);
		}
		_edtDebitoFev.setValue(valor);
		valor = null;
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlMarCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlMarCredito(), 0);
		}
		_edtCreditoMar.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlMarDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlMarDebito(), 0);
		}
		_edtDebitoMar.setValue(valor);
		valor = null;
		
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlAbrCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlAbrCredito(), 0);
		}
		_edtCreditoAbr.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlAbrDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlAbrDebito(), 0);
		}
		_edtDebitoAbr.setValue(valor);
		valor = null;
		
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlMaiCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlMaiCredito(), 0);
		}
		_edtCreditoMai.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlMaiDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlMaiDebito(), 0);
		}
		_edtDebitoMai.setValue(valor);
		valor = null;
		
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlJunCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlJunCredito(), 0);
		}
		_edtCreditoJun.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlJunDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlJunDebito(), 0);
		}
		_edtDebitoJun.setValue(valor);
		valor = null;
		
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlJulCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlJulCredito(), 0);
		}
		_edtCreditoJul.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlJulDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlJulDebito(), 0);
		}
		_edtDebitoJul.setValue(valor);
		valor = null;
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlAgoCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlAgoCredito(), 0);
		}
		_edtCreditoAgo.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlAgoDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlAgoDebito(), 0);
		}
		_edtDebitoAgo.setValue(valor);
		valor = null;
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlSetCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlSetCredito(), 0);
		}
		_edtCreditoSet .setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlSetDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlSetDebito(), 0);
		}
		_edtDebitoSet .setValue(valor);
		valor = null;
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlOutCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlOutCredito(), 0);
		}
		_edtCreditoOut.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlOutDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlOutDebito(), 0);
		}
		_edtDebitoOut.setValue(valor);
		valor = null;
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlNovCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlNovCredito(), 0);
		}
		_edtCreditoNov.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlNovDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlNovDebito(), 0);
		}
		_edtDebitoNov.setValue(valor);
		valor = null;
		
		if (_DSHistoricoAnual.getEnHistoricoAnualVlDezCredito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlDezCredito(), 0);
		}
		_edtCreditoDez.setValue(valor);
		valor = null;
		 
		if (_DSHistoricoAnual.getEnHistoricoAnualVlDezDebito() > 0) {
			valor = Utils.doubleToStr(_DSHistoricoAnual.getEnHistoricoAnualVlDezDebito(), 0);
		}
		_edtDebitoDez.setValue(valor);
		valor = null;
	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSHistoricoAnual;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSHistoricoAnual.EN_HISTORICO_ANUAL_CD_EMPRESA );
		this.setKey(DSHistoricoAnual.EN_HISTORICO_ANUAL_NU_ANO);
		this.setKey(DSHistoricoAnual.EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO);
		
		this.setDataFormInnerLayout(this.createFormLayout());

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, _DSHistoricoAnual, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(600);
		detail.setHeight(650);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		
		_txtBranco1 = new Text("",this);
		
		_edtAno  = new TextEdit("pg",this);
		_edtAno.setColumn(_DSHistoricoAnual, DSHistoricoAnual.EN_HISTORICO_ANUAL_NU_ANO);  
		
		
		
		
		_cbxTipoLancamento  = new ComboBoxLookup("ckAgendado", this);
		_cbxTipoLancamento.setLookupInfo(_DSTipoLancamento, DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO , DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO );  
		_cbxTipoLancamento.setColumn(_DSHistoricoAnual, DSHistoricoAnual.EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO );
		
		PeImage.Attributes attrs = new PeImage.Attributes();
		attrs.setImage("images/pag_add.gif");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE);
		_btnIncluirTipoLancamento = new PeImage(attrs);
		_btnIncluirTipoLancamento.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotOnIncluirTipoLancamentoClick"),
				EventType.WAIT);
		_btnIncluirTipoLancamento.setHint("Clique aqui para incluir um novo Tipo de Lancamento.");

		attrs.setImage("images/pag_edit.gif");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE);
		_btnAlterarTipoLancamento = new PeImage(attrs);
		_btnAlterarTipoLancamento.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotOnAlterarTipoLancamentoClick"),
				EventType.WAIT);
		_btnAlterarTipoLancamento.setHint("Clique aqui para alterar o Tipo de Lancamento selecionado  na listagem.");

		 
		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		_cbxEmpresa = new ComboBoxLookup("empresa", this);
		{
			_cbxEmpresa.setLookupInfo(_DSEmpresa, DSEmpresa.EN_EMPRESA_CD_EMPRESA, DSEmpresa.EN_EMPRESA_DE_SIGLA);

			_cbxEmpresa.setValue(empresa_selecionada);
			_cbxEmpresa.setEnable(false);
		}


		_edtCreditoJan    = new TextEdit("edtJanC",this);
		_edtDebitoJan    = new TextEdit("edtJanD",this);
		 		 
		_edtCreditoFev    = new TextEdit("edtFevC",this);
		_edtDebitoFev    = new TextEdit("edtFevD",this);
		
		_edtCreditoMar    = new TextEdit("edtMarC",this);
		_edtDebitoMar    = new TextEdit("edtMarD",this);
				 		 
		_edtCreditoAbr    = new TextEdit("edtAbrC",this);
		_edtDebitoAbr    = new TextEdit("edtAbrD",this);
		
		_edtCreditoMai    = new TextEdit("edtMaiC",this);
		_edtDebitoMai    = new TextEdit("edtMaiD",this);
		
		_edtCreditoJun    = new TextEdit("edtJunC",this);
		_edtDebitoJun    = new TextEdit("edtJunD",this);
		
		_edtCreditoJul    = new TextEdit("edtJulC",this);
		_edtDebitoJul    = new TextEdit("edtJulD",this);
		
		_edtCreditoAgo    = new TextEdit("edtAgoC",this);
		_edtDebitoAgo    = new TextEdit("edtAgoD",this);
		
		_edtCreditoSet    = new TextEdit("edtSetC",this);
		_edtDebitoSet    = new TextEdit("edtSetD",this);
		
		_edtCreditoAgo    = new TextEdit("edtAgoC",this);
		_edtDebitoAgo    = new TextEdit("edtAgoD",this);
		
		_edtCreditoOut    = new TextEdit("edtOutC",this);
		_edtDebitoOut    = new TextEdit("edtOutD",this);
		
		_edtCreditoNov    = new TextEdit("edtNovC",this);
		_edtDebitoNov    = new TextEdit("edtNovD",this);
		
		_edtCreditoDez    = new TextEdit("edtDezC",this);
		_edtDebitoDez    = new TextEdit("edtDezD",this);
	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1,1,3});
		{
			detail.addField("Empresa: ", _cbxEmpresa);
			detail.addField("Ano: ", _edtAno);
			detail.addField(" ", _txtBranco1);
		}

		detail.addTable(new int[] { 30, 1, 1 });
		{
			detail.addField("Tipo de Lancamento ", _cbxTipoLancamento);
		 
			detail.addField("Incluir", _btnIncluirTipoLancamento);
			detail.addField("Alterar", _btnAlterarTipoLancamento);
		}

		detail.addTable(new int[] { 1, 1  });
		{
			detail.addField("Janeiro - Crédito:", _edtCreditoJan );
			detail.addField("Janeiro - Débito", _edtDebitoJan);
			
			detail.addField("Fevereiro - Crédito:", _edtCreditoFev );
			detail.addField("Fevereiro - Débito", _edtDebitoFev);
			
			detail.addField("Março - Crédito:", _edtCreditoMar );
			detail.addField("Março - Débito", _edtDebitoMar);
			
			detail.addField("Abril - Crédito:", _edtCreditoAbr );
			detail.addField("Abril - Débito", _edtDebitoAbr);
			
			detail.addField("Maio - Crédito:", _edtCreditoMai );
			detail.addField("Maio - Débito", _edtDebitoMai);
			
			detail.addField("Junho - Crédito:", _edtCreditoJun );
			detail.addField("Junho - Débito", _edtDebitoJun);
			
			detail.addField("Julho - Crédito:", _edtCreditoJul );
			detail.addField("Julho - Débito", _edtDebitoJul);
			
			detail.addField("Agosto - Crédito:", _edtCreditoAgo);
			detail.addField("Agosto - Débito", _edtDebitoAgo);
			
			
			detail.addField("Setembro - Crédito:", _edtCreditoSet);
			detail.addField("Setembro - Débito", _edtDebitoSet);
			
			detail.addField("Outubro - Crédito:", _edtCreditoOut);
			detail.addField("Outubro - Débito", _edtDebitoOut);
		
			detail.addField("Novembro - Crédito:", _edtCreditoNov);
			detail.addField("Novembro - Débito", _edtDebitoNov);
			
			detail.addField("Dezembro - Crédito:", _edtCreditoDez);
			detail.addField("Dezembro - Débito", _edtDebitoDez );
			
		}
		 
	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSHistoricoAnual = new DSHistoricoAnual(this.getApplicationName());

		_DSTipoLancamento = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamento.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada);

		_DSTipoLancamentoPesquisa = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamentoPesquisa.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada);

		_DSEmpresa = new DSEmpresa(this.getApplicationName());
		_DSEmpresa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa_selecionada);

		_DSEmpresaPesquisa = new DSEmpresa(this.getApplicationName());
		_DSEmpresaPesquisa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa_selecionada);

	}

	@Override
	protected String getSQLSearch() {
		// TODO Auto-generated method stub

		String criteria =    " 0 = 0 ";

		String empresa = (String) _cbxEmpresaPesquisa.getValue();
		String codigoTipoLancamento = (String) _cbxTipoLancamentoPesquisa.getValue();
		String ano = _edtAnoPesquisa.getValue();
		
		if (empresa != null) {

			criteria = criteria + " and " + DSHistoricoAnual.EN_HISTORICO_ANUAL_CD_EMPRESA + " = " + empresa + " ";
		} else {
			criteria = criteria + " and " + DSHistoricoAnual.EN_HISTORICO_ANUAL_CD_EMPRESA + " = -1 ";
		}

		if (codigoTipoLancamento != null) {

			criteria = criteria + " and "
					+ DSHistoricoAnual.EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO + " = " + codigoTipoLancamento		+ "  ";
		}

		
		if (ano != null) {
			criteria = criteria + " and "
					+ DSHistoricoAnual.EN_HISTORICO_ANUAL_NU_ANO + " = " + ano + "  ";
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
		
		 
		
		_txtBrancoPesquisa = new Text("",this);

		_cbxEmpresaPesquisa = new ComboBoxLookup("emp", this);
		_cbxEmpresaPesquisa.setLookupInfo(_DSEmpresaPesquisa, DSEmpresa.EN_EMPRESA_CD_EMPRESA,
				DSEmpresa.EN_EMPRESA_DE_SIGLA);
		_cbxEmpresaPesquisa.setValue((String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA"));
		_cbxEmpresaPesquisa.setEnable(false);

		_cbxTipoLancamentoPesquisa = new ComboBoxLookup("hp", this);
		_cbxTipoLancamentoPesquisa.setLookupInfo(_DSTipoLancamentoPesquisa ,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO ,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
		
		_edtAnoPesquisa = new TextEdit("ani", this);
 
		_edtAnoPesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

	}

	private void setSearchFields() {
		this.addSearchFieldComponent("Empresa:", _cbxEmpresaPesquisa);
		this.addSearchFieldComponent("Ano:", _edtAnoPesquisa);
		this.addSearchFieldComponent("Tipo de Lancamento:", _cbxTipoLancamentoPesquisa);
		this.addSearchFieldComponent(" ", _txtBrancoPesquisa);

	}

	private void setSearchView() {
		this.addListColumn("Empresa", "left", 100, DSHistoricoAnual.EN_EMPRESA_NM_EMPRESA,	ListView.CTYPE_READONLY);
		this.addListColumn("Ano", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_NU_ANO,	ListView.CTYPE_READONLY);
		this.addListColumn("Histórico", "center", 80, DSHistoricoAnual.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO ,	ListView.CTYPE_READONLY);
		this.addListColumn("Janeiro Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_JAN_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Janeiro Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_JAN_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Fevereiro Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_FEV_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Fevereiro Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_FEV_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Março Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_MAR_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Março Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_MAR_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Abril Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_ABR_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Abril Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_ABR_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Maio Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_MAI_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Maio Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_MAI_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Junho Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_JUN_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Junho Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_JUN_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Julho Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_JUL_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Julho Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_JUL_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Agosto Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_AGO_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Agosto Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_AGO_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Setembro Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_SET_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Setembro Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_SET_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Outubro Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_OUT_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Outubro Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_OUT_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Novembro Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_NOV_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Novembro Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_NOV_DEBITO, ListView.CTYPE_PRICE);
		this.addListColumn("Dezembro Crédito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_DEZ_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Dezembro Débito", "left", 100, DSHistoricoAnual.EN_HISTORICO_ANUAL_VL_DEZ_DEBITO, ListView.CTYPE_PRICE);
		
	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub

		 
		String historico = (String) _cbxTipoLancamento.getValue();
		String ano  = _edtAno.getValue();

		if (historico == null) {
			this.showErrorMessage("O Tipo de Lancamento deve ser informado!");
			return false;
		} else if (ano == null) {
			this.showErrorMessage("O ano deve ser informado!");
			return false;
		} 
		else
			return true;

	}

	@Override
	protected void beforeSave() {

		  String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		
		_DSHistoricoAnual .setEnHistoricoAnualCdEmpresa(Short.parseShort(empresa)) ;
		
		


		if (_edtCreditoJan.getValue() != null && !(_edtCreditoJan.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlJanCredito(Utils.strToDouble(_edtCreditoJan.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlJanCredito(0);
		}
		if (_edtDebitoJan.getValue() != null && !(_edtDebitoJan.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlJanDebito(Utils.strToDouble(_edtDebitoJan.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlJanDebito(0);
		}
		
		if (_edtCreditoFev.getValue() != null && !(_edtCreditoFev.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlFevCredito(Utils.strToDouble(_edtCreditoFev.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlFevCredito(0);
		}
		if (_edtDebitoFev.getValue() != null && !(_edtDebitoFev.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlFevDebito(Utils.strToDouble(_edtDebitoFev.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlFevDebito(0);
		}
		if (_edtCreditoMar.getValue() != null && !(_edtCreditoMar.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlMarCredito(Utils.strToDouble(_edtCreditoMar.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlMarCredito(0);
		}
		if (_edtDebitoMar.getValue() != null && !(_edtDebitoMar.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlMarDebito(Utils.strToDouble(_edtDebitoMar.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlMarDebito(0);
		}
		if (_edtCreditoAbr.getValue() != null && !(_edtCreditoAbr.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlAbrCredito(Utils.strToDouble(_edtCreditoAbr.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlAbrCredito(0);
		}
		if (_edtDebitoAbr.getValue() != null && !(_edtDebitoAbr.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlAbrDebito(Utils.strToDouble(_edtDebitoAbr.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlAbrDebito(0);
		}
		if (_edtCreditoMai.getValue() != null && !(_edtCreditoMai.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlMaiCredito(Utils.strToDouble(_edtCreditoMai.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlMaiCredito(0);
		}
		if (_edtDebitoMai.getValue() != null && !(_edtDebitoMai.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlMaiDebito(Utils.strToDouble(_edtDebitoMai.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlMaiDebito(0);
		}
		if (_edtCreditoJun.getValue() != null && !(_edtCreditoJun.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlJunCredito(Utils.strToDouble(_edtCreditoJun.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlJunCredito(0);
		}
		if (_edtDebitoJun.getValue() != null && !(_edtDebitoJun.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlJunDebito(Utils.strToDouble(_edtDebitoJun.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlJunDebito(0);
		}
		if (_edtCreditoJul.getValue() != null && !(_edtCreditoJul.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlJulCredito(Utils.strToDouble(_edtCreditoJul.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlJulCredito(0);
		}
		if (_edtDebitoJul.getValue() != null && !(_edtDebitoJul.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlJulDebito(Utils.strToDouble(_edtDebitoJul.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlJulDebito(0);
		}
		if (_edtCreditoAgo.getValue() != null && !(_edtCreditoAgo.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlAgoCredito(Utils.strToDouble(_edtCreditoAgo.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlAgoCredito(0);
		}
		if (_edtDebitoAgo.getValue() != null && !(_edtDebitoAgo.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlAgoDebito(Utils.strToDouble(_edtDebitoAgo.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlAgoDebito(0);
		}
		if (_edtCreditoSet.getValue() != null && !(_edtCreditoSet.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlSetCredito(Utils.strToDouble(_edtCreditoSet.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlSetCredito(0);
		}
		if (_edtDebitoSet.getValue() != null && !(_edtDebitoSet.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlSetDebito(Utils.strToDouble(_edtDebitoSet.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlSetDebito(0);
		}
		if (_edtCreditoOut.getValue() != null && !(_edtCreditoOut.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlOutCredito(Utils.strToDouble(_edtCreditoOut.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlOutCredito(0);
		}
		if (_edtDebitoOut.getValue() != null && !(_edtDebitoOut.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlOutDebito(Utils.strToDouble(_edtDebitoOut.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlOutDebito(0);
		}
		if (_edtCreditoNov.getValue() != null && !(_edtCreditoNov.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlNovCredito(Utils.strToDouble(_edtCreditoNov.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlNovCredito(0);
		}
		if (_edtDebitoNov.getValue() != null && !(_edtDebitoNov.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlNovDebito(Utils.strToDouble(_edtDebitoNov.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlNovDebito(0);
		}
		if (_edtCreditoDez.getValue() != null && !(_edtCreditoDez.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlDezCredito(Utils.strToDouble(_edtCreditoDez.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlDezCredito(0);
		}
		if (_edtDebitoDez.getValue() != null && !(_edtDebitoDez.getValue().trim().equals(""))) {
			_DSHistoricoAnual.setEnHistoricoAnualVlDezDebito(Utils.strToDouble(_edtDebitoDez.getValue()));
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualVlDezDebito(0);
		}
		
	}

	@Override
	protected void onNewRecord() {
		_edtCreditoJan.setValue(null);
		_edtDebitoJan.setValue(null);
		_edtCreditoFev.setValue(null);
		_edtDebitoFev.setValue(null);
		_edtCreditoMar.setValue(null);
		_edtDebitoMar.setValue(null);
		_edtCreditoAbr.setValue(null);
		_edtDebitoAbr.setValue(null);
		_edtCreditoMai.setValue(null);
		_edtDebitoMai.setValue(null);
		_edtCreditoJun.setValue(null);
		_edtDebitoJun.setValue(null);
		_edtCreditoJul.setValue(null);
		_edtDebitoJul.setValue(null);
		_edtCreditoAgo.setValue(null);
		_edtDebitoAgo.setValue(null);
		_edtCreditoSet.setValue(null);
		_edtDebitoSet.setValue(null);
		_edtCreditoOut.setValue(null);
		_edtDebitoOut.setValue(null);
		_edtCreditoNov.setValue(null);
		_edtDebitoNov.setValue(null);
		_edtCreditoDez.setValue(null);
		_edtDebitoDez.setValue(null);

	}

	public void slotOnIncluirTipoLancamentoClick(PeEventObject e) {

		Map<String, Object> param = new HashMap<String, Object>();
		Boolean insertModal = new Boolean(Boolean.TRUE);

		param.put(BaseControllerForm.INSERT_MODAL, insertModal);

		this.showModal("CadTipoLancamento", 780, 400, param, new OnCloseTipoLancamento());

	}

	public void slotOnAlterarTipoLancamentoClick(PeEventObject e) {

		String[] fields = { DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO};
		Object[] values = { _DSTipoLancamento.getEnTipoLancamentoCdTipoLancamento(_cbxTipoLancamento.getSelectedIndex()) };
		Map<String, Object> param = new HashMap<String, Object>();
		{
			param.put(BaseControllerForm.INSERT_MODAL, true);
			param.put(BaseControllerForm.MODAL_KEY_FIELD, fields);
			param.put(BaseControllerForm.MODAL_KEY_VALUE, values);
		}

		this.showModal("CadTipoLancamento", 780, 400, param, new OnCloseTipoLancamento());

	}

	class OnCloseTipoLancamento implements ICloseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void onCloseEvent(Object e) {
			String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

			try {
				_DSTipoLancamento.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa);
			} catch (DataStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			_cbxTipoLancamento.populateOptions();

		}
	}
 
}

