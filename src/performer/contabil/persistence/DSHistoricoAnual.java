package performer.contabil.persistence;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSHistoricoAnual: A SOFIA generated model
 */
public class DSHistoricoAnual extends DataStore {

     //constants for columns
     public static final String EN_HISTORICO_ANUAL_CD_EMPRESA="en_historico_anual.cd_empresa";
     public static final String EN_HISTORICO_ANUAL_NU_ANO="en_historico_anual.nu_ano";
     public static final String EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO="en_historico_anual.cd_tipo_lancamento";
     public static final String EN_HISTORICO_ANUAL_ID_USUARIO_ALT="en_historico_anual.id_usuario_alt";
     public static final String EN_HISTORICO_ANUAL_DT_CADASTRO="en_historico_anual.dt_cadastro";
     public static final String EN_HISTORICO_ANUAL_DT_ALTERACAO="en_historico_anual.dt_alteracao";
     public static final String EN_HISTORICO_ANUAL_VL_JAN_CREDITO="en_historico_anual.vl_jan_credito";
     public static final String EN_HISTORICO_ANUAL_VL_JAN_DEBITO="en_historico_anual.vl_jan_debito";
     public static final String EN_HISTORICO_ANUAL_VL_FEV_CREDITO="en_historico_anual.vl_fev_credito";
     public static final String EN_HISTORICO_ANUAL_VL_FEV_DEBITO="en_historico_anual.vl_fev_debito";
     public static final String EN_HISTORICO_ANUAL_VL_MAR_CREDITO="en_historico_anual.vl_mar_credito";
     public static final String EN_HISTORICO_ANUAL_VL_MAR_DEBITO="en_historico_anual.vl_mar_debito";
     public static final String EN_HISTORICO_ANUAL_VL_ABR_CREDITO="en_historico_anual.vl_abr_credito";
     public static final String EN_HISTORICO_ANUAL_VL_ABR_DEBITO="en_historico_anual.vl_abr_debito";
     public static final String EN_HISTORICO_ANUAL_VL_MAI_CREDITO="en_historico_anual.vl_mai_credito";
     public static final String EN_HISTORICO_ANUAL_VL_MAI_DEBITO="en_historico_anual.vl_mai_debito";
     public static final String EN_HISTORICO_ANUAL_VL_JUN_CREDITO="en_historico_anual.vl_jun_credito";
     public static final String EN_HISTORICO_ANUAL_VL_JUN_DEBITO="en_historico_anual.vl_jun_debito";
     public static final String EN_HISTORICO_ANUAL_VL_JUL_CREDITO="en_historico_anual.vl_jul_credito";
     public static final String EN_HISTORICO_ANUAL_VL_JUL_DEBITO="en_historico_anual.vl_jul_debito";
     public static final String EN_HISTORICO_ANUAL_VL_AGO_CREDITO="en_historico_anual.vl_ago_credito";
     public static final String EN_HISTORICO_ANUAL_VL_AGO_DEBITO="en_historico_anual.vl_ago_debito";
     public static final String EN_HISTORICO_ANUAL_VL_SET_CREDITO="en_historico_anual.vl_set_credito";
     public static final String EN_HISTORICO_ANUAL_VL_SET_DEBITO="en_historico_anual.vl_set_debito";
     public static final String EN_HISTORICO_ANUAL_VL_OUT_CREDITO="en_historico_anual.vl_out_credito";
     public static final String EN_HISTORICO_ANUAL_VL_OUT_DEBITO="en_historico_anual.vl_out_debito";
     public static final String EN_HISTORICO_ANUAL_VL_NOV_CREDITO="en_historico_anual.vl_nov_credito";
     public static final String EN_HISTORICO_ANUAL_VL_NOV_DEBITO="en_historico_anual.vl_nov_debito";
     public static final String EN_HISTORICO_ANUAL_VL_DEZ_CREDITO="en_historico_anual.vl_dez_credito";
     public static final String EN_HISTORICO_ANUAL_VL_DEZ_DEBITO="en_historico_anual.vl_dez_debito";
     public static final String EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO="en_tipo_lancamento.nm_tipo_lancamento";
     public static final String EN_EMPRESA_NM_EMPRESA="en_empresa.nm_empresa";
     public static final String EN_HISTORICO_ANUAL_ID_USUARIO_CAD="en_historico_anual.id_usuario_cad";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSHistoricoAnual object.
      * @param appName The SOFIA application name
      */
     public DSHistoricoAnual (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSHistoricoAnual object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSHistoricoAnual (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_historico_anual"),null);
          addTableAlias(computeTableName("en_tipo_lancamento"),null);
          addTableAlias(computeTableName("en_empresa"),null);

          //add columns
          addColumn(computeTableName("en_historico_anual"),"cd_empresa",DataStore.DATATYPE_SHORT,true,true,EN_HISTORICO_ANUAL_CD_EMPRESA);
          addColumn(computeTableName("en_historico_anual"),"nu_ano",DataStore.DATATYPE_SHORT,true,true,EN_HISTORICO_ANUAL_NU_ANO);
          addColumn(computeTableName("en_historico_anual"),"cd_tipo_lancamento",DataStore.DATATYPE_SHORT,true,true,EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO);
          addColumn(computeTableName("en_historico_anual"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_HISTORICO_ANUAL_ID_USUARIO_ALT);
          addColumn(computeTableName("en_historico_anual"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_HISTORICO_ANUAL_DT_CADASTRO);
          addColumn(computeTableName("en_historico_anual"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_HISTORICO_ANUAL_DT_ALTERACAO);
          addColumn(computeTableName("en_historico_anual"),"vl_jan_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_JAN_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_jan_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_JAN_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_fev_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_FEV_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_fev_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_FEV_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_mar_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_MAR_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_mar_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_MAR_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_abr_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_ABR_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_abr_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_ABR_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_mai_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_MAI_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_mai_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_MAI_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_jun_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_JUN_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_jun_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_JUN_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_jul_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_JUL_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_jul_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_JUL_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_ago_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_AGO_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_ago_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_AGO_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_set_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_SET_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_set_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_SET_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_out_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_OUT_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_out_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_OUT_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_nov_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_NOV_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_nov_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_NOV_DEBITO);
          addColumn(computeTableName("en_historico_anual"),"vl_dez_credito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_DEZ_CREDITO);
          addColumn(computeTableName("en_historico_anual"),"vl_dez_debito",DataStore.DATATYPE_DOUBLE,false,true,EN_HISTORICO_ANUAL_VL_DEZ_DEBITO);
          addColumn(computeTableName("en_tipo_lancamento"),"nm_tipo_lancamento",DataStore.DATATYPE_STRING,false,true,EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
          addColumn(computeTableName("en_empresa"),"nm_empresa",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_NM_EMPRESA);
          addColumn(computeTableName("en_historico_anual"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true,EN_HISTORICO_ANUAL_ID_USUARIO_CAD);

          //add joins
          addJoin(computeTableAndFieldName("en_historico_anual.cd_tipo_lancamento"),computeTableAndFieldName("en_tipo_lancamento.cd_tipo_lancamento"),false);
          addJoin(computeTableAndFieldName("en_historico_anual.cd_empresa"),computeTableAndFieldName("en_empresa.cd_empresa"),false);

          //set order by
          setOrderBy(computeTableAndFieldName("en_historico_anual.nu_ano") + " ASC," + computeTableAndFieldName("en_tipo_lancamento.nm_tipo_lancamento") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_historico_anual.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoAnualCdEmpresa() throws DataStoreException {
          return  getShort(EN_HISTORICO_ANUAL_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_historico_anual.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoAnualCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,EN_HISTORICO_ANUAL_CD_EMPRESA);
     }

     /**
      * Set the value of the en_historico_anual.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualCdEmpresa(short newValue) throws DataStoreException {
          setShort(EN_HISTORICO_ANUAL_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_historico_anual.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,EN_HISTORICO_ANUAL_CD_EMPRESA, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.nu_ano column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoAnualNuAno() throws DataStoreException {
          return  getShort(EN_HISTORICO_ANUAL_NU_ANO);
     }

     /**
      * Retrieve the value of the en_historico_anual.nu_ano column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoAnualNuAno(int row) throws DataStoreException {
          return  getShort(row,EN_HISTORICO_ANUAL_NU_ANO);
     }

     /**
      * Set the value of the en_historico_anual.nu_ano column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualNuAno(short newValue) throws DataStoreException {
          setShort(EN_HISTORICO_ANUAL_NU_ANO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.nu_ano column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualNuAno(int row,short newValue) throws DataStoreException {
          setShort(row,EN_HISTORICO_ANUAL_NU_ANO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.cd_tipo_lancamento column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoAnualCdTipoLancamento() throws DataStoreException {
          return  getShort(EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_historico_anual.cd_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoAnualCdTipoLancamento(int row) throws DataStoreException {
          return  getShort(row,EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO);
     }

     /**
      * Set the value of the en_historico_anual.cd_tipo_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualCdTipoLancamento(short newValue) throws DataStoreException {
          setShort(EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.cd_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualCdTipoLancamento(int row,short newValue) throws DataStoreException {
          setShort(row,EN_HISTORICO_ANUAL_CD_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoAnualIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_HISTORICO_ANUAL_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_historico_anual.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoAnualIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_HISTORICO_ANUAL_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_historico_anual.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_HISTORICO_ANUAL_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_historico_anual.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_HISTORICO_ANUAL_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnHistoricoAnualDtCadastro() throws DataStoreException {
          return  getDateTime(EN_HISTORICO_ANUAL_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_historico_anual.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnHistoricoAnualDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_HISTORICO_ANUAL_DT_CADASTRO);
     }

     /**
      * Set the value of the en_historico_anual.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_HISTORICO_ANUAL_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_HISTORICO_ANUAL_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnHistoricoAnualDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_HISTORICO_ANUAL_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_historico_anual.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnHistoricoAnualDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_HISTORICO_ANUAL_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_historico_anual.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_HISTORICO_ANUAL_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_HISTORICO_ANUAL_DT_ALTERACAO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jan_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJanCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_JAN_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jan_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJanCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_JAN_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_jan_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJanCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_JAN_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_jan_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJanCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_JAN_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jan_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJanDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_JAN_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jan_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJanDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_JAN_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_jan_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJanDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_JAN_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_jan_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJanDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_JAN_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_fev_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlFevCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_FEV_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_fev_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlFevCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_FEV_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_fev_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlFevCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_FEV_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_fev_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlFevCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_FEV_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_fev_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlFevDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_FEV_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_fev_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlFevDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_FEV_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_fev_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlFevDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_FEV_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_fev_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlFevDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_FEV_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_mar_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlMarCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_MAR_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_mar_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlMarCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_MAR_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_mar_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlMarCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_MAR_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_mar_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlMarCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_MAR_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_mar_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlMarDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_MAR_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_mar_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlMarDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_MAR_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_mar_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlMarDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_MAR_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_mar_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlMarDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_MAR_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_abr_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlAbrCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_ABR_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_abr_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlAbrCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_ABR_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_abr_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlAbrCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_ABR_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_abr_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlAbrCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_ABR_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_abr_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlAbrDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_ABR_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_abr_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlAbrDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_ABR_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_abr_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlAbrDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_ABR_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_abr_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlAbrDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_ABR_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_mai_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlMaiCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_MAI_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_mai_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlMaiCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_MAI_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_mai_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlMaiCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_MAI_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_mai_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlMaiCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_MAI_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_mai_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlMaiDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_MAI_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_mai_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlMaiDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_MAI_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_mai_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlMaiDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_MAI_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_mai_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlMaiDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_MAI_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jun_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJunCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_JUN_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jun_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJunCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_JUN_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_jun_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJunCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_JUN_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_jun_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJunCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_JUN_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jun_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJunDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_JUN_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jun_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJunDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_JUN_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_jun_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJunDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_JUN_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_jun_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJunDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_JUN_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jul_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJulCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_JUL_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jul_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJulCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_JUL_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_jul_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJulCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_JUL_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_jul_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJulCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_JUL_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jul_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJulDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_JUL_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_jul_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlJulDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_JUL_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_jul_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJulDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_JUL_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_jul_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlJulDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_JUL_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_ago_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlAgoCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_AGO_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_ago_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlAgoCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_AGO_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_ago_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlAgoCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_AGO_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_ago_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlAgoCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_AGO_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_ago_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlAgoDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_AGO_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_ago_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlAgoDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_AGO_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_ago_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlAgoDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_AGO_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_ago_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlAgoDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_AGO_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_set_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlSetCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_SET_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_set_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlSetCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_SET_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_set_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlSetCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_SET_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_set_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlSetCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_SET_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_set_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlSetDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_SET_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_set_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlSetDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_SET_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_set_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlSetDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_SET_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_set_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlSetDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_SET_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_out_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlOutCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_OUT_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_out_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlOutCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_OUT_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_out_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlOutCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_OUT_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_out_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlOutCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_OUT_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_out_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlOutDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_OUT_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_out_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlOutDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_OUT_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_out_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlOutDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_OUT_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_out_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlOutDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_OUT_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_nov_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlNovCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_NOV_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_nov_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlNovCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_NOV_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_nov_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlNovCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_NOV_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_nov_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlNovCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_NOV_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_nov_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlNovDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_NOV_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_nov_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlNovDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_NOV_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_nov_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlNovDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_NOV_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_nov_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlNovDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_NOV_DEBITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_dez_credito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlDezCredito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_DEZ_CREDITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_dez_credito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlDezCredito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_DEZ_CREDITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_dez_credito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlDezCredito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_DEZ_CREDITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_dez_credito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlDezCredito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_DEZ_CREDITO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_dez_debito column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlDezDebito() throws DataStoreException {
          return  getDouble(EN_HISTORICO_ANUAL_VL_DEZ_DEBITO);
     }

     /**
      * Retrieve the value of the en_historico_anual.vl_dez_debito column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnHistoricoAnualVlDezDebito(int row) throws DataStoreException {
          return  getDouble(row,EN_HISTORICO_ANUAL_VL_DEZ_DEBITO);
     }

     /**
      * Set the value of the en_historico_anual.vl_dez_debito column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlDezDebito(double newValue) throws DataStoreException {
          setDouble(EN_HISTORICO_ANUAL_VL_DEZ_DEBITO, newValue);
     }

     /**
      * Set the value of the en_historico_anual.vl_dez_debito column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualVlDezDebito(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_HISTORICO_ANUAL_VL_DEZ_DEBITO, newValue);
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
      * Retrieve the value of the en_empresa.nm_empresa column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnEmpresaNmEmpresa() throws DataStoreException {
          return  getString(EN_EMPRESA_NM_EMPRESA);
     }

     /**
      * Retrieve the value of the en_empresa.nm_empresa column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnEmpresaNmEmpresa(int row) throws DataStoreException {
          return  getString(row,EN_EMPRESA_NM_EMPRESA);
     }

     /**
      * Set the value of the en_empresa.nm_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnEmpresaNmEmpresa(String newValue) throws DataStoreException {
          setString(EN_EMPRESA_NM_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_empresa.nm_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnEmpresaNmEmpresa(int row,String newValue) throws DataStoreException {
          setString(row,EN_EMPRESA_NM_EMPRESA, newValue);
     }

     /**
      * Retrieve the value of the en_historico_anual.id_usuario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoAnualIdUsuarioCad() throws DataStoreException {
          return  getString(EN_HISTORICO_ANUAL_ID_USUARIO_CAD);
     }

     /**
      * Retrieve the value of the en_historico_anual.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoAnualIdUsuarioCad(int row) throws DataStoreException {
          return  getString(row,EN_HISTORICO_ANUAL_ID_USUARIO_CAD);
     }

     /**
      * Set the value of the en_historico_anual.id_usuario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualIdUsuarioCad(String newValue) throws DataStoreException {
          setString(EN_HISTORICO_ANUAL_ID_USUARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_historico_anual.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoAnualIdUsuarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_HISTORICO_ANUAL_ID_USUARIO_CAD, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
