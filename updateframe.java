package ProjectFolder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateframe extends JFrame {

	public static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField updateht;
	public static JTextField updatewt;
	public static JTextField updateage;
	static String htupdated="xyz";
	static String wtupdated="xyz";
	static String ageupdated="xyz";
	
	static String strnewbmi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateframe frame = new updateframe();
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
	public updateframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(151, 53, 308, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("UPDATE PROFILE");
		lblNewLabel_2.setBounds(10, 0, 307, 43);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Britannic Bold", Font.PLAIN, 28));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		
		updateage = new JTextField();
		updateage.setColumns(10);
		updateage.setBounds(341, 253, 90, 28);
		contentPane.add(updateage);
		
		updatewt = new JTextField();
		updatewt.setColumns(10);
		updatewt.setBounds(341, 204, 90, 28);
		contentPane.add(updatewt);
		
		updateht = new JTextField();
		updateht.setBounds(341, 150, 90, 28);
		contentPane.add(updateht);
		updateht.setColumns(10);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(155, 150, 150, 28);
		contentPane.add(panel_2_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Height");
		lblNewLabel_1_2.setBounds(0, 0, 152, 28);
		panel_2_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 17));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(155, 204, 150, 28);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Weight");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(0, 0, 152, 28);
		panel_2_1.add(lblNewLabel_1_2_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				htupdated = updateht.getText();
				wtupdated = updatewt.getText();
				ageupdated = updateage.getText();
				
				Signupjdbc obj = new Signupjdbc();
				obj.updateData(loginframe.name1, htupdated, wtupdated, ageupdated);
				JOptionPane.showMessageDialog(btnUpdate , "Profile Updated Successfully");
				
				
			}
		});
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdate.setBounds(257, 312, 117, 36);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homeframe homefr= new homeframe();
				homefr.setVisible(true);
				
				homeframe.usernameField.setText(loginframe.name1);
				homeframe.htField.setText(htupdated);
				homeframe.wtField.setText(wtupdated);
				homeframe.ageField.setText(ageupdated);
				
				
				float newbmi=Signupjdbc.getBMI(htupdated, wtupdated);
				strnewbmi=Float.toString(newbmi);
				
				
				homeframe.bmiField.setText(strnewbmi);
				homeframe.rangeField.setText("Your BMI is "+strnewbmi+", indicating your weight is ");
				homeframe.strField.setText("in the "+ Signupjdbc.getRange(newbmi)+" for adults of your height.");
				
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(257, 358, 117, 36);
		contentPane.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(154, 253, 151, 28);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Age");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1_2_2.setBounds(0, 0, 152, 28);
		panel_2.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zishaan\\Downloads\\signup4.jpeg"));
		lblNewLabel.setBounds(-15, 0, 622, 408);
		contentPane.add(lblNewLabel);
	}
}
