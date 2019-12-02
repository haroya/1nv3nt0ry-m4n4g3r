/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.manager;
import java.sql.*;
import java.time.LocalDate;
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
        int numbertries = 3;
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

              PreparedStatement ps = conn.prepareStatement("SELECT USERID, password from warehouseuser where USERID = (?)");
              try {
              ps = conn.prepareStatement("SELECT USERID, password from warehouseuser where USERID = (?)");
              ps.setInt(1, id);
             ps.executeQuery();
             
            
             if (getTable(ps)[1].equals("false")){
                 System.out.println("ID does not exist in the system, registering new user");
                 ps = conn.prepareStatement("INSERT Into warehouseuser (userid, username, phonenumber, email, password, lockstatus, numbertries) values (?,?,?,?,?,?, ?)");
                  ps.setInt(1, id);
                  System.out.println("Please enter your username");
                  ps.setString(2, in.next());
                   System.out.println("Please enter your phonenumber (XXX-XXX-XXXX)");
                  ps.setString(3,in.next());
                   System.out.println("Please enter your email");
                  ps.setString(4, in.next());
                  System.out.println("Please enter your password");
                   ps.setString(5, in.next());
                  ps.setBoolean(6, false);
                  ps.setInt(7, 3);
                  ps.executeUpdate();
             }
             
             else {
                 in.nextLine();
                 numbercheck = false;
             do {
             
                 System.out.println("Password:");
                 String password1 = in.nextLine();
                 if (getTable(ps)[0].contains(password1)){
                     numbercheck = true;
                     System.out.println("hello");
                 }
                 else {
                     if (numbertries <= 0){
                         ps = conn.prepareStatement("Update warehouseuser set lockstatus = (?)");
                         ps.setBoolean(1, true);
                         ps.execute();
                         System.out.println("You have reached your limit of 3 unsuccessful attempts, your account will reactive after 30 minutes! Thank you for understanding!! ");
                         System.exit(1);
                     }
                     else {
                     
                     numbertries -= 1;
                      System.out.println("You have "+ numbertries + " attempts left");
                     ps = conn.prepareStatement("Update warehouseuser set numbertries = (?)");
                     ps.setInt(1, numbertries);
                     ps.execute();
                     
                 }
                     }
 
             }
             while (!numbercheck);
             }   
              }
              catch (DerbySQLIntegrityConstraintViolationException e){
                                
              System.out.println("Password:");
                 String password1 = in.next();
                 if (getTable(ps)[0].contains(password1)){
                     
                 }
                 else {
                     if (numbertries - 1 < 0){
                         ps = conn.prepareStatement("Update warehouseuser set lockstatus = (?)");
                         ps.setBoolean(1, true);
                         ps.execute();
                         
                     }
                     else {
                         System.out.println("You have "+ numbertries + " attempts leftdhsbf");
                     numbertries -= 1;
                     
                 }  
             }
              }
              int option = -1;
              while (option != 4){
              System.out.println("-----MENU----");
              System.out.println("1. Process Order or Restock");
              System.out.println("2. Manage Products");
              System.out.println("3. Marketing Analysis");
              System.out.println("4. Exit");
              option = Integer.parseInt(in.next().trim());
              if (option ==1){
                  System.out.println("1.Process order");
                  System.out.println("2. Process stock");
                  option = in.nextInt();
                  if (option == 1){

                      int pID = 0;
                     numbercheck = false;
              do {
                try { //validate user input 
                    System.out.print("Product ID: ");
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
                // do { 
              
             String v = "SELECT Quantityinstock from Products where Productid = " + pID;
              int Quantityinstock = viewValue(conn, v);
                 System.out.println("Quantity:");
                 int quantity = in.nextInt();
                 
                 if (Quantityinstock >= quantity && quantity != 0){
                     
                     Quantityinstock -= quantity;
                     ps = conn.prepareStatement("Update products set quantityinstock = (?) where productid = (?)");
                     ps.setInt(1, Quantityinstock);
                     ps.setInt(2, pID);
                     ps.execute();
                     
                   ps = conn.prepareStatement("Insert into orderlogs (productid, productamountordered, dateordered, timeordered) values (?,?,?, ?)");
                   ps.setInt(1, pID);
                   ps.setInt(2, quantity);
                   ps.setDate(3, getCurrentDate());
                   Date date = getCurrentDate();
                   ps.setLong(4, date.getTime());
                   
                  //TIME ORDERED 
                  ps.execute();
                  ps = conn.prepareStatement("Insert into productassociations (timetransaction, userid, productid) values (?, ?,?)");
                  ps.setLong(1, date.getTime());
                  ps.setInt(2, id);
                  ps.setInt(3, pID);
                  ps.execute(); 
                  System.out.println("SUCCESSFUL");
                 }
                 else {
                     System.out.println("Not Enough quantity in the system! Please check back soon!");
                 }
                 
                  }
                  else if (option == 2){
                      int pID = 0;
                     numbercheck = false;
              do {
                try { //validate user input 
                    in.nextLine();
                    System.out.print("Product ID: ");
                   pID = Integer.parseInt(in.next());
                    if ( pID == (int)  pID) {
                        numbercheck = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error: check the format of entered pID; try again");
                    numbercheck = false;
                }
            } while (!numbercheck);
              
             String v = "SELECT Quantityinstock from Products where Productid = " + pID;
              int Quantityinstock = viewValue(conn, v);
     
                 System.out.println("Quantity");
                 int quantity = in.nextInt();
                     Quantityinstock += quantity;
                     ps = conn.prepareStatement("Update products set quantityinstock = (?) where productid = (?)");
                     ps.setInt(1, Quantityinstock);
                     ps.setInt(2, pID);
                     ps.execute();
                     System.out.println("SUCCESSFUL");
                 
                  }
              }
              else if (option == 2){
                  System.out.println("1. Add New product");
                  System.out.println("2. remove product");
                  System.out.println("3. Adjust product quantity");
                  System.out.println("4. Inventory optimization");
                  System.out.println("5. Update product information");
                  int save = in.nextInt();
                  in.nextLine();
                  if (save == 1){
                     boolean check = false;
                      PreparedStatement insert = conn.prepareStatement ("Insert into products(productid, productname, price, productdescription, quantityinstock) values (?,?,?,?,?)");
                    do {
                      try {
                      System.out.println("ProductID");
                      int pID = Integer.parseInt(in.nextLine().trim());
                      insert.setInt(1, pID);
                      System.out.println("ProductName");
                      String name = in.nextLine();
                      insert.setString(2, name);
                      System.out.println("Price");
                      Double  price = Double.parseDouble(in.nextLine().trim());
                      insert.setDouble(3, price);
                      System.out.println("ProductDescription");
                      String desc = in.nextLine();
                      insert.setString(4, desc);
                      System.out.println("Quantity");
                      int quan = Integer.parseInt(in.nextLine().trim());
                      insert.setInt(5, quan);
                      check = true;
                      insert.execute();
          
                      }
                      catch (DerbySQLIntegrityConstraintViolationException e){
                          System.out.println("Incorrect Process ID, it already exists in the system");
                          check = false;
                      }                      
                  }
                    while (!check);
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
                      PreparedStatement remove = conn.prepareStatement("Update   products  set quantityinstock = (?) where productid = (?)");
                      remove.setInt(2, proID);
                      remove.setInt(1, quantity);
                      remove.execute();
                      
                  }
                  else if (save == 4){
                      //productID
                      //min inventory
                      //max inventory
                      //min size
                      //max size
                      
                      
                  }
                  else if (save == 5){
                      System.out.println("Update product information");
                      PreparedStatement update = conn.prepareStatement("Update products set  productname = (?), price = (?), productdescription = (?) where productid = (?) ");
                      System.out.println("Enter ID of the product that you would like to make changes on");
                      int ID = Integer.parseInt(in.nextLine());
                      update.setInt(4, ID);
                      System.out.println("Enter new productname");
                      update.setString(1, in.nextLine());
                      System.out.println("Enter new price of the product");
                      update.setDouble(2, Double.parseDouble(in.nextLine()));
                      System.out.println("Enter new product description");
                      update.setString(3, in.nextLine());
                      update.execute();
    
                  }
              }
              else if (option == 3){
                  System.out.println("ProductID");
                  int productid = in.nextInt();
                  in.nextLine();
                  System.out.println("Start date");
                  System.out.println("Enter a year: ");
                  int year = Integer.parseInt(in.nextLine());
                 System.out.println("Enter a month: ");
                  int month = Integer.parseInt(in.nextLine());
                 System.out.println("Enter a day: ");
                  int day = Integer.parseInt(in.nextLine());
                  
                  LocalDate startdate = LocalDate.of(year, month, day);
                  System.out.println("end Date");
                   System.out.println("Enter a year: ");
                  year = Integer.parseInt(in.nextLine());
                 System.out.println("Enter a month: ");
                  month = Integer.parseInt(in.nextLine());
                 System.out.println("Enter a day: ");
                  day = Integer.parseInt(in.nextLine());
                  LocalDate enddate = LocalDate.of(year, month, day);
                 
              }   
              }     

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
     public static String[] getTable(PreparedStatement ps) {
        String table = "";
        String label = "";
        int columnSize = 0;
        int column = 0;
        try {
            // To list the column labels.
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            column = rsmd.getColumnCount();
            for (int i = 1; i <= column; i++) {
                label = rsmd.getColumnName(i);
                columnSize = rsmd.getColumnDisplaySize(i); // Each column may have a different length
                if (columnSize < rsmd.getColumnName(i).length()) {
                    table += String.format("%-" + rsmd.getColumnName(i).length() + "s ", label); // To format by column size from left.
                } else {
                    table += String.format("%-" + columnSize + "s ", label); // To format by column size from left.
                }
            }
            table += "\n";
            // To store all the rows with format. 
            if (!rs.next()) {
                String[] returns = {"No Data. Please ensure you entered data correctly.", "false"};
                return returns;
            } else {
                do {
                    for (int i = 1; i <= column; i++) {
                        columnSize = rsmd.getColumnDisplaySize(i);
                        if (columnSize < rsmd.getColumnName(i).length()) {
                            table += String.format("%-" + rsmd.getColumnName(i).length() + "s ", rs.getString(i)); // To format by column size from left.
                        } else {                    
                            table += String.format("%-" + columnSize + "s ", rs.getString(i));
                        }
                    }
                    table += "\n";
                } while(rs.next());
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        String[] returns = {table, "true"};
        return returns;
    }
     static int viewValue(Connection con, String command) throws SQLException 
    {
        int value = 0;
        Statement stmt = null;
        ResultSet rs = null;
        try 
        {
            stmt = con.createStatement();
             rs = stmt.executeQuery(command);

            if (rs.next())
                value = rs.getInt("QuantityinStock");
        } 

        catch (SQLException e ) 
        {
            e.printStackTrace();
        } 

        finally
        {
            if (stmt != 
            null) { stmt.close(); }
        }

        return value;

    }
     private static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
} 
}
