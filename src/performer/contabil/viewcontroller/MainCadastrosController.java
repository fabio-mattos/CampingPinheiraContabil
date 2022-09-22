package performer.contabil.viewcontroller;

import com.adobe.serialization.json.JSONSerializable;
import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.core.configuration.Form;
import com.performer.faces.PeButton;
import com.performer.faces.PeComposite;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeMenu;
import com.performer.faces.PePanel;
import com.performer.faces.PeToolbar;
import com.performer.faces.PeWidget;
import com.performer.faces.PeWindow;
import com.performer.faces.core.IPeComposite;
import com.performer.faces.layouts.PeDockData;
import com.performer.faces.layouts.PeDockLayout;

import framework.web.BaseController.ModalArgument;
import performer.contabil.utils.Utils;

public class MainCadastrosController extends PeComposite {

	private PeButton _btnClose;

	public static enum MenuCodes implements JSONSerializable {
		// w h
		Default(0, 0),
		CadParametros(750, 570),
		CadUsuario(850, 600),
		CadHistoricoLancamentos(800, 600),
		CadTipoLancamento(800, 600);

		private final int width;
		private final int height;

		private MenuCodes(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public Object getData() {
			return this.ordinal();
		}

		public static MenuCodes valueOf(int code) {
			MenuCodes[] items = MenuCodes.values();
			for (int i = 0, iSize = items.length; i < iSize; i++) {
				if (items[i].ordinal() == code) {
					return items[i];
				}
			}
			return MenuCodes.Default;
		}

	}

	public MainCadastrosController() {

		super(new PeComposite.Attributes() {

			private static final long serialVersionUID = 1L;

			{
				this.setWidth("100%");
				this.setOverflow(PeComposite.Overflow.AUTO);
			}
		});

		PeDockLayout layout;
		{
			PeDockLayout.Configuration config = new PeDockLayout.Configuration();
			config.setGrabHorizontalSpace(true);
			config.setVerticalSpacing(10);

			layout = new PeDockLayout(this, config);
		}

		layout.add(this.createMenuBar(), PeDockData.NORTH);
		/*
		 * PeImage img; { PeImage.Attributes attrs = new PeImage.Attributes();
		 * attrs.setImage("images/screen/RH.png"); img = new PeImage(attrs); }
		 * 
		 * layout.add(img, PeDockData.CENTER);
		 */

		PeButton.Attributes attr = new PeButton.Attributes();
		attr.setText("Fechar");
		_btnClose = new PeButton(attr);
		_btnClose.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotDoClose"));

		// layout.add(_btnClose, PeDockData.WEST);

		this.setTitle("Menu Cadastros");

	}

	protected PeToolbar createMenuBar() {

		PeToolbar.Attributes attrs = new PeToolbar.Attributes();
		{
			PeButton.Attributes buttonAttrs = new PeButton.Attributes();
			buttonAttrs.setText("Cadastros");
			buttonAttrs.setMenu(this.createMenuCadastrosBasicos());

			attrs.addButton(buttonAttrs);
		}

		return new PeToolbar(attrs);

	}

	protected PeMenu createMenuCadastrosBasicos() {

		String acessos_do_usuario = (String) PeFacesApplication.getInstance().getAttribute("ACESSOS_DO_USUARIO");

		PeMenu.Attributes menuCadastros = new PeMenu.Attributes();

		
		if (Utils.verifica_item_menu(acessos_do_usuario, "03") == true) {
			menuCadastros.addItem(MenuCodes.CadUsuario, "Usuários");
		}
		if (Utils.verifica_item_menu(acessos_do_usuario, "04") == true) {
			menuCadastros.addItem(MenuCodes.CadParametros, "Parâmetros");
		}
		
		if (Utils.verifica_item_menu(acessos_do_usuario, "09") == true) {
			menuCadastros.addItem(MenuCodes.CadHistoricoLancamentos, "Histórico de Lancamentos");
		}
		
		
		if (Utils.verifica_item_menu(acessos_do_usuario, "14") == true) {
			menuCadastros.addItem(MenuCodes.CadTipoLancamento, "Tipos de Lancamentos");
		}
		
		
		menuCadastros.setEventListener(PeMenu.CLICK, new PeDelegate(this, "onMenuAction"), EventType.WAIT);

		return new PeMenu(menuCadastros);

	}

	protected void onMenuAction(PeEventObject event) {

		MenuCodes menu = MenuCodes.valueOf(event.asInt("code"));
		this.showModal(menu.name(), menu.getWidth(), menu.getHeight(), false);

	}

	public void showModal(String moduleAlias, int width, int height, boolean showCloseButton) {

		PeWindow.Attributes config = new PeWindow.Attributes();
		config.setWidth(width);
		config.setHeight(height);
		config.setClosable(showCloseButton);

		ModalArgument argument = null;
		PeFacesApplication.getInstance().openModal(moduleAlias, config, argument);

	}

	public void setTitle(String text) {
		Form form = this.form;
		if (form == null) {
			// Caso esteja ainda no construtor, o di�logo n�o tem o formulário
			// associado.
			// Neste caso, se busca o formulário associado a esta classe.
			form = PeFacesApplication.getInstance().getFormDescriptor(this.getClass());
		}

		// Troca o texto no descritor da classe, assim o openModal mostrar� o
		// texto correto
		if (form != null) {
			form.setAttributeValue("title", text);
		}

		// Caso a tela j� tenha sido mostrada, procura a janela propriet�ria
		// para trocar o titulo.
		IPeComposite parent = this.getParent();
		while (parent != null) {
			if (parent instanceof PePanel) {
				PePanel dialog = (PePanel) parent;
				dialog.setTitle(text);
				break;
			}
			parent = ((PeWidget<?>) parent).getParent();
		}
	}

	protected void slotDoClose(PeEventObject e) {

		// this.

		// this.CLOSE_WINDOW() ;
	}
}
