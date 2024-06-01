package dao; 

import java.sql.SQLException;


import model.Employee; 

public interface Dao {
	
	
	public void connect() throws SQLException;
	
	 Employee getEmployee(int employeeId, String password);
	
	 public void disconnect() throws SQLException;
	 
	 

}
