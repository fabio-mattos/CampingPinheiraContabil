package performer.contabil.persistence;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMIMPORTS$

/**
 * DSParametros: A SOFIA generated model
 */
public class DSParametros extends DataStore {

     //constants for columns
     public static final String EN_PARAMETRO_CD_PARAMETRO="en_parametro.cd_parametro";
     public static final String EN_PARAMETRO_DE_AVISO="en_parametro.de_aviso";
     public static final String EN_PARAMETRO_NM_EMPRESA_INSTALACAO="en_parametro.nm_empresa_instalacao";
     public static final String EN_PARAMETRO_FONES_EMPRESA_INSTALACAO="en_parametro.fones_empresa_instalacao";
     public static final String EN_PARAMETRO_DE_EMAIL_EMPRESA_INSTALACAO="en_parametro.de_email_empresa_instalacao";
     public static final String EN_PARAMETRO_NU_CNPJ_EMPRESA_INSTALACAO="en_parametro.nu_cnpj_empresa_instalacao";
     public static final String EN_PARAMETRO_DE_ENDERECO_EMPRESA_INSTALACAO="en_parametro.de_endereco_empresa_instalacao";
     public static final String EN_PARAMETRO_EMAIL_PERFORMER_HOSTNAME="en_parametro.email_performer_hostname";
     public static final String EN_PARAMETRO_EMAIL_PERFORMER_SMTPPORT="en_parametro.email_performer_smtpport";
     public static final String EN_PARAMETRO_EMAIL_PERFORMER_FROM="en_parametro.email_performer_from";
     public static final String EN_PARAMETRO_EMAIL_PERFORMER_USER="en_parametro.email_performer_user";
     public static final String EN_PARAMETRO_EMAIL_PERFORMER_PASSWORD="en_parametro.email_performer_password";
     public static final String EN_PARAMETRO_DE_SIGLA_EMPRESA_INSTALACAO="en_parametro.de_sigla_empresa_instalacao";

     //$CUSTOMVARS$
//Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMVARS$
     
     /**
      * Create a new DSParametros object.
      * @param appName The SOFIA application name
      */
     public DSParametros (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSParametros object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSParametros (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_parametro"),null);

          //add columns
          addColumn(computeTableName("en_parametro"),"cd_parametro",DataStore.DATATYPE_SHORT,false,true,EN_PARAMETRO_CD_PARAMETRO);
          addColumn(computeTableName("en_parametro"),"de_aviso",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_DE_AVISO);
          addColumn(computeTableName("en_parametro"),"nm_empresa_instalacao",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_NM_EMPRESA_INSTALACAO);
          addColumn(computeTableName("en_parametro"),"fones_empresa_instalacao",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_FONES_EMPRESA_INSTALACAO);
          addColumn(computeTableName("en_parametro"),"de_email_empresa_instalacao",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_DE_EMAIL_EMPRESA_INSTALACAO);
          addColumn(computeTableName("en_parametro"),"nu_cnpj_empresa_instalacao",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_NU_CNPJ_EMPRESA_INSTALACAO);
          addColumn(computeTableName("en_parametro"),"de_endereco_empresa_instalacao",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_DE_ENDERECO_EMPRESA_INSTALACAO);
          addColumn(computeTableName("en_parametro"),"email_performer_hostname",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_EMAIL_PERFORMER_HOSTNAME);
          addColumn(computeTableName("en_parametro"),"email_performer_smtpport",DataStore.DATATYPE_SHORT,false,true,EN_PARAMETRO_EMAIL_PERFORMER_SMTPPORT);
          addColumn(computeTableName("en_parametro"),"email_performer_from",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_EMAIL_PERFORMER_FROM);
          addColumn(computeTableName("en_parametro"),"email_performer_user",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_EMAIL_PERFORMER_USER);
          addColumn(computeTableName("en_parametro"),"email_performer_password",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_EMAIL_PERFORMER_PASSWORD);
          addColumn(computeTableName("en_parametro"),"de_sigla_empresa_instalacao",DataStore.DATATYPE_STRING,false,true,EN_PARAMETRO_DE_SIGLA_EMPRESA_INSTALACAO);

          //$CUSTOMCONSTRUCTOR$
//Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated
//$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_parametro.cd_parametro column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnParametroCdParametro() throws DataStoreException {
          return  getShort(EN_PARAMETRO_CD_PARAMETRO);
     }

     /**
      * Retrieve the value of the en_parametro.cd_parametro column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnParametroCdParametro(int row) throws DataStoreException {
          return  getShort(row,EN_PARAMETRO_CD_PARAMETRO);
     }

     /**
      * Set the value of the en_parametro.cd_parametro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroCdParametro(short newValue) throws DataStoreException {
          setShort(EN_PARAMETRO_CD_PARAMETRO, newValue);
     }

     /**
      * Set the value of the en_parametro.cd_parametro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroCdParametro(int row,short newValue) throws DataStoreException {
          setShort(row,EN_PARAMETRO_CD_PARAMETRO, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.de_aviso column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroDeAviso() throws DataStoreException {
          return  getString(EN_PARAMETRO_DE_AVISO);
     }

     /**
      * Retrieve the value of the en_parametro.de_aviso column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroDeAviso(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_DE_AVISO);
     }

     /**
      * Set the value of the en_parametro.de_aviso column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroDeAviso(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_DE_AVISO, newValue);
     }

     /**
      * Set the value of the en_parametro.de_aviso column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroDeAviso(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_DE_AVISO, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.nm_empresa_instalacao column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroNmEmpresaInstalacao() throws DataStoreException {
          return  getString(EN_PARAMETRO_NM_EMPRESA_INSTALACAO);
     }

     /**
      * Retrieve the value of the en_parametro.nm_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroNmEmpresaInstalacao(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_NM_EMPRESA_INSTALACAO);
     }

     /**
      * Set the value of the en_parametro.nm_empresa_instalacao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroNmEmpresaInstalacao(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_NM_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Set the value of the en_parametro.nm_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroNmEmpresaInstalacao(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_NM_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.fones_empresa_instalacao column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroFonesEmpresaInstalacao() throws DataStoreException {
          return  getString(EN_PARAMETRO_FONES_EMPRESA_INSTALACAO);
     }

     /**
      * Retrieve the value of the en_parametro.fones_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroFonesEmpresaInstalacao(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_FONES_EMPRESA_INSTALACAO);
     }

     /**
      * Set the value of the en_parametro.fones_empresa_instalacao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroFonesEmpresaInstalacao(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_FONES_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Set the value of the en_parametro.fones_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroFonesEmpresaInstalacao(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_FONES_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.de_email_empresa_instalacao column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroDeEmailEmpresaInstalacao() throws DataStoreException {
          return  getString(EN_PARAMETRO_DE_EMAIL_EMPRESA_INSTALACAO);
     }

     /**
      * Retrieve the value of the en_parametro.de_email_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroDeEmailEmpresaInstalacao(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_DE_EMAIL_EMPRESA_INSTALACAO);
     }

     /**
      * Set the value of the en_parametro.de_email_empresa_instalacao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroDeEmailEmpresaInstalacao(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_DE_EMAIL_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Set the value of the en_parametro.de_email_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroDeEmailEmpresaInstalacao(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_DE_EMAIL_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.nu_cnpj_empresa_instalacao column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroNuCnpjEmpresaInstalacao() throws DataStoreException {
          return  getString(EN_PARAMETRO_NU_CNPJ_EMPRESA_INSTALACAO);
     }

     /**
      * Retrieve the value of the en_parametro.nu_cnpj_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroNuCnpjEmpresaInstalacao(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_NU_CNPJ_EMPRESA_INSTALACAO);
     }

     /**
      * Set the value of the en_parametro.nu_cnpj_empresa_instalacao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroNuCnpjEmpresaInstalacao(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_NU_CNPJ_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Set the value of the en_parametro.nu_cnpj_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroNuCnpjEmpresaInstalacao(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_NU_CNPJ_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.de_endereco_empresa_instalacao column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroDeEnderecoEmpresaInstalacao() throws DataStoreException {
          return  getString(EN_PARAMETRO_DE_ENDERECO_EMPRESA_INSTALACAO);
     }

     /**
      * Retrieve the value of the en_parametro.de_endereco_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroDeEnderecoEmpresaInstalacao(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_DE_ENDERECO_EMPRESA_INSTALACAO);
     }

     /**
      * Set the value of the en_parametro.de_endereco_empresa_instalacao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroDeEnderecoEmpresaInstalacao(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_DE_ENDERECO_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Set the value of the en_parametro.de_endereco_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroDeEnderecoEmpresaInstalacao(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_DE_ENDERECO_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_hostname column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroEmailPerformerHostname() throws DataStoreException {
          return  getString(EN_PARAMETRO_EMAIL_PERFORMER_HOSTNAME);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_hostname column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroEmailPerformerHostname(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_EMAIL_PERFORMER_HOSTNAME);
     }

     /**
      * Set the value of the en_parametro.email_performer_hostname column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerHostname(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_EMAIL_PERFORMER_HOSTNAME, newValue);
     }

     /**
      * Set the value of the en_parametro.email_performer_hostname column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerHostname(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_EMAIL_PERFORMER_HOSTNAME, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_smtpport column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnParametroEmailPerformerSmtpport() throws DataStoreException {
          return  getShort(EN_PARAMETRO_EMAIL_PERFORMER_SMTPPORT);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_smtpport column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnParametroEmailPerformerSmtpport(int row) throws DataStoreException {
          return  getShort(row,EN_PARAMETRO_EMAIL_PERFORMER_SMTPPORT);
     }

     /**
      * Set the value of the en_parametro.email_performer_smtpport column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerSmtpport(short newValue) throws DataStoreException {
          setShort(EN_PARAMETRO_EMAIL_PERFORMER_SMTPPORT, newValue);
     }

     /**
      * Set the value of the en_parametro.email_performer_smtpport column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerSmtpport(int row,short newValue) throws DataStoreException {
          setShort(row,EN_PARAMETRO_EMAIL_PERFORMER_SMTPPORT, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_from column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroEmailPerformerFrom() throws DataStoreException {
          return  getString(EN_PARAMETRO_EMAIL_PERFORMER_FROM);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_from column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroEmailPerformerFrom(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_EMAIL_PERFORMER_FROM);
     }

     /**
      * Set the value of the en_parametro.email_performer_from column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerFrom(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_EMAIL_PERFORMER_FROM, newValue);
     }

     /**
      * Set the value of the en_parametro.email_performer_from column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerFrom(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_EMAIL_PERFORMER_FROM, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_user column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroEmailPerformerUser() throws DataStoreException {
          return  getString(EN_PARAMETRO_EMAIL_PERFORMER_USER);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_user column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroEmailPerformerUser(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_EMAIL_PERFORMER_USER);
     }

     /**
      * Set the value of the en_parametro.email_performer_user column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerUser(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_EMAIL_PERFORMER_USER, newValue);
     }

     /**
      * Set the value of the en_parametro.email_performer_user column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerUser(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_EMAIL_PERFORMER_USER, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_password column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroEmailPerformerPassword() throws DataStoreException {
          return  getString(EN_PARAMETRO_EMAIL_PERFORMER_PASSWORD);
     }

     /**
      * Retrieve the value of the en_parametro.email_performer_password column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroEmailPerformerPassword(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_EMAIL_PERFORMER_PASSWORD);
     }

     /**
      * Set the value of the en_parametro.email_performer_password column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerPassword(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_EMAIL_PERFORMER_PASSWORD, newValue);
     }

     /**
      * Set the value of the en_parametro.email_performer_password column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroEmailPerformerPassword(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_EMAIL_PERFORMER_PASSWORD, newValue);
     }

     /**
      * Retrieve the value of the en_parametro.de_sigla_empresa_instalacao column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroDeSiglaEmpresaInstalacao() throws DataStoreException {
          return  getString(EN_PARAMETRO_DE_SIGLA_EMPRESA_INSTALACAO);
     }

     /**
      * Retrieve the value of the en_parametro.de_sigla_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnParametroDeSiglaEmpresaInstalacao(int row) throws DataStoreException {
          return  getString(row,EN_PARAMETRO_DE_SIGLA_EMPRESA_INSTALACAO);
     }

     /**
      * Set the value of the en_parametro.de_sigla_empresa_instalacao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroDeSiglaEmpresaInstalacao(String newValue) throws DataStoreException {
          setString(EN_PARAMETRO_DE_SIGLA_EMPRESA_INSTALACAO, newValue);
     }

     /**
      * Set the value of the en_parametro.de_sigla_empresa_instalacao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnParametroDeSiglaEmpresaInstalacao(int row,String newValue) throws DataStoreException {
          setString(row,EN_PARAMETRO_DE_SIGLA_EMPRESA_INSTALACAO, newValue);
     }
     
     //$CUSTOMMETHODS$
//Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMMETHODS$
     
}
