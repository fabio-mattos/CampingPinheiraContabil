package performer.contabil.persistence;

 

import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * java: A SOFIA generated model
 */
public class DSEmpresa extends DataStore {

     //constants for columns
     public static final String EN_EMPRESA_CD_EMPRESA="en_empresa.cd_empresa";
     public static final String EN_EMPRESA_NM_EMPRESA="en_empresa.nm_empresa";
     public static final String EN_EMPRESA_NU_CNPJ="en_empresa.nu_cnpj";
     public static final String EN_EMPRESA_DE_SIGLA="en_empresa.de_sigla";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new java object.
      * @param appName The SOFIA application name
      */
     public DSEmpresa (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new java object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSEmpresa (String appName, String profile) { 
          super(appName, profile);

          //add columns
          addColumn(computeTableName("en_empresa"),"cd_empresa",DataStore.DATATYPE_SHORT,false,true,EN_EMPRESA_CD_EMPRESA);
          addColumn(computeTableName("en_empresa"),"nm_empresa",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_NM_EMPRESA);
          addColumn(computeTableName("en_empresa"),"nu_cnpj",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_NU_CNPJ);
          addColumn(computeTableName("en_empresa"),"de_sigla",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_DE_SIGLA);

          //set order by
          setOrderBy(computeTableAndFieldName("en_empresa.de_sigla") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_empresa.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnEmpresaCdEmpresa() throws DataStoreException {
          return  getShort(EN_EMPRESA_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_empresa.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnEmpresaCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,EN_EMPRESA_CD_EMPRESA);
     }

     /**
      * Set the value of the en_empresa.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnEmpresaCdEmpresa(short newValue) throws DataStoreException {
          setShort(EN_EMPRESA_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_empresa.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnEmpresaCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,EN_EMPRESA_CD_EMPRESA, newValue);
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
      * Retrieve the value of the en_empresa.nu_cnpj column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnEmpresaNuCnpj() throws DataStoreException {
          return  getString(EN_EMPRESA_NU_CNPJ);
     }

     /**
      * Retrieve the value of the en_empresa.nu_cnpj column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnEmpresaNuCnpj(int row) throws DataStoreException {
          return  getString(row,EN_EMPRESA_NU_CNPJ);
     }

     /**
      * Set the value of the en_empresa.nu_cnpj column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnEmpresaNuCnpj(String newValue) throws DataStoreException {
          setString(EN_EMPRESA_NU_CNPJ, newValue);
     }

     /**
      * Set the value of the en_empresa.nu_cnpj column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnEmpresaNuCnpj(int row,String newValue) throws DataStoreException {
          setString(row,EN_EMPRESA_NU_CNPJ, newValue);
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
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
