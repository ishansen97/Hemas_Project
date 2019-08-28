/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.ParkingSlot;
import java.util.ArrayList;
import java.util.List;
import model.DeleteParkingSlotRequest;
import model.GetParkingSlotRequest;
import model.GetParkingSlotResponse;
import model.InsertParkingSlotRequest;
import model.UpdateParkingSlotRequest;
import repository.ParkingSlotRepository;

/**
 *
 * @author Ishan
 */
public class ParkingSlotService {
    
    public static ParkingSlotRepository parkingSlotRepo = new ParkingSlotRepository();
    
    public static boolean insertParkingSlot(InsertParkingSlotRequest request) {
        ParkingSlot parkingSlot = new ParkingSlot();
        
        parkingSlot.setParking_slot_no(request.getParking_slot_no());
        parkingSlot.setP_name(request.getP_name());
        parkingSlot.setLocation(request.getLocation());
        
        return parkingSlotRepo.insertParkingSlot(parkingSlot);
    }
    
    public static GetParkingSlotResponse getParkingSlot(GetParkingSlotRequest request) {
        GetParkingSlotResponse response = new GetParkingSlotResponse();
        int id = request.getParking_slot_no();
        String p_name = request.getP_name();
        
        ParkingSlot parkingSlot = parkingSlotRepo.getParkingSlot(id, p_name);
        
        response.setParking_slot_no(parkingSlot.getParking_slot_no());
        response.setP_name(parkingSlot.getP_name());
        response.setLocation(parkingSlot.getLocation());
        
        return response;
    }
    
    public static boolean updateParkingSlot(UpdateParkingSlotRequest request) {
        ParkingSlot parkingSlot = new ParkingSlot();
        
        parkingSlot.setParking_slot_no(request.getParking_slot_no());
        parkingSlot.setP_name(request.getP_name());
        parkingSlot.setLocation(request.getLocation());
        
        return parkingSlotRepo.updateParkingSlot(parkingSlot);
    }
    
    public static boolean deleteParkingSlot(DeleteParkingSlotRequest request) {
        int id = request.getParking_slot_no();
        String p_name = request.getP_name();
        
        return parkingSlotRepo.deleteParkingSlot(id, p_name);
    }
    
    
    public static List<GetParkingSlotResponse> getAllParkingSlots() {
        List<ParkingSlot> parkingSlotList = parkingSlotRepo.getAllParkingSlots();
        List<GetParkingSlotResponse> responseList = new ArrayList<>();
        
        for (ParkingSlot parkingSlot: parkingSlotList) {
            GetParkingSlotResponse response = new GetParkingSlotResponse();
            
            response.setParking_slot_no(parkingSlot.getParking_slot_no());
            response.setP_name(parkingSlot.getP_name());
            response.setLocation(parkingSlot.getLocation());
            
            responseList.add(response);
        }
        
        return responseList;
    }
    
    public static List<GetParkingSlotResponse> getParkingSlotNumbers(GetParkingSlotRequest request) {
        List<ParkingSlot> parkingSlotList = parkingSlotRepo.getAllParkingSlots();
        List<GetParkingSlotResponse> responseList = new ArrayList<>();
        String requestPName = request.getP_name();
        
        for (ParkingSlot parkingSlot: parkingSlotList) {
            String p_name = parkingSlot.getP_name();
            
            if (requestPName.equals(p_name)) {
                GetParkingSlotResponse response = new GetParkingSlotResponse();
                
                response.setParking_slot_no(parkingSlot.getParking_slot_no());
                
                responseList.add(response);
            }
            
        }
        
        return responseList;
    }    
}
