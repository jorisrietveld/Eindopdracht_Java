package jorisrietveld;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 05-04-2017 15:17
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
public class Rental
{
    /**
     * The unique identification code of the rented speedboat.
     */
    private String boatId;

    /**
     * The amount of fuel used during the rental.
     */
    private int usedFuel;

    /**
     * The rental time of the speedboat.
     */
    private int timeRented;

    /**
     * Is this rental record closed or is the speedboat currently rented?
     */
    private boolean rented;

    /**
     * Did the renter break our boat?
     */
    private boolean damage;

    /**
     * The name of the customer that rented the speedboat.
     */
    private String customerName;

    /**
     * Initiate an empty rental record.
     */
    Rental()
    {}

    /**
     * Initiate an rental record.
     * @param boatId The unique identification code of the rented speedboat.
     * @param usedFuel The amount of fuel used during the rental.
     * @param timeRented The rental time of the speedboat.
     * @param rented Is this rental record closed or is the speedboat currently rented?
     * @param damage Did the renter break our boat?
     * @param customerName The name of the customer that rented the speedboat.
     */
    Rental( String boatId, int usedFuel, int timeRented, boolean rented, boolean damage, String customerName )
    {
        this.boatId=boatId;
        this.usedFuel=usedFuel;
        this.timeRented=timeRented;
        this.rented=rented;
        this.damage=damage;
        this.customerName=customerName;
    }

    /**
     * Initiate an new rental record, use this constructor to rent an speedboat.
     * @param boatId The unique identification code of the rented speedboat.
     * @param customerName The name of the customer that rented the speedboat.
     */
    Rental( String boatId, String customerName )
    {
        this.boatId=boatId;
        this.customerName=customerName;
    }

    /**
     * Sets The unique identification code of the rented speedboat.
     */
    String getBoatId()
    {
        return boatId;
    }

    /**
     * Gets The unique identification code of the rented speedboat.
     */
    Rental setBoatId( String boatId )
    {
        this.boatId=boatId;
        return this;
    }

    /**
     * Gets The amount of fuel used during the rental.
     */
    int getUsedFuel()
    {
        return usedFuel;
    }

    /**
     * Sets The amount of fuel used during the rental.
     */
    Rental setUsedFuel( int usedFuel )
    {
        this.usedFuel=usedFuel;
        return this;
    }

    /**
     * Gets The rental time of the speedboat.
     */
    int getTimeRented()
    {
        return timeRented;
    }

    /**
     * Sets The rental time of the speedboat.
     */
    Rental setTimeRented( int timeRented )
    {
        this.timeRented=timeRented;
        return this;
    }

    /**
     * Is this rental record closed or is the speedboat currently rented?
     */
    boolean isRented()
    {
        return rented;
    }

    /**
     * Is this rental record closed or is the speedboat currently rented?
     */
    Rental setRented( boolean rented )
    {
        this.rented=rented;
        return this;
    }

    /**
     * Did the renter break our boat?
     */
    boolean isDamage()
    {
        return damage;
    }

    /**
     * Did the renter break our boat?
     */
    Rental setDamage( boolean damage )
    {
        this.damage=damage;
        return this;
    }

    /**
     * Gets The name of the customer that rented the speedboat.
     */
    String getCustomerName()
    {
        return customerName;
    }

    /**
     * Sets The name of the customer that rented the speedboat.
     */
    Rental setCustomerName( String customerName )
    {
        this.customerName=customerName;
        return this;
    }

    /**
     * This method gets called when the object is printed as an string.
     * @return String An text representation of the rentals attributes.
     */
    @Override
    public String toString()
    {
        return "Rental{ " +
                "boatId=" + boatId  +
                ", usedFuel=" + usedFuel +
                ", timeRented=" + timeRented +
                ", rented=" + rented +
                ", damage=" + damage +
                ", customerName='" + customerName + '\'' +
                " }";
    }
}
