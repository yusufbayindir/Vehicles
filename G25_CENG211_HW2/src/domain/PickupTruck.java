package domain;

public class PickupTruck extends Vehicle{

    private String cabType;
    private String truckBedType;
    public static final double BASEPRICE= 250000.0;
    
    /*
     * Default constructor
     */
    PickupTruck(){
		super();
    	this.cabType="";
    	this.truckBedType="";
	}
    /*
	 * This constructor takes pickup truck information details and creates an pickup truck object.
	 */

    PickupTruck(String vehicleID, String monthOfSale, String cityOfSale, int productionYear,int vat,String cabType, String truckBedType){
        super(vehicleID,monthOfSale,cityOfSale,productionYear,vat);
        this.cabType=cabType;
        this.truckBedType = truckBedType;
    }
    /*
   	 * This copy constructor creates a PickupTruck object by copying another PickupTruck object's datas.
   	 * @param otherPickup: a non-null PickupTruck object
   	 */
    PickupTruck(PickupTruck otherPickup){
		super(otherPickup);
		this.cabType=otherPickup.cabType;
        this.truckBedType = otherPickup.truckBedType;
	}

    public String getCabType(){
        return cabType;
    }
     public String getTruckBedType(){
        return truckBedType;
    }

    public double getSCTofCabType(){
        switch(cabType){
            case "regular":
              return 2.5;
            case "extended":
              return 2.8;
            case "crew":
              return 3;
            default:
              return 0.0;
        }
    }
    public double getSCTofTruckBedType(){
        switch(truckBedType){
            case "regular":
              return 0.5;
            case "tanker":
              return 0.8;
            case "trailer":
              return 1.0;
            default:
              return 0.0;
        }
    }
    public double calculateSCT() {
    	return (getSCTofTruckBedType() * getSCTofProductionYear()) / getSCTofCabType();
    }
    public double calculateTotalPrice(){
		return (BASEPRICE) * (1 + (calculateSCT() * 0.6)) + (1 + getVat()/100); 
	}

    public String toString(){
        return "Vehicle: PickUp Truck "+"Vehicle ID: "+getVehicleId()+ " Mont:  "+getMonthOfSale()+" City: "+getCityOfSale()+" Production Year: "+getProductionYear()+" SCT: "+calculateSCT()+" The total price paid for :  "+getVehicleId()+" "+calculateTotalPrice()+"TL";
    }

}
