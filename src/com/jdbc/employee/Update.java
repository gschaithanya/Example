package com.jdbc.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) throws SQLException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee",
			// "root", "Mysql@1234");
			conn = JDBCMySQLConnection.getConnection();
		

			String sql = "update EmpDetails Set Address=?,Designation=?,ContactNumber=?,Email=?,AnnualCTC=?,YearsofExperience=?,BloodGroup=? where EmployeeName='lija' and ( Address !='' OR Designation !='' OR ContactNumber!='' OR Email !='' OR AnnualCTC !='' OR YearsofExperience !='' OR BloodGroup !='')";

			// ;

			// String sql ="update EmpDetails SET
			// Address=?,Designation=?,ContactNumber=?,Email=?,AnnualCTC=?,YearsofExperience=?,BloodGroup=?
			// where Employeename='LIJA' " ;

			/*
			 * System.out.print("Enter the employee name"); String name = s.nextLine();
			 */
			System.out.print("Enter the address ");
		
			String address = reader.readLine();
			

			System.out.print("Enter the designation");
			String designation = reader.readLine();

			System.out.println("Enter the contact number");
			String contactnumber = reader.readLine();

			System.out.println("Enter the email");
			String email = reader.readLine();

			System.out.println("Enter the annual ctc in lakhs");
			
			
				double annualCtc = Double.parseDouble(reader.readLine());
			
			
			System.out.println("Enter total year of experience");
			
			
		

			
				float yearsOfExperience = Float.parseFloat(reader.readLine());;
			
			

			System.out.println("Enter the blood group");

			String bloodGroup = reader.readLine();

			stmt = conn.prepareStatement(sql);

			// stmt.setString(1, name);
			stmt.setString(1, address);
			stmt.setString(2, designation);
			stmt.setString(3, contactnumber);
			stmt.setString(4, email);

			stmt.setDouble(5, annualCtc);
			stmt.setFloat(6, yearsOfExperience);
			stmt.setString(7, bloodGroup);
			stmt.executeUpdate();
			System.out.println("Updated the employee sucessfully");

		} catch (NumberFormatException e) {
		    // Use whatever default you like
			double annualCtc=0;
			float yearsOfExperience=0;
			
		}
		finally {
			conn.close();
		}

	}
}
