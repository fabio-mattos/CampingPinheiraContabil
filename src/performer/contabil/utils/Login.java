package performer.contabil.utils;
 

import java.sql.Date;

import com.performer.faces.PeFacesApplication;

import performer.contabil.persistence.DSUsuario;

public class Login {

	public final static String USER_ACCESS_PERMISSIONS = "USER_ACCESS";

	public final static int ACCESS_ALLOWED = 0;
	public final static int ACCESS_DENIED = 1;
	public final static int ACCESS_FAILED = 2;

	public int checkLoginData(String userName, String password) {

		try {

			UsuarioManager umngr = new UsuarioManager(PeFacesApplication.getInstance().getName());

	   if (umngr.loginExists(userName, password)) {

		 
				DSUsuario dsUsuario = umngr.getDSUsuario();
				dsUsuario.gotoFirst();
			
			
			 

				return ACCESS_ALLOWED;

			} else {

				return ACCESS_DENIED;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return ACCESS_FAILED;

		}
	}

	 

	class UsuarioManager {

		private String _appName;
		private DSUsuario _dsUsuario;

		public UsuarioManager(String appName) {

			_appName = appName;

		}

		public boolean loginExists(String login, String pass) {

			if (_dsUsuario == null) {

				_dsUsuario = new DSUsuario(_appName);

			}

			try {
				_dsUsuario.retrieve(DSUsuario.EN_USUARIO_ID_USUARIO + " = '" + login + "'" + " AND " + DSUsuario.EN_USUARIO_DE_SENHA + " = '" + pass + "'" + " AND "
						+ DSUsuario.EN_USUARIO_FG_ATIVO + " = 1 ");

				
				
			
				
				return (_dsUsuario.gotoNext());

			} catch (Exception e) {

				e.printStackTrace();
				return false;

			}
			
		
			
			
			
			
		}

		public DSUsuario getDSUsuario() {

			return _dsUsuario;

		}

	}

	public String getApplicationName() {
		return PeFacesApplication.getInstance().getName();
	}

}
