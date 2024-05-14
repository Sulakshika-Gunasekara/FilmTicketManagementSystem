import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

abstract class Hall  {
   String sNUmber = null;
   String sID = null;

   int movieID;
   int timeID;

   abstract  public int getRowNumber();
   abstract public int getColumnNumber();

   abstract public String getsID(int movieID, int timeID);


   abstract public String seatID();



   
}
