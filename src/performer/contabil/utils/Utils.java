/*
 * Created on 19/07/2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package performer.contabil.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.structs.PeUploadedFile;
import com.salmonllc.html.HtmlPage;
import com.salmonllc.properties.Props;
import com.salmonllc.sql.DBConnection;
import com.salmonllc.sql.DataStoreException;

import framework.web.gui.widget.ImageButton;
import framework.web.util.SOFIAPaths;
import performer.contabil.persistence.DSHistoricoAnual;
import performer.contabil.persistence.DSUsuario;

public class Utils {

	public static final String FLOAT_PATTERN = "^([0-9]{1,3}|[0-9]{1,3},[0-9]{0,2})$";

	public static final String INTEGER_PATTERN = "^([0-9]{1,10})$";

	public static final String CURRENCY_EXPRESSION = "^([0-9]{1,5}|[0-9]{1,5},[0-9]{0,2})$";

	public static final Locale PORTUGUES_BR = new Locale("pt", "Br");

	public static final int DIGIT_COUNT = 11;

	private static ResourceBundle rb;

	public static java.sql.Date getCurrentSQLDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return new java.sql.Date(c.getTimeInMillis());
	}

	/**
	 * Marcellus
	 * 
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

	public static String DataYYYYmmdd(String data) {
		String[] dataSplit = data.split("/");

		return dataSplit[2] + "/" + dataSplit[1] + "/" + dataSplit[0];
	}

	public static Integer horaMinuto(String hora) {

		if ((hora == null) || (hora.replaceAll(" ", "") == "")) {
			hora = "00:00:00";
		}

		hora = hora.replaceAll(" ", "");

		if (hora.equals("")) {
			hora = "00:00:00";
		}

		if (hora.length() == 7) {
			hora = "0" + hora;
		}

		int horaInteger = Integer.parseInt(hora.substring(0, 2));
		int minutoInteger = Integer.parseInt(hora.substring(3, 5));

		return (horaInteger * 60) + minutoInteger;
	}

	/**
	 * @param p
	 *            (HtmlPage)
	 * @return String
	 */
	public static String getPathsImages(HtmlPage p) {
		SOFIAPaths path = new SOFIAPaths(p);
		return path.getAppImagePath() + "/icones/";
	}

	/**
	 * @param p
	 *            (HtmlPage)
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
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
		img1.setImagePath(Utils.getPathsImagesButton(p));
		img1.setImgIdle("btn_adicionar_up.gif");
		img1.setImgOver("btn_adicionar_over.gif");
		img1.setImgDown("btn_adicionar_down.gif");
		img1.setImgDisable("adicionar.gif");
		return img1;
	}

	/**
	 * @param p
	 *            (HtmlPage)
	 * @return ImageButton Remover
	 */
	public static ImageButton getButtonRemover(String name, HtmlPage p) {
		ImageButton img1 = new ImageButton(name, p);
		img1.setImagePath(Utils.getPathsImagesButton(p));
		img1.setImgIdle("btn_remover_up.png");
		img1.setImgOver("btn_remover_over.png");
		img1.setImgDown("btn_remover_down.png");
		img1.setImgDisable("btn_remover_dis.png");
		return img1;
	}

	/**
	 * @param p
	 *            (HtmlPage)
	 * @return ImageButton Fechar
	 */
	public static ImageButton getButtonFechar(String name, HtmlPage p) {
		ImageButton img1 = new ImageButton(name, p);
		img1.setImagePath(Utils.getPathsImagesButton(p));
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

	public static String formataData(Timestamp data) throws Exception {
		if (data != null) {

			try {

				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String strData = format.format(data);
				return strData;
			} catch (DataStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			return "";
		return null;
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

	public static String formataValor(int valor) throws Exception {
		NumberFormat fmt = new DecimalFormat(",###.00");
		String valorNovo = fmt.format(valor);
		return valorNovo;
	}

	public static Double strToDouble(String str_temp) {

		str_temp = str_temp.toUpperCase();
		str_temp = str_temp.replace("R$", "");
		str_temp = str_temp.replace(".", "");
		str_temp = str_temp.replace(",", ".");
		String formato = "";
		Double retorno = 0D;
		formato = "###,###,###,###,##0.00";

		DecimalFormat formata = new DecimalFormat(formato, new DecimalFormatSymbols(new Locale("pt", "BR")));
		formata.setMinimumFractionDigits(2);
		formata.setParseBigDecimal(true);
		retorno = Double.parseDouble(str_temp);

		return retorno;

	}

	public static Double strToDoubleResultadoNumerico(String str_temp) {

		str_temp = str_temp.toUpperCase();
		str_temp = str_temp.replace("R$", "");
		str_temp = str_temp.replace(",", ".");
		String formato = "";
		Double retorno = 0D;
		formato = "###,##0.0";

		DecimalFormat formata = new DecimalFormat(formato, new DecimalFormatSymbols(new Locale("pt", "BR")));
		formata.setMinimumFractionDigits(1);
		formata.setParseBigDecimal(true);
		retorno = Double.parseDouble(str_temp);

		return retorno;

	}

	public static String doubleToStr(Double valor, int cifrao) {

		String formato = "";

		if (cifrao == 1) {
			formato = "R$ ###,###,###,##0.00";
		} else {
			formato = "###,###,###,##0.00";
		}

		DecimalFormat formatoDois = new DecimalFormat(formato, new DecimalFormatSymbols(new Locale("pt", "BR")));
		formatoDois.setMinimumFractionDigits(2);
		formatoDois.setParseBigDecimal(true);
		return formatoDois.format(valor);

	}

	public static Integer strToInt(String valor) {

		Integer retorno = 0;

		if (valor != null) {

			try {
				retorno = Integer.parseInt(valor);
			} catch (Exception e) {
				retorno = 0;
			}

		}

		return retorno;

	}

	public static Short strToShort(String valor) {

		Short retorno = 0;

		if (valor != null) {

			try {
				retorno = Short.parseShort(valor);
			} catch (Exception e) {
				retorno = 0;
			}

		}

		return retorno;

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

			rb = ResourceBundle.getBundle("performer.contabil.resource.resource");

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

	public static String getReportPathJrxml() {

		String path = getProperties().getString("ReportPathJrxml");

		return getRealPath(path);

	}

	public static String getRealPath(String relativePath) {

		return PeFacesApplication.getInstance().getRealPath(relativePath).toString() + "/";

	}

	/*
	 * public static String getReportPath(String realPath) {
	 * 
	 * String path = realPath +
	 * "WEB-INF\\properties\\InfoEstoqueWeb.properties"; File file = new
	 * File(path); Properties props = new Properties(); FileInputStream fis =
	 * null; try { fis = new FileInputStream(file); props.load(fis);
	 * fis.close(); } catch (IOException ex) {
	 * System.out.println(ex.getMessage()); ex.printStackTrace(); } return
	 * props.getProperty("REPORT_DIRECTORY");
	 * 
	 * }
	 * 
	 * public static String getReportPath(Props props) { return
	 * props.getProperty("REPORT_DIRECTORY"); }
	 */

	/**
	 * @author Nilton
	 * @return String
	 */
	public static String getFormatoTimestamp(String ddmmyyyy) {

		String strTimestamp = ddmmyyyy;

		strTimestamp = strTimestamp.substring(6, 10) + "-" + strTimestamp.substring(3, 5) + "-"
				+ strTimestamp.substring(0, 2) + " 00:00:00.000";
		return strTimestamp;
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

	public static void freeDBConnection(DBConnection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (con != null) {
			con.freeConnection();
			con = null;
		}
	}

	public static boolean validaEmail(String Email) {

		String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$";
		// String EMAIL_REGEX2 = ".+@.+\\.[a-z]+";

		// Definir a seq��ncia de padr�o de e-mail
		Pattern p = Pattern.compile(EMAIL_REGEX);
		// Pattern p = Pattern.compile(EMAIL_REGEX2);

		// Match Joga seq��ncia de dados com o padr�o
		java.util.regex.Matcher m = p.matcher(Email);

		// Verifica se o Match jogado foi encontrado
		boolean matchEncon = m.matches();

		if (matchEncon)
			return true;
		else
			return false;
	}

	public static String inverteString(String texto) {

		String resultado = ""; // variavel que sera alimentada com o resultado;

		for (int x = texto.length() - 1; x >= 0; x--) {
			resultado += texto.charAt(x);
		}

		return resultado;

	}

	public static boolean validaCPF(String strCpf) {

		if (strCpf.length() == 14) {
			strCpf = strCpf.substring(0, 3) + strCpf.substring(4, 7) + strCpf.substring(8, 11)
					+ strCpf.substring(12, 14);

		}

		int d1, d2, digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
			// e assim por diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro
			// digito calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}
		;

		// Primeiro resto da divis�o por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
		// menos o resultado anterior.
		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		// Segundo resto da divis�o por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
		// menos o resultado anterior.
		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Digito verificador do CPF que est� sendo validado.
		String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo
		// resto.
		return nDigVerific.equals(nDigResult);

	}

	public boolean ValidaPis(String pisOrPasep) {

		if (pisOrPasep == null)
			return false;
		String n = pisOrPasep.replaceAll("[^0-9]*", "");
		if (n.length() != DIGIT_COUNT)
			return false;
		int i; // just count
		int digit; // A number digit
		int coeficient; // A coeficient
		int sum; // The sum of (Digit * Coeficient)
		int foundDv; // The found Dv (Chek Digit)
		int dv = Integer.parseInt(String.valueOf(n.charAt(n.length() - 1)));
		sum = 0;
		coeficient = 2;
		for (i = n.length() - 2; i >= 0; i--) {
			digit = Integer.parseInt(String.valueOf(n.charAt(i)));
			sum += digit * coeficient;
			coeficient++;
			if (coeficient > 9)
				coeficient = 2;
		}
		foundDv = 11 - sum % 11;
		if (foundDv >= 10)
			foundDv = 0;
		return dv == foundDv;
	}

	public static boolean ValidaCNPJ(String str_cnpj) {
		int soma = 0, dig;
		String cnpj_calc = str_cnpj.substring(0, 12);
		if (str_cnpj.length() != 14)
			return false;
		char[] chr_cnpj = str_cnpj.toCharArray();
		/* Primeira parte */
		for (int i = 0; i < 4; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
				soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);
		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
		/* Segunda parte */
		soma = 0;
		for (int i = 0; i < 5; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
				soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);
		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
		return str_cnpj.equals(cnpj_calc);
	}

	public static boolean bancoTeste(String _appName) {
		boolean result = false;
		Props p = Props.getProps(_appName, null);
		String defaultProfile = p.getProperty(Props.DB_DEFAULT) + ".";
		String url = p.getProperty(defaultProfile + Props.DB_URL);

		if (url.contains("TESTE")) {
			result = true;
		}

		return result;
	}

	public static String buscaPeriodo(Short periodo) {

		String retorno = "";
		switch (periodo) {
		case 2:
			retorno = "Mat";
			break;
		case 3:
			retorno = "Ves";
			break;
		case 4:
			retorno = "Not";
			break;
		default:
			retorno = "Int";

		}

		return retorno;
	}

	public static final void dumpStream(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[4 * 1024];
		int len;
		while ((len = in.read(buffer)) != -1) {
			if (len == 0) {
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
			Utils.dumpStream(in, out);
		} catch (IOException exn) {
			exn.printStackTrace();
		} finally {
			if (out != null) {
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
			Utils.dumpStream(in, target);
		} finally {
			if (in != null) {
				IOUtils.closeQuietly(in);
			}
		}
	}

	public static final void dumpStream(PeUploadedFile source, OutputStream out) throws IOException {
		InputStream in = null;
		try {
			in = source.getInputStream();
			Utils.dumpStream(in, out);
		} finally {
			if (in != null) {
				IOUtils.closeQuietly(in);
			}
		}
	}

	public static boolean validaContaCorrente(String banco, String conta, int digito) {
		String pesoBradesco = "32765432";
		String pesoSantander = "97310097131973";
		String pesoBB = "98765432";
		String pesoHSBC = "8923456789";

		int soma = 0;
		int resto = 0;
		int Digito = 0;
		int x = 0;

		switch (Integer.parseInt(banco)) {
		case 1: // BCO DO BRASIL S/A
			// region
			x = pesoBB.length() - conta.length();
			for (int j = 0; j < x; j++) {
				conta = conta + "0";
			}

			for (int i = 0; i < pesoBB.length(); i++) {
				if (i < x) {
					soma += Integer.parseInt(pesoBB.substring(i, i + 1)) * 0;

				} else {
					soma += Integer.parseInt(pesoBB.substring(i, i + 1))
							* Integer.parseInt(conta.substring(i, i + 1).toString());
				}
			}

			resto = soma % 11;
			Digito = 11 - resto;
			if (Digito == 11) {
				Digito = 0;
			} else if (Digito == 10) {
				Digito = 20;
			}

			if (digito == 0 && Digito == 10) {
				return true;
			} else if (digito != Digito) {
				return false;
			} else {
				return true;
			}
			// endregion
			// break;
		case 33: // SANTANDER
			// region
			x = pesoSantander.length() - conta.length();

			for (int j = 0; j < x; j++) {
				conta = conta + "0";
			}

			if (x == 0) {
				x = conta.length();
			}

			for (int i = 0; i < pesoSantander.length(); i++) {
				if (i < x && pesoSantander.length() != x) {
					soma += Integer.parseInt(pesoSantander.substring(i, i + 1)) * 0;
				} else {
					soma += Integer.parseInt(pesoSantander.substring(i, i + 1))
							* Integer.parseInt(conta.substring(i, i + 1).toString());
				}
			}

			resto = soma % 10;
			if (resto == 0) {
				Digito = 0;
			} else {
				Digito = 10 - resto;
			}

			if (digito != Digito) {
				return false;
			} else {
				return true;
			}
			// endregion
			// break;
		case 104: // CAIXA ECONOMICA FEDERAL
			// region
			// endregion
			break;
		case 237: // BRADESCO S/A
			// region
			x = pesoBradesco.length() - conta.length();
			for (int j = 0; j < x; j++) {
				conta = conta + "0";
			}

			for (int i = 0; i < pesoBradesco.length(); i++) {
				if (i < x) {
					soma += Integer.parseInt(pesoBradesco.substring(i, i + 1)) * 0;
				} else {
					soma += Integer.parseInt(pesoBradesco.substring(i, i + 1))
							* Integer.parseInt(conta.substring(i, i + 1).toString());
				}
			}

			resto = soma % 11;

			if (resto == 0) {
				Digito = 0;
			} else {
				Digito = 11 - resto;
			}
			if (Digito == 10 || Digito == 11) {
				Digito = 0;
			}

			if (digito != Digito) {
				return false;
			} else {
				return true;
			}
			// endregion
			// break;
		case 341: // BCO ITAU S/A
			// Region
			// endregion
			break;
		case 399: // HSBC BANK BRASIL S.A.
			// region
			x = pesoHSBC.length() - conta.length();

			for (int i = 0; i < conta.length(); i++) {
				soma += Integer.parseInt(pesoHSBC.substring(i, i + 1)) * Integer.parseInt(conta.substring(i, i + 1));
			}

			Digito = soma % 11;

			if (Digito == digito) {
				return true;
			} else {
				return false;
				// break;
			}
			// endregion

		default:
			return false;
		// break;
		}
		return false;
	}

	// / <summary>Valida ag�ncia bancaria
	// / </summary>
	// /<param name="banco">Passar o n�mero (c�digo) do banco</param>
	// / <param name="agencia">Passar o n�mero da ag�ncia sem o digito</param>
	// / <param name="digito">Passar o digito da conta</param>
	public static boolean validaAgencia(String banco, String agencia, int digito) {
		String pesoBradesco = "5432";
		String pesoBB = "5432";

		int soma = 0;
		int resto = 0;
		int Digito = 0;

		switch (Integer.parseInt(banco)) {
		case 1: // Banco do Brasil
			for (int i = 0; i < pesoBB.length(); i++) {
				soma += Integer.parseInt(pesoBB.substring(i, i + 1)) * Integer.parseInt(agencia.substring(i, i + 1));
			}

			resto = soma % 11;
			Digito = 11 - resto;

			if (Digito == 11) {
				Digito = 0;
			} else if (Digito == 10) {
				Digito = 20;
			}

			if (digito != Digito) {
				return false;
			} else {
				return true;
			}
			// break;
		case 237: // Bradesco
			for (int i = 0; i < pesoBradesco.length(); i++) {
				soma += Integer.parseInt(pesoBradesco.substring(i, i + 1))
						* Integer.parseInt(agencia.substring(i, i + 1));
			}

			resto = soma % 11;
			Digito = 11 - resto;

			if (digito != Digito) {
				return false;
			} else {
				return true;
			}

		default:
			return false;
		// break;
		}
		// return false;
	}

	public static String getAnoMes(int ano, short mes) {

		String ano_mes = "" + ano;

		if (mes < 10) {
			ano_mes = ano_mes + "0" + mes;
		} else {
			ano_mes = ano_mes + mes;
		}

		return ano_mes;
	}

	public static String getMesAno(short mes, int ano) {

		String ano_mes = "";

		if (mes < 10) {
			ano_mes = ano_mes + "0" + mes;
		} else {
			ano_mes = ano_mes + mes;
		}

		return ano_mes + ano;
	}

	public static String DigitoProtocolo(String codigo) {

		Integer NUMERO;
		Short D1;
		Short D2;
		String NUMERO_S;

		NUMERO = Integer.parseInt(codigo);

		D1 = (short) ((NUMERO * 9) % 11);
		if (D1 >= 10) {
			D1 = 0;
		}

		D2 = (short) (((NUMERO + D1) * 8) % 11);
		if (D2 >= 10) {
			D2 = 0;
		}
		NUMERO_S = D1 + "" + D2;

		return NUMERO_S;

	}

	public static String nomeAnoMes(Integer anoMes) {

		String anoMesStr = anoMes + "";
		String retorno = nomeMes(+Integer.parseInt(anoMesStr.substring(4, 6))) + " / " + anoMesStr.substring(0, 4);

		return retorno;
	}

	public static String nomeMes(Integer mes) {
		String retorno = "";

		switch (mes) {
		case 1:
			retorno = "Janeiro";
			break;

		case 2:
			retorno = "Fevereiro";
			break;

		case 3:
			retorno = "Março";
			break;

		case 4:
			retorno = "Abril";
			break;
		case 5:
			retorno = "Maio";
			break;

		case 6:
			retorno = "Junho";
			break;

		case 7:
			retorno = "Julho";
			break;

		case 8:
			retorno = "Agosto";
			break;

		case 9:
			retorno = "Setembro";
			break;

		case 10:
			retorno = "Outubro";
			break;

		case 11:
			retorno = "Novembro";
			break;
		case 12:
			retorno = "Dezembro";
			break;

		}
		return retorno;

	}

	public static Integer TotalOcorrencias(String texto, String letra) {
		int total = 0;

		if (texto != null) {
			texto = texto.trim();
		} else
			texto = "";

		if (texto.length() > 0) {
			for (int i = 0; i <= texto.length() - 1; i++) {
				char ch = texto.charAt(i);
				String x1 = String.valueOf(ch);
				if (x1.equalsIgnoreCase(letra)) {
					total = total + 1;
				}
			}
		}
		return total;
	}

	public static String completeToLeft(String value, String c, int size) {
		String result = value;

		while (result.length() < size) {
			result = c + result;
		}

		return result;
	}

	public static boolean verifica_item_menu(String acessos, String item) {
		boolean retorno = true;
        /*
		if (acessos != null && acessos.indexOf(item) > 0) {
			retorno = true;
		}*/

		return retorno;

	}

	public static String acessos_do_usuario(String IDUsuario) {
		DBConnection con = null;
		Statement stmt = null;
		String acessos = "";

		try {
			con = DBConnection.getConnection(PeFacesApplication.getInstance().getName());
			stmt = con.createStatement();

			String sql = "SELECT lpad(CAST(cd_item_modulo AS VARCHAR(2)),2,'0') FROM en_perfil WHERE id_usuario = '"
					+ IDUsuario + "' AND fg_acesso = '1'; ";

			ResultSet A = stmt.executeQuery(sql);
			while (A.next()) {

				acessos = acessos + "," + A.getString(1);

			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

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
		return acessos;
	}

	public static String acessos_usuario_modulos(String IDUsuario) {
		DBConnection con = null;
		Statement stmt = null;
		String modulos = "";

		try {
			con = DBConnection.getConnection(PeFacesApplication.getInstance().getName());
			stmt = con.createStatement();

			String sql = "SELECT DISTINCT LPAD( CAST(EN_ITEM_MODULO.cd_item_modulo_modulo AS VARCHAR(2)),2,'0') FROM  EN_PERFIL "
					+ "INNER JOIN EN_ITEM_MODULO ON EN_ITEM_MODULO.CD_ITEM_MODULO = EN_PERFIL.CD_ITEM_MODULO "
					+ "WHERE  EN_PERFIL.ID_USUARIO = '" + IDUsuario + "' and FG_ACESSO = 1";

			ResultSet A = stmt.executeQuery(sql);
			while (A.next()) {

				modulos = modulos + "," + A.getString(1);

			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

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
		return modulos;
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String geraDigitoProtocolo(String numero) {

		int d1, d2, digito1, digito2, resto;
		int digitoNumero;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < numero.length() - 1; nCount++) {
			digitoNumero = Integer.valueOf(numero.substring(nCount - 1, nCount)).intValue();
			d1 = d1 + (11 - nCount) * digitoNumero;
			d2 = d2 + (12 - nCount) * digitoNumero;
		}

		resto = (d1 % 11);

		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		resto = (d2 % 11);

		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo
		// resto.
		return nDigResult;

	}

	public static boolean valida_hora(String hora) {
		/*
		 * Integer primeira_parte = Integer.parseInt(hora.substring(0, 2));
		 * Integer segunda_parte = Integer.parseInt(hora.substring(2, 4));
		 * 
		 * if ((primeira_parte > 23) || (segunda_parte > 59)) {
		 * 
		 * return false; }
		 */
		return true;
	}

	public static String formataCPFouCNPJ(String cpf_cnpj) {

		if (cpf_cnpj == null || cpf_cnpj.length() < 11) {
			return cpf_cnpj;
		}

		// CPF
		if (cpf_cnpj != null && cpf_cnpj.length() < 14) {
			// 810.949.659-87
			// 81094965987
			// 01234567890
			return cpf_cnpj.substring(0, 3) + "." + cpf_cnpj.substring(3, 6) + "." + cpf_cnpj.substring(6, 9) + "-"
					+ cpf_cnpj.substring(9, 11);

			// CNPJ
		} else {
			return cpf_cnpj.substring(0, 2) + "." + cpf_cnpj.substring(2, 5) + "." + cpf_cnpj.substring(5, 8) + "/"
					+ cpf_cnpj.substring(8, 12) + "-" + cpf_cnpj.substring(12, 14);

		}

	}

	public static String diretorioAssinaturas() {

		String retorno = "/AssinaturasSAL/";
		File diretorio = new File("c:\\123\\AssinaturasSAL\\");
		if (diretorio.exists()) {

			retorno = "c:\\123\\AssinaturasSAL\\";

		}

		return retorno;
	}

	public static String formataCampoData(Timestamp data) {

		if (data != null) {

			try {

				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String strData = format.format(data);
				return strData;
			} catch (DataStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			return "";
		return null;

	}

	public static String zeroEsquerda(String texto, Integer tamanho) {
		String zeros = "";
		String retorno = "";

		for (int i = 0; i < tamanho; i++) {
			zeros = zeros + "0";
		}

		retorno = zeros + texto;
		retorno = retorno.substring(retorno.length() - tamanho);

		return retorno;
	}

	public static String geraSecaoPerformer() {

		String retorno = "";

		DBConnection con = null;
		Statement stmt = null;

		try {
			con = DBConnection.getConnection(PeFacesApplication.getInstance().getName());
			stmt = con.createStatement();

			String sql_update = "UPDATE en_parametro set cd_secao = (select (COALESCE(cd_secao,0)+1) from en_parametro)";
			stmt.execute(sql_update);

			String sql_valor = "select cd_secao from en_parametro";
			ResultSet r = stmt.executeQuery(sql_valor);

			if (r.next()) {

				GregorianCalendar calendar = new GregorianCalendar();
				int ano = calendar.get(GregorianCalendar.YEAR);
				int mes = calendar.get(GregorianCalendar.MONTH);
				mes = mes + 1;
				int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
				int hora = calendar.get(GregorianCalendar.HOUR_OF_DAY);
				int minutos = calendar.get(GregorianCalendar.MINUTE);
				int segundos = calendar.get(GregorianCalendar.SECOND);
				int milesimos = calendar.get(GregorianCalendar.MILLISECOND);

				retorno = ano + "" + Utils.zeroEsquerda(mes + "", 2) + Utils.zeroEsquerda(dia + "", 2)
						+ Utils.zeroEsquerda(hora + "", 2) + Utils.zeroEsquerda(minutos + "", 2)
						+ Utils.zeroEsquerda(segundos + "", 2) + milesimos + "" + r.getInt(1);

			}

			r.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (con != null)
				con.freeConnection();

		}

		return retorno;
	}

	public static int ContaOcorrencias(String caracter, String palavra) {

		int pos = -1;
		int contagem = 0;
		while (true) {
			pos = palavra.indexOf("oc", pos + 1);
			if (pos < 0)
				break;
			contagem++;
		}

		return contagem;
	}

	public static int convertCentimetersToPixelsInX(double centimeters) {

		int xScale = 30; // 1cm ~= 30px
		int pixels = (int) Math.round(centimeters * xScale);

		return pixels;

	}

	public static String completeToLeft(String value, char c, int size) {
		String result = value;
		while (result.length() < size) {
			result = c + result;
		}
		return result;
	}

	public static void GeraHistoricoAnual(short empresa, short ano, short mes, short tipo, double credito, double debito) {

		String idLogin = (String) PeFacesApplication.getInstance().getAttribute(DSUsuario.EN_USUARIO_ID_USUARIO);
		Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());

		DSHistoricoAnual _DSHistoricoAnual;
		_DSHistoricoAnual = new DSHistoricoAnual(PeFacesApplication.getInstance().getName());
		
		
		try {
 			_DSHistoricoAnual.retrieve(DSHistoricoAnual.EN_HISTORICO_ANUAL_CD_EMPRESA + " = " + empresa + " and " 
					+ DSHistoricoAnual.EN_HISTORICO_ANUAL_NU_ANO + " = " + ano + " and " 
					+ DSHistoricoAnual.EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO + " = " + tipo);
		} catch (DataStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		if (_DSHistoricoAnual.getRowCount() == 0) {
			_DSHistoricoAnual.insertRow();
			_DSHistoricoAnual.setEnHistoricoAnualCdEmpresa(0, empresa);
			_DSHistoricoAnual.setEnHistoricoAnualNuAno(0, ano);
			_DSHistoricoAnual.setEnHistoricoAnualCdTipoLancamento(0, tipo);

			_DSHistoricoAnual.setEnHistoricoAnualIdUsuarioCad(0, idLogin);
			_DSHistoricoAnual.setEnHistoricoAnualDtCadastro(0, dataDeHoje);
		} else {
			_DSHistoricoAnual.setEnHistoricoAnualIdUsuarioAlt(0, idLogin);
			_DSHistoricoAnual.setEnHistoricoAnualDtAlteracao(0, dataDeHoje);
		}

		DBConnection con = null;
		Statement stmt = null;

		// Calcula saldo dos meses
		try {
			try {
				con = DBConnection.getConnection(PeFacesApplication.getInstance().getName());
				stmt = con.createStatement();

				String sql = "SELECT " + "SUM(COALESCE(en_ativo_passivo.vl_credito,0)) AS vl_credito, "
						+ "SUM(COALESCE(en_ativo_passivo.vl_debito,0)) AS vl_debito " + "FROM " + "en_ativo_passivo "
						+ "INNER JOIN en_historico_lancamento ON en_historico_lancamento.cd_historico_lancamento =  "
						+ "en_ativo_passivo.cd_historico_lancamento " + "WHERE " + "en_ativo_passivo.cd_empresa = "
						+ empresa + " AND " + "en_ativo_passivo.nu_ano = " + ano + " AND "
						+ "DATE_PART('YEAR', en_ativo_passivo.dt_historico) = " + ano + " AND "
						+ "DATE_PART('MONTH', en_ativo_passivo.dt_historico) = " + mes + " AND "
						+ "en_historico_lancamento.cd_tipo_lancamento =  " + tipo;

				ResultSet A = stmt.executeQuery(sql);
				if (A.next()) {

					switch (mes) {
					case 1: {
						_DSHistoricoAnual.setEnHistoricoAnualVlJanCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlJanDebito(0, A.getDouble(2));
						break;
					}
					case 2: {
						_DSHistoricoAnual.setEnHistoricoAnualVlFevCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlFevDebito(0, A.getDouble(2));
						break;
					}
					case 3: {
						_DSHistoricoAnual.setEnHistoricoAnualVlMarCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlMarDebito(0, A.getDouble(2));
						break;
					}
					case 4: {
						_DSHistoricoAnual.setEnHistoricoAnualVlAbrCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlAbrDebito(0, A.getDouble(2));
						break;
					}
					case 5: {
						_DSHistoricoAnual.setEnHistoricoAnualVlMaiCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlMaiDebito(0, A.getDouble(2));
						break;
					}
					case 6: {
						_DSHistoricoAnual.setEnHistoricoAnualVlJunCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlJunDebito(0, A.getDouble(2));
						break;
					}
					case 7: {
						_DSHistoricoAnual.setEnHistoricoAnualVlJulCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlJulDebito(0, A.getDouble(2));
						break;
					}
					case 8: {
						_DSHistoricoAnual.setEnHistoricoAnualVlAgoCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlAgoDebito(0, A.getDouble(2));
						break;
					}
					case 9: {
						_DSHistoricoAnual.setEnHistoricoAnualVlSetCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlSetDebito(0, A.getDouble(2));
						break;
					}
					case 10: {
						_DSHistoricoAnual.setEnHistoricoAnualVlOutCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlOutDebito(0, A.getDouble(2));
						break;
					}
					case 11: {
						_DSHistoricoAnual.setEnHistoricoAnualVlNovCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlNovDebito(0, A.getDouble(2));
						break;
					}
					case 12: {
						_DSHistoricoAnual.setEnHistoricoAnualVlDezCredito(0, A.getDouble(1));
						_DSHistoricoAnual.setEnHistoricoAnualVlDezDebito(0, A.getDouble(2));
						break;
					}
					}

				}
				
				_DSHistoricoAnual.update();
				
				
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		} finally {
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

	public static String getEclipce() {

		  

		return "SIM";

	}
	
	
	public static Date UltimoDiaMes(short mes, int ano) {

		String strMes = mes + "";
		Date data = null;

		if (mes < 10) {
			strMes = "0" + strMes;
		}

		String dateInString = ano + "-" + strMes + "-01";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			data = sdf.parse(dateInString);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Date ultimoDia = null;

		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(data);

		int dia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		try {
			ultimoDia = (new SimpleDateFormat("dd/MM/yyyy")).parse(dia + "/" + mes + "/" + ano);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return ultimoDia;
	}

	public static Date PrimeiroDiaMes(short mes, int ano) {

		String strMes = mes + "";
		String strDia = "01";

		if (mes < 10) {
			strMes = "0" + strMes;
		}

		if (mes == 11) {
			strDia = "02";
		}

		Date primeiroDia = null;

		try {
			primeiroDia = (new SimpleDateFormat("dd/MM/yyyy")).parse(strDia + "/" + mes + "/" + ano);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return primeiroDia;
	}
}
