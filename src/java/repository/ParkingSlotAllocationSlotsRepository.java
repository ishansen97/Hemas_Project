/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import connection.DBConnection;
import entity.ParkingSlotAllocation;
import entity.ParkingSlotAllocationSlots;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.ParkingSlotAllocationSlotsQueries;

/**
 *
 * @author Ishan
 */
public class ParkingSlotAllocationSlotsRepository {
    
    public Connection getConnection() {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();

        return con;
    }

    public boolean insertParkingSlotAllocationSlots(ParkingSlotAllocationSlots parkingSlotAllocationSlots) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationSlotsQueries.INSERT_PARKINGSLOTALLOCATIONSLOTS);
            pst.setInt(1, parkingSlotAllocationSlots.getAllocation_Id());
            pst.setInt(2, parkingSlotAllocationSlots.getSlot_no());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
        return (result > 0);
    }

    public ParkingSlotAllocationSlots getParkingSlotAllocationSlots(int id, int slot_no) {
        Connection con = getConnection();
        ResultSet result = null;
        ParkingSlotAllocationSlots parkingSlotAllocationSlots = new ParkingSlotAllocationSlots();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationSlotsQueries.GET_PARKINGSLOTALLOCATIONSLOTS);
            pst.setInt(1, id);
            pst.setInt(2, slot_no);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                parkingSlotAllocationSlots.setAllocation_Id(result.getInt(1));
                parkingSlotAllocationSlots.setSlot_no(result.getInt(2));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return parkingSlotAllocationSlots;
    }

    public boolean updateParkingSlotAllocationSlots(ParkingSlotAllocationSlots parkingSlotAllocationSlots) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationSlotsQueries.UPDATE_PARKINGSLOTALLOCATIONSLOTS);
            pst.setInt(1, parkingSlotAllocationSlots.getSlot_no());
            pst.setInt(2, parkingSlotAllocationSlots.getAllocation_Id());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return (result > 0);
    }

    public boolean deleteParkingSlotAllocationSlots(int id) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationSlotsQueries.DELETE_PARKINGSLOTALLOCATIONSLOTS);
            pst.setInt(1, id);
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return (result > 0);
    }

    public List<ParkingSlotAllocationSlots> getAllParkingSlotAllocations() {
        Connection con = getConnection();
        ResultSet result = null;
        List<ParkingSlotAllocationSlots> parkingSlotAllocationSlotsList = new ArrayList<>();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationSlotsQueries.GET_ALL_PARKINGSLOTALLOCATIONSLOTS);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                ParkingSlotAllocationSlots parkingSlotAllocationSlots = new ParkingSlotAllocationSlots();
            
                parkingSlotAllocationSlots.setAllocation_Id(result.getInt(1));
                parkingSlotAllocationSlots.setSlot_no(result.getInt(2));
                
                parkingSlotAllocationSlotsList.add(parkingSlotAllocationSlots);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return parkingSlotAllocationSlotsList;
    }
    
}
