/*
 * Created on 22/01/2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package performer.contabil.utils;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;

import framework.web.BaseController;
import framework.web.util.Geral;
import framework.web.util.SOFIAPaths;

/**
 * @author paula
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class BaseControllerAdapter extends BaseController {

	private static final long serialVersionUID = 1L;

	public BaseControllerAdapter() {
		this(null);
	}

	public BaseControllerAdapter(ModalArgument modalArgument) {
		super(modalArgument);
	}

	protected SOFIAPaths _paths;

	public void initialize() {
		Geral.setCompsGlobal(false);
		_paths = new SOFIAPaths(this);
		replaceComponent("placeHolder", getViewComponent());

	}

	public String getLogoutAction(String exitUrl) {
		return "window.location.href='" + exitUrl + "'";
	}

	
	/**
	 * 
	 * @return session
	 */
	public PeFacesApplication getSession() {
		return PeFacesApplication.getInstance();
	}

	/**
	 * 
	 * @return String
	 */
	public String getProfile() {
		return "PRINCIPAL";
	}

	
	/**
	 * Abstract Class
	 * 
	 * @return PeWidget<?>
	 */
	protected abstract PeWidget<?> getViewComponent();

}
