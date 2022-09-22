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
import performer.contabil.utils.Utils;

public class CadBoletosController extends BaseControllerForm {

	// Data Store
	private DSEmpresa _DSEmpresa;
	private DSEmpresa _DSEmpresaPesquisa;
	private DSBoleto _DSBoleto;
    private DSFornecedor _DSFornecedor;
    private DSFornecedor _DSFornecedorPesquisa;
    
	// Visual Comps Pesquisa
	private ComboBoxLookup _cbxEmpresaPesquisa;
	private ComboBoxLookup _cbxFornecedorPesquisa;
	private DateEdit _edtDataIncioPesquisa;
	private DateEdit _edtDataFimPesquisa;

	// Visual Comps
	private TextEdit _edtCodigo;
	private ComboBoxLookup _cbxEmpresa;
	 

	private PeImage _btnIncluirFornecedor;
	private PeImage _btnAlterarFornecedor;

	private TextEdit _edtNuDocumento;
	private TextEdit _edtValorBoleto;
	private DateEdit _edtDataVencimento;
	private CheckBox _ckbPagamentoAgendado;
	private ComboBoxLookup _cbxFornecedor;

	
	
	private Text _txtBranco1;
	public short AbreFornecedor;

	public CadBoletosController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public CadBoletosController(ModalArgument modalArgument) {
		super(modalArgument);

	}

	@Override
	protected String getCaption() {

		return "Cadastro de Boletos";

	}

	@Override
	protected void afterOpen() {

		_cbxEmpresa.setValue(_DSBoleto.getEnBoletoCdEmpresa());

		String valor = null;

		if (_DSBoleto.getEnBoletoVlBoleto() > 0) {
			valor = Utils.doubleToStr(_DSBoleto.getEnBoletoVlBoleto(), 0);
		}
		_edtValorBoleto.setValue(valor);

		 

		_edtDataVencimento.setValue(_DSBoleto.getEnBoletoDtVencimento());

	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSBoleto;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSBoleto.EN_BOLETO_CD_BOLETO );
		this.setKey(DSBoleto.EN_BOLETO_NU_ANO);
		this.setDataFormInnerLayout(this.createFormLayout());

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, _DSBoleto, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(720);
		detail.setHeight(350);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		
		_edtNuDocumento = new TextEdit("pg",this);
		_edtNuDocumento.setColumn(_DSBoleto, DSBoleto.EN_BOLETO_NU_DOCUMENTO);
		
		
		_ckbPagamentoAgendado = new CheckBox("ckAgendado", this, " ", "S", "N");
		_ckbPagamentoAgendado.setColumn(_DSBoleto, DSBoleto.EN_BOLETO_FG_PAGAMENTO_AGENDADO);
		
		PeImage.Attributes attrs = new PeImage.Attributes();
		attrs.setImage("images/pag_add.gif");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE);
		_btnIncluirFornecedor = new PeImage(attrs);
		_btnIncluirFornecedor.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotOnIncluirFornecedorClick"),
				EventType.WAIT);
		_btnIncluirFornecedor.setHint("Clique aqui para incluir um novo Fornecedor.");

		attrs.setImage("images/pag_edit.gif");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE);
		_btnAlterarFornecedor = new PeImage(attrs);
		_btnAlterarFornecedor.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotOnAlterarFornecedorClick"),
				EventType.WAIT);
		_btnAlterarFornecedor.setHint("Clique aqui para alterar o Fornecedor selecionado  na listagem.");

		 
		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		_cbxEmpresa = new ComboBoxLookup("empresa", this);
		{
			_cbxEmpresa.setLookupInfo(_DSEmpresa, DSEmpresa.EN_EMPRESA_CD_EMPRESA, DSEmpresa.EN_EMPRESA_DE_SIGLA);

			_cbxEmpresa.setValue(empresa_selecionada);
			_cbxEmpresa.setEnable(false);
		}

		_edtDataVencimento = new DateEdit("data", this);

		_edtValorBoleto = new TextEdit("valorC", this);
 

		_cbxFornecedor = new ComboBoxLookup("hist", this);
		_cbxFornecedor.setLookupInfo(_DSFornecedor,
				DSFornecedor.EN_FORNECEDOR_NU_CNPJ_CPF,
				DSFornecedor.EN_FORNECEDOR_NM_FORNECEDOR);
		_cbxFornecedor.setColumn(_DSBoleto, DSBoleto.EN_BOLETO_NU_CNPJ_CPF_FORNECEDOR);

		_txtBranco1 = new Text("", this);

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1});
		{
			detail.addField("Empresa: ", _cbxEmpresa);
		
			detail.addField(" ", _txtBranco1);
		}

		detail.addTable(new int[] { 30, 1, 1 });
		{
			detail.addField("Fornecedor ", _cbxFornecedor);
		 
			detail.addField("Incluir", _btnIncluirFornecedor);
			detail.addField("Alterar", _btnAlterarFornecedor);
		}

		detail.addTable(new int[] { 1, 1 ,1});
		{
			detail.addField("Nº Documento:", _edtNuDocumento);
			detail.addField("Valor Boleto:", _edtValorBoleto);
			detail.addField("Data Vencimento:", _edtDataVencimento);
		}
		detail.addTable(new int[] {   1 });
		{
			detail.addField("Pagamento Agendado  ", _ckbPagamentoAgendado);
		}
	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSBoleto = new DSBoleto(this.getApplicationName());

		_DSFornecedor = new DSFornecedor(this.getApplicationName());
		_DSFornecedor.retrieve();

		_DSFornecedorPesquisa = new DSFornecedor(this.getApplicationName());
		_DSFornecedorPesquisa.retrieve();

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
		String codigoFornecedor = (String) _cbxFornecedorPesquisa.getValue();
		Date dataInicio = _edtDataIncioPesquisa.getValue();
		Date dataFim = _edtDataFimPesquisa.getValue();
		SimpleDateFormat _sdfBrasil = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat _sdfUSA = new SimpleDateFormat("yyyy/MM/dd");

		if (empresa != null) {

			criteria = criteria + " and " + DSBoleto.EN_BOLETO_CD_EMPRESA + " = " + empresa + " ";
		} else {
			criteria = criteria + " and " + DSBoleto.EN_BOLETO_CD_EMPRESA + " = -1 ";
		}

		if (codigoFornecedor != null) {

			criteria = criteria + " and "
					+ DSBoleto.EN_BOLETO_NU_CNPJ_CPF_FORNECEDOR + " = '" + _DSFornecedorPesquisa
							.getEnFornecedorNuCnpjCpf(_cbxFornecedorPesquisa.getSelectedIndex())
					+ "' ";
		}

		if (dataInicio != null && dataFim == null) {

			criteria = criteria + "and to_char(en_boleto.dt_vencimento,'dd/mm/yyyy') = '"
					+ _sdfBrasil.format(dataInicio.getTime()) + "'";
		}

		if (dataInicio != null && dataFim != null) {

			criteria = criteria + "and en_boleto.dt_vencimento between '" + _sdfUSA.format(dataInicio.getTime())
					+ " 00:00:00' and '" + _sdfUSA.format(dataFim.getTime()) + " 23:59:59' ";
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

		_cbxEmpresaPesquisa = new ComboBoxLookup("emp", this);
		_cbxEmpresaPesquisa.setLookupInfo(_DSEmpresaPesquisa, DSEmpresa.EN_EMPRESA_CD_EMPRESA,
				DSEmpresa.EN_EMPRESA_DE_SIGLA);
		_cbxEmpresaPesquisa.setValue((String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA"));
		_cbxEmpresaPesquisa.setEnable(false);

		_cbxFornecedorPesquisa = new ComboBoxLookup("hp", this);
		_cbxFornecedorPesquisa.setLookupInfo(_DSFornecedorPesquisa,
				DSFornecedor.EN_FORNECEDOR_NU_CNPJ_CPF,
				DSFornecedor.EN_FORNECEDOR_NM_FORNECEDOR);
		_edtDataIncioPesquisa = new DateEdit("ini", this);
		_edtDataFimPesquisa = new DateEdit("ini", this);

		_cbxFornecedorPesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

	}

	private void setSearchFields() {
		this.addSearchFieldComponent("Empresa:", _cbxEmpresaPesquisa);
		this.addSearchFieldComponent("Fornecedor:", _cbxFornecedorPesquisa);
		this.addSearchFieldComponent("Data Inicio:", _edtDataIncioPesquisa);
		this.addSearchFieldComponent("Data Fim:", _edtDataFimPesquisa);

	}

	private void setSearchView() {
		this.addListColumn("Empresa", "left", 100, DSBoleto.EN_EMPRESA_NM_EMPRESA);
		this.addListColumn("Fornecedor", "left", 100, DSBoleto.EN_FORNECEDOR_NM_FORNECEDOR);
		this.addListColumn("Data Vencimento", "center", 80, DSBoleto.EN_BOLETO_DT_VENCIMENTO,	ListView.CTYPE_DATE);
		this.addListColumn("Valor Boleto", "left", 250, DSBoleto.EN_BOLETO_VL_BOLETO, ListView.CTYPE_PRICE);
		this.addListColumn("Nº Documento", "right", 100, DSBoleto.EN_BOLETO_NU_DOCUMENTO, ListView.CTYPE_READONLY);
		this.addListColumn("Agendado", "right", 80, DSBoleto.EN_BOLETO_FG_PAGAMENTO_AGENDADO , ListView.CTYPE_READONLY);
	 		
	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub

		 
		String fornecedor = (String) _cbxFornecedor.getValue();
		String valor  = _edtValorBoleto.getValue();
	 	Date dataVencimento = _edtDataVencimento.getValue();

		if (dataVencimento == null) {
			this.showErrorMessage("A data de vencimento deve ser informada!");
			return false;
		} else if (fornecedor == null) {
			this.showErrorMessage("O fornecedor deve ser informado!");
			return false;
		} else if (valor == null) {
			this.showErrorMessage("O valor deve ser informado!");
			return false;
		  
		}

		else
			return true;

	}

	@Override
	protected void beforeSave() {

		  String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		
		_DSBoleto.setEnBoletoCdEmpresa(Short.parseShort(empresa)) ;
		
		

		Timestamp dataVenc = new java.sql.Timestamp(_edtDataVencimento.getValue().getTime());
		_DSBoleto.setEnBoletoDtVencimento(dataVenc);

		if (_edtValorBoleto.getValue() != null && !(_edtValorBoleto.getValue().trim().equals(""))) {
			_DSBoleto.setEnBoletoVlBoleto(Utils.strToDouble(_edtValorBoleto.getValue()));
		} else {
			_DSBoleto.setEnBoletoVlBoleto(0);
		}

	 
	}

	@Override
	protected void onNewRecord() {
		_edtValorBoleto.setValue(null);
		_edtDataVencimento.setValue(null);

	}

	public void slotOnIncluirFornecedorClick(PeEventObject e) {

		Map<String, Object> param = new HashMap<String, Object>();
		Boolean insertModal = new Boolean(Boolean.TRUE);

		param.put(BaseControllerForm.INSERT_MODAL, insertModal);

		this.showModal("CadFornecedor", 780, 400, param, new OnCloseFornecedor());

	}

	public void slotOnAlterarFornecedorClick(PeEventObject e) {

		String[] fields = { DSFornecedor.EN_FORNECEDOR_NU_CNPJ_CPF};
		Object[] values = { _DSFornecedor
				.getEnFornecedorNuCnpjCpf(_cbxFornecedor.getSelectedIndex()) };
		Map<String, Object> param = new HashMap<String, Object>();
		{
			param.put(BaseControllerForm.INSERT_MODAL, true);
			param.put(BaseControllerForm.MODAL_KEY_FIELD, fields);
			param.put(BaseControllerForm.MODAL_KEY_VALUE, values);
		}

		this.showModal("CadFornecedor", 780, 400, param, new OnCloseFornecedor());

	}

	class OnCloseFornecedor implements ICloseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void onCloseEvent(Object e) {

			try {
				_DSFornecedor.retrieve();
			} catch (DataStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			_cbxFornecedor.populateOptions();

		}
	}
 
}

