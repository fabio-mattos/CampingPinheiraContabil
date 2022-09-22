package performer.contabil.persistence;



import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * java: A SOFIA generated model
 */
public class Teste extends DataStore {

     //constants for columns
     public static final String PUBLIC_EN_MES_NU_MES="public.en_mes.nu_mes";
     public static final String PUBLIC_EN_MES_NM_MES="public.en_mes.nm_mes";
     public static final String PUBLIC_EN_MES_SG_MES="public.en_mes.sg_mes";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new java object.
      * @param appName The SOFIA application name
      */
     public Teste (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new java object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public Teste (String appName, String profile) { 
          super(appName, profile);

          //add columns
          addColumn(computeTableName("public.en_mes"),"nu_mes",DataStore.DATATYPE_SHORT,false,true,PUBLIC_EN_MES_NU_MES);
          addColumn(computeTableName("public.en_mes"),"nm_mes",DataStore.DATATYPE_STRING,false,true,PUBLIC_EN_MES_NM_MES);
          addColumn(computeTableName("public.en_mes"),"sg_mes",DataStore.DATATYPE_STRING,false,true,PUBLIC_EN_MES_SG_MES);

          //set order by
          setOrderBy(computeTableAndFieldName("public.en_mes.nm_mes") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the public.en_mes.nu_mes column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getPublicEnMesNuMes() throws DataStoreException {
          return  getShort(PUBLIC_EN_MES_NU_MES);
     }

     /**
      * Retrieve the value of the public.en_mes.nu_mes column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getPublicEnMesNuMes(int row) throws DataStoreException {
          return  getShort(row,PUBLIC_EN_MES_NU_MES);
     }

     /**
      * Set the value of the public.en_mes.nu_mes column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setPublicEnMesNuMes(short newValue) throws DataStoreException {
          setShort(PUBLIC_EN_MES_NU_MES, newValue);
     }

     /**
      * Set the value of the public.en_mes.nu_mes column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setPublicEnMesNuMes(int row,short newValue) throws DataStoreException {
          setShort(row,PUBLIC_EN_MES_NU_MES, newValue);
     }

     /**
      * Retrieve the value of the public.en_mes.nm_mes column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getPublicEnMesNmMes() throws DataStoreException {
          return  getString(PUBLIC_EN_MES_NM_MES);
     }

     /**
      * Retrieve the value of the public.en_mes.nm_mes column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getPublicEnMesNmMes(int row) throws DataStoreException {
          return  getString(row,PUBLIC_EN_MES_NM_MES);
     }

     /**
      * Set the value of the public.en_mes.nm_mes column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setPublicEnMesNmMes(String newValue) throws DataStoreException {
          setString(PUBLIC_EN_MES_NM_MES, newValue);
     }

     /**
      * Set the value of the public.en_mes.nm_mes column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setPublicEnMesNmMes(int row,String newValue) throws DataStoreException {
          setString(row,PUBLIC_EN_MES_NM_MES, newValue);
     }

     /**
      * Retrieve the value of the public.en_mes.sg_mes column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getPublicEnMesSgMes() throws DataStoreException {
          return  getString(PUBLIC_EN_MES_SG_MES);
     }

     /**
      * Retrieve the value of the public.en_mes.sg_mes column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getPublicEnMesSgMes(int row) throws DataStoreException {
          return  getString(row,PUBLIC_EN_MES_SG_MES);
     }

     /**
      * Set the value of the public.en_mes.sg_mes column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setPublicEnMesSgMes(String newValue) throws DataStoreException {
          setString(PUBLIC_EN_MES_SG_MES, newValue);
     }

     /**
      * Set the value of the public.en_mes.sg_mes column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setPublicEnMesSgMes(int row,String newValue) throws DataStoreException {
          setString(row,PUBLIC_EN_MES_SG_MES, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
