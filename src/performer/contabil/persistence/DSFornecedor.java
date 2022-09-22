package performer.contabil.persistence;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSFornecedor: A SOFIA generated model
 */
public class DSFornecedor extends DataStore {

     //constants for columns
     public static final String EN_FORNECEDOR_NU_CNPJ_CPF="en_fornecedor.nu_cnpj_cpf";
     public static final String EN_FORNECEDOR_NM_FORNECEDOR="en_fornecedor.nm_fornecedor";
     public static final String EN_FORNECEDOR_NM_MUNICIO="en_fornecedor.nm_municio";
     public static final String EN_FORNECEDOR_CD_UF="en_fornecedor.cd_uf";
     public static final String EN_FORNECEDOR_DE_EMAIL="en_fornecedor.de_email";
     public static final String EN_FORNECEDOR_NU_FONES="en_fornecedor.nu_fones";
     public static final String EN_FORNECEDOR_DE_ENDERECO="en_fornecedor.de_endereco";
     public static final String EN_FORNECEDOR_NM_BAIRRO="en_fornecedor.nm_bairro";
     public static final String EN_FORNECEDOR_ID_USUARIO_CAD="en_fornecedor.id_usuario_cad";
     public static final String EN_FORNECEDOR_ID_USUARIO_ALT="en_fornecedor.id_usuario_alt";
     public static final String EN_FORNECEDOR_DT_CADASTRO="en_fornecedor.dt_cadastro";
     public static final String EN_FORNECEDOR_DT_ALTERACAO="en_fornecedor.dt_alteracao";
     public static final String EN_FORNECEDOR_NU_ENDERECO="en_fornecedor.nu_endereco";
     public static final String EN_FORNECEDOR_NU_CEP="en_fornecedor.nu_cep";
     public static final String EN_FORNECEDOR_CD_MUNICIPIO="en_fornecedor.cd_municipio";
     public static final String EN_EMPRESA_NM_EMPRESA="en_empresa.nm_empresa";
     public static final String EN_FORNECEDOR_CD_EMPRESA="en_fornecedor.cd_empresa";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSFornecedor object.
      * @param appName The SOFIA application name
      */
     public DSFornecedor (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSFornecedor object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSFornecedor (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_fornecedor"),null);

          //add columns
          addColumn(computeTableName("en_fornecedor"),"nu_cnpj_cpf",DataStore.DATATYPE_STRING,true,true,EN_FORNECEDOR_NU_CNPJ_CPF);
          addColumn(computeTableName("en_fornecedor"),"nm_fornecedor",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_NM_FORNECEDOR);
          addColumn(computeTableName("en_fornecedor"),"nm_municio",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_NM_MUNICIO);
          addColumn(computeTableName("en_fornecedor"),"cd_uf",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_CD_UF);
          addColumn(computeTableName("en_fornecedor"),"de_email",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_DE_EMAIL);
          addColumn(computeTableName("en_fornecedor"),"nu_fones",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_NU_FONES);
          addColumn(computeTableName("en_fornecedor"),"de_endereco",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_DE_ENDERECO);
          addColumn(computeTableName("en_fornecedor"),"nm_bairro",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_NM_BAIRRO);
          addColumn(computeTableName("en_fornecedor"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_ID_USUARIO_CAD);
          addColumn(computeTableName("en_fornecedor"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_ID_USUARIO_ALT);
          addColumn(computeTableName("en_fornecedor"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_FORNECEDOR_DT_CADASTRO);
          addColumn(computeTableName("en_fornecedor"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_FORNECEDOR_DT_ALTERACAO);
          addColumn(computeTableName("en_fornecedor"),"nu_endereco",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_NU_ENDERECO);
          addColumn(computeTableName("en_fornecedor"),"nu_cep",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_NU_CEP);
          addColumn(computeTableName("en_fornecedor"),"cd_municipio",DataStore.DATATYPE_INT,false,true,EN_FORNECEDOR_CD_MUNICIPIO);
          addColumn(computeTableName("en_empresa"),"nm_empresa",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_NM_EMPRESA);
          addColumn(computeTableName("en_fornecedor"),"cd_empresa",DataStore.DATATYPE_SHORT,false,true,EN_FORNECEDOR_CD_EMPRESA);

          //add joins
          addJoin(computeTableAndFieldName("en_fornecedor.cd_empresa"),computeTableAndFieldName("en_empresa.cd_empresa"),false);

          //set order by
          setOrderBy(computeTableAndFieldName("en_fornecedor.nm_fornecedor") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_fornecedor.nu_cnpj_cpf column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNuCnpjCpf() throws DataStoreException {
          return  getString(EN_FORNECEDOR_NU_CNPJ_CPF);
     }

     /**
      * Retrieve the value of the en_fornecedor.nu_cnpj_cpf column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNuCnpjCpf(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_NU_CNPJ_CPF);
     }

     /**
      * Set the value of the en_fornecedor.nu_cnpj_cpf column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNuCnpjCpf(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_NU_CNPJ_CPF, newValue);
     }

     /**
      * Set the value of the en_fornecedor.nu_cnpj_cpf column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNuCnpjCpf(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_NU_CNPJ_CPF, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.nm_fornecedor column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNmFornecedor() throws DataStoreException {
          return  getString(EN_FORNECEDOR_NM_FORNECEDOR);
     }

     /**
      * Retrieve the value of the en_fornecedor.nm_fornecedor column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNmFornecedor(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_NM_FORNECEDOR);
     }

     /**
      * Set the value of the en_fornecedor.nm_fornecedor column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNmFornecedor(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_NM_FORNECEDOR, newValue);
     }

     /**
      * Set the value of the en_fornecedor.nm_fornecedor column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNmFornecedor(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_NM_FORNECEDOR, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.nm_municio column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNmMunicio() throws DataStoreException {
          return  getString(EN_FORNECEDOR_NM_MUNICIO);
     }

     /**
      * Retrieve the value of the en_fornecedor.nm_municio column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNmMunicio(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_NM_MUNICIO);
     }

     /**
      * Set the value of the en_fornecedor.nm_municio column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNmMunicio(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_NM_MUNICIO, newValue);
     }

     /**
      * Set the value of the en_fornecedor.nm_municio column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNmMunicio(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_NM_MUNICIO, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.cd_uf column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorCdUf() throws DataStoreException {
          return  getString(EN_FORNECEDOR_CD_UF);
     }

     /**
      * Retrieve the value of the en_fornecedor.cd_uf column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorCdUf(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_CD_UF);
     }

     /**
      * Set the value of the en_fornecedor.cd_uf column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorCdUf(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_CD_UF, newValue);
     }

     /**
      * Set the value of the en_fornecedor.cd_uf column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorCdUf(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_CD_UF, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.de_email column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorDeEmail() throws DataStoreException {
          return  getString(EN_FORNECEDOR_DE_EMAIL);
     }

     /**
      * Retrieve the value of the en_fornecedor.de_email column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorDeEmail(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_DE_EMAIL);
     }

     /**
      * Set the value of the en_fornecedor.de_email column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorDeEmail(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_DE_EMAIL, newValue);
     }

     /**
      * Set the value of the en_fornecedor.de_email column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorDeEmail(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_DE_EMAIL, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.nu_fones column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNuFones() throws DataStoreException {
          return  getString(EN_FORNECEDOR_NU_FONES);
     }

     /**
      * Retrieve the value of the en_fornecedor.nu_fones column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNuFones(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_NU_FONES);
     }

     /**
      * Set the value of the en_fornecedor.nu_fones column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNuFones(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_NU_FONES, newValue);
     }

     /**
      * Set the value of the en_fornecedor.nu_fones column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNuFones(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_NU_FONES, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.de_endereco column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorDeEndereco() throws DataStoreException {
          return  getString(EN_FORNECEDOR_DE_ENDERECO);
     }

     /**
      * Retrieve the value of the en_fornecedor.de_endereco column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorDeEndereco(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_DE_ENDERECO);
     }

     /**
      * Set the value of the en_fornecedor.de_endereco column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorDeEndereco(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_DE_ENDERECO, newValue);
     }

     /**
      * Set the value of the en_fornecedor.de_endereco column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorDeEndereco(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_DE_ENDERECO, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.nm_bairro column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNmBairro() throws DataStoreException {
          return  getString(EN_FORNECEDOR_NM_BAIRRO);
     }

     /**
      * Retrieve the value of the en_fornecedor.nm_bairro column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNmBairro(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_NM_BAIRRO);
     }

     /**
      * Set the value of the en_fornecedor.nm_bairro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNmBairro(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_NM_BAIRRO, newValue);
     }

     /**
      * Set the value of the en_fornecedor.nm_bairro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNmBairro(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_NM_BAIRRO, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.id_usuario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorIdUsuarioCad() throws DataStoreException {
          return  getString(EN_FORNECEDOR_ID_USUARIO_CAD);
     }

     /**
      * Retrieve the value of the en_fornecedor.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorIdUsuarioCad(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_ID_USUARIO_CAD);
     }

     /**
      * Set the value of the en_fornecedor.id_usuario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorIdUsuarioCad(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_ID_USUARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_fornecedor.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorIdUsuarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_ID_USUARIO_CAD, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_FORNECEDOR_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_fornecedor.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_fornecedor.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_fornecedor.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFornecedorDtCadastro() throws DataStoreException {
          return  getDateTime(EN_FORNECEDOR_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_fornecedor.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFornecedorDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_FORNECEDOR_DT_CADASTRO);
     }

     /**
      * Set the value of the en_fornecedor.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_FORNECEDOR_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_fornecedor.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_FORNECEDOR_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFornecedorDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_FORNECEDOR_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_fornecedor.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnFornecedorDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_FORNECEDOR_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_fornecedor.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_FORNECEDOR_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_fornecedor.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_FORNECEDOR_DT_ALTERACAO, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.nu_endereco column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNuEndereco() throws DataStoreException {
          return  getString(EN_FORNECEDOR_NU_ENDERECO);
     }

     /**
      * Retrieve the value of the en_fornecedor.nu_endereco column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNuEndereco(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_NU_ENDERECO);
     }

     /**
      * Set the value of the en_fornecedor.nu_endereco column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNuEndereco(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_NU_ENDERECO, newValue);
     }

     /**
      * Set the value of the en_fornecedor.nu_endereco column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNuEndereco(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_NU_ENDERECO, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.nu_cep column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNuCep() throws DataStoreException {
          return  getString(EN_FORNECEDOR_NU_CEP);
     }

     /**
      * Retrieve the value of the en_fornecedor.nu_cep column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnFornecedorNuCep(int row) throws DataStoreException {
          return  getString(row,EN_FORNECEDOR_NU_CEP);
     }

     /**
      * Set the value of the en_fornecedor.nu_cep column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNuCep(String newValue) throws DataStoreException {
          setString(EN_FORNECEDOR_NU_CEP, newValue);
     }

     /**
      * Set the value of the en_fornecedor.nu_cep column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorNuCep(int row,String newValue) throws DataStoreException {
          setString(row,EN_FORNECEDOR_NU_CEP, newValue);
     }

     /**
      * Retrieve the value of the en_fornecedor.cd_municipio column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnFornecedorCdMunicipio() throws DataStoreException {
          return  getInt(EN_FORNECEDOR_CD_MUNICIPIO);
     }

     /**
      * Retrieve the value of the en_fornecedor.cd_municipio column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnFornecedorCdMunicipio(int row) throws DataStoreException {
          return  getInt(row,EN_FORNECEDOR_CD_MUNICIPIO);
     }

     /**
      * Set the value of the en_fornecedor.cd_municipio column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorCdMunicipio(int newValue) throws DataStoreException {
          setInt(EN_FORNECEDOR_CD_MUNICIPIO, newValue);
     }

     /**
      * Set the value of the en_fornecedor.cd_municipio column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorCdMunicipio(int row,int newValue) throws DataStoreException {
          setInt(row,EN_FORNECEDOR_CD_MUNICIPIO, newValue);
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
      * Retrieve the value of the en_fornecedor.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFornecedorCdEmpresa() throws DataStoreException {
          return  getShort(EN_FORNECEDOR_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_fornecedor.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnFornecedorCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,EN_FORNECEDOR_CD_EMPRESA);
     }

     /**
      * Set the value of the en_fornecedor.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorCdEmpresa(short newValue) throws DataStoreException {
          setShort(EN_FORNECEDOR_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_fornecedor.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnFornecedorCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,EN_FORNECEDOR_CD_EMPRESA, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
