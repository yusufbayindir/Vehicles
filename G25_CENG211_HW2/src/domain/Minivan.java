package domain;

public class Minivan extends Automobile{
    private int numberOfSeats;
    
/*
 * Default constructor
 */
    Minivan(){
        super();
        this.numberOfSeats=0;
    }
    /*
	 * This constructor takes minivan information details and creates an minivan object.
	 */
    Minivan(String vehicleID, String monthOfSale, String cityOfSale, int productionYear,int vat,double engineVolume, int numberOfSeats){
        super(vehicleID,monthOfSale,cityOfSale,productionYear,vat,engineVolume);
        this.numberOfSeats=numberOfSeats;
    }
    /*
   	 * This copy constructor creates a minivan object by copying another minivan object's datas.
   	 * @param otherMinivan: a non-null Minivan object
   	 */
    Minivan(Minivan otherMinivan){
        super(otherMinivan);
        this.numberOfSeats=otherMinivan.numberOfSeats;
    }

    public int getNumberOfSeats(){
        return this.numberOfSeats;
    }

    public double getSCTofNumberOfSeats(){
        switch(numberOfSeats){
            case 4:
              return 0.1;
            case 5:
              return 0.4;
            case 6:
              return 0.6;
            case 7:
              return 0.8;
            default:
              return 0;
        }
    }
    public double calculateSCT(){
      return (0.6 * getSCTofProductionYear()) / (getEngineVolume() + getSCTofNumberOfSeats());
    }
    public double calculateTotalPrice() {
    	return super.calculateTotalPrice(calculateSCT());
    }

    public String toString(){
      return "Vehicle: Minivan "+"Vehicle ID: "+getVehicleId()+ " Mont:  "+getMonthOfSale()+" City: "+getCityOfSale()+" Production Year: "+getProductionYear()+" SCT: "+calculateSCT()+" The total price paid for :  "+getVehicleId()+" "+calculateTotalPrice()+"TL";
    }
}
