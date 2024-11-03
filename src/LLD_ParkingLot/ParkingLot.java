package LLD_ParkingLot;

import LLD_ParkingLot.Constants.Type;

import java.math.BigDecimal;
import java.util.*;

public class ParkingLot {
    private static ParkingLot parkingLot = null;

    Scanner sc;

    String parkingID;

    int floor;

    int slots;

    Vehicle vehicle;

    HashMap<String,String> log;

    PriorityQueue<Float> carAvailability;
    PriorityQueue<Float> truckAvailability;
    PriorityQueue<Float> bikeAvailability;


    private ParkingLot(){
        sc = new Scanner(System.in);
        log = new HashMap<>();
        carAvailability = new PriorityQueue<Float>();
        truckAvailability = new PriorityQueue<Float>();
        bikeAvailability  = new PriorityQueue<Float>();
    }

    public void create(){
        String input = sc.nextLine();
        String[] value = input.split(" ");
        parkingID = value[1];
        floor = Integer.parseInt(value[2]);
        slots = Integer.parseInt(value[3]);
        for(int i = 1; i <= floor; ++i){
            for(int j = 1; j <= slots; ++j){
                float f = i;
                for(int k = 1)
                float s = 1 - (10 - j)/10;

                float slot =
                if(j == 1){
                    truckAvailability.add(slot);
                }else if(j < 4){
                    bikeAvailability.add(slot);
                }else{
                    carAvailability.add(slot);
                }
            }
        }
        System.out.println("Created parking lot with "+ floor +" floors and "+ slots +" slots per floor");
    }

    public static ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void open() {
        while(true){
            String input = sc.nextLine();
            if(input.charAt(0) == 'e'){
                break;
            }

            String[] cmd = input.split(" "); //park_vehicle CAR KA-02-CB-1334 red
            vehicle = new Vehicle(cmd[1],cmd[2],cmd[3]);
            createTicket(vehicle);

        }
    }
   //parkingID_floor_slot

//    12.00
//    0.8
//    12.80
    private void createTicket(Vehicle vehicle) {
        Type type = vehicle.type;
        if(type.equals(Type.CAR) && !carAvailability.isEmpty()){
            Integer availableSlot =
            String ticketID = parkingID;
            ticketID += "_";

        }
    }
}
