=package studCollegePune;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class StudentCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb","root","root");
		return connection;
	}
	
	public int signUp(Student student) throws Exception {
		Connection connection=getConnection();
		 PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO STUDENT(ID,NAME,FNAME,MNAME,AGE,PHONE,EMAIL,PASSWORD)VALUES(?,?,?,?,?,?,?,?)");
		 preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getFname());
			preparedStatement.setString(4, student.getMname());
			preparedStatement.setInt(5, student.getAge());
			preparedStatement.setLong(6, student.getPhone());
			preparedStatement.setString(7, student.getEmail());
			preparedStatement.setString(8, student.getPassword());
			
			int result=preparedStatement.executeUpdate();
			connection.close();
			return result;
	}
	
	public String login(String email) throws Exception {
		 Connection connection=getConnection();
			String qurey="SELECT password FROM student WHERE email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(qurey);
			preparedStatement.setString(1,email);

			ResultSet resultset=preparedStatement.executeQuery();
			String password=null;
			if(resultset.next()) {
				 password=resultset.getString("password");
			}		
			connection.close();
			return password;
	 }
	
	
}
