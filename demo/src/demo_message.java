import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class demo_message extends JDialog {
	public static Statement stmt;
	public static Connection con;
	public static ResultSet rs;
	JMenuBar menuBar;
	JMenu mnAdmin;
	JMenuItem m;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			demo_message dialog = new demo_message();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public demo_message() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		 menuBar = new JMenuBar();
		  mnAdmin = new JMenu("message");
		  
		  mnAdmin.setForeground(Color.BLACK);
		  mnAdmin.setBackground(Color.WHITE);
	      menuBar.add(mnAdmin);
	      
	     
		menuBar.setBounds(0, 0, 434, 23);
		getContentPane().add(menuBar);
		
		
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
//					int rowcount = 0;
//					if (rs.last()) {
//					  rowcount = rs.getRow();
//					  rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
//					}
//					
					int i=0; 
					while(rs.next()){
						 m=new JMenuItem("Message : "+rs.getString(1));
						 
						mnAdmin.add(m);
						mnAdmin.setForeground(Color.red);
					//JOptionPane.showMessageDialog(null,"Message : "+rs.getString(1),"SUCESS",JOptionPane.INFORMATION_MESSAGE);
						
						i++;         
						}
//					if(i>0){
//						mnAdmin.setForeground(Color.red);
//					}else{
//						mnAdmin.setForeground(Color.black);
//					}
					m.addActionListener(new ActionListener() {
					  	public void actionPerformed(ActionEvent e) {
					  		mnAdmin.setForeground(Color.black);
					  	}
					  });
					//mnAdmin.setForeground(Color.black);
					stmt.executeUpdate("update message set status='read' where status='unread'");
				   }catch(Exception e){

							e.printStackTrace();	

		        }
		      }

		    },startingTime,delayTime);

	}
}
