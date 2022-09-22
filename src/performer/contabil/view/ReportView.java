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

public class ReportView extends PeComposite {
	
	private static final long serialVersionUID = 1L;

	ReportGroup reportGroup;
	
	boolean hasView;
	
	boolean hasClean;
	
	
	public ReportView(boolean hasView, boolean hasClean) {
		super(new ReportView.Attributes() {
			private static final long serialVersionUID = 1L;
			{
				this.setSize("100%", "100%");
			}
		});
		
		this.hasView = hasView;
		
		this.hasClean = hasClean;
		
		PeHorizontalLayout layout;
		{
			PeHorizontalLayout.Configuration config = new PeHorizontalLayout.Configuration();
			config.setGrabHorizontalSpace(true);
			config.setGrabVerticalSpace(true);
			
			layout = new PeHorizontalLayout(this, config);
		}
		/*
		PeImage img;
		{
			PeImage.Attributes attrs = new PeImage.Attributes();
			attrs.setImage("images/screen/tela_relatorio.jpg");
			img = new PeImage(attrs);
		}
		
		layout.add(img);
		*/
		VerticalPanel container = new VerticalPanel("reportContainer", null);
		{
			container.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
			container.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
			container.setWidth("100%");
		}

		{
			reportGroup = new ReportGroup();
			container.add(reportGroup);
		}
		
		layout.add(container);

	}
	
	public void setReportInnerLayout(PeWidget<?> inner) {
		
		reportGroup.report.setReportInnerLayout(inner);
		
	}
	
	public PeButton getViewButton() {
		
		return reportGroup.reportButtons.btnView;
		
	}
	
	public PeButton getCleanButton() {
		
		return reportGroup.reportButtons.btnClean;
		
	}
		
	public PeButton getCloseButton() {
		
		return reportGroup.reportButtons.btnClose;
		
	}
	
	class ReportGroup extends PeComposite {
		
		private static final long serialVersionUID = 1L;

		ReportLayout report;
		
		ReportButtonLayout reportButtons;
		
		
		public ReportGroup() {
			super(new ReportGroup.Attributes() {
				private static final long serialVersionUID = 1L;
				{
					this.setSize("100%", "100%");
					this.setDecoration(new GroupDecoration("Relatório"));
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
				report = new ReportLayout();
				
				layout.add(report, new PeVerticalData(
						PeVerticalData.ALIGN_CENTER, 
						PeVerticalData.ALIGN_MIDDLE));
			}
			
			{
				reportButtons = new ReportButtonLayout();
				
				layout.add(reportButtons, new PeVerticalData(
						PeVerticalData.ALIGN_CENTER, 
						PeVerticalData.ALIGN_MIDDLE));
			}
			
		}
	}
	
	class ReportLayout extends PeComposite {

		private static final long serialVersionUID = 1L;
		
		PeVerticalLayout layout;
		
		
		public ReportLayout() {
			super(new ReportLayout.Attributes() {
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
		
		public void setReportInnerLayout(PeWidget<?> inner) {
			
			layout.add(inner);
			
		}
	}
	
	class ReportButtonLayout extends PeComposite {
		
		private static final long serialVersionUID = 1L;
		
		PeHorizontalLayout layout;
		
		PeButton btnView;
		
		PeButton btnClean;
		
		PeButton btnClose;
		
		
		public ReportButtonLayout() {
			super(new ReportButtonLayout.Attributes() {
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
			
			if (ReportView.this.hasView) {
				
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Visualizar");
				
				btnView = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
				layout.add(btnView, layoutData);
			}
			
			if (ReportView.this.hasClean) {
				
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Limpar");
				
				btnClean = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
			//	layout.add(btnClean, layoutData);
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
