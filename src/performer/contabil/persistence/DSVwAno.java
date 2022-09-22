package performer.contabil.persistence;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSVwAno: A SOFIA generated model
 */
public class DSVwAno extends DataStore {

     //constants for columns
     public static final String VW_ANO_NU_ANO="vw_ano.nu_ano";
     public static final String VW_ANO_CD_EMPRESA="vw_ano.cd_empresa";
     public static final String VW_ANO_FG_SEL="vw_ano.fg_sel";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSVwAno object.
      * @param appName The SOFIA application name
      */
     public DSVwAno (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSVwAno object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSVwAno (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("vw_ano"),null);

          //add columns
          addColumn(computeTableName("vw_ano"),"nu_ano",DataStore.DATATYPE_SHORT,false,true,VW_ANO_NU_ANO);
          addColumn(computeTableName("vw_ano"),"cd_empresa",DataStore.DATATYPE_SHORT,false,true,VW_ANO_CD_EMPRESA);
          addColumn(computeTableName("vw_ano"),"fg_sel",DataStore.DATATYPE_STRING,false,true,VW_ANO_FG_SEL);

          //set order by
          setOrderBy(computeTableAndFieldName("vw_ano.nu_ano") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the vw_ano.nu_ano column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getVwAnoNuAno() throws DataStoreException {
          return  getShort(VW_ANO_NU_ANO);
     }

     /**
      * Retrieve the value of the vw_ano.nu_ano column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getVwAnoNuAno(int row) throws DataStoreException {
          return  getShort(row,VW_ANO_NU_ANO);
     }

     /**
      * Set the value of the vw_ano.nu_ano column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setVwAnoNuAno(short newValue) throws DataStoreException {
          setShort(VW_ANO_NU_ANO, newValue);
     }

     /**
      * Set the value of the vw_ano.nu_ano column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setVwAnoNuAno(int row,short newValue) throws DataStoreException {
          setShort(row,VW_ANO_NU_ANO, newValue);
     }

     /**
      * Retrieve the value of the vw_ano.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getVwAnoCdEmpresa() throws DataStoreException {
          return  getShort(VW_ANO_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the vw_ano.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getVwAnoCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,VW_ANO_CD_EMPRESA);
     }

     /**
      * Set the value of the vw_ano.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setVwAnoCdEmpresa(short newValue) throws DataStoreException {
          setShort(VW_ANO_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the vw_ano.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setVwAnoCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,VW_ANO_CD_EMPRESA, newValue);
     }

     /**
      * Retrieve the value of the vw_ano.fg_sel column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getVwAnoFgSel() throws DataStoreException {
          return  getString(VW_ANO_FG_SEL);
     }

     /**
      * Retrieve the value of the vw_ano.fg_sel column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getVwAnoFgSel(int row) throws DataStoreException {
          return  getString(row,VW_ANO_FG_SEL);
     }

     /**
      * Set the value of the vw_ano.fg_sel column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setVwAnoFgSel(String newValue) throws DataStoreException {
          setString(VW_ANO_FG_SEL, newValue);
     }

     /**
      * Set the value of the vw_ano.fg_sel column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setVwAnoFgSel(int row,String newValue) throws DataStoreException {
          setString(row,VW_ANO_FG_SEL, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
