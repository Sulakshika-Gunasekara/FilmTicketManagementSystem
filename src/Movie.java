import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Movie {
    Scanner m = new Scanner(System.in);






    public int selectMovie() {
        System.out.println(" Movie ID :"+
                "\nMovie 1 : 11"+
                "\nMovie 2 : 22"+
                "\nMovie 3 : 33");
        System.out.print("Enter the selected Movie ID :");
         int mid = m.nextInt();
        return mid;

    }

}

