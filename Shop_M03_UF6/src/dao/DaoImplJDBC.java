
package dao; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import exception.LimitLoginException;

import model.Employee;

public class DaoImplJDBC implements Dao {

	private Connection connection;
	
	//Connectionn 
	public void connect() throws SQLException {
		// Define connection parameters
		String url = "jdbc:mysql://localhost:3306/shop";
		String user = "root";
		String password = "";
		this.connection = DriverManager.getConnection(url, user, password);
	}
	
	// Get employee 
	 public Employee getEmployee(int employeeId, String password) {
	        Employee employee = null;
	        try {
	            String query = "SELECT * FROM employee WHERE employeeId = ? AND password = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, employeeId);
	            statement.setString(2, password);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                employee = new Employee(resultSet.getString("name"));
	                employee.setEmployeeId(resultSet.getInt("employeeId"));
	                employee.setPassword(resultSet.getString("password"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employee;
	    }
	
	//Disconnection 
	@Override
	public void disconnect() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	/**public void disconnect() {
        try {
            if (connection != null ) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}**/
	
}}

