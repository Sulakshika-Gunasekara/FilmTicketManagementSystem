import java.sql.*;
import java.util.Scanner;

public class SQLSyntax {
    Scanner SQLScanner = new Scanner(System.in);
    int movieID;
    int timeID;
    String sID;
    String sNUmber;
    int rowNumber;
    int columnNumber;


    public void FilmDetails(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","#KElkg@613");
            System.out.println("CONNECTION ESTABLISHED...");
            Statement stmt = con.createStatement();
            System.out.print("Enter Movie ID : ");
            int Mid = SQLScanner.nextInt();
            System.out.print("Enter Movie Name : ");
            String Mname = SQLScanner.nextLine();
            System.out.print("Enter Movie Description : ");
            String Des = SQLScanner.nextLine();
            System.out.print("Enter Movie Type : ");
            String MType = SQLScanner.nextLine();
            System.out.print("Enter  Characters : ");
            String MChar = SQLScanner.nextLine();
            stmt.executeUpdate("insert into movie values ('"+Mid+"','"+Mname+"','"+Des+"','"+MType+"','"+MChar+"')");
            System.out.println("VALUES INSERTED SUCCESSFULLY...THANK YOU !");

        } catch (ClassNotFoundException  ex) {
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void AvailableFilms(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","#KElkg@613") ;
            System.out.println("CONNECTED TO THE DATABASE...\n");
            System.out.println("HERE THE MOVIES AVAILABLE TODAY...\n\n\n");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movie");
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void DeleteFilms(){
        try{
            Class.forName(("com.mysql.jdbc.Driver"));
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","#KElkg@613");
            System.out.println("CONNECTION ESTABLISHED...");
            Statement st = con.createStatement();
            System.out.print("Enter the Movie ID : ");
            int MID = SQLScanner.nextInt();
            String sql = "delete from movie where  MovieID =('"+MID+"')";
            int numberAffectedRow = st.executeUpdate(sql);
            System.out.println("Rows Affected"+numberAffectedRow);
            System.out.println("DELETE COMPLETED...");


        }catch (ClassNotFoundException e){

            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AvailableTime(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","#KElkg@613") ;
            System.out.println("CONNECTED TO THE DATABASE...\n");
            System.out.println("HERE THE MOVIE TIMES AVAILABLE TODAY...\n\n");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from time");
            while (rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void SeatDetails(String sID,String sNUmber,int rowNumber,int columnNumber,String hallName){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","#KElkg@613");
            System.out.println("We are adding your details into the database.");
            System.out.println("CONNECTION ESTABLISHED...");
            Statement stmt = con.createStatement();

            stmt.executeUpdate("insert into seat values ('"+sID+"','"+sNUmber+"','"+rowNumber+"','"+columnNumber+"','"+hallName+"')" );
            System.out.println("VALUES INSERTED SUCCESSFULLY...THANK YOU !");

        } catch (ClassNotFoundException  ex) {
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }



    public void BookedSeatDetails(int movieID,int timeID){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","#KElkg@613");
            System.out.println("CONNECTION ESTABLISHED...");

            Statement stmt = con.createStatement();


            ResultSet resultSet =  stmt.executeQuery("select RowNumber,ColumnNumber,Hall from seat where SeatID in (select SeatID from movie_ticket where MovieID = "+movieID+" and TimeID = "+timeID+" ) ");

            System.out.println("THESE ARE THE SEAT NUMBERS THAT ALREADY BOOKED");
            System.out.println("");
            System.out.println("ROW NUMBERS  COLUMN NUMBERS  HALL TYPE");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+"\t\t\t "+resultSet.getInt(2)+" \t\t\t"+resultSet.getString(3));

            }
            System.out.println("");
            System.out.println("");


        } catch (ClassNotFoundException  ex) {
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }




}
