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
public class ParkQueries {

    public static String INSERT_PARK = "Insert Into park Values (?,?,?,?)";
    public static String GET_PARK = "Select * From park Where P_Name = ?";
    public static String UPDATE_PARK = "Update park Set P_Location = ?, Slot_Count = ?, type = ? Where P_Name = ?";
    public static String DELETE_PARK = "Delete From park Where P_Name = ?";
    public static String GET_ALL_PARKS = "Select * From park";
    
}
