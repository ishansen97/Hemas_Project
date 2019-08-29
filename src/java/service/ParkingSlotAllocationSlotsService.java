/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.ParkingSlotAllocationSlots;
import java.util.ArrayList;
import java.util.List;
import model.DeleteParkingSlotAllocationSlotsRequest;
import model.GetParkingSlotAllocationSlotsRequest;
import model.GetParkingSlotAllocationSlotsResponse;
import model.InsertParkingSlotAllocationSlotsRequest;
import model.UpdateParkingSlotAllocationSlotsRequest;
import repository.ParkingSlotAllocationSlotsRepository;

/**
 *
 * @author Ishan
 */
public class ParkingSlotAllocationSlotsService {
    public static ParkingSlotAllocationSlotsRepository parkingSlotAllocationSlotsRepo = new ParkingSlotAllocationSlotsRepository();
    
    public static boolean insertParkingSlotAllocationSlots(InsertParkingSlotAllocationSlotsRequest request) {
        ParkingSlotAllocationSlots parkingSlotAllocationSlots = new ParkingSlotAllocationSlots();
        
        parkingSlotAllocationSlots.setAllocation_Id(request.getAllocation_Id());
        parkingSlotAllocationSlots.setSlot_no(request.getSlot_no());
        
        return parkingSlotAllocationSlotsRepo.insertParkingSlotAllocationSlots(parkingSlotAllocationSlots);
    }
    
    public static GetParkingSlotAllocationSlotsResponse getParkingSlotAllocationSlots(GetParkingSlotAllocationSlotsRequest request) {
        GetParkingSlotAllocationSlotsResponse response = new GetParkingSlotAllocationSlotsResponse();
        int id = request.getAllocation_Id();
        int slot_no = request.getSlot_no();
        
        ParkingSlotAllocationSlots parkingSlotAllocationSlots = parkingSlotAllocationSlotsRepo.getParkingSlotAllocationSlots(id, slot_no);
        
        response.setAllocation_Id(parkingSlotAllocationSlots.getAllocation_Id());
        response.setSlot_no(parkingSlotAllocationSlots.getSlot_no());
        
        return response;
    }
    
    public static boolean updateParkingSlotAllocationSlots(UpdateParkingSlotAllocationSlotsRequest request) {
        ParkingSlotAllocationSlots parkingSlotAllocationSlots = new ParkingSlotAllocationSlots();
        
        parkingSlotAllocationSlots.setAllocation_Id(request.getAllocation_Id());
        parkingSlotAllocationSlots.setSlot_no(request.getSlot_no());
        
        return parkingSlotAllocationSlotsRepo.updateParkingSlotAllocationSlots(parkingSlotAllocationSlots);
    }
    
    public static boolean deleteParkingSlotAllocationSlots(DeleteParkingSlotAllocationSlotsRequest request) {
        int id = request.getAllocation_Id();
        
        return parkingSlotAllocationSlotsRepo.deleteParkingSlotAllocationSlots(id);
    }
    
    
    public static List<GetParkingSlotAllocationSlotsResponse> getAllParkingSlotAllocations() {
        List<ParkingSlotAllocationSlots> parkingSlotAllocationSlotsList = parkingSlotAllocationSlotsRepo.getAllParkingSlotAllocations();
        List<GetParkingSlotAllocationSlotsResponse> responseList = new ArrayList<>();
        
        for (ParkingSlotAllocationSlots parkingSlotAllocationSlots: parkingSlotAllocationSlotsList) {
            GetParkingSlotAllocationSlotsResponse response = new GetParkingSlotAllocationSlotsResponse();
            
            response.setAllocation_Id(parkingSlotAllocationSlots.getAllocation_Id());
            response.setSlot_no(parkingSlotAllocationSlots.getSlot_no());
            
            responseList.add(response);
        }
        
        return responseList;
    }
}
