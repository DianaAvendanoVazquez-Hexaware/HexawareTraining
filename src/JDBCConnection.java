import java.sql.*;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		
		String dburl = "jdbc:mysql://localhost:3306/demoJDBC";
		String user = "root";
		String pssw = "xxxx";
		
		//sets the connection to the db
		Connection conn = DriverManager.getConnection(dburl, user, pssw);
		
		//instantiates statement which contains the method to execute queries in SQL
		Statement s = conn.createStatement();
		
		
		s.executeUpdate("INSERT INTO peopleinfo values('someName','SomeLastName', 'SomeEmail', 'SomePAssword', 'SomeCompany','SomeAddress', 'SomeCity', '1234','332112345');");
		
		//We save the results to be able to use them later
		ResultSet rs = s.executeQuery("SELECT * FROM peopleinfo " );
		
		
		//This section displays the columns we want to see from the db
		while(rs.next()){
			
		System.out.println("Name: " + rs.getString("NAME"));
		System.out.println("Last Name: " + rs.getString("LASTNAME"));
		System.out.println("Email: " + rs.getString("EMAIL"));
		System.out.println("Password: " + rs.getString("PASSWORD"));
		System.out.println("Company: " + rs.getString("COMPANY"));
		System.out.println("Address: " + rs.getString("ADDRESS"));
		System.out.println("City: " + rs.getString("CITY"));
		System.out.println("ZipCode: " + rs.getString("ZIP_CODE"));
		System.out.println("Phone: " + rs.getString("MOBILE_PHONE"));
		
		
		}
		
		System.out.println("-----------------------");
		System.out.println("The columns in the table are: ");

        System.out.println("Table: " + rs.getMetaData().getTableName(1));
        for  (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ rs.getMetaData().getColumnName(i));
        }
    
	}

}
