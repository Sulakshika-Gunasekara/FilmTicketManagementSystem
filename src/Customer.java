import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {
    Scanner s = new Scanner(System.in);
    Scanner s1 = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    private int customerID ;

    static int Age;
    String email_address;



    public void CustomerDetails(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","#KElkg@613");
            System.out.println("CONNECTION ESTABLISHED...");
            System.out.println("Please enter your details here...");
            Statement stmt = con.createStatement();
            System.out.print("Enter Your ID : ");
              customerID = s.nextInt();
            System.out.print("Enter Your Name : ");
            String CustomerName = s1.nextLine();
            System.out.print("Enter Contact Number : ");
            String ContactNumber = s1.nextLine();
            System.out.print("Enter Your Age : ");
            Age = s1.nextInt();
            System.out.print("Enter your email address : ");
            email_address = scanner.nextLine();

            stmt.executeUpdate("insert into customer values('"+customerID+"','"+CustomerName+"','"+ContactNumber+"','"+Age+"','"+email_address+"')");

            System.out.println("VALUES INSERTED SUCCESSFULLY...THANK YOU !");

        } catch (ClassNotFoundException  ex) {
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
    public int getCustomerID(){
        return customerID;
    }


}
