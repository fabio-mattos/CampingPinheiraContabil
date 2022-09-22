package performer.contabil.persistence;

import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSBoleto: A SOFIA generated model
 */
public class DSBoleto extends DataStore {

     //constants for columns
     public static final String EN_BOLETO_CD_BOLETO="en_boleto.cd_boleto";
     public static final String EN_BOLETO_ID_USUARIO_CAD="en_boleto.id_usuario_cad";
     public static final String EN_BOLETO_ID_USUARIO_ALT="en_boleto.id_usuario_alt";
     public static final String EN_BOLETO_DT_CADASTRO="en_boleto.dt_cadastro";
     public static final String EN_BOLETO_DT_ALTERACAO="en_boleto.dt_alteracao";
     public static final String EN_BOLETO_CD_EMPRESA="en_boleto.cd_empresa";
     public static final String EN_BOLETO_VL_BOLETO="en_boleto.vl_boleto";
     public static final String EN_BOLETO_DT_VENCIMENTO="en_boleto.dt_vencimento";
     public static final String EN_BOLETO_FG_PAGAMENTO_AGENDADO="en_boleto.fg_pagamento_agendado";
     public static final String EN_BOLETO_NU_DOCUMENTO="en_boleto.nu_documento";
     public static final String EN_EMPRESA_NM_EMPRESA="en_empresa.nm_empresa";
     public static final String EN_BOLETO_NU_ANO="en_boleto.nu_ano";
     public static final String EN_FORNECEDOR_NM_FORNECEDOR="en_fornecedor.nm_fornecedor";
     public static final String EN_BOLETO_NU_CNPJ_CPF_FORNECEDOR="en_boleto.nu_cnpj_cpf_fornecedor";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSBoleto object.
      * @param appName The SOFIA application name
      */
     public DSBoleto (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSBoleto object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSBoleto (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_boleto"),null);
          addTableAlias(computeTableName("en_empresa"),null);

          //add columns
          addColumn(computeTableName("en_boleto"),"cd_boleto",DataStore.DATATYPE_INT,false,true,EN_BOLETO_CD_BOLETO);
          addColumn(computeTableName("en_boleto"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true,EN_BOLETO_ID_USUARIO_CAD);
          addColumn(computeTableName("en_boleto"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_BOLETO_ID_USUARIO_ALT);
          addColumn(computeTableName("en_boleto"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_BOLETO_DT_CADASTRO);
          addColumn(computeTableName("en_boleto"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_BOLETO_DT_ALTERACAO);
          addColumn(computeTableName("en_boleto"),"cd_empresa",DataStore.DATATYPE_INT,false,true,EN_BOLETO_CD_EMPRESA);
          addColumn(computeTableName("en_boleto"),"vl_boleto",DataStore.DATATYPE_DOUBLE,false,true,EN_BOLETO_VL_BOLETO);
          addColumn(computeTableName("en_boleto"),"dt_vencimento",DataStore.DATATYPE_DATETIME,false,true,EN_BOLETO_DT_VENCIMENTO);
          addColumn(computeTableName("en_boleto"),"fg_pagamento_agendado",DataStore.DATATYPE_STRING,false,true,EN_BOLETO_FG_PAGAMENTO_AGENDADO);
          addColumn(computeTableName("en_boleto"),"nu_documento",DataStore.DATATYPE_STRING,false,true,EN_BOLETO_NU_DOCUMENTO);
          addColumn(computeTableName("en_empresa"),"nm_empresa",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_NM_EMPRESA);
          addColumn(computeTableName("en_boleto"),"nu_ano",DataStore.DATATYPE_SHORT,false,true,EN_BOLETO_NU_ANO);
          addColumn(computeTableName("en_fornecedor"),"nm_fornecedor",DataStore.DATATYPE_STRING,false,true,EN_FORNECEDOR_NM_FORNECEDOR);
          addColumn(computeTableName("en_boleto"),"nu_cnpj_cpf_fornecedor",DataStore.DATATYPE_STRING,false,true,EN_BOLETO_NU_CNPJ_CPF_FORNECEDOR);

          //add joins
          addJoin(computeTableAndFieldName("en_boleto.cd_empresa"),computeTableAndFieldName("en_empresa.cd_empresa"),false);
          addJoin(computeTableAndFieldName("en_boleto.nu_cnpj_cpf_fornecedor"),computeTableAndFieldName("en_fornecedor.nu_cnpj_cpf"),false);

          //set order by
          setOrderBy(computeTableAndFieldName("en_boleto.dt_vencimento") + " DESC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_boleto.cd_boleto column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnBoletoCdBoleto() throws DataStoreException {
          return  getInt(EN_BOLETO_CD_BOLETO);
     }

     /**
      * Retrieve the value of the en_boleto.cd_boleto column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnBoletoCdBoleto(int row) throws DataStoreException {
          return  getInt(row,EN_BOLETO_CD_BOLETO);
     }

     /**
      * Set the value of the en_boleto.cd_boleto column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoCdBoleto(int newValue) throws DataStoreException {
          setInt(EN_BOLETO_CD_BOLETO, newValue);
     }

     /**
      * Set the value of the en_boleto.cd_boleto column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoCdBoleto(int row,int newValue) throws DataStoreException {
          setInt(row,EN_BOLETO_CD_BOLETO, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.id_usuario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoIdUsuarioCad() throws DataStoreException {
          return  getString(EN_BOLETO_ID_USUARIO_CAD);
     }

     /**
      * Retrieve the value of the en_boleto.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoIdUsuarioCad(int row) throws DataStoreException {
          return  getString(row,EN_BOLETO_ID_USUARIO_CAD);
     }

     /**
      * Set the value of the en_boleto.id_usuario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoIdUsuarioCad(String newValue) throws DataStoreException {
          setString(EN_BOLETO_ID_USUARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_boleto.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoIdUsuarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_BOLETO_ID_USUARIO_CAD, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_BOLETO_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_boleto.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_BOLETO_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_boleto.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_BOLETO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_boleto.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_BOLETO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnBoletoDtCadastro() throws DataStoreException {
          return  getDateTime(EN_BOLETO_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_boleto.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnBoletoDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_BOLETO_DT_CADASTRO);
     }

     /**
      * Set the value of the en_boleto.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_BOLETO_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_boleto.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_BOLETO_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnBoletoDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_BOLETO_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_boleto.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnBoletoDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_BOLETO_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_boleto.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_BOLETO_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_boleto.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_BOLETO_DT_ALTERACAO, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.cd_empresa column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnBoletoCdEmpresa() throws DataStoreException {
          return  getInt(EN_BOLETO_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_boleto.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnBoletoCdEmpresa(int row) throws DataStoreException {
          return  getInt(row,EN_BOLETO_CD_EMPRESA);
     }

     /**
      * Set the value of the en_boleto.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoCdEmpresa(int newValue) throws DataStoreException {
          setInt(EN_BOLETO_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_boleto.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoCdEmpresa(int row,int newValue) throws DataStoreException {
          setInt(row,EN_BOLETO_CD_EMPRESA, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.vl_boleto column for the current row.
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnBoletoVlBoleto() throws DataStoreException {
          return  getDouble(EN_BOLETO_VL_BOLETO);
     }

     /**
      * Retrieve the value of the en_boleto.vl_boleto column for the specified row.
      * @param row which row in the table
      * @return double
      * @throws DataStoreException
      */ 
     public double getEnBoletoVlBoleto(int row) throws DataStoreException {
          return  getDouble(row,EN_BOLETO_VL_BOLETO);
     }

     /**
      * Set the value of the en_boleto.vl_boleto column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoVlBoleto(double newValue) throws DataStoreException {
          setDouble(EN_BOLETO_VL_BOLETO, newValue);
     }

     /**
      * Set the value of the en_boleto.vl_boleto column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoVlBoleto(int row,double newValue) throws DataStoreException {
          setDouble(row,EN_BOLETO_VL_BOLETO, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.dt_vencimento column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnBoletoDtVencimento() throws DataStoreException {
          return  getDateTime(EN_BOLETO_DT_VENCIMENTO);
     }

     /**
      * Retrieve the value of the en_boleto.dt_vencimento column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnBoletoDtVencimento(int row) throws DataStoreException {
          return  getDateTime(row,EN_BOLETO_DT_VENCIMENTO);
     }

     /**
      * Set the value of the en_boleto.dt_vencimento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoDtVencimento(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_BOLETO_DT_VENCIMENTO, newValue);
     }

     /**
      * Set the value of the en_boleto.dt_vencimento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoDtVencimento(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_BOLETO_DT_VENCIMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.fg_pagamento_agendado column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoFgPagamentoAgendado() throws DataStoreException {
          return  getString(EN_BOLETO_FG_PAGAMENTO_AGENDADO);
     }

     /**
      * Retrieve the value of the en_boleto.fg_pagamento_agendado column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoFgPagamentoAgendado(int row) throws DataStoreException {
          return  getString(row,EN_BOLETO_FG_PAGAMENTO_AGENDADO);
     }

     /**
      * Set the value of the en_boleto.fg_pagamento_agendado column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoFgPagamentoAgendado(String newValue) throws DataStoreException {
          setString(EN_BOLETO_FG_PAGAMENTO_AGENDADO, newValue);
     }

     /**
      * Set the value of the en_boleto.fg_pagamento_agendado column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoFgPagamentoAgendado(int row,String newValue) throws DataStoreException {
          setString(row,EN_BOLETO_FG_PAGAMENTO_AGENDADO, newValue);
     }

     /**
      * Retrieve the value of the en_boleto.nu_documento column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoNuDocumento() throws DataStoreException {
          return  getString(EN_BOLETO_NU_DOCUMENTO);
     }

     /**
      * Retrieve the value of the en_boleto.nu_documento column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoNuDocumento(int row) throws DataStoreException {
          return  getString(row,EN_BOLETO_NU_DOCUMENTO);
     }

     /**
      * Set the value of the en_boleto.nu_documento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoNuDocumento(String newValue) throws DataStoreException {
          setString(EN_BOLETO_NU_DOCUMENTO, newValue);
     }

     /**
      * Set the value of the en_boleto.nu_documento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoNuDocumento(int row,String newValue) throws DataStoreException {
          setString(row,EN_BOLETO_NU_DOCUMENTO, newValue);
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
      * Retrieve the value of the en_boleto.nu_ano column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnBoletoNuAno() throws DataStoreException {
          return  getShort(EN_BOLETO_NU_ANO);
     }

     /**
      * Retrieve the value of the en_boleto.nu_ano column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnBoletoNuAno(int row) throws DataStoreException {
          return  getShort(row,EN_BOLETO_NU_ANO);
     }

     /**
      * Set the value of the en_boleto.nu_ano column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoNuAno(short newValue) throws DataStoreException {
          setShort(EN_BOLETO_NU_ANO, newValue);
     }

     /**
      * Set the value of the en_boleto.nu_ano column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoNuAno(int row,short newValue) throws DataStoreException {
          setShort(row,EN_BOLETO_NU_ANO, newValue);
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
      * Retrieve the value of the en_boleto.nu_cnpj_cpf_fornecedor column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoNuCnpjCpfFornecedor() throws DataStoreException {
          return  getString(EN_BOLETO_NU_CNPJ_CPF_FORNECEDOR);
     }

     /**
      * Retrieve the value of the en_boleto.nu_cnpj_cpf_fornecedor column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnBoletoNuCnpjCpfFornecedor(int row) throws DataStoreException {
          return  getString(row,EN_BOLETO_NU_CNPJ_CPF_FORNECEDOR);
     }

     /**
      * Set the value of the en_boleto.nu_cnpj_cpf_fornecedor column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoNuCnpjCpfFornecedor(String newValue) throws DataStoreException {
          setString(EN_BOLETO_NU_CNPJ_CPF_FORNECEDOR, newValue);
     }

     /**
      * Set the value of the en_boleto.nu_cnpj_cpf_fornecedor column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnBoletoNuCnpjCpfFornecedor(int row,String newValue) throws DataStoreException {
          setString(row,EN_BOLETO_NU_CNPJ_CPF_FORNECEDOR, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
