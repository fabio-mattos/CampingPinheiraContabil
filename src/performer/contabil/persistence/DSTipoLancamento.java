package performer.contabil.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.salmonllc.sql.*;
import com.salmonllc.util.MessageLog;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSTipoLancamento: A SOFIA generated model
 */
public class DSTipoLancamento extends DataStore {

     //constants for columns
     public static final String EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO="en_tipo_lancamento.cd_tipo_lancamento";
     public static final String EN_TIPO_LANCAMENTO_CD_EMPRESA="en_tipo_lancamento.cd_empresa";
     public static final String EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO="en_tipo_lancamento.nm_tipo_lancamento";
     public static final String EN_TIPO_LANCAMENTO_ID_USARIO_CAD="en_tipo_lancamento.id_usario_cad";
     public static final String EN_TIPO_LANCAMENTO_ID_USUARIO_ALT="en_tipo_lancamento.id_usuario_alt";
     public static final String EN_TIPO_LANCAMENTO_DT_CADASTRO="en_tipo_lancamento.dt_cadastro";
     public static final String EN_TIPO_LANCAMENTO_DT_ALTERACAO="en_tipo_lancamento.dt_alteracao";
     public static final String EN_EMPRESA_NM_EMPRESA="en_empresa.nm_empresa";
     public static final String EN_EMPRESA_DE_SIGLA="en_empresa.de_sigla";
     public static final String EN_TIPO_LANCAMENTO_FG_ATIVO="en_tipo_lancamento.fg_ativo";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     private short _Codigo = -1;
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSTipoLancamento object.
      * @param appName The SOFIA application name
      */
     public DSTipoLancamento (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSTipoLancamento object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSTipoLancamento (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_tipo_lancamento"),null);
          addTableAlias(computeTableName("en_empresa"),null);

          //add columns
          addColumn(computeTableName("en_tipo_lancamento"),"cd_tipo_lancamento",DataStore.DATATYPE_SHORT,true,true,EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO);
          addColumn(computeTableName("en_tipo_lancamento"),"cd_empresa",DataStore.DATATYPE_SHORT,false,true,EN_TIPO_LANCAMENTO_CD_EMPRESA);
          addColumn(computeTableName("en_tipo_lancamento"),"nm_tipo_lancamento",DataStore.DATATYPE_STRING,false,true,EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
          addColumn(computeTableName("en_tipo_lancamento"),"id_usario_cad",DataStore.DATATYPE_STRING,false,true,EN_TIPO_LANCAMENTO_ID_USARIO_CAD);
          addColumn(computeTableName("en_tipo_lancamento"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_TIPO_LANCAMENTO_ID_USUARIO_ALT);
          addColumn(computeTableName("en_tipo_lancamento"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_TIPO_LANCAMENTO_DT_CADASTRO);
          addColumn(computeTableName("en_tipo_lancamento"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_TIPO_LANCAMENTO_DT_ALTERACAO);
          addColumn(computeTableName("en_empresa"),"nm_empresa",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_NM_EMPRESA);
          addColumn(computeTableName("en_empresa"),"de_sigla",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_DE_SIGLA);
          addColumn(computeTableName("en_tipo_lancamento"),"fg_ativo",DataStore.DATATYPE_STRING,false,true,EN_TIPO_LANCAMENTO_FG_ATIVO);

          //add joins
          addJoin(computeTableAndFieldName("en_tipo_lancamento.cd_empresa"),computeTableAndFieldName("en_empresa.cd_empresa"),false);

          //set order by
          setOrderBy(computeTableAndFieldName("en_tipo_lancamento.nm_tipo_lancamento") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_tipo_lancamento.cd_tipo_lancamento column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnTipoLancamentoCdTipoLancamento() throws DataStoreException {
          return  getShort(EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.cd_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnTipoLancamentoCdTipoLancamento(int row) throws DataStoreException {
          return  getShort(row,EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO);
     }

     /**
      * Set the value of the en_tipo_lancamento.cd_tipo_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoCdTipoLancamento(short newValue) throws DataStoreException {
          setShort(EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.cd_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoCdTipoLancamento(int row,short newValue) throws DataStoreException {
          setShort(row,EN_TIPO_LANCAMENTO_CD_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnTipoLancamentoCdEmpresa() throws DataStoreException {
          return  getShort(EN_TIPO_LANCAMENTO_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnTipoLancamentoCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,EN_TIPO_LANCAMENTO_CD_EMPRESA);
     }

     /**
      * Set the value of the en_tipo_lancamento.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoCdEmpresa(short newValue) throws DataStoreException {
          setShort(EN_TIPO_LANCAMENTO_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,EN_TIPO_LANCAMENTO_CD_EMPRESA, newValue);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.nm_tipo_lancamento column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoNmTipoLancamento() throws DataStoreException {
          return  getString(EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.nm_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoNmTipoLancamento(int row) throws DataStoreException {
          return  getString(row,EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
     }

     /**
      * Set the value of the en_tipo_lancamento.nm_tipo_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoNmTipoLancamento(String newValue) throws DataStoreException {
          setString(EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.nm_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoNmTipoLancamento(int row,String newValue) throws DataStoreException {
          setString(row,EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.id_usario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoIdUsarioCad() throws DataStoreException {
          return  getString(EN_TIPO_LANCAMENTO_ID_USARIO_CAD);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.id_usario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoIdUsarioCad(int row) throws DataStoreException {
          return  getString(row,EN_TIPO_LANCAMENTO_ID_USARIO_CAD);
     }

     /**
      * Set the value of the en_tipo_lancamento.id_usario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoIdUsarioCad(String newValue) throws DataStoreException {
          setString(EN_TIPO_LANCAMENTO_ID_USARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.id_usario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoIdUsarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_TIPO_LANCAMENTO_ID_USARIO_CAD, newValue);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_TIPO_LANCAMENTO_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_TIPO_LANCAMENTO_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_tipo_lancamento.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_TIPO_LANCAMENTO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_TIPO_LANCAMENTO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnTipoLancamentoDtCadastro() throws DataStoreException {
          return  getDateTime(EN_TIPO_LANCAMENTO_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnTipoLancamentoDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_TIPO_LANCAMENTO_DT_CADASTRO);
     }

     /**
      * Set the value of the en_tipo_lancamento.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_TIPO_LANCAMENTO_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_TIPO_LANCAMENTO_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnTipoLancamentoDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_TIPO_LANCAMENTO_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnTipoLancamentoDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_TIPO_LANCAMENTO_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_tipo_lancamento.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_TIPO_LANCAMENTO_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_TIPO_LANCAMENTO_DT_ALTERACAO, newValue);
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

     /**
      * Retrieve the value of the en_tipo_lancamento.fg_ativo column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoFgAtivo() throws DataStoreException {
          return  getString(EN_TIPO_LANCAMENTO_FG_ATIVO);
     }

     /**
      * Retrieve the value of the en_tipo_lancamento.fg_ativo column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTipoLancamentoFgAtivo(int row) throws DataStoreException {
          return  getString(row,EN_TIPO_LANCAMENTO_FG_ATIVO);
     }

     /**
      * Set the value of the en_tipo_lancamento.fg_ativo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoFgAtivo(String newValue) throws DataStoreException {
          setString(EN_TIPO_LANCAMENTO_FG_ATIVO, newValue);
     }

     /**
      * Set the value of the en_tipo_lancamento.fg_ativo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTipoLancamentoFgAtivo(int row,String newValue) throws DataStoreException {
          setString(row,EN_TIPO_LANCAMENTO_FG_ATIVO, newValue);
     }
     
   //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     public void update(DBConnection conn, boolean handleTrans) throws DataStoreException, SQLException {
    		_Codigo = -1;
    		synchronized (this) {
    			for (int i = 0; i < getRowCount(); i++) {
    				if (getRowStatus(i) == STATUS_NEW_MODIFIED)
    					generateCd(conn, i);
    			}
    			super.update(conn, handleTrans);
    		}
    	 }
    	
    	private void generateCd(DBConnection conn, int row) throws DataStoreException {
    		if (getEnTipoLancamentoCdTipoLancamento()> 0)
    			return;
    		if (_Codigo != -1) {
    			setEnTipoLancamentoCdTipoLancamento((short)_Codigo++);
    			return;
    		}
    		int co = 1;
    		try {
    			String selectID = "select COALESCE(max(cd_tipo_lancamento),0) from en_tipo_lancamento";
    			Statement st = conn.createStatement();
    			ResultSet r = st.executeQuery(selectID);
    			if (r.next())
    				co = r.getInt(1) + 1;
    	
    			r.close();
    			st.close();
    		} catch (Exception e) {
    			MessageLog.writeErrorMessage("generateCd", e, this);
    		}
    		setEnTipoLancamentoCdTipoLancamento((short)co);
    		_Codigo = (short) (co + 1);
    	}
     
     
     
     //$ENDCUSTOMMETHODS$
     
}
