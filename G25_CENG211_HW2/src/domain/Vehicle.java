package domain;

public class Vehicle {
	private String vehicleID;
	private String monthOfSale;
	private String cityOfSale;
	private int productionYear;
	private int vat;
	
	/*
	 * Default constructor
	 */
	Vehicle(){
		this("","","",0,0);
	}
	/*
	 * This constructor takes vehicle information details and creates an vehicle object.
	 */
	
	Vehicle(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, int vat){
		this.vehicleID = vehicleID;
		this.monthOfSale = monthOfSale;
		this.cityOfSale=cityOfSale;
		this.productionYear = productionYear;
		this.vat=vat;
	}
	/*
	 * This copy constructor creates a vehicle object by copying another vehicle object's datas.
	 * @param otherVehicle: a non-null Vehicle object
	 */
    Vehicle(Vehicle otherVehicle){
        this.vehicleID= otherVehicle.vehicleID;
        this.monthOfSale=otherVehicle.monthOfSale;
        this.cityOfSale=otherVehicle.cityOfSale;
        this.productionYear=otherVehicle.productionYear;
        this.vat=otherVehicle.vat;
    }
    public double getSCTofMonthOfSale() {
    	switch(monthOfSale) {
    	case "January":
    		return 0.3;
		case "May":
    		return 0.4;
    	case "August":
    		return 0.5;
    	case "October":
    		return 0.6;
    	case "December":
    		return 0.7;
    	default:
    		return 0.0;
    	}
    }
    
       
    public double getSCTofCityOfSale(){
		switch (cityOfSale) {
		case "Izmir": {
			return 0.1;	
		}
		case "Istanbul": {
			return 0.2;
		}
		case "Ankara":{
			return 0.3;
		}
		default:
			return 0.0;
		}
	}
   

    public double getSCTofProductionYear() {
    	if(2001<=productionYear && productionYear<=2008) {
    		return 1.0;
    	}
		else if(2012<=productionYear && productionYear<=2017) {
			return 1.2;
		}
		else if(2018<=productionYear && productionYear<=2022) {
			return 1.6;
		}	
		else {
			return 0.0;
		}
    }
	// 
  
	public String toString() {
        if(vehicleID.startsWith("S")){
            return "Vehicle: Sedan "+"Vehicle ID: "+vehicleID+ " Mont:  "+monthOfSale+" City: "+cityOfSale+" "+productionYear;
        }
         if(vehicleID.startsWith("M")){
            return "Vehicle: Minivan "+"Vehicle ID: "+vehicleID+ " Mont:  "+monthOfSale+" City: "+cityOfSale+" "+productionYear;
        }
         if(vehicleID.startsWith("H")){
            return "Vehicle: Hatchback "+"Vehicle ID: "+vehicleID+ " Mont:  "+monthOfSale+" City: "+cityOfSale+" "+productionYear;
        }
         if(vehicleID.startsWith("B")){
            return "Vehicle: Bicycle "+"Vehicle ID: "+vehicleID+ " Mont:  "+monthOfSale+" City: "+cityOfSale+" "+productionYear;
        }
         if(vehicleID.startsWith("P")){
            return "Vehicle: Pickup "+"Vehicle ID: "+vehicleID+ " Mont:  "+monthOfSale+" City: "+cityOfSale+" "+productionYear;
        }
        return null;
	}
	public double calculateTotalPrice(){
		return 0; 
	}
	  public String getMonthOfSale() {
			return monthOfSale;
		}
		public String getVehicleId() {
			return vehicleID;
		}
		public String getCityOfSale() {
			return cityOfSale;
		}
		public int getProductionYear() {
			return productionYear;
		}

		public int getVat() {
			return vat;
		}
		
}

		