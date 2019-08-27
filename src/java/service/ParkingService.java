/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Park;
import java.util.ArrayList;
import java.util.List;
import model.DeleteParkingRequest;
import model.GetParkingRequest;
import model.GetParkingResponse;
import model.InsertParkingRequest;
import model.UpdateParkingRequest;
import repository.ParkingRepository;

/**
 *
 * @author Ishan
 */
public class ParkingService {
    
    public static ParkingRepository parkingRepo = new ParkingRepository();
    
    public static boolean insertParking(InsertParkingRequest request) {
        Park parking = new Park();
        
        parking.setP_name(request.getP_name());
        parking.setP_location(request.getP_location());
        parking.setSlot_count(request.getSlot_count());
        parking.setType(request.getType());
        
        return parkingRepo.insertParking(parking);
    }
    
    public static GetParkingResponse getParking(GetParkingRequest request) {
        GetParkingResponse response = new GetParkingResponse();
        String p_name = request.getP_name();
        
        Park parking = parkingRepo.getParking(p_name);
        
        response.setP_name(parking.getP_name());
        response.setP_location(parking.getP_location());
        response.setSlot_count(parking.getSlot_count());
        response.setType(parking.getType());
        
        return response;
    }
    
    public static boolean updateParking(UpdateParkingRequest request) {
       Park parking = new Park();
        
        parking.setP_name(request.getP_name());
        parking.setP_location(request.getP_location());
        parking.setSlot_count(request.getSlot_count());
        parking.setType(request.getType());
        
        return parkingRepo.updateParking(parking);
    }
    
    public static boolean deleteParking(DeleteParkingRequest request) {
        String p_name = request.getP_name();
        
        return parkingRepo.deleteParking(p_name);
    }
    
    
    public static List<GetParkingResponse> getAllParkings() {
        List<Park> parkingList = parkingRepo.getAllParkings();
        List<GetParkingResponse> responseList = new ArrayList<>();
        
        for (Park parking: parkingList) {
            GetParkingResponse response = new GetParkingResponse();
            
            response.setP_name(parking.getP_name());
            response.setP_location(parking.getP_location());
            response.setSlot_count(parking.getSlot_count());
            response.setType(parking.getType());
            
            responseList.add(response);
        }
        
        return responseList;
    }
}
