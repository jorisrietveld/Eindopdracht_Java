package jorisrietveld;

import java.util.Scanner;

public class Main
{
    /**
     * The company object that holds all functionality.
     */
    private static Company speedboatCompany = new Company();

    /**
     * The main method of this program.
     */
    public static void main(String[] args)
    {
        printWelcomeMessage();
        printMenu();

        while( true )
        {
            executeAction();
        }
    }

    /**
     * Execute an option from the menu.
     */
    private static void executeAction()
    {
        try
        {
            Scanner scanner = new Scanner( System.in );
            String speedboatId;

            switch( scanner.nextInt() )
            {
                case 1:
                    System.out.println( "List of all speedboats:" );
                    speedboatCompany.getSpeedboats().values().forEach( System.out::println );
                    break;

                case 2:
                    System.out.println( "List of all rentals:" );
                    speedboatCompany.getRentals().forEach( System.out::println );
                    break;

                case 3:
                    speedboatCompany.printSpeedBoatWithHighestFuelUse();
                    break;

                case 4:
                    speedboatCompany.printPercentageOfSpeedboatsWithDamage();
                    break;

                case 5:
                    speedboatCompany.printShortestRentedSpeedboat();
                    break;

                case 6:
                    System.out.println( "Rent an speedboat" );
                    System.out.print( "Please type speedboat number: " );
                    speedboatId = scanner.next();

                    System.out.print( "Please type the customer name: " );
                    speedboatCompany.rentAnSpeedboat( speedboatId, scanner.next() );
                    System.out.println( "Tanks for renting the speedboat:" + speedboatId );
                    break;

                case 7:
                    System.out.println( "Rent an speedboat" );
                    System.out.print( "Please type speedboat number: " );
                    speedboatId = scanner.next();
                    System.out.print( "Please type the amount of fuel used: " );
                    int fuelUsed = scanner.nextInt();
                    System.out.print( "Please type the time the speedboat was rented: " );
                    int timeRented = scanner.nextInt();
                    System.out.print( "Did you break it? (y-N)" );
                    Rental yourRental = speedboatCompany.returnAnSpeedboat( speedboatId, fuelUsed, timeRented, scanner.next().equals( "y" ) );
                    System.out.println( yourRental.isDamage() ? "Thanks for destroying our speedboat, now get out!" : "See you next time!" );
                    break;

                case 8:
                    System.out.println( "Exit..." );
                    System.exit( 0 );
                    break;

                default:
                    System.out.println( "Unrecognized option" );
                    break;
            }
        }
        catch( Exception e )
        {
            System.out.println( "You messed up, your an horrible person next time don't break it!" );
        }
    }

    /**
     * Prints the option menu.
     */
    private static void printMenu()
    {
        System.out.println( "=======================[ MENU ]=====================" );
        System.out.println( "[ 1 ] - Show all speedboats                         " );
        System.out.println( "[ 2 ] - Show rental records                         " );
        System.out.println( "[ 3 ] - Show speedboat with highest fuel use        " );
        System.out.println( "[ 4 ] - Show percentage of speedboats with damage   " );
        System.out.println( "[ 5 ] - Show speedboat with the shortest rental time" );
        System.out.println( "[ 6 ] - Rent an speedboat                           " );
        System.out.println( "[ 7 ] - Return an rented speedboat                  " );
        System.out.println( "[ 8 ] - close the program                           " );
        System.out.println( "=======================[ MENU ]=====================" );
    }

    /**
     * Prints an welcome message.
     */
    private static void printWelcomeMessage()
    {
        System.out.println( "------------------------------------------------------[ Joris Rietveld's ]----------------------------------------------------------");
        System.out.println( "                                                                                                                                    ");
        System.out.println( " ███████╗██████╗ ███████╗███████╗██████╗ ██████╗  ██████╗  █████╗ ████████╗    ██████╗ ███████╗███╗   ██╗████████╗ █████╗ ██╗       ");
        System.out.println( " ██╔════╝██╔══██╗██╔════╝██╔════╝██╔══██╗██╔══██╗██╔═══██╗██╔══██╗╚══██╔══╝    ██╔══██╗██╔════╝████╗  ██║╚══██╔══╝██╔══██╗██║       ");
        System.out.println( " ███████╗██████╔╝█████╗  █████╗  ██║  ██║██████╔╝██║   ██║███████║   ██║       ██████╔╝█████╗  ██╔██╗ ██║   ██║   ███████║██║       ");
        System.out.println( " ╚════██║██╔═══╝ ██╔══╝  ██╔══╝  ██║  ██║██╔══██╗██║   ██║██╔══██║   ██║       ██╔══██╗██╔══╝  ██║╚██╗██║   ██║   ██╔══██║██║       ");
        System.out.println( " ███████║██║     ███████╗███████╗██████╔╝██████╔╝╚██████╔╝██║  ██║   ██║       ██║  ██║███████╗██║ ╚████║   ██║   ██║  ██║███████╗  ");
        System.out.println( " ╚══════╝╚═╝     ╚══════╝╚══════╝╚═════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝   ╚═╝       ╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚═╝  ╚═╝╚══════╝  ");
        System.out.println( "####################################################################################################################################");
        System.out.println( "############                                          ┌┬┐┬┌┬┐┌─┐┌┐┌┬┌─┐                                                #############");
        System.out.println( "############                                           │ │ │ ├─┤│││││                                                  #############");
        System.out.println( "############                                           ┴ ┴ ┴ ┴ ┴┘└┘┴└─┘                                                #############");
        System.out.println( "####################################################################################################################################");
        System.out.println( "Welcome to speedboat rental service titanic" );
        System.out.println( "Please choose an option from the menu...   " );
    }
}
