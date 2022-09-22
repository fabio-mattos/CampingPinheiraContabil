package performer.contabil.controller;

import java.sql.SQLException;

import com.performer.faces.PeMessages;
import com.performer.faces.PePanel;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStoreException;

import framework.web.BaseController;
import framework.web.util.Geral;

public abstract class BaseControllerContabil extends BaseController {

	private static final long serialVersionUID = 1L;
	
	public static final int ENTER_KEY = 13;
	
	
	public BaseControllerContabil() {
		this(null);
	}
	
	public BaseControllerContabil(ModalArgument modalArgument) {
		super(modalArgument);
	}
	
    protected abstract String getCaption();
    protected abstract void initDataStores() throws SQLException, DataStoreException;
    protected abstract PeWidget<?> getViewComponent();
    
    @Override
    public void initialize() {
    	
        Geral.setCompsGlobal(false);
        
        this.setTitle(this.getCaption());
        try { this.initDataStores(); } catch (Exception e) { e.printStackTrace(); }
        this.replaceComponent("placeHolder", this.getViewComponent());
        
    }
    
    protected void showWarningMessage(String message) {
    	
    	PeMessages.showDialog("Atenção", message, PeMessages.Icon.WARNING);
    	
    }
    
    protected void showErrorMessage(String message) {
    	
    	PeMessages.showDialog("Erro", message, PeMessages.Icon.ERROR);
    	
    }
    
    protected void showInfoMessage(String message) {
    	
    	PeMessages.showDialog("Informação", message, PeMessages.Icon.INFO);
    	
    }
    
    protected void exitUseCase() {
    	
    	PeWidget<?> composite = (PeWidget<?>) this.getParent();
    	
    	while(composite != null) {
    		
    		if(composite instanceof PePanel) {
    			((PePanel) composite).setVisible(false);
    			break;
    		}
    		
    		composite = (PeWidget<?>) composite.getParent();
    	}
    	
    	this.destroy();
    }

}
