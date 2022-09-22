package performer.contabil.viewcontroller;



import java.sql.SQLException;
import java.util.Map;

import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSParametros;
import performer.contabil.utils.Utils;

import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ListView;
import framework.web.gui.widget.NumberEdit;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import framework.web.gui.widget.TextMemo;
import framework.web.gui.widget.events.ChangeEvent;
import framework.web.gui.widget.events.IChangeListener;

public class CadParametrosController extends BaseControllerForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Visual Comps
	private ListView _ListaPreco;

	// Data Store
	private DSParametros _DSParametros;
	private TextMemo _edtAviso;
	private TextEdit _edtFundacao;
	private TextEdit _edtCNPJ;
	private TextEdit _edtFones;
	private TextEdit _edtEmail;
	private TextEdit _edtEndereco;
	
 
	
	
	public CadParametrosController() {
		this(null);
	}

	@SuppressWarnings("unchecked")
	public CadParametrosController(ModalArgument modalArgument) {
		super(modalArgument);

		Map<String, Object> arguments = (Map<String, Object>) this
				.getModalArguments();

		
		
		try {

			try {
				_DSParametros.retrieve(DSParametros.EN_PARAMETRO_CD_PARAMETRO 	+ " = 1 ");
				_DSParametros.gotoFirst();
							
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
		
			
			
			
			
		} catch (DataStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

	@Override
	protected String getCaption() {

		return "Cadastro de Parâmetros ";

	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSParametros ;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSParametros.EN_PARAMETRO_CD_PARAMETRO  );


		this.setDataFormInnerLayout(this.createFormLayout());

		this.setHasSearch(false);

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this,
				_DSParametros , true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
        
		detail.setWidth(650);
		detail.setHeight(450);
		 
           
		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {
		_edtAviso = new TextMemo("_cbPeriodo", this);
		{ 
			_edtAviso.setWidth(500);
			_edtAviso.setHeight(300);
			_edtAviso.setColumn(_DSParametros  , DSParametros.EN_PARAMETRO_DE_AVISO     );
		}
		
	

		_edtCNPJ = new TextEdit("edtCNPJ", this);
		_edtCNPJ.setColumn(_DSParametros  , DSParametros.EN_PARAMETRO_NU_CNPJ_EMPRESA_INSTALACAO    );

		_edtEmail = new TextEdit("edtEmail", this);
		_edtEmail.setColumn(_DSParametros  , DSParametros.EN_PARAMETRO_DE_EMAIL_EMPRESA_INSTALACAO     );

		_edtFones = new TextEdit("edtFones", this);
		_edtFones.setColumn(_DSParametros  , DSParametros.EN_PARAMETRO_FONES_EMPRESA_INSTALACAO     );
		
		
		_edtFundacao  = new TextEdit("edtFundacao", this);
		_edtFundacao.setColumn(_DSParametros  , DSParametros.EN_PARAMETRO_NM_EMPRESA_INSTALACAO     );
		
		_edtEndereco  = new TextEdit("edtEndereco", this);
		_edtEndereco.setColumn(_DSParametros  , DSParametros.EN_PARAMETRO_DE_ENDERECO_EMPRESA_INSTALACAO );
		
		
		
		
	
	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 3,1 });
		{
			detail.addField("Nome Instalação:  ", _edtFundacao);
			detail.addField("CNPJ:  ", _edtCNPJ);
		}

		detail.addTable(new int[] { 1 });
		{
			detail.addField("Enderço:  ", _edtEndereco);
			
		}
		detail.addTable(new int[] { 1, 1 });
		{
			detail.addField("Fones:  ", _edtFones);
			detail.addField("Email:  ", _edtEmail);
		}
		

		detail.addTable(new int[] { 1 });
		{
			detail.addField("Aviso tela de Entrada:  ", _edtAviso);
			 
		}

	}

 

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		_DSParametros  = new DSParametros(this.getApplicationName());
		_DSParametros.retrieve();
		
 

	}

	
	
	
	@Override
	protected boolean hasInsert() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected boolean hasNew() {
		// TODO Auto-generated method stub
		return false;
	}
 


	@Override
	protected boolean hasDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getSQLSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setupSearch() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub
	 
		   
			return true;
	}

	@Override
	protected void beforeSave() {
		// TODO Auto-generated method stub
 
				
	}


	 
	
	
}
