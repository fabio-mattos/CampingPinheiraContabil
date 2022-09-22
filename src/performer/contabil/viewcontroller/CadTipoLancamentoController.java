package performer.contabil.viewcontroller;

import java.sql.SQLException;
import java.text.Normalizer;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSEmpresa;
import performer.contabil.persistence.DSTipoLancamento;

public class CadTipoLancamentoController extends BaseControllerForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Data Store
	private DSTipoLancamento _DSTipoLancamento;
	private DSEmpresa _DSEmpresa;
	private DSEmpresa _DSEmpresaPesquisa;

	// Visual Comps Pesquisa
	private TextEdit _edtNomePesquisa;
	private TextEdit _edtCodigoPesquisa;
	private ComboBoxLookup _cbxEmpresaPesquisa;
	private Text _txtBrancoPesquisa;

	// Visual Comps
	private TextEdit _edtCodigo;
	private TextEdit _edtNome;
	private ComboBoxLookup _cbxAtivo;
	private ComboBoxLookup _cbxEmpresa;

	private Text _txtBranco1;

	public CadTipoLancamentoController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public CadTipoLancamentoController(ModalArgument modalArgument) {
		super(modalArgument);

	}

	@Override
	protected String getCaption() {

		return "Cadastro Tipos de Lancamento";

	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSTipoLancamento;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO);
		this.setDataFormInnerLayout(this.createFormLayout());

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, _DSTipoLancamento, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(720);
		detail.setHeight(250);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		
		_cbxEmpresa = new ComboBoxLookup("empresa", this);
		{
			_cbxEmpresa.setLookupInfo(_DSEmpresa, DSEmpresa.EN_EMPRESA_CD_EMPRESA, DSEmpresa.EN_EMPRESA_DE_SIGLA);
			_cbxEmpresa.setValue(empresa);
			_cbxEmpresa.setEnable(false);
		}

		
		_edtCodigo = new TextEdit("codigo", this);
		{
			_edtCodigo.setReadOnly(true);
			_edtCodigo.setWidth(100);
			_edtCodigo.setColumn(_DSTipoLancamento,
					DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO);
		}

		_edtNome = new TextEdit("nome", this);
		{
			_edtNome.setColumn(_DSTipoLancamento,
					DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
		}

		_cbxAtivo = new ComboBoxLookup("ativo", this);
		_cbxAtivo.addOption("S", "Sim");
		_cbxAtivo.addOption("N", "Não");
		_cbxAtivo.setColumn(_DSTipoLancamento, DSTipoLancamento.EN_TIPO_LANCAMENTO_FG_ATIVO);

		_txtBranco1 = new Text("", this);

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1, 3,3 });
		{
			detail.addField("Código: ", _edtCodigo);
			detail.addField("Empresa: ", _cbxEmpresa);
			detail.addField("Ativo? ", _cbxAtivo);
		}

		detail.addTable(new int[] { 1 });
		{

			detail.addField("Nome: ", _edtNome);

		}

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {
		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		_DSTipoLancamento = new DSTipoLancamento(this.getApplicationName());

		_DSEmpresa = new DSEmpresa(this.getApplicationName());
		_DSEmpresa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa );

		_DSEmpresaPesquisa = new DSEmpresa(this.getApplicationName());
		_DSEmpresaPesquisa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa );
	}

	@Override
	protected String getSQLSearch() {
		// TODO Auto-generated method stub

		String criteria = "0 = 0";

		String nome = _edtNomePesquisa.getValue();
		String codigo = _edtCodigoPesquisa.getValue();
		String empresa = (String) _cbxEmpresaPesquisa.getValue();

		criteria = criteria + " and  " + DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO
				+ " > 0 ";

		if (empresa == null) {
			criteria = criteria + " and  " + DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO
					+ " = -1 ";
			 
		} else {

			criteria = criteria + " and  " + DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA
					+ " =  " + empresa + " ";

		}

		if (nome != null) {
			nome = nome.toUpperCase();
			nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
			nome = nome.replaceAll("[^\\p{ASCII}]", "");
		}

		if (nome != null)
			criteria = criteria + " and lower(sem_acento("
					+ DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO + ")) like   '%"
					+ nome.toLowerCase() + "%'";

		if (codigo != null)
			criteria = criteria + " and " + DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO + "= "
					+ codigo + " ";

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
		
		

		_txtBrancoPesquisa = new Text("", this);

		_edtNomePesquisa = new TextEdit("edtNomePesquisa", this);
		_edtNomePesquisa.setWidth(250);

		_edtCodigoPesquisa = new TextEdit("edtLetraPesquisa", this);
		_edtCodigoPesquisa.setWidth(50);

		_edtNomePesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

	}

	private void setSearchFields() {
		this.addSearchFieldComponent("Empresa:", _cbxEmpresaPesquisa);
		this.addSearchFieldComponent("Nome Tipo Lançamento:", _edtNomePesquisa);
		this.addSearchFieldComponent("Código:", _edtCodigoPesquisa);
		this.addSearchFieldComponent(" ", _txtBrancoPesquisa);

	}

	private void setSearchView() {

		this.addListColumn("Código", "center", 50,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO);
		this.addListColumn("Empresa", "left", 100, DSTipoLancamento.EN_EMPRESA_DE_SIGLA);
		this.addListColumn("Nome Tipo de Lançamento ", "left", 250,
				DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);

	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub

		String nome = (String) _edtNome.getValue();
		 

		 if (nome == null) {
			this.showErrorMessage("O nome do Tipo de lançamento deve ser informado!");
			return false;
		} else
			return true;

	}

	@Override
	protected void beforeSave() {
		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		
		_DSTipoLancamento.setEnTipoLancamentoCdEmpresa(Short.parseShort(empresa_selecionada));
		

		
		_DSTipoLancamento.setEnTipoLancamentoNmTipoLancamento(_edtNome.getValue().toUpperCase());

	
		if ((String) _cbxAtivo.getValue() == null) {
			_DSTipoLancamento.setEnTipoLancamentoFgAtivo("S");
		}

	}

}
