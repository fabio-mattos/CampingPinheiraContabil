package performer.contabil.viewcontroller;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;

import com.performer.core.IPeEventListener;
import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeMessages;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DBConnection;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.ListView;
import framework.web.gui.widget.TabBar;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import framework.web.gui.widget.events.ChangeEvent;
import framework.web.gui.widget.events.IChangeListener;
import framework.web.util.NotifyDelegate;
import framework.web.util.NotifyEvent;
import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSModulo;
import performer.contabil.persistence.DSPerfilUsuario;
import performer.contabil.persistence.DSTipoPerfil;
import performer.contabil.persistence.DSUsuario;

public class CadUsuarioController extends BaseControllerForm {

	private TabBar _tabbar;
	private DSModulo _DSModulo;
	
	private DSUsuario _DSUsuario;
	private DSPerfilUsuario _DSPerfilUsuario;
	private DSTipoPerfil _DSTipoPerfil;

	private ComboBoxLookup _cbxModulo;
	

	private ListView _listaPerfil;

	private TextEdit _edtIDPesquisa;
	private TextEdit _edtNomePesquisa;
	
	private ComboBoxLookup _cboxAtivoPesquisa;

	private TextEdit _edtID;
	private TextEdit _edtSenha;
	private TextEdit _edtReSenha;
		private TextEdit _edtNome;
	private TextEdit _edtEmail;

	private ComboBoxLookup _cboxPerfil;
	private ComboBoxLookup _cboxAtivo;
	private PeButton _btnVerSenha;
	private PeButton _btnTodos;
	private PeButton _btnNenhum;

	private Text _branco;
	private Text _branco2;
	private Text _branco3;

	public CadUsuarioController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public CadUsuarioController(ModalArgument modalArgument) {
		super(modalArgument);

	}

	@Override
	protected String getCaption() {

		return "Cadastro de Usuários";

	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSUsuario;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSUsuario.EN_USUARIO_ID_USUARIO);
		this.setDataFormInnerLayout(this.createFormLayout());

	}

	private PeWidget<?> createFormLayout() {

		_tabbar = new TabBar("$tabBar$", this);
		_tabbar.setWidth(780);
		_tabbar.setTabBarChangeListener(new NotifyDelegate(this, "onTabBarChange"));

		this.initVisualComps();
		this.addVisualComps(_tabbar);

		return _tabbar;

	}

	private void initVisualComps() {


		_branco = new Text("", this);
		_branco2 = new Text("", this);
		_branco3 = new Text("", this);

		_edtNome = new TextEdit("EdtNome", this);
		{

			_edtNome.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_NM_COMPLETO);

		}

 

		_edtID = new TextEdit("edtID", this);
		{
			_edtID.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_ID_USUARIO);
			 
		}

		_edtSenha = new TextEdit("EdtSenha", this);
		{
			_edtSenha.setMaxLength(50);
			_edtSenha.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_DE_SENHA);
			_edtSenha.setPasswordMode(true);
		}

		_edtEmail = new TextEdit("EdtEmail", this);
		{
			_edtEmail.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_DE_EMAIL);

		}

		_edtReSenha = new TextEdit("EdtSenha", this);
		{
			_edtReSenha.setMaxLength(50);
			_edtReSenha.setPasswordMode(true);
			_edtReSenha.setWidth(100);
		}

		_cboxPerfil = new ComboBoxLookup("CboxAdministrador", this);
		_cboxPerfil.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_CD_PERFIL);
		_cboxPerfil.setLookupInfo(_DSTipoPerfil, DSTipoPerfil.en_tipo_perfil_cd_tipo_perfil,
				DSTipoPerfil.en_tipo_perfil_nm_tipo_perfil);

		_cboxPerfil.setChangeListener(new onChangePerfil());

		_cboxAtivo = new ComboBoxLookup("CboxAtivo", this);
		_cboxAtivo.setColumn(_DSUsuario, DSUsuario.EN_USUARIO_FG_ATIVO);
		_cboxAtivo.addOption("1", "Sim");
		_cboxAtivo.addOption("2", "Não");

		PeButton.Attributes attr = new PeButton.Attributes();
		attr.setText("Ver Senha");
		_btnVerSenha = new PeButton(attr);
		_btnVerSenha.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotVerSenhaClick"));

		attr.setText("Marcar Todos");
		_btnTodos = new PeButton(attr);
		_btnTodos.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotTodosClick"));

		attr.setText("Desmarcar Todos");
		_btnNenhum = new PeButton(attr);
		_btnNenhum.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotNenhumClick"));

		_cbxModulo = new ComboBoxLookup("Modulos", this);
		_cbxModulo.setLookupInfo(_DSModulo, DSModulo.en_modulo_cd_modulo, DSModulo.en_modulo_nm_modulo);
		_cbxModulo.setChangeListener(new onChangeModulo());

		_listaPerfil = new ListView("listaPerfil", this);
		_listaPerfil.setVScrollAlwaysVisible(true);
		_listaPerfil.setDataStore(_DSPerfilUsuario);

		_listaPerfil.addColumn(DSPerfilUsuario.en_perfil_fg_acesso, ListView.CTYPE_CHECK, "Acesso", 50, "center",
				"white");
		_listaPerfil.addColumn("cel_color", ListView.CTYPE_CELLCOLOR(0), "", 0, "",
				DSPerfilUsuario.en_perfil_fg_acesso);

		_listaPerfil.addColumn(DSPerfilUsuario.vw_item_modulo_nm_modulo, ListView.CTYPE_READONLY, "Módulo ", 50, "left",
				"white");
		_listaPerfil.addColumn("cel_color", ListView.CTYPE_CELLCOLOR(2), "", 0, "",
				DSPerfilUsuario.vw_item_modulo_nm_modulo);

		_listaPerfil.addColumn(DSPerfilUsuario.vw_item_modulo_item, ListView.CTYPE_READONLY, "Item Menu  ", 400, "left",
				"white");
		_listaPerfil.addColumn("cel_color", ListView.CTYPE_CELLCOLOR(4), "", 0, "",
				DSPerfilUsuario.vw_item_modulo_item);

		_listaPerfil.addColumn(DSPerfilUsuario.vw_item_modulo_cd_item_modulo, ListView.CTYPE_READONLY, "Código", 50,
				"center", "white");
		_listaPerfil.addColumn("cel_color", ListView.CTYPE_CELLCOLOR(6), "", 0, "",
				DSPerfilUsuario.vw_item_modulo_cd_item_modulo);

		// _listaPerfil.setWidth(600);
		_listaPerfil.setHeight(230);

		_listaPerfil.addEventListener(ListView.ROW_SELECTED, new PeDelegate(this, "slotLinhaSeleciona"));

	}

	class onChangePerfil implements IChangeListener {
		private static final long serialVersionUID = 1L;

		@Override
		public void onChangeEvent(ChangeEvent e) {

			PeMessages.confirmDialog("Confirmação",
					"Deseja Realmente transformar o perfil do usuário  " + _DSUsuario.getEnUsuarioNmCompleto()
							+ " para o Perfil : " + _cboxPerfil.getOptionValue(_cboxPerfil.getSelectedIndex()) + "?",

					new IPeEventListener() {

						private static final long serialVersionUID = 1L;

						public void handleEvent(PeEventObject event) {
							if (event.getString(PeMessages.PARAM_CLICKED) == "OK") {

								try {
									_DSUsuario.update();
								} catch (DataStoreException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

								DBConnection con = null;
								Statement stmt = null;

								try {
									con = DBConnection.getConnection(getApplicationName());
									stmt = con.createStatement();

									// Limpando os Modulos
									stmt.execute(
											" SELECT \"public\".\"geraPerfilTipoUsuario\" ('"
													+ _DSUsuario.getEnUsuarioIdUsuario() + "','" + _DSTipoPerfil
															.geten_tipo_perfil_cd_string(_cboxPerfil.getSelectedIndex())
													+ "');");

									// sqlBuffer = null;
								} catch (SQLException ex) {
									// TODO Auto-generated catch block
									ex.printStackTrace();
								} finally {
									if (con != null) {
										con.freeConnection();
										con = null;
									}
									if (stmt != null) {
										try {
											stmt.close();
										} catch (SQLException ex) {
											// TODO Auto-generated catch block
											ex.printStackTrace();
										}
										stmt = null;
									}

								}

								try {
									_DSPerfilUsuario.retrieve(DSPerfilUsuario.en_perfil_id_usuario + " = '"
											+ _DSUsuario.getEnUsuarioIdUsuario() + "' ");
								} catch (DataStoreException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}

							atualizaCor();

						}

					});
		}
	}

	protected void slotLinhaSeleciona(PeEventObject e) {

	}

	private void addVisualComps(final TabBar tab) {

		BasicDetail detail_usuario = new BasicDetail("$detail$", this, _DSUsuario, true);
		detail_usuario.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail_usuario.setCaptionTop(true);
		detail_usuario.setWidth(750);
		detail_usuario.setHeight(350);

		BasicDetail detail_perfil = new BasicDetail("$detail$", this, _DSUsuario, true);
		detail_perfil.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail_perfil.setCaptionTop(true);
		detail_perfil.setWidth(750);
		detail_perfil.setHeight(350);

		detail_usuario.addTable(new int[] { 1});
		{

			detail_usuario.addField("Login: ", _edtID);
			 
		}
		detail_usuario.addTable(new int[] { 1 });
		{
			detail_usuario.addField("Nome Completo: ", _edtNome);
		}

		detail_usuario.addTable(new int[] { 1 });
		{

			detail_usuario.addField("Email:", _edtEmail);

		}

		detail_usuario.addTable(new int[] { 3, 1, 3 });
		{
			detail_usuario.addField("Senha: ", _edtSenha);
			detail_usuario.addField(". ", _btnVerSenha);
			detail_usuario.addField("Redigite a Senha ", _edtReSenha);
		}

		detail_usuario.addTable(new int[] { 1, 1 });
		{

			detail_usuario.addField("Usuário Ativo:", _cboxAtivo);
			detail_usuario.addField(" ", _branco2);
		}

		detail_perfil.addTable(new int[] { 1});
		{
			detail_perfil.addField("Perfil: ", _cboxPerfil);
			
		}
		detail_perfil.addTable(new int[] { 1 });
		{
			detail_perfil.addField(" ", _listaPerfil);

		}
		detail_perfil.addTable(new int[] { 1, 1, 6 });
		{
			detail_perfil.addField(" ", _btnTodos);
			detail_perfil.addField(" ", _btnNenhum);
			detail_perfil.addField(" ", _branco);
		}

		tab.addTab("Dados do Usuário", detail_usuario);
		tab.addTab("Perfil", detail_perfil);
	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		_DSUsuario = new DSUsuario(this.getApplicationName());

		_DSPerfilUsuario = new DSPerfilUsuario(this.getApplicationName());
		_DSPerfilUsuario.addBucket("cel_color", DataStore.DATATYPE_STRING);

		_DSModulo = new DSModulo(this.getApplicationName());
		_DSModulo.retrieve();

		_DSTipoPerfil = new DSTipoPerfil(this.getApplicationName());
		_DSTipoPerfil.retrieve();



	}

	@Override
	protected String getSQLSearch() {
		// TODO Auto-generated method stub

		String criteria = "0 = 0";
	
		String nome = _edtNomePesquisa.getValue();
		String id = _edtIDPesquisa.getValue();
		String ativo = (String) _cboxAtivoPesquisa.getValue();

		if (nome != null) {

			nome = nome.toUpperCase();
			nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
			nome = nome.replaceAll("[^\\p{ASCII}]", "");

			criteria = criteria + " and upper(sem_acento(" + DSUsuario.EN_USUARIO_NM_COMPLETO + ")) like '%" + nome
					+ "%'";
		}

		if (id != null)
			criteria = criteria + " and " + DSUsuario.EN_USUARIO_ID_USUARIO + " = '" + id + "' ";

		if (ativo != null)
			criteria = criteria + " and " + DSUsuario.EN_USUARIO_FG_ATIVO + " = '" + ativo + "' ";


 
		return criteria;
	}

	@Override
	protected void setupSearch() {
		setListViewSize("700", "250");
		this.initSearchFields();
		this.setSearchFields();
		this.setSearchView();
	}

	private void initSearchFields() {

		_edtNomePesquisa = new TextEdit("edtNomePesquisa", this);
		_edtNomePesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

		_edtIDPesquisa = new TextEdit("edtIDPesquisa", this);
		_edtIDPesquisa.setMask("###.###.###-##");
		_edtIDPesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

		_cboxAtivoPesquisa = new ComboBoxLookup("CboxAtivoPesquisa", this);
		_cboxAtivoPesquisa.addOption("1", "Sim");
		_cboxAtivoPesquisa.addOption("2", "Não");

		
	}

	private void setSearchFields() {
		this.addSearchFieldComponent("CPF:", _edtIDPesquisa);
		this.addSearchFieldComponent("Nome:", _edtNomePesquisa);
		this.addSearchFieldComponent("Ativo? ", _cboxAtivoPesquisa);

	}

	private void setSearchView() {

		this.addListColumn("CPF", "left", 100, DSUsuario.EN_USUARIO_ID_USUARIO);
		this.addListColumn("Nome", "left", 200, DSUsuario.EN_USUARIO_NM_COMPLETO);
			this.addListColumn("Pefil", "left", 100, DSUsuario.EN_TIPO_PERFIL_NM_TIPO_PERFIL);
		this.addListColumn("Ativo", "left", 80, DSUsuario.EN_USUARIO_FG_ATIVO);

	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub

		String senha = (String) _edtSenha.getValue();
		String resenha = (String) _edtReSenha.getValue();
		String ativo = (String) _cboxAtivo.getValue();

		if (senha == null) {
			this.showErrorMessage("A senha devem ser digitada!");
			return false;
		} else if (resenha == null) {
			this.showErrorMessage("Você deve redigitar a senha!");
			return false;
		} else if (!senha.equals(resenha)) {
			this.showErrorMessage("A senhas digitadas estão diferentes!");
			return false;
		} else if (ativo == null) {

			this.showWarningMessage("A informação Ativo SIM ou NãO deve ser informada.");
			return false;

		} else
			return true;

	}

	@Override
	protected void onNewRecord() {
		// TODO Auto-generated method stub
		_edtReSenha.setValue("");

		try {
			_DSPerfilUsuario.retrieve(DSPerfilUsuario.en_perfil_id_usuario + " = '-1'");
		} catch (DataStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_listaPerfil.refresh();

	}

	public void abrePefil() {

		insereItensNovos(_DSUsuario.getEnUsuarioIdUsuario());

		if (_DSUsuario.getEnUsuarioIdUsuario() != null) {

			try {
				_DSPerfilUsuario.retrieve(
						DSPerfilUsuario.en_perfil_id_usuario + " = '" + _DSUsuario.getEnUsuarioIdUsuario() + "' ");
			} catch (DataStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!(_DSPerfilUsuario.getRowCount() > 0)) {
				// Insere Perfil para o usu�rio
				DBConnection con = null;
				Statement stmt = null;

				try {
					con = DBConnection.getConnection(getApplicationName());
					stmt = con.createStatement();

					stmt.execute("select \"public\".\"inserePerfil\" ('" + _DSUsuario.getEnUsuarioIdUsuario() + "');");
					stmt.execute("select \"public\".\"geraPerfilTipoUsuario\"('" + _DSUsuario.getEnUsuarioIdUsuario()
							+ "','03')");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if (con != null) {
						con.freeConnection();
						con = null;
					}
					if (stmt != null) {
						try {
							stmt.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						stmt = null;
					}

				}

				try {
					_DSPerfilUsuario.retrieve(
							DSPerfilUsuario.en_perfil_id_usuario + " = '" + _DSUsuario.getEnUsuarioIdUsuario() + "' ");
				} catch (DataStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			atualizaCor();

		}

	}

	@Override
	protected void afterOpen() {
		_edtReSenha.setValue(_DSUsuario.getEnUsuarioDeSenha());

		abrePefil();

	}

	public void atualizaCor() {

		for (int i = 0; i < _DSPerfilUsuario.getRowCount(); i++) {

			if (_DSPerfilUsuario.getvw_item_modulo_cd_tipo(i) == 1)
				_DSPerfilUsuario.setString(i, "cel_color", "#BEBEBE"); // Cinza
			else
				_DSPerfilUsuario.setString(i, "cel_color", "#FFFACD"); // Bege

		}

		_listaPerfil.refresh();

	}

	public void slotVerSenhaClick(PeEventObject e) {
		this.showInfoMessage("A senha é: " + _edtSenha.getValue());
	}

	public void slotTodosClick(PeEventObject e) {

		for (int i = 0; i < _DSPerfilUsuario.getRowCount(); i++) {
			_DSPerfilUsuario.seten_perfilfg_acesso(i, Short.parseShort("1"));
		}
		_listaPerfil.refresh();
	}

	public void slotNenhumClick(PeEventObject e) {

		for (int i = 0; i < _DSPerfilUsuario.getRowCount(); i++) {
			_DSPerfilUsuario.seten_perfilfg_acesso(i, Short.parseShort("2"));
		}
		_listaPerfil.refresh();
	}

	@Override
	protected void beforeSave() {

		if (!(_DSPerfilUsuario.getRowCount() > 0)) {

			abrePefil();
		} else {

			if (!(_DSUsuario.getEnUsuarioCdPerfil() >= 1)) {

				// Usu�rio Comum
				_DSUsuario.setEnUsuarioCdPerfil(Short.parseShort("2"));
			}

			if (_DSPerfilUsuario.getRowCount() > 0) {

				String codigoItemModuloModulo = "";
				String codigoModulo = "";

				for (int i = 0; i < _DSPerfilUsuario.getRowCount(); i++) {

					if (_DSPerfilUsuario.geten_perfil_fg_acesso(i) == Short.parseShort("1")) {
						// Adicionando zeros as esquerda
						codigoModulo = "0" + _DSPerfilUsuario.getvw_item_modulo_cd_item_modulo_modulo(i);
						codigoModulo = codigoModulo.substring(codigoModulo.length() - 2);

						if (!(codigoItemModuloModulo.contains(codigoModulo))) {
							codigoItemModuloModulo = codigoItemModuloModulo + codigoModulo + ",";
						}
					}

				}
				if (codigoItemModuloModulo.length() > 0) {
					codigoItemModuloModulo = codigoItemModuloModulo.substring(0, codigoItemModuloModulo.length() - 1);
				}

				try {
					_DSPerfilUsuario.update();
				} catch (DataStoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	public void onTabBarChange(NotifyEvent event) {

		try {
			_DSPerfilUsuario.retrieve(
					DSPerfilUsuario.en_perfil_id_usuario + " = '" + _DSUsuario.getEnUsuarioIdUsuario() + "' ");
		} catch (DataStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		atualizaCor();

	}

	class onChangeModulo implements IChangeListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void onChangeEvent(ChangeEvent e) {

			String filtro = "";
			if ((_cbxModulo.getSelectedIndex() >= 0)
					&& (_DSModulo.geten_modulo_cd_modulo(_cbxModulo.getSelectedIndex())) > 0) {
				filtro = DSPerfilUsuario.vw_item_modulo_cd_modulo + " = "
						+ _DSModulo.geten_modulo_cd_modulo(_cbxModulo.getSelectedIndex()) + " and ";
			}

			try {
				_DSPerfilUsuario.retrieve(filtro + _DSPerfilUsuario.en_perfil_id_usuario + " = '"
						+ _DSUsuario.getEnUsuarioIdUsuario() + "' ");
			} catch (DataStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			atualizaCor();
			_listaPerfil.refresh();
		}
	}

	private void insereItensNovos(String cpf) {

		DBConnection con = null;
		Statement stmt = null;

		try {
			con = DBConnection.getConnection(getApplicationName());
			stmt = con.createStatement();

			String sql = "	INSERT INTO en_perfil (	id_usuario,	cd_item_modulo,	fg_acesso) select " + "'" + cpf
					+ "',im.cd_item_modulo,2 from en_item_modulo im	where "
					+ "im.cd_item_modulo not in (select	cd_item_modulo	from	en_perfil "
					+ "where		id_usuario = '" + cpf + "')";

			stmt.execute(sql);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (con != null) {
				con.freeConnection();
				con = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stmt = null;
			}

		}

	}

}
