package frames;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Color;

public class AllFrames extends JFrame{
	public JPanel logInPanel = new JPanel();
	public JLabel instText = new JLabel("Please enter the following");
	public JTextField productText = new JTextField(15);
	public JTextField quantityText = new JTextField(15);
	public JTextField productID = new JTextField(40);
	public JTextField quantity = new JTextField(40);
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
								productText.setText("Product ID");
								productText.setBackground(new Color(204,255,153));
								quantityText.setText("Quantity");
								quantityText.setBackground(new Color(204,255,153));
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
							welcome.setText("Process Restock");
							restockPanel.add(welcome);
							restockPanel.add(instText);
							productText.setText("Product ID");
							productText.setBackground(new Color(204,255,153));
							quantityText.setText("Quantity");
							quantityText.setBackground(new Color(204,255,153));
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
					private JButton addButton = new JButton("Add new product");
					private JButton removeButton = new JButton("Remove product");
					private JButton adjustButton = new JButton("Adjust Product Quantity");
					private JButton iOButton = new JButton("Inventory Optimization");
					private JButton updateButton = new JButton("Update Product Information");
					private JButton continueManage = new JButton("continue");
					
					private void manageProducts() {
						managePanel.removeAll();
						welcome.setText("Manage Products");
						managePanel.add(welcome);
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
							JPanel removePanel = new JPanel();
							private JButton removeContinue = new JButton("continue");
							
							private void removeProduct() {
								removePanel.removeAll();
								welcome.setText("Remove Product");
								productText.setText("Product ID");
								productText.setBackground(new Color(204,255,153));
								
								removePanel.add(welcome);
								removePanel.add(instText);
								removePanel.add(productText);
								removePanel.add(productID);
								removePanel.add(removeContinue);
								
								repaint();
								revalidate();	
							}
							
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								removeProduct();
								c.setTitle("1nv3nt0ry-m4n4g3r: Remove Product");
								c.setSize(800,800);		
								c.remove(managePanel);
								c.add(removePanel);
								////insert if statements to validate input
								repaint();
								revalidate();
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
							JPanel ioPanel = new JPanel();
							private JTextField inst = new JTextField(60);
							private JTextField minInText = new JTextField(15);
							private JTextField maxInText = new JTextField(15);
							private JTextField min$Text = new JTextField(15);
							private JTextField max$Text = new JTextField(15);
							private JTextField minInventory = new JTextField(40);
							private JTextField maxInventory = new JTextField(40);
							private JTextField minPrice = new JTextField(40);
							private JTextField maxPrice = new JTextField(40);
							private JButton ioContinue = new JButton("continue");
							
							private void inventoryOptimization() {
								ioPanel.removeAll();
								welcome.setText("Inventory Optimization");
								inst.setText("Please enter the following. Leave blank for no change");
								inst.setBackground(new Color(102,204,102));
								productText.setText("Product ID");
								productText.setBackground(new Color(204,255,153));
								minInText.setText("Min inventory");
								minInText.setBackground(new Color(204,255,153));
								maxInText.setText("Max inventory");
								maxInText.setBackground(new Color(204,255,153));
								min$Text.setText("Min price");
								min$Text.setBackground(new Color(204,255,153));
								max$Text.setText("Max price");
								max$Text.setBackground(new Color(204,255,153));
								
								ioPanel.add(welcome);
								ioPanel.add(inst);
								ioPanel.add(productText);
								ioPanel.add(productID);
								ioPanel.add(minInText);
								ioPanel.add(minInventory);
								ioPanel.add(maxInText);
								ioPanel.add(maxInventory);
								ioPanel.add(min$Text);
								ioPanel.add(minPrice);
								ioPanel.add(max$Text);
								ioPanel.add(maxPrice);
								ioPanel.add(ioContinue);
								
								repaint();
								revalidate();
								
							}
							
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								inventoryOptimization();
								c.setTitle("1nv3nt0ry-m4n4g3r: Manage Products");
								c.setSize(800,800);
								c.remove(managePanel);
								c.add(ioPanel);
								repaint();
								revalidate();
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
						////insert if statements to check for null/errors
						repaint();
						revalidate();						
					}
					
				});
				
////////////////////////////MARKETING ANALYSIS//////////////////////////////////////////				
				marketingButton.addActionListener(new ActionListener() {
					JPanel marketPanel = new JPanel();
					private JLabel maWelcome = new JLabel("Marketing Analysis");
					private JButton continueMA = new JButton("continue");
					private JTextField startText = new JTextField(15);
					private JTextField endText = new JTextField(15);
					private JTextField startDate = new JTextField(50);
					private JTextField endDate = new JTextField(50);
					
					private void marketingAnalysis() {
						marketPanel.removeAll();
						marketPanel.add(maWelcome);
						marketPanel.add(instText);
						
						startText.setBackground(new Color(204,255,153));
						startText.setText("Start date");
						endText.setBackground(new Color(204,255,153));
						endText.setText("End date");
						
						marketPanel.add(startText);
						marketPanel.add(startDate);
						marketPanel.add(endText);
						marketPanel.add(endDate);
						marketPanel.add(continueMA);
						repaint();
						revalidate();
					}
					
					@Override
					public void actionPerformed(ActionEvent click) {
						Component b = (Component) click.getSource();
						JFrame c = (JFrame) SwingUtilities.getRoot(b);
						marketingAnalysis();
						c.setSize(800,800);
						c.setTitle("1nv3nt0ry-m4n4g3r: Marketing Analysis");
						c.remove(menuPanel);
						c.add(marketPanel);
						///insert if statements here to validate inputs
						repaint();
						revalidate();
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
