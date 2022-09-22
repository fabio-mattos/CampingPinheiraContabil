package performer.contabil.persistence;

 
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

 //$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMIMPORTS$

/**
* java: A SOFIA generated model
*/
public class DSTipoPerfil  extends DataStore {
/**
 * 
 */
private static final long serialVersionUID = 1L;
//constants for columns

public static final  String  en_tipo_perfil_cd_string="en_tipo_perfil.cd_string";
public static final  String  en_tipo_perfil_cd_tipo_perfil="en_tipo_perfil.cd_tipo_perfil";
public static final  String  en_tipo_perfil_nm_tipo_perfil="en_tipo_perfil.nm_tipo_perfil";


//$CUSTOMVARS$
//Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMVARS$

   /**
    * Create a new java object.
    * @param appName The SOFIA application name
    */
   public  DSTipoPerfil   (String appName) {
        this(appName, null);
   }

/**
* Create a new java object.
* @param appName The SOFIA application name
* @param profile The database profile to use
*/
public DSTipoPerfil   (String appName, String profile) {
super(appName, profile);

//add aliases
addTableAlias(computeTableName("en_tipo_perfil"),null);

//add columns
addColumn(computeTableName("en_tipo_perfil"),"cd_string",DataStore.DATATYPE_STRING,false,true ,en_tipo_perfil_cd_string);
addColumn(computeTableName("en_tipo_perfil"),"cd_tipo_perfil",DataStore.DATATYPE_SHORT,true,true ,en_tipo_perfil_cd_tipo_perfil);
addColumn(computeTableName("en_tipo_perfil"),"nm_tipo_perfil",DataStore.DATATYPE_STRING,false,true ,en_tipo_perfil_nm_tipo_perfil);

//set order by
setOrderBy(computeTableAndFieldName("en_tipo_perfil.nm_tipo_perfil") + "  asc ");


//add joins



//$CUSTOMCONSTRUCTOR$
//Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated
//$ENDCUSTOMCONSTRUCTOR$

}

/**
* Retrieve the value of the EN_TIPO_PERFIL.cd_string column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_tipo_perfilcd_string() throws DataStoreException {
     return  getString(en_tipo_perfil_cd_string);
}

/**
* Retrieve the value of the en_tipo_perfil_cd_string column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_tipo_perfil_cd_string(int row) throws DataStoreException {
     return  getString(row,en_tipo_perfil_cd_string);
}

/**
* Set the value of the en_tipo_perfil_cd_string column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_tipo_perfil_cd_string(String newValue) throws DataStoreException {
setString(en_tipo_perfil_cd_string, newValue);
}

/**
* Set the value of the en_tipo_perfil_cd_string  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_tipo_perfilcd_string(int row,String newValue) throws DataStoreException {
    setString (row,en_tipo_perfil_cd_string, newValue);
}

/**
* Retrieve the value of the EN_TIPO_PERFIL.cd_tipo_perfil column for the current row.
* @return Short
* @throws DataStoreException
*/
public Short geten_tipo_perfilcd_tipo_perfil() throws DataStoreException {
     return  getShort(en_tipo_perfil_cd_tipo_perfil);
}

/**
* Retrieve the value of the en_tipo_perfil_cd_tipo_perfil column for the specified row.
* @param row which row in the table
* @return Short
* @throws DataStoreException
*/
public Short geten_tipo_perfil_cd_tipo_perfil(int row) throws DataStoreException {
     return  getShort(row,en_tipo_perfil_cd_tipo_perfil);
}

/**
* Set the value of the en_tipo_perfil_cd_tipo_perfil column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_tipo_perfil_cd_tipo_perfil(Short newValue) throws DataStoreException {
setShort(en_tipo_perfil_cd_tipo_perfil, newValue);
}

/**
* Set the value of the en_tipo_perfil_cd_tipo_perfil  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_tipo_perfilcd_tipo_perfil(int row,Short newValue) throws DataStoreException {
    setShort (row,en_tipo_perfil_cd_tipo_perfil, newValue);
}

/**
* Retrieve the value of the EN_TIPO_PERFIL.nm_tipo_perfil column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_tipo_perfilnm_tipo_perfil() throws DataStoreException {
     return  getString(en_tipo_perfil_nm_tipo_perfil);
}

/**
* Retrieve the value of the en_tipo_perfil_nm_tipo_perfil column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_tipo_perfil_nm_tipo_perfil(int row) throws DataStoreException {
     return  getString(row,en_tipo_perfil_nm_tipo_perfil);
}

/**
* Set the value of the en_tipo_perfil_nm_tipo_perfil column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_tipo_perfil_nm_tipo_perfil(String newValue) throws DataStoreException {
setString(en_tipo_perfil_nm_tipo_perfil, newValue);
}

/**
* Set the value of the en_tipo_perfil_nm_tipo_perfil  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_tipo_perfilnm_tipo_perfil(int row,String newValue) throws DataStoreException {
    setString (row,en_tipo_perfil_nm_tipo_perfil, newValue);
}

//$CUSTOMMETHODS$
//Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMMETHODS$

}
