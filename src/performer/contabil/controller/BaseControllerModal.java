package performer.contabil.controller;


public abstract class BaseControllerModal extends BaseControllerContabil {

	private static final long serialVersionUID = 1L;
	
	
	public BaseControllerModal(ModalArgument modalArgument) {
		super(modalArgument);
	}

	public BaseControllerModal() {
		this(null);
	}
	
	protected abstract void onShowModal();
	
	@Override
	public void initialize() {
		
		super.initialize();
		
		this.onShowModal();
		
	}
	

}
