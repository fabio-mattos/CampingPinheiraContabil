package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.performer.core.IPeEventListener;
import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeImage;
import com.performer.faces.PeLabel;
import com.performer.faces.PeMessages;
import com.performer.faces.PePanel;
import com.performer.faces.download.IPeFileDownloader;
import com.performer.faces.forms.PeMainFormV2;
import com.performer.faces.forms.PeMainMenuV2;
import com.performer.faces.layouts.PeTemplateLayout;

import framework.web.gui.widget.Text;
import performer.contabil.persistence.DSUsuario;
import performer.contabil.utils.Login;
import performer.contabil.utils.Utils;

public class StartUp extends PeMainFormV2<StartUp.MenuCodes> {

	private static final long serialVersionUID = 1L;

	static enum MenuCodes implements Serializable {
		// W H

		AlteraSenha(650, 500, true), MainReport(400, 300, true), EsqueciMinhaSenha(550, 150, true), 
		MainCadastros(400,	300, true), DownloadManualUsuario(350, 250, true), DownloadPDF(350, 250, true), 
		DownloadAmmyyAdmin(350,	250, true), EmDesenvolvimento(500, 250, true), CadOrcamentos(1000, 700,true), 
		ImportaPlanilhaBaseSaldo(800, 620,	true), CadAtivosPassivos(900, 620, true), SelecionaEmpresa(800, 400),
		CadBoletos(800, 620, true),CadFaturamentoMensal(800, 620, true),
		CadHistoricoAnual(800, 800,true);

		private int width;
		private int height;
		private boolean modal;
		private String urlHelp;

		private MenuCodes(int width, int height) {
			this(width, height, false);
		}

		private MenuCodes(int width, int height, boolean modal) {
			this.width = width;
			this.height = height;
			this.modal = modal;
		}

		private MenuCodes(int width, int height, boolean modal, String urlHelp) {
			this.width = width;
			this.height = height;
			this.modal = modal;
			this.urlHelp = urlHelp;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public boolean isModal() {
			return modal;
		}

		public String getUrlHelp() {
			return urlHelp;
		}
	}

	public void createMenu(PeMainMenuV2 menu) {

	//	String acessos_do_usuario = (String) PeFacesApplication.getInstance().getAttribute("ACESSOS_DO_USUARIO");
	//	String acessos_do_usuario_modulos = (String) PeFacesApplication.getInstance()	.getAttribute("ACESSOS_DO_USUARIO_MODULOS");
		String acessos_do_usuario = "";
		String acessos_do_usuario_modulos = "";

		if (Utils.verifica_item_menu(acessos_do_usuario_modulos, "02") == true) {
			PeMainMenuV2.MenuOptions menu_tabelas = menu.addMenu("Históricos");

			{
				if (Utils.verifica_item_menu(acessos_do_usuario, "06") == true) {
					menu_tabelas.addItem("images/icons/Atendimentos.png", "Lancamento de Ativos\\Passivos",
							MenuCodes.CadAtivosPassivos, EventType.WAIT);
				}
				
				if (Utils.verifica_item_menu(acessos_do_usuario, "10") == true) {
					menu_tabelas.addItem("images/icons/historico.png", "Cadastro de Boletos",
							MenuCodes.CadBoletos, EventType.WAIT);
				}
/*
				
				if (Utils.verifica_item_menu(acessos_do_usuario, "11") == true) {
					menu_tabelas.addItem("images/icons/Faturamento.png", "Cadastro de Faturamentos Mensais",
							MenuCodes.CadFaturamentoMensal, EventType.WAIT);
				}

				if (Utils.verifica_item_menu(acessos_do_usuario, "16") == true) {
					menu_tabelas.addItem("images/icons/contra_cheque.png", "Cadastro de Histórico Anual",
							MenuCodes.CadHistoricoAnual, EventType.WAIT);
				}
				
				*/
					menu_tabelas.addItem("images/icons/Change.png", "Troca Empresa",
							MenuCodes.SelecionaEmpresa, EventType.WAIT);
				
			}

		}

		if (Utils.verifica_item_menu(acessos_do_usuario_modulos, "01") == true) {
			PeMainMenuV2.MenuOptions menu_tabelas = menu.addMenu("Cadastros Base");

			{
				if (Utils.verifica_item_menu(acessos_do_usuario, "02") == true) {
					menu_tabelas.addItem("images/icons/Controler2.png", "Cadastros", MenuCodes.MainCadastros,
							EventType.WAIT);
				}

			}

		}

		if (Utils.verifica_item_menu(acessos_do_usuario_modulos, "03") == true) {
			PeMainMenuV2.MenuOptions menu_relatorios = menu.addMenu("Relatórios");
			{
				if (Utils.verifica_item_menu(acessos_do_usuario, "08") == true) {
					menu_relatorios.addItem("images/icons/impressao_folhas.png", "Gerenciador de Relatórios",
							MenuCodes.MainReport, EventType.WAIT);
				}
			}
		}

		PeMainMenuV2.MenuOptions menu_suporte = menu.addMenu("Suporte");

		{
			menu_suporte.addItem("images/icons/esf.png", "Atualizar Senha", MenuCodes.AlteraSenha, EventType.WAIT);

		}
	}

	public boolean validUser(String user, String password) {

		Login manager = new Login();

		int result = manager.checkLoginData(user, password);

		return (Login.ACCESS_ALLOWED == result);

	}

	// //TODO: Chama um item do menu ao abrir a tela principal.
	@Override
	protected void drawMain() {

	 

			this.dispatchMenuAction(MenuCodes.SelecionaEmpresa);
			super.drawMain();
	}

	private class OnExitLinkClicked implements IPeEventListener {

		@Override
		public void handleEvent(PeEventObject event) {
			if (dialog == null) {
				deleteAllChildren();
				drawLogin();
			}
		}

	}

	protected void drawWorkArea(int index, Object data) {
		deleteAllChildren();

		PeTemplateLayout layout = new PeTemplateLayout(this, "templates/pe-main.html");

		// {0}
		layout.add(lblExit = new PeImage(new PeImage.Attributes() {
			{
				this.setImage("resources/images/performer/botao_sair.png");
				this.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.PRESSED | PeImage.ImageState.SELECTED
						| PeImage.ImageState.DISABLE);
				this.setHint("Clique aqui para sair do programa");
				this.setTheme("pe-main-exit");
				this.setEventListener(PeLabel.CLICK, new OnExitLinkClicked());
			}
		}));

		// {1}

		String login = (String) PeFacesApplication.getInstance().getAttribute(DSUsuario.EN_USUARIO_ID_USUARIO);
		String nome = (String) PeFacesApplication.getInstance().getAttribute(DSUsuario.EN_USUARIO_NM_COMPLETO);

		layout.add(new Text("Usuário Logado: " + login + " - " + nome, null));

		// {2}
		layout.add(host = new PePanel(new PePanel.Attributes() {
			{
				this.setTitle(".");
				this.setVisible(false);
				this.setWidth("100%");
				this.setHeight("100%");
			}
		}));

		menu = new PeMainMenuV2();

		menu.setEventListener(PeMainMenuV2.ITEM_SELECTED, new PeDelegate(this, "onItemSelected"), EventType.WAIT);

		if (data == null) {
			this.createMenu(menu);
		} else {
			this.createMenu(menu, data);
		}

		// {3}
		layout.add(menu);

		menu.setActiveTab(index);
	}

	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		this.showMissingPasswordLink(true);
		super.initializeView();
	}

	@Override
	protected void onForgotPassword(String userName) {
		// TODO Auto-generated method stub
		// PeFacesApplication.getInstance().openModal(moduleAlias, config,
		// params) (MenuCodes.EsqueciMinhaSenha );
		this.dispatchMenuAction(MenuCodes.EsqueciMinhaSenha);
	}

	@Override
	protected void dispatchMenuAction(StartUp.MenuCodes id) {

		File diretorio = new File("c:\\temp");
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}

		if (id.name().equalsIgnoreCase(MenuCodes.DownloadPDF.name())) {
			PeFacesApplication.getInstance().downloadFile("download/FoxitReader30_enu_Setup.exe", "c:/temp");
		} else if (id.name().equalsIgnoreCase(id.DownloadAmmyyAdmin.name())) {
			PeFacesApplication.getInstance().downloadFile("download/AA_v3.5.zip", "c:/temp");
		} else if (id.name().equalsIgnoreCase(id.DownloadManualUsuario.name())) {
			PeFacesApplication.getInstance().downloadFile("download/ManualUsuarioSAL.pdf", "c:/temp");
			// slotAbreManualUsuario();
		} else if (id.name().equalsIgnoreCase(MenuCodes.EmDesenvolvimento.name())) {
			PeMessages.showDialog("Atenção", "Módulo em Desenvovimento", PeMessages.Icon.WARNING);
		} else {
			if (id.modal) {
				this.showModal(id.name(), id.getWidth(), id.getHeight(), id.getUrlHelp());
			} else {
				this.show(id.name());
			}
		}
	}

	protected void slotAbreManualUsuario() {

		final java.io.File file = new java.io.File("//download/ManualUsuarioSAL.pdf");

		if (file.exists()) {
			IPeFileDownloader outputWriter = new IPeFileDownloader() {

				@Override
				public String fileName() {
					return file.getName();
				}

				@Override
				public String mimeType() {
					return "application/pdf"; //
				}

				@Override
				public long fileSize() {
					return file.length();
				}

				@Override
				public void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
					FileInputStream input = new FileInputStream(file);
					try {
						IOUtils.copyLarge(input, response.getOutputStream());
					} finally {
						IOUtils.closeQuietly(input);
					}
				}

			};

			PeFacesApplication.getInstance().openWindow(outputWriter, 800, 600, true, true);

		}

	}

	/*
	 * @Override protected void dispatchMenuAction(StartUp.MenuCodes id) {
	 * 
	 * if (id.modal) { this.showModal(id.name(), id.getWidth(), id.getHeight(),
	 * id.getUrlHelp()); } else { this.show(id.name()); }
	 * 
	 * }
	 */
	// @Override
	// protected void drawLogin() {
	// if (validUser("1", "1")) {
	// drawMain();
	// } else {
	// super.drawLogin();
	// }
	// }

}
