import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class TimerClass {
	public static Statement stmt;
	public static Connection con;
	public static ResultSet rs;
    public static void main(String[] args) {
    	
    Timer timer=  new Timer();

    int startingTime=1000; 
    int delayTime=1000; 
     timer.schedule(new TimerTask()
       {
        public void run() {
         System.out.println("Timer repeat statement");
		try {
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" ) ;
			con = DriverManager.getConnection( "jdbc:odbc:message" ) ;
			stmt = con.createStatement() ;
			rs=stmt.executeQuery("select * from message where status='unread'");
			int i=0;
			while(rs.next()){
				JOptionPane.showMessageDialog(null,"Message : "+rs.getString(1),"SUCESS",JOptionPane.INFORMATION_MESSAGE);
				i++;         
				}
			stmt.executeUpdate("update message set status='read' where status='unread'");
		   }catch(Exception e){

					e.printStackTrace();	

        }
      }

    },startingTime,delayTime);
}
}