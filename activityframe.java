package ProjectFolder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class activityframe extends JFrame {

	public static final long serialVersionUID = 1L;
	
	public static JPanel contentPane;
	public static JTextField durationtxt;
	public static JTextField weighttxt;
	float cal;
	public static JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					activityframe frame = new activityframe();
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
	public activityframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				homeframe obj= new homeframe();
				obj.setVisible(true);
				homeframe.usernameField.setText(loginframe.name1);
				homeframe.wtField.setText(loginframe.wt2);
				homeframe.htField.setText(loginframe.ht2);
				homeframe.ageField.setText(loginframe.age2);
				homeframe.bmiField.setText(loginframe.bmi2);
				homeframe.rangeField.setText(loginframe.s5);
				homeframe.strField.setText(loginframe.s6);
				dispose();
			}
		});
		
		textField1 = new JTextField();
		textField1.setBounds(290, 79, 156, 19);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("What exercises did you do today?");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(225, 108, 306, 21);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Walking", "Running", "Cycling", "Swimming", "Aerobics"}));
		comboBox.setBounds(56, 150, 306, 27);
		contentPane.add(comboBox);
		
		JButton btnCalculateCalories = new JButton("Calculate Calories");
		btnCalculateCalories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String exer=(String) comboBox.getSelectedItem();
				String dur=durationtxt.getText();
				String w=weighttxt.getText();
				
				homeframe home = new homeframe();
				String str=homeframe.usernameField.getText();
							
				Signupjdbc ob = new Signupjdbc();
				
				ob.insertActivityData(exer, dur, loginframe.wt2, loginframe.name1);
				
				calories calobj = new calories();
				calobj.setVisible(true);
				dispose();
				
				cal=Math.round( (float) (Float.parseFloat(dur)*((5.8*Float.parseFloat(w)*3.5)/200)));
				String calo = Float.toString(cal);
				calories.calorieField.setText(calo);
						
			}
		});
		btnCalculateCalories.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCalculateCalories.setBounds(300, 237, 156, 27);
		contentPane.add(btnCalculateCalories);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(603, 416, 85, 21);
		contentPane.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBounds(518, 150, 130, 52);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Weight(kg)");
		lblNewLabel_1_2.setBounds(0, 10, 133, 23);
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1_2);
		
		weighttxt = new JTextField();
		weighttxt.setColumns(10);
		weighttxt.setBounds(24, 33, 96, 19);
		panel_3.add(weighttxt);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(384, 150, 124, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Duration\r\n(min)");
		lblNewLabel_1.setBounds(0, 10, 133, 23);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		durationtxt = new JTextField();
		durationtxt.setBounds(10, 33, 96, 19);
		panel.add(durationtxt);
		durationtxt.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zishaan\\Downloads\\wallp77.jpg"));
		lblNewLabel.setBounds(0, 0, 698, 447);
		contentPane.add(lblNewLabel);
	}
}
