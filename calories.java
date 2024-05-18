package ProjectFolder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calories extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public static JTextField calorieField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calories frame = new calories();
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
	public calories() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				activityframe objactivity = new	activityframe();
				objactivity.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(563, 10, 78, 25);
		contentPane.add(btnNewButton);
		
		calorieField = new JTextField();
		calorieField.setFont(new Font("Arial", Font.BOLD, 24));
		calorieField.setBounds(77, 189, 96, 54);
		contentPane.add(calorieField);
		calorieField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("calories!");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(47, 245, 152, 33);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("You burned ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1.setBounds(42, 154, 170, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zishaan\\Downloads\\hand-manager-employee-with-flashlight-showing-gold-cup-golden-trophy-prize-spotlight-flat-vector-illustration-success-career-concept-banner-website-design-landing-web-page_74855-23066.jpg"));
		lblNewLabel.setBounds(0, 0, 651, 365);
		contentPane.add(lblNewLabel);
	}

}
