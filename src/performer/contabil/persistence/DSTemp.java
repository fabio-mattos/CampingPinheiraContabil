package performer.contabil.persistence;



import com.salmonllc.sql.*;

//$CUSTOMIMPORTS$
//Put custom imports between these comments, otherwise they will be overwritten if the model is regenerated

//$ENDCUSTOMIMPORTS$

/**
 * java: A SOFIA generated model
 */
public class DSTemp extends DataStore {

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//constants for columns
     public static final String EN_TEMP_TEMP1="en_temp.temp1";
     public static final String EN_TEMP_TEMP2="en_temp.temp2";

     //$CUSTOMVARS$
     //Put custom instance variables between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMVARS$
     
     /**
      * Create a new java object.
      * @param appName The SOFIA application name
      */
     public DSTemp (String appName) { 
          this(appName, null);
     }

     /**
      * Create a new java object.
      * @param appName The SOFIA application name
      * @param profile The database profile to use
      */
     public DSTemp (String appName, String profile) { 
          super(appName, profile);

          //add columns
          addColumn(computeTableName("en_temp"),"temp1",DataStore.DATATYPE_STRING,false,true,EN_TEMP_TEMP1);
          addColumn(computeTableName("en_temp"),"temp2",DataStore.DATATYPE_STRING,false,true,EN_TEMP_TEMP2);

          //$CUSTOMCONSTRUCTOR$
          //Put custom constructor code between these comments, otherwise it be overwritten if the model is regenerated

          //$ENDCUSTOMCONSTRUCTOR$

     }

     /**
      * Retrieve the value of the en_temp.temp1 column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTempTemp1() throws DataStoreException {
          return  getString(EN_TEMP_TEMP1);
     }

     /**
      * Retrieve the value of the en_temp.temp1 column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTempTemp1(int row) throws DataStoreException {
          return  getString(row,EN_TEMP_TEMP1);
     }

     /**
      * Set the value of the en_temp.temp1 column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTempTemp1(String newValue) throws DataStoreException {
          setString(EN_TEMP_TEMP1, newValue);
     }

     /**
      * Set the value of the en_temp.temp1 column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTempTemp1(int row,String newValue) throws DataStoreException {
          setString(row,EN_TEMP_TEMP1, newValue);
     }

     /**
      * Retrieve the value of the en_temp.temp2 column for the current row.
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTempTemp2() throws DataStoreException {
          return  getString(EN_TEMP_TEMP2);
     }

     /**
      * Retrieve the value of the en_temp.temp2 column for the specified row.
      * @param row which row in the table
      * @return String
      * @throws DataStoreException
      */ 
     public String getEnTempTemp2(int row) throws DataStoreException {
          return  getString(row,EN_TEMP_TEMP2);
     }

     /**
      * Set the value of the en_temp.temp2 column for the current row.
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTempTemp2(String newValue) throws DataStoreException {
          setString(EN_TEMP_TEMP2, newValue);
     }

     /**
      * Set the value of the en_temp.temp2 column for the specified row.
      * @param row which row in the table
      * @param newValue the new item value
      * @throws DataStoreException
      */ 
     public void setEnTempTemp2(int row,String newValue) throws DataStoreException {
          setString(row,EN_TEMP_TEMP2, newValue);
     }
     
     //$CUSTOMMETHODS$
     //Put custom methods between these comments, otherwise they will be overwritten if the model is regenerated
     
     //$ENDCUSTOMMETHODS$
     
}
