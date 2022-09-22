package performer.contabil.persistence;

 
import java.sql.Timestamp;

import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;

 //$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMIMPORTS$

/**
* java: A SOFIA generated model
*/
public class DSModulo  extends DataStore {
/**
 * 
 */
private static final long serialVersionUID = 1L;
//constants for columns

public static final  String  en_modulo_cd_modulo="en_modulo.cd_modulo";
public static final  String  en_modulo_dt_alteracao="en_modulo.dt_alteracao";
public static final  String  en_modulo_dt_cadastro="en_modulo.dt_cadastro";
public static final  String  en_modulo_id_usuario_alt="en_modulo.id_usuario_alt";
public static final  String  en_modulo_id_usuario_cad="en_modulo.id_usuario_cad";
public static final  String  en_modulo_nm_modulo="en_modulo.nm_modulo";
public static final  String  en_modulo_sq_lista="en_modulo.sq_lista";


//$CUSTOMVARS$
//Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMVARS$

   /**
    * Create a new java object.
    * @param appName The SOFIA application name
    */
   public  DSModulo   (String appName) {
        this(appName, null);
   }

/**
* Create a new java object.
* @param appName The SOFIA application name
* @param profile The database profile to use
*/
public DSModulo   (String appName, String profile) {
super(appName, profile);

//add aliases
addTableAlias(computeTableName("en_modulo"),null);

//add columns
addColumn(computeTableName("en_modulo"),"cd_modulo",DataStore.DATATYPE_INT,true,true ,en_modulo_cd_modulo);
addColumn(computeTableName("en_modulo"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true ,en_modulo_dt_alteracao);
addColumn(computeTableName("en_modulo"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true ,en_modulo_dt_cadastro);
addColumn(computeTableName("en_modulo"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true ,en_modulo_id_usuario_alt);
addColumn(computeTableName("en_modulo"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true ,en_modulo_id_usuario_cad);
addColumn(computeTableName("en_modulo"),"nm_modulo",DataStore.DATATYPE_STRING,false,true ,en_modulo_nm_modulo);
addColumn(computeTableName("en_modulo"),"sq_lista",DataStore.DATATYPE_INT,false,true ,en_modulo_sq_lista);

//set order by
setOrderBy(computeTableAndFieldName("en_modulo.nm_modulo") + "  asc ");


//add joins



//$CUSTOMCONSTRUCTOR$
//Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated
//$ENDCUSTOMCONSTRUCTOR$

}

/**
* Retrieve the value of the EN_MODULO.cd_modulo column for the current row.
* @return Int
* @throws DataStoreException
*/
public int geten_modulocd_modulo() throws DataStoreException {
     return  getInt(en_modulo_cd_modulo);
}

/**
* Retrieve the value of the en_modulo_cd_modulo column for the specified row.
* @param row which row in the table
* @return Int
* @throws DataStoreException
*/
public int geten_modulo_cd_modulo(int row) throws DataStoreException {
     return  getInt(row,en_modulo_cd_modulo);
}

/**
* Set the value of the en_modulo_cd_modulo column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulo_cd_modulo(int newValue) throws DataStoreException {
setInt(en_modulo_cd_modulo, newValue);
}

/**
* Set the value of the en_modulo_cd_modulo  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulocd_modulo(int row,int newValue) throws DataStoreException {
    setInt (row,en_modulo_cd_modulo, newValue);
}

/**
* Retrieve the value of the EN_MODULO.dt_alteracao column for the current row.
* @return DateTime
* @throws DataStoreException
*/
public Timestamp geten_modulodt_alteracao() throws DataStoreException {
     return  getDateTime(en_modulo_dt_alteracao);
}

/**
* Retrieve the value of the en_modulo_dt_alteracao column for the specified row.
* @param row which row in the table
* @return DateTime
* @throws DataStoreException
*/
public Timestamp geten_modulo_dt_alteracao(int row) throws DataStoreException {
     return  getDateTime(row,en_modulo_dt_alteracao);
}

/**
* Set the value of the en_modulo_dt_alteracao column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulo_dt_alteracao(Timestamp newValue) throws DataStoreException {
setDateTime(en_modulo_dt_alteracao, newValue);
}

/**
* Set the value of the en_modulo_dt_alteracao  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulodt_alteracao(int row,Timestamp newValue) throws DataStoreException {
    setDateTime (row,en_modulo_dt_alteracao, newValue);
}

/**
* Retrieve the value of the EN_MODULO.dt_cadastro column for the current row.
* @return DateTime
* @throws DataStoreException
*/
public Timestamp geten_modulodt_cadastro() throws DataStoreException {
     return  getDateTime(en_modulo_dt_cadastro);
}

/**
* Retrieve the value of the en_modulo_dt_cadastro column for the specified row.
* @param row which row in the table
* @return DateTime
* @throws DataStoreException
*/
public Timestamp geten_modulo_dt_cadastro(int row) throws DataStoreException {
     return  getDateTime(row,en_modulo_dt_cadastro);
}

/**
* Set the value of the en_modulo_dt_cadastro column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulo_dt_cadastro(Timestamp newValue) throws DataStoreException {
setDateTime(en_modulo_dt_cadastro, newValue);
}

/**
* Set the value of the en_modulo_dt_cadastro  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulodt_cadastro(int row,Timestamp newValue) throws DataStoreException {
    setDateTime (row,en_modulo_dt_cadastro, newValue);
}

/**
* Retrieve the value of the EN_MODULO.id_usuario_alt column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_moduloid_usuario_alt() throws DataStoreException {
     return  getString(en_modulo_id_usuario_alt);
}

/**
* Retrieve the value of the en_modulo_id_usuario_alt column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_modulo_id_usuario_alt(int row) throws DataStoreException {
     return  getString(row,en_modulo_id_usuario_alt);
}

/**
* Set the value of the en_modulo_id_usuario_alt column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulo_id_usuario_alt(String newValue) throws DataStoreException {
setString(en_modulo_id_usuario_alt, newValue);
}

/**
* Set the value of the en_modulo_id_usuario_alt  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_moduloid_usuario_alt(int row,String newValue) throws DataStoreException {
    setString (row,en_modulo_id_usuario_alt, newValue);
}

/**
* Retrieve the value of the EN_MODULO.id_usuario_cad column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_moduloid_usuario_cad() throws DataStoreException {
     return  getString(en_modulo_id_usuario_cad);
}

/**
* Retrieve the value of the en_modulo_id_usuario_cad column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_modulo_id_usuario_cad(int row) throws DataStoreException {
     return  getString(row,en_modulo_id_usuario_cad);
}

/**
* Set the value of the en_modulo_id_usuario_cad column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulo_id_usuario_cad(String newValue) throws DataStoreException {
setString(en_modulo_id_usuario_cad, newValue);
}

/**
* Set the value of the en_modulo_id_usuario_cad  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_moduloid_usuario_cad(int row,String newValue) throws DataStoreException {
    setString (row,en_modulo_id_usuario_cad, newValue);
}

/**
* Retrieve the value of the EN_MODULO.nm_modulo column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_modulonm_modulo() throws DataStoreException {
     return  getString(en_modulo_nm_modulo);
}

/**
* Retrieve the value of the en_modulo_nm_modulo column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_modulo_nm_modulo(int row) throws DataStoreException {
     return  getString(row,en_modulo_nm_modulo);
}

/**
* Set the value of the en_modulo_nm_modulo column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulo_nm_modulo(String newValue) throws DataStoreException {
setString(en_modulo_nm_modulo, newValue);
}

/**
* Set the value of the en_modulo_nm_modulo  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulonm_modulo(int row,String newValue) throws DataStoreException {
    setString (row,en_modulo_nm_modulo, newValue);
}

/**
* Retrieve the value of the EN_MODULO.sq_lista column for the current row.
* @return Int
* @throws DataStoreException
*/
public int geten_modulosq_lista() throws DataStoreException {
     return  getInt(en_modulo_sq_lista);
}

/**
* Retrieve the value of the en_modulo_sq_lista column for the specified row.
* @param row which row in the table
* @return Int
* @throws DataStoreException
*/
public int geten_modulo_sq_lista(int row) throws DataStoreException {
     return  getInt(row,en_modulo_sq_lista);
}

/**
* Set the value of the en_modulo_sq_lista column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulo_sq_lista(int newValue) throws DataStoreException {
setInt(en_modulo_sq_lista, newValue);
}

/**
* Set the value of the en_modulo_sq_lista  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_modulosq_lista(int row,int newValue) throws DataStoreException {
    setInt (row,en_modulo_sq_lista, newValue);
}

//$CUSTOMMETHODS$
//Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMMETHODS$

}
