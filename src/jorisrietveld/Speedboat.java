package jorisrietveld;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 05-04-2017 15:14
 * Licence: GPLv3 - General public licence version 3.
 * Teachers: Rob loves and  Winnie van Schilt
 * <p>
 * ======================================================================
 * ===               Java final assignment id: 10                 ===
 * ======================================================================
 * An short description about the project
 * ----------------------------------------------------------------------
 * An speedboat rental company wants to digitize there rental records.
 * The company owns 10 speedboats and they want to record what speedboat
 * get rented on what date, the amount of fuel that was used, the total
 * profit earned and the damage that the speedboat accumulated during
 * the speedboat rental.
 */
public class Speedboat
{
    /**
     * The weight of the speedboat.
     */
    private int weight;

    /**
     * The amount of horsepower the speedboat has.
     */
    private int horsePower;

    /**
     * The length of the speedboat.
     */
    private int length;

    /**
     * The unique identification code of the speedboat.
     */
    private String id;

    /**
     * The price for renting the speedboat for one hour.
     */
    private double rentalPrice;

    /**
     * Initiate an new speedboat object.
     * @param weight The weight of the speedboat.
     * @param horsePower The amount of horsepower the speedboat has.
     * @param length The length of the speedboat.
     * @param id The unique identification code of the speedboat.
     * @param rentalPrice The price for renting the speedboat for one hour.
     */
    Speedboat( int weight, int horsePower, int length, String id, double rentalPrice )
    {
        this.weight=weight;
        this.horsePower=horsePower;
        this.length=length;
        this.id=id;
        this.rentalPrice=rentalPrice;
    }

    /**
     * Gets the weight of the speedboat.
     */
    int getWeight()
    {
        return weight;
    }

    /**
     * Sets the weight of the speedboat.
     */
    void setWeight( int weight )
    {
        this.weight=weight;
    }

    /**
     * Gets the amount of horse power the speedboat has.
     */
    int getHorsePower()
    {
        return horsePower;
    }

    /**
     * Sets the amount of horsepower the speedboat has.
     */
    void setHorsePower( int horsePower )
    {
        this.horsePower=horsePower;
    }

    /**
     * Gets the length of the speedboat.
     */
    int getLength()
    {
        return length;
    }

    /**
     * Sets the length of the speedboat.
     */
    void setLength( int length )
    {
        this.length=length;
    }

    /**
     * Gets the unique identification code of the speedboat.
     */
    String getId()
    {
        return id;
    }

    /**
     * Sets the unique identification code of the speedboat.
     */
    void setId( String id )
    {
        this.id=id;
    }

    /**
     * Gets the the speedboats rental price per hour.
     */
    double getRentalPrice()
    {
        return rentalPrice;
    }

    /**
     * Sets the the speedboats rental price per hour.
     */
    void setRentalPrice( double rentalPrice )
    {
        this.rentalPrice=rentalPrice;
    }

    /**
     * This method gets called when the object is printed as an string.
     * @return String An text representation of speedboats attributes.
     */
    @Override
    public String toString()
    {
        return new StringBuilder()
                .append( "Speedboat{ ")
                .append( "weight=" ).append( weight )
                .append( ", horsePower=" ).append( horsePower )
                .append( ", length=" ).append( length )
                .append( ", id=" ).append( id )
                .append(  ", rentalPrice=" ).append( rentalPrice )
                .append( "}" ).toString();
    }
}
