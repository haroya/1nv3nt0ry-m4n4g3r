package frames;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;

public class AllFrames extends JFrame{
	public JPanel logInPanel = new JPanel();
	public JLabel instText = new JLabel("Please enter the following");
	public JTextField nameText = new JTextField(15);
	public JTextField productName = new JTextField(40);
	public JTextField inst = new JTextField(40);
	public JTextField productText = new JTextField(15);
	public JTextField quantityText = new JTextField(15);
	public JTextField productID = new JTextField(40);
	public JTextField quantity = new JTextField(40);
	public JTextField priceText = new JTextField(15);
	public JTextField price = new JTextField(40);
	public JTextField descText = new JTextField(15);
	public JTextField description = new JTextField(40);
	protected JLabel welcome = new JLabel("WELCOME");
	protected JLabel userText = new JLabel("username: ");
	protected JLabel passText = new JLabel("password: ");
	protected JTextField username = new JTextField(60);
	protected JTextField password = new JTextField(60);
	protected JButton continueLogIn = new JButton("continue");
	protected JButton backButton = new JButton("BACK");
//	protected ActionListener continueListen = new ContinueListener();
	
	public void logIn() {
		logInPanel.removeAll();
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
			private JButton orderOrRestockButton = new JButton("Process Order or Restock");
			private JButton manageButton = new JButton("Manage Products");
			private JButton marketingButton = new JButton("Marketing Analysis");
			private JButton continueMenu = new JButton("continue");
			
			private void menu() {
				menuPanel.removeAll();
				
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
						c.setTitle("1nv3nt0ry-m4n4g3r: Menu");
						c.setSize(800,800);
						c.remove(menuPanel);
						c.add(logInPanel);
						
						repaint();
						revalidate();
						
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
						oRRPanel.setBackground(new Color(255,255,204));
						
						welcome.setFont(new Font("Arial", Font.BOLD, 48));
						welcome.setText("Process Order or Restock");
						
						welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
						orderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
						
						oRRPanel.setLayout(new BoxLayout(oRRPanel,BoxLayout.Y_AXIS));
						
						oRRPanel.add(Box.createVerticalGlue());
						oRRPanel.add(welcome);
						oRRPanel.add(Box.createRigidArea(new Dimension(0,10)));
						oRRPanel.add(orderButton);
						oRRPanel.add(Box.createRigidArea(new Dimension(0,10)));
						oRRPanel.add(restockButton);
						oRRPanel.add(Box.createRigidArea(new Dimension(0,10)));
						oRRPanel.add(backButton);
						oRRPanel.add(Box.createVerticalGlue());
						
						repaint();
						revalidate();
						
						backButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								
								Component b = (Component) e.getSource();
								JFrame c = (JFrame) SwingUtilities.getRoot(b);
								menu();
								c.setTitle("1nv3nt0ry-m4n4g3r: Menu");
								c.setSize(800,800);
								c.remove(oRRPanel);
								c.add(menuPanel);
								
								repaint();
								revalidate();
													
							}
						});
						
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
							
							private JButton continueOrder = new JButton("continue");
							
							private void order() {
								orderPanel.removeAll();
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
								
								orderPanel.add(welcome);
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
								c.setTitle("1nv3nt0ry-m4n4g3r: Process Order");
								c.setSize(800,800);
								
								order();
								
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
					private JButton backManage = new JButton("Back");
					
					private void manageProducts() {
						managePanel.removeAll();
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
							private JButton continueAdd = new JButton("continue");
							
							private void addProduct() {
								addPanel.removeAll();
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
								////insert if statements to validate input
								repaint();
								revalidate();								
							}
							
						});
						
/////////////////////////////////REMOVE PRODUCT//////////////////////////////////////////////////////////////
						removeButton.addActionListener(new ActionListener() {
							JPanel removePanel = new JPanel();
							private JButton continueRemove = new JButton("continue");
							
							private void removeProduct() {
								removePanel.removeAll();
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
								remlayout.putConstraint(SpringLayout.NORTH, continueRemove, 280, SpringLayout.NORTH, removePanel);
								
								removePanel.add(welcome);
								removePanel.add(instText);
								removePanel.add(productText);
								removePanel.add(productID);
								removePanel.add(continueRemove);
								
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
							JPanel adjustPanel = new JPanel();
							private JButton continueAdjust = new JButton("continue");
							
							private void adjustProductQuantity() {
								adjustPanel.removeAll();
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
								
								adjustPanel.add(welcome);
								adjustPanel.add(inst);
								adjustPanel.add(productText);
								adjustPanel.add(productID);
								adjustPanel.add(quantityText);
								adjustPanel.add(quantity);
								adjustPanel.add(continueAdjust);
								
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
								repaint();
								revalidate();
							}
							
						});
						
						
						
////////////////////////////////INVENTORY OPTIMIZATION////////////////////////////////////////////////////////
						iOButton.addActionListener(new ActionListener () {
							JPanel ioPanel = new JPanel();
							private JTextField minInText = new JTextField(15);
							private JTextField maxInText = new JTextField(15);
							private JTextField min$Text = new JTextField(15);
							private JTextField max$Text = new JTextField(15);
							private JTextField minInventory = new JTextField(40);
							private JTextField maxInventory = new JTextField(40);
							private JTextField minPrice = new JTextField(40);
							private JTextField maxPrice = new JTextField(40);
							private JButton continueIO = new JButton("continue");
							
							private void inventoryOptimization() {
								ioPanel.removeAll();
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
								////if statements to validate input
								repaint();
								revalidate();
							}
							
						});
						
///////////////////////////UPDATE PRODUCT INFO///////////////////////////////////////////
						updateButton.addActionListener(new ActionListener() {
							JPanel updatePanel = new JPanel();
							private JButton continueUpdate = new JButton("continue");
							
							private void updateProductInfo() {
								updatePanel.removeAll();
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
					
					private JButton continueMA = new JButton("continue");
					private JTextField startText = new JTextField(15);
					private JTextField endText = new JTextField(15);
					private JTextField startDate = new JTextField(40);
					private JTextField endDate = new JTextField(40);
					
					private void marketingAnalysis() {
						marketPanel.removeAll();
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
						
						marketPanel.add(welcome);
						marketPanel.add(instText);
						marketPanel.add(productText);
						marketPanel.add(productID);
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
						///insert if statements
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
