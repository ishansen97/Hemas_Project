/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import connection.DBConnection;
import entity.ParkingSlotAllocation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.ParkingSlotAllocationQueries;

/**
 *
 * @author Ishan
 */
public class ParkingSlotAllocationRepository {
    public Connection getConnection() {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();

        return con;
    }

    public boolean insertParkingSlotAllocation(ParkingSlotAllocation parkingSlotAllocation) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationQueries.INSERT_PARKINGSLOTALLOCATION);
            pst.setString(1, parkingSlotAllocation.getP_Name());
            pst.setString(2, parkingSlotAllocation.getDay_type());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
        return (result > 0);
    }

    public ParkingSlotAllocation getParkingSlotAllocation(int id) {
        Connection con = getConnection();
        ResultSet result = null;
        ParkingSlotAllocation parkingSlotAllocation = new ParkingSlotAllocation();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationQueries.GET_PARKINGSLOTALLOCATION);
            pst.setInt(1, id);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                parkingSlotAllocation.setAllocationId(result.getInt(1));
                parkingSlotAllocation.setP_Name(result.getString(2));
                parkingSlotAllocation.setDay_type(result.getString(3));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return parkingSlotAllocation;
    }

    public boolean updateParkingSlotAllocation(ParkingSlotAllocation parkingSlotAllocation) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationQueries.UPDATE_PARKINGSLOTALLOCATION);
            pst.setString(1, parkingSlotAllocation.getP_Name());
            pst.setString(2, parkingSlotAllocation.getDay_type());
            pst.setInt(3, parkingSlotAllocation.getAllocationId());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return (result > 0);
    }

    public boolean deleteParkingSlotAllocation(int id) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationQueries.DELETE_PARKINGSLOTALLOCATION);
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

    public List<ParkingSlotAllocation> getAllParkingSlotAllocations() {
        Connection con = getConnection();
        ResultSet result = null;
        List<ParkingSlotAllocation> parkingSlotAllocationList = new ArrayList<>();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotAllocationQueries.GET_ALL_PARKINGSLOTALLOCATIONS);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                ParkingSlotAllocation parkingSlotAllocation = new ParkingSlotAllocation();
            
                parkingSlotAllocation.setAllocationId(result.getInt(1));
                parkingSlotAllocation.setP_Name(result.getString(2));
                parkingSlotAllocation.setDay_type(result.getString(3));
                
                parkingSlotAllocationList.add(parkingSlotAllocation);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return parkingSlotAllocationList;
    }
    
}
