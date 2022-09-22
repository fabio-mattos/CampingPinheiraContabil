package performer.contabil.viewcontroller;

import java.sql.SQLException;

import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeImage;
import com.performer.faces.PeWidget;
import com.performer.faces.PeComponent.EventType;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ImageButton;
import framework.web.gui.widget.Text;
import performer.contabil.controller.BaseControllerModal;
import performer.contabil.persistence.DSParametros;


public class SelecionaEmpresaController extends BaseControllerModal {

	private DSParametros _DSParametros;
  
 
	private Text _txtSelecioneEmpresa;
	private Text _texto_branco1;
	private PeImage _btnEmpresa1;
	private PeImage _btnEmpresa2;
	
		
 

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub
		return "Bem vindo ao sistema Contábil - Selecione a Empresa";
	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {
		// TODO Auto-generated method stub
		_DSParametros = new DSParametros(getApplicationName());
		_DSParametros.retrieve(DSParametros.EN_PARAMETRO_CD_PARAMETRO + " = 1");
	}

	@Override
	protected PeWidget<?> getViewComponent() {
		// TODO Auto-generated method stub
		BasicDetail detail = new BasicDetail("$detail$", this, _DSParametros,
				true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(520);
		detail.setHeight(270);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;
	}

	private void initVisualComps() {
		_txtSelecioneEmpresa = new Text("Selecione a Empresa", this);
		_txtSelecioneEmpresa.setCustomStyle("color: blue;");
		 
		_texto_branco1 = new Text(" ", this);
		
	  
	
		PeImage.Attributes attrs = new PeImage.Attributes();
		attrs.setImage("images/CampingPinheira.png");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE   		);
		_btnEmpresa1 = new PeImage(attrs);
		_btnEmpresa1.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotSelecionarEmpresa1Click"),	EventType.WAIT);
		_btnEmpresa1.setHint("Clique aqui para selecionar a Empresa Camping Pinheira.");
	 
	 
		
		attrs.setImage("images/CampingPinheiraComercial.png");
		 attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
					| PeImage.ImageState.DISABLE	);
		_btnEmpresa2 = new PeImage(attrs);
		_btnEmpresa2.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotSelecionarEmpresa2Click"),		EventType.WAIT);
		_btnEmpresa2.setHint("Clique aqui para selecionar a Empresa Camping Pinheira Comercial.");
	 

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1 });
		{
			detail.addField("  ", _txtSelecioneEmpresa);

		}
		detail.addTable(new int[] { 1,1  });
		{
			detail.addField("Camping Pinheira  ", _btnEmpresa1);
			detail.addField("Camping Pinheira Comercial  ", _btnEmpresa2);
		}
		
 
 

	}

 

	@Override
	protected void onShowModal() {
		// TODO Auto-generated method stub
		
	}
	
	public void slotSelecionarEmpresa1Click(PeEventObject e) {
		PeFacesApplication.getInstance().putAttribute("EMPRESA_SELECIONADA", "1");
		PeFacesApplication.getInstance().putAttribute("NOME_EMPRESA_SELECIONADA", "Camping Pinheira");
		this.close();
		
	}
	
	public void slotSelecionarEmpresa2Click(PeEventObject e) {
		PeFacesApplication.getInstance().putAttribute("EMPRESA_SELECIONADA", "2");
		PeFacesApplication.getInstance().putAttribute("NOME_EMPRESA_SELECIONADA", "Camping Pinheira Comercial");
		this.close();
	}
	
 
}
