package performer.contabil.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.salmonllc.sql.DBConnection;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;
import com.salmonllc.util.MessageLog;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSAtivoPassivo: A SOFIA generated model
 */
public class DSAtivoPassivo extends DataStore {

     //constants for columns
     public static final String EN_ATIVO_PASSIVO_CD_ATIVO_PASSIVO="en_ativo_passivo.cd_ativo_passivo";
     public static final String EN_ATIVO_PASSIVO_NU_ANO="en_ativo_passivo.nu_ano";
     public static final String EN_ATIVO_PASSIVO_NU_ANO_CODIGO="en_ativo_passivo.nu_ano_codigo";
     public static final String EN_ATIVO_PASSIVO_VL_CREDITO="en_ativo_passivo.vl_credito";
     public static final String EN_ATIVO_PASSIVO_VL_DEBITO="en_ativo_passivo.vl_debito";
     public static final String EN_ATIVO_PASSIVO_DT_CADASTRO="en_ativo_passivo.dt_cadastro";
     public static final String EN_ATIVO_PASSIVO_DT_ALTERACAO="en_ativo_passivo.dt_alteracao";
     public static final String EN_ATIVO_PASSIVO_ID_USUARIO_CAD="en_ativo_passivo.id_usuario_cad";
     public static final String EN_ATIVO_PASSIVO_ID_USUARIO_ALT="en_ativo_passivo.id_usuario_alt";
     public static final String EN_ATIVO_PASSIVO_DT_HISTORICO="en_ativo_passivo.dt_historico";
     public static final String EN_ATIVO_PASSIVO_CD_HISTORICO_LANCAMENTO="en_ativo_passivo.cd_historico_lancamento";
     public static final String EN_ATIVO_PASSIVO_CD_EMPRESA="en_ativo_passivo.cd_empresa";
     public static final String EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO="en_historico_lancamento.nm_historico_lancamento";
     public static final String EN_EMPRESA_DE_SIGLA="en_empresa.de_sigla";
     public static final String EN_ATIVO_PASSIVO_FG_EXCLUIDO="en_ativo_passivo.fg_excluido";
     public static final String EN_ATIVO_PASSIVO_VL_SALDO="en_ativo_passivo.vl_saldo";
     public static final String EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO="en_historico_lancamento.cd_tipo_lancamento";
     public static final String EN_ATIVO_PASSIVO_NU_MES="en_ativo_passivo.nu_mes";
     public static final String EN_ATIVO_PASSIVO_SQ_MES="en_ativo_passivo.sq_mes";
     public static final String EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO="en_tipo_lancamento.nm_tipo_lancamento";
     public static final String EN_ATIVO_PASSIVO_QT_CONSUMO="en_ativo_passivo.qt_consumo";
     public static final String EN_ATIVO_PASSIVO_NU_PAGINA="en_ativo_passivo.nu_pagina";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     private int _ano = -1;
     private int _codigo = -1;
     private int _ano_codigo = -1;
     private int _seq_mes  = -1;
     
     private double  _ultimoSaldo = 0;
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSAtivoPassivo object.
      * @param appName The SOFIA application name
      */
     public DSAtivoPassivo (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSAtivoPassivo object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSAtivoPassivo (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_ativo_passivo"),null);
          addTableAlias(computeTableName("en_historico_lancamento"),null);
          addTableAlias(computeTableName("en_empresa"),null);
          addTableAlias(computeTableName("en_tipo_lancamento"),null);

          //add columns
          addColumn(computeTableName("en_ativo_passivo"),"cd_ativo_passivo",DataStore.DATATYPE_INT,true,true,EN_ATIVO_PASSIVO_CD_ATIVO_PASSIVO);
          addColumn(computeTableName("en_ativo_passivo"),"nu_ano",DataStore.DATATYPE_SHORT,false,true,EN_ATIVO_PASSIVO_NU_ANO);
          addColumn(computeTableName("en_ativo_passivo"),"nu_ano_codigo",DataStore.DATATYPE_INT,false,true,EN_ATIVO_PASSIVO_NU_ANO_CODIGO);
          addColumn(computeTableName("en_ativo_passivo"),"vl_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_ATIVO_PASSIVO_VL_CREDITO);
          addColumn(computeTableName("en_ativo_passivo"),"vl_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_ATIVO_PASSIVO_VL_DEBITO);
          addColumn(computeTableName("en_ativo_passivo"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_ATIVO_PASSIVO_DT_CADASTRO);
          addColumn(computeTableName("en_ativo_passivo"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_ATIVO_PASSIVO_DT_ALTERACAO);
          addColumn(computeTableName("en_ativo_passivo"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true,EN_ATIVO_PASSIVO_ID_USUARIO_CAD);
          addColumn(computeTableName("en_ativo_passivo"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_ATIVO_PASSIVO_ID_USUARIO_ALT);
          addColumn(computeTableName("en_ativo_passivo"),"dt_historico",DataStore.DATATYPE_DATETIME,false,true,EN_ATIVO_PASSIVO_DT_HISTORICO);
          addColumn(computeTableName("en_ativo_passivo"),"cd_historico_lancamento",DataStore.DATATYPE_INT,false,true,EN_ATIVO_PASSIVO_CD_HISTORICO_LANCAMENTO);
          addColumn(computeTableName("en_ativo_passivo"),"cd_empresa",DataStore.DATATYPE_SHORT,false,true,EN_ATIVO_PASSIVO_CD_EMPRESA);
          addColumn(computeTableName("en_historico_lancamento"),"nm_historico_lancamento",DataStore.DATATYPE_STRING,false,true,EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
          addColumn(computeTableName("en_empresa"),"de_sigla",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_DE_SIGLA);
          addColumn(computeTableName("en_ativo_passivo"),"fg_excluido",DataStore.DATATYPE_STRING,false,true,EN_ATIVO_PASSIVO_FG_EXCLUIDO);
          addColumn(computeTableName("en_ativo_passivo"),"vl_saldo",DataStore.DATATYPE_DOUBLE,false,true,EN_ATIVO_PASSIVO_VL_SALDO);
          addColumn(computeTableName("en_historico_lancamento"),"cd_tipo_lancamento",DataStore.DATATYPE_SHORT,false,true,EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO);
          addColumn(computeTableName("en_ativo_passivo"),"nu_mes",DataStore.DATATYPE_SHORT,false,true,EN_ATIVO_PASSIVO_NU_MES);
          addColumn(computeTableName("en_ativo_passivo"),"sq_mes",DataStore.DATATYPE_INT,false,true,EN_ATIVO_PASSIVO_SQ_MES);
          addColumn(computeTableName("en_tipo_lancamento"),"nm_tipo_lancamento",DataStore.DATATYPE_STRING,false,true,EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
          addColumn(computeTableName("en_ativo_passivo"),"qt_consumo",DataStore.DATATYPE_INT,false,true,EN_ATIVO_PASSIVO_QT_CONSUMO);
          addColumn(computeTableName("en_ativo_passivo"),"nu_pagina",DataStore.DATATYPE_INT,false,true,EN_ATIVO_PASSIVO_NU_PAGINA);

          //add joins
          addJoin(computeTableAndFieldName("en_ativo_passivo.cd_historico_lancamento"),computeTableAndFieldName("en_historico_lancamento.cd_historico_lancamento"),false);
          addJoin(computeTableAndFieldName("en_ativo_passivo.cd_empresa"),computeTableAndFieldName("en_empresa.cd_empresa"),false);
          addJoin(computeTableAndFieldName("en_ativo_passivo.cd_empresa") + "," +computeTableAndFieldName("en_historico_lancamento.cd_tipo_lancamento"),computeTableAndFieldName("en_tipo_lancamento.cd_empresa") + "," +computeTableAndFieldName("en_tipo_lancamento.cd_tipo_lancamento"),false);

          //set order by
          setOrderBy(computeTableAndFieldName("en_ativo_passivo.dt_historico") + " DESC," + computeTableAndFieldName("en_ativo_passivo.cd_ativo_passivo") + " DESC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_ativo_passivo.cd_ativo_passivo column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoCdAtivoPassivo() throws DataStoreException {
          return  getInt(EN_ATIVO_PASSIVO_CD_ATIVO_PASSIVO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.cd_ativo_passivo column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoCdAtivoPassivo(int row) throws DataStoreException {
          return  getInt(row,EN_ATIVO_PASSIVO_CD_ATIVO_PASSIVO);
     }

     /**
      * Set the value of the en_ativo_passivo.cd_ativo_passivo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoCdAtivoPassivo(int newValue) throws DataStoreException {
          setInt(EN_ATIVO_PASSIVO_CD_ATIVO_PASSIVO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.cd_ativo_passivo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoCdAtivoPassivo(int row,int newValue) throws DataStoreException {
          setInt(row,EN_ATIVO_PASSIVO_CD_ATIVO_PASSIVO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.nu_ano column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnAtivoPassivoNuAno() throws DataStoreException {
          return  getShort(EN_ATIVO_PASSIVO_NU_ANO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.nu_ano column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnAtivoPassivoNuAno(int row) throws DataStoreException {
          return  getShort(row,EN_ATIVO_PASSIVO_NU_ANO);
     }

     /**
      * Set the value of the en_ativo_passivo.nu_ano column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoNuAno(short newValue) throws DataStoreException {
          setShort(EN_ATIVO_PASSIVO_NU_ANO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.nu_ano column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoNuAno(int row,short newValue) throws DataStoreException {
          setShort(row,EN_ATIVO_PASSIVO_NU_ANO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.nu_ano_codigo column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoNuAnoCodigo() throws DataStoreException {
          return  getInt(EN_ATIVO_PASSIVO_NU_ANO_CODIGO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.nu_ano_codigo column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoNuAnoCodigo(int row) throws DataStoreException {
          return  getInt(row,EN_ATIVO_PASSIVO_NU_ANO_CODIGO);
     }

     /**
      * Set the value of the en_ativo_passivo.nu_ano_codigo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoNuAnoCodigo(int newValue) throws DataStoreException {
          setInt(EN_ATIVO_PASSIVO_NU_ANO_CODIGO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.nu_ano_codigo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoNuAnoCodigo(int row,int newValue) throws DataStoreException {
          setInt(row,EN_ATIVO_PASSIVO_NU_ANO_CODIGO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.vl_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnAtivoPassivoVlCredito() throws DataStoreException {
          return  getDouble(EN_ATIVO_PASSIVO_VL_CREDITO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.vl_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnAtivoPassivoVlCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_ATIVO_PASSIVO_VL_CREDITO);
     }

     /**
      * Set the value of the en_ativo_passivo.vl_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoVlCredito(double newValue) throws DataStoreException {
          setDouble(EN_ATIVO_PASSIVO_VL_CREDITO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.vl_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoVlCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_ATIVO_PASSIVO_VL_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.vl_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnAtivoPassivoVlDebito() throws DataStoreException {
          return  getDouble(EN_ATIVO_PASSIVO_VL_DEBITO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.vl_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnAtivoPassivoVlDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_ATIVO_PASSIVO_VL_DEBITO);
     }

     /**
      * Set the value of the en_ativo_passivo.vl_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoVlDebito(double newValue) throws DataStoreException {
          setDouble(EN_ATIVO_PASSIVO_VL_DEBITO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.vl_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoVlDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_ATIVO_PASSIVO_VL_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnAtivoPassivoDtCadastro() throws DataStoreException {
          return  getDateTime(EN_ATIVO_PASSIVO_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnAtivoPassivoDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_ATIVO_PASSIVO_DT_CADASTRO);
     }

     /**
      * Set the value of the en_ativo_passivo.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_ATIVO_PASSIVO_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_ATIVO_PASSIVO_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnAtivoPassivoDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_ATIVO_PASSIVO_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnAtivoPassivoDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_ATIVO_PASSIVO_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_ativo_passivo.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_ATIVO_PASSIVO_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_ATIVO_PASSIVO_DT_ALTERACAO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.id_usuario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnAtivoPassivoIdUsuarioCad() throws DataStoreException {
          return  getString(EN_ATIVO_PASSIVO_ID_USUARIO_CAD);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnAtivoPassivoIdUsuarioCad(int row) throws DataStoreException {
          return  getString(row,EN_ATIVO_PASSIVO_ID_USUARIO_CAD);
     }

     /**
      * Set the value of the en_ativo_passivo.id_usuario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoIdUsuarioCad(String newValue) throws DataStoreException {
          setString(EN_ATIVO_PASSIVO_ID_USUARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoIdUsuarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_ATIVO_PASSIVO_ID_USUARIO_CAD, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnAtivoPassivoIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_ATIVO_PASSIVO_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnAtivoPassivoIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_ATIVO_PASSIVO_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_ativo_passivo.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_ATIVO_PASSIVO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_ATIVO_PASSIVO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.dt_historico column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnAtivoPassivoDtHistorico() throws DataStoreException {
          return  getDateTime(EN_ATIVO_PASSIVO_DT_HISTORICO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.dt_historico column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnAtivoPassivoDtHistorico(int row) throws DataStoreException {
          return  getDateTime(row,EN_ATIVO_PASSIVO_DT_HISTORICO);
     }

     /**
      * Set the value of the en_ativo_passivo.dt_historico column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoDtHistorico(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_ATIVO_PASSIVO_DT_HISTORICO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.dt_historico column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoDtHistorico(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_ATIVO_PASSIVO_DT_HISTORICO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.cd_historico_lancamento column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoCdHistoricoLancamento() throws DataStoreException {
          return  getInt(EN_ATIVO_PASSIVO_CD_HISTORICO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.cd_historico_lancamento column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoCdHistoricoLancamento(int row) throws DataStoreException {
          return  getInt(row,EN_ATIVO_PASSIVO_CD_HISTORICO_LANCAMENTO);
     }

     /**
      * Set the value of the en_ativo_passivo.cd_historico_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoCdHistoricoLancamento(int newValue) throws DataStoreException {
          setInt(EN_ATIVO_PASSIVO_CD_HISTORICO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.cd_historico_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoCdHistoricoLancamento(int row,int newValue) throws DataStoreException {
          setInt(row,EN_ATIVO_PASSIVO_CD_HISTORICO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnAtivoPassivoCdEmpresa() throws DataStoreException {
          return  getShort(EN_ATIVO_PASSIVO_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnAtivoPassivoCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,EN_ATIVO_PASSIVO_CD_EMPRESA);
     }

     /**
      * Set the value of the en_ativo_passivo.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoCdEmpresa(short newValue) throws DataStoreException {
          setShort(EN_ATIVO_PASSIVO_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,EN_ATIVO_PASSIVO_CD_EMPRESA, newValue);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.nm_historico_lancamento column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoNmHistoricoLancamento() throws DataStoreException {
          return  getString(EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.nm_historico_lancamento column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoNmHistoricoLancamento(int row) throws DataStoreException {
          return  getString(row,EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
     }

     /**
      * Set the value of the en_historico_lancamento.nm_historico_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoNmHistoricoLancamento(String newValue) throws DataStoreException {
          setString(EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.nm_historico_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoNmHistoricoLancamento(int row,String newValue) throws DataStoreException {
          setString(row,EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_empresa.de_sigla column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnEmpresaDeSigla() throws DataStoreException {
          return  getString(EN_EMPRESA_DE_SIGLA);
     }

     /**
      * Retrieve the value of the en_empresa.de_sigla column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnEmpresaDeSigla(int row) throws DataStoreException {
          return  getString(row,EN_EMPRESA_DE_SIGLA);
     }

     /**
      * Set the value of the en_empresa.de_sigla column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnEmpresaDeSigla(String newValue) throws DataStoreException {
          setString(EN_EMPRESA_DE_SIGLA, newValue);
     }

     /**
      * Set the value of the en_empresa.de_sigla column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnEmpresaDeSigla(int row,String newValue) throws DataStoreException {
          setString(row,EN_EMPRESA_DE_SIGLA, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.fg_excluido column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnAtivoPassivoFgExcluido() throws DataStoreException {
          return  getString(EN_ATIVO_PASSIVO_FG_EXCLUIDO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.fg_excluido column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnAtivoPassivoFgExcluido(int row) throws DataStoreException {
          return  getString(row,EN_ATIVO_PASSIVO_FG_EXCLUIDO);
     }

     /**
      * Set the value of the en_ativo_passivo.fg_excluido column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoFgExcluido(String newValue) throws DataStoreException {
          setString(EN_ATIVO_PASSIVO_FG_EXCLUIDO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.fg_excluido column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoFgExcluido(int row,String newValue) throws DataStoreException {
          setString(row,EN_ATIVO_PASSIVO_FG_EXCLUIDO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.vl_saldo column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnAtivoPassivoVlSaldo() throws DataStoreException {
          return  getDouble(EN_ATIVO_PASSIVO_VL_SALDO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.vl_saldo column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnAtivoPassivoVlSaldo(int row) throws DataStoreException {
          return  getDouble(row,EN_ATIVO_PASSIVO_VL_SALDO);
     }

     /**
      * Set the value of the en_ativo_passivo.vl_saldo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoVlSaldo(double newValue) throws DataStoreException {
          setDouble(EN_ATIVO_PASSIVO_VL_SALDO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.vl_saldo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoVlSaldo(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_ATIVO_PASSIVO_VL_SALDO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.cd_tipo_lancamento column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoLancamentoCdTipoLancamento() throws DataStoreException {
          return  getShort(EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.cd_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoLancamentoCdTipoLancamento(int row) throws DataStoreException {
          return  getShort(row,EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO);
     }

     /**
      * Set the value of the en_historico_lancamento.cd_tipo_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoCdTipoLancamento(short newValue) throws DataStoreException {
          setShort(EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.cd_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoCdTipoLancamento(int row,short newValue) throws DataStoreException {
          setShort(row,EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.nu_mes column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnAtivoPassivoNuMes() throws DataStoreException {
          return  getShort(EN_ATIVO_PASSIVO_NU_MES);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.nu_mes column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnAtivoPassivoNuMes(int row) throws DataStoreException {
          return  getShort(row,EN_ATIVO_PASSIVO_NU_MES);
     }

     /**
      * Set the value of the en_ativo_passivo.nu_mes column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoNuMes(short newValue) throws DataStoreException {
          setShort(EN_ATIVO_PASSIVO_NU_MES, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.nu_mes column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoNuMes(int row,short newValue) throws DataStoreException {
          setShort(row,EN_ATIVO_PASSIVO_NU_MES, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.sq_mes column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoSqMes() throws DataStoreException {
          return  getInt(EN_ATIVO_PASSIVO_SQ_MES);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.sq_mes column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoSqMes(int row) throws DataStoreException {
          return  getInt(row,EN_ATIVO_PASSIVO_SQ_MES);
     }

     /**
      * Set the value of the en_ativo_passivo.sq_mes column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoSqMes(int newValue) throws DataStoreException {
          setInt(EN_ATIVO_PASSIVO_SQ_MES, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.sq_mes column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoSqMes(int row,int newValue) throws DataStoreException {
          setInt(row,EN_ATIVO_PASSIVO_SQ_MES, newValue);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.nm_tipo_lancamento column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoNmTipoLancamento() throws DataStoreException {
          return  getString(EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.nm_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoNmTipoLancamento(int row) throws DataStoreException {
          return  getString(row,EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
     }

     /**
      * Set the value of the en_tipo_lancamento.nm_tipo_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoNmTipoLancamento(String newValue) throws DataStoreException {
          setString(EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.nm_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoNmTipoLancamento(int row,String newValue) throws DataStoreException {
          setString(row,EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.qt_consumo column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoQtConsumo() throws DataStoreException {
          return  getInt(EN_ATIVO_PASSIVO_QT_CONSUMO);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.qt_consumo column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoQtConsumo(int row) throws DataStoreException {
          return  getInt(row,EN_ATIVO_PASSIVO_QT_CONSUMO);
     }

     /**
      * Set the value of the en_ativo_passivo.qt_consumo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoQtConsumo(int newValue) throws DataStoreException {
          setInt(EN_ATIVO_PASSIVO_QT_CONSUMO, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.qt_consumo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoQtConsumo(int row,int newValue) throws DataStoreException {
          setInt(row,EN_ATIVO_PASSIVO_QT_CONSUMO, newValue);
     }
     
     
     /**
      * Retrieve the value of the en_ativo_passivo.nu_pagina column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoNuPagina() throws DataStoreException {
          return  getInt(EN_ATIVO_PASSIVO_NU_PAGINA);
     }

     /**
      * Retrieve the value of the en_ativo_passivo.nu_pagina column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnAtivoPassivoNuPagina(int row) throws DataStoreException {
          return  getInt(row,EN_ATIVO_PASSIVO_NU_PAGINA);
     }

     /**
      * Set the value of the en_ativo_passivo.nu_pagina column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoNuPagina(int newValue) throws DataStoreException {
          setInt(EN_ATIVO_PASSIVO_NU_PAGINA, newValue);
     }

     /**
      * Set the value of the en_ativo_passivo.nu_pagina column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnAtivoPassivoNuPagina(int row,int newValue) throws DataStoreException {
          setInt(row,EN_ATIVO_PASSIVO_NU_PAGINA, newValue);
     }
     
     //$CUSTOMMETHODS$



     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated


     



     public void update(DBConnection conn, boolean handleTrans) throws DataStoreException, SQLException {
    		_codigo = -1;
    		_ano = -1;

    		synchronized (this) {
    			for (int i = 0; i < getRowCount(); i++) {
    				if (getRowStatus(i) == STATUS_NEW_MODIFIED)
    					generateCd(conn, i);
    			}
    			super.update(conn, handleTrans);
    		}
    	 }


    	private void generateCd(DBConnection conn, int row) throws DataStoreException {
    		if (getEnAtivoPassivoCdAtivoPassivo()       > 0)
    			return;
    		if (_codigo != -1) {
    			setEnAtivoPassivoCdAtivoPassivo( row,(int)_codigo++);
    			return;
    		}
    		try {


    		 String SelectAno = "SELECT DATE_PART('YEAR', CURRENT_TIMESTAMP) ";	
    		 Statement st = conn.createStatement();
 			 ResultSet A = st.executeQuery(SelectAno);
 		  	 if (A.next())
 				_ano = A.getInt(1);	


    			String selectID = "SELECT COALESCE(max(cd_ativo_passivo),0) + 1 as codigo,  cast( CAST(  DATE_PART('YEAR', CURRENT_TIMESTAMP) AS VARCHAR(4)) ||   " +
    			"CAST(COALESCE(max(cd_ativo_passivo),0) + 1 AS VARCHAR(50)) as INTEGER) AS ano_codigo    from en_ativo_passivo  ";
    			
    			
    			//String selectUltimoSaldo = "select vl_saldo from en_ativo_passivo where nu_ano_codigo = (SELECT max(nu_ano_codigo) from   en_ativo_passivo where en_ativo_passivo.cd_empresa = " + getEnAtivoPassivoCdEmpresa() + ")";
    			
     			
    			ResultSet r = st.executeQuery(selectID);

    			if (r.next()) {
    				_codigo = r.getInt(1) ;
    				_ano_codigo  = r.getInt(2) ;
    				
    			}
 
    			/*
    			ResultSet u = st.executeQuery(selectUltimoSaldo);
    			if (u.next()) {
    				_ultimoSaldo = u.getDouble(1) ;
    				
    			}
    			
    			
    			if (getEnAtivoPassivoVlCredito() > 0 ) {
    				_ultimoSaldo = _ultimoSaldo  + getEnAtivoPassivoVlCredito();
    			} else {
    				_ultimoSaldo = _ultimoSaldo  - getEnAtivoPassivoVlDebito();
    			}
    			*/
    			
    			
    			
    			r.close();
    			//u.close();


    			st.close();


    		} catch (Exception e) {

    			MessageLog.writeErrorMessage("generateCd", e, this);

    		}


           //setEnAtivoPassivoVlSaldo((double)_ultimoSaldo);
           

    		setEnAtivoPassivoCdAtivoPassivo((int)_codigo);
 
    		
    		setEnAtivoPassivoNuAnoCodigo((int) _ano_codigo);
    		setEnAtivoPassivoSqMes((int) _seq_mes);
    		
    		
    	}




     //$ENDCUSTOMMETHODS$
     
}
