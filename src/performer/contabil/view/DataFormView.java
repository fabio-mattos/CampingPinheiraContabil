package performer.contabil.view;



import com.performer.faces.PeButton;
import com.performer.faces.PeComposite;
import com.performer.faces.PeImage;
import com.performer.faces.PeWidget;
import com.performer.faces.layouts.PeHorizontalData;
import com.performer.faces.layouts.PeHorizontalLayout;
import com.performer.faces.layouts.PeVerticalData;
import com.performer.faces.layouts.PeVerticalLayout;

import framework.web.gui.widget.panels.VerticalPanel;

public class DataFormView extends PeComposite {
	
	private static final long serialVersionUID = 1L;

	DataFormGroup dataFormGroup;
	
	boolean hasNew;
	
	boolean hasUpdate;
	
	boolean hasDelete;
	
	boolean hasPrint;
	
	boolean hasExtraButton;
	
	String extraButtonLabel; 
	
	
	public DataFormView(boolean hasNew, boolean hasUpdate, boolean hasDelete, boolean hasPrint, boolean hasExtraButton, String extraButtonLabel) {
		super(new DataFormView.Attributes() {
			private static final long serialVersionUID = 1L;
			{
				this.setSize("100%", "100%");
			}
		});
		
		this.hasNew = hasNew;
		this.hasUpdate = hasUpdate;
		this.hasDelete = hasDelete;
		this.hasPrint = hasPrint;
		this.hasExtraButton = hasExtraButton;
		this.extraButtonLabel = extraButtonLabel;
		
		PeHorizontalLayout layout;
		{
			PeHorizontalLayout.Configuration config = new PeHorizontalLayout.Configuration();
			config.setGrabHorizontalSpace(true);
			config.setGrabVerticalSpace(true);
			
			layout = new PeHorizontalLayout(this, config);
		}
		
//		if (hasPicture)
//		{
//			PeImage img;
//			{
//				PeImage.Attributes attrs = new PeImage.Attributes();
//				attrs.setImage("images/screen/tela_nova.jpg");
//				img = new PeImage(attrs);
//			}
//			layout.add(img);
//		}
		
		

		
		VerticalPanel container = new VerticalPanel("dataFormContainer", null);
		{
			container.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
			container.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
			container.setWidth("100%");
		}

		{
			dataFormGroup = new DataFormGroup();
			container.add(dataFormGroup);
		}
		
		layout.add(container);
	}
	
	public void setDataFormInnerLayout(PeWidget<?> inner) {
		
		dataFormGroup.dataForm.setDataFormInnerLayout(inner);
		
	}
	
	public PeButton getNewButton() {
		
		return dataFormGroup.dataFormButtons.btnNew;
		
	}
	
	public PeButton getSaveButton() {
		
		return dataFormGroup.dataFormButtons.btnSave;
		
	}
	
	public PeButton getDeleteButton() {
		
		return dataFormGroup.dataFormButtons.btnDelete;
		
	}
	
	public PeButton getPrintButton() {
		
		return dataFormGroup.dataFormButtons.btnPrint;
		
	}
	
	public PeButton getExtraButton() {
		
		return dataFormGroup.dataFormButtons.btnExtra;
		
	}	
	
	public PeButton getCloseButton() {
		
		return dataFormGroup.dataFormButtons.btnClose;
		
	}
	
	class DataFormGroup extends PeComposite {
		
		private static final long serialVersionUID = 1L;

		DataFormLayout dataForm;
		
		DataFormButtonLayout dataFormButtons;
		
		
		public DataFormGroup() {
			super(new DataFormGroup.Attributes() {
				private static final long serialVersionUID = 1L;
				{
					this.setSize("100%", "100%");
					this.setDecoration(new GroupDecoration("Formulário"));
				}
			});
			
			PeVerticalLayout layout;
			{
				PeVerticalLayout.Configuration config = new PeVerticalLayout.Configuration();
				config.setSpacing(10);
				config.setMargin(5);
				config.setGrabHorizontalSpace(true);
				
				layout = new PeVerticalLayout(this, config);
			}

			{
				dataForm = new DataFormLayout();
				
				layout.add(dataForm, new PeVerticalData(
						PeVerticalData.ALIGN_CENTER, 
						PeVerticalData.ALIGN_MIDDLE));
			}
			
			{
				dataFormButtons = new DataFormButtonLayout();
				
				layout.add(dataFormButtons, new PeVerticalData(
						PeVerticalData.ALIGN_CENTER, 
						PeVerticalData.ALIGN_MIDDLE));
			}
		}
	}
	
	class DataFormLayout extends PeComposite {

		private static final long serialVersionUID = 1L;
		
		PeVerticalLayout layout;
		
		
		public DataFormLayout() {
			super(new DataFormLayout.Attributes() {
				private static final long serialVersionUID = 1L;
				{
					this.setSize("100%", "100%");
				}
			});
			
			{
				PeVerticalLayout.Configuration config = new PeVerticalLayout.Configuration();
				config.setGrabHorizontalSpace(true);
				config.setMargin(5);
				
				layout = new PeVerticalLayout(this, config);
			}
		}
		
		public void setDataFormInnerLayout(PeWidget<?> inner) {
			
			layout.add(inner);
			
		}
	}
	
	class DataFormButtonLayout extends PeComposite {
		
		private static final long serialVersionUID = 1L;
		
		PeHorizontalLayout layout;
		PeButton btnNew;
		PeButton btnSave;
		PeButton btnDelete;
		PeButton btnPrint;
		PeButton btnExtra;
		PeButton btnClose;
		
		
		public DataFormButtonLayout() {
			super(new DataFormButtonLayout.Attributes() {
				private static final long serialVersionUID = 1L;
				{
					this.setSize("100%", "100%");
				}
			});
			
			{
				PeHorizontalLayout.Configuration config = new PeHorizontalLayout.Configuration();
				config.setSpacing(10);
				
				layout = new PeHorizontalLayout(this, config);
			}
			
			if (DataFormView.this.hasUpdate) {
				
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Salvar");
				
				btnSave = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
				layout.add(btnSave, layoutData);
			}
			
			if (DataFormView.this.hasNew) {
				
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Novo");
				
				btnNew = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
				layout.add(btnNew, layoutData);
			}
			
			if (DataFormView.this.hasDelete) {
				
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Excluir");
				
				btnDelete = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
				layout.add(btnDelete, layoutData);
			}
			
			if (DataFormView.this.hasPrint) {
				
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Imprimir");
				
				btnPrint = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
				layout.add(btnPrint, layoutData);
			}
			
			if (DataFormView.this.hasExtraButton) {
				
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText(DataFormView.this.extraButtonLabel);
				
				btnExtra = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
				layout.add(btnExtra, layoutData);
			}
			
			{
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Fechar");
				
				btnClose = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
				layout.add(btnClose, layoutData);
			}
		}
	}
}
