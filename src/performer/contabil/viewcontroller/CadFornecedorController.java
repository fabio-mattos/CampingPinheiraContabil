package performer.contabil.viewcontroller;

import java.sql.SQLException;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.TextEdit;
import framework.web.gui.widget.events.ChangeEvent;
import framework.web.gui.widget.events.IChangeListener;
import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSFornecedor;
import performer.contabil.utils.Utils;

public class CadFornecedorController extends BaseControllerForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Data Store
	private DSFornecedor _DSFornecedor;

	// Visual Comps Pesquisa
	private TextEdit _edtNomePesquisa;
	private TextEdit _edtCnpjPesquisa;

	// Visual Comps
	private TextEdit _edtCnpj;
	private TextEdit _edtNome;

	private TextEdit _edtMunicipio;
	private TextEdit _edtUF;
	private TextEdit _edtCNPJ;
	private TextEdit _edtBairro;
	private TextEdit _edtEndereco;
	private TextEdit _edtFones;
	private TextEdit _edtEmail;

	private TextEdit _edtCEP;
	private TextEdit _edtNuEndereco;

	public CadFornecedorController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public CadFornecedorController(ModalArgument modalArgument) {
		super(modalArgument);

	}

	@Override
	protected String getCaption() {

		return "Cadastro de Fornecedores";

	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSFornecedor;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSFornecedor.EN_FORNECEDOR_NU_CNPJ_CPF);
		this.setDataFormInnerLayout(this.createFormLayout());

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, _DSFornecedor, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(700);
		detail.setHeight(250);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		_edtNome = new TextEdit("edtNome", this);
		{

			_edtNome.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_NM_FORNECEDOR);
		}

		_edtMunicipio = new TextEdit("edtMunicipio", this);
		{
			_edtMunicipio.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_NM_MUNICIO);
		}

		_edtUF = new TextEdit("cboxUF", this);
		_edtUF.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_CD_UF);

		_edtCNPJ = new TextEdit("edtCNPJ", this);
		{
			_edtCNPJ.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_NU_CNPJ_CPF);
			_edtCNPJ.setMask("##.###.###/####-##");
			_edtCNPJ.setChangeListener(new onChangeCNPJ());
		}

		_edtBairro = new TextEdit("edtBairro", this);
		{
			_edtBairro.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_NM_BAIRRO);
		}

		_edtEndereco = new TextEdit("edtEndereco", this);
		{
			_edtEndereco.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_DE_ENDERECO);
		}

		_edtFones = new TextEdit("edtFones", this);
		{
			_edtFones.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_NU_FONES);
		}

		_edtEmail = new TextEdit("edtEmail", this);
		{
			_edtEmail.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_DE_EMAIL);
		}

		_edtCEP = new TextEdit("edtCEP", this);
		{
			_edtCEP.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_NU_CEP);
			_edtCEP.setMaxLength(8);
		}

		_edtNuEndereco = new TextEdit("edtNuEndereco", this);
		{
			_edtNuEndereco.setColumn(_DSFornecedor, DSFornecedor.EN_FORNECEDOR_NU_ENDERECO);
		}

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 2, 8 });
		{

			detail.addField("CNPJ ", _edtCNPJ);
			detail.addField("Nome: ", _edtNome);
		}

		detail.addTable(new int[] { 3, 1 });
		{

			detail.addField("Email ", _edtEmail);
			detail.addField("Fones ", _edtFones);

		}
		detail.addTable(new int[] { 2, 1, 6 });
		{
			detail.addField("CEP ", _edtCEP);
			detail.addField("UF ", _edtUF);
			detail.addField("Município ", _edtMunicipio);

		}

		detail.addTable(new int[] { 3, 1, 3 });
		{

			detail.addField("Endereço ", _edtEndereco);
			detail.addField("Número ", _edtNuEndereco);
			detail.addField("Bairro ", _edtBairro);

		}

	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		_DSFornecedor = new DSFornecedor(this.getApplicationName());

	}

	@Override
	protected String getSQLSearch() {
		// TODO Auto-generated method stub

		String criteria = " cd_empresa  = "
				+ (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		String nome = _edtNomePesquisa.getValue();
		String cnpj = _edtCnpjPesquisa.getValue();

		if (nome != null)
			criteria = criteria + " and " + DSFornecedor.EN_FORNECEDOR_NM_FORNECEDOR + " like '%" + nome + "%' ";

		if (cnpj != null)
			criteria = criteria + " and " + DSFornecedor.EN_FORNECEDOR_NU_CNPJ_CPF + "= '" + cnpj + "' ";

		return criteria;
	}

	@Override
	protected void setupSearch() {
		setListViewSize("600", "250");
		this.initSearchFields();
		this.setSearchFields();
		this.setSearchView();
	}

	private void initSearchFields() {

		_edtNomePesquisa = new TextEdit("edtNomePesquisa", this);
		_edtNomePesquisa.setWidth(250);

		_edtCnpjPesquisa = new TextEdit("edtLetraPesquisa", this);
		_edtCnpjPesquisa.setWidth(50);

		_edtNomePesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

	}

	private void setSearchFields() {
		this.addSearchFieldComponent("Nome:", _edtNomePesquisa);
		this.addSearchFieldComponent("CNPJ:", _edtCnpjPesquisa);

	}

	private void setSearchView() {

		this.addListColumn("CNPJ", "center", 50, DSFornecedor.EN_FORNECEDOR_NU_CNPJ_CPF);
		this.addListColumn("Nome", "left", 250, DSFornecedor.EN_FORNECEDOR_NM_FORNECEDOR);

	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub

		String nome = (String) _edtNome.getValue();
		String cnpj = (String) _edtCNPJ.getValue();

		if (cnpj == null) {
			this.showErrorMessage("O CNPJ do Fornecedor deve ser informado!");
			return false;
		} else if (nome == null) {
			this.showErrorMessage("O nome do Fornecedor deve ser informado!");
			return false;
		} else
			return true;

	}

	@Override
	protected void beforeSave() {

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSFornecedor.setEnFornecedorNmFornecedor(_DSFornecedor.getEnFornecedorNmFornecedor().toUpperCase());

		_DSFornecedor.setEnFornecedorCdEmpresa(Short.parseShort(empresa_selecionada));

	}

	class onChangeCNPJ implements IChangeListener {

		@Override
		public void onChangeEvent(ChangeEvent e) {
	
			if (_edtCNPJ.getValue() != null) {
				if (!(Utils.ValidaCNPJ(_edtCNPJ.getValue()))) {
					showErrorMessage("O CNPJ " + Utils.formataCPFouCNPJ(_edtCNPJ.getValue()) + " não é um número de CNPJ válido!");
				}
			}
			
		}
	}

}
