package performer.contabil.persistence;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSFaturamentoMensal: A SOFIA generated model
 */
public class DSFaturamentoMensal extends DataStore {

     //constants for columns
     public static final String EN_FATURAMENTO_MENSAL_CD_EMPRESA="en_faturamento_mensal.cd_empresa";
     public static final String EN_FATURAMENTO_MENSAL_NU_MES="en_faturamento_mensal.nu_mes";
     public static final String EN_FATURAMENTO_MENSAL_NU_ANO="en_faturamento_mensal.nu_ano";
     public static final String EN_FATURAMENTO_MENSAL_ID_USUARIO_CAD="en_faturamento_mensal.id_usuario_cad";
     public static final String EN_FATURAMENTO_MENSAL_ID_USUARIO_ALT="en_faturamento_mensal.id_usuario_alt";
     public static final String EN_FATURAMENTO_MENSAL_DT_CADASTRO="en_faturamento_mensal.dt_cadastro";
     public static final String EN_FATURAMENTO_MENSAL_DT_ALTERACAO="en_faturamento_mensal.dt_alteracao";
     public static final String EN_FATURAMENTO_MENSAL_VL_FATURAMENTO="en_faturamento_mensal.vl_faturamento";
     public static final String EN_FATURAMENTO_MENSAL_VL_DESPESAS="en_faturamento_mensal.vl_despesas";
     public static final String EN_MES_NM_MES="en_mes.nm_mes";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSFaturamentoMensal object.
      * @param appName The SOFIA application name
      */
     public DSFaturamentoMensal (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSFaturamentoMensal object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSFaturamentoMensal (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_faturamento_mensal"),null);
          addTableAlias(computeTableName("en_mes"),null);

          //add columns
          addColumn(computeTableName("en_faturamento_mensal"),"cd_empresa",DataStore.DATATYPE_SHORT,true,true,EN_FATURAMENTO_MENSAL_CD_EMPRESA);
          addColumn(computeTableName("en_faturamento_mensal"),"nu_mes",DataStore.DATATYPE_SHORT,true,true,EN_FATURAMENTO_MENSAL_NU_MES);
          addColumn(computeTableName("en_faturamento_mensal"),"nu_ano",DataStore.DATATYPE_SHORT,true,true,EN_FATURAMENTO_MENSAL_NU_ANO);
          addColumn(computeTableName("en_faturamento_mensal"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true,EN_FATURAMENTO_MENSAL_ID_USUARIO_CAD);
          addColumn(computeTableName("en_faturamento_mensal"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_FATURAMENTO_MENSAL_ID_USUARIO_ALT);
          addColumn(computeTableName("en_faturamento_mensal"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_FATURAMENTO_MENSAL_DT_CADASTRO);
          addColumn(computeTableName("en_faturamento_mensal"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_FATURAMENTO_MENSAL_DT_ALTERACAO);
          addColumn(computeTableName("en_faturamento_mensal"),"vl_faturamento",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_MENSAL_VL_FATURAMENTO);
          addColumn(computeTableName("en_faturamento_mensal"),"vl_despesas",DataStore.DATATYPE_DOUBLE,false,true,EN_FATURAMENTO_MENSAL_VL_DESPESAS);
          addColumn(computeTableName("en_mes"),"nm_mes",DataStore.DATATYPE_STRING,false,true,EN_MES_NM_MES);

          //add joins
          addJoin(computeTableAndFieldName("en_faturamento_mensal.nu_mes"),computeTableAndFieldName("en_mes.nu_mes"),false);

          //set order by
          setOrderBy(computeTableAndFieldName("en_faturamento_mensal.nu_ano") + " ASC," + computeTableAndFieldName("en_faturamento_mensal.nu_mes") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_faturamento_mensal.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoMensalCdEmpresa() throws DataStoreException {
          return  getShort(EN_FATURAMENTO_MENSAL_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoMensalCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,EN_FATURAMENTO_MENSAL_CD_EMPRESA);
     }

     /**
      * Set the value of the en_faturamento_mensal.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalCdEmpresa(short newValue) throws DataStoreException {
          setShort(EN_FATURAMENTO_MENSAL_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,EN_FATURAMENTO_MENSAL_CD_EMPRESA, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.nu_mes column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoMensalNuMes() throws DataStoreException {
          return  getShort(EN_FATURAMENTO_MENSAL_NU_MES);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.nu_mes column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoMensalNuMes(int row) throws DataStoreException {
          return  getShort(row,EN_FATURAMENTO_MENSAL_NU_MES);
     }

     /**
      * Set the value of the en_faturamento_mensal.nu_mes column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalNuMes(short newValue) throws DataStoreException {
          setShort(EN_FATURAMENTO_MENSAL_NU_MES, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.nu_mes column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalNuMes(int row,short newValue) throws DataStoreException {
          setShort(row,EN_FATURAMENTO_MENSAL_NU_MES, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.nu_ano column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoMensalNuAno() throws DataStoreException {
          return  getShort(EN_FATURAMENTO_MENSAL_NU_ANO);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.nu_ano column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFaturamentoMensalNuAno(int row) throws DataStoreException {
          return  getShort(row,EN_FATURAMENTO_MENSAL_NU_ANO);
     }

     /**
      * Set the value of the en_faturamento_mensal.nu_ano column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalNuAno(short newValue) throws DataStoreException {
          setShort(EN_FATURAMENTO_MENSAL_NU_ANO, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.nu_ano column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalNuAno(int row,short newValue) throws DataStoreException {
          setShort(row,EN_FATURAMENTO_MENSAL_NU_ANO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.id_usuario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFaturamentoMensalIdUsuarioCad() throws DataStoreException {
          return  getString(EN_FATURAMENTO_MENSAL_ID_USUARIO_CAD);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFaturamentoMensalIdUsuarioCad(int row) throws DataStoreException {
          return  getString(row,EN_FATURAMENTO_MENSAL_ID_USUARIO_CAD);
     }

     /**
      * Set the value of the en_faturamento_mensal.id_usuario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalIdUsuarioCad(String newValue) throws DataStoreException {
          setString(EN_FATURAMENTO_MENSAL_ID_USUARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalIdUsuarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_FATURAMENTO_MENSAL_ID_USUARIO_CAD, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFaturamentoMensalIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_FATURAMENTO_MENSAL_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFaturamentoMensalIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_FATURAMENTO_MENSAL_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_faturamento_mensal.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_FATURAMENTO_MENSAL_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_FATURAMENTO_MENSAL_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFaturamentoMensalDtCadastro() throws DataStoreException {
          return  getDateTime(EN_FATURAMENTO_MENSAL_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFaturamentoMensalDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_FATURAMENTO_MENSAL_DT_CADASTRO);
     }

     /**
      * Set the value of the en_faturamento_mensal.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_FATURAMENTO_MENSAL_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_FATURAMENTO_MENSAL_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFaturamentoMensalDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_FATURAMENTO_MENSAL_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFaturamentoMensalDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_FATURAMENTO_MENSAL_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_faturamento_mensal.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_FATURAMENTO_MENSAL_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_FATURAMENTO_MENSAL_DT_ALTERACAO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.vl_faturamento column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoMensalVlFaturamento() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_MENSAL_VL_FATURAMENTO);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.vl_faturamento column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoMensalVlFaturamento(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_MENSAL_VL_FATURAMENTO);
     }

     /**
      * Set the value of the en_faturamento_mensal.vl_faturamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalVlFaturamento(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_MENSAL_VL_FATURAMENTO, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.vl_faturamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalVlFaturamento(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_MENSAL_VL_FATURAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.vl_despesas column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoMensalVlDespesas() throws DataStoreException {
          return  getDouble(EN_FATURAMENTO_MENSAL_VL_DESPESAS);
     }

     /**
      * Retrieve the value of the en_faturamento_mensal.vl_despesas column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnFaturamentoMensalVlDespesas(int row) throws DataStoreException {
          return  getDouble(row,EN_FATURAMENTO_MENSAL_VL_DESPESAS);
     }

     /**
      * Set the value of the en_faturamento_mensal.vl_despesas column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalVlDespesas(double newValue) throws DataStoreException {
          setDouble(EN_FATURAMENTO_MENSAL_VL_DESPESAS, newValue);
     }

     /**
      * Set the value of the en_faturamento_mensal.vl_despesas column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFaturamentoMensalVlDespesas(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_FATURAMENTO_MENSAL_VL_DESPESAS, newValue);
     }

     /**
      * Retrieve the value of the en_mes.nm_mes column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnMesNmMes() throws DataStoreException {
          return  getString(EN_MES_NM_MES);
     }

     /**
      * Retrieve the value of the en_mes.nm_mes column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnMesNmMes(int row) throws DataStoreException {
          return  getString(row,EN_MES_NM_MES);
     }

     /**
      * Set the value of the en_mes.nm_mes column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnMesNmMes(String newValue) throws DataStoreException {
          setString(EN_MES_NM_MES, newValue);
     }

     /**
      * Set the value of the en_mes.nm_mes column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnMesNmMes(int row,String newValue) throws DataStoreException {
          setString(row,EN_MES_NM_MES, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
