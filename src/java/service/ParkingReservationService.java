/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.ParkingReservation;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.InsertParkingReservationRequest;
import repository.ParkingReservationRepository;

/**
 *
 * @author Ishan
 */
public class ParkingReservationService {
    public static ParkingReservationRepository parkingReservationRepo = new ParkingReservationRepository();
    
    public static boolean insertParkingReservation(InsertParkingReservationRequest request) {
        ParkingReservation parkingReservation = new ParkingReservation();
        
        String reservation_no = parkingReservationRepo.generateNewReservationNo();
        
        Timestamp time = Timestamp.valueOf(request.getDate() + " " + request.getTime_to_arrive());
        
        
        
        parkingReservation.setReservation_no(reservation_no);
        parkingReservation.setTelephone_no(request.getTelephone_no());
        parkingReservation.setTime_to_arrive(time);
        parkingReservation.setParking_slot_no(request.getParking_slot_no());
        parkingReservation.setP_name(request.getP_name());
        
        return parkingReservationRepo.insertParkingReservation(parkingReservation);
    }
    
}
