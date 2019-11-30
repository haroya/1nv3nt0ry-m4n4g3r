package frames;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AllFrames extends JFrame{
	public JPanel logInPanel = new JPanel();
	public JLabel instText = new JLabel("Please enter the following: ");
	public JLabel productText = new JLabel("Product ID");
	public JLabel quantityText = new JLabel("Quantity");
	public JTextField productID = new JTextField(60);
	public JTextField quantity = new JTextField(60);
	protected JLabel welcome = new JLabel("WELCOME");
	protected JLabel userText = new JLabel("username: ");
	protected JLabel passText = new JLabel("password: ");
	protected JTextField username = new JTextField(60);
	protected JTextField password = new JTextField(60);
	protected JButton continueLogIn = new JButton("continue");
//	protected ActionListener continueListen = new ContinueListener();
	
	public void logIn() {
		logInPanel.removeAll();
		logInPanel.add(welcome);
		logInPanel.add(userText);
		logInPanel.add(username);
		logInPanel.add(passText);
		logInPanel.add(password);
		logInPanel.add(continueLogIn);
		repaint();
		revalidate();
	}
	
	public AllFrames() {
		this.setTitle("1nv3nt0ry-m4n4g3r: Log In Page");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		logIn();
		continueLogIn.addActionListener(new ActionListener() {
			JPanel menuPanel=new JPanel();
			private JLabel menu = new JLabel("MENU");
			private JButton orderOrRestockButton = new JButton("Process Order or Restock");
			private JButton manageButton = new JButton("Manage Products");
			private JButton marketingButton = new JButton("Marketing Analysis");
			private JButton continueMenu = new JButton("continue");
			
			private void menu() {
				menuPanel.add(menu);
				menuPanel.add(orderOrRestockButton);
				menuPanel.add(manageButton);
				menuPanel.add(marketingButton);
				menuPanel.add(continueMenu);
				repaint();
				revalidate();
			}
			
			
			@Override
			public void actionPerformed(ActionEvent click) {
				Component b = (Component) click.getSource();
				JFrame c = (JFrame) SwingUtilities.getRoot(b);
				menu();
				c.setTitle("1nv3nt0ry-m4n4g3r: Menu");
				c.setSize(800,800);
				c.remove(logInPanel);
				c.add(menuPanel);
				repaint();
				revalidate();
/////////////////////////////PROCESS ORDER OR RESTOCK////////////////////////////////////////////////////
				orderOrRestockButton.addActionListener(new ActionListener() {
					JPanel oRRPanel = new JPanel();
					private JLabel orderORRestock = new JLabel("Process Order or Restock");
					private JButton orderButton = new JButton("Process Order");
					private JButton restockButton = new JButton("Process Restock");
					private JButton continueORR = new JButton("continue");
					
					private void oRR() {
						oRRPanel.removeAll();
						oRRPanel.add(orderORRestock);
						oRRPanel.add(orderButton);
						oRRPanel.add(restockButton);
						oRRPanel.add(continueORR);
						repaint();
						revalidate();
						
					}
					
					@Override
					public void actionPerformed(ActionEvent click) {
						Component b = (Component) click.getSource();
						JFrame c = (JFrame) SwingUtilities.getRoot(b);

						oRR();
						
						
						c.setTitle("1nv3nt0ry-m4n4g3r: Order or Restock");
						c.setSize(800,800);
////////////////////////////////PROCESS ORDER/////////////////////////////////////////////////////////
						orderButton.addActionListener(new ActionListener() {
							JPanel orderPanel = new JPanel();
							private JLabel processText = new JLabel("Process Order");
							private JButton continueOrder = new JButton("continue");
							
							private void order() {
								orderPanel.removeAll();
								orderPanel.add(processText);
								orderPanel.add(instText);
								orderPanel.add(productText);
								orderPanel.add(productID);
								orderPanel.add(quantityText);
								orderPanel.add(quantity);
								orderPanel.add(continueOrder);
								repaint();
								revalidate();
								
							}
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								order();
								c.setTitle("1nv3nt0ry-m4n4g3r: Process Order");
								c.setSize(800,800);
								
								c.remove(oRRPanel);
								c.add(orderPanel);
								repaint();
								revalidate();
							}
							
						});
////////////////////////PROCESS RESTOCK///////////////////////////////////////////
					restockButton.addActionListener(new ActionListener() {
						JPanel restockPanel = new JPanel();
						JLabel restockText = new JLabel("Process Restock");
						private JButton continueRestock = new JButton("continue");
						
						private void restock() {
							restockPanel.removeAll();
							restockPanel.add(restockText);
							restockPanel.add(instText);
							restockPanel.add(productText);
							restockPanel.add(productID);
							restockPanel.add(quantityText);
							restockPanel.add(quantity);
							restockPanel.add(continueRestock);
							repaint();
							revalidate();
						}
						
						@Override
						public void actionPerformed(ActionEvent click) {
							Component b = (Component) click.getSource();
							JFrame c = (JFrame) SwingUtilities.getRoot(b);
							restock();
							c.setTitle("1nv3nt0ry-m4n4g3r: Process Restock");
							c.setSize(800,800);
							c.remove(oRRPanel);
							c.add(restockPanel);
							repaint();
							revalidate();
							
						}
						
					});
/////////////////////////////////PROCESS CONTINUE///////////////////////////////					
					continueORR.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
					});
					c.remove(menuPanel);
					c.add(oRRPanel);
					repaint();
					revalidate();
						
					}
					
				});
///////////////////////////MANAGE PRODUCTS///////////////////////////////////////
				manageButton.addActionListener(new ActionListener() {
					JPanel managePanel = new JPanel();
					private JLabel manageText = new JLabel("Manage Products");
					private JButton addButton = new JButton("Add new product");
					private JButton removeButton = new JButton("Remove product");
					private JButton adjustButton = new JButton("Adjust Product Quantity");
					private JButton iOButton = new JButton("Inventory Optimization");
					private JButton updateButton = new JButton("Update Product Information");
					private JButton continueManage = new JButton("continue");
					
					private void manageProducts() {
						managePanel.removeAll();
						managePanel.add(manageText);
						managePanel.add(addButton);
						managePanel.add(removeButton);
						managePanel.add(adjustButton);
						managePanel.add(iOButton);
						managePanel.add(updateButton);
						managePanel.add(continueManage);
						repaint();
						revalidate();
					}
					
					@Override
					public void actionPerformed(ActionEvent click) {
						Component b = (Component) click.getSource();
						JFrame c = (JFrame) SwingUtilities.getRoot(b);
						manageProducts();
						c.setTitle("1nv3nt0ry-m4n4g3r: Manage Products");
						c.setSize(800,800);
/////////////////////////////////ADD NEW PRODUCT////////////////////////////////////////////////////////////
						addButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
						});
/////////////////////////////////REMOVE PRODUCT//////////////////////////////////////////////////////////////
						removeButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
						});
//////////////////////////////////ADJUST PRODUCT QUANTITY/////////////////////////////////////////////////////
						adjustButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
						});
////////////////////////////////INVENTORY OPTIMIZATION////////////////////////////////////////////////////////
						iOButton.addActionListener(new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
						});
						updateButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
						});
//////////////////////////////////CONTINUE MANAGE//////////////////////////////////////////////////////////////
						continueManage.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
						});
						c.remove(menuPanel);
						c.add(managePanel);
						repaint();
						revalidate();						
					}
					
				});
				
////////////////////////////MARKETING ANALYSIS//////////////////////////////////////////				
				marketingButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
			}
			
		});
		
		this.add(logInPanel);
	}
	
//	class ContinueListener implements ActionListener{
//		
//	}
	
}
