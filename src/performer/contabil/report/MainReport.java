package performer.contabil.report;

import java.util.HashMap;
import java.util.Map;

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
import performer.contabil.utils.StaticReportManager;
import performer.contabil.utils.Utils;

public class MainReport extends PeComposite {

	public static enum MenuCodes implements JSONSerializable {
		// w h
		Default(0, 0),
		RelAtivoPassivoAnual(450, 300),
		RelConferenciaTotais(800, 800),
		RelGraficoTipoLancamento(480, 430),
		RelFaturamentoAnual(450, 300),
		RelHistoricoAnual(450, 300),
		RelGraficoSaldoAnual(450, 300),
		RelGraficoMensalTipoLancamento(650,450),
		RelLancamentosAtivosPassivos(450, 500),
		RelTotalPorTipo(600, 550);

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

	private static  final String acessos_do_usuario = (String) PeFacesApplication.getInstance().getAttribute("ACESSOS_DO_USUARIO");

	public MainReport() {
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
		 * attrs.setImage("images/screen/tela_relatorio.jpg"); img = new
		 * PeImage(attrs); }
		 * 
		 * layout.add(img, PeDockData.CENTER);
		 */
		this.setTitle("Gerenciador de Relatórios");

		

	}

	protected PeToolbar createMenuBar() {

		PeToolbar.Attributes attrs = new PeToolbar.Attributes();
		{
			PeButton.Attributes buttonAttrs = new PeButton.Attributes();
			buttonAttrs.setText("Listagens");
			buttonAttrs.setMenu(this.createMenuListagens());
			attrs.addButton(buttonAttrs);
		}

		{
			PeButton.Attributes buttonAttrs = new PeButton.Attributes();
			buttonAttrs.setText("Totalizadores");
			buttonAttrs.setMenu(this.createMenuTotalizadores());

			attrs.addButton(buttonAttrs);
		}
		
		{
			PeButton.Attributes buttonAttrs = new PeButton.Attributes();
			buttonAttrs.setText("Graficos");
			buttonAttrs.setMenu(this.createMenuGraficos());

			attrs.addButton(buttonAttrs);
		}

		return new PeToolbar(attrs);

	}

	
protected PeMenu createMenuGraficos() {

		
		PeMenu.Attributes MenuGraficos = new PeMenu.Attributes();
		
 
		if (Utils.verifica_item_menu(acessos_do_usuario, "12") == true) {

			MenuGraficos.addItem(MenuCodes.RelGraficoMensalTipoLancamento , "Mensal Por Tipo de Lancamentos");
			MenuGraficos.addItem(MenuCodes.RelGraficoTipoLancamento , "Anual Por Tipo de Lancamentos");
		}
		 
		
		if (Utils.verifica_item_menu(acessos_do_usuario, "17") == true) {
			MenuGraficos.addItem(MenuCodes.RelGraficoSaldoAnual, "Gráfico Saldo Anual");
		}
		
		MenuGraficos.setEventListener(PeMenu.CLICK, new PeDelegate(this, "onMenuAction"), EventType.WAIT);

		return   new PeMenu(MenuGraficos);

	}
	
	
	
	protected PeMenu createMenuListagens() {

		
		PeMenu.Attributes MenuListagem = new PeMenu.Attributes();
		
  /*
		if (Utils.verifica_item_menu(acessos_do_usuario, "13") == true) {
			MenuListagem.addItem(MenuCodes.RelFaturamentoAnual , "Faturamentos Anual");
		}
		*/
		if (Utils.verifica_item_menu(acessos_do_usuario, "19") == true) {
			MenuListagem.addItem(MenuCodes.RelAtivoPassivoAnual , "Historico Anual Ativos x Passivos");
		}
		if (Utils.verifica_item_menu(acessos_do_usuario, "18") == true) {
			MenuListagem.addItem(MenuCodes.RelLancamentosAtivosPassivos , "Lançamentos Ativos x Passivos");
		}
		
		MenuListagem.setEventListener(PeMenu.CLICK, new PeDelegate(this, "onMenuAction"), EventType.WAIT);

		return   new PeMenu(MenuListagem);

	}

	protected PeMenu createMenuTotalizadores() {

		PeMenu.Attributes MenuTotalizador = new PeMenu.Attributes();
		
		MenuTotalizador.setEventListener(PeMenu.CLICK, new PeDelegate(this, "onMenuAction"), EventType.WAIT);
		
		
		if (Utils.verifica_item_menu(acessos_do_usuario, "21") == true) {
			MenuTotalizador.addItem(MenuCodes.RelTotalPorTipo , "Total por Tipo de Lancamento");
		}
		
		if (Utils.verifica_item_menu(acessos_do_usuario, "23") == true) {
			MenuTotalizador.addItem(MenuCodes.RelConferenciaTotais , "Conferência Totais");
		}
		

		return new PeMenu(MenuTotalizador);

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
			// Caso esteja ainda no construtor, o di�logo n�o tem o formul�rio
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

	
	 
	 
}
