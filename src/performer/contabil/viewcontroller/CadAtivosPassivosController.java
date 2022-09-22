package performer.contabil.viewcontroller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.adobe.serialization.json.JSONSerializable;
import com.performer.core.IPeEventListener;
import com.performer.core.PeDelegate;
import com.performer.core.PeEventObject;
import com.performer.faces.PeButton;
import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeImage;
import com.performer.faces.PeMessages;
import com.performer.faces.PeWidget;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.BasicDetail;
import framework.web.gui.widget.ComboBoxLookup;
import framework.web.gui.widget.DateEdit;
import framework.web.gui.widget.ListView;
import framework.web.gui.widget.Text;
import framework.web.gui.widget.TextEdit;
import framework.web.gui.widget.events.ICloseListener;
import performer.contabil.controller.BaseControllerForm;
import performer.contabil.persistence.DSAtivoPassivo;
import performer.contabil.persistence.DSEmpresa;
import performer.contabil.persistence.DSHistoricoLancamento;
import performer.contabil.persistence.DSTipoLancamento;
import performer.contabil.utils.Utils;

public class CadAtivosPassivosController extends BaseControllerForm {
	
	
	public static enum MenuCodes implements JSONSerializable {
		// w h
		Default(0, 0),
		RelAtivoPassivoAnual(450, 300);

		private final int width;
		private final int height;

		private MenuCodes(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public Object getData() {
			return this.ordinal();
		}

		public static MenuCodes valueOf(int code) {
			MenuCodes[] items = MenuCodes.values();
			for (int i = 0, iSize = items.length; i < iSize; i++) {
				if (items[i].ordinal() == code) {
					return items[i];
				}
			}
			return MenuCodes.Default;
		}

	}
	
	
	

	// Data Store
	private DSTipoLancamento _DSTipoLancamentoPesquisa;
	private DSEmpresa _DSEmpresa;
	private DSEmpresa _DSEmpresaPesquisa;
	private DSAtivoPassivo _DSAtivoPassivo;
	private DSAtivoPassivo _DSAtivoPassivoCRUD;
	private DSHistoricoLancamento _DSHistoricoLancamento;
	private DSHistoricoLancamento _DSHistoricoLancamentoPesquisa;
	private PeButton _btnProximoMes;

	// Visual Comps Pesquisa
	private ComboBoxLookup _cbxTipoLancamentoPesquisa;
	private ComboBoxLookup _cbxEmpresaPesquisa;
	private ComboBoxLookup _cbxHistoricoPesquisa;
	private DateEdit _edtDataIncioPesquisa;
	private DateEdit _edtDataFimPesquisa;
	private TextEdit _edtPaginaPesquisa;

	// Visual Comps
	
 
	private TextEdit _edtNuPagina;
	private TextEdit _edtCodigo;
	private ComboBoxLookup _cbxEmpresa;
	private DateEdit _edtDtHistorico;
    private Text _txtBrancoPesquisa;
	private PeImage _btnIncluirHistorico;
	private PeImage _btnAlterarHistorico;
	private TextEdit _edtQuantidadeConsumo;
	private TextEdit _edtValorCredito;
	private TextEdit _edtValorDebito;
	private ComboBoxLookup _cbxHistorico;

	private Text _txtBranco1;
	public short AbreHistorico;
 

	public PeButton _btnTemp;

	public CadAtivosPassivosController() {
		this(null);

	}

	@SuppressWarnings("unchecked")
	public CadAtivosPassivosController(ModalArgument modalArgument) {
		super(modalArgument);

	}

	@Override
	protected String getCaption() {

		return "Cadastro de Ativos e Passivos";

	}

	@Override
	protected void afterOpen() {

		_cbxEmpresa.setValue(_DSAtivoPassivo.getEnAtivoPassivoCdEmpresa());
		
		
		

		String valor = null;

		if (_DSAtivoPassivo.getEnAtivoPassivoVlCredito() > 0) {
			valor = Utils.doubleToStr(_DSAtivoPassivo.getEnAtivoPassivoVlCredito(), 0);
		}
		_edtValorCredito.setValue(valor);

		
		
		_edtNuPagina.setValue(_DSAtivoPassivo.getEnAtivoPassivoNuPagina()+"");
		
		
		
		valor = "";
		if (_DSAtivoPassivo.getEnAtivoPassivoVlDebito() > 0) {
			valor = Utils.doubleToStr(_DSAtivoPassivo.getEnAtivoPassivoVlDebito(), 0);
		}
		_edtValorDebito.setValue(valor);

		_edtDtHistorico.setValue(_DSAtivoPassivo.getEnAtivoPassivoDtHistorico());

		if (_DSAtivoPassivo.getEnAtivoPassivoQtConsumo() > 0) {
			_edtQuantidadeConsumo.setValue(_DSAtivoPassivo.getEnAtivoPassivoQtConsumo() +"");
		}
		else {
			_edtQuantidadeConsumo.setValue(null);
		}
		
	}

	@Override
	protected DataStore getMainDataStore() {
		// TODO Auto-generated method stub
		return _DSAtivoPassivo;
	}

	@Override
	protected void setupDataForm() {
		// TODO Auto-generated method stub

		this.setKey(DSAtivoPassivo.EN_ATIVO_PASSIVO_CD_ATIVO_PASSIVO);
		this.setKey(DSAtivoPassivo.EN_ATIVO_PASSIVO_NU_ANO);
		this.setDataFormInnerLayout(this.createFormLayout());

	}

	private PeWidget<?> createFormLayout() {

		BasicDetail detail = new BasicDetail("$detail$", this, _DSAtivoPassivo, true);
		detail.setCurrentLayout(BasicDetail.LAYOUT_FLOW_COLUMNS);
		detail.setCaptionTop(true);
		detail.setWidth(720);
		detail.setHeight(350);

		this.initVisualComps();
		this.addVisualComps(detail);

		return detail;

	}

	private void initVisualComps() {
		
		
		
		 
		
		

		PeImage.Attributes attrs = new PeImage.Attributes();
		attrs.setImage("images/pag_add.gif");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE);
		_btnIncluirHistorico = new PeImage(attrs);
		_btnIncluirHistorico.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotOnIncluirHistoricoClick"),
				EventType.WAIT);
		_btnIncluirHistorico.setHint("Clique aqui para incluir um novo histórico.");

		attrs.setImage("images/pag_edit.gif");
		attrs.setImageState(PeImage.ImageState.NORMAL | PeImage.ImageState.SELECTED | PeImage.ImageState.PRESSED
				| PeImage.ImageState.DISABLE);
		_btnAlterarHistorico = new PeImage(attrs);
		_btnAlterarHistorico.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotOnAlterarHistoricoClick"),
				EventType.WAIT);
		_btnAlterarHistorico.setHint("Clique aqui para alterar o histórico selecionado  na listagem.");

		_edtCodigo = new TextEdit("codigo", this);
		{
			_edtCodigo.setReadOnly(true);
			_edtCodigo.setWidth(100);
			_edtCodigo.setColumn(_DSAtivoPassivo, DSAtivoPassivo.EN_ATIVO_PASSIVO_CD_ATIVO_PASSIVO);
		}
		
		_edtNuPagina= new TextEdit("pg", this);
		
		
		
		
		

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
		_cbxEmpresa = new ComboBoxLookup("empresa", this);
		{
			_cbxEmpresa.setLookupInfo(_DSEmpresa, DSEmpresa.EN_EMPRESA_CD_EMPRESA, DSEmpresa.EN_EMPRESA_DE_SIGLA);

			_cbxEmpresa.setValue(empresa_selecionada);
			_cbxEmpresa.setEnable(false);
		}

		_edtDtHistorico = new DateEdit("data", this);
		
		_edtQuantidadeConsumo = new TextEdit("qtd", this);

		_edtValorCredito = new TextEdit("valorC", this);

		_edtValorDebito = new TextEdit("valorD", this);

		_cbxHistorico = new ComboBoxLookup("hist", this);
		_cbxHistorico.setLookupInfo(_DSHistoricoLancamento,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
		_cbxHistorico.setColumn(_DSAtivoPassivo, DSAtivoPassivo.EN_ATIVO_PASSIVO_CD_HISTORICO_LANCAMENTO);

		_txtBranco1 = new Text("", this);

		PeButton.Attributes attr = new PeButton.Attributes();
		attr.setText("Gera Historico Anual");
		_btnTemp = new PeButton(attr);
		

		
		attr.setText("Próximo Mês");
		_btnProximoMes  = new PeButton(attr);
		_btnProximoMes.addEventListener(PeButton.CLICK, new PeDelegate(this, "slotProximoMes"), EventType.WAIT);

	}

	private void addVisualComps(BasicDetail detail) {

		detail.addTable(new int[] { 2, 1, 5 });
		{
			detail.addField("Empresa: ", _cbxEmpresa);
			detail.addField("Data do Histórico ", _edtDtHistorico);
			detail.addField(" ", _txtBranco1);
		}

		detail.addTable(new int[] { 30, 1, 1 });
		{

			detail.addField("Histórico: ", _cbxHistorico);
			detail.addField("Incluir", _btnIncluirHistorico);
			detail.addField("Alterar", _btnAlterarHistorico);
		}

		detail.addTable(new int[] { 1, 1,1,1  });
		{

			detail.addField("Valor Crédito: ", _edtValorCredito);
			detail.addField("Valor Débito: ", _edtValorDebito);
			detail.addField("Quantidade Consumo: ", _edtQuantidadeConsumo);
			detail.addField("Nº Página: ", _edtNuPagina);
		}
		detail.addTable(new int[] { 1  });
		{

			detail.addField("  ", _btnProximoMes);
			 
		}
	}

	@Override
	protected void initDataStores() throws SQLException, DataStoreException {

		String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSAtivoPassivo = new DSAtivoPassivo(this.getApplicationName());

		_DSAtivoPassivoCRUD = new DSAtivoPassivo(this.getApplicationName());
		
		
		_DSTipoLancamentoPesquisa = new DSTipoLancamento(this.getApplicationName());
		_DSTipoLancamentoPesquisa.retrieve(DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_EMPRESA + " = " + empresa_selecionada); 
		

		_DSHistoricoLancamento = new DSHistoricoLancamento(this.getApplicationName());
		_DSHistoricoLancamento.retrieve(DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_EMPRESA + " = "
				+ empresa_selecionada + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_FG_ATIVO + " = 'S'");

		_DSHistoricoLancamentoPesquisa = new DSHistoricoLancamento(this.getApplicationName());
		_DSHistoricoLancamentoPesquisa.retrieve(DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_EMPRESA + " = "
				+ empresa_selecionada + " and " + DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_FG_ATIVO + " = 'S'");

		_DSEmpresa = new DSEmpresa(this.getApplicationName());
		_DSEmpresa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa_selecionada);

		_DSEmpresaPesquisa = new DSEmpresa(this.getApplicationName());
		_DSEmpresaPesquisa.retrieve(DSEmpresa.EN_EMPRESA_CD_EMPRESA + " = " + empresa_selecionada);

	}

	@Override
	protected String getSQLSearch() {
		// TODO Auto-generated method stub

		String criteria = DSAtivoPassivo.EN_ATIVO_PASSIVO_FG_EXCLUIDO + " is null ";
        String tipoLancamento = (String) _cbxTipoLancamentoPesquisa.getValue();
		String empresa = (String) _cbxEmpresaPesquisa.getValue();
		String codigoHistorico = (String) _cbxHistoricoPesquisa.getValue();
		Date dataInicio = _edtDataIncioPesquisa.getValue();
		Date dataFim = _edtDataFimPesquisa.getValue();
		SimpleDateFormat _sdfBrasil = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat _sdfUSA = new SimpleDateFormat("yyyy/MM/dd");
        String pagina = _edtPaginaPesquisa.getValue();
		
		
        
        if (pagina != null) {
        	criteria = criteria + " and " + DSAtivoPassivo.EN_ATIVO_PASSIVO_NU_PAGINA + " = " + pagina;
        }
		
		
		if (tipoLancamento != null) {
			criteria = criteria + " and " + DSAtivoPassivo.EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO + " = " + tipoLancamento;
		}
		
		
		
		if (empresa != null) {

			criteria = criteria + " and " + DSAtivoPassivo.EN_ATIVO_PASSIVO_CD_EMPRESA + " = " + empresa + " ";
		} else {
			criteria = criteria + " and " + DSAtivoPassivo.EN_ATIVO_PASSIVO_CD_EMPRESA + " = -1 ";
		}

		if (codigoHistorico != null) {

			criteria = criteria + " and "
					+ DSAtivoPassivo.EN_ATIVO_PASSIVO_CD_HISTORICO_LANCAMENTO + " = " + _DSHistoricoLancamentoPesquisa
							.getEnHistoricoLancamentoCdHistoricoLancamento(_cbxHistoricoPesquisa.getSelectedIndex())
					+ " ";
		}

		if (dataInicio != null && dataFim == null) {

			criteria = criteria + "and to_char(en_ativo_passivo.dt_historico,'dd/mm/yyyy') = '"
					+ _sdfBrasil.format(dataInicio.getTime()) + "'";
		}

		if (dataInicio != null && dataFim != null) {

			criteria = criteria + "and en_ativo_passivo.dt_historico between '" + _sdfUSA.format(dataInicio.getTime())
					+ " 00:00:00' and '" + _sdfUSA.format(dataFim.getTime()) + " 23:59:59' ";
		}

		return criteria;
	}

	@Override
	protected void setupSearch() {
		setListViewSize("800", "300");
		this.initSearchFields();
		this.setSearchFields();
		this.setSearchView();
	}

	private void initSearchFields() {
		
		_txtBrancoPesquisa = new Text("",this);
		
		
		_edtPaginaPesquisa = new TextEdit("",this);
		
		
		_cbxTipoLancamentoPesquisa = new ComboBoxLookup("tp", this);
		_cbxTipoLancamentoPesquisa.setLookupInfo(_DSTipoLancamentoPesquisa, DSTipoLancamento.EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO, DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO); 

		_cbxEmpresaPesquisa = new ComboBoxLookup("emp", this);
		_cbxEmpresaPesquisa.setLookupInfo(_DSEmpresaPesquisa, DSEmpresa.EN_EMPRESA_CD_EMPRESA,
				DSEmpresa.EN_EMPRESA_DE_SIGLA);
		_cbxEmpresaPesquisa.setValue((String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA"));
		_cbxEmpresaPesquisa.setEnable(false);

		_cbxHistoricoPesquisa = new ComboBoxLookup("hp", this);
		_cbxHistoricoPesquisa.setLookupInfo(_DSHistoricoLancamentoPesquisa,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO,
				DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
		_edtDataIncioPesquisa = new DateEdit("ini", this);
		_edtDataFimPesquisa = new DateEdit("ini", this);
		
		Calendar calendar = Calendar.getInstance();
		int mes = calendar.get(GregorianCalendar.MONTH);
		int ano = calendar.get(GregorianCalendar.YEAR);
		
		_edtDataIncioPesquisa.setValue( Utils.PrimeiroDiaMes(Short.parseShort((mes+1)+""), ano));
		
		_edtDataFimPesquisa.setValue( calendar.getTime());
		
		
		
		
 

		_cbxHistoricoPesquisa.setOnKeyUpListener(new int[] { ENTER_KEY }, new SearchTrigger());

	}

	private void setSearchFields() {
		this.addSearchFieldComponent("Empresa:", _cbxEmpresaPesquisa);
		this.addSearchFieldComponent("Histórico:", _cbxHistoricoPesquisa);
		this.addSearchFieldComponent("Data Inicio:", _edtDataIncioPesquisa);
		this.addSearchFieldComponent("Data Fim:", _edtDataFimPesquisa);
		this.addSearchFieldComponent("Tipo:", _cbxTipoLancamentoPesquisa);
		this.addSearchFieldComponent("Nº Página", _edtPaginaPesquisa);
	}

	private void setSearchView() {
		this.addListColumn("Empresa", "center", 50, DSAtivoPassivo.EN_EMPRESA_DE_SIGLA);
		this.addListColumn("Data Histórico", "center", 80, DSAtivoPassivo.EN_ATIVO_PASSIVO_DT_HISTORICO,	ListView.CTYPE_DATE);
		this.addListColumn("Histórico", "left", 200, DSAtivoPassivo.EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
		this.addListColumn("Tipo", "left", 100, DSTipoLancamento.EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
		
		this.addListColumn("Crédito", "right", 100, DSAtivoPassivo.EN_ATIVO_PASSIVO_VL_CREDITO, ListView.CTYPE_PRICE);
		this.addListColumn("Débito", "right", 100, DSAtivoPassivo.EN_ATIVO_PASSIVO_VL_DEBITO, ListView.CTYPE_PRICE);
 		this.addListColumn("Consumo", "center", 50, DSAtivoPassivo.EN_ATIVO_PASSIVO_QT_CONSUMO, ListView.CTYPE_READONLY);
 		this.addListColumn("Página", "center", 50, DSAtivoPassivo.EN_ATIVO_PASSIVO_NU_PAGINA, ListView.CTYPE_READONLY);

	}

	@Override
	protected boolean isDataValidated() {
		// TODO Auto-generated method stub

		String empresa = (String) _cbxEmpresa.getValue();
		String codigoHistorico = (String) _cbxHistorico.getValue();
		String credito = _edtValorCredito.getValue();
		String debito = _edtValorDebito.getValue();
		Date dataHistorico = _edtDtHistorico.getValue();
		 

		if (dataHistorico == null) {
			this.showErrorMessage("A data do histórico deve ser informada!");
			return false;
		} else if (codigoHistorico == null) {
			this.showErrorMessage("O Histórico do lançamento deve ser informado!");
			return false;
		}
		if (credito == null && debito == null) {
			this.showErrorMessage("O valor do Débito ou Crédito deve ser informado!");
			return false;
		}
       
		else
			return true;

		
		
		
	}

	@Override
	protected void beforeSave() {

		GregorianCalendar dataCal = new GregorianCalendar();
		dataCal.setTime(_edtDtHistorico.getValue());
		int mes = dataCal.get(Calendar.MONTH);
		int ano = dataCal.get(Calendar.YEAR);

		_DSAtivoPassivo.setEnAtivoPassivoNuAno(Short.parseShort(ano + ""));
		_DSAtivoPassivo.setEnAtivoPassivoNuMes(Short.parseShort(mes+1 + ""));

		String empresa = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");

		_DSAtivoPassivo.setEnAtivoPassivoCdEmpresa(Short.parseShort(empresa));

		if ((String) _cbxHistorico.getValue() == null) {
			_DSAtivoPassivo.setEnAtivoPassivoCdHistoricoLancamento(0);

		}

		Timestamp dataHistorico = new java.sql.Timestamp(_edtDtHistorico.getValue().getTime());
		_DSAtivoPassivo.setEnAtivoPassivoDtHistorico(dataHistorico);

		if (_edtValorCredito.getValue() != null && !(_edtValorCredito.getValue().trim().equals(""))) {
			_DSAtivoPassivo.setEnAtivoPassivoVlCredito(Utils.strToDouble(_edtValorCredito.getValue()));
		} else {
			_DSAtivoPassivo.setEnAtivoPassivoVlCredito(0);
		}
		
		if (_edtValorDebito.getValue() != null && !(_edtValorDebito.getValue().trim().equals(""))) {
			_DSAtivoPassivo.setEnAtivoPassivoVlDebito(Utils.strToDouble(_edtValorDebito.getValue()));
		} else {
			_DSAtivoPassivo.setEnAtivoPassivoVlDebito(0);
		}
		
		if (_edtQuantidadeConsumo.getValue() != null && !(_edtQuantidadeConsumo.getValue().trim().equals(""))) {
			_DSAtivoPassivo.setEnAtivoPassivoQtConsumo(Integer.parseInt(_edtQuantidadeConsumo.getValue()));
		} else {
			_DSAtivoPassivo.setEnAtivoPassivoQtConsumo(Integer.parseInt("0"));
		}
		
		
		if (_edtNuPagina.getValue() != null && !(_edtNuPagina.getValue().trim().equals(""))) {
			_DSAtivoPassivo.setEnAtivoPassivoNuPagina(Integer.parseInt(_edtNuPagina.getValue()));
		} else {
			_DSAtivoPassivo.setEnAtivoPassivoNuPagina(0);
		}
		
	}

	@Override
	protected void onNewRecord() {
		_edtValorCredito.setValue(null);
		_edtValorDebito.setValue(null);
		_edtQuantidadeConsumo.setValue(null);
		 
	 
	}

	public void slotOnIncluirHistoricoClick(PeEventObject e) {

		Map<String, Object> param = new HashMap<String, Object>();
		Boolean insertModal = new Boolean(Boolean.TRUE);

		param.put(BaseControllerForm.INSERT_MODAL, insertModal);

		this.showModal("CadHistoricoLancamentos", 800, 600, param, new OnCloseHistorico());

	}

	public void slotOnAlterarHistoricoClick(PeEventObject e) {

		String[] fields = { DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO };
		Object[] values = { _DSHistoricoLancamento
				.getEnHistoricoLancamentoCdHistoricoLancamento(_cbxHistorico.getSelectedIndex()) };
		Map<String, Object> param = new HashMap<String, Object>();
		{
			param.put(BaseControllerForm.INSERT_MODAL, true);
			param.put(BaseControllerForm.MODAL_KEY_FIELD, fields);
			param.put(BaseControllerForm.MODAL_KEY_VALUE, values);
		}

		this.showModal("CadHistoricoLancamentos", 850, 500, param, new OnCloseHistorico());

	}

	class OnCloseHistorico implements ICloseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void onCloseEvent(Object e) {
			String empresa_selecionada = (String) PeFacesApplication.getInstance().getAttribute("EMPRESA_SELECIONADA");
			try {
				_DSHistoricoLancamento.retrieve(DSHistoricoLancamento.EN_HISTORICO_LANCAMENTO_FG_ATIVO
						+ " = 'S' AND en_historico_lancamento.CD_EMPRESA = " + empresa_selecionada);
			} catch (DataStoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			_cbxHistorico.populateOptions();

		}
	}

	@Override
	protected void slotDoDelete(PeEventObject e) {

		PeMessages.confirmDialog("Confirmação", "Deseja Realmente excluir o lançamento atual? ",
				new IPeEventListener() {

					private static final long serialVersionUID = 1L;

					public void handleEvent(PeEventObject event) {
						if (event.getString(PeMessages.PARAM_CLICKED) == "OK") {

							_DSAtivoPassivo.setEnAtivoPassivoFgExcluido("S");

							if (_DSAtivoPassivo.getEnAtivoPassivoVlCredito() > 0) {
								_DSAtivoPassivo.setEnAtivoPassivoVlDebito(_DSAtivoPassivo.getEnAtivoPassivoVlCredito());
							} else {
								_DSAtivoPassivo.setEnAtivoPassivoVlCredito(_DSAtivoPassivo.getEnAtivoPassivoVlDebito());
							}

							 
								try {
									_DSAtivoPassivo.update();
								} catch (DataStoreException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							 

							showInfoMessage("Lancamento cancelado com sucesso!");
						}
					}
				});

	}

	 

	@Override
	protected void afterSave() {
		// Ajusta saldos
		// Somente Alteração ajusta os saldos
		if (_DSAtivoPassivo.getEnAtivoPassivoIdUsuarioAlt() != null) {

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date dataHistorico = _edtDtHistorico.getValue();
			String strHistorico = format.format(dataHistorico);

			 
			

		}
		
		 
	}

	 

	 
	
	protected void slotProximoMes(PeEventObject e) {
		
		if (_edtDtHistorico.getValue() == null) {
			showErrorMessage("Não existe data de histórico para gerar o próximo mês!");
		} else {
			
			 
			
			Date dataHist = _edtDtHistorico.getValue();
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(dataHist);
		 
			cal.add(Calendar.MONTH, 1);
			 			
			String hist = (String) _cbxHistorico.getValue();
					
			_DSAtivoPassivo.insertRow();
			
			
			_cbxHistorico.setValue(hist);
			_edtDtHistorico.setValue(cal.getTime());
			
			_edtValorCredito.setValue(null);
			_edtValorDebito.setValue(null);
			_edtQuantidadeConsumo.setValue(null);
			
			
			
		}
		
		
	}

	@Override
	protected boolean hasExtraButton() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected String getExtraButtonLabel() {
		// TODO Auto-generated method stub
		return "Saldo Atual";
	}

	

	@Override
	protected void slotDoExtra(PeEventObject e) {
	
		 showModal(MenuCodes.RelAtivoPassivoAnual.name() , MenuCodes.RelAtivoPassivoAnual.getWidth() , MenuCodes.RelAtivoPassivoAnual.getHeight());
	}
	
	

	 
	
	
}
