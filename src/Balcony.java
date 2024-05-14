import java.util.Scanner;

public class Balcony extends Hall {

    Scanner scanner = new Scanner(System.in);
    int columnNumber;
    int rowNumber;
    static String hType = "Balcony";
    int timeID;
    int movieID;



    public int getRowNumber(){
        System.out.print("Enter the row number here: ");
        rowNumber = scanner.nextInt();
        return rowNumber;
    }

    public int getColumnNumber(){
        System.out.print("Enter the column number here :");
        columnNumber = scanner.nextInt();
        return columnNumber;
    }




    @Override
    public String seatID() {
        String rowID = null;


        Scanner s = new Scanner(System.in);


        if (rowNumber < 11) {

           int column = columnNumber;
            if (column < 11) {
                switch (rowNumber) {
                    case 1:
                        rowID = "a";
                        break;
                    case 2:
                        rowID = "b";
                        break;
                    case 3:
                        rowID = "c";
                        break;
                    case 4:
                        rowID = "d";
                        break;
                    case 5:
                        rowID = "e";
                        break;
                    case 6:
                        rowID = "f";
                        break;
                    case 7:
                        rowID = "g";
                        break;
                    case 8:
                        rowID = "h";
                        break;
                    case 9:
                        rowID = "i";
                        break;
                    case 10:
                        rowID = "j";
                        break;
                    default:
                        System.out.println("Wrong input");
                }

            } else {
                System.out.println("Wrong input");
            }
        } else {
            System.out.println("Wrong input");
        }
        sNUmber = rowID + columnNumber;
        System.out.print("Your Seat Number : ");
        System.out.println(sNUmber);
        System.out.println("");
        return sNUmber;
    }
    public String getsID(int movieID,int timeID){
        sID = hType+timeID+movieID+sNUmber;
        System.out.print("Your Seat ID : ");
        System.out.println(sID);
        System.out.println("");
        return sID;
    }
}
