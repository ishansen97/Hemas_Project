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
public class ParkingSlotAllocationQueries {

    public static String INSERT_PARKINGSLOTALLOCATION = "Insert Into parking_slot_allocation (P_Name, 	day_type) Values (?,?)";
    public static String GET_PARKINGSLOTALLOCATION = "Select * From parking_slot_allocation Where allocation_Id = ?";
    public static String UPDATE_PARKINGSLOTALLOCATION = "Update parking_slot_allocation Set P_Name = ?, day_type = ? Where allocation_Id = ?";
    public static String DELETE_PARKINGSLOTALLOCATION = "Delete From parking_slot_allocation Where allocation_Id = ?";
    public static String GET_ALL_PARKINGSLOTALLOCATIONS = "Select * From parking_slot_allocation";
    
}
