package frames;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;

public class AllFrames extends JFrame{
	
	static JPanel logInPanel = new JPanel();
	static JLabel instText = new JLabel("Please enter the following");
	static JTextField nameText = new JTextField(15);
	static JTextField productName = new JTextField(40);
	static JTextField inst = new JTextField(40);
	static JTextField productText = new JTextField(15);
	static JTextField quantityText = new JTextField(15);
	static JTextField productID = new JTextField(40);
	static JTextField quantity = new JTextField(40);
	static JTextField priceText = new JTextField(15);
	static JTextField price = new JTextField(40);
	static JTextField descText = new JTextField(15);
	static JTextField description = new JTextField(40);
	static JLabel welcome = new JLabel("WELCOME");
	static JLabel userText = new JLabel("username: ");
	static JLabel passText = new JLabel("password: ");
	static JTextField username = new JTextField(60);
	static JTextField password = new JTextField(60);
	static JButton continueLogIn = new JButton("continue");
	static JButton backButton = new JButton("BACK");
	static JButton backToManage = new JButton("Back");
	static JButton backToORR = new JButton("Back");
	static JButton backToMenu = new JButton("Back");
	
	
	
	public void logIn() {
		logInPanel.removeAll();
		clearTextFields();
		logInPanel.setBackground(new Color(255,255,204));
		
		welcome.setFont(new Font("Arial", Font.BOLD, 48));
		
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		SpringLayout layout = new SpringLayout();
		logInPanel.setLayout(layout);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,logInPanel);
		layout.putConstraint(SpringLayout.NORTH, welcome, 80, SpringLayout.NORTH, logInPanel);
		layout.putConstraint(SpringLayout.WEST, userText,60,SpringLayout.WEST, logInPanel);
		layout.putConstraint(SpringLayout.NORTH, userText, 200,SpringLayout.NORTH, logInPanel);
		layout.putConstraint(SpringLayout.WEST, username,60,SpringLayout.EAST, userText);
		layout.putConstraint(SpringLayout.NORTH, username,200,SpringLayout.NORTH, logInPanel);		
		layout.putConstraint(SpringLayout.WEST, passText,60,SpringLayout.WEST, logInPanel);
		layout.putConstraint(SpringLayout.NORTH, passText, 300,SpringLayout.NORTH, logInPanel);
		layout.putConstraint(SpringLayout.WEST, password,60,SpringLayout.EAST, passText);
		layout.putConstraint(SpringLayout.NORTH, password,300,SpringLayout.NORTH, logInPanel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueLogIn,0, SpringLayout.HORIZONTAL_CENTER,logInPanel);
		layout.putConstraint(SpringLayout.NORTH, continueLogIn, 380, SpringLayout.NORTH, logInPanel);
		
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
		inst.setEditable(false);
		this.setTitle("1nv3nt0ry-m4n4g3r: Log In Page");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		logIn();
/////////////////////////////////////MAIN MENU///////////////////////////////////////////////////////		
		continueLogIn.addActionListener(new ActionListener() {
			JPanel menuPanel=new JPanel();
			public JButton orderOrRestockButton = new JButton("Process Order or Restock");
			public JButton manageButton = new JButton("Manage Products");
			public JButton marketingButton = new JButton("Marketing Analysis");
			
			public void menu() {
				menuPanel.removeAll();
				clearTextFields();
				menuPanel.setBackground(new Color(255,255,204));
				
				backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
				orderOrRestockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				manageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				marketingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				
				menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
				welcome.setFont(new Font("Arial", Font.BOLD, 48));
				welcome.setText("Menu");
				backButton.setText("Log Out");
				backButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Component b = (Component) e.getSource();
						JFrame c = (JFrame) SwingUtilities.getRoot(b);
						logIn();
						if(c != null)
						{
							c.setTitle("1nv3nt0ry-m4n4g3r: Menu");
							c.setSize(800,800);
							c.remove(menuPanel);
							c.add(logInPanel);
							
							repaint();
							revalidate();
						}
						
						
					}
				});
				
				
				menuPanel.add(Box.createVerticalGlue());
				menuPanel.add(welcome);
				menuPanel.add(Box.createRigidArea(new Dimension(0,10)));
				menuPanel.add(orderOrRestockButton);
				menuPanel.add(Box.createRigidArea(new Dimension(0,10)));
				menuPanel.add(manageButton);
				menuPanel.add(Box.createRigidArea(new Dimension(0,10)));
				menuPanel.add(marketingButton);
				menuPanel.add(Box.createRigidArea(new Dimension(0,10)));
				menuPanel.add(backButton);
				menuPanel.add(Box.createVerticalGlue());
				
				repaint();
				revalidate();
			}
			
			@Override
			public void actionPerformed(ActionEvent click) {
				Component b = (Component) click.getSource();
				JFrame c = (JFrame) AllFrames.this;
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
					public JLabel orderORRestock = new JLabel("Process Order or Restock");
					public JButton orderButton = new JButton("Process Order");
					public JButton restockButton = new JButton("Process Restock");
					public JButton continueORR = new JButton("continue");
					public JLabel welcomeORR = new JLabel();
					
					public void oRR() {
						oRRPanel.removeAll();
						clearTextFields();
						oRRPanel.setBackground(new Color(255,255,204));
						
						welcomeORR.setFont(new Font("Arial", Font.BOLD, 48));
						welcomeORR.setText("Process Order or Restock");
						
						welcomeORR.setAlignmentX(Component.CENTER_ALIGNMENT);
						orderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						backToMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
						
						oRRPanel.setLayout(new BoxLayout(oRRPanel,BoxLayout.Y_AXIS));
						
						oRRPanel.add(Box.createVerticalGlue());
						oRRPanel.add(welcomeORR);
						oRRPanel.add(Box.createRigidArea(new Dimension(0,10)));
						oRRPanel.add(orderButton);
						oRRPanel.add(Box.createRigidArea(new Dimension(0,10)));
						oRRPanel.add(restockButton);
						oRRPanel.add(Box.createRigidArea(new Dimension(0,10)));
						oRRPanel.add(backToMenu);
						oRRPanel.add(Box.createVerticalGlue());
						
						backToMenu.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								menu();
								if (c != null) {
									c.setTitle("1nv3nt0ry-m4n4g3r: Menu");
									c.setSize(800,800);
									c.remove(((JButton)click.getSource()).getParent());
									c.add(menuPanel);
									
									repaint();
									revalidate();	
								}
															
							}
							
						});
						
						repaint();
						revalidate();
						
						
					}
					
					@Override
					public void actionPerformed(ActionEvent click) {
						Component b = (Component) click.getSource();
						JFrame c = (JFrame) SwingUtilities.getRoot(b);

						oRR();
						
						c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
						c.setSize(800,800);
						
////////////////////////////////PROCESS ORDER/////////////////////////////////////////////////////////
						orderButton.addActionListener(new ActionListener() {
							JPanel orderPanel = new JPanel();
							
							public JButton continueOrder = new JButton("continue");
							public JButton backOrder = new JButton("back");
							
							
							public void order() {
								orderPanel.removeAll();
								clearTextFields();
								orderPanel.setBackground(new Color(255,255,204));
								
								welcome.setFont(new Font("Arial", Font.BOLD, 48));
								welcome.setText("Process Order");
								productText.setText("Product ID");
								productText.setBackground(new Color(204,255,153));
								quantityText.setText("Quantity");
								quantityText.setBackground(new Color(204,255,153));
								
								SpringLayout orlayout = new SpringLayout();
								orderPanel.setLayout(orlayout);
								
								orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,orderPanel);
								orlayout.putConstraint(SpringLayout.NORTH, welcome, 80, SpringLayout.NORTH, orderPanel);
								orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, instText,0, SpringLayout.HORIZONTAL_CENTER,orderPanel);
								orlayout.putConstraint(SpringLayout.NORTH, instText, 150, SpringLayout.NORTH, orderPanel);
								orlayout.putConstraint(SpringLayout.WEST, productText,80,SpringLayout.WEST, orderPanel);
								orlayout.putConstraint(SpringLayout.NORTH, productText, 200,SpringLayout.NORTH, orderPanel);
								orlayout.putConstraint(SpringLayout.WEST, productID,80,SpringLayout.EAST, productText);
								orlayout.putConstraint(SpringLayout.NORTH,productID,200,SpringLayout.NORTH, orderPanel);
								orlayout.putConstraint(SpringLayout.WEST, quantityText,80,SpringLayout.WEST, orderPanel);
								orlayout.putConstraint(SpringLayout.NORTH, quantityText, 240,SpringLayout.NORTH, orderPanel);
								orlayout.putConstraint(SpringLayout.WEST, quantity,80,SpringLayout.EAST, quantityText);
								orlayout.putConstraint(SpringLayout.NORTH,quantity,240,SpringLayout.NORTH, orderPanel);
								orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueOrder,0, SpringLayout.HORIZONTAL_CENTER,orderPanel);
								orlayout.putConstraint(SpringLayout.NORTH, continueOrder, 280, SpringLayout.NORTH, orderPanel);
								orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backOrder,0, SpringLayout.HORIZONTAL_CENTER,orderPanel);
								orlayout.putConstraint(SpringLayout.NORTH, backOrder, 320, SpringLayout.NORTH, orderPanel);
								
								orderPanel.add(welcome);
								orderPanel.add(instText);
								orderPanel.add(productText);
								orderPanel.add(productID);
								orderPanel.add(quantityText);
								orderPanel.add(quantity);
								orderPanel.add(continueOrder);
								orderPanel.add(backOrder);
								
								repaint();
								revalidate();
								
							}
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								c.setTitle("1nv3nt0ry-m4n4g3r: Process Order");
								c.setSize(800,800);
								
								order();
								
								c.remove(oRRPanel);
								c.add(orderPanel);
								backOrder.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent click) {
										Component b = (Component) click.getSource();
										JFrame c = (JFrame) SwingUtilities.getRoot(b);
										menu();
										if (c != null) {
											c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
											c.setSize(800,800);
											c.remove(((JButton)click.getSource()).getParent());
											c.add(oRRPanel);
											repaint();
											revalidate();	
										}
									}
										
									
								});
								
								continueOrder.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent click) {
										//if input is invalid
										
										//if input is valid/////////////////////////////////////////////
										 Object[] options1 = { "Confirm", "Cancel"};

										 JPanel panel = new JPanel();
										 panel.add(new JLabel("Do you wish to confirm process order?"));

										 int result = JOptionPane.showOptionDialog(null, panel, "Confirm: Process Order",
							             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
										 if (result == JOptionPane.YES_OPTION){
									            JTextField confirmOrder = new JTextField(20);
									            confirmOrder.setEditable(false);
									            confirmOrder.setText("Order Processed");
									            orderPanel.removeAll();
									            order(); 
									            quantity.setEditable(false);
									            productID.setEditable(false);
									            orderPanel.add(confirmOrder);
									            orderPanel.remove(continueOrder);
									            c.add(orderPanel);
									            repaint();
									            revalidate();
									            
									        }
									}
									
								});
								
								repaint();
								revalidate();
							}
							
						});
////////////////////////PROCESS RESTOCK///////////////////////////////////////////
					restockButton.addActionListener(new ActionListener() {
						JPanel restockPanel = new JPanel();
						JLabel restockText = new JLabel("Process Restock");
						public JButton continueRestock = new JButton("continue");
						public JButton backRestock = new JButton("back");
						public void restock() {
							restockPanel.removeAll();
							clearTextFields();
							restockPanel.setBackground(new Color(255,255,204));
							
							welcome.setFont(new Font("Arial", Font.BOLD, 48));
							welcome.setText("Process Restock");
							
							SpringLayout orlayout = new SpringLayout();
							restockPanel.setLayout(orlayout);
							
							orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,restockPanel);
							orlayout.putConstraint(SpringLayout.NORTH, welcome, 80, SpringLayout.NORTH, restockPanel);
							orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, instText,0, SpringLayout.HORIZONTAL_CENTER,restockPanel);
							orlayout.putConstraint(SpringLayout.NORTH, instText, 150, SpringLayout.NORTH, restockPanel);
							orlayout.putConstraint(SpringLayout.WEST, productText,80,SpringLayout.WEST, restockPanel);
							orlayout.putConstraint(SpringLayout.NORTH, productText, 200,SpringLayout.NORTH, restockPanel);
							orlayout.putConstraint(SpringLayout.WEST, productID,80,SpringLayout.EAST, productText);
							orlayout.putConstraint(SpringLayout.NORTH,productID,200,SpringLayout.NORTH,restockPanel);
							orlayout.putConstraint(SpringLayout.WEST, quantityText,80,SpringLayout.WEST, restockPanel);
							orlayout.putConstraint(SpringLayout.NORTH, quantityText, 240,SpringLayout.NORTH, restockPanel);
							orlayout.putConstraint(SpringLayout.WEST, quantity,80,SpringLayout.EAST, quantityText);
							orlayout.putConstraint(SpringLayout.NORTH,quantity,240,SpringLayout.NORTH, restockPanel);
							orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueRestock,0, SpringLayout.HORIZONTAL_CENTER,restockPanel);
							orlayout.putConstraint(SpringLayout.NORTH, continueRestock, 280, SpringLayout.NORTH, restockPanel);
							orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueRestock,0, SpringLayout.HORIZONTAL_CENTER,restockPanel);
							orlayout.putConstraint(SpringLayout.NORTH, continueRestock, 280, SpringLayout.NORTH, restockPanel);
							orlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backRestock,0, SpringLayout.HORIZONTAL_CENTER,restockPanel);
							orlayout.putConstraint(SpringLayout.NORTH, backRestock, 320, SpringLayout.NORTH, restockPanel);
							
							
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
							restockPanel.add(backRestock);
							backRestock.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent click) {
									Component b = (Component) click.getSource();
									JFrame c = (JFrame) SwingUtilities.getRoot(b);
									menu();
									if (c != null) {
										c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
										c.setSize(800,800);
										c.remove(((JButton)click.getSource()).getParent());
										c.add(oRRPanel);
									
										repaint();
										revalidate();	
									}
									
								}
								
							});
							
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
							continueRestock.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									Object[] options1 = { "Confirm", "Cancel"};

									 JPanel panel = new JPanel();
									 panel.add(new JLabel("Do you wish to confirm process restock?"));

									 int result = JOptionPane.showOptionDialog(null, panel, "Confirm: Process Restock",
						             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
									 if (result == JOptionPane.YES_OPTION){
								            JTextField confirmRe = new JTextField(20);
								            confirmRe.setEditable(false);
								            confirmRe.setText("Order Restocked");
								            restockPanel.removeAll();
								            restock(); 
								            quantity.setEditable(false);
								            productID.setEditable(false);
								            restockPanel.add(confirmRe);
								            restockPanel.remove(continueRestock);
								            c.add(restockPanel);
								            repaint();
								            revalidate();
								            
								        }
								}
								
							});
							
						
							repaint();
							revalidate();
							
						}
						
					});
/////////////////////////////////PROCESS CONTINUE///////////////////////////////					
					
					
					c.remove(menuPanel);
					c.add(oRRPanel);
					
					repaint();
					revalidate();
						
					}
					
				});
///////////////////////////MANAGE PRODUCTS///////////////////////////////////////
				manageButton.addActionListener(new ActionListener() {
					JPanel managePanel = new JPanel();
					public JButton addButton = new JButton("Add new product");
					public JButton removeButton = new JButton("Remove product");
					public JButton adjustButton = new JButton("Adjust Product Quantity");
					public JButton iOButton = new JButton("Inventory Optimization");
					public JButton updateButton = new JButton("Update Product Information");
					public JButton backManage = new JButton("Back");
					
					public void manageProducts() {
						managePanel.removeAll();
						clearTextFields();
						managePanel.setBackground(new Color(255,255,204));
						
						welcome.setFont(new Font("Arial", Font.BOLD, 48));
						welcome.setText("Manage Products");
						
						addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
						removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						adjustButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						iOButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						backManage.setAlignmentX(Component.CENTER_ALIGNMENT);
						
						managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.Y_AXIS));
						
						managePanel.add(Box.createVerticalGlue());
						managePanel.add(welcome);
						managePanel.add(Box.createRigidArea(new Dimension(0,10)));
						managePanel.add(addButton);
						managePanel.add(Box.createRigidArea(new Dimension(0,10)));
						managePanel.add(removeButton);
						managePanel.add(Box.createRigidArea(new Dimension(0,10)));
						managePanel.add(adjustButton);
						managePanel.add(Box.createRigidArea(new Dimension(0,10)));
						managePanel.add(iOButton);
						managePanel.add(Box.createRigidArea(new Dimension(0,10)));
						managePanel.add(updateButton);
						managePanel.add(Box.createRigidArea(new Dimension(0,10)));
						managePanel.add(backManage);
						managePanel.add(Box.createVerticalGlue());
						
						backManage.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								menu();
								if (c != null) {
									c.setTitle("1nv3nt0ry-m4n4g3r: Menu");
									c.setSize(800,800);
									c.remove(((JButton)click.getSource()).getParent());
									c.add(menuPanel);
									
									repaint();
									revalidate();		
								}
							}
							
						});

								
					
						
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
							JPanel addPanel = new JPanel();
							public JButton continueAdd = new JButton("continue");
							public JButton backAdd = new JButton("back");
							
							public void addProduct() {
								addPanel.removeAll();
								clearTextFields();
								addPanel.setBackground(new Color(255,255,204));
								
								welcome.setFont(new Font("Arial", Font.BOLD, 48));
								welcome.setText("Add New Product");
								inst.setText("Please enter the following");
								inst.setBackground(new Color(102,204,102));
								nameText.setText("Product Name");
								nameText.setBackground(new Color(204,255,153));
								quantityText.setText("Quantity");
								quantityText.setBackground(new Color(204,255,153));
								priceText.setText("Price");
								priceText.setBackground(new Color(204,255,153));
								descText.setText("Description");
								descText.setBackground(new Color(204,255,153));
								productText.setText("Product ID");
								productText.setBackground(new Color(204,255,153));
								productID.setBackground(new Color(0,0,0));
								productID.setEditable(false);
								
								SpringLayout addlayout = new SpringLayout();
								addPanel.setLayout(addlayout);
								
								addlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, welcome, 95, SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, inst,0, SpringLayout.HORIZONTAL_CENTER,addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, inst, 150, SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, nameText,95,SpringLayout.WEST, addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, nameText, 200,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, productName,95,SpringLayout.EAST, nameText);
								addlayout.putConstraint(SpringLayout.NORTH,productName,200,SpringLayout.NORTH,addPanel);
								addlayout.putConstraint(SpringLayout.WEST, quantityText,95,SpringLayout.WEST, addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, quantityText, 240,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, quantity,95,SpringLayout.EAST, quantityText);
								addlayout.putConstraint(SpringLayout.NORTH,quantity,240,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, priceText,95,SpringLayout.WEST, addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, priceText, 280,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, price,95,SpringLayout.EAST, priceText);
								addlayout.putConstraint(SpringLayout.NORTH,price,280,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, descText,95,SpringLayout.WEST, addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, descText, 320,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, description,95,SpringLayout.EAST, descText);
								addlayout.putConstraint(SpringLayout.NORTH, description,320,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, productText,95,SpringLayout.WEST, addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, productText, 360,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.WEST, productID,95,SpringLayout.EAST, descText);
								addlayout.putConstraint(SpringLayout.NORTH, productID,360,SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueAdd,0, SpringLayout.HORIZONTAL_CENTER,addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, continueAdd, 400, SpringLayout.NORTH, addPanel);
								addlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backAdd,0, SpringLayout.HORIZONTAL_CENTER,addPanel);
								addlayout.putConstraint(SpringLayout.NORTH, backAdd, 440, SpringLayout.NORTH, addPanel);
								
								
								addPanel.add(welcome);
								addPanel.add(inst);
								addPanel.add(nameText);
								addPanel.add(productName);
								addPanel.add(quantityText);
								addPanel.add(quantity);
								addPanel.add(priceText);
								addPanel.add(price);
								addPanel.add(descText);
								addPanel.add(description);
								addPanel.add(productText);
								addPanel.add(productID);
								addPanel.add(continueAdd);
								addPanel.add(backAdd);
								
								backAdd.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent click) {
										Component b = (Component) click.getSource();
										JFrame c = (JFrame) SwingUtilities.getRoot(b);
										manageProducts();
										if (c != null) {
											c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
											c.setSize(800,800);
											c.remove(((JButton)click.getSource()).getParent());
											c.add(managePanel);
											
											repaint();
											revalidate();	
										}
										
									}
								});
								repaint();
								revalidate();
							}
							
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								addProduct();
								c.setTitle("1nv3nt0ry-m4n4g3r: Add New Product");
								c.setSize(800,800);		
								c.remove(managePanel);
								c.add(addPanel);
								continueAdd.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent click) {
										//if input is invalid
										
										//if input is valid/////////////////////////////////////////////
										 Object[] options1 = { "Confirm", "Cancel"};

										 JPanel panel = new JPanel();
										 panel.add(new JLabel("Do you wish to confirm adding a product?"));

										 int result = JOptionPane.showOptionDialog(null, panel, "Confirm: Add New Product",
							             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
										 if (result == JOptionPane.YES_OPTION){
									            JTextField confirmAdd = new JTextField(20);
									            confirmAdd.setEditable(false);
									            confirmAdd.setText("Product ID GENERATED");
									            addPanel.removeAll();
									            addProduct();
									            productName.setEditable(false);
									            quantity.setEditable(false);
									            price.setEditable(false);
									            description.setEditable(false);
									            productID.setBackground(new Color(240,240,240));
									            productID.setText("Insert User Input HERE");
									            productID.setEditable(false);
									            addPanel.add(confirmAdd);
									            addPanel.remove(continueAdd);
									            c.add(addPanel);
									            repaint();
									            revalidate();
									            
									        }
									}
									
								});
								////insert if statements to validate input
								repaint();
								revalidate();								
							}
							
						});
						
/////////////////////////////////REMOVE PRODUCT//////////////////////////////////////////////////////////////
						removeButton.addActionListener(new ActionListener() {
							JPanel removePanel = new JPanel();
							public JButton continueRemove = new JButton("continue");
							public JButton backRemove = new JButton("back");
							
							public void removeProduct() {
								removePanel.removeAll();
								clearTextFields();
								removePanel.setBackground(new Color(255,255,204));
								
								welcome.setFont(new Font("Arial", Font.BOLD, 48));
								welcome.setText("Remove Product");
								productText.setText("Product ID");
								productText.setBackground(new Color(204,255,153));
								
								SpringLayout remlayout = new SpringLayout();
								removePanel.setLayout(remlayout);
								
								remlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,removePanel);
								remlayout.putConstraint(SpringLayout.NORTH, welcome, 95, SpringLayout.NORTH, removePanel);
								remlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, instText,0, SpringLayout.HORIZONTAL_CENTER,removePanel);
								remlayout.putConstraint(SpringLayout.NORTH, instText, 150, SpringLayout.NORTH, removePanel);
								remlayout.putConstraint(SpringLayout.WEST, productText,95,SpringLayout.WEST, removePanel);
								remlayout.putConstraint(SpringLayout.NORTH, productText, 200,SpringLayout.NORTH, removePanel);
								remlayout.putConstraint(SpringLayout.WEST, productID,95,SpringLayout.EAST, productText);
								remlayout.putConstraint(SpringLayout.NORTH,productID,200,SpringLayout.NORTH,removePanel);
								remlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueRemove,0, SpringLayout.HORIZONTAL_CENTER,removePanel);
								remlayout.putConstraint(SpringLayout.NORTH, continueRemove, 240, SpringLayout.NORTH, removePanel);
								remlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backRemove,0, SpringLayout.HORIZONTAL_CENTER,removePanel);
								remlayout.putConstraint(SpringLayout.NORTH, backRemove, 280, SpringLayout.NORTH, removePanel);
								
								removePanel.add(welcome);
								removePanel.add(instText);
								removePanel.add(productText);
								removePanel.add(productID);
								removePanel.add(continueRemove);
								removePanel.add(backRemove);
								
								backRemove.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent click) {
										Component b = (Component) click.getSource();
										JFrame c = (JFrame) SwingUtilities.getRoot(b);
										manageProducts();
										if (c != null) {
											c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
											c.setSize(800,800);
											c.remove(((JButton)click.getSource()).getParent());
											c.add(managePanel);
											
											repaint();
											revalidate();	
										}
									}
								});
								
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
								continueRemove.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent arg0) {
										Object[] options1 = { "Confirm", "Cancel"};

										 JPanel panel = new JPanel();
										 panel.add(new JLabel("Do you wish to confirm removing a product?"));

										 int result = JOptionPane.showOptionDialog(null, panel, "Confirm: Remove Product",
							             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
										 if (result == JOptionPane.YES_OPTION){
									            JTextField confirmRem = new JTextField(20);
									            confirmRem.setEditable(false);
									            confirmRem.setText("Product Removed");
									            removePanel.removeAll();
									            removeProduct();
									            removePanel.add(confirmRem);
									            c.add(removePanel);
									            productID.setText("ID Destroyed");
									            productID.setEditable(false);
									            removePanel.remove(continueRemove);
									            repaint();
									            revalidate();
										 }
									}
									
								});
								////insert if statements to validate input
								repaint();
								revalidate();
							}
							
						});
						
//////////////////////////////////ADJUST PRODUCT QUANTITY/////////////////////////////////////////////////////
						adjustButton.addActionListener(new ActionListener() {
							JPanel adjustPanel = new JPanel();
							public JButton continueAdjust = new JButton("continue");
							public JButton backAdjust = new JButton("back");
							
							public void adjustProductQuantity() {
								adjustPanel.removeAll();
								clearTextFields();
								adjustPanel.setBackground(new Color(255,255,204));
								
								welcome.setFont(new Font("Arial", Font.BOLD, 48));
								welcome.setText("Adjust Product Quantity");
								inst.setText("Please enter the following");
								inst.setBackground(new Color(102,204,102));
								productText.setText("Product ID");
								productText.setBackground(new Color(204,255,153));
								quantityText.setText("Quantity");
								quantityText.setBackground(new Color(204,255,153));
								
								SpringLayout adjlayout = new SpringLayout();
								adjustPanel.setLayout(adjlayout);
								
								adjlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,adjustPanel);
								adjlayout.putConstraint(SpringLayout.NORTH, welcome, 80, SpringLayout.NORTH, adjustPanel);
								adjlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, inst,0, SpringLayout.HORIZONTAL_CENTER,adjustPanel);
								adjlayout.putConstraint(SpringLayout.NORTH, inst, 150, SpringLayout.NORTH, adjustPanel);
								adjlayout.putConstraint(SpringLayout.WEST, productText,95,SpringLayout.WEST, adjustPanel);
								adjlayout.putConstraint(SpringLayout.NORTH, productText, 200,SpringLayout.NORTH, adjustPanel);
								adjlayout.putConstraint(SpringLayout.WEST, productID,95,SpringLayout.EAST, productText);
								adjlayout.putConstraint(SpringLayout.NORTH,productID,200,SpringLayout.NORTH,adjustPanel);
								adjlayout.putConstraint(SpringLayout.WEST, quantityText,95,SpringLayout.WEST, adjustPanel);
								adjlayout.putConstraint(SpringLayout.NORTH, quantityText, 240,SpringLayout.NORTH, adjustPanel);
								adjlayout.putConstraint(SpringLayout.WEST, quantity,95,SpringLayout.EAST, quantityText);
								adjlayout.putConstraint(SpringLayout.NORTH,quantity,240,SpringLayout.NORTH, adjustPanel);
								adjlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueAdjust,0, SpringLayout.HORIZONTAL_CENTER,adjustPanel);
								adjlayout.putConstraint(SpringLayout.NORTH, continueAdjust, 280, SpringLayout.NORTH, adjustPanel);
								adjlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backAdjust,0, SpringLayout.HORIZONTAL_CENTER,adjustPanel);
								adjlayout.putConstraint(SpringLayout.NORTH, backAdjust, 320, SpringLayout.NORTH, adjustPanel);
								
								adjustPanel.add(welcome);
								adjustPanel.add(inst);
								adjustPanel.add(productText);
								adjustPanel.add(productID);
								adjustPanel.add(quantityText);
								adjustPanel.add(quantity);
								adjustPanel.add(continueAdjust);
								adjustPanel.add(backAdjust);
								
								backAdjust.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent click) {
										Component b = (Component) click.getSource();
										JFrame c = (JFrame) SwingUtilities.getRoot(b);
										manageProducts();
										if (c != null) {
											c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
											c.setSize(800,800);
											c.remove(((JButton)click.getSource()).getParent());
											c.add(managePanel);
											
											repaint();
											revalidate();
										}
											
									}
								});
								
								repaint();
								revalidate();
							}
							
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								adjustProductQuantity();
								c.setTitle("1nv3nt0ry-m4n4g3r: Adjust Product Quantity");
								c.setSize(800,800);
								c.remove(managePanel);
								c.add(adjustPanel);		
								///if statements to validate input
								continueAdjust.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent arg0) {
										Object[] options1 = { "Confirm", "Cancel"};

										 JPanel panel = new JPanel();
										 panel.add(new JLabel("Do you wish to confirm adjusting product quantity?"));

										 int result = JOptionPane.showOptionDialog(null, panel, "Confirm: Adjust Product Quantity",
							             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
										 if (result == JOptionPane.YES_OPTION){
									            JTextField confirmAdjust = new JTextField(20);
									            confirmAdjust.setEditable(false);
									            confirmAdjust.setText("Product Quantity Adjusted");
									            adjustPanel.removeAll();
									            adjustProductQuantity();
									            adjustPanel.add(confirmAdjust);
									            c.add(adjustPanel);
									            quantity.setEditable(false);
									            productID.setEditable(false);
									            adjustPanel.remove(continueAdjust);
									            repaint();
									            revalidate();
										 }
									}
									
								});
								repaint();
								revalidate();
							}
							
						});
						
						
						
////////////////////////////////INVENTORY OPTIMIZATION////////////////////////////////////////////////////////
						iOButton.addActionListener(new ActionListener () {
							JPanel ioPanel = new JPanel();
							public JTextField minInText = new JTextField(15);
							public JTextField maxInText = new JTextField(15);
							public JTextField min$Text = new JTextField(15);
							public JTextField max$Text = new JTextField(15);
							public JTextField minInventory = new JTextField(40);
							public JTextField maxInventory = new JTextField(40);
							public JTextField minPrice = new JTextField(40);
							public JTextField maxPrice = new JTextField(40);
							public JButton continueIO = new JButton("continue");
							public JButton backIO = new JButton("back");
							
							public void inventoryOptimization() {
								ioPanel.removeAll();
								clearTextFields();
								ioPanel.setBackground(new Color(255,255,204));
								
								welcome.setFont(new Font("Arial", Font.BOLD, 48));
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
								
								SpringLayout iolayout = new SpringLayout();
								ioPanel.setLayout(iolayout);
								
								iolayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, welcome, 80, SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, inst,0, SpringLayout.HORIZONTAL_CENTER,ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, inst, 150, SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, productText,95,SpringLayout.WEST, ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, productText, 200,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, productID,95,SpringLayout.EAST, productText);
								iolayout.putConstraint(SpringLayout.NORTH,productID,200,SpringLayout.NORTH,ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, minInText,95,SpringLayout.WEST, ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, minInText, 240,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, minInventory,95,SpringLayout.EAST, minInText);
								iolayout.putConstraint(SpringLayout.NORTH,minInventory,240,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, maxInText,95,SpringLayout.WEST, ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, maxInText, 280,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, maxInventory,95,SpringLayout.EAST, maxInText);
								iolayout.putConstraint(SpringLayout.NORTH,maxInventory,280,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, min$Text,95,SpringLayout.WEST, ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, min$Text, 320,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, minPrice,95,SpringLayout.EAST, min$Text);
								iolayout.putConstraint(SpringLayout.NORTH,minPrice,320,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, max$Text,95,SpringLayout.WEST, ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, max$Text, 360,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.WEST, maxPrice,95,SpringLayout.EAST, max$Text);
								iolayout.putConstraint(SpringLayout.NORTH,maxPrice,360,SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueIO,0, SpringLayout.HORIZONTAL_CENTER,ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, continueIO, 400, SpringLayout.NORTH, ioPanel);
								iolayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backIO,0, SpringLayout.HORIZONTAL_CENTER,ioPanel);
								iolayout.putConstraint(SpringLayout.NORTH, backIO, 440, SpringLayout.NORTH, ioPanel);
								
								
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
								ioPanel.add(continueIO);
								ioPanel.add(backIO);
								
								backIO.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent click) {
										Component b = (Component) click.getSource();
										JFrame c = (JFrame) SwingUtilities.getRoot(b);
										manageProducts();
										if (c != null) {
											c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
											c.setSize(800,800);
											c.remove(((JButton)click.getSource()).getParent());
											c.add(managePanel);
											
											repaint();
											revalidate();	
										}
										
									}
								});
								
								repaint();
								revalidate();
							}
							
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								inventoryOptimization();
								c.setTitle("1nv3nt0ry-m4n4g3r: Inventory Optimization");
								c.setSize(800,800);
								c.remove(managePanel);
								c.add(ioPanel);
								
								continueIO.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent click) {
										Object[] options1 = { "Confirm", "Cancel"};

										 JPanel panel = new JPanel();
										 panel.add(new JLabel("Do you wish to confirm inventory optimization?"));

										 int result = JOptionPane.showOptionDialog(null, panel, "Confirm: Inventory Optimization",
							             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
										 if (result == JOptionPane.YES_OPTION){
									            JTextField confirmOp = new JTextField(20);
									            confirmOp.setEditable(false);
									            confirmOp.setText("Inventory Optimized");
									            ioPanel.removeAll();
									            inventoryOptimization();
									            ioPanel.add(confirmOp);
									            c.add(ioPanel);
									            minInventory.setEditable(false);
									            maxInventory.setEditable(false);
									            minPrice.setEditable(false);
									            maxPrice.setEditable(false);
									            productID.setEditable(false);
									            ioPanel.remove(continueIO);
									            repaint();
									            revalidate();
										 }
										
									}
									
								});
								
								repaint();
								revalidate();
							}
							
						});
						
///////////////////////////UPDATE PRODUCT INFO///////////////////////////////////////////
						updateButton.addActionListener(new ActionListener() {
							JPanel updatePanel = new JPanel();
							public JButton continueUpdate = new JButton("continue");
							public JButton backUpdate = new JButton("back");
							
							public void updateProductInfo() {
								updatePanel.removeAll();
								clearTextFields();
								updatePanel.setBackground(new Color(255,255,204));
								
								welcome.setFont(new Font("Arial", Font.BOLD, 48));
								welcome.setText("Update Product Information");
								inst.setText("Please enter the following. Leave blank for no change");
								inst.setBackground(new Color(102,204,102));
								productText.setText("Product ID");
								productText.setBackground(new Color(204,255,153));
								nameText.setText("Product Name");
								nameText.setBackground(new Color(204,255,153));
								priceText.setText("Price");
								priceText.setBackground(new Color(204,255,153));
								descText.setText("Description");
								descText.setBackground(new Color(204,255,153));
								
								SpringLayout uplayout = new SpringLayout();
								updatePanel.setLayout(uplayout);
								
								uplayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,updatePanel);
								uplayout.putConstraint(SpringLayout.NORTH, welcome, 80, SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, inst,0, SpringLayout.HORIZONTAL_CENTER,updatePanel);
								uplayout.putConstraint(SpringLayout.NORTH, inst, 150, SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.WEST, productText,95,SpringLayout.WEST, updatePanel);
								uplayout.putConstraint(SpringLayout.NORTH, productText, 200,SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.WEST, productID,95,SpringLayout.EAST, productText);
								uplayout.putConstraint(SpringLayout.NORTH,productID,200,SpringLayout.NORTH,updatePanel);
								uplayout.putConstraint(SpringLayout.WEST, nameText,95,SpringLayout.WEST, updatePanel);
								uplayout.putConstraint(SpringLayout.NORTH, nameText, 240,SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.WEST, productName,95,SpringLayout.EAST, nameText);
								uplayout.putConstraint(SpringLayout.NORTH,productName,240,SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.WEST, priceText,95,SpringLayout.WEST, updatePanel);
								uplayout.putConstraint(SpringLayout.NORTH, priceText, 280,SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.WEST, price,95,SpringLayout.EAST, priceText);
								uplayout.putConstraint(SpringLayout.NORTH,price,280,SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.WEST, descText,95,SpringLayout.WEST, updatePanel);
								uplayout.putConstraint(SpringLayout.NORTH, descText, 320,SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.WEST, description,95,SpringLayout.EAST, descText);
								uplayout.putConstraint(SpringLayout.NORTH,description,320,SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueUpdate,0, SpringLayout.HORIZONTAL_CENTER,updatePanel);
								uplayout.putConstraint(SpringLayout.NORTH, continueUpdate, 360, SpringLayout.NORTH, updatePanel);
								uplayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backUpdate,0, SpringLayout.HORIZONTAL_CENTER,updatePanel);
								uplayout.putConstraint(SpringLayout.NORTH, backUpdate, 400, SpringLayout.NORTH, updatePanel);
								
								
								updatePanel.add(welcome);
								updatePanel.add(inst);
								updatePanel.add(productText);
								updatePanel.add(productID);
								updatePanel.add(nameText);
								updatePanel.add(productName);
								updatePanel.add(priceText);
								updatePanel.add(price);
								updatePanel.add(descText);
								updatePanel.add(description);
								updatePanel.add(continueUpdate);
								updatePanel.add(backUpdate);
								
								backUpdate.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent click) {
										
										Component b = (Component) click.getSource();
										JFrame c = (JFrame) SwingUtilities.getRoot(b);
										manageProducts();
										if (c != null) {
											c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
											c.setSize(800,800);
											c.remove(((JButton)click.getSource()).getParent());
											c.add(managePanel);
											
											repaint();
											revalidate();	
										}
										
									}
								});
								
								repaint();
								revalidate();
								
							}
							
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								updateProductInfo();
								c.setTitle("1nv3nt0ry-m4n4g3r: Update Product Information");
								c.setSize(800,800);
								c.remove(managePanel);
								c.add(updatePanel);		
								///if statements to validate input
								continueUpdate.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent arg0) {
																				
										Object[] options1 = { "Confirm", "Cancel"};

										 JPanel panel = new JPanel();
										 panel.add(new JLabel("Do you wish to confirm updating product information ?"));

										 int result = JOptionPane.showOptionDialog(null, panel, "Confirm: Update Product Information",
							             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
										 if (result == JOptionPane.YES_OPTION){
									            JTextField confirmOp = new JTextField(20);
									            confirmOp.setEditable(false);
									            confirmOp.setText("Information Updated");
									            updatePanel.removeAll();
									            updateProductInfo();
									            updatePanel.add(confirmOp);
									            c.add(updatePanel);
									            productID.setEditable(false);
									            productName.setEditable(false);
									            price.setEditable(false);
									            description.setEditable(false);
									            updatePanel.remove(continueUpdate);
									            repaint();
									            revalidate();
										 }
										
									}
									
								});
								repaint();
								revalidate();
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
					
					public JButton continueMA = new JButton("continue");
					public JTextField startText = new JTextField(15);
					public JTextField endText = new JTextField(15);
					public JTextField startDate = new JTextField(40);
					public JTextField endDate = new JTextField(40);
					public JButton backMA = new JButton("Back");
					
					public void marketingAnalysis() {
						marketPanel.removeAll();
						clearTextFields();
						marketPanel.setBackground(new Color(255,255,204));
						
						welcome.setFont(new Font("Arial", Font.BOLD, 48));
						welcome.setText("Marketing Analysis");
						productText.setText("Product ID");
						productText.setBackground(new Color(204,255,153));
						startText.setBackground(new Color(204,255,153));
						startText.setText("Start date");
						endText.setBackground(new Color(204,255,153));
						endText.setText("End date");
						
						SpringLayout marketlayout = new SpringLayout();
						marketPanel.setLayout(marketlayout);
						
						marketlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, welcome,0, SpringLayout.HORIZONTAL_CENTER,marketPanel);
						marketlayout.putConstraint(SpringLayout.NORTH, welcome, 80, SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, instText,0, SpringLayout.HORIZONTAL_CENTER,marketPanel);
						marketlayout.putConstraint(SpringLayout.NORTH, instText, 150, SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.WEST, productText,95,SpringLayout.WEST, marketPanel);
						marketlayout.putConstraint(SpringLayout.NORTH, productText, 200,SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.WEST, productID,95,SpringLayout.EAST, productText);
						marketlayout.putConstraint(SpringLayout.NORTH,productID,200,SpringLayout.NORTH,marketPanel);
						marketlayout.putConstraint(SpringLayout.WEST, startText,95,SpringLayout.WEST, marketPanel);
						marketlayout.putConstraint(SpringLayout.NORTH, startText, 240,SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.WEST, startDate,95,SpringLayout.EAST, startText);
						marketlayout.putConstraint(SpringLayout.NORTH,startDate,240,SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.WEST, endText,95, SpringLayout.WEST,marketPanel);
						marketlayout.putConstraint(SpringLayout.NORTH, endText, 280, SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.WEST, endDate,95,SpringLayout.EAST, endText);
						marketlayout.putConstraint(SpringLayout.NORTH,endDate,280,SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueMA,0, SpringLayout.HORIZONTAL_CENTER,marketPanel);
						marketlayout.putConstraint(SpringLayout.NORTH, continueMA, 320, SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backToMenu,0, SpringLayout.HORIZONTAL_CENTER,marketPanel);
						marketlayout.putConstraint(SpringLayout.NORTH, backToMenu, 360, SpringLayout.NORTH, marketPanel);
						marketlayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backMA,0, SpringLayout.HORIZONTAL_CENTER,marketPanel);
						marketlayout.putConstraint(SpringLayout.NORTH, backMA, 400, SpringLayout.NORTH, marketPanel);
						
						marketPanel.add(welcome);
						marketPanel.add(instText);
						marketPanel.add(productText);
						marketPanel.add(productID);
						marketPanel.add(startText);
						marketPanel.add(startDate);
						marketPanel.add(endText);
						marketPanel.add(endDate);
						marketPanel.add(continueMA);
						marketPanel.add(backMA);
						
						backMA.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent click) {
								Component b = (Component) click.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								menu();
								if (c != null) {
								c.setTitle("1nv3nt0ry-m4n4g3r: Process Order or Restock");
									c.setSize(800,800);
									c.remove(((JButton)click.getSource()).getParent());
									c.add(menuPanel);
									
									repaint();
									revalidate();	
								}
								
							}
						});
						
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
						continueMA.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								Object[] options1 = { "Confirm", "Cancel"};

								 JPanel panel = new JPanel();
								 panel.add(new JLabel("Do you wish to confirm marketing analysis?"));

								 int result = JOptionPane.showOptionDialog(null, panel, "Confirm: Marketing Analysis",
					             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options1, null);
								 if (result == JOptionPane.YES_OPTION){
							            JTextField confirmOrder = new JTextField(20);
							            confirmOrder.setEditable(false);
							            confirmOrder.setText("MARKETING ANALYSIS");
							            marketPanel.removeAll();
							            marketingAnalysis(); 
							            startDate.setEditable(false);
							            endDate.setEditable(false);
							            productID.setEditable(false);
							            marketPanel.add(confirmOrder);
							            marketPanel.remove(continueMA);
							            c.add(marketPanel);
							            repaint();
							            revalidate();
							            
							        }
							}
							
						});
						repaint();
						revalidate();
					}
					
				});
				
			}
			
		});
		
		this.add(logInPanel);
	}
	
	public static void clearTextFields() {

		productName.setText("");
		productName.setEditable(true);
		inst.setText("");
		inst.setEditable(true);
		productID.setText("");
		productID.setEditable(true);
		quantity.setText("");
		quantity.setEditable(true);
		price.setText("");
		price.setEditable(true);
		description.setText("");
		description.setEditable(true);
	}
	
}


	

