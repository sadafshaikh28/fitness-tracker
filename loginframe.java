package ProjectFolder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class loginframe extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public  JTextField usertxt;
	public JPasswordField passwordtxt;
    String s1;
	String s2;
	String s3;
	static String s4;
	public static float bmindex;
	static String s5;
	static String s6;
	static String name1;
	static String ht2="xyz";
	static String wt2="xyz";
	static String age2="xyz";
	static String bmi2="xyz";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginframe frame = new loginframe();
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
	public loginframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(252, 252, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("TRACKER");
		lblNewLabel_3_1.setBounds(644, 230, 156, 63);
		contentPane.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Verdana Pro Cond Black", Font.BOLD, 30));
		lblNewLabel_3_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("FITNESS");
		lblNewLabel_3.setBounds(590, 188, 146, 54);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Verdana Pro Cond Black", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(160, 23, 278, 438);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana Pro Cond Black", Font.BOLD, 26));
		lblNewLabel_1.setBounds(20, 23, 238, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(20, 116, 182, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password ");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(20, 196, 182, 28);
		panel.add(lblNewLabel_2_1);
		
		usertxt = new JTextField();
		usertxt.setBounds(20, 142, 226, 34);
		panel.add(usertxt);
		usertxt.setColumns(10);
		
		
		
		JButton loginbtn = new JButton("LOGIN");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver"); // this method registers the driver
					
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness_tracker", "root", "");
					
					System.out.println("connection established");
					
					String uname=usertxt.getText();	
					String headname=uname;	
					name1=uname;
					
					
					String passWord = passwordtxt.getText();				
					
					Statement stm = con.createStatement();
					String sql = "select * from user where username='"+ uname+"' and password='"+passWord+"'";
					ResultSet rs=stm.executeQuery(sql);
					
					if(rs.next())
					{
						Signupjdbc signupobj= new Signupjdbc();
						signupobj.readData(headname);
						
						
						
						s1=signupobj.readHt(headname); //for only reading height
						s2=signupobj.readWt(headname);
						s3=signupobj.readAge(headname);
						
						wt2=s2;
						ht2=s1;
						age2=s3;
					
						
					
						homeframe hf=new homeframe();
					
						homeframe.htField.setText(s1+"m");
						homeframe.usernameField.setText(headname);
						homeframe.wtField.setText(s2+"kg");
						homeframe.ageField.setText(s3);
						
						bmindex= Signupjdbc.getBMI(ht2, wt2);
						s4=Float.toString(bmindex);
						homeframe.bmiField.setText(s4);
						
						bmi2=s4;
						
						s5="Your BMI is "+s4+", indicating your weight is ";
						s6="in the "+ Signupjdbc.getRange(bmindex)+" for adults of your height.";
						homeframe.rangeField.setText(s5);
						homeframe.strField.setText(s6);
						
						
						
						hf.setVisible(true);
						dispose();
						
					}
					
					
					else
					{
						String sql2 = "select * from user where username="+"'"+ uname+"'" ;
						ResultSet rs2=stm.executeQuery(sql2);
						boolean res=rs2.next();
						if(res==false)
						{
							JOptionPane.showMessageDialog(loginbtn , "incorrect username");
						}
						else
						{
							JOptionPane.showMessageDialog(loginbtn , "incorrect password");
						}
					}
					/*else
					{
						JOptionPane.showMessageDialog(loginbtn , "incorrect username or password");
						usertxt.setText("");
						passwordtxt.setText("");
					}
					*/
					
					
				//	con.close();
				}
				catch(Exception e1)
				{
					System.out.println(e1.getMessage());
				}
				
				
			}
		});
		
		//homeframe object1= new homeframe();
		//object1.
		
	
		
		loginbtn.setBackground(Color.BLACK);
		loginbtn.setForeground(Color.WHITE);
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginbtn.setBounds(71, 282, 127, 41);
		panel.add(loginbtn);
		
		JButton regbtn = new JButton("SIGN UP");
		regbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				signupframe signupf = new signupframe();
				signupf.setVisible(true);
				dispose();
			}
		});
		regbtn.setBackground(Color.BLACK);
		regbtn.setForeground(Color.WHITE);
		regbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		regbtn.setBounds(71, 381, 127, 41);
		panel.add(regbtn);
		
		JLabel lblNewLabel_1_1 = new JLabel("Don't have an account yet?");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(20, 343, 248, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sign in to your account");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(20, 62, 238, 28);
		panel.add(lblNewLabel_1_1_1);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(20, 224, 226, 34);
		panel.add(passwordtxt);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zishaan\\Downloads\\wallpaper3.jpg"));
		lblNewLabel.setBounds(0, 0, 875, 483);
		contentPane.add(lblNewLabel);
	}
}
