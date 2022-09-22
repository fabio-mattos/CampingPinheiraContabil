package performer.contabil.view;

import com.performer.faces.PeButton;
import com.performer.faces.PeComposite;
import com.performer.faces.PeLabel;
import com.performer.faces.PeWidget;
import com.performer.faces.layouts.PeGridData;
import com.performer.faces.layouts.PeGridLayout;
import com.performer.faces.layouts.PeHorizontalData;
import com.performer.faces.layouts.PeHorizontalLayout;
import com.performer.faces.layouts.PeVerticalData;
import com.performer.faces.layouts.PeVerticalLayout;

import framework.web.gui.widget.ListView;
import framework.web.gui.widget.ListView.ColumnType;
import framework.web.gui.widget.panels.VerticalPanel;
import performer.contabil.controller.BaseControllerForm;

public class ListSearchView extends PeComposite {
	
	private static final long serialVersionUID = 1L;
	
	SearchFieldsGroup searchFieldsGroup;
	
	SearchListingGroup searchListingGroup;
	
	boolean hasInsert;
	
	
 
	
	
	public ListSearchView(boolean hasInsert) {
		super(new ListSearchView.Attributes() {
			private static final long serialVersionUID = 1L;
			{
				this.setSize("100%", "100%");
			}
		});
		
		this.hasInsert = hasInsert;
		
		PeHorizontalLayout layout;
		{
			PeHorizontalLayout.Configuration config = new PeHorizontalLayout.Configuration();
			config.setGrabHorizontalSpace(true);
			config.setGrabVerticalSpace(true);
			
			layout = new PeHorizontalLayout(this, config);
		}
		
//		PeImage img;
//		{
//			PeImage.Attributes attrs = new PeImage.Attributes();
//			attrs.setImage("images/screen/tela_consultar.jpg");
//			img = new PeImage(attrs);
//		}
		
//		layout.add(img);
		
		VerticalPanel container = new VerticalPanel("searchContainer", null);
		{
			container.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
			container.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
			container.setWidth("100%");
		}

		{
			searchFieldsGroup = new SearchFieldsGroup();
			container.add(searchFieldsGroup);
		}
				
		{
			searchListingGroup = new SearchListingGroup();
			container.add(searchListingGroup);
		}
		
		layout.add(container);
		
	}
	
	public void addSearchFieldComponent(String caption, PeWidget<?> comp) {
		
		this.searchFieldsGroup.searchFields.addSearchFieldComponent(caption, comp);
		
	}
	
	public void addListingColumn(String field, ColumnType type, String caption, int width, String align) {
		
		this.searchListingGroup.listing.addColumn(field, type, caption, width, align);
		
	}
	
	
	 
	
	public PeButton getSearchButton() {
		
		return searchFieldsGroup.searchButtons.btnSearch;
		
	}
	
	public PeButton getNewButton() {
		
		return searchListingGroup.listingButton.btnNew;
			
	}
	
	public PeButton getExitButton() {
		
		return searchListingGroup.listingButton.btnExit;
		
	}

	public PeButton getHelpButton() {
		
		return searchListingGroup.listingButton.btnHelp;
		
	}
	
	
	public ListView getListView() {
		
		return searchListingGroup.listing;
		
	}
	
	public void setSearchListingGroupHeight(Integer height) {
		
		searchListingGroup.setHeight(height);
		
	}
	
	class SearchFieldsGroup extends PeComposite {
		
		private static final long serialVersionUID = 1L;

		SearchFieldsLayout searchFields;
		
		SearchButtonLayout searchButtons;
		
		
		public SearchFieldsGroup() {
			super(new SearchFieldsGroup.Attributes() {
				private static final long serialVersionUID = 1L;
				{
					this.setSize("100%", "100%");
					this.setDecoration(new GroupDecoration("Filtro"));
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
				searchFields = new SearchFieldsLayout();
				
				layout.add(searchFields, new PeVerticalData(
						PeVerticalData.ALIGN_CENTER, 
						PeVerticalData.ALIGN_MIDDLE));
			}
			
			{
				searchButtons = new SearchButtonLayout();
				
				layout.add(searchButtons, new PeVerticalData(
						PeVerticalData.ALIGN_CENTER, 
						PeVerticalData.ALIGN_MIDDLE));
			}
		}
	}
	
	class SearchFieldsLayout extends PeComposite {

		private static final long serialVersionUID = 1L;
		
		PeGridLayout layout;
		
		
		public SearchFieldsLayout() {
			super(new SearchFieldsLayout.Attributes() {
				private static final long serialVersionUID = 1L;
				{
					this.setSize("100%", "100%");
				}
			});
			
			{
				PeGridLayout.Configuration config = new PeGridLayout.Configuration(6);
				config.setHorizontalSpacing(5);
				config.setVerticalSpacing(5);
				
				layout = new PeGridLayout(this, config);
			}
		}
		
		public void addSearchFieldComponent(String caption, PeWidget<?> comp) {
			
			PeLabel label;
			{
				PeLabel.Attributes attr = new PeLabel.Attributes();
				attr.setText(caption);
				
				label = new PeLabel(attr);
				
				PeGridData layoutData = new PeGridData();
				layoutData.setVerticalAlignment(PeGridData.ALIGN_MIDDLE);
				layoutData.setHorizontalAlignment(PeGridData.ALIGN_RIGHT);
				
				layout.add(label, layoutData);
			}
			
			{
				PeGridData layoutData = new PeGridData();
				layoutData.setVerticalAlignment(PeGridData.ALIGN_MIDDLE);
				layoutData.setHorizontalAlignment(PeGridData.ALIGN_LEFT);
				layoutData.horizontalSpan = 2;
				
				layout.add(comp, layoutData);
			}
		}
	}
	
	class SearchButtonLayout extends PeComposite {
		
		private static final long serialVersionUID = 1L;
		
		PeHorizontalLayout layout;
		
		PeButton btnSearch;
		
		
		public SearchButtonLayout() {
			super(new SearchButtonLayout.Attributes() {
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
			
			{
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Pesquisar");
				
				btnSearch = new PeButton(attr);
				
				PeHorizontalData layoutData = new PeHorizontalData();
				layoutData.setHorizontalAlignment(PeHorizontalData.ALIGN_CENTER); 
				layoutData.setVerticalAlignment(PeHorizontalData.ALIGN_MIDDLE);
				
				layout.add(btnSearch, layoutData);
			}
		}
	}
	
	class SearchListingGroup extends PeComposite {
		
		private static final long serialVersionUID = 1L;
		
		PeVerticalLayout layout;
		
		ListView listing;
		
		ListingButtonLayout listingButton;
		
		
		public SearchListingGroup() {
			super(new SearchListingGroup.Attributes() {
				private static final long serialVersionUID = 1L;
				{
					this.setSize("100%", "100%");
					this.setDecoration(new GroupDecoration("Listagem"));
				}
			});
			
			{
				PeVerticalLayout.Configuration config = new PeVerticalLayout.Configuration();
				config.setSpacing(10);
				config.setMargin(5);
				config.setGrabHorizontalSpace(true);
				
				layout = new PeVerticalLayout(this, config);
			}
			
			{
				listing = new ListView("listingSearch", null);
				listing.setReadOnly(true);
				listing.setHeight(100);
				listing.setWidth(500);
				
				layout.add(listing, new PeVerticalData(
						PeVerticalData.ALIGN_CENTER, 
						PeVerticalData.ALIGN_MIDDLE));
			}
			
			{
				listingButton = new ListingButtonLayout();
				
				layout.add(listingButton, new PeVerticalData(
						PeVerticalData.ALIGN_CENTER, 
						PeVerticalData.ALIGN_MIDDLE));
			}
		}
	}
	
	class ListingButtonLayout extends PeComposite {
		
		private static final long serialVersionUID = 1L;
		
		PeHorizontalLayout layout;
		
		PeButton btnNew;
		
		PeButton btnHelp;
		
		PeButton btnExit;
		
		
		public ListingButtonLayout() {
			super(new ListingButtonLayout.Attributes() {
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
			
			if (ListSearchView.this.hasInsert) {
				
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Novo");
				
				btnNew = new PeButton(attr);
				
				layout.add(btnNew, new PeHorizontalData(
						PeHorizontalData.ALIGN_CENTER, 
						PeHorizontalData.ALIGN_MIDDLE));
			}
			
			
			{
			 
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Help");
				
				btnHelp = new PeButton(attr);
				
				layout.add(btnHelp, new PeHorizontalData(
						PeHorizontalData.ALIGN_CENTER, 
						PeHorizontalData.ALIGN_MIDDLE));
			 	
				
			}
			
			
			
			{
				PeButton.Attributes attr = new PeButton.Attributes();
				attr.setText("Sair");
				
				btnExit = new PeButton(attr);
				
				layout.add(btnExit, new PeHorizontalData(
						PeHorizontalData.ALIGN_CENTER, 
						PeHorizontalData.ALIGN_MIDDLE));
			}
		}
	}

}
