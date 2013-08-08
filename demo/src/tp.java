import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class tp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JMenuBar menuBar;
	JMenu mnAdmin;
	int i=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			tp dialog = new tp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public tp() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		 menuBar = new JMenuBar();
		  mnAdmin = new JMenu("message");
		  mnAdmin.setForeground(Color.red);
		  mnAdmin.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		Color a=mnAdmin.getForeground();
			     
			      if(a.equals(Color.red)){
			    	  mnAdmin.setForeground(Color.black);
			    	  System.out.println("sdsd");
			      }
		  	}
		  });
		  
		  
		  
		  
	      menuBar.add(mnAdmin);
	     
		menuBar.setBounds(0, 0, 434, 23);
		getContentPane().add(menuBar);
			
			
		
	}

}
