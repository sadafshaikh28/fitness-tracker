package ProjectFolder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class homeframe extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JLabel httlbl;
	public static JTextField htField;
	public static JTextField usernameField;
	public static JTextField wtField;
	public static JTextField ageField;
	public static JTextField bmiField;
	public static JTextField rangeField;
	public static JTextField strField;
	PreparedStatement ps;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeframe frame = new homeframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homeframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 445);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		strField = new JTextField();
		strField.setHorizontalAlignment(SwingConstants.CENTER);
		strField.setFont(new Font("Arial", Font.BOLD, 11));
		strField.setColumns(10);
		strField.setBounds(176, 379, 385, 19);
		contentPane.add(strField);
		
		rangeField = new JTextField();
		rangeField.setFont(new Font("Arial", Font.BOLD, 11));
		rangeField.setHorizontalAlignment(SwingConstants.CENTER);
		rangeField.setBounds(176, 360, 385, 19);
		contentPane.add(rangeField);
		rangeField.setColumns(10);
		
		bmiField = new JTextField();
		bmiField.setHorizontalAlignment(SwingConstants.CENTER);
		bmiField.setFont(new Font("Arial", Font.BOLD, 19));
		bmiField.setBounds(247, 121, 96, 29);
		contentPane.add(bmiField);
		bmiField.setColumns(10);
		
		JLabel lblNewLabel_2_3 = new JLabel("Your Current Body Mass Index is ");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(176, 90, 252, 29);
		contentPane.add(lblNewLabel_2_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(607, 310, 137, 75);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(0, 46, 137, 29);
		panel_2_1.add(lblNewLabel_1_2);
		
		ageField = new JTextField();
		ageField.setHorizontalAlignment(SwingConstants.CENTER);
		ageField.setFont(new Font("Arial", Font.BOLD, 22));
		ageField.setColumns(10);
		ageField.setBounds(0, 0, 147, 49);
		panel_2_1.add(ageField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(607, 209, 137, 75);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Weight\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(0, 46, 137, 29);
		panel_2.add(lblNewLabel_1_1);
		
		wtField = new JTextField();
		wtField.setHorizontalAlignment(SwingConstants.CENTER);
		wtField.setFont(new Font("Arial", Font.BOLD, 22));
		wtField.setBounds(0, 0, 147, 49);
		panel_2.add(wtField);
		wtField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(607, 110, 137, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Height\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(0, 46, 137, 29);
		panel.add(lblNewLabel_1);
		
		htField = new JTextField();
		htField.setHorizontalAlignment(SwingConstants.CENTER);
		htField.setFont(new Font("Arial", Font.BOLD, 22));
		htField.setBounds(0, 0, 137, 47);
		panel.add(htField);
		htField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(120, 162, 236));
		panel_1.setBounds(0, 0, 168, 408);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnlogout = new JButton("Log Out");
		btnlogout.setBounds(10, 366, 151, 35);
		panel_1.add(btnlogout);
		btnlogout.setForeground(new Color(255, 255, 255));
		btnlogout.setBackground(new Color(0, 92, 185));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginframe loginfr = new loginframe();
				loginfr.setVisible(true);
				dispose();
			}
		});
		btnlogout.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("Update Profile");
		btnNewButton.setBounds(10, 275, 151, 35);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				updateframe updatefr=new updateframe();
				updatefr.setVisible(true);
				updateframe.updatewt.setText(loginframe.wt2);
				updateframe.updateht.setText(loginframe.ht2);
				updateframe.updateage.setText(loginframe.age2);
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnactivity = new JButton("Calculate Calories");
		btnactivity.setBounds(10, 230, 151, 35);
		panel_1.add(btnactivity);
		btnactivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				activityframe activityfr = new activityframe();
				activityframe.textField1.setText(loginframe.name1);
				activityframe.weighttxt.setText(loginframe.wt2);
				activityfr.setVisible(true);
				dispose();
			}
		});
		btnactivity.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnDeleteProfile = new JButton("Delete Profile");
		btnDeleteProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane.showConfirmDialog(this, "Do you want to continue?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
				int opt= JOptionPane.showConfirmDialog(null, "Do you want to continue?","Confirm",JOptionPane.YES_NO_OPTION);
				
				if(opt==0)
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver"); // this method registers the driver
						
						Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness_tracker", "root", "");
						
						System.out.println("connection established");
						
						String sql="delete from `user` where `user`.`username` = ?";
						
						
						ps=con.prepareStatement(sql);
						ps.setString(1, loginframe.name1);
						ps.executeUpdate();
						System.out.println("Data deleted successfully!");
						
						loginframe obj2= new loginframe();
						obj2.setVisible(true);
					    dispose();
						
					}
					catch(Exception e1)
					{
						System.out.println(e1.getMessage());
					}
					
				}
				
				
			//	Signupjdbc obj=new Signupjdbc();
			//	JOptionPane.showMessageDialog(btnDeleteProfile , "Profile Deleted");
			//	obj.deleteData(loginframe.name1);
				
				
			}
		});
		btnDeleteProfile.setFont(new Font("Arial", Font.BOLD, 12));
		btnDeleteProfile.setBounds(10, 321, 151, 35);
		panel_1.add(btnDeleteProfile);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-34, 78, 825, 14);
		separator.setForeground(new Color(0, 0, 0));
		contentPane.add(separator);
		
		
		
		JLabel datelbl = new JLabel("Hello !");
		datelbl.setVerticalAlignment(SwingConstants.BOTTOM);
		datelbl.setBounds(187, 19, 79, 49);
		datelbl.setFont(new Font("Arial", Font.BOLD, 25));
		contentPane.add(datelbl);
		
		
		
		//System.out.println(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));
		Date date1 = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	    String str = formatter.format(date1);
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dayy =new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(665, 26, 79, 42);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1_1.setBackground(new Color(88, 41, 248));
		contentPane.add(panel_1_1);
		
		JLabel hellonamelbl_1 = new JLabel("");
		hellonamelbl_1.setBackground(Color.WHITE);
		hellonamelbl_1.setBounds(458, 21, 0, 0);
		panel_1_1.add(hellonamelbl_1);
		JLabel datelabel = new JLabel(str);
		datelabel.setBounds(0, 0, 89, 27);
		panel_1_1.add(datelabel);
		datelabel.setBackground(new Color(187, 187, 255));
		datelabel.setHorizontalAlignment(SwingConstants.CENTER);
		datelabel.setForeground(new Color(255, 255, 255));
		datelabel.setFont(new Font("Arial", Font.BOLD, 15));
		JLabel daylbl = new JLabel(dayy);
		daylbl.setBounds(0, 21, 89, 21);
		panel_1_1.add(daylbl);
		daylbl.setVerticalAlignment(SwingConstants.TOP);
		daylbl.setHorizontalAlignment(SwingConstants.CENTER);
		daylbl.setForeground(new Color(255, 255, 255));
		daylbl.setFont(new Font("Arial", Font.BOLD, 14));
		daylbl.setBackground(new Color(187, 187, 255));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zishaan\\Downloads\\creative-waves-blue-background-dynamic-shapes-composition-vector-illustration_1142-13229.jpg"));
		lblNewLabel.setBounds(168, 104, 588, 304);
		contentPane.add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setForeground(new Color(122, 85, 249));
		usernameField.setHorizontalAlignment(SwingConstants.LEFT);
		usernameField.setFont(new Font("Arial", Font.BOLD, 25));
		usernameField.setBounds(264, 38, 164, 29);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
	}
}
