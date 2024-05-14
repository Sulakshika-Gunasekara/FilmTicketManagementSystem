import java.sql.*;
import java.util.Scanner;

public class Time {
    Scanner t = new Scanner(System.in);
    Seat h = new Seat();

    public int selectTime() {
        System.out.println("select time :\n 1 : 8.00 - 10.00\n 2 : 10.00 - 12.00\n 3 : 4.00 - 6.00");
        System.out.print("time : ");
        int time = t.nextInt();
        return time;

    }


}
