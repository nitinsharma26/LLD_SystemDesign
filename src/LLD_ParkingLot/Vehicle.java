package LLD_ParkingLot;

import LLD_ParkingLot.Constants.Type;

import java.security.PublicKey;

public class Vehicle {
    Type type;
    String registrationNo;
    String color;

    public Vehicle(String type,String registrationNo,String color){
        if(type.equals("CAR")){
            this.type = Type.CAR;
        }else if(type.equals("TRUCK")){
            this.type = Type.TRUCK;
        }else{
            this.type = Type.BIKE;
        }
        this.registrationNo = registrationNo;
        this.color = color;
    }

}
