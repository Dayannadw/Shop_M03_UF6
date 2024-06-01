package model;
import java.sql.SQLException;

import exception.LimitLoginException;

import dao.Dao;
import dao.DaoImplJDBC;


public class Employee extends Person implements main.Logable {
	private int employeeId;
	private String password;
	//final static int USER = 123;
	//final static String PASSWORD = "test";
	private Dao dao;
	
	//constructor that initialize the name and DAo
	public Employee(String name) {
		super(name);
		this.dao = new DaoImplJDBC(); 
		
	}
	//constructor that initialize the id, the name and password
	/*public Employee(int employeeId, String name, String password) { 
		super (name );
		this.employeeId = employeeId;
		this.password = password;
		this.dao = new DaoImplJDBC();
	}**/


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	// NEW LOGIN METHOD 
	public boolean login(int user, String password) {
	    try {
	        dao.connect();
	        Employee employee = dao.getEmployee(user, password);
	        if (employee != null) {
	            // Update current instance with employee details
	            this.employeeId = employee.getEmployeeId();
	            this.setName(employee.getName());
	            this.password = employee.getPassword();
	            return true;
	        }
	        return false;
	    } catch (SQLException e) {
	        System.err.println("Error inicio de login:");
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            dao.disconnect();
	        } catch (SQLException e) {
	            System.err.println("Error en la connección:");
	            e.printStackTrace();
	        }
	    }
	}

}


