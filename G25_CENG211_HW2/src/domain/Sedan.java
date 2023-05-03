package domain;

public class Sedan extends Automobile{
	private String roofType;
	/*
	 * Default constructor
	 */
	Sedan(){
		super();
		this.roofType="";
	}
	/*
	 * This constructor takes sedan information details and creates an sedan object.
	 */
	Sedan(String vehicleID, String monthOfSale, String cityOfSale, int productionYear,double engineVolume,int vat,String roofType){
		super(vehicleID,monthOfSale,cityOfSale,productionYear,vat,engineVolume);
		this.roofType=roofType;
	}
	 /*
		 * This copy constructor creates a sedan object by copying another sedan object's datas.
		 * @param otherSedan: a non-null Sedan object
		 */
	Sedan(Sedan otherSedan){
		super(otherSedan);
		this.roofType=otherSedan.roofType;
	}
	public String getRoofType() {
		return roofType;
	}
	
	public double calculateSCT() {
		return (getEngineVolume() * 0.2 * getSCTofRoofType()) / getSCTofProductionYear();
	}
	

	public double getSCTofRoofType(){
		switch(roofType){
			case "regular":
			  return 0.5;
			case "moonroof":
			  return 0.6;
			case "sunroof":
			  return 0.8;
			default:
			   return 0;
		}
	}
	public double calculateTotalPrice() {
    	return super.calculateTotalPrice(calculateSCT());
    }

	public String toString(){
		return "Vehicle: Sedan "+"Vehicle ID: "+getVehicleId()+ " Mont:  "+getMonthOfSale()+" City: "+getCityOfSale()+" Production Year: "+getProductionYear()+" SCT: "+calculateSCT()+" The total price paid for :  "+getVehicleId()+" "+calculateTotalPrice()+"TL";
	}
}
