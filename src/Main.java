import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        Time time = new Time();
        Seat seat = new Seat();
        Customer customer = new Customer();
        Price price = new Price();
        Hall ODC = new ODC();
        Hall Balcony = new Balcony();
        SQLSyntax SQL = new SQLSyntax();


        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\t\t1. ADMIN" + "\n\t\t2. CUSTOMER"+"\n\t\t3.EXIT");
            System.out.print("Enter who you are : ");
            int first = s.nextInt();
            switch (first) {
                case 1:
                    System.out.print("Enter Password : ");
                    int pswd = s.nextInt();
                    if (pswd == 1234) {
                        System.out.println("WELCOME......!!!");
                        while (true) {

                            System.out.println("Options : " +
                                    "\n\t1.Add new film" +
                                    "\n\t2.Delete a film" +
                                    "\n\t3.See available films" +
                                    "\n\t4.Exit");
                            System.out.print("Please enter your option : ");
                            int a_option = s.nextInt();
                            switch (a_option) {
                                case 1:
                                    SQL.FilmDetails();
                                    break;
                                case 2:
                                    SQL.DeleteFilms();
                                    break;
                                case 3:
                                    SQL.AvailableFilms();
                                    break;
                                case 4:
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Wrong input.Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Your password is incorrect.Please try again.");
                    }
                    break;


                case 2:
                    System.out.println("WELCOME...!!!");
                    while (true) {


                        System.out.println("Options : " +
                                "\n1. See available films" +
                                "\n2.See the time slots" +
                                "\n3. Booking a seat" +

                                "\n4.Exit");
                        System.out.print("Choose your option : ");


                        int option = s.nextInt();
                        switch (option) {
                            case 1:
                                SQL.AvailableFilms();

                                break;
                            case 2:
                                SQL.AvailableTime();
                                break;

                            case 3:
                                int movieId = movie.selectMovie();

                                int selectedTime = time.selectTime();
                                String hallName = seat.selectHall();
                                switch (hallName) {
                                    case "ODC":
                                        SQL.BookedSeatDetails(movieId,selectedTime);

                                        int rowNumber = ODC.getRowNumber();

                                        int columnNumber = ODC.getColumnNumber();

                                        String seatNumber=ODC.seatID();

                                        String seatID = ODC.getsID(movieId,selectedTime);

                                        SQL.SeatDetails(seatID,seatNumber,rowNumber,columnNumber,hallName);

                                        customer.CustomerDetails();

                                        price.TicketPrice();

                                        price.TicketDetails(movieId,selectedTime,seatID);


                                        break;
                                    case "Balcony":

                                        SQL.BookedSeatDetails(movieId,selectedTime);

                                        int BalconyRowNumber = Balcony.getRowNumber();

                                        int BalconyColumnNumber  = Balcony.getColumnNumber();

                                        String BalconySeatNumber = Balcony.seatID();

                                        String BalconySeatID = Balcony.getsID(movieId,selectedTime);

                                        SQL.SeatDetails(BalconySeatID,BalconySeatNumber,BalconyRowNumber,BalconyColumnNumber,hallName);

                                        customer.CustomerDetails();

                                        price.TicketPrice();

                                        price.TicketDetails(movieId,selectedTime,BalconySeatID);
                                        break;
                                    default:
                                        System.out.println("You have entered a wrong input");
                                        break;
                                }


                                break;
                            case 4:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("You have entered an invalid number.Please try again.");
                                break;

                        }
                    }

                    case 3:
                       System.exit(0);
                       break;
                    default:
                        System.out.println("You Have entered an invalid number.Please try again.");
                        break;
                    }

        }

    }
}

