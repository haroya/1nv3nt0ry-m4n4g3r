package frames;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import java.awt.Font;

public class ConfirmFrame extends JFrame {

	private JPanel contentPane;
	private boolean result;

	/**
	 * Create the frame.
	 */
	public ConfirmFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton confirmButton = new JButton("Confirm");
		contentPane.add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result = true;
				Component comp = (Component) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		sl_contentPane.putConstraint(SpringLayout.NORTH, confirmButton, 0, SpringLayout.NORTH, cancelButton);
		contentPane.add(cancelButton);
		
		JTextPane txtpnDoYou = new JTextPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, cancelButton, 40, SpringLayout.SOUTH, txtpnDoYou);
		sl_contentPane.putConstraint(SpringLayout.WEST, confirmButton, 0, SpringLayout.WEST, txtpnDoYou);
		sl_contentPane.putConstraint(SpringLayout.EAST, cancelButton, 0, SpringLayout.EAST, txtpnDoYou);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtpnDoYou, 78, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtpnDoYou, 102, SpringLayout.WEST, contentPane);
		txtpnDoYou.setFont(new Font("Arial", Font.PLAIN, 18));
		txtpnDoYou.setText("Do you wish to confirm?");
		txtpnDoYou.setEditable(false);
		contentPane.add(txtpnDoYou);
	}
	
	public boolean getResult() {
		return result;
	}
}
