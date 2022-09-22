package performer.contabil.viewcontroller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DBConnection;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ListView;
import framework.web.gui.widget.Text;
import performer.contabil.controller.BaseControllerModal;
import performer.contabil.persistence.DSTemp;

public class PossivelDuplicidadeController extends BaseControllerModal {

	public DSTemp _DSTemp;
	public ListView _listaPossivelDuplicidade;
	public Text _txtOrientacoes;
	public Text _txtTotal;
	private PeButton _btnSair;
	DBConnection con = null;
	Statement stmt = null;

	
	
	public PossivelDuplicidadeController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public PossivelDuplicidadeController(ModalArgument modalArgument) {
		super(modalArgument);

	}
	
	
	
	@Override
	protected void onShowModal() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getCaption() {
		// TODO Auto-generated method stub
		return "Possíveis Duplicidades";
	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {
		// TODO Auto-generated method stub
		_DSTemp = new DSTemp(getApplicationName());

	}

	@Override
	protected PeWidget<?> getViewComponent() {
		BasicDetail detail = new BasicDetail("$detail$", this, _DSTemp, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(950);
		detail.setHeight(550);
		this.initVisualComps();
		this.addVisualComps(detail);
		return detail;

	}

	private void initVisualComps() {

		_txtOrientacoes = new Text("Verifique se os registros abaixo são possíveis duplicidades!", this);
		_txtOrientacoes.setCustomStyle("color: red ");

		_txtTotal = new Text("Total: 0", this);
		_txtTotal.setCustomStyle("color: red ");

		
		_listaPossivelDuplicidade = new ListView("ListaPontosIrregulares", this);
		_listaPossivelDuplicidade.setDataStore(_DSTemp);
		_listaPossivelDuplicidade.addColumn(DSTemp.EN_TEMP_TEMP1, ListView.CTYPE_READONLY, "Código", 70, "center", "#d5f1ff");
		_listaPossivelDuplicidade.addColumn(DSTemp.EN_TEMP_TEMP2, ListView.CTYPE_READONLY, "Nome", 300, "left", "#d5f1ff");
		_listaPossivelDuplicidade.setHeight(200);
		_listaPossivelDuplicidade.setWidth(380);
		// _listaPossivelDuplicidade.setOnCellClick(new NotifyDelegate(this,
		// "slotJustificarClick"));
		
		
		PeButton.Attributes attr = new PeButton.Attributes();
		attr.setText("Sair");
		_btnSair = new PeButton(attr);
		_btnSair.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotSairClick"));

		
		
		
		String sql = (String) PeFacesApplication.getInstance().getAttribute("SQL_DUPLICIDADE");
        Integer total = 0;
		try {
			try {
				con = DBConnection.getConnection(getApplicationName());
				stmt = con.createStatement();

				ResultSet A = stmt.executeQuery(sql);

				while (A.next()) {
					total  = total  + 1;
                 _DSTemp.insertRow();
                 _DSTemp.setEnTempTemp1( A.getString(1));
                 _DSTemp.setEnTempTemp2( A.getString(2));
                 
				}
				_txtTotal.setText("Total: " + total + "");
				
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		} finally {
			_listaPossivelDuplicidade.refresh();
			
			if (con != null) {
				con.freeConnection();
				con = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				stmt = null;
			}

		}
		
	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 1 });
		{
			detail.addField(" ", _txtOrientacoes);
			detail.addField(" ", _listaPossivelDuplicidade);
			detail.addField(" ", _txtTotal);
			
			detail.addField(" ", _btnSair);
		}
	}

	
	public void slotSairClick(PeEventObject e) {

		this.close();

	}
}
