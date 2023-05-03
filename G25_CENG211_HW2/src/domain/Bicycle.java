package domain;

public class Bicycle extends Vehicle{
    private String chainType;
    private String seatPost;
    public static final double BASEPRICE= 10000.0;
    
    /*
     * Default constructor
     */
    Bicycle(){
        super();
        this.chainType = "";
        this.seatPost = "";
       
    }
    /*
	 * This constructor takes bicycle information details and creates an bicycle object.
	 */
    Bicycle(String vehicleID, String monthOfSale, String cityOfSale, int productionYear,int vat,String chainType,String seatPost){
        super(vehicleID, monthOfSale, cityOfSale, productionYear,vat);
        this.chainType=chainType;
        this.seatPost=seatPost;
    }
    
    /*
	 * This copy constructor creates a bicycle object by copying another bicycle object's datas.
	 * @param otherBicycle: a non-null Bicycle object
	 */
    Bicycle(Bicycle otherBicycle){
        super(otherBicycle);
        this.chainType = otherBicycle.chainType;
        this.seatPost = otherBicycle.seatPost;
    }
    public double calculateSCTofBicycle(){
		return (getSCTofChainType() * getSCTofSeatPost() * 0.1) + getSCTofMonthOfSale() ; 
	}
	public double calculateTotalPrice(){
		return (BASEPRICE * 0.9) * (1+calculateSCTofBicycle()) * (1 + getVat() / 100); 
	}
    public double getSCTofChainType() {
    	switch(chainType) {
    	case "derailleur":{
    		return 1.1;
    	}
    	case "onechain":{
    		return 1.2;
    	}
    	case "doublechain":{
    		return 1.3;
    	}
    	default:{
    		return 0;
    	}
    	}
    }

    
    public double getSCTofSeatPost(){
        switch (seatPost) {
		case "carbonfiber": {
			return 0.8;	
		}
		case "steel": {
			return 0.7;
		}
		case "aluminum":{
			return 0.9;
		}
        case "titanium":{
			return 0.6;
		}
		default:
			return 0.0;
		}
    }

    public String toString(){
        return "Vehicle: Bicycle "+"Vehicle ID: "+getVehicleId()+ " Month: "+getMonthOfSale()+" City: "+getCityOfSale()+" Production Year :  "+getProductionYear() + " SCT: "+calculateSCTofBicycle() + " The total price paid for : " + calculateTotalPrice() ;
    }

}
