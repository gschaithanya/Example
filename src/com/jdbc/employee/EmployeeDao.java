
package com.jdbc.employee;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeDao {

	
		ArrayList<EmployeeDetails> emp = new ArrayList<EmployeeDetails>();

		Scanner s = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement stmt = null;
		{
		System.out.println(
				"Press  \n (0) to add new employee \n (1) View employee details(1)  \n (2) View employee details based on bloodgroup\n (3) View employee who are over paid\n (4) view employee who all are underpaid");
		int i = s.nextInt();
		
		
		try {
			
			// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee",
			// "root", "Mysql@1234");
			conn = JDBCMySQLConnection.getConnection();

			String sql = "insert into Empdetails(employeeName,address,designation,contactNumber,email,annualCtc,yearsOfExperience,bloodGroup) values(?,?,?,?,?,?,?,?)";
			String QUERY = "SELECT * FROM Empdetails";
			String sql1="select Employeename, (AnnualCtc/YearsofExperience) as 'result' from EmpDetails group by result having result>1";
			String sql2="select Employeename, (AnnualCtc/YearsofExperience) as 'result' from EmpDetails group by result having result<1";


			switch (i) {
			case 0:

				System.out.print("Enter the employee name");
				String name = s.next();
				System.out.print("Enter the address ");
				String address = s.next();
				System.out.print("Enter the designation");
				String designation = s.next();
				s.nextLine();
				System.out.println("Enter the contact number");
				String contactNumber = s.next();
				System.out.println("Enter the email");
				String email = s.next();
				System.out.println("Enter the annual ctc in lakhs");
				Double annualCtc = s.nextDouble();
				System.out.println("Enter total year of experience");
				float yearsOfExperience = s.nextFloat();
				System.out.println("Enter the blood group");
				String bloodGroup = s.next();
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, name);
				stmt.setString(2, address);
				stmt.setString(3, designation);
				stmt.setString(4, contactNumber);
				stmt.setString(5, email);
				stmt.setDouble(6, annualCtc);
				stmt.setFloat(7, yearsOfExperience);
				stmt.setString(8, bloodGroup);
				stmt.execute();
				System.out.println("Added the employee sucessfully");
				break;
			case 1:
				Statement stmt2 = conn.createStatement();
				ResultSet rs = stmt2.executeQuery(QUERY);
				while (rs.next()) {
					// Retrieve by column name
					System.out.print(rs.getString("Employeename"));
					System.out.print(" " + rs.getString("address"));
					System.out.print(" " + rs.getString("designation"));
					System.out.print(" " + rs.getString("contactNumber"));
					System.out.print(" " + rs.getString("email"));
					System.out.print(" " + rs.getDouble("annualCtc"));
					System.out.print(" " + rs.getFloat("yearsofExperience"));
					System.out.println(" " + rs.getString("bloodGroup"));

				}
				break;


			
			case 2:
				Statement stmt11 = conn.createStatement();
				ResultSet rs21 = stmt11.executeQuery(QUERY);

				while (rs21.next()) {
					EmployeeDetails employee = new EmployeeDetails();
					employee.setEmployeeName(rs21.getString("Employeename"));
					employee.setAddress(rs21.getString("address"));
					employee.setDesignation(rs21.getString("designation"));
					employee.setContactNumber(rs21.getString("contactNumber"));
					employee.setEmail(rs21.getString("email"));
					employee.setAnnulaCtc(rs21.getDouble("annualCtc"));
					employee.setYearsOfExperience(rs21.getFloat("yearsofExperience"));
					employee.setBloodGroup(rs21.getString("bloodGroup"));
					emp.add(employee);
				}
				Map<Object, List<EmployeeDetails>> EmpbyBloodgroup = new HashMap<>();

				EmpbyBloodgroup = emp.stream().collect(Collectors.groupingBy(EmployeeDetails::getBloodGroup));
				//System.out.println(EmpbyBloodgroup);
				Set set = EmpbyBloodgroup.entrySet();
				Iterator iterator = set.iterator();
				while (iterator.hasNext()) {
					Map.Entry entry = (Map.Entry) iterator.next();
					System.out.println("BloodGroup : " + entry.getKey());
					System.out.println(" "+entry.getValue());
				

			}
				break;
			case 3:
				Statement stmt4 = conn.createStatement();
				ResultSet rs4 = stmt4.executeQuery(sql1);
				System.out.println("Employees who all are overpaid");
				while (rs4.next()) {
					// Retrieve by column name
					System.out.println(rs4.getString("Employeename"));
				

				}
				break;
				
				
			case 4:
				Statement stmt5 = conn.createStatement();
				ResultSet rs5 = stmt5.executeQuery(sql2);
				System.out.println("Employees who all are underpaid");
				while (rs5.next()) {
					// Retrieve by column name
					System.out.println(rs5.getString("Employeename"));
				

				}
				break;
		
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	

}
}
