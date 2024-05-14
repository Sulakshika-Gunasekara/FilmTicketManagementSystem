import java.sql.*;

public class Price extends Customer {
    String price ;
    int movieID;
    int timeID;
    String seatID;



    public String TicketPrice(){


        if(Age<10){
            price = "500";

        }else {
            price = "1000";
        }
        System.out.println("Price of your ticket is : "+price);

        return price;
    }
    public void TicketDetails(int movieID,int timeID,String seatID){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","#KElkg@613");
            System.out.println("");
            System.out.println("We are inserting your details to our database");
            System.out.println("CONNECTION ESTABLISHED...");
            Statement stmt = con.createStatement();

            stmt.executeUpdate("insert into movie_ticket values('"+getCustomerID() +"','"+movieID+"','"+timeID+"','"+seatID+"','"+price+"')");
            System.out.println("VALUES INSERTED SUCCESSFULLY...THANK YOU !");
            System.out.println("Your ticket is ready now.");
            System.out.println("" );
            System.out.println("");

        } catch (ClassNotFoundException  ex) {
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }



}
