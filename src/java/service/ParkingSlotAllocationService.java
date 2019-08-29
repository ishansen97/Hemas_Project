/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.ParkingSlotAllocation;
import java.util.ArrayList;
import java.util.List;
import model.DeleteParkingSlotAllocationRequest;
import model.GetParkingSlotAllocationRequest;
import model.GetParkingSlotAllocationResponse;
import model.InsertParkingSlotAllocationRequest;
import model.UpdateParkingSlotAllocationRequest;
import repository.ParkingSlotAllocationRepository;

/**
 *
 * @author Ishan
 */
public class ParkingSlotAllocationService {
    public static ParkingSlotAllocationRepository parkingSlotAllocationRepo = new ParkingSlotAllocationRepository();
    
    public static boolean insertParkingSlotAllocation(InsertParkingSlotAllocationRequest request) {
        ParkingSlotAllocation parkingSlotAllocation = new ParkingSlotAllocation();
        
        parkingSlotAllocation.setP_Name(request.getP_Name());
        parkingSlotAllocation.setDay_type(request.getDay_type());
        
        return parkingSlotAllocationRepo.insertParkingSlotAllocation(parkingSlotAllocation);
    }
    
    public static GetParkingSlotAllocationResponse getParkingSlotAllocation(GetParkingSlotAllocationRequest request) {
        GetParkingSlotAllocationResponse response = new GetParkingSlotAllocationResponse();
        int id = request.getAllocationId();
        
        ParkingSlotAllocation parkingSlotAllocation = parkingSlotAllocationRepo.getParkingSlotAllocation(id);
        
        response.setAllocationId(parkingSlotAllocation.getAllocationId());
        response.setP_Name(parkingSlotAllocation.getP_Name());
        response.setDay_type(parkingSlotAllocation.getDay_type());
        
        return response;
    }
    
    public static boolean updateParkingSlotAllocation(UpdateParkingSlotAllocationRequest request) {
        ParkingSlotAllocation parkingSlotAllocation = new ParkingSlotAllocation();
        
        parkingSlotAllocation.setAllocationId(request.getAllocationId());
        parkingSlotAllocation.setP_Name(request.getP_Name());
        parkingSlotAllocation.setDay_type(request.getDay_type());
        
        return parkingSlotAllocationRepo.updateParkingSlotAllocation(parkingSlotAllocation);
    }
    
    public static boolean deleteParkingSlotAllocation(DeleteParkingSlotAllocationRequest request) {
        int id = request.getAllocationId();
        
        return parkingSlotAllocationRepo.deleteParkingSlotAllocation(id);
    }
    
    
    public static List<GetParkingSlotAllocationResponse> getAllParkingSlotAllocations() {
        List<ParkingSlotAllocation> parkingSlotAllocationList = parkingSlotAllocationRepo.getAllParkingSlotAllocations();
        List<GetParkingSlotAllocationResponse> responseList = new ArrayList<>();
        
        for (ParkingSlotAllocation parkingSlotAllocation: parkingSlotAllocationList) {
            GetParkingSlotAllocationResponse response = new GetParkingSlotAllocationResponse();
            
            response.setAllocationId(parkingSlotAllocation.getAllocationId());
            response.setP_Name(parkingSlotAllocation.getP_Name());
            response.setDay_type(parkingSlotAllocation.getDay_type());
            
            responseList.add(response);
        }
        
        return responseList;
    }
    
}
