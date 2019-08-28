/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import connection.DBConnection;
import entity.Feedback;
import entity.Park;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.ParkQueries;

/**
 *
 * @author Ishan
 */
public class ParkingRepository {
    public Connection getConnection() {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();

        return con;
    }

    public boolean insertParking(Park parking) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkQueries.INSERT_PARK);
            pst.setString(1, parking.getP_name());
            pst.setString(2, parking.getP_location());
            pst.setInt(3, parking.getSlot_count());
            pst.setString(3, parking.getType());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
//                }
        }
        return (result > 0);
    }

    public Park getParking(String p_name) {
        Connection con = getConnection();
        ResultSet result = null;
        Park park = new Park();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkQueries.GET_PARK);
            pst.setString(1, p_name);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                park.setP_name(result.getString(1));
                park.setP_location(result.getString(2));
                park.setSlot_count(result.getInt(3));
                park.setType(result.getString(4));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
//                }
        }
        return park;

    }

    public boolean updateParking(Park parking) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkQueries.UPDATE_PARK);
            pst.setString(1, parking.getP_location());
            pst.setInt(2, parking.getSlot_count());
            pst.setString(3, parking.getType());
            pst.setString(4, parking.getP_name());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
//                }
        }
        return (result > 0);
    }

    public boolean deleteParking(String p_name) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkQueries.DELETE_PARK);
            pst.setString(1, p_name);
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
//                }
        }
        return (result > 0);
    }

    public List<Park> getAllParkings() {
        Connection con = getConnection();
        ResultSet result = null;
        List<Park> parkList = new ArrayList<>();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkQueries.GET_ALL_PARKS);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                Park park = new Park();
            
                park.setP_name(result.getString(1));
                park.setP_location(result.getString(2));
                park.setSlot_count(result.getInt(3));
                park.setType(result.getString(4));
                
                parkList.add(park);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ParkingRepository.class.getName()).log(Level.SEVERE, null, ex);
//                }
        }
        return parkList;
    }
    
}
