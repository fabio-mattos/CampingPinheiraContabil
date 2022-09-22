package performer.contabil.persistence;

 
import com.salmonllc.sql.*;
import java.sql.Timestamp;
import com.salmonllc.sql.DataStore; 
 import com.salmonllc.sql.DataStoreException;

 //$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMIMPORTS$

/**
* java: A SOFIA generated model
*/
public class DSPerfilUsuario  extends DataStore {
/**
 * 
 */
private static final long serialVersionUID = 1L;
//constants for columns

public static final  String  en_perfil_cd_item_modulo="en_perfil.cd_item_modulo";
public static final  String  en_perfil_dt_alteracao="en_perfil.dt_alteracao";
public static final  String  en_perfil_dt_cadastro="en_perfil.dt_cadastro";
public static final  String  en_perfil_fg_acesso="en_perfil.fg_acesso";
public static final  String  en_perfil_id_usuario_alt="en_perfil.id_usuario_alt";
public static final  String  en_perfil_id_usuario_cad="en_perfil.id_usuario_cad";
public static final  String  en_perfil_id_usuario="en_perfil.id_usuario";
public static final  String  vw_item_modulo_cd_item_modulo="vw_item_modulo.cd_item_modulo";
public static final  String  vw_item_modulo_cd_item_modulo_modulo="vw_item_modulo.cd_item_modulo_modulo";
public static final  String  vw_item_modulo_cd_modulo="vw_item_modulo.cd_modulo";
public static final  String  vw_item_modulo_cd_tipo="vw_item_modulo.cd_tipo";
public static final  String  vw_item_modulo_item="vw_item_modulo.item";
public static final  String  vw_item_modulo_nm_modulo="vw_item_modulo.nm_modulo";
public static final  String  vw_item_modulo_sq_lista="vw_item_modulo.sq_lista";


//$CUSTOMVARS$
//Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMVARS$

   /**
    * Create a new java object.
    * @param appName The SOFIA application name
    */
   public  DSPerfilUsuario   (String appName) {
        this(appName, null);
   }

/**
* Create a new java object.
* @param appName The SOFIA application name
* @param profile The database profile to use
*/
public DSPerfilUsuario   (String appName, String profile) {
super(appName, profile);

//add aliases
addTableAlias(computeTableName("en_perfil"),null);
addTableAlias(computeTableName("vw_item_modulo"),null);

//add columns
addColumn(computeTableName("en_perfil"),"id_usuario",DataStore.DATATYPE_STRING,true,true ,en_perfil_id_usuario);
addColumn(computeTableName("en_perfil"),"cd_item_modulo",DataStore.DATATYPE_INT,true,true ,en_perfil_cd_item_modulo);
addColumn(computeTableName("en_perfil"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true ,en_perfil_dt_alteracao);
addColumn(computeTableName("en_perfil"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true ,en_perfil_dt_cadastro);
addColumn(computeTableName("en_perfil"),"fg_acesso",DataStore.DATATYPE_SHORT,false,true ,en_perfil_fg_acesso);
addColumn(computeTableName("en_perfil"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true ,en_perfil_id_usuario_alt);
addColumn(computeTableName("en_perfil"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true ,en_perfil_id_usuario_cad);
addColumn(computeTableName("vw_item_modulo"),"cd_item_modulo",DataStore.DATATYPE_INT,false,true ,vw_item_modulo_cd_item_modulo);
addColumn(computeTableName("vw_item_modulo"),"cd_item_modulo_modulo",DataStore.DATATYPE_INT,false,true ,vw_item_modulo_cd_item_modulo_modulo);
addColumn(computeTableName("vw_item_modulo"),"cd_modulo",DataStore.DATATYPE_INT,false,true ,vw_item_modulo_cd_modulo);
addColumn(computeTableName("vw_item_modulo"),"cd_tipo",DataStore.DATATYPE_SHORT,false,true ,vw_item_modulo_cd_tipo);
addColumn(computeTableName("vw_item_modulo"),"item",DataStore.DATATYPE_STRING,false,true ,vw_item_modulo_item);
addColumn(computeTableName("vw_item_modulo"),"nm_modulo",DataStore.DATATYPE_STRING,false,true ,vw_item_modulo_nm_modulo);
addColumn(computeTableName("vw_item_modulo"),"sq_lista",DataStore.DATATYPE_INT,false,true ,vw_item_modulo_sq_lista);

//set order by
setOrderBy(computeTableAndFieldName("vw_item_modulo.sq_lista") + ", " + computeTableAndFieldName("vw_item_modulo.item")   );






//add joins
addJoin(computeTableAndFieldName("en_perfil.cd_item_modulo ") ,computeTableAndFieldName("vw_item_modulo.cd_item_modulo "),false);



//$CUSTOMCONSTRUCTOR$
//Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated
//$ENDCUSTOMCONSTRUCTOR$

}

/**
* Retrieve the value of the EN_PERFIL.cd_item_modulo column for the current row.
* @return Int
* @throws DataStoreException
*/
public int geten_perfilcd_item_modulo() throws DataStoreException {
     return  getInt(en_perfil_cd_item_modulo);
}

/**
* Retrieve the value of the en_perfil_cd_item_modulo column for the specified row.
* @param row which row in the table
* @return Int
* @throws DataStoreException
*/
public int geten_perfil_cd_item_modulo(int row) throws DataStoreException {
     return  getInt(row,en_perfil_cd_item_modulo);
}

/**
* Set the value of the en_perfil_cd_item_modulo column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfil_cd_item_modulo(int newValue) throws DataStoreException {
setInt(en_perfil_cd_item_modulo, newValue);
}

/**
* Set the value of the en_perfil_cd_item_modulo  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfilcd_item_modulo(int row,int newValue) throws DataStoreException {
    setInt (row,en_perfil_cd_item_modulo, newValue);
}

/**
* Retrieve the value of the EN_PERFIL.dt_alteracao column for the current row.
* @return DateTime
* @throws DataStoreException
*/
public Timestamp geten_perfildt_alteracao() throws DataStoreException {
     return  getDateTime(en_perfil_dt_alteracao);
}

/**
* Retrieve the value of the en_perfil_dt_alteracao column for the specified row.
* @param row which row in the table
* @return DateTime
* @throws DataStoreException
*/
public Timestamp geten_perfil_dt_alteracao(int row) throws DataStoreException {
     return  getDateTime(row,en_perfil_dt_alteracao);
}

/**
* Set the value of the en_perfil_dt_alteracao column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfil_dt_alteracao(Timestamp newValue) throws DataStoreException {
setDateTime(en_perfil_dt_alteracao, newValue);
}

/**
* Set the value of the en_perfil_dt_alteracao  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfildt_alteracao(int row,Timestamp newValue) throws DataStoreException {
    setDateTime (row,en_perfil_dt_alteracao, newValue);
}

/**
* Retrieve the value of the EN_PERFIL.dt_cadastro column for the current row.
* @return DateTime
* @throws DataStoreException
*/
public Timestamp geten_perfildt_cadastro() throws DataStoreException {
     return  getDateTime(en_perfil_dt_cadastro);
}

/**
* Retrieve the value of the en_perfil_dt_cadastro column for the specified row.
* @param row which row in the table
* @return DateTime
* @throws DataStoreException
*/
public Timestamp geten_perfil_dt_cadastro(int row) throws DataStoreException {
     return  getDateTime(row,en_perfil_dt_cadastro);
}

/**
* Set the value of the en_perfil_dt_cadastro column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfil_dt_cadastro(Timestamp newValue) throws DataStoreException {
setDateTime(en_perfil_dt_cadastro, newValue);
}

/**
* Set the value of the en_perfil_dt_cadastro  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfildt_cadastro(int row,Timestamp newValue) throws DataStoreException {
    setDateTime (row,en_perfil_dt_cadastro, newValue);
}

/**
* Retrieve the value of the EN_PERFIL.fg_acesso column for the current row.
* @return Short
* @throws DataStoreException
*/
public Short geten_perfilfg_acesso() throws DataStoreException {
     return  getShort(en_perfil_fg_acesso);
}

/**
* Retrieve the value of the en_perfil_fg_acesso column for the specified row.
* @param row which row in the table
* @return Short
* @throws DataStoreException
*/
public Short geten_perfil_fg_acesso(int row) throws DataStoreException {
     return  getShort(row,en_perfil_fg_acesso);
}

/**
* Set the value of the en_perfil_fg_acesso column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfil_fg_acesso(Short newValue) throws DataStoreException {
setShort(en_perfil_fg_acesso, newValue);
}

/**
* Set the value of the en_perfil_fg_acesso  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfilfg_acesso(int row,Short newValue) throws DataStoreException {
    setShort (row,en_perfil_fg_acesso, newValue);
}

/**
* Retrieve the value of the EN_PERFIL.id_usuario_alt column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_perfilid_usuario_alt() throws DataStoreException {
     return  getString(en_perfil_id_usuario_alt);
}

/**
* Retrieve the value of the en_perfil_id_usuario_alt column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_perfil_id_usuario_alt(int row) throws DataStoreException {
     return  getString(row,en_perfil_id_usuario_alt);
}

/**
* Set the value of the en_perfil_id_usuario_alt column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfil_id_usuario_alt(String newValue) throws DataStoreException {
setString(en_perfil_id_usuario_alt, newValue);
}

/**
* Set the value of the en_perfil_id_usuario_alt  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfilid_usuario_alt(int row,String newValue) throws DataStoreException {
    setString (row,en_perfil_id_usuario_alt, newValue);
}

/**
* Retrieve the value of the EN_PERFIL.id_usuario_cad column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_perfilid_usuario_cad() throws DataStoreException {
     return  getString(en_perfil_id_usuario_cad);
}

/**
* Retrieve the value of the en_perfil_id_usuario_cad column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_perfil_id_usuario_cad(int row) throws DataStoreException {
     return  getString(row,en_perfil_id_usuario_cad);
}

/**
* Set the value of the en_perfil_id_usuario_cad column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfil_id_usuario_cad(String newValue) throws DataStoreException {
setString(en_perfil_id_usuario_cad, newValue);
}

/**
* Set the value of the en_perfil_id_usuario_cad  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfilid_usuario_cad(int row,String newValue) throws DataStoreException {
    setString (row,en_perfil_id_usuario_cad, newValue);
}

/**
* Retrieve the value of the EN_PERFIL.id_usuario column for the current row.
* @return String
* @throws DataStoreException
*/
public String geten_perfilid_usuario() throws DataStoreException {
     return  getString(en_perfil_id_usuario);
}

/**
* Retrieve the value of the en_perfil_id_usuario column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String geten_perfil_id_usuario(int row) throws DataStoreException {
     return  getString(row,en_perfil_id_usuario);
}

/**
* Set the value of the en_perfil_id_usuario column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfil_id_usuario(String newValue) throws DataStoreException {
setString(en_perfil_id_usuario, newValue);
}

/**
* Set the value of the en_perfil_id_usuario  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void seten_perfilid_usuario(int row,String newValue) throws DataStoreException {
    setString (row,en_perfil_id_usuario, newValue);
}

/**
* Retrieve the value of the VW_ITEM_MODULO.cd_item_modulo column for the current row.
* @return Int
* @throws DataStoreException
*/
public int getvw_item_modulocd_item_modulo() throws DataStoreException {
     return  getInt(vw_item_modulo_cd_item_modulo);
}

/**
* Retrieve the value of the vw_item_modulo_cd_item_modulo column for the specified row.
* @param row which row in the table
* @return Int
* @throws DataStoreException
*/
public int getvw_item_modulo_cd_item_modulo(int row) throws DataStoreException {
     return  getInt(row,vw_item_modulo_cd_item_modulo);
}

/**
* Set the value of the vw_item_modulo_cd_item_modulo column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulo_cd_item_modulo(int newValue) throws DataStoreException {
setInt(vw_item_modulo_cd_item_modulo, newValue);
}

/**
* Set the value of the vw_item_modulo_cd_item_modulo  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulocd_item_modulo(int row,int newValue) throws DataStoreException {
    setInt (row,vw_item_modulo_cd_item_modulo, newValue);
}

/**
* Retrieve the value of the VW_ITEM_MODULO.cd_item_modulo_modulo column for the current row.
* @return Int
* @throws DataStoreException
*/
public int getvw_item_modulocd_item_modulo_modulo() throws DataStoreException {
     return  getInt(vw_item_modulo_cd_item_modulo_modulo);
}

/**
* Retrieve the value of the vw_item_modulo_cd_item_modulo_modulo column for the specified row.
* @param row which row in the table
* @return Int
* @throws DataStoreException
*/
public int getvw_item_modulo_cd_item_modulo_modulo(int row) throws DataStoreException {
     return  getInt(row,vw_item_modulo_cd_item_modulo_modulo);
}

/**
* Set the value of the vw_item_modulo_cd_item_modulo_modulo column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulo_cd_item_modulo_modulo(int newValue) throws DataStoreException {
setInt(vw_item_modulo_cd_item_modulo_modulo, newValue);
}

/**
* Set the value of the vw_item_modulo_cd_item_modulo_modulo  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulocd_item_modulo_modulo(int row,int newValue) throws DataStoreException {
    setInt (row,vw_item_modulo_cd_item_modulo_modulo, newValue);
}

/**
* Retrieve the value of the VW_ITEM_MODULO.cd_modulo column for the current row.
* @return Int
* @throws DataStoreException
*/
public int getvw_item_modulocd_modulo() throws DataStoreException {
     return  getInt(vw_item_modulo_cd_modulo);
}

/**
* Retrieve the value of the vw_item_modulo_cd_modulo column for the specified row.
* @param row which row in the table
* @return Int
* @throws DataStoreException
*/
public int getvw_item_modulo_cd_modulo(int row) throws DataStoreException {
     return  getInt(row,vw_item_modulo_cd_modulo);
}

/**
* Set the value of the vw_item_modulo_cd_modulo column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulo_cd_modulo(int newValue) throws DataStoreException {
setInt(vw_item_modulo_cd_modulo, newValue);
}

/**
* Set the value of the vw_item_modulo_cd_modulo  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulocd_modulo(int row,int newValue) throws DataStoreException {
    setInt (row,vw_item_modulo_cd_modulo, newValue);
}

/**
* Retrieve the value of the VW_ITEM_MODULO.cd_tipo column for the current row.
* @return Short
* @throws DataStoreException
*/
public Short getvw_item_modulocd_tipo() throws DataStoreException {
     return  getShort(vw_item_modulo_cd_tipo);
}

/**
* Retrieve the value of the vw_item_modulo_cd_tipo column for the specified row.
* @param row which row in the table
* @return Short
* @throws DataStoreException
*/
public Short getvw_item_modulo_cd_tipo(int row) throws DataStoreException {
     return  getShort(row,vw_item_modulo_cd_tipo);
}

/**
* Set the value of the vw_item_modulo_cd_tipo column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulo_cd_tipo(Short newValue) throws DataStoreException {
setShort(vw_item_modulo_cd_tipo, newValue);
}

/**
* Set the value of the vw_item_modulo_cd_tipo  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulocd_tipo(int row,Short newValue) throws DataStoreException {
    setShort (row,vw_item_modulo_cd_tipo, newValue);
}

/**
* Retrieve the value of the VW_ITEM_MODULO.item column for the current row.
* @return String
* @throws DataStoreException
*/
public String getvw_item_moduloitem() throws DataStoreException {
     return  getString(vw_item_modulo_item);
}

/**
* Retrieve the value of the vw_item_modulo_item column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String getvw_item_modulo_item(int row) throws DataStoreException {
     return  getString(row,vw_item_modulo_item);
}

/**
* Set the value of the vw_item_modulo_item column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulo_item(String newValue) throws DataStoreException {
setString(vw_item_modulo_item, newValue);
}

/**
* Set the value of the vw_item_modulo_item  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_moduloitem(int row,String newValue) throws DataStoreException {
    setString (row,vw_item_modulo_item, newValue);
}

/**
* Retrieve the value of the VW_ITEM_MODULO.nm_modulo column for the current row.
* @return String
* @throws DataStoreException
*/
public String getvw_item_modulonm_modulo() throws DataStoreException {
     return  getString(vw_item_modulo_nm_modulo);
}

/**
* Retrieve the value of the vw_item_modulo_nm_modulo column for the specified row.
* @param row which row in the table
* @return String
* @throws DataStoreException
*/
public String getvw_item_modulo_nm_modulo(int row) throws DataStoreException {
     return  getString(row,vw_item_modulo_nm_modulo);
}

/**
* Set the value of the vw_item_modulo_nm_modulo column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulo_nm_modulo(String newValue) throws DataStoreException {
setString(vw_item_modulo_nm_modulo, newValue);
}

/**
* Set the value of the vw_item_modulo_nm_modulo  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulonm_modulo(int row,String newValue) throws DataStoreException {
    setString (row,vw_item_modulo_nm_modulo, newValue);
}

/**
* Retrieve the value of the VW_ITEM_MODULO.sq_lista column for the current row.
* @return Int
* @throws DataStoreException
*/
public int getvw_item_modulosq_lista() throws DataStoreException {
     return  getInt(vw_item_modulo_sq_lista);
}

/**
* Retrieve the value of the vw_item_modulo_sq_lista column for the specified row.
* @param row which row in the table
* @return Int
* @throws DataStoreException
*/
public int getvw_item_modulo_sq_lista(int row) throws DataStoreException {
     return  getInt(row,vw_item_modulo_sq_lista);
}

/**
* Set the value of the vw_item_modulo_sq_lista column for the current row.
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulo_sq_lista(int newValue) throws DataStoreException {
setInt(vw_item_modulo_sq_lista, newValue);
}

/**
* Set the value of the vw_item_modulo_sq_lista  column for the specified row. 
* @param row which row in the table
* @param newValue the new item value
* @throws DataStoreException
*/
public void setvw_item_modulosq_lista(int row,int newValue) throws DataStoreException {
    setInt (row,vw_item_modulo_sq_lista, newValue);
}

//$CUSTOMMETHODS$
//Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
//$ENDCUSTOMMETHODS$

}
