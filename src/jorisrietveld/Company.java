package jorisrietveld;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 05-04-2017 15:15
 * Licence: GPLv3 - General public licence version 3.
 * Teachers: Rob loves and  Winnie van Schilt
 * <p>
 * ======================================================================
 * ===               Java final assignment number: 10                 ===
 * ======================================================================
 * An short description about the project
 * ----------------------------------------------------------------------
 * An speedboat rental company wants to digitize there rental records.
 * The company owns 10 speedboats and they want to record what speedboat
 * get rented on what date, the amount of fuel that was used, the total
 * profit earned and the damage that the speedboat accumulated during
 * the speedboat rental.
 */
public class Company
{
    /**
     * An collection with Rentals that speedboat rental titanic did. Initiate the collection with some test data.
     */
    private ArrayList<Rental> rentals = new ArrayList<Rental>()
    {{
        add( new Rental( "1", 2, 10, false, false, "bob" ) );
        add( new Rental( "1", 1, 10, false, false, "alice" ) );
        add( new Rental( "3", 6, 5, false, true, "Linus" ) );
    }};

    /**
     * An collection with Speedboats that speedboat rental titanic owns. Initiate the collection with some test data.
     */
    private Map<String, Speedboat> speedboats = new HashMap<String, Speedboat>()
    {{
        put( "1", new Speedboat( 200, 50, 8, "1", 23.00 ) );
        put( "2", new Speedboat( 245, 100, 12, "2", 50.00 ) );
        put( "3", new Speedboat( 600, 78, 6, "3", 67.00 ) );
        put( "4", new Speedboat( 1200, 900, 20, "4", 300.00 ) );
        put( "5", new Speedboat( 2244, 1300, 25, "5", 900.00 ) );
        put( "6", new Speedboat( 278, 45, 20, "6", 32.00 ) );
        put( "7", new Speedboat( 403, 15, 44, "7", 56.00 ) );
        put( "8", new Speedboat( 890, 65, 80, "8", 76.00 ) );
        put( "9", new Speedboat( 112, 67, 67, "9", 34.00 ) );
        put( "10", new Speedboat( 42, 80000, 42, "10", 37.00 ) );
        put( "11", new Speedboat( 389, 20, 23, "11", 79.00 ) );
    }};

    /**
     * Closure for getting the rental price of an speedboat by the speedboat id.
     * (testing the new functional interfaces and lambada syntax)
     */
    private Function<String, Double> getRentById = i -> speedboats.getOrDefault( i, null ) != null ? speedboats.get( i ).getRentalPrice() : null;

    /**
     * Closure for calculating the total revenue.
     * (testing the new functional interfaces and lambada syntax)
     */
    private Function<ArrayList<Rental>, DoubleSummaryStatistics> calcTotalRevenue = rl ->
            rl.stream().collect(
                    Collectors.summarizingDouble( r ->
                            getRentById.apply( r.getBoatId() ) * r.getTimeRented() + ( r.getUsedFuel() * 5 ) ) );

    /**
     * Rent an speedboat.
     * @param boatId The unique identification code of an speedboat.
     * @param customerName The name of the customer renting the speedboat.
     */
    void rentAnSpeedboat( String boatId, String customerName ) throws Exception
    {
        boolean isRented = rentals.stream().filter( r -> r.getBoatId().equals( boatId ) && r.isRented() ).count() == 0;

        if( speedboats.containsKey( boatId ) && !isRented ) // Does the speedboat exist and is it not currently rented?
        {
            rentals.add( new Rental( boatId, customerName ) );
            System.out.println( String.format( "Speedboat rented with id: %s for customer: %s", boatId, customerName ) );
            return;
        }
        throw new Exception( String.format( "The speedboat with the id: %s, is not found!", boatId ) );
    }

    /**
     * Return an rented speedboat.
     * @param boatId The unique identification code of the speedboat.
     * @param fuelUsed The amount of fuel the speedboat used.
     * @param timeRented The total rental time.
     * @param hasDamage Dit the renter break the speedboat?
     * @return The updated rental record.
     * @throws Exception If the speedboat isn't found.
     */
    Rental returnAnSpeedboat( String boatId, int fuelUsed, int timeRented, boolean hasDamage ) throws Exception
    {
        // Find the rental record.
        Rental rental = rentals.stream().filter( r -> r.getBoatId().equals( boatId ) && r.isRented() ).findFirst().orElse( null );

        if( null != rental ) // Is the speedboat currently rented?
        {
            rental.setUsedFuel( fuelUsed ).setTimeRented( timeRented ).setDamage( hasDamage );
            System.out.println( String.format( "The speedboat: %s is available for rental again.", boatId ) );
            return rental;
        }
        throw new Exception( String.format( "No speedboat found with the number %s that is currently rented", boatId ) );
    }

    /**
     * Print the total revenue the speedboat company has made based on the rental records.
     */
    public void printTotalRevenue()
    {
        System.out.println( String.format(
                "The total revenue is: %f for this day",
                calcTotalRevenue.apply( rentals ).getSum()
        ) );
    }

    /**
     * Print the speedboat that has the highest fuel use.
     */
    void printSpeedBoatWithHighestFuelUse()
    {
        Rental highestFuel = Collections.max( rentals, Comparator.comparing( Rental::getUsedFuel ) );

        System.out.println( String.format(
                "The speedboat with the highest fuel use is: %s it was rented by: %s it used: %d liters of fuel.",
                highestFuel.getBoatId(),
                highestFuel.getCustomerName(),
                highestFuel.getUsedFuel()
        ) );
    }

    /**
     * Stream filter for filtering an collection with objects by an distinct object attribute.
     */
    private static <T> Predicate<T> distinctByKey( Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * Print the amount of speedboats that have damage, calculated from the rental records.
     */
    void printPercentageOfSpeedboatsWithDamage()
    {
        System.out.println( String.format(
                "The percentage of damaged speedboats is: %d%%",
                100/speedboats.size()*rentals.stream().filter( Rental::isDamage ).filter( distinctByKey( Rental::getBoatId ) ).count()
        ) );
    }

    /**
     * Print the shortest rent time of an rented speedboat.
     */
    void printShortestRentedSpeedboat()
    {
        Rental shortestRentTime = Collections.min( rentals, Comparator.comparing( Rental::getTimeRented ) );

        System.out.println( String.format(
                "The shortest rent time is: %s for speedboat: %s it was rented by: %s",
                shortestRentTime.getTimeRented(),
                shortestRentTime.getBoatId(),
                shortestRentTime.getCustomerName()
        ));
    }

    /**
     * Add an new speedboat to the speedboat collection.
     * @param speedboat The new speedboat.
     */
    void addAnSpeedboat( Speedboat speedboat )
    {
        speedboats.put( speedboat.getId(), speedboat );
    }

    /**
     * Get the speedboat collection.
     * @return An collection with all speedboats that Speedboat Rental titanic has.
     */
    Map<String,Speedboat> getSpeedboats()
    {
        return speedboats;
    }

    /**
     * Get the rentals collection.
     * @return An collection with all rental records.
     */
    ArrayList<Rental> getRentals()
    {
        return rentals;
    }
}
