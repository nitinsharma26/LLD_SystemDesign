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

    //ticketId, Floor_Slot
    HashMap<String, String> log;

    PriorityQueue<String> carAvailability = new PriorityQueue<>((a, b) -> {
        // Split the strings at "_"
        String[] aParts = a.split("_");
        String[] bParts = b.split("_");

        // Compare the first part as integers
        int mainA = Integer.parseInt(aParts[0]);
        int mainB = Integer.parseInt(bParts[0]);

        // If the main parts are equal, compare the second parts as integers
        if (mainA == mainB) {
            int subA = Integer.parseInt(aParts[1]);
            int subB = Integer.parseInt(bParts[1]);
            return Integer.compare(subA, subB);
        }

        // Otherwise, compare the main parts
        return Integer.compare(mainA, mainB);
    });

    PriorityQueue<String> bikeAvailability = new PriorityQueue<>((a, b) -> {
        // Split the strings at "_"
        String[] aParts = a.split("_");
        String[] bParts = b.split("_");

        // Compare the first part as integers
        int mainA = Integer.parseInt(aParts[0]);
        int mainB = Integer.parseInt(bParts[0]);

        // If the main parts are equal, compare the second parts as integers
        if (mainA == mainB) {
            int subA = Integer.parseInt(aParts[1]);
            int subB = Integer.parseInt(bParts[1]);
            return Integer.compare(subA, subB);
        }

        // Otherwise, compare the main parts
        return Integer.compare(mainA, mainB);
    });

    PriorityQueue<String> truckAvailability = new PriorityQueue<>((a, b) -> {
        // Split the strings at "_"
        String[] aParts = a.split("_");
        String[] bParts = b.split("_");

        // Compare the first part as integers
        int mainA = Integer.parseInt(aParts[0]);
        int mainB = Integer.parseInt(bParts[0]);

        // If the main parts are equal, compare the second parts as integers
        if (mainA == mainB) {
            int subA = Integer.parseInt(aParts[1]);
            int subB = Integer.parseInt(bParts[1]);
            return Integer.compare(subA, subB);
        }

        // Otherwise, compare the main parts
        return Integer.compare(mainA, mainB);
    });
    
    HashMap<Integer,ArrayList<Integer>> carAvailableSlot=  new HashMap<>();
    HashMap<Integer,ArrayList<Integer>> truckAvailableSlot=  new HashMap<>();
    HashMap<Integer,ArrayList<Integer>> bikeAvailableSlot=  new HashMap<>();


    private ParkingLot() {
        sc = new Scanner(System.in);
        log = new HashMap<>();
    }

    public void create() {
        //create_parking_lot PR1234 2 6
        String input = sc.nextLine();
        String[] value = input.split(" ");
        parkingID = value[1];
        floor = Integer.parseInt(value[2]);
        slots = Integer.parseInt(value[3]);
        for (int i = 1; i <= floor; ++i) {
            for (int j = 1; j <= slots; ++j) {
                String slot = "";
                slot+=i;
                slot+="_";
                slot+=j;
                if (j == 1) {
                    ArrayList<Integer> temp = truckAvailableSlot.get(i);
                    if(temp == null)
                        temp = new ArrayList<>();
                    temp.add(j);
                    truckAvailableSlot.put(i,temp);
                    truckAvailability.add(slot);
                } else if (j < 4) {
                    ArrayList<Integer> temp = bikeAvailableSlot.get(i);
                    if(temp == null)
                        temp = new ArrayList<>();
                    temp.add(j);
                    bikeAvailableSlot.put(i,temp);
                    bikeAvailability.add(slot);
                } else {
                    ArrayList<Integer> temp = carAvailableSlot.get(i);
                    if(temp == null)
                        temp = new ArrayList<>();
                    temp.add(j);
                    carAvailableSlot.put(i,temp);
                    carAvailability.add(slot);
                }
            }
        }
        System.out.println("Created parking lot with " + floor + " floors and " + slots + " slots per floor");
    }

    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void open() {
        while (true) {
            String input = sc.nextLine();
            if (input.charAt(0) == 'e') {
                break;
            }

            String[] cmd = input.split(" ");

            //park_vehicle CAR KA-01-DB-1234 black
            if(cmd[0].equals("park_vehicle")){
                parkVehicle(cmd[1],cmd[2],cmd[3]);
            }else if(cmd[0].equals("unpark_vehicle")){
                unparkVehicle(cmd[1]);
            }
        }
    }

    private void unparkVehicle(String s) {
        if(log.containsKey(s)){
            //Unparked vehicle with Registration Number: WB-45-HO-9032 and Color: white
//            floor_slot_type_regs_color
            String temp = log.get(s);
            String[] s1 = temp.split("_");
            System.out.println("Unparked vehicle with Registration Number: "+ s1[3] +" and Color: "+ s1[4]);
            log.remove(s);
            if(s1[2].equals(Type.CAR)){
                String tt = s1[0]+s1[1];
                carAvailability.add(tt);
                int floor = Integer.parseInt(s1[0]);
                ArrayList<Integer> vec = carAvailableSlot.get(floor);
                vec.add(Integer.parseInt(s1[1]));
                carAvailableSlot.put(floor,vec);//updated nhi ho rha to delete krke add karenge
            }
            //same to all other

        }else{
            System.out.println("unpark_vehicle");
        }
    }

    private void parkVehicle(String type, String regi_no, String color) {
        //Parked vehicle. Ticket ID: PR1234_1_4
        String ticketId = parkingID;
        ticketId+="_";
        if(type.equals("CAR")){
            //floor_slot -> string
            if(carAvailability.isEmpty()){
                System.out.println("Parking Lot Full");
            }else{
                String top = carAvailability.poll();
                top+="_";
                top+=type;
                top+="_";
                top+=regi_no;
                top+="_";
                top+=color;
                String[] s = top.split("_");
                int floor = Integer.parseInt(s[0]);
                int slot = Integer.parseInt(s[1]);
                ticketId+=s[0];
                ticketId+="_";
                ticketId+=s[1];
                ArrayList<Integer> temp = carAvailableSlot.get(floor);
                temp.remove(slot);
                carAvailableSlot.put(floor,temp);
                log.put(ticketId,top);
            }
        }else if(type.equals(Type.BIKE)){
            if(bikeAvailability.isEmpty()){
                System.out.println("Parking Lot Full");
            }else{

            }
        }else if(type.equals(Type.TRUCK)){
            if(truckAvailability.isEmpty()){
                System.out.println("Parking Lot Full");
            }else{

            }
        }else{
            throw new IllegalCallerException("Unsupported Vehicle");
        }
    }
    //parkingID_floor_slot

}
