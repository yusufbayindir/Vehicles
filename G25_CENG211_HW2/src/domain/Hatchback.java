package domain;

public class Hatchback extends Automobile {
	String cityMode;
	/*
	 * Default constructor
	 */
	Hatchback() {
		super();
		this.cityMode="";
	}
	/*
	 * This constructor takes hatchback information details and creates an hatchback object.
	 */
	Hatchback(String vehicleID, String monthOfSale, String cityOfSale, int productionYear,int vat, double engineVolume,String cityMode){
		super(vehicleID,monthOfSale,cityOfSale,productionYear,vat, engineVolume);
		this.cityMode=cityMode;
	}
	 /*
		 * This copy constructor creates a hatchback object by copying another hatchback object's datas.
		 * @param otherHatchback: a non-null Hatchback object
		 */
	Hatchback(Hatchback otherHatchback){
		super(otherHatchback);
		this.cityMode= otherHatchback.cityMode;
	}
	public String getCityMode() {
		return cityMode;
	}

	public double getSCTofCityMode(){
		switch(cityMode){
			case "yes":
			  return 0.15;
			case "no":
			  return 0.1;
			default:
			  return 0;
		}
	}
	public double calculateSCT(){
		return (getEngineVolume()*0.3*getSCTofProductionYear())+getSCTofCityMode();
	}
	public double calculateTotalPrice() {
    	return super.calculateTotalPrice(calculateSCT());
    }

	public String toString(){
		return "Vehicle: Hatchback "+"Vehicle ID: "+getVehicleId()+ " Mont:  "+getMonthOfSale()+" City: "+getCityOfSale()+" Production Year: "+getProductionYear()+" SCT: "+calculateSCT()+" The total price paid for :  "+getVehicleId()+" "+calculateTotalPrice()+"TL";
	}
	
}
