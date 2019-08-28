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
public class ParkingSlotQueries {
    public static final String INSERT_PARKINGSLOT = "Insert Into parking_slot (Parking_Slot_No, P_Name, location) Values (?,?,?)";
    public static final String GET_PARKINGSLOT = "Select * From parking_slot Where Parking_Slot_No = ? And P_Name = ?";
    public static final String UPDATE_PARKINGSLOT = "Update parking_slot Set location = ? Where Parking_Slot_No = ? AND P_Name = ?";
    public static final String DELETE_PARKINGSLOT = "Delete From parking_slot Where Parking_Slot_No = ? AND P_Name = ?";
    public static final String GET_ALL_PARKINGSLOTS =  "Select * From parking_slot";
}
