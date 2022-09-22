package performer.contabil.viewcontroller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import performer.contabil.controller.BaseControllerModal;
import performer.contabil.persistence.DSParametros;
import performer.contabil.persistence.DSUsuario;
import performer.contabil.utils.Criptografia;

import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;

public class EsqueciMinhaSenhaController extends BaseControllerModal {

	
	private PeButton _btnSair;
	private PeButton _btnEnviarSenha;
	private TextEdit _EdtUsuario;
	private DSUsuario _DSUsuario;
	private DSParametros _DSParametros;
	private Text _texto_branco1;
	DateFormat df = new SimpleDateFormat("HHmm");  
	String novaSenha = df.format(new Date());
	
	@Override
	protected void onShowModal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub
		return "Esqueci minha senha";
	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {
		// TODO Auto-generated method stub
		_DSUsuario  = new DSUsuario(this.getApplicationName());
		
		_DSParametros  = new DSParametros(this.getApplicationName());
		_DSParametros.retrieve(DSParametros.EN_PARAMETRO_CD_PARAMETRO + " = 1");
	}

	@Override
	protected PeWidget<?> getViewComponent() {
		// TODO Auto-generated method stub
		BasicDetail detail = new BasicDetail("$detail$", this, _DSUsuario, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(525);
		detail.setHeight(100);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;
	}
	
	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1 });
		{

			detail.addField("Informe seu nome de usuário que foi cadastrado no CSP - CONTROLE SALDO DE PROJETOS", _EdtUsuario);
		}

		detail.addTable(new int[] { 1,1,10 });
		{
			detail.addField(" ",  _btnEnviarSenha  );
	    	detail.addField(" ",  _btnSair  );
	    	detail.addField(" ",  _texto_branco1);
		}
	}
		
	

	
	private void initVisualComps() {
		_EdtUsuario = new TextEdit("EdtUsuario", this);
		_EdtUsuario.setFocus();
		
		PeButton.Attributes attr = new PeButton.Attributes();
		attr.setText("Sair");
		_btnSair = new PeButton(attr);
		_btnSair.addEventListener(PeButton.CLICK, new PeDelegate(this,
				"slotSairClick"));
		
		attr.setText("Enviar Senha");
		_btnEnviarSenha = new PeButton(attr);
		_btnEnviarSenha.addEventListener(PeButton.CLICK, new PeDelegate(this,
				"slotEnviarSenhaClick"));
	
		_texto_branco1 = new Text(" ", this);
	}
	
	
	public void slotSairClick(PeEventObject e) {

	   this.close();
	}
	
	public void slotEnviarSenhaClick(PeEventObject e) {

		   if (_EdtUsuario.getValue() != null) {
			   
			   try {
				_DSUsuario.retrieve("lower(" + DSUsuario.EN_USUARIO_ID_USUARIO + ") = '" + _EdtUsuario.getValue().toLowerCase() + "'");
			} catch (DataStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   
			   
			    if (_DSUsuario.getRowCount() != 1) {
				  this.showErrorMessage("Não há usuário cadastrado com o nome " + _EdtUsuario.getValue() + ". <br> <br> Verifique se o nome foi digitado corretamente!");
		    	} else {
		    		
		    		       _DSUsuario.setEnUsuarioDeSenha(0, novaSenha);
		    		       try {
							_DSUsuario.update();
						} catch (DataStoreException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
		    		       
		    		    try {
		    		    	
							 sendEmail(); 
							 this.showWarningMessage("Sua nova senha de acesso ao  CSP foi enviada para o email " + _DSUsuario.getEnUsuarioDeEmail(0));		    		    	
		    		    	
						} catch (EmailException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							this.showErrorMessage("Não foi possível o envio do email com sua nova senha! Tente Novamente!");
						}
		    		    
		    		       
		    		       
		            	}
			
			
		   } else 	
			 this.showWarningMessage("Informe um email para solicitar a recuperação de senha!");
			
		}
	
	public void sendEmail() throws EmailException {
	    
		   SimpleEmail email = new SimpleEmail();
		   
		   
		   
		   //Utilize o hostname do seu provedor de email
		  email.setHostName(_DSParametros.getEnParametroEmailPerformerHostname(0));
		   //Quando a porta utilizada n�o � a padr�o (gmail = 465)
		   email.setSmtpPort(_DSParametros.getEnParametroEmailPerformerSmtpport(0));
		   //Adicione os destinat�rios
		   email.addTo(_DSUsuario.getEnUsuarioDeEmail(0), "Recuperação Senha");
		   //Configure o seu email do qual enviar�
		   email.setFrom(_DSParametros.getEnParametroEmailPerformerFrom(0) , "CSP - Controle Saldo de Projetos");
		   //Adicione um assunto
		   email.setSubject("Recuperação senha do sistema CSP - Controle Saldo de Projetos");
		   //Adicione a mensagem do email
		   email.setMsg("Sua nova senha para acesso ao CSP é: " + "\n\n" 
		                + " Usuário: " + _DSUsuario.getEnUsuarioIdUsuario(0) +	"\n"   
		                + " Senha: " + novaSenha  +  "\n\n" 
		                + "\n\n"
						+ "OBS: Caso use o navegador  Chrome e tenha mandado salvar a senha, "
						+  " exclua o histórico de senhas desde o início do navegado, antes de digitar a senha nova. "
						+  " Sem esse procedimento o navegador pode acusar Usuário ou Senha Inválida, mesmo os dados estando corretos." 
						+ "\n\n"
						+ "COMO LIMPAR HISTÓRICO DE SENHAS DO CHROME \n" 
						+ "[Passo 1] Clique sobre o ícone de menu do Google Chrome  (3 traços no canto superior direito) \n"
						+ "[Passo 2] Em seguida, em “Histórico” e “Histórico” novamente, ou digite CRTL + H. \n"  
						+ "[Passo 3] Clique em “Limpar dados de navegação…”; \n" 
						+ "[Passo 4] Em 'Eliminar os seguintes itens desde', selecione a opção “desde o começo”. "  
						+ "          Desta maneira, todo o histórico de navegação será apagado. Caso não queira apagar tudo,"   
						+ "          escolha uma opção diferente da lista, marcando pelo menos a opção senhas; \n" 
						+ "[Passo 5] Para terminar, clique em “Limpar dados de navegação” e aguarde até que o processo termine.\n\n"  
						+ " Observação: Este é um email automático, favor não responder.");
		   //Para autenticar no servidor � necess�rio chamar os dois m�todos abaixo
		   
		   email.setAuthentication(_DSParametros.getEnParametroEmailPerformerUser(0) , _DSParametros.getEnParametroEmailPerformerPassword(0));
		   email.send();
		 }
}
