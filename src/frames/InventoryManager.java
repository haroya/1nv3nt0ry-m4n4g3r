/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.manager;
import java.sql.*;
import java.util.Scanner;
import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException;
/**
 *
 * @author jaineeshah
 */


public class InventoryManager {
    //  Database credentials
    static String USER;
    static String PASS;
    static String DBNAME;
    //This is the specification for the printout that I'm doing:
    //each % denotes the start of a new field.
    //The - denotes left justification.
    //The number indicates how wide to make the field.
    //The "s" denotes that it's a string.  All of our output in this test are 
    //strings, but that won't always be the case.
    static final String displayFormat="%-5s%-15s%-15s%-15s\n";
// JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static String DB_URL = "jdbc:derby://localhost:1527/";
//            + "testdb;user=";
/**
 * Takes the input string and outputs "N/A" if the string is empty or null.
 * @param input The string to be mapped.
 * @return  Either the input string or "N/A" as appropriate.
 */
    public static String dispNull (String input) {
        //because of short circuiting, if it's null, it never checks the length.
        if (input == null || input.length() == 0)
            return "N/A";
        else
            return input;
    }
    
    public static void main(String[] args) throws SQLException {
        //Prompt the user for the database name, and the credentials.
        //If your database has no credentials, you can update this code to 
        //remove that from the connection string.
        Scanner in = new Scanner(System.in);
        System.out.print("Name of the database (not the user account): ");
        DBNAME = in.nextLine();
        System.out.print("Database user name: ");
        USER = in.nextLine();
        System.out.print("Database password: ");
        PASS = in.nextLine();
        //Constructing the database URL connection string
        DB_URL = DB_URL + DBNAME + ";user="+ USER + ";password=" + PASS;
        Connection conn = null; //initialize the connection
        Statement stmt = null;  //initialize the statement that we're using
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
//            AllFrames n = new AllFrames();
//		n.setVisible(true);
              System.out.println("Please enter your team user ID and password");
              int id = 0;
              boolean numbercheck = false;
              do {
                try { //validate user input 
                    System.out.print("UserID: ");
                   id = Integer.parseInt(in.next());
                    if (id == (int) id) {
                        numbercheck = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error: check the format of entered ID; try again");
                    numbercheck = false;
                }
            } while (!numbercheck);
              System.out.print("Password: ");
              String password = in.next().trim();
              PreparedStatement ps;
              try {
              ps = conn.prepareStatement("SELECT USERID from warehouseuser where USERID = (?)");
              ps.setInt(1, id);
             ps.execute();
             // System.out.println(result);
             
              
                  ps = conn.prepareStatement("INSERT Into warehouseuser (userid, username, phonenumber, email, password, lockstatus) values (?,?,?,?,?,?)");
                  ps.setInt(1, id);
                  ps.setString(2, "hello");
                  ps.setString(3, "7722");
                  ps.setString(4, "shshs@");
                  ps.setString(5, "hi there");
                  ps.setBoolean(6, false);
                  ps.executeUpdate();
                  
              }
              catch (DerbySQLIntegrityConstraintViolationException e){
                                
              ps = conn.prepareStatement("SELECT userid, password from warehouseuser where userid = (?) and password = (?)");
              ps.setInt(1, id);
              ps.setString(2, password);
             System.out.println(ps.getFetchSize());
              boolean result = ps.execute();
              if (result){
                  System.out.println("hurray");
              }
              }
              System.out.println("-----MENU----");
              System.out.println("1. Process Order or Restock");
              System.out.println("2. Manage Products");
              System.out.println("3. Marketing Analysis");
              int option = in.nextInt();
              if (option ==1){
                  System.out.println("1.Process order");
                  System.out.println("2. Process stock");
                  option = in.nextInt();
                  if (option == 1){
                      System.out.println("Process ID");
                      int pID = in.nextInt();
                     numbercheck = false;
              do {
                try { //validate user input 
                    System.out.print("UserID: ");
                   pID = Integer.parseInt(in.next());
                    if ( pID == (int)  pID) {
                        numbercheck = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error: check the format of entered pID; try again");
                    numbercheck = false;
                }
            } while (!numbercheck);
              numbercheck = false; //TO_DO : productID doest not exist 
                 do { 
              ps = conn.prepareStatement("SELECT ProductID from Products where Products = (?)");
              ps.setInt(1, pID);
             ps.execute();  
                 
              }
                 while (!numbercheck );
                 System.out.println("Quantity");
                 int quantity = in.nextInt();
                 
//                 if (Quantityinstock >= quantity){
//                     check = true;
//                     quantityinstock -= quantity;
//                    CURRENT_TIMESTAMP;
//                    //add t orderlogs, update productassociations, products
//                 }
//                 if (check){
//                     System.out.println("SUCCESSFUL");
//                 }
//                 
                  }
                  else if (option == 2){
                       System.out.println("Process ID");
                      int pID = in.nextInt();
                     numbercheck = false;
              do {
                try { //validate user input 
                    System.out.print("UserID: ");
                   pID = Integer.parseInt(in.next());
                    if ( pID == (int)  pID) {
                        numbercheck = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error: check the format of entered pID; try again");
                    numbercheck = false;
                }
            } while (!numbercheck);
              numbercheck = false; //TO_DO : productID doest not exist 
                 do { 
              ps = conn.prepareStatement("SELECT ProductID from Products where ProductID = (?)");
              ps.setInt(1, pID);
             ps.execute();  
                 
              }
                 while (!numbercheck );
                 System.out.println("Quantity");
                 int quantity = in.nextInt();
                 
//                 if (Quantityinstock >= quantity){
//                     check = true;
//                     quantityinstock -= quantity;
//                    CURRENT_TIMESTAMP;
//                    //add t orderlogs, update productassociations, products
//                 }
//                 if (check){
//                     System.out.println("SUCCESSFUL");
//                 }
                  }
              }
              else if (option == 2){
                  System.out.println("1. Add New product");
                  System.out.println("2. remove product");
                  System.out.println("3. Adjust product quantity");
                  System.out.println("4. Inventory optimization");
                  System.out.println("5. Update product information");
                  int save = in.nextInt();
                  if (save == 1){
                      PreparedStatement insert = conn.prepareStatement ("Insert into products(productid, productname, price, productdescription, quantityinstock) values (?,?,?,?,?)");
                      //USER INPUTS 
                      //insert.setString 5 statements 
                      //check prodcutID
                      
                  }
                  else if (save == 2){
                      System.out.println("Enter productID");
                      int proID = in.nextInt();
                       PreparedStatement remove = conn.prepareStatement("DELETE from products where productID = (?)");
                       remove.setInt(1, proID);
                       int result = remove.executeUpdate();
                       if (result == 1){
                           System.out.println("Successfully removed the product");
                       }
                       else {
                           System.out.println("NO products exists with this productID in the system");
                       }
                      
                  }
                  else if (save == 3){
                       System.out.println("Enter productID");
                      int proID = in.nextInt();
                      System.out.println("Enter quantity");
                      int quantity = in.nextInt();
                      PreparedStatement remove = conn.prepareStatement("Update   products where productid = (?) set quantity = (?)");
                      remove.setInt(1, proID);
                      remove.setInt(2, quantity);

                      
                  }
                  else if (save == 4){
                      //productID
                      //min inventory
                      //max inventory
                      //min size
                      //max size
                      
                      
                  }
                  else if (save == 5){
                      System.out.println("Update product info");
                      //productid
                      //productname
                      //price
                      //description
                      PreparedStatement update = conn.prepareStatement("Update products set productid = (?), ");
                      
                  }
              }
              else if (option == 3){
                  System.out.println("ProductID");
                  int productid = in.nextInt();
                  System.out.println("Start date");
                  String date = in.nextLine();
                  System.out.println("end Date");
                  String date1 = in.nextLine();
              }
        
                  
                  
                      
                  
                      
                  
              
 

              
              
                      
//            sql = "SELECT au_id, au_fname, au_lname, phone FROM Authors";
//            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
         //   System.out.printf(displayFormat, "ID", "First Name", "Last Name", "Phone #");
//            while (rs.next()) {
//                //Retrieve by column name
//                String id = rs.getString("au_id");
//                String phone = rs.getString("phone");
//                String first = rs.getString("au_fname");
//                String last = rs.getString("au_lname");
//
//                //Display values
//                System.out.printf(displayFormat, 
//                        dispNull(id), dispNull(first), dispNull(last), dispNull(phone));
            //}
            //STEP 6: Clean-up environment
         //   rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}
