package performer.contabil.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.salmonllc.sql.DBConnection;
import com.salmonllc.sql.DataStore;
import com.salmonllc.sql.DataStoreException;
import com.salmonllc.util.MessageLog;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * DSHistoricoLancamento: A SOFIA generated model
 */
public class DSHistoricoLancamento extends DataStore {

     //constants for columns
     public static final String EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO="en_historico_lancamento.cd_historico_lancamento";
     public static final String EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO="en_historico_lancamento.nm_historico_lancamento";
     public static final String EN_HISTORICO_LANCAMENTO_DT_CADASTRO="en_historico_lancamento.dt_cadastro";
     public static final String EN_HISTORICO_LANCAMENTO_DT_ALTERACAO="en_historico_lancamento.dt_alteracao";
     public static final String EN_HISTORICO_LANCAMENTO_ID_USUARIO_CAD="en_historico_lancamento.id_usuario_cad";
     public static final String EN_HISTORICO_LANCAMENTO_ID_USUARIO_ALT="en_historico_lancamento.id_usuario_alt";
     public static final String EN_HISTORICO_LANCAMENTO_FG_ATIVO="en_historico_lancamento.fg_ativo";
     public static final String EN_EMPRESA_DE_SIGLA="en_empresa.de_sigla";
     public static final String EN_HISTORICO_LANCAMENTO_CD_EMPRESA="en_historico_lancamento.cd_empresa";
     public static final String EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO="en_tipo_lancamento.nm_tipo_lancamento";
     public static final String EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO="en_historico_lancamento.cd_tipo_lancamento";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     private int _Codigo = -1;
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new DSHistoricoLancamento object.
      * @param appName The SOFIA application name
      */
     public DSHistoricoLancamento (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new DSHistoricoLancamento object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSHistoricoLancamento (String appName, String profile) { 
          super(appName, profile);

          //add aliases
          addTableAlias(computeTableName("en_historico_lancamento"),null);
          addTableAlias(computeTableName("en_empresa"),null);
          addTableAlias(computeTableName("en_tipo_lancamento"),null);

          //add columns
          addColumn(computeTableName("en_historico_lancamento"),"cd_historico_lancamento",DataStore.DATATYPE_INT,true,true,EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO);
          addColumn(computeTableName("en_historico_lancamento"),"nm_historico_lancamento",DataStore.DATATYPE_STRING,false,true,EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
          addColumn(computeTableName("en_historico_lancamento"),"dt_cadastro",DataStore.DATATYPE_DATETIME,false,true,EN_HISTORICO_LANCAMENTO_DT_CADASTRO);
          addColumn(computeTableName("en_historico_lancamento"),"dt_alteracao",DataStore.DATATYPE_DATETIME,false,true,EN_HISTORICO_LANCAMENTO_DT_ALTERACAO);
          addColumn(computeTableName("en_historico_lancamento"),"id_usuario_cad",DataStore.DATATYPE_STRING,false,true,EN_HISTORICO_LANCAMENTO_ID_USUARIO_CAD);
          addColumn(computeTableName("en_historico_lancamento"),"id_usuario_alt",DataStore.DATATYPE_STRING,false,true,EN_HISTORICO_LANCAMENTO_ID_USUARIO_ALT);
          addColumn(computeTableName("en_historico_lancamento"),"fg_ativo",DataStore.DATATYPE_STRING,false,true,EN_HISTORICO_LANCAMENTO_FG_ATIVO);
          addColumn(computeTableName("en_empresa"),"de_sigla",DataStore.DATATYPE_STRING,false,true,EN_EMPRESA_DE_SIGLA);
          addColumn(computeTableName("en_historico_lancamento"),"cd_empresa",DataStore.DATATYPE_SHORT,false,true,EN_HISTORICO_LANCAMENTO_CD_EMPRESA);
          addColumn(computeTableName("en_tipo_lancamento"),"nm_tipo_lancamento",DataStore.DATATYPE_STRING,false,true,EN_TIPO_LANCAMENTO_NM_TIPO_LANCAMENTO);
          addColumn(computeTableName("en_historico_lancamento"),"cd_tipo_lancamento",DataStore.DATATYPE_SHORT,false,true,EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO);

          //add joins
          addJoin(computeTableAndFieldName("en_historico_lancamento.cd_empresa"),computeTableAndFieldName("en_empresa.cd_empresa"),false);
          addJoin(computeTableAndFieldName("en_historico_lancamento.cd_tipo_lancamento"),computeTableAndFieldName("en_tipo_lancamento.cd_tipo_lancamento"),true);

          //set order by
          setOrderBy(computeTableAndFieldName("en_historico_lancamento.nm_historico_lancamento") + " ASC");

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_historico_lancamento.cd_historico_lancamento column for the current row.
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnHistoricoLancamentoCdHistoricoLancamento() throws DataStoreException {
          return  getInt(EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.cd_historico_lancamento column for the specified row.
      * @param row which row in the table
      * @return int
      * @throws DataStoreException
      */ 
     public int getEnHistoricoLancamentoCdHistoricoLancamento(int row) throws DataStoreException {
          return  getInt(row,EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO);
     }

     /**
      * Set the value of the en_historico_lancamento.cd_historico_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoCdHistoricoLancamento(int newValue) throws DataStoreException {
          setInt(EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.cd_historico_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoCdHistoricoLancamento(int row,int newValue) throws DataStoreException {
          setInt(row,EN_HISTORICO_LANCAMENTO_CD_HISTORICO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.nm_historico_lancamento column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoNmHistoricoLancamento() throws DataStoreException {
          return  getString(EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.nm_historico_lancamento column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoNmHistoricoLancamento(int row) throws DataStoreException {
          return  getString(row,EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO);
     }

     /**
      * Set the value of the en_historico_lancamento.nm_historico_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoNmHistoricoLancamento(String newValue) throws DataStoreException {
          setString(EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.nm_historico_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoNmHistoricoLancamento(int row,String newValue) throws DataStoreException {
          setString(row,EN_HISTORICO_LANCAMENTO_NM_HISTORICO_LANCAMENTO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.dt_cadastro column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnHistoricoLancamentoDtCadastro() throws DataStoreException {
          return  getDateTime(EN_HISTORICO_LANCAMENTO_DT_CADASTRO);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnHistoricoLancamentoDtCadastro(int row) throws DataStoreException {
          return  getDateTime(row,EN_HISTORICO_LANCAMENTO_DT_CADASTRO);
     }

     /**
      * Set the value of the en_historico_lancamento.dt_cadastro column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoDtCadastro(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_HISTORICO_LANCAMENTO_DT_CADASTRO, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.dt_cadastro column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoDtCadastro(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_HISTORICO_LANCAMENTO_DT_CADASTRO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.dt_alteracao column for the current row.
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnHistoricoLancamentoDtAlteracao() throws DataStoreException {
          return  getDateTime(EN_HISTORICO_LANCAMENTO_DT_ALTERACAO);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @return java.sql.Timestamp
      * @throws DataStoreException
      */ 
     public java.sql.Timestamp getEnHistoricoLancamentoDtAlteracao(int row) throws DataStoreException {
          return  getDateTime(row,EN_HISTORICO_LANCAMENTO_DT_ALTERACAO);
     }

     /**
      * Set the value of the en_historico_lancamento.dt_alteracao column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoDtAlteracao(java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(EN_HISTORICO_LANCAMENTO_DT_ALTERACAO, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.dt_alteracao column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoDtAlteracao(int row,java.sql.Timestamp newValue) throws DataStoreException {
          setDateTime(row,EN_HISTORICO_LANCAMENTO_DT_ALTERACAO, newValue);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.id_usuario_cad column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoIdUsuarioCad() throws DataStoreException {
          return  getString(EN_HISTORICO_LANCAMENTO_ID_USUARIO_CAD);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoIdUsuarioCad(int row) throws DataStoreException {
          return  getString(row,EN_HISTORICO_LANCAMENTO_ID_USUARIO_CAD);
     }

     /**
      * Set the value of the en_historico_lancamento.id_usuario_cad column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoIdUsuarioCad(String newValue) throws DataStoreException {
          setString(EN_HISTORICO_LANCAMENTO_ID_USUARIO_CAD, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.id_usuario_cad column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoIdUsuarioCad(int row,String newValue) throws DataStoreException {
          setString(row,EN_HISTORICO_LANCAMENTO_ID_USUARIO_CAD, newValue);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.id_usuario_alt column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoIdUsuarioAlt() throws DataStoreException {
          return  getString(EN_HISTORICO_LANCAMENTO_ID_USUARIO_ALT);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoIdUsuarioAlt(int row) throws DataStoreException {
          return  getString(row,EN_HISTORICO_LANCAMENTO_ID_USUARIO_ALT);
     }

     /**
      * Set the value of the en_historico_lancamento.id_usuario_alt column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoIdUsuarioAlt(String newValue) throws DataStoreException {
          setString(EN_HISTORICO_LANCAMENTO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.id_usuario_alt column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoIdUsuarioAlt(int row,String newValue) throws DataStoreException {
          setString(row,EN_HISTORICO_LANCAMENTO_ID_USUARIO_ALT, newValue);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.fg_ativo column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoFgAtivo() throws DataStoreException {
          return  getString(EN_HISTORICO_LANCAMENTO_FG_ATIVO);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.fg_ativo column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnHistoricoLancamentoFgAtivo(int row) throws DataStoreException {
          return  getString(row,EN_HISTORICO_LANCAMENTO_FG_ATIVO);
     }

     /**
      * Set the value of the en_historico_lancamento.fg_ativo column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoFgAtivo(String newValue) throws DataStoreException {
          setString(EN_HISTORICO_LANCAMENTO_FG_ATIVO, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.fg_ativo column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoFgAtivo(int row,String newValue) throws DataStoreException {
          setString(row,EN_HISTORICO_LANCAMENTO_FG_ATIVO, newValue);
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
      * Retrieve the value of the en_historico_lancamento.cd_empresa column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoLancamentoCdEmpresa() throws DataStoreException {
          return  getShort(EN_HISTORICO_LANCAMENTO_CD_EMPRESA);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.cd_empresa column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoLancamentoCdEmpresa(int row) throws DataStoreException {
          return  getShort(row,EN_HISTORICO_LANCAMENTO_CD_EMPRESA);
     }

     /**
      * Set the value of the en_historico_lancamento.cd_empresa column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoCdEmpresa(short newValue) throws DataStoreException {
          setShort(EN_HISTORICO_LANCAMENTO_CD_EMPRESA, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.cd_empresa column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoCdEmpresa(int row,short newValue) throws DataStoreException {
          setShort(row,EN_HISTORICO_LANCAMENTO_CD_EMPRESA, newValue);
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
      * Retrieve the value of the en_historico_lancamento.cd_tipo_lancamento column for the current row.
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoLancamentoCdTipoLancamento() throws DataStoreException {
          return  getShort(EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO);
     }

     /**
      * Retrieve the value of the en_historico_lancamento.cd_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @return short
      * @throws DataStoreException
      */ 
     public short getEnHistoricoLancamentoCdTipoLancamento(int row) throws DataStoreException {
          return  getShort(row,EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO);
     }

     /**
      * Set the value of the en_historico_lancamento.cd_tipo_lancamento column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoCdTipoLancamento(short newValue) throws DataStoreException {
          setShort(EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO, newValue);
     }

     /**
      * Set the value of the en_historico_lancamento.cd_tipo_lancamento column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnHistoricoLancamentoCdTipoLancamento(int row,short newValue) throws DataStoreException {
          setShort(row,EN_HISTORICO_LANCAMENTO_CD_TIPO_LANCAMENTO, newValue);
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
    		if (getEnHistoricoLancamentoCdHistoricoLancamento()> 0)
    			return;
    		if (_Codigo != -1) {
    			setEnHistoricoLancamentoCdHistoricoLancamento((int)_Codigo++);
    			return;
    		}
    		int co = 1;
    		try {
    			String selectID = "select COALESCE(max(cd_historico_lancamento),0) from en_historico_lancamento";
    			Statement st = conn.createStatement();
    			ResultSet r = st.executeQuery(selectID);
    			if (r.next())
    				co = r.getInt(1) + 1;
    	
    			r.close();
    			st.close();
    		} catch (Exception e) {
    			MessageLog.writeErrorMessage("generateCd", e, this);
    		}
    		setEnHistoricoLancamentoCdHistoricoLancamento((int)co);
    		_Codigo = (int) (co + 1);
    	}
     
     
     
     //$ENDCUSTOMMETHODS$
     
}
