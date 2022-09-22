package performer.contabil.viewcontroller;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeImage;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import framework.web.gui.widget.events.ICloseListener;
import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSEmpresa;
import performer.contabil.persistence.DSHistoricoLancamento;
import performer.contabil.persistence.DSTipoLancamento;

public class CadHistoricoLancamentosController extends BaseControllerForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Data Store
	private DSHistoricoLancamento _DSHistoricoLancamento;
	private DSEmpresa _DSEmpresa;
	private DSEmpresa _DSEmpresaPesquisa;
	private DSTipoLancamento _DSTipoLancamento;
	private DSTipoLancamento _DSTipoLancamentoPesquisa;

	// Visual Comps Pesquisa
	private TextEdit _edtNomePesquisa;
	private TextEdit _edtCodigoPesquisa;
	private ComboBoxLookup _cbxEmpresaPesquisa;
	private ComboBoxLookup _cbxTipoPesquisa;
	private Text _txtBrancoPesquisa;

	// Visual Comps
	private TextEdit _edtCodigo;
	private TextEdit _edtNome;
	private ComboBoxLookup _cbxAtivo;
	private ComboBoxLookup _cbxEmpresa;
	private ComboBoxLookup _cbxTipo;
	
	private PeImage _btnIncluirTipo;
	private PeImage _btnAlterarTipo;

	private Text _txtBranco1;

	public CadHistoricoLancamentosController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public CadHistoricoLancamentosController(ModalArgument modalArgument) {
		super(modalArgument);

	}

	@Override
	protected String getCaption() {

		return "Cadastro de Históricos de Lancamentos";

	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSHistoricoLancamento;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO);
		this.setDataFormInnerLayout(this.createFormLayout());

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, _DSHistoricoLancamento, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(720);
		detail.setHeight(320);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {
		
		PeImage.Attributes attrs = new PeImage.Attributes();
		attrs.setImage("images/pag_add.gif");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE);
		_btnIncluirTipo= new PeImage(attrs);
		_btnIncluirTipo.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotOnIncluirTipoClick"),
				EventType.WAIT);
		_btnIncluirTipo.setHint("Clique aqui para incluir um novo tipo de lançamento.");

		attrs.setImage("images/pag_edit.gif");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE);
		_btnAlterarTipo = new PeImage(attrs);
		_btnAlterarTipo.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotOnAlterarTipoClick"),
				EventType.WAIT);
		_btnAlterarTipo.setHint("Clique aqui para alterar o tipo selecionado  na listagem.");
		
		
		

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_cbxEmpresa = new ComboBoxLookup("empresa", this);
		{
			_cbxEmpresa.setLookupInfo(_DSEmpresa, DSEmpresa.EN_EMPRESA_CD_EMPRESA, DSEmpresa.EN_EMPRESA_DE_SIGLA);
			_cbxEmpresa.setValue(empresa);
			_cbxEmpresa.setEnable(false);
		}

		_cbxTipo = new ComboBoxLookup("tipo", this);
		{
			_cbxTipo.setLookupInfo(_DSTipoLancamento, DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO,
					DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
			_cbxTipo.setColumn(_DSHistoricoLancamento,
					DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO);
		}

		_edtCodigo = new TextEdit("codigo", this);
		{
			_edtCodigo.setReadOnly(true);
			_edtCodigo.setWidth(100);
			_edtCodigo.setColumn(_DSHistoricoLancamento,
					DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO);
		}

		_edtNome = new TextEdit("nome", this);
		{
			_edtNome.setColumn(_DSHistoricoLancamento,
					DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
		}

		_cbxAtivo = new ComboBoxLookup("ativo", this);
		_cbxAtivo.addOption("S", "Sim");
		_cbxAtivo.addOption("N", "Não");
		_cbxAtivo.setColumn(_DSHistoricoLancamento, DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_FG_ATIVO);

		_txtBranco1 = new Text("", this);

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1, 3, 3 });
		{
			detail.addField("Código: ", _edtCodigo);
			detail.addField("Empresa: ", _cbxEmpresa);
			detail.addField("Ativo? ", _cbxAtivo);
		}

		detail.addTable(new int[] { 1 });
		{

			detail.addField("Nome: ", _edtNome);
		}
		detail.addTable(new int[] { 30,1,1 });
		{
			detail.addField("Tipo Lançamento: ", _cbxTipo);
			detail.addField(". ", _btnIncluirTipo);
			detail.addField(". ", _btnAlterarTipo);
		}

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		_DSHistoricoLancamento = new DSHistoricoLancamento(this.getApplicationName());

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSEmpresa = new DSEmpresa(this.getApplicationName());
		_DSEmpresa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa);

		_DSEmpresaPesquisa = new DSEmpresa(this.getApplicationName());
		_DSEmpresaPesquisa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa);

		_DSTipoLancamentoPesquisa = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamentoPesquisa.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa);

		_DSTipoLancamento = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamento.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa);

	}

	@Override
	protected String getSQLSearch() {
		// TODO Auto-generated method stub

		String criteria = "0 = 0";

		String nome = _edtNomePesquisa.getValue();
		String codigo = _edtCodigoPesquisa.getValue();
		String empresa = (String) _cbxEmpresaPesquisa.getValue();
		String tipo = (String) _cbxTipoPesquisa.getValue();
 
		criteria = criteria + " and  " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO
				+ " > 0 ";

		if (empresa == null) {
			criteria = criteria + " and  " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO
					+ " = -1 ";
			 
		} else {

			criteria = criteria + " and  " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_EMPRESA
					+ " =  " + empresa + " ";

		}

		if (nome != null) {
			nome = nome.toUpperCase();
			nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
			nome = nome.replaceAll("[^\\p{ASCII}]", "");
		}

		if (nome != null) {
			criteria = criteria + " and lower(sem_acento("
					+ DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO + ")) like   '%"
					+ nome.toLowerCase() + "%'";
		}

		if (codigo != null) {
			criteria = criteria + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO + "= "
					+ codigo + " ";
		}
		
		if (tipo != null) {
			criteria = criteria + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO + "= "
					+ tipo + " ";
		}
		return criteria;
	}

	@Override
	protected void setupSearch() {
		setListViewSize("750", "250");
		this.initSearchFields();
		this.setSearchFields();
		this.setSearchView();
	}

	private void initSearchFields() {

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_cbxEmpresaPesquisa = new ComboBoxLookup("empresap", this);
		{
			_cbxEmpresaPesquisa.setLookupInfo(_DSEmpresaPesquisa, DSEmpresa.EN_EMPRESA_CD_EMPRESA,
					DSEmpresa.EN_EMPRESA_DE_SIGLA);
			_cbxEmpresaPesquisa.setEnable(false);
			_cbxEmpresaPesquisa.setValue(empresa);
		}
		
		_cbxTipoPesquisa = new ComboBoxLookup("tipop", this);
		{
			_cbxTipoPesquisa.setLookupInfo(_DSTipoLancamentoPesquisa, DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO,
					DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
			 
		}

		_txtBrancoPesquisa = new Text("", this);

		_edtNomePesquisa = new TextEdit("edtNomePesquisa", this);
		_edtNomePesquisa.setWidth(250);

		_edtCodigoPesquisa = new TextEdit("edtLetraPesquisa", this);
		_edtCodigoPesquisa.setWidth(50);

		_edtNomePesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

	}

	private void setSearchFields() {
		this.addSearchFieldComponent("Empresa:", _cbxEmpresaPesquisa);
		this.addSearchFieldComponent("Nome do Histórico:", _edtNomePesquisa);
		this.addSearchFieldComponent("Tipo Lançamento ", _cbxTipoPesquisa);
		this.addSearchFieldComponent("Código:", _edtCodigoPesquisa);
		

	}

	private void setSearchView() {

		this.addListColumn("Código", "center", 50,	DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO);
		this.addListColumn("Empresa", "left", 100, DSHistoricoLancamento.EN_EMPRESA_DE_SIGLA);
		this.addListColumn("Nome do Histórico", "left", 150,DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
		this.addListColumn("Tipo Lançamento", "left", 100,DSHistoricoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);

	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub

		String nome = (String) _edtNome.getValue();
		String tipo = (String) _cbxTipo.getValue();

		if (nome == null) {
			this.showErrorMessage("O nome do histórico de lançamento deve ser informado!");
			return false;
		} if (tipo == null) {
			this.showErrorMessage("O nome do tipo de lançamento deve ser informado!");
			return false;
		}  else
			return true;

	}

	@Override
	protected void beforeSave() {
		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSHistoricoLancamento.setEnHistoricoLancamentoCdEmpresa(Short.parseShort(empresa_selecionada));

		_DSHistoricoLancamento.setEnHistoricoLancamentoNmHistoricoLancamento(_edtNome.getValue().toUpperCase());

		if ((String) _cbxAtivo.getValue() == null) {
			_DSHistoricoLancamento.setEnHistoricoLancamentoFgAtivo("S");
		}

	}
	public void slotOnIncluirTipoClick(PeEventObject e) {

		Map<String, Object> param = new HashMap<String, Object>();
		Boolean insertModal = new Boolean(Boolean.TRUE);

		param.put(BaseControllerForm.INSERT_MODAL, insertModal);

		this.showModal("CadTipoLancamento", 800, 600, param, new OnCloseTipo());

	}

	public void slotOnAlterarTipoClick(PeEventObject e) {

		String[] fields = { DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO };
		Object[] values = { _DSTipoLancamento
				.getEnTipoLancamentoCdTipoLancamento(_cbxTipo.getSelectedIndex()) };
		Map<String, Object> param = new HashMap<String, Object>();
		{
			param.put(BaseControllerForm.INSERT_MODAL, true);
			param.put(BaseControllerForm.MODAL_KEY_FIELD, fields);
			param.put(BaseControllerForm.MODAL_KEY_VALUE, values);
		}

		this.showModal("CadTipoLancamento", 850, 500, param, new OnCloseTipo());

	}

	class OnCloseTipo implements ICloseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void onCloseEvent(Object e) {
			String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
			try {
				_DSTipoLancamento.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_FG_ATIVO
						+ " = 'S' AND " + DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA +" = " + empresa_selecionada);
			} catch (DataStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			_cbxTipo.populateOptions();

		}
	}
}
