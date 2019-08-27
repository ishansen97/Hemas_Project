/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import connection.DBConnection;
import entity.Feedback;
import entity.ParkingSlot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.FeedbackQueries;
import queries.ParkingSlotQueries;

/**
 *
 * @author Ishan
 */
public class ParkingSlotRepository {
    
    public Connection getConnection() {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();

        return con;
    }
    
    public boolean insertParkingSlot(ParkingSlot parkingSlot) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotQueries.INSERT_PARKINGSLOT);
            pst.setInt(1, parkingSlot.getParking_slot_no());
            pst.setString(2, parkingSlot.getP_name());
            pst.setString(3, parkingSlot.getLocation());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }

    public ParkingSlot getParkingSlot(int parking_slot_no, String p_name) {
        Connection con = getConnection();
        ResultSet result = null;
        ParkingSlot parkingSlot = new ParkingSlot();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotQueries.GET_PARKINGSLOT);
            pst.setInt(1, parking_slot_no);
            pst.setString(2, p_name);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                parkingSlot.setParking_slot_no(result.getInt(1));
                parkingSlot.setP_name(result.getString(2));
                parkingSlot.setLocation(result.getString(3));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return parkingSlot;
    }

    public boolean updateParkingSlot(ParkingSlot parkingSlot) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotQueries.UPDATE_PARKINGSLOT);
            pst.setString(1, parkingSlot.getLocation());
            pst.setInt(2, parkingSlot.getParking_slot_no());
            pst.setString(3, parkingSlot.getP_name());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }

    public boolean deleteParkingSlot(int parking_slot_no, String p_name) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotQueries.DELETE_PARKINGSLOT);
            pst.setInt(1, parking_slot_no);
            pst.setString(2, p_name);
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }
    
    
    public List<ParkingSlot> getAllParkingSlots() {
        Connection con = getConnection();
        ResultSet result = null;
        List<ParkingSlot> parkingSlotList = new ArrayList<>();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingSlotQueries.GET_ALL_PARKINGSLOTS);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                ParkingSlot parkingSlot = new ParkingSlot();
            
                parkingSlot.setParking_slot_no(result.getInt(1));
                parkingSlot.setP_name(result.getString(2));
                parkingSlot.setLocation(result.getString(3));
                
                parkingSlotList.add(parkingSlot);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return parkingSlotList;
    }
}
