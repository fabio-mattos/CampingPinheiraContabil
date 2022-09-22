package performer.contabil.persistence;

 

 

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * java: A SOFIA generated model
 */
public class DSUsuario extends DataStore {

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//constants for columns
     public static final String EN_USUARIO_ID_USUARIO="en_usuario.id_usuario";
     public static final String EN_USUARIO_DE_SENHA="en_usuario.de_senha";
     public static final String EN_USUARIO_DT_CADASTRO="en_usuario.dt_cadastro";
     public static final String EN_USUARIO_DT_ALTERACAO="en_usuario.dt_alteracao";
     public static final String EN_USUARIO_ID_USUARIO_CAD="en_usuario.id_usuario_cad";
     public static final String EN_USUARIO_ID_USUARIO_ALT="en_usuario.id_usuario_alt";
     public static final String EN_USUARIO_NM_COMPLETO="en_usuario.nm_completo";
     public static final String EN_USUARIO_NU_FONE_FIXO="en_usuario.nu_fone_fixo";
     public static final String EN_USUARIO_NU_FONE_CELULAR="en_usuario.nu_fone_celular";
     public static final String EN_USUARIO_DE_EMAIL="en_usuario.de_email";
     public static final String EN_USUARIO_CD_PERFIL="en_usuario.cd_perfil";
     public static final String EN_USUARIO_FG_ATIVO="en_usuario.fg_ativo";
     public static final String EN_TIPO_PERFIL_NM_TIPO_PERFIL="en_tipo_perfil.nm_tipo_perfil";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new java object.
      * @param appName The SOFIA application name
      */
     public DSUsuario (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new java object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSUsuario (String appName, String profile) { 
          super(appName, profile);

          //add columns
          addColumn(computeTableName("en_usuario"),"id_usuario",DataStore.DATATYPE_STRING,true,true,EN_USUARIO_ID_USUARIO);
          addColumn(computeTableName("en_usuario"),"de_senha",DataStore.DATATYPE_STRING,false,true,EN_USUARIO_DE_SENHA);
          addColumn(computeTableName("en_usuario"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_USUARIO_DT_CADASTRO);
          addColumn(computeTableName("en_usuario"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_USUARIO_DT_ALTERACAO);
          addColumn(computeTableName("en_usuario"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true,EN_USUARIO_ID_USUARIO_CAD);
          addColumn(computeTableName("en_usuario"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_USUARIO_ID_USUARIO_ALT);
          addColumn(computeTableName("en_usuario"),"nm_completo",DataStore.DATATYPE_STRING,false,true,EN_USUARIO_NM_COMPLETO);
          addColumn(computeTableName("en_usuario"),"nu_fone_fixo",DataStore.DATATYPE_STRING,false,true,EN_USUARIO_NU_FONE_FIXO);
          addColumn(computeTableName("en_usuario"),"nu_fone_celular",DataStore.DATATYPE_STRING,false,true,EN_USUARIO_NU_FONE_CELULAR);
          addColumn(computeTableName("en_usuario"),"de_email",DataStore.DATATYPE_STRING,false,true,EN_USUARIO_DE_EMAIL);
          addColumn(computeTableName("en_usuario"),"cd_perfil",DataStore.DATATYPE_SHORT,false,true,EN_USUARIO_CD_PERFIL);
          addColumn(computeTableName("en_usuario"),"fg_ativo",DataStore.DATATYPE_SHORT,false,true,EN_USUARIO_FG_ATIVO);
          addColumn(computeTableName("en_tipo_perfil"),"nm_tipo_perfil",DataStore.DATATYPE_STRING,false,true,EN_TIPO_PERFIL_NM_TIPO_PERFIL);

          //add joins
          addJoin(computeTableAndFieldName("en_usuario.cd_perfil"),computeTableAndFieldName("en_tipo_perfil.cd_tipo_perfil"),true);

          //set order by
          setOrderBy(computeTableAndFieldName("en_usuario.id_usuario") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_usuario.id_usuario column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioIdUsuario() throws DataStoreException {
          return  getString(EN_USUARIO_ID_USUARIO);
     }

     /**
      * Retrieve the value of the en_usuario.id_usuario column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioIdUsuario(int row) throws DataStoreException {
          return  getString(row,EN_USUARIO_ID_USUARIO);
     }

     /**
      * Set the value of the en_usuario.id_usuario column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioIdUsuario(String newValue) throws DataStoreException {
          setString(EN_USUARIO_ID_USUARIO, newValue);
     }

     /**
      * Set the value of the en_usuario.id_usuario column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioIdUsuario(int row,String newValue) throws DataStoreException {
          setString(row,EN_USUARIO_ID_USUARIO, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.de_senha column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioDeSenha() throws DataStoreException {
          return  getString(EN_USUARIO_DE_SENHA);
     }

     /**
      * Retrieve the value of the en_usuario.de_senha column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioDeSenha(int row) throws DataStoreException {
          return  getString(row,EN_USUARIO_DE_SENHA);
     }

     /**
      * Set the value of the en_usuario.de_senha column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioDeSenha(String newValue) throws DataStoreException {
          setString(EN_USUARIO_DE_SENHA, newValue);
     }

     /**
      * Set the value of the en_usuario.de_senha column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioDeSenha(int row,String newValue) throws DataStoreException {
          setString(row,EN_USUARIO_DE_SENHA, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnUsuarioDtCadastro() throws DataStoreException {
          return  getDateTime(EN_USUARIO_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_usuario.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnUsuarioDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_USUARIO_DT_CADASTRO);
     }

     /**
      * Set the value of the en_usuario.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_USUARIO_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_usuario.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_USUARIO_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnUsuarioDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_USUARIO_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_usuario.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnUsuarioDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_USUARIO_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_usuario.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_USUARIO_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_usuario.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_USUARIO_DT_ALTERACAO, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.id_usuario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioIdUsuarioCad() throws DataStoreException {
          return  getString(EN_USUARIO_ID_USUARIO_CAD);
     }

     /**
      * Retrieve the value of the en_usuario.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioIdUsuarioCad(int row) throws DataStoreException {
          return  getString(row,EN_USUARIO_ID_USUARIO_CAD);
     }

     /**
      * Set the value of the en_usuario.id_usuario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioIdUsuarioCad(String newValue) throws DataStoreException {
          setString(EN_USUARIO_ID_USUARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_usuario.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioIdUsuarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_USUARIO_ID_USUARIO_CAD, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_USUARIO_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_usuario.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_USUARIO_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_usuario.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_USUARIO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_usuario.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_USUARIO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.nm_completo column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioNmCompleto() throws DataStoreException {
          return  getString(EN_USUARIO_NM_COMPLETO);
     }

     /**
      * Retrieve the value of the en_usuario.nm_completo column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioNmCompleto(int row) throws DataStoreException {
          return  getString(row,EN_USUARIO_NM_COMPLETO);
     }

     /**
      * Set the value of the en_usuario.nm_completo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioNmCompleto(String newValue) throws DataStoreException {
          setString(EN_USUARIO_NM_COMPLETO, newValue);
     }

     /**
      * Set the value of the en_usuario.nm_completo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioNmCompleto(int row,String newValue) throws DataStoreException {
          setString(row,EN_USUARIO_NM_COMPLETO, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.nu_fone_fixo column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioNuFoneFixo() throws DataStoreException {
          return  getString(EN_USUARIO_NU_FONE_FIXO);
     }

     /**
      * Retrieve the value of the en_usuario.nu_fone_fixo column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioNuFoneFixo(int row) throws DataStoreException {
          return  getString(row,EN_USUARIO_NU_FONE_FIXO);
     }

     /**
      * Set the value of the en_usuario.nu_fone_fixo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioNuFoneFixo(String newValue) throws DataStoreException {
          setString(EN_USUARIO_NU_FONE_FIXO, newValue);
     }

     /**
      * Set the value of the en_usuario.nu_fone_fixo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioNuFoneFixo(int row,String newValue) throws DataStoreException {
          setString(row,EN_USUARIO_NU_FONE_FIXO, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.nu_fone_celular column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioNuFoneCelular() throws DataStoreException {
          return  getString(EN_USUARIO_NU_FONE_CELULAR);
     }

     /**
      * Retrieve the value of the en_usuario.nu_fone_celular column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioNuFoneCelular(int row) throws DataStoreException {
          return  getString(row,EN_USUARIO_NU_FONE_CELULAR);
     }

     /**
      * Set the value of the en_usuario.nu_fone_celular column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioNuFoneCelular(String newValue) throws DataStoreException {
          setString(EN_USUARIO_NU_FONE_CELULAR, newValue);
     }

     /**
      * Set the value of the en_usuario.nu_fone_celular column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioNuFoneCelular(int row,String newValue) throws DataStoreException {
          setString(row,EN_USUARIO_NU_FONE_CELULAR, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.de_email column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioDeEmail() throws DataStoreException {
          return  getString(EN_USUARIO_DE_EMAIL);
     }

     /**
      * Retrieve the value of the en_usuario.de_email column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnUsuarioDeEmail(int row) throws DataStoreException {
          return  getString(row,EN_USUARIO_DE_EMAIL);
     }

     /**
      * Set the value of the en_usuario.de_email column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioDeEmail(String newValue) throws DataStoreException {
          setString(EN_USUARIO_DE_EMAIL, newValue);
     }

     /**
      * Set the value of the en_usuario.de_email column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioDeEmail(int row,String newValue) throws DataStoreException {
          setString(row,EN_USUARIO_DE_EMAIL, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.cd_perfil column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnUsuarioCdPerfil() throws DataStoreException {
          return  getShort(EN_USUARIO_CD_PERFIL);
     }

     /**
      * Retrieve the value of the en_usuario.cd_perfil column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnUsuarioCdPerfil(int row) throws DataStoreException {
          return  getShort(row,EN_USUARIO_CD_PERFIL);
     }

     /**
      * Set the value of the en_usuario.cd_perfil column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioCdPerfil(short newValue) throws DataStoreException {
          setShort(EN_USUARIO_CD_PERFIL, newValue);
     }

     /**
      * Set the value of the en_usuario.cd_perfil column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioCdPerfil(int row,short newValue) throws DataStoreException {
          setShort(row,EN_USUARIO_CD_PERFIL, newValue);
     }

     /**
      * Retrieve the value of the en_usuario.fg_ativo column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnUsuarioFgAtivo() throws DataStoreException {
          return  getShort(EN_USUARIO_FG_ATIVO);
     }

     /**
      * Retrieve the value of the en_usuario.fg_ativo column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnUsuarioFgAtivo(int row) throws DataStoreException {
          return  getShort(row,EN_USUARIO_FG_ATIVO);
     }

     /**
      * Set the value of the en_usuario.fg_ativo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioFgAtivo(short newValue) throws DataStoreException {
          setShort(EN_USUARIO_FG_ATIVO, newValue);
     }

     /**
      * Set the value of the en_usuario.fg_ativo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnUsuarioFgAtivo(int row,short newValue) throws DataStoreException {
          setShort(row,EN_USUARIO_FG_ATIVO, newValue);
     }

    

     /**
      * Retrieve the value of the en_tipo_perfil.nm_tipo_perfil column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoPerfilNmTipoPerfil() throws DataStoreException {
          return  getString(EN_TIPO_PERFIL_NM_TIPO_PERFIL);
     }

     /**
      * Retrieve the value of the en_tipo_perfil.nm_tipo_perfil column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoPerfilNmTipoPerfil(int row) throws DataStoreException {
          return  getString(row,EN_TIPO_PERFIL_NM_TIPO_PERFIL);
     }

     /**
      * Set the value of the en_tipo_perfil.nm_tipo_perfil column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoPerfilNmTipoPerfil(String newValue) throws DataStoreException {
          setString(EN_TIPO_PERFIL_NM_TIPO_PERFIL, newValue);
     }

     /**
      * Set the value of the en_tipo_perfil.nm_tipo_perfil column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoPerfilNmTipoPerfil(int row,String newValue) throws DataStoreException {
          setString(row,EN_TIPO_PERFIL_NM_TIPO_PERFIL, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
