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
public class ParkingReservationQueries {
    public static String INSERT_PARKINGRESERVATION = "Insert Into  parking_reservation (reservation_no, telephone_no, time_to_arrive, parking_slot_no, p_name) Values (?,?,?,?,?)";
    public static String GET_PARKINGRESERVATION  = "Select * From park Where P_Name = ?";
    public static String UPDATE_PARKINGRESERVATION  = "Update park Set P_Location = ?, Slot_Count = ?, type = ? Where P_Name = ?";
    public static String DELETE_PARKINGRESERVATION  = "Delete From park Where P_Name = ?";
    public static String GET_ALL_PARKINGRESERVATIONS  = "Select * From park";
    public static String GET_LAST_ID  = "SELECT reservation_no FROM `parking_reservation` ORDER BY reservation_no DESC LIMIT 1";
}
