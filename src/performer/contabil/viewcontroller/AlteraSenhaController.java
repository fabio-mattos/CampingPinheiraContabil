package performer.contabil.viewcontroller;

import java.sql.SQLException;
import java.util.Map;

import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSUsuario;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.TextEdit;

public class AlteraSenhaController extends BaseControllerForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 

	// Data Store
	private DSUsuario _DSUsuario;

	private TextEdit _EdtId_usuario;
	private TextEdit _EdtSenha;
	private TextEdit _EdtReSenha;
	private TextEdit _EdtNome;
  
    
    
    
    private TextEdit _edtNomeCompleto;
    private TextEdit _EdtEmail;
 
    private TextEdit _EdtFoneFixo;
    private TextEdit _EdtFoneCelular;
    

	
	public AlteraSenhaController() {
		this(null);
		
				
		
	}

	@SuppressWarnings("unchecked")
	public AlteraSenhaController(ModalArgument modalArgument) {
		super(modalArgument);

		Map<String, Object> arguments = (Map<String, Object>) this
				.getModalArguments();

		String _ID_Usuario = (String) PeFacesApplication.getInstance().getAttribute(DSUsuario.EN_USUARIO_ID_USUARIO   );
	      
		
		try {

			try {
				_DSUsuario.retrieve(DSUsuario.EN_USUARIO_ID_USUARIO 	+ " = '" + _ID_Usuario + "'");
				_DSUsuario.gotoFirst();
				 
				
				if (_DSUsuario.getEnUsuarioDeSenha() != null) {
				  _EdtReSenha.setValue(_DSUsuario.getEnUsuarioDeSenha());
				  _EdtSenha.setValue( _EdtReSenha.getValue());
				  
				}
				
				
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

		return "Alterar Senha";

	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSUsuario ;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSUsuario.EN_USUARIO_ID_USUARIO );


		this.setDataFormInnerLayout(this.createFormLayout());

		this.setHasSearch(false);

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this,
				_DSUsuario , true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(550);
		detail.setHeight(300);
		 
           
		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {

		_EdtNome = new TextEdit("EdtNome", this);
		{
			_EdtNome.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_ID_USUARIO);
			_EdtNome.setEnable(false);

		}

		_edtNomeCompleto = new TextEdit("edtNomeCompleto", this);
		{
			_edtNomeCompleto.setColumn(_DSUsuario,
					DSUsuario.EN_USUARIO_NM_COMPLETO);
			_edtNomeCompleto.setEnable(false);

		}

		_EdtSenha = new TextEdit("EdtSenha", this);
		{
			_EdtSenha.setMaxLength(50);
			_EdtSenha.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_DE_SENHA);
			_EdtSenha.setPasswordMode(true);
		}

		_EdtEmail = new TextEdit("EdtEmail", this);
		{
			_EdtEmail.setMaxLength(50);
			_EdtEmail.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_DE_EMAIL);

		}

		_EdtReSenha = new TextEdit("EdtSenha", this);
		{
			_EdtReSenha.setMaxLength(50);
			_EdtReSenha.setPasswordMode(true);
			
		}
		
		 

		_EdtFoneFixo = new TextEdit("EdtFoneFixo", this);
		{
			_EdtFoneFixo.setMaxLength(50);
			_EdtFoneFixo.setColumn(_DSUsuario,
					DSUsuario.EN_USUARIO_NU_FONE_FIXO);

		}

		_EdtFoneCelular = new TextEdit("EdtFoneCelular", this);
		{
			_EdtFoneCelular.setMaxLength(50);
			_EdtFoneCelular.setColumn(_DSUsuario,
					DSUsuario.EN_USUARIO_NU_FONE_CELULAR);

		}

		
 
		
		
		
    	

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1,6 });
		{
					
			detail.addField("Matricula: ", _EdtNome);
			detail.addField("Nome Completo: ", _edtNomeCompleto);
		}
		
		
		detail.addTable(new int[] { 1 });
		{
								
			
			detail.addField("Email: ", _EdtEmail);

		}

 

		detail.addTable(new int[] { 2, 2    });
		{
			detail.addField("Nova Senha: ", _EdtSenha);
			detail.addField("Redigite a Nova Senha ", _EdtReSenha);
			 

			 
		}

		detail.addTable(new int[] { 1, 1 });
		{

			detail.addField("Fone Fixo: ", _EdtFoneFixo);
			detail.addField("Fone Celular: ", _EdtFoneCelular);

		}


	}

 

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		_DSUsuario  = new DSUsuario(this.getApplicationName());

	}

	
	
	
	@Override
	protected boolean hasInsert() {
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
	 
		    String atual= (String) _EdtSenha.getValue();
		    atual = atual;
		    
			String senha = (String) _EdtSenha.getValue();
			String resenha = (String) _EdtReSenha.getValue();
	 
			
			
			if (( senha == null) || 
			    ( resenha == null)) {
				this.showErrorMessage("A nova senha devem ser digitada.");
				return false;		
			}
			
			else if ( !senha.equals(resenha) ) {
				this.showErrorMessage("A senhas digitadas estão diferentes.");
				return false;
			}  
			else
			return true;
	}

	@Override
	protected void beforeSave() {
		// TODO Auto-generated method stub
		String senha = (String) _EdtSenha.getValue();
		_DSUsuario.setEnUsuarioDeSenha(senha);
		
		 _EdtReSenha.setValue( _EdtSenha.getValue());
	 
		
		
	}

	@Override
	protected void afterSave() {
		// TODO Auto-generated method stub
		
		_EdtSenha.setValue(_DSUsuario.getEnUsuarioDeSenha());
		_EdtReSenha.setValue(_EdtSenha.getValue());
		
		
	}

	
 

 
	
	
	
}
