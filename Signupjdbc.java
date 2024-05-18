package ProjectFolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Signupjdbc {
	
	
	

		Connection con;
		Statement st;
		String htt;
		String wtt;
		String agee;
		static String strRange;
		
		public static float bmiiii;
		
		public void connectDB()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver"); // this method registers the driver
				
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness_tracker", "root", "");
				
				System.out.println("connection established");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void createDB()
		{
			connectDB();
			try
			{
				st= con.createStatement();
				
				String sql="create database cricket";
				
				st.executeUpdate(sql); 
				
				System.out.println("Database created!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void createTable()
		{
			connectDB();
			
			try
			{
				st= con.createStatement();
				
				String sql="create table player(pid int not null primary key, pname varchar(20) , pRank varchar(20))";
				
				st.executeUpdate(sql); 
				
				System.out.println("Table created!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				
			
		}
		
		public void insertData(String name ,String pass ,String ht ,String wt ,String age )
		{
			connectDB();
			
			String sql = "insert into user values(?,?,?,?,?)";
			
			try
			{
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, pass);
				ps.setString(3, ht);
				ps.setString(4, wt);
				ps.setString(5, age);
				
				int res=ps.executeUpdate();
				
				
				
				System.out.println("Data inserted successfully "+ res);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void insertActivityData(String acti ,String duration,String weight  ,String username )
		{
			connectDB();
			
			String sql = "insert into exercises values(?,?,?,?)";
			
			try
			{
				PreparedStatement ps= con.prepareStatement(sql);
				ps.setString(1, acti);
				ps.setString(2, duration);
				ps.setString(3, weight);
				ps.setString(4, username);
				
				System.out.println(username);
				
				int res=ps.executeUpdate();
				
				System.out.println("Data inserted successfully "+ res);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void readAllData()
		{
			connectDB();
			String sql="select * from player";
			try
			{
				st = con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				
				while(rs.next())
				{
					System.out.println("Player number : "+rs.getInt(1)+" Player name : "+ rs.getString(2)+" Player rank : "+ rs.getInt(3));
				}
				
			
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
		}
		
		public void readData(String str)
		{
			connectDB();
			String sql="select username,height,weight,age from user where username = "+"'"+str+"'";
			try
			{
				
				st = con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				
				boolean temp=rs.next();
				System.out.println(temp);
				
				String usrnm=rs.getString(1) ;
				float htt=rs.getFloat(2);
				float wtt=rs.getFloat(3);
				int agee=rs.getInt(4);
				
				System.out.println("Username : "+usrnm +"\t Height : "+ htt+"\t Weight : "+ wtt +"\t Age : "+ agee);
		
				//System.out.println("Username : "+rs.getString(1) +"\t Height : "+ rs.getFloat(2)+"\t Weight : "+ rs.getFloat(3) +"\t Age : "+ rs.getInt(4));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
		}
		
		public String readHt(String str)
		{
			connectDB();
			String sql="select height from user where username = "+"'"+str+"'";
			try
			{
				
				st = con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				
				boolean temp=rs.next();
				System.out.println(temp);
				
				
				htt=rs.getString(1);
				
				
				
				System.out.println("Height : "+ htt);
				
				//System.out.println("Username : "+rs.getString(1) +"\t Height : "+ rs.getFloat(2)+"\t Weight : "+ rs.getFloat(3) +"\t Age : "+ rs.getInt(4));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return htt;
			
		
		
		}
		
		public String readWt(String str)
		{
			connectDB();
			String sql="select weight from user where username = "+"'"+str+"'";
			try
			{
				
				st = con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				
				boolean temp=rs.next();
				System.out.println(temp);
				
				
				wtt=rs.getString(1);
				
				
				
				System.out.println("Weight : "+ wtt);
				
				//System.out.println("Username : "+rs.getString(1) +"\t Height : "+ rs.getFloat(2)+"\t Weight : "+ rs.getFloat(3) +"\t Age : "+ rs.getInt(4));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return wtt;
		}
		
		public String readAge(String str)
		{
			connectDB();
			String sql="select age from user where username = "+"'"+str+"'";
			try
			{
				
				st = con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				
				boolean temp=rs.next();
				System.out.println(temp);
				
				
				agee=rs.getString(1);
				
				
				
				System.out.println("Age : "+ agee);
				
				//System.out.println("Username : "+rs.getString(1) +"\t Height : "+ rs.getFloat(2)+"\t Weight : "+ rs.getFloat(3) +"\t Age : "+ rs.getInt(4));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return agee;
		}
		

		public void deleteData (String nm)
		{
			connectDB();
			String sql="delete from user where username = "+"'nm'";
			
			try
			{
				st=con.createStatement();
				st.executeUpdate(sql);
				System.out.println("Data deleted successfully!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			 
		}
		
		public void updateData (String nm ,String h,String w , String a)
		{
			connectDB();
			String sql="update user set height=? , weight=? , age=? where username = ?";
			
			
			try
			{
				PreparedStatement ps= con.prepareStatement(sql);
				
				//in question mark sequence..
				ps.setString(1, h);
				ps.setString(2, w);
				ps.setString(3, a);
				ps.setString(4, nm);
				
				int res=ps.executeUpdate();
				System.out.println("Data updated successfully!" + res);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			 
		}

		
		public static float getBMI(String hh , String ww)
		{
			bmiiii=Math.round(Float.parseFloat(ww)/(Float.parseFloat(hh)*Float.parseFloat(hh)));	
			return bmiiii;
		}
		
		public static String getRange(float bmi)
		{
			if(bmi<18)
			{
				strRange="Underweight";
			}
			else if(bmi>=18 && bmi<=25)
			{
				strRange="Normal";
			}
			else if(bmi>25 && bmi<=30)
			{
				strRange="Overweight";
			}
			else
			{
				strRange="Type-I Obese";
			}
			
			return strRange;
			
		}
}


