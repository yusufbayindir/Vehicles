package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	/*
	 * This method asks to user that which category of vehicle information they wanted to see 
	 * and displays the wanted category.
	 */
	public static void application() throws IOException {
		SalesRecord salesRecord = new SalesRecord();
        salesRecord.createVehicleList();
        ArrayList<Vehicle>vehicleList=salesRecord.getVehicleList();
        ArrayList<Minivan>minivanList= salesRecord.getMinivanList();
        ArrayList<Hatchback>hatchbackList= salesRecord.getHatchbackList();
        ArrayList<Sedan>sedanList= salesRecord.getSedanList();
        ArrayList<Bicycle>bicycleList= salesRecord.getBicycleList();
        ArrayList<PickupTruck>pickupList=salesRecord.getPickupList();
        
        boolean isValid=true;
        /*
         * This loop asks the user for a valid input until they exit the program.
         */
        while (isValid){
      	System.out.println("Please press,\n0 to exit\n1 to see all sold vehicles list \n2 to see sold sedan list \n3 to see sold hatchback list \n4 to see sold minivan list \n5 to see sold pickup truck list \n6 to see sold bicycle list");
        Scanner tempScanner = new Scanner(System.in);
        int choice= tempScanner.nextInt();
          switch(choice){
          case 0:
        	  System.out.println("Goodbye!!");
        	  isValid=false;
        	  tempScanner.close();
        	  break;
          case 1:
            for(Vehicle vehicle:vehicleList) {
              System.out.println(vehicle);
            }
              break;
          case 2:
            for(Sedan sedan:sedanList) {
              System.out.println(sedan);
            }
              break;
          case 3:
            for(Hatchback hatchback:hatchbackList) {
              System.out.println(hatchback);
            }
              break;
          case 4:
            for(Minivan minivan:minivanList) {
              System.out.println(minivan);
            }
              break;
          case 5:
              for(PickupTruck pickup:pickupList) {
              System.out.println(pickup);
            }
              break;
          case 6:
              for(Bicycle bicycle:bicycleList) {
              System.out.println(bicycle);
            }
              break;
          default:
              System.out.println("You entered invalid value.");
              break;
            }
          }

		
	}
}
