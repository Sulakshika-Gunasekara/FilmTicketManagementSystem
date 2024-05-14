import java.sql.*;
import java.util.Scanner;
class Seat {
    Scanner s = new Scanner(System.in);
    Hall o = new ODC();
    Hall b = new Balcony();
    static  String hTYPE;
    int mid;





    public String selectHall() {
        System.out.println("Select a hall type ODC or Balcony");
        String hType = s.nextLine();


        hTYPE =hType;
        return hTYPE;
    }

}