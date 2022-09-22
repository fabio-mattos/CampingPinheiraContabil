package performer.contabil.persistence;

 
import com.salmonllc.sql.*;

 //$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMIMPORTS$

/**
* java: A SOFIA generated model
*/
public class DSMes  extends DataStore {
/**
 * 
 */
private static final long serialVersionUID = 1L;
//constants for columns

public static final  String  en_mes_nm_mes="en_mes.nm_mes";
public static final  String  en_mes_nu_mes="en_mes.nu_mes";


//$CUSTOMVARS$
//Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMVARS$

   /**
    * Create a new java object.
    * @param appName The SOFIA application name
    */
   public  DSMes   (String appName) {
        this(appName, null);
   }

/**
* Create a new java object.
* @param appName The SOFIA application name
* @param profile The database profile to use
*/
public DSMes   (String appName, String profile) {
super(appName, profile);

//add aliases
addTableAlias(computeTableName("en_mes"),null);

//add columns
addColumn(computeTableName("en_mes"),"nm_mes",DataStore.DATATYPE_STRING,false,true ,en_mes_nm_mes);
addColumn(computeTableName("en_mes"),"nu_mes",DataStore.DATATYPE_SHORT,true,true ,en_mes_nu_mes);

//set order by
setOrderBy(computeTableAndFieldName("en_mes.nu_mes") + "  asc ");


//add joins



//$CUSTOMCONSTRUCTOR$
//Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated
//$ENDCUSTOMCONSTRUCTOR$

}

/**
* Retrieve the value of the EN_MES.nm_mes column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_mesnm_mes() throws DataStoreException {
     return  getString(en_mes_nm_mes);
}

/**
* Retrieve the value of the en_mes_nm_mes column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_mes_nm_mes(int row) throws DataStoreException {
     return  getString(row,en_mes_nm_mes);
}

/**
* Set the value of the en_mes_nm_mes column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_mes_nm_mes(String newValue) throws DataStoreException {
setString(en_mes_nm_mes, newValue);
}

/**
* Set the value of the en_mes_nm_mes  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_mesnm_mes(int row,String newValue) throws DataStoreException {
    setString (row,en_mes_nm_mes, newValue);
}

/**
* Retrieve the value of the EN_MES.nu_mes column for the current row.
* @return Short
* @throws DataStoreException
*/
public Short geten_mesnu_mes() throws DataStoreException {
     return  getShort(en_mes_nu_mes);
}


public Short geten_mesnu_mes(int row) throws DataStoreException {
    return  getShort(row,en_mes_nu_mes);
}



/**
* Retrieve the value of the en_mes_nu_mes column for the specified row.
* @param row which row in the table
* @return Short
* @throws DataStoreException
*/
public Short geten_mes_nu_mes(int row) throws DataStoreException {
     return  getShort(row,en_mes_nu_mes);
}

/**
* Set the value of the en_mes_nu_mes column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_mes_nu_mes(Short newValue) throws DataStoreException {
setShort(en_mes_nu_mes, newValue);
}

/**
* Set the value of the en_mes_nu_mes  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_mesnu_mes(int row,Short newValue) throws DataStoreException {
    setShort (row,en_mes_nu_mes, newValue);
}

//$CUSTOMMETHODS$
//Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMMETHODS$

}
