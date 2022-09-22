package performer.contabil.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import performer.contabil.persistence.DSUsuario;
import performer.contabil.view.DataFormView;
import performer.contabil.view.ListSearchView;

import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeMessages;
import com.performer.faces.PeWidget;
import com.performer.faces.layouts.PeVerticalLayout;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;
import com.salmonllc.util.MessageLog;

import framework.web.gui.widget.ListView;
import framework.web.gui.widget.ListView.ColumnType;
import framework.web.gui.widget.events.KeyUpEvent;
import framework.web.gui.widget.events.KeyUpListener;
import framework.web.gui.widget.panels.VerticalPanel;
import framework.web.util.NotifyDelegate;
import framework.web.util.NotifyEvent;

public abstract class BaseControllerForm extends BaseControllerContabil {

	private static final long serialVersionUID = 1L;

	public static final String INSERT_MODAL = "insertModal";
	public static final String MODAL_KEY_FIELD = "modalKeyField";
	public static final String MODAL_KEY_VALUE = "modalKeyValue";

	private VerticalPanel _mainContainer;

	private ListSearchView _listSearchView;

	private DataFormView _dataFormView;

	private boolean _hasSearch;

	private boolean _showConfirmationMessage = true;

	private List<String> _key;

	private boolean _newRecord;

	private boolean _insertModalWindow;

	private String[] _modalKeyField;

	private Object[] _modalKeyValue;

	public BaseControllerForm() {
		this(null);
	}

	public BaseControllerForm(ModalArgument modalArgument) {
		super(modalArgument);
	}

	protected abstract String getSQLSearch();

	protected abstract DataStore getMainDataStore();

	protected abstract void setupSearch();

	protected abstract void setupDataForm();

	@SuppressWarnings("unchecked")
	@Override
	public void initialize() {

		_key = new ArrayList<String>();
		_hasSearch = true;

		if (this.getModalArguments() instanceof Map) {

			Map map = (Map<String, Object>) this.getModalArguments();
			if (map.containsKey(INSERT_MODAL)) {

				boolean insertModal = (Boolean) map.get(INSERT_MODAL);
				this.setInsertModalWindow(insertModal);

				String[] modalKeyField = (String[]) map.get(MODAL_KEY_FIELD);
				this.setModalKeyField(modalKeyField);

				Object[] modalKeyValue = (Object[]) map.get(MODAL_KEY_VALUE);
				this.setModalKeyValue(modalKeyValue);

			}

		}

		super.initialize();

	}

	public boolean isNewRecord() {

		return _newRecord;

	}

	public void setNewRecord(boolean newRecord) {

		_newRecord = newRecord;

	}

	public boolean isInsertModalWindow() {

		return _insertModalWindow;

	}

	public void setInsertModalWindow(boolean insertModalWindow) {

		_insertModalWindow = insertModalWindow;

	}

	public String[] getModalKeyField() {

		return _modalKeyField;

	}

	public void setModalKeyField(String[] key) {

		_modalKeyField = key;

	}

	public Object[] getModalKeyValue() {

		return _modalKeyValue;

	}

	public void setModalKeyValue(Object[] key) {

		_modalKeyValue = key;

	}

	public boolean isShowConfirmationMessage() {

		return _showConfirmationMessage;

	}

	public void setShowConfirmationMessage(boolean confirmationMessage) {

		_showConfirmationMessage = confirmationMessage;

	}

	public void setKey(String key) {

		_key.add(key);

	}

	public void setHasSearch(boolean hasSearch) {

		_hasSearch = hasSearch;

	}

	protected boolean hasPicture() {
		return false;
	}

	protected boolean hasInsert() {

		return true;

	}

	protected boolean hasNew() {

		return true;

	}

	protected boolean hasUpdate() {

		return true;

	}

	protected boolean hasDelete() {

		return true;

	}

	protected boolean hasPrint() {

		return false;

	}

	protected boolean hasExtraButton() {

		return false;

	}

	protected String getExtraButtonLabel() {

		return null;

	}

	protected PeButton getNewButton() {

		return _listSearchView.getNewButton();

	}

	protected PeButton getSearchButton() {

		return _listSearchView.getSearchButton();

	}

	protected PeButton getExitButton() {

		return _listSearchView.getExitButton();

	}

	protected PeButton getHelpButton() {

		return _listSearchView.getHelpButton();

	}
	
	 

	protected PeButton getNewDataFormButton() {

		return _dataFormView.getNewButton();

	}

	protected PeButton getSaveButton() {

		return _dataFormView.getSaveButton();

	}

	protected PeButton getDeleteButton() {

		return _dataFormView.getDeleteButton();

	}

	protected PeButton getPrintButton() {

		return _dataFormView.getPrintButton();

	}

	protected PeButton getExtraButton() {

		return _dataFormView.getExtraButton();

	}

	protected PeButton getCloseButton() {

		return _dataFormView.getCloseButton();

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

		if (this.isInsertModalWindow()) {

			this.createModalMode(_mainContainer);

		} else {

			this.createDefaultFormMode(_mainContainer);

		}

		return _mainContainer;

	}

	private void createDefaultFormMode(VerticalPanel container) {

		if (_hasSearch) {

			this.createListSearchView();
			container.add(_listSearchView);

		}

		{
			this.createDataFormView();
			container.add(_dataFormView);
		}

		this.setListSearchViewVisible(_hasSearch);

	}

	private void createModalMode(VerticalPanel container) {

		this.setHasSearch(false);
		this.createDataFormView();
		container.add(_dataFormView);

		if (this.getModalKeyValue() == null) {
			this.createModalInsertMode();
		} else {
			this.createModalUpdateMode();
		}

	}

	private void createModalInsertMode() {

		_newRecord = true;

		this.getMainDataStore().insertRow();
		this.setResponsableByInsert();

		this.onNewRecord();
		this.onShow();

	}

	private void createModalUpdateMode() {

		_newRecord = false;
		this.beforeOpen();
		this.loadModalData();
		this.afterOpen();

		this.setResponsableByUpdate();
		this.onShow();

	}

	private void loadModalData() {

		String criteria = "";
		for (int i = 0; i < this.getModalKeyField().length; i++) {
			criteria += this.getModalKeyField()[i] + " = '"
					+ this.getModalKeyValue()[i] + "' AND ";
		}
		criteria += "0 = 0";

		try {
			this.getMainDataStore().retrieve(criteria);
			this.getMainDataStore().gotoFirst();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setListSearchViewVisible(boolean visible) {

		_dataFormView.setVisible(!visible);

		_listSearchView.setVisible(visible);

		if (visible) {

			_listSearchView.getListView().refresh();

		}

	}

	protected void setListViewSize(String width, String height) {

		_listSearchView.getListView().setWidth(width);
		_listSearchView.getListView().setHeight(height);

	}

	protected void setSearchListingGroupHeight(Integer height) {

		_listSearchView.setSearchListingGroupHeight(height);

	}

	private void createDataFormView() {

		_dataFormView = new DataFormView(
				(this.hasNew() && !this.isInsertModalWindow()),
				this.hasUpdate(), this.hasDelete(), this.hasPrint(),
				this.hasExtraButton(), this.getExtraButtonLabel());

		{
			if (this.hasNew() && !this.isInsertModalWindow()) {

				this.getNewDataFormButton().addEventListener(PeButton.CLICK,
						new PeDelegate(BaseControllerForm.this, "slotDoNew"));

			}

			if (this.hasUpdate()) {

				this.getSaveButton().addEventListener(PeButton.CLICK,
						new PeDelegate(BaseControllerForm.this, "slotDoSave"));

			}

			if (this.hasDelete()) {

				this.getDeleteButton()
						.addEventListener(
								PeButton.CLICK,
								new PeDelegate(BaseControllerForm.this,
										"slotDoDelete"));

			}

			if (this.hasPrint()) {

				this.getPrintButton().addEventListener(PeButton.CLICK,
						new PeDelegate(BaseControllerForm.this, "slotDoPrint"),
						EventType.WAIT);

			}

			if (this.hasExtraButton()) {

				this.getExtraButton().addEventListener(PeButton.CLICK,
						new PeDelegate(BaseControllerForm.this, "slotDoExtra"),
						EventType.WAIT);

			}

			{
				this.getCloseButton().addEventListener(PeButton.CLICK,
						new PeDelegate(BaseControllerForm.this, "slotDoClose"));
			}
		}

		this.setupDataForm();
	}

	protected void createListSearchView() {

		_listSearchView = new ListSearchView(this.hasInsert());
		{
			_listSearchView.getListView().setDataStore(this.getMainDataStore());

			_listSearchView.getListView().setOnCellClick(
					new NotifyDelegate(BaseControllerForm.this, "slotDoGrid"));

			this.getSearchButton().addEventListener(PeButton.CLICK,
					new PeDelegate(BaseControllerForm.this, "slotDoSearch"),
					EventType.WAIT);

			if (this.hasInsert()) {

				this.getNewButton().addEventListener(PeButton.CLICK,
						new PeDelegate(BaseControllerForm.this, "slotDoNew"));

			}

			this.getHelpButton().addEventListener(PeButton.CLICK,
					new PeDelegate(BaseControllerForm.this, "slotDoHelp"));

			this.getExitButton().addEventListener(PeButton.CLICK,
					new PeDelegate(BaseControllerForm.this, "slotDoExit"));
		}

		this.setupSearch();
	}

	protected void addSearchFieldComponent(String caption, PeWidget<?> comp) {

		_listSearchView.addSearchFieldComponent(caption, comp);

	}

	protected void setDataFormInnerLayout(PeWidget<?> inner) {

		_dataFormView.setDataFormInnerLayout(inner);

	}

	protected void addListColumn(String caption, String alinhamento, int width,
			String campo) {

		_listSearchView.addListingColumn(campo, ListView.CTYPE_READONLY,
				caption, width, alinhamento);

	}

	protected void addListColumn(String caption, String alinhamento, int width,
			String campo, ColumnType type) {

		_listSearchView.addListingColumn(campo, type, caption, width,
				alinhamento);

	}

	 
	
	
	
	protected void slotDoSearch(PeEventObject e) {

		try {

			if (this.isSearchValid())
				this.performSearch();

		} catch (Exception ex) {

			MessageLog.writeErrorMessage("Erro ao pesquisar", ex, this);
			this.showErrorMessage(ex.getMessage());

		}

	}

	protected boolean isSearchValid() {
		return true;
	}

	private void performSearch() throws SQLException {

		String msg;
		this.getMainDataStore().retrieve(this.getSQLSearch());

		if (this.getMainDataStore().getRowCount() == 0) {

			msg = "<center>Nenhum registro foi encontrado!</center>"
					+ "<br><br>Refaça a pesquisa com outro critério de busca ";

			if (this.hasInsert()) {
				msg += "ou clique no botão \"Novo\" para inserir um novo registro.";
			}

			this.showInfoMessage(msg);

		}

		this._listSearchView.getListView().refresh();
	}

	protected int getReturnedRowsMaxLimit() {

		return 50;

	}

	protected void slotDoGrid(NotifyEvent event) {

		_newRecord = false;
		if (this.hasDelete()) {
			this.getDeleteButton().setEnable(true);
		}

		this.beforeOpen();
		this.performOpening(event);
		this.afterOpen();

		this.onShow();

		this.setListSearchViewVisible(false);
	}

	private void performOpening(NotifyEvent event) {

		int row = _listSearchView.getListView().getSelectedRow();
		this.getMainDataStore().gotoRow(row);

		try {
			this.setResponsableByUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.showErrorMessage(ex.getMessage());
		}

	}

	protected void slotDoNew(PeEventObject e) {

		_newRecord = true;
		if (this.hasDelete()) {
			this.getDeleteButton().setEnable(false);
		}

		this.getMainDataStore().insertRow();

		this.setResponsableByInsert();

		this.onNewRecord();
		this.onShow();

		if (this._hasSearch)
			this.setListSearchViewVisible(false);

	}

	protected void slotDoSave(PeEventObject e) {

		this.saveRecord();

	}

	protected void slotDoPrint(PeEventObject e) {

	}

	protected void slotDoExtra(PeEventObject e) {

	}

	protected void saveRecord() {
		try {

			if (this.isDataValidated()) {

				this.performSaving();

				if (this.isInsertModalWindow()) {

					this.showInfoMessage("Os dados foram salvos com sucesso.");

					String keyField = (String) _key.get(0);
					Object id = this.getMainDataStore().getAny(keyField);
					this.close(id);

				} else if (this.isShowConfirmationMessage()) {

					this.showInfoMessage("Os dados foram salvos com sucesso.");

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
			this.showErrorMessage(e.getMessage());

		}
	}

	protected void performSaving() throws SQLException {

		this.beforeSave();
		this.getMainDataStore().update();
		_newRecord = false;
		this.afterSave();

	}

	protected boolean isDataValidated() {

		return true;

	}

	protected void slotDoDelete(PeEventObject e) {

		this.confirmDelete();

	}

	protected void confirmDelete() {

		PeMessages.confirmDialog("Confirmação de Exclusão",
				"Deseja realmente excluir este registro?", new PeDelegate(this,
						"deleteClickAction"));

	}

	protected void deleteClickAction(PeEventObject e) {

		String paramClicked = e.getString(PeMessages.PARAM_CLICKED);

		if (PeMessages.Action.OK.toString().equals(paramClicked)) {

			this.deleteRecord();

		}

	}

	protected void deleteRecord() {

		if (this.canBeDeleted()) {

			this.beforeDelete();
			this.getMainDataStore().deleteRow();
			this.afterDelete();

			try {

				this.getMainDataStore().update();
				this.showWarningMessage("Registro excluído com sucesso.");

				if (this.isInsertModalWindow()) {
					this.close();
				} else if (this._hasSearch) {
					this.closeDataForm();
				}

			} catch (Exception ex) {

				ex.printStackTrace();
				this.showErrorMessage(ex.getMessage());

			}
		}
	}

	protected boolean canBeDeleted() {

		return true;

	}

	protected void slotDoExit(PeEventObject e) {

		this.exitUseCase();

	}

	protected void slotDoHelp(PeEventObject e) {

	}

	protected void slotDoClose(PeEventObject e) {
		 
		if (_hasSearch) {
			int row = this.getMainDataStore().getRowCount() - 1;
			if (this.getMainDataStore().getAny(row, _key.get(0)) == null) {
				if (row > 0)
					this.slotDoSearch(null);
				else
					this.getMainDataStore().reset();
			}

			this.closeDataForm();
		} else {
			this.exitUseCase();
		} 
		/*
		  if (_hasSearch) {
	        	this.closeDataForm();
	        } else {
	        	this.exitUseCase();
	        }*/
	}

	private void closeDataForm() {

		this.beforeCloseDataForm();
		this.setListSearchViewVisible(true);
		this.afterCloseDataForm();

	}

	protected void onNewRecord() {
	}

	protected void beforeSave() {
	}

	protected void afterSave() {
	}

	protected void beforeDelete() {
	}

	protected void afterDelete() {
	}

	protected void beforeCloseDataForm() {
	}

	protected void afterCloseDataForm() {
	}

	protected void beforeOpen() {
	}

	protected void afterOpen() {
	}

	protected void onShow() {
	}

	protected void setResponsableByInsert() {

		Timestamp fmt_data = new Timestamp(System.currentTimeMillis());
		String user = (String) PeFacesApplication.getInstance().getAttribute(DSUsuario.EN_USUARIO_ID_USUARIO);
		String table = this.getMainDataStore().getTable(0);

		try {

			this.getMainDataStore().setString(table + ".id_usuario_cad", user);
			this.getMainDataStore().setDateTime(table + ".dt_cadastro",
					fmt_data);

		} catch (DataStoreException e) {
			e.printStackTrace();
		}
	}

	protected void setResponsableByUpdate() {

		Timestamp fmt_data = new Timestamp(System.currentTimeMillis());
		String user = (String) PeFacesApplication.getInstance().getAttribute(DSUsuario.EN_USUARIO_ID_USUARIO);
		String table = this.getMainDataStore().getTable(0);

		this.getMainDataStore().setString(table + ".id_usuario_alt", user);
		this.getMainDataStore().setDateTime(table + ".dt_alteracao", fmt_data);

	}

	public class SearchTrigger implements KeyUpListener {

		private static final long serialVersionUID = 1L;

		@Override
		public void onKeyUp(KeyUpEvent event) {

			getSearchButton().fireEvent(PeButton.CLICK);

		}

	}

}
