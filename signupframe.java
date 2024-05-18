package ProjectFolder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;

public class signupframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernametxt;
	private JTextField httxt;
	private JTextField wttxt;
	private JTextField agetxt;
	private JTextField passtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupframe frame = new signupframe();
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
	public signupframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(239, 252, 248));
		panel.setBounds(38, 10, 417, 464);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Hey there!");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Verdana Pro Cond Black", Font.BOLD, 26));
		lblNewLabel_3.setBounds(86, 10, 244, 45);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sign up to get started");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_4.setBounds(71, 50, 265, 32);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Username");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(45, 92, 182, 28);
		panel.add(lblNewLabel_2_1);
		
		usernametxt = new JTextField();
		usernametxt.setColumns(10);
		usernametxt.setBounds(45, 116, 327, 34);
		panel.add(usernametxt);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password ");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_1_1.setBounds(45, 160, 182, 28);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Heigth(m)");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_1_1_1.setBounds(90, 232, 101, 28);
		panel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Weigth(kg)");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_1_1_1_1.setBounds(254, 232, 101, 28);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		httxt = new JTextField();
		httxt.setColumns(10);
		httxt.setBounds(86, 270, 92, 32);
		panel.add(httxt);
		
		wttxt = new JTextField();
		wttxt.setColumns(10);
		wttxt.setBounds(244, 269, 92, 34);
		panel.add(wttxt);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Age");
		lblNewLabel_2_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_1_1_1_2.setBounds(154, 312, 101, 28);
		panel.add(lblNewLabel_2_1_1_1_2);
		
		agetxt = new JTextField();
		agetxt.setColumns(10);
		agetxt.setBounds(163, 350, 92, 32);
		panel.add(agetxt);
		
		JButton btnSignup = new JButton("SIGN UP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = usernametxt.getText();
				String height = httxt.getText();
				String weight = wttxt.getText();
				String age=agetxt.getText();
				
				String password = passtxt.getText();
				if(password.length()>5)
				{
					Signupjdbc signupobj = new Signupjdbc();
					signupobj.insertData(username,password,height,weight,age);
					JOptionPane.showMessageDialog(btnSignup , "Your account has been created");
					
					loginframe loginfr = new loginframe();
					loginfr.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(btnSignup , "Password should contain atleast 6 characters");
					passtxt.setText("");
					
				}
				
				
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignup.setBackground(Color.BLACK);
		btnSignup.setForeground(new Color(255, 255, 255));
		btnSignup.setBounds(42, 401, 159, 39);
		panel.add(btnSignup);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usernametxt.setText("");
				passtxt.setText("");
				httxt.setText("");
				wttxt.setText("");
				agetxt.setText("");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBackground(Color.BLACK);
		btnReset.setBounds(211, 401, 161, 39);
		panel.add(btnReset);
		
		passtxt = new JTextField();
		passtxt.setBounds(45, 188, 327, 34);
		panel.add(passtxt);
		passtxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(416, 10, 0, 0);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(421, 10, 0, 0);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 879, 487);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Zishaan\\Downloads\\signup3.jpg"));
		contentPane.add(lblNewLabel_2);
	}
}
