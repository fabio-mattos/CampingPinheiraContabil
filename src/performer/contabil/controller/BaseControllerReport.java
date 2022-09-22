package performer.contabil.controller;

import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeWidget;
import com.performer.faces.layouts.PeVerticalLayout;

import framework.web.gui.widget.panels.VerticalPanel;
import performer.contabil.view.ReportView;



public abstract class BaseControllerReport extends BaseControllerContabil {

	private static final long serialVersionUID = 1L;

	private VerticalPanel _mainContainer;
	
	private ReportView _reportView;
	
	
	public BaseControllerReport() {
		this(null);
	}
	
	public BaseControllerReport(ModalArgument modalArgument) {
		super(modalArgument);
	}
	
	protected abstract void setupReportFilter();
	
    @Override
    public void initialize() {
    	
        super.initialize();
        
        this.onShow();
        
    }
	
	protected void onShow() {
		
	}

	protected boolean hasView() {
    	
        return true;
        
    }
    
    protected boolean hasClean() {
    	
        return true;
        
    }
    
    protected PeButton getViewButton() {
    	
    	return _reportView.getViewButton();
    	
    }
    
    protected PeButton getCleanButton() {
    	
    	return _reportView.getCleanButton();
    	
    }
    
    protected PeButton getCloseButton() {
    	
    	return _reportView.getCloseButton();
    	
    }
	
    @Override
    protected PeWidget<?> getViewComponent() {
    	{
    		PeVerticalLayout.Configuration config = new PeVerticalLayout.Configuration();
    		config.setMargin(0);
    		config.setSpacing(0);
    		
	    	_mainContainer = new VerticalPanel("$mainContainer$", this, config);
	    	_mainContainer.setHeight("100%");
	    	_mainContainer.setWidth("100%");
    	}
    	
        {
	        this.createReportView();
	        _mainContainer.add(_reportView);
        }
        
        return _mainContainer;
    }
    
    private void createReportView() {
		
    	_reportView = new ReportView(
				this.hasView(), 
				this.hasClean());
		
		{
			if (this.hasView()) {
				
				this.getViewButton().addEventListener(
		    			PeButton.CLICK, 
		    			new PeDelegate(BaseControllerReport.this, "slotDoView"),
		    			EventType.WAIT);
				
			}
			
			if (this.hasClean()) {
				
				this.getCleanButton().addEventListener(
		    			PeButton.CLICK, 
		    			new PeDelegate(BaseControllerReport.this, "slotDoClean"));
				
			}
			
			{
				this.getCloseButton().addEventListener(
		    			PeButton.CLICK, 
		    			new PeDelegate(BaseControllerReport.this, "slotDoExit"));
			}
		}
		
		this.setupReportFilter();
	}
    
    protected void setReportInnerLayout(PeWidget<?> inner) {
		
		_reportView.setReportInnerLayout(inner);
		
	}
    
    protected void slotDoView(PeEventObject e) {
    	
    	this.viewReport();
    	
    }
    
    protected void viewReport() {
        try {
        	
            if (this.isFilterValidated()) {
            	
            	this.performReportView();
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            this.showErrorMessage(e.getMessage());
        }
    }
    
    protected void performReportView() {
		
	}

	protected boolean isFilterValidated() {
    	
        return true;
        
    }
    
    protected void slotDoClean(PeEventObject e) {
    	
    	this.performClean();
    	
    }
    
    protected void performClean() {
		
	}

	protected void slotDoExit(PeEventObject e) {
        
    	this.exitUseCase();
    	
    }

}
