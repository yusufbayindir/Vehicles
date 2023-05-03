package domain;

import java.io.IOException;
import java.util.ArrayList;

import dataAccess.FileOpen;

public class SalesRecord {
	private ArrayList<ArrayList<String>> contentsOfFile;
	private ArrayList<PickupTruck> pickupList;
	private ArrayList<Bicycle> bicycleList;
    private ArrayList<Sedan> sedanList;
    private ArrayList<Minivan> minivanList;
    private ArrayList<Hatchback> hatchbackList;
	private ArrayList<Vehicle> vehicleList;

     public SalesRecord(){
        this.contentsOfFile=null;
        this.pickupList=null;
        this.bicycleList=null;
        this.sedanList=null;
        this.minivanList=null;
        this.hatchbackList=null;
    }
     
     /*
      * This method creates an ArrayList which holds other ArrayLists.
      */
	private void createTwoDim() throws IOException {
		this.contentsOfFile=FileOpen.getTwoDim("HW2_SoldVehicles.csv");
	}
	public void createPickUpList() throws IOException {
		createTwoDim();
		this.pickupList=new ArrayList<>();
		/*
		 * loop for finding which ArrayLists holds datas of Pickups
		 * and adding them to an ArrayList which holds PickupTruck objects.
		 */
		for(ArrayList<String> temp:contentsOfFile) {
			if(temp.get(0).startsWith("P")) {
				pickupList.add(new PickupTruck(temp.get(0),temp.get(1),temp.get(2),Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(6)),temp.get(4),temp.get(5)));
			}
		}
		pickupList.trimToSize();
	}
	public void createBicycleList() throws IOException {
		createTwoDim();
		this.bicycleList=new ArrayList<>();
		/*
		 * loop for finding which ArrayLists holds datas of Bicycles
		 * and adding them to an ArrayList which holds Bicycle objects.
		 */
		for(ArrayList<String> temp:contentsOfFile) {
			if(temp.get(0).startsWith("B")) {
				bicycleList.add(new Bicycle(temp.get(0),temp.get(1),temp.get(2),Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(6)),temp.get(4),temp.get(5)));
			}
		}
		bicycleList.trimToSize();
	}
    	public void createSedanList() throws IOException {
		createTwoDim();
		this.sedanList=new ArrayList<>();
		/*
		 * loop for finding which ArrayLists holds datas of Sedans
		 * and adding them to an ArrayList which holds Sedan objects.
		 */
		for(ArrayList<String> temp:contentsOfFile) {
			if(temp.get(0).startsWith("S")) {
				sedanList.add(new Sedan(temp.get(0),temp.get(1),temp.get(2),Integer.parseInt(temp.get(3)),Double.parseDouble(temp.get(5)),Integer.parseInt(temp.get(6)),temp.get(4)));
			}
		}
		sedanList.trimToSize();
	}
    public void createMinivanList() throws IOException {
		createTwoDim();
		this.minivanList=new ArrayList<>();
		/*
		 * loop for finding which ArrayLists holds datas of Minivan
		 * and adding them to an ArrayList which holds Minivan objects.
		 */
		for(ArrayList<String> temp:contentsOfFile) {
			if(temp.get(0).startsWith("M")) {
				minivanList.add(new Minivan(temp.get(0),temp.get(1),temp.get(2),Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(6)),Double.parseDouble(temp.get(5)),Integer.parseInt(temp.get(4))));
			}
		}
		minivanList.trimToSize();
	}

    public void createHatchbackList() throws IOException {
		createTwoDim();
		this.hatchbackList=new ArrayList<>();
		/*
		 * loop for finding which ArrayLists holds datas of Hatchbacks
		 * and adding them to an ArrayList which holds Hatchback objects.
		 */
		for(ArrayList<String> temp:contentsOfFile) {
			if(temp.get(0).startsWith("H")) {
				hatchbackList.add(new Hatchback(temp.get(0),temp.get(1),temp.get(2),Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(6)),Double.parseDouble(temp.get(5)),temp.get(4)));
			}
		}
		hatchbackList.trimToSize();
	}
    
    public void createVehicleList() throws IOException {
    	createTwoDim();
    	this.vehicleList=new ArrayList<>();
    	createPickUpList();
    	createBicycleList();
    	createHatchbackList();
    	createMinivanList();
    	createSedanList(); 
    	/*
    	 * loops for adding all kind of vehicles to an ArrayList of Vehicle.
    	 */
    	for(Vehicle temp:pickupList) {
    		vehicleList.add(temp);
    	}
    	for(Vehicle temp:bicycleList) {
    		vehicleList.add(temp);
    	}
    	for(Vehicle temp:hatchbackList) {
    		vehicleList.add(temp);
    	}
    	for(Vehicle temp:minivanList) {
    		vehicleList.add(temp);
    	}
    	for(Vehicle temp:sedanList) {
    		vehicleList.add(temp);
    	}
		vehicleList.trimToSize();
    	
    }


	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public ArrayList<ArrayList<String>> getContentsOfFile() {
		return contentsOfFile;
	}
	public ArrayList<PickupTruck> getPickupList() {
		return pickupList;
	}
	public ArrayList<Bicycle> getBicycleList() {
		return bicycleList;
	}
	public ArrayList<Sedan> getSedanList() {
		return sedanList;
	}
	public ArrayList<Minivan> getMinivanList() {
		return minivanList;
	}
	public ArrayList<Hatchback> getHatchbackList() {
		return hatchbackList;
	}

}
