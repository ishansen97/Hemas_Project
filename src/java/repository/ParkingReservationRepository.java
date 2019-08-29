/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import connection.DBConnection;
import entity.ParkingReservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.ParkingReservationQueries;

/**
 *
 * @author Ishan
 */
public class ParkingReservationRepository {
    
    public Connection getConnection() {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();

        return con;
    }

    public boolean insertParkingReservation(ParkingReservation parkingReservation) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(ParkingReservationQueries.INSERT_PARKINGRESERVATION);
            pst.setString(1, parkingReservation.getReservation_no());
            pst.setString(2, parkingReservation.getTelephone_no());
            pst.setTimestamp(3, parkingReservation.getTime_to_arrive());
            pst.setInt(4, parkingReservation.getParking_slot_no());
            pst.setString(5, parkingReservation.getP_name());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotAllocationRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
        return (result > 0);
    }

    public String generateNewReservationNo() {
        Connection con = getConnection();
        ResultSet result = null;
        String last_id = null;
        String new_Id = null;
        
        try {
           
            Statement st = con.createStatement();
            
            result = st.executeQuery(ParkingReservationQueries.GET_LAST_ID);
            
            while (result.next()) {
                last_id = result.getString(1);
                
            }
            
            if (last_id != null) {
                String[] idParts = last_id.split("R");

                String subStr = last_id.substring(last_id.indexOf("R") + 1);

                if (subStr.startsWith("0")) {
                    int index = subStr.lastIndexOf("0");
                    String numSubStr = subStr.substring(index + 1);
                   

                    int number = Integer.parseInt(numSubStr);
                    number++;
                    subStr = subStr.replaceAll(numSubStr, number + "");

                    new_Id = "R" + subStr;
                }

                else {
                    int number = Integer.parseInt(subStr);
                    number++;

                    new_Id = "R" + subStr;
                }
               
            }
            else {
                new_Id = "R00000001";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ParkingSlotRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
               
        }
        return new_Id;
    }
    
}
