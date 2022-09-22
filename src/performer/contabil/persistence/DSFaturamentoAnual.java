package performer.contabil.persistence;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSFaturamentoAnual: A SOFIA generated model
 */
public class DSFaturamentoAnual extends DataStore {

     //constants for columns
     public static final String EN_FATURAMENTO_ANUAL_NU_ANO="en_faturamento_anual.nu_ano";
     public static final String EN_FATURAMENTO_ANUAL_CD_EMPRESA="en_faturamento_anual.cd_empresa";
     public static final String EN_FATURAMENTO_ANUAL_ID_USUARIO_CAD="en_faturamento_anual.id_usuario_cad";
     public static final String EN_FATURAMENTO_ANUAL_ID_USUARIO_ALT="en_faturamento_anual.id_usuario_alt";
     public static final String EN_FATURAMENTO_ANUAL_DT_CADASTRO="en_faturamento_anual.dt_cadastro";
     public static final String EN_FATURAMENTO_ANUAL_DT_ALTERACAO="en_faturamento_anual.dt_alteracao";
     public static final String EN_FATURAMENTO_ANUAL_VL_JAN_FATURAMENTO="en_faturamento_anual.vl_jan_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_JAN_DESPESAS="en_faturamento_anual.vl_jan_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_FEV_FATURAMENTO="en_faturamento_anual.vl_fev_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_FEV_DESPESAS="en_faturamento_anual.vl_fev_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_MAR_FATURAMENTO="en_faturamento_anual.vl_mar_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_MAR_DESPESAS="en_faturamento_anual.vl_mar_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_ABR_FATURAMENTO="en_faturamento_anual.vl_abr_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_ABR_DESPESAS="en_faturamento_anual.vl_abr_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_MAI_FATURAMENTO="en_faturamento_anual.vl_mai_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_MAI_DESPESAS="en_faturamento_anual.vl_mai_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_JUN_FATURAMENTO="en_faturamento_anual.vl_jun_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_JUN_DESPESAS="en_faturamento_anual.vl_jun_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_JUL_FATURAMENTO="en_faturamento_anual.vl_jul_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_JUL_DESPESAS="en_faturamento_anual.vl_jul_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_AGO_FATURAMENTO="en_faturamento_anual.vl_ago_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_AGO_DESPESAS="en_faturamento_anual.vl_ago_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_SET_FATURAMENTO="en_faturamento_anual.vl_set_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_SET_DESPESAS="en_faturamento_anual.vl_set_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_OUT_FATURAMENTO="en_faturamento_anual.vl_out_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_OUT_DESPESAS="en_faturamento_anual.vl_out_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_NOV_FATURAMENTO="en_faturamento_anual.vl_nov_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_NOV_DESPESAS="en_faturamento_anual.vl_nov_despesas";
     public static final String EN_FATURAMENTO_ANUAL_VL_DEZ_FATURAMENTO="en_faturamento_anual.vl_dez_faturamento";
     public static final String EN_FATURAMENTO_ANUAL_VL_DEZ_DESPESAS="en_faturamento_anual.vl_dez_despesas";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSFaturamentoAnual object.
      * @param appName The SOFIA application name
      */
     public DSFaturamentoAnual (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSFaturamentoAnual object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSFaturamentoAnual (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_faturamento_anual"),null);

          //add columns
          addColumn(computeTableName("en_faturamento_anual"),"nu_ano",DataStore.DATATYPE_SHORT,false,true,EN_FATURAMENTO_ANUAL_NU_ANO);
          addColumn(computeTableName("en_faturamento_anual"),"cd_empresa",DataStore.DATATYPE_SHORT,false,true,EN_FATURAMENTO_ANUAL_CD_EMPRESA);
          addColumn(computeTableName("en_faturamento_anual"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true,EN_FATURAMENTO_ANUAL_ID_USUARIO_CAD);
          addColumn(computeTableName("en_faturamento_anual"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_FATURAMENTO_ANUAL_ID_USUARIO_ALT);
          addColumn(computeTableName("en_faturamento_anual"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_FATURAMENTO_ANUAL_DT_CADASTRO);
          addColumn(computeTableName("en_faturamento_anual"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_FATURAMENTO_ANUAL_DT_ALTERACAO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_jan_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_JAN_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_jan_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_JAN_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_fev_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_FEV_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_fev_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_FEV_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_mar_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_MAR_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_mar_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_MAR_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_abr_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_ABR_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_abr_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_ABR_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_mai_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_MAI_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_mai_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_MAI_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_jun_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_JUN_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_jun_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_JUN_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_jul_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_JUL_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_jul_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_JUL_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_ago_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_AGO_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_ago_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_AGO_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_set_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_SET_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_set_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_SET_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_out_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_OUT_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_out_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_OUT_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_nov_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_NOV_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_nov_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_NOV_DESPESAS);
          addColumn(computeTableName("en_faturamento_anual"),"vl_dez_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_DEZ_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_anual"),"vl_dez_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_ANUAL_VL_DEZ_DESPESAS);

          //set order by
          setOrderBy(computeTableAndFieldName("en_faturamento_anual.nu_ano") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_faturamento_anual.nu_ano column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoAnualNuAno() throws DataStoreException {
          return  getShort(EN_FATURAMENTO_ANUAL_NU_ANO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.nu_ano column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoAnualNuAno(int row) throws DataStoreException {
          return  getShort(row,EN_FATURAMENTO_ANUAL_NU_ANO);
     }

     /**
      * Set the value of the en_faturamento_anual.nu_ano column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualNuAno(short newValue) throws DataStoreException {
          setShort(EN_FATURAMENTO_ANUAL_NU_ANO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.nu_ano column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualNuAno(int row,short newValue) throws DataStoreException {
          setShort(row,EN_FATURAMENTO_ANUAL_NU_ANO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoAnualCdEmpresa() throws DataStoreException {
          return  getShort(EN_FATURAMENTO_ANUAL_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoAnualCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,EN_FATURAMENTO_ANUAL_CD_EMPRESA);
     }

     /**
      * Set the value of the en_faturamento_anual.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualCdEmpresa(short newValue) throws DataStoreException {
          setShort(EN_FATURAMENTO_ANUAL_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,EN_FATURAMENTO_ANUAL_CD_EMPRESA, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.id_usuario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFaturamentoAnualIdUsuarioCad() throws DataStoreException {
          return  getString(EN_FATURAMENTO_ANUAL_ID_USUARIO_CAD);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFaturamentoAnualIdUsuarioCad(int row) throws DataStoreException {
          return  getString(row,EN_FATURAMENTO_ANUAL_ID_USUARIO_CAD);
     }

     /**
      * Set the value of the en_faturamento_anual.id_usuario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualIdUsuarioCad(String newValue) throws DataStoreException {
          setString(EN_FATURAMENTO_ANUAL_ID_USUARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualIdUsuarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_FATURAMENTO_ANUAL_ID_USUARIO_CAD, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFaturamentoAnualIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_FATURAMENTO_ANUAL_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFaturamentoAnualIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_FATURAMENTO_ANUAL_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_faturamento_anual.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_FATURAMENTO_ANUAL_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_FATURAMENTO_ANUAL_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFaturamentoAnualDtCadastro() throws DataStoreException {
          return  getDateTime(EN_FATURAMENTO_ANUAL_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFaturamentoAnualDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_FATURAMENTO_ANUAL_DT_CADASTRO);
     }

     /**
      * Set the value of the en_faturamento_anual.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_FATURAMENTO_ANUAL_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_FATURAMENTO_ANUAL_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFaturamentoAnualDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_FATURAMENTO_ANUAL_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFaturamentoAnualDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_FATURAMENTO_ANUAL_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_faturamento_anual.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_FATURAMENTO_ANUAL_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_FATURAMENTO_ANUAL_DT_ALTERACAO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jan_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJanFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_JAN_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jan_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJanFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_JAN_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jan_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJanFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_JAN_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jan_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJanFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_JAN_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jan_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJanDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_JAN_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jan_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJanDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_JAN_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jan_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJanDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_JAN_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jan_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJanDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_JAN_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_fev_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlFevFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_FEV_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_fev_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlFevFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_FEV_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_fev_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlFevFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_FEV_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_fev_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlFevFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_FEV_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_fev_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlFevDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_FEV_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_fev_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlFevDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_FEV_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_fev_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlFevDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_FEV_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_fev_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlFevDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_FEV_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_mar_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlMarFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_MAR_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_mar_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlMarFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_MAR_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_mar_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlMarFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_MAR_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_mar_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlMarFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_MAR_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_mar_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlMarDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_MAR_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_mar_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlMarDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_MAR_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_mar_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlMarDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_MAR_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_mar_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlMarDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_MAR_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_abr_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlAbrFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_ABR_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_abr_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlAbrFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_ABR_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_abr_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlAbrFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_ABR_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_abr_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlAbrFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_ABR_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_abr_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlAbrDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_ABR_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_abr_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlAbrDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_ABR_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_abr_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlAbrDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_ABR_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_abr_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlAbrDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_ABR_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_mai_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlMaiFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_MAI_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_mai_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlMaiFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_MAI_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_mai_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlMaiFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_MAI_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_mai_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlMaiFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_MAI_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_mai_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlMaiDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_MAI_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_mai_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlMaiDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_MAI_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_mai_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlMaiDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_MAI_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_mai_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlMaiDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_MAI_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jun_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJunFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_JUN_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jun_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJunFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_JUN_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jun_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJunFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_JUN_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jun_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJunFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_JUN_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jun_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJunDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_JUN_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jun_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJunDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_JUN_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jun_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJunDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_JUN_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jun_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJunDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_JUN_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jul_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJulFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_JUL_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jul_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJulFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_JUL_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jul_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJulFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_JUL_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jul_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJulFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_JUL_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jul_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJulDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_JUL_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_jul_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlJulDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_JUL_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jul_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJulDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_JUL_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_jul_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlJulDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_JUL_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_ago_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlAgoFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_AGO_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_ago_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlAgoFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_AGO_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_ago_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlAgoFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_AGO_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_ago_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlAgoFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_AGO_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_ago_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlAgoDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_AGO_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_ago_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlAgoDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_AGO_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_ago_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlAgoDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_AGO_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_ago_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlAgoDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_AGO_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_set_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlSetFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_SET_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_set_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlSetFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_SET_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_set_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlSetFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_SET_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_set_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlSetFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_SET_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_set_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlSetDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_SET_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_set_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlSetDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_SET_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_set_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlSetDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_SET_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_set_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlSetDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_SET_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_out_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlOutFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_OUT_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_out_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlOutFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_OUT_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_out_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlOutFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_OUT_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_out_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlOutFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_OUT_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_out_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlOutDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_OUT_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_out_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlOutDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_OUT_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_out_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlOutDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_OUT_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_out_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlOutDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_OUT_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_nov_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlNovFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_NOV_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_nov_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlNovFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_NOV_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_nov_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlNovFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_NOV_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_nov_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlNovFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_NOV_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_nov_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlNovDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_NOV_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_nov_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlNovDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_NOV_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_nov_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlNovDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_NOV_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_nov_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlNovDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_NOV_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_dez_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlDezFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_DEZ_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_dez_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlDezFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_DEZ_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_dez_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlDezFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_DEZ_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_dez_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlDezFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_DEZ_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_dez_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlDezDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_ANUAL_VL_DEZ_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_anual.vl_dez_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoAnualVlDezDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_ANUAL_VL_DEZ_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_dez_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlDezDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_ANUAL_VL_DEZ_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_anual.vl_dez_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoAnualVlDezDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_ANUAL_VL_DEZ_DESPESAS, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
