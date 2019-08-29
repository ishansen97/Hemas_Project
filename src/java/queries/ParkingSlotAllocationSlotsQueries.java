/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

/**
 *
 * @author Ishan
 */
public class ParkingSlotAllocationSlotsQueries {

    public static String INSERT_PARKINGSLOTALLOCATIONSLOTS = "Insert Into  parking_slot_allocation_slots (allocation_Id, slot_no) Values (?,?)";
    public static String GET_PARKINGSLOTALLOCATIONSLOTS = "Select * From parking_slot_allocation_slots Where allocation_Id = ?, slot_no = ?";
    public static String UPDATE_PARKINGSLOTALLOCATIONSLOTS = "Update parking_slot_allocation_slots Set slot_no = ? Where allocation_Id = ?";
    public static String DELETE_PARKINGSLOTALLOCATIONSLOTS = "Delete From parking_slot_allocation_slots Where allocation_Id = ?";
    public static String GET_ALL_PARKINGSLOTALLOCATIONSLOTS = "Select * From parking_slot_allocation_slots";
    
}
