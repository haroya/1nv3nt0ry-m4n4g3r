package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;


////DONT TOUCH THIS!!!!!!!///////////////////////////////////////////

public class testWB extends JFrame {

	private JPanel contentPane;
	private JTextField txtProductId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testWB frame = new testWB();
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
	public testWB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtProductId = new JTextField();
		txtProductId.setFont(new Font("Arial", Font.BOLD, 48));
		txtProductId.setBackground(new Color(255, 255, 204));
		txtProductId.setText("Product ID");
		GridBagConstraints gbc_txtProductId = new GridBagConstraints();
		gbc_txtProductId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProductId.gridx = 5;
		gbc_txtProductId.gridy = 2;
		contentPane.add(txtProductId, gbc_txtProductId);
		txtProductId.setColumns(10);
	}

}
