package performer.contabil.utils;

 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.structs.PeUploadedFile;
import com.salmonllc.html.HtmlPage;
import com.salmonllc.sql.DBConnection;
import com.salmonllc.sql.DSColumnDescriptor;
import com.salmonllc.sql.DSDataStoreDescriptor;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.ImageButton;
import framework.web.util.SOFIAPaths;

public class utilsRH {

    public static final String FLOAT_PATTERN = "^([0-9]{1,3}|[0-9]{1,3},[0-9]{0,2})$";
    
    public static final String INTEGER_PATTERN = "^([0-9]{1,10})$";
    
    public static final String CURRENCY_EXPRESSION = "^([0-9]{1,5}|[0-9]{1,5},[0-9]{0,2})$";

    private static ResourceBundle rb;
    
    
    public static java.sql.Date getCurrentSQLDate()
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        
        return new java.sql.Date(c.getTimeInMillis());
    }

    public static java.sql.Date getCurrentSQLSERVERDate( String applicationName)
    {
        PreparedStatement pst;
	    DBConnection conn = null;
	    ResultSet rs = null;
        Calendar c = Calendar.getInstance();
	    
		try {
			conn = DBConnection.getConnection( applicationName );
			String sql = "select getdate()";

			pst = conn.prepareStatement( sql );
	   	   	rs = pst.executeQuery();
	   	   	rs.next();
	   	   	
	   	   	c.setTime( rs.getDate(1) );
	        c.set(Calendar.HOUR, 0);
	        c.set(Calendar.MINUTE, 0);
	        c.set(Calendar.SECOND, 0);
	        c.set(Calendar.MILLISECOND, 0);
	        
	   	   	conn.freeConnection();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
        
        return new java.sql.Date(c.getTimeInMillis());
    }
    
    /**
     * Marcellus
     * @param data
     * @return
     */
    public static java.sql.Date getSQLDate(String data) {
		if (data == null)
			return null;
		String[] dataSplit = data.split("/");
		String dataSql = null;
		if (dataSplit.length > 0) {
			dataSql = dataSplit[2] + "-" + dataSplit[1] + "-" + dataSplit[0];
		}
		java.sql.Date dt = null;
		try {
			dt = java.sql.Date.valueOf(dataSql);
		} catch (Exception e) {
			dt = null;
		}
		return dt;
	}
    
    /**
     * @param p(HtmlPage)
     * @return String
     */
    public static String getPathsImages(HtmlPage p) {
        SOFIAPaths path = new SOFIAPaths(p);
        return path.getAppImagePath() + "/icones/";
    }

    
 public static String formatDateAsString(Date date, boolean isSQLParam) {
    	
    	String formatedDate = null;
    	
    	if (date != null) {
    		
	    	SimpleDateFormat formatter = null;
	    	
	    	if (isSQLParam) {
	    		formatter = new SimpleDateFormat("yyyy-MM-dd");
	    	} else {
	    		formatter = new SimpleDateFormat("dd/MM/yyyy");
	    	}
	    	
	    	formatedDate = formatter.format(date);
	    	
    	}
    	
    	return formatedDate;
    	
    }
    
    
    
    
    
    
    
    /**
     * @param p(HtmlPage)
     * @return String
     */
    public static String getPathsImagesMenu(HtmlPage p) {
        SOFIAPaths path = new SOFIAPaths(p);
        return path.getAppImagePath() + "/menu/";
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return String
     */
    public static String getPathsImagesButton(HtmlPage p) {
        SOFIAPaths path = new SOFIAPaths(p);
        return path.getImagePath() + "/button/";
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Hist�rico"
     */
    public static ImageButton getButtonHistorico(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_historico_up.png");
        img1.setImgOver("btn_historico_over.png");
        img1.setImgDown("btn_historico_down.png");
        img1.setImgDisable("btn_historico_dis.png");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Etiquetas"
     */
    public static ImageButton getButtonEtiquetas(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_etiquetas_up.png");
        img1.setImgOver("btn_etiquetas_over.png");
        img1.setImgDown("btn_etiquetas_down.png");
        img1.setImgDisable("btn_etiquetas_dis.png");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "N�o"
     */
    public static ImageButton getButtonNao(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_nored_up.gif");
        img1.setImgOver("btn_nored_over.gif");
        img1.setImgDown("btn_nored_down.gif");
        img1.setImgDisable("btn_nored_dis.gif");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Sim"
     */
    public static ImageButton getButtonSim(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_yesgreen_up.gif");
        img1.setImgOver("btn_yesgreen_over.gif");
        img1.setImgDown("btn_yesgreen_down.gif");
        img1.setImgDisable("btn_yesgreen_dis.gif");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Entrar"
     */
    public static ImageButton getButtonEntrar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_entrar_up.png");
        img1.setImgOver("btn_entrar_over.png");
        img1.setImgDown("btn_entrar_down.png");
        img1.setImgDisable("btn_entrar_dis.png");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Enviar"
     */
    public static ImageButton getButtonEnviar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_enviar_up.png");
        img1.setImgOver("btn_enviar_over.png");
        img1.setImgDown("btn_enviar_down.png");
        img1.setImgDisable("btn_enviar_dis.png");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Editar"
     */
    public static ImageButton getButtonEditar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_editar_up.png");
        img1.setImgOver("btn_editar_over.png");
        img1.setImgDown("btn_editar_down.png");
        img1.setImgDisable("btn_editar_dis.png");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Alterar"
     */
    public static ImageButton getButtonAlterar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_alterar_up.png");
        img1.setImgOver("btn_alterar_over.png");
        img1.setImgDown("btn_alterar_down.png");
        img1.setImgDisable("btn_alterar_dis.png");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Fechar Balan�o"
     */
    public static ImageButton getButtonFecharBalanco(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_fecharbalanco_up.png");
        img1.setImgOver("btn_fecharbalanco_over.png");
        img1.setImgDown("btn_fecharbalanco_down.png");
        img1.setImgDisable("btn_fecharbalanco_dis.png");
        return img1;
    }

    /**
     * @param name
     *            (Nome do Objeto)
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Receber"
     */
    public static ImageButton getButtonReceber(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_receber_up.png");
        img1.setImgOver("btn_receber_over.png");
        img1.setImgDown("btn_receber_down.png");
        img1.setImgDisable("btn_receber_dis.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Ok"
     */
    public static ImageButton getButtonOkGreen(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_okgreen_up.gif");
        img1.setImgOver("btn_okgreen_over.gif");
        img1.setImgDown("btn_okgreen_down.gif");
        img1.setImgDisable("btn_okgreen_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Ok"
     */
    public static ImageButton getButtonOkBlue(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_okblue_up.gif");
        img1.setImgOver("btn_okblue_over.gif");
        img1.setImgDown("btn_okblue_down.gif");
        img1.setImgDisable("btn_okblue_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Consultar"
     */
    public static ImageButton getButtonConsultar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_consultar_up.png");
        img1.setImgOver("btn_consultar_over.png");
        img1.setImgDown("btn_consultar_down.png");
        img1.setImgDisable("btn_consultar_dis.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Avancar"
     */
    public static ImageButton getButtonAvancar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_avancar_up.gif");
        img1.setImgOver("btn_avancar_over.gif");
        img1.setImgDown("btn_avancar_down.gif");
        img1.setImgDisable("btn_avancar_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Cancelar"
     */
    public static ImageButton getButtonCancelar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_cancelar_up.gif");
        img1.setImgOver("btn_cancelar_over.gif");
        img1.setImgDown("btn_cancelar_down.gif");
        img1.setImgDisable("btn_cancelar_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Inserir"
     */
    public static ImageButton getButtonInserir(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_inserir_up.gif");
        img1.setImgOver("btn_inserir_over.gif");
        img1.setImgDown("btn_inserir_down.gif");
        img1.setImgDisable("btn_inserir_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Voltar"
     */
    public static ImageButton getButtonVoltar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_voltar_up.gif");
        img1.setImgOver("btn_voltar_over.gif");
        img1.setImgDown("btn_voltar_down.gif");
        img1.setImgDisable("btn_voltar_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Atendidos"
     */
    public static ImageButton getButtonAtendidos(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_atendidos_up.png");
        img1.setImgDown("btn_atendidos_down.png");
        img1.setImgDisable("btn_atendidos_dis.png");
        img1.setImgOver("btn_atendidos_over.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "IncluirBalanco"
     */
    public static ImageButton getButtonIniciarBalanco(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_iniciarbalanco_up.png");
        img1.setImgDown("btn_iniciarbalanco_down.png");
        img1.setImgDisable("btn_iniciarbalanco_dis.png");
        img1.setImgOver("btn_iniciarbalanco_over.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Visualizar"
     */
    public static ImageButton getButtonVisualizar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_visualizar_up.gif");
        img1.setImgOver("btn_visualizar_over.gif");
        img1.setImgDown("btn_visualizar_down.gif");
        img1.setImgDisable("btn_visualizar_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Imprimir"
     */
    public static ImageButton getButtonImprimir(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_imprimir_up.gif");
        img1.setImgOver("btn_imprimir_over.gif");
        img1.setImgDown("btn_imprimir_down.gif");
        img1.setImgDisable("btn_imprimir_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Excluir"
     */
    public static ImageButton getButtonExcluir(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_excluir_up.gif");
        img1.setImgOver("btn_excluir_over.gif");
        img1.setImgDown("btn_excluir_down.gif");
        img1.setImgDisable("btn_excluir_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Confirmar"
     */
    public static ImageButton getButtonConfirmar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_confirmar_up.gif");
        img1.setImgOver("btn_confirmar_over.gif");
        img1.setImgDown("btn_confirmar_down.gif");
        img1.setImgDisable("btn_confirmar_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Confirmar"
     */
    public static ImageButton getButtonConfirmarGreen(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_confirmargreen_up.png");
        img1.setImgOver("btn_confirmargreen_over.png");
        img1.setImgDown("btn_confirmargreen_down.png");
        img1.setImgDisable("btn_confirmargreen_dis.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Novo"
     */
    public static ImageButton getButtonNovo(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_novo_up.gif");
        img1.setImgOver("btn_novo_over.gif");
        img1.setImgDown("btn_novo_down.gif");
        img1.setImgDisable("btn_novo_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Sair"
     */
    public static ImageButton getButtonSair(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_sair_up.gif");
        img1.setImgOver("btn_sair_over.gif");
        img1.setImgDown("btn_sair_down.gif");
        img1.setImgDisable("btn_sair_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Pesquisar"
     */
    public static ImageButton getButtonPesquisar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_pesquisar_up.gif");
        img1.setImgOver("btn_pesquisar_over.gif");
        img1.setImgDown("btn_pesquisar_down.gif");
        img1.setImgDisable("btn_pesquisar_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Filtrar"
     */
    public static ImageButton getButtonFiltrar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_filtrar_up.gif");
        img1.setImgOver("btn_filtrar_over.gif");
        img1.setImgDown("btn_filtrar_down.gif");
        img1.setImgDisable("btn_filtrar_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Limpar"
     */
    public static ImageButton getButtonLimpar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_limpar_up.png");
        img1.setImgOver("btn_limpar_over.png");
        img1.setImgDown("btn_limpar_down.png");
        img1.setImgDisable("btn_limpar_dis.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Salvar"
     */
    public static ImageButton getButtonSalvarGreen(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_salvargreen_up.png");
        img1.setImgOver("btn_salvargreen_over.png");
        img1.setImgDown("btn_salvargreen_down.png");
        img1.setImgDisable("btn_salvargreen_dis.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Salvar"
     */
    public static ImageButton getButtonSalvar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_salvar_up.gif");
        img1.setImgOver("btn_salvar_over.gif");
        img1.setImgDown("btn_salvar_down.gif");
        img1.setImgDisable("btn_salvar_dis.gif");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Incluir Lote"
     */
    public static ImageButton getButtonIncluirLote(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_incluirlote_up.png");
        img1.setImgOver("btn_incluirlote_over.png");
        img1.setImgDown("btn_incluirlote_down.png");
        img1.setImgDisable("btn_iincluirlote_dis.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Igualar Qtde"
     */
    public static ImageButton getButtonIgualarQtde(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_igualarqtde_up.png");
        img1.setImgOver("btn_igualarqtde_over.png");
        img1.setImgDown("btn_igualarqtde_down.png");
        img1.setImgDisable("btn_igualarqtde_dis.png");
        return img1;
    }

    /**
     * @param p
     *            (HtmlPage)
     * @return ImageButton "Adicionar"
     */
    public static ImageButton getButtonAdicionar(String name, HtmlPage p) {
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_adicionar_up.gif");
        img1.setImgOver("btn_adicionar_over.gif");
        img1.setImgDown("btn_adicionar_down.gif");
        img1.setImgDisable("adicionar.gif");
        return img1;
    }
    
    /**
     * @param p (HtmlPage)
     * @return ImageButton Remover
     */
    public static ImageButton getButtonRemover(String name, HtmlPage p){
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_remover_up.png");
        img1.setImgOver("btn_remover_over.png");
        img1.setImgDown("btn_remover_down.png");
        img1.setImgDisable("btn_remover_dis.png");
        return img1;
    }

    /**
     * @param p (HtmlPage)
     * @return ImageButton Fechar
     */
    public static ImageButton getButtonFechar(String name, HtmlPage p){
        ImageButton img1 = new ImageButton(name, p);
        img1.setImagePath(utilsRH.getPathsImagesButton(p));
        img1.setImgIdle("btn_fechar_up.gif");
        img1.setImgOver("btn_fechar_over.gif");
        img1.setImgDown("btn_fechar_down.gif"); 
        img1.setImgDisable("btn_fechar_dis.gif");
        return img1;
    }
    

    public static Date parseDate(String value) {
        if (value == null)
            return null;

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return fmt.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Double parseDouble(String value) {
	    if (value == null)
	        return null;
	
	    boolean checkDecimal = true;
	    StringBuffer b = new StringBuffer();
	    for (int i = value.length() - 1; i >= 0; i--) {
	        char ch = value.charAt(i);
	        if (ch == ',' || ch == '.') {
	            if (checkDecimal) {
	                b.append('.');
	                checkDecimal = false;
	            }
	            continue;
	        }
	        b.append(ch);
	    }
	    b.reverse();
	    return new Double(b.toString());
    }

    public static String formataData(String data) throws Exception {
        if (data != null) {
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            Date din = in.parse(data);
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
            String dataNova = out.format(din);

            return dataNova;
        } else
            return "";
    }

    public static java.sql.Date getDataAsDate(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return new java.sql.Date(sdf.parse(data).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Timestamp getDataAsTimeStamp(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return new java.sql.Timestamp(sdf.parse(data).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Timestamp getDateTimeAsTimeStamp(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            return new java.sql.Timestamp(sdf.parse(data).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formataValor(int valor) throws Exception {
        NumberFormat fmt = new DecimalFormat(",###.00");
        String valorNovo = fmt.format(valor);
        return valorNovo;
    }
    
    public static String formataValorPonto(int valor) throws Exception {
        NumberFormat fmt = new DecimalFormat("###,###.##");
        String valorNovo = fmt.format(valor);
        return valorNovo;
    }

    public static boolean stringAsNumber(String s) {
        if (s == null)
            return false;
        else
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch < 48 || ch > 57)
                    return false;
            }
        return true;

    }
    
    public static ResourceBundle getProperties() {

    	if (rb == null) {
    		
    		rb = ResourceBundle.getBundle("performer.rhweb.resources.resource");
    		
    		}
    	
    	return rb;
    }
    
    public static String getImagePath() {
    	                                         
    	String path = getProperties().getString("ImagePath");
    	
    	return getRealPath(path);
    	
    }
    
    public static String getReportPath() {
        
    	String path = getProperties().getString("ReportPath");
    	
    	return getRealPath(path);
    	
    }
    
    public static String getRealPath(String relativePath) {
        
    	return PeFacesApplication.getInstance().getRealPath(relativePath).toString() + "/";
    	
    }
    
    /*public static String getReportPath(String realPath) {
        
        String path = realPath + "WEB-INF\\properties\\InfoEstoqueWeb.properties";        
        File file = new File(path);    
        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            props.load(fis); 
            fis.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return props.getProperty("REPORT_DIRECTORY");
        
    }        
    
    public static String getReportPath(Props props) {
        return props.getProperty("REPORT_DIRECTORY");        
    }*/ 
    
    /**
     * @author Nilton
     * @return String
     */
    public static String getFormatoTimestamp(String ddmmyyyy) {
        
        String strTimestamp = ddmmyyyy;
        
        strTimestamp = strTimestamp.substring(6,10) + "-" + strTimestamp.substring(3,5) 
        											+ "-" + strTimestamp.substring(0,2) + " 00:00:00.000";
        return strTimestamp;        
    }

   public static int convertCentimetersToPixelsInX(double centimeters) {
		
		int xScale = 30; // 1cm ~= 30px
		int pixels = (int) Math.round(centimeters * xScale);
		
		return pixels;
		
	}
   
	public static boolean isDateValid(String date)
	{ 
		boolean result = false;
		   
		Calendar c = Calendar.getInstance();
		int year, month, day;
		   
		day   = Integer.parseInt( date.substring(0, 2) );
		month = Integer.parseInt( date.substring(3, 5) );
		year  = Integer.parseInt( date.substring(6, 10) );
		c.set(Calendar.YEAR, year);
		   
		if (month < 13 )
		{
			c.set(Calendar.MONTH, month - 1);
			if ( day <= c.getActualMaximum(Calendar.DAY_OF_MONTH) )
			   result = true;
		}
			   
		return result;
	}
	
    public static final void sendToHistoric(String table, String fieldKey, String valueKey, String appName, String FgUpdateDelete ) throws DataStoreException, SQLException
    {
 		Statement stm;
 		DBConnection conn = null;

		String user = (String)PeFacesApplication.getInstance().getAttribute("USUARIO.NM_USUARIO");
		String sql = "INSERT INTO " + table + "_HIST SELECT *, GETDATE(), '" + user + "', '" + FgUpdateDelete + "' FROM " + table + " WHERE " + fieldKey + " = " + valueKey;
		
		 try {
			 conn = DBConnection.getConnection( appName );
			 stm = conn.createStatement();
			 stm.executeUpdate(sql);
	     } finally {
	         if (conn != null)
	          	conn.freeConnection();
	     }
	}

    public static final String getPrimaryKey(DSDataStoreDescriptor ds)
    {
	   	 String result = null;
	   	 
	   	 for (int i = 0; i < ds.getColumnCount(); i++)
	   	 {
	   		 DSColumnDescriptor dsCol = ds.getColumn(i);
	   		 if ( dsCol.isPrimaryKey() ){
	   			 result = dsCol.getInternalName();
	   			 break;
	   		 }
	   	 }
	   	 return result;
    }
    
    public static final void dumpStream(InputStream in, OutputStream out) throws IOException {
    	byte[] buffer = new byte[4 * 1024];
		int len;
		while((len = in.read(buffer)) != -1) {
			if(len == 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// NOOP
				}
			} else {
				out.write(buffer, 0, len);
			}
		}
    }
    
    public static final void dumpStream(InputStream in, File target) throws IOException {
    	FileOutputStream out = null;
    	try {
			out = new FileOutputStream(target);
			utilsRH.dumpStream(in, out);
		} catch(IOException exn) {
			exn.printStackTrace();
		} finally {
			if(out != null) {
				IOUtils.closeQuietly(out);
			}
		}
    }
    
    /*
     * PeUploadedFile Util
     */
    
    public static final void dumpStream(PeUploadedFile source, File target) throws IOException {
    	InputStream in = null;
		try {
			in = source.getInputStream();
			utilsRH.dumpStream(in, target);
		} finally {
			if(in != null) {
				IOUtils.closeQuietly(in);
			}
		}
    }

    public static final void dumpStream(PeUploadedFile source, OutputStream out) throws IOException {
    	InputStream in = null;
		try {
			in = source.getInputStream();
			utilsRH.dumpStream(in, out);
		} finally {
			if(in != null) {
				IOUtils.closeQuietly(in);
			}
		}    	
    }
}