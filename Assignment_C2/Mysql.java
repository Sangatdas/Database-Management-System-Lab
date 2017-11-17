import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Mysql {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsc2","sangat","password");
		
		Statement st = conn.createStatement();
		
		String query;
		ResultSet rs;
		
		int opt=0;
		while(opt!=5)
		{
			System.out.println("Choose option:");
			System.out.println("1.Create query");
			System.out.println("2.Read query");
			System.out.println("3.Update query");
			System.out.println("4.Delete query");
			System.out.println("5.Exit");
			
			opt=sc.nextInt();
			
			switch(opt)
			{
			case 1:
				query = "create table student(rollno int primary key auto_increment,name varchar(20),marks int);";
				st.execute(query);
				query = "insert into student values(null,'sangat',91);";
				st.execute(query);
				query = "insert into student values(null,'chinmay',95);";
				st.execute(query);
				query = "insert into student values(null,'anand',91);";
				st.execute(query);
				break;
			case 2:
				query = "select * from student";
				rs = st.executeQuery(query);
				while(rs.next())
				{
					int rollno = rs.getInt("rollno");
					String name = rs.getString("name");
					int marks = rs.getInt("marks");
					System.out.println("\nRoll no. "+rollno+"\nName: "+name+"\nMarks: "+marks);
				}
				break;
			case 3:
				query = "update student set marks=100";
				st.executeUpdate(query);
				break;
			case 4:
				query = "delete from student";
				st.execute(query);
				break;
			case 5:
				break;		
			default:
				System.out.println("Invalid choice!!");
			}
		}
		conn.close();
	}

}
