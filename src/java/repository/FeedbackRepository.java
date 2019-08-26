/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import connection.DBConnection;
import entity.Feedback;
import entity.TestUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.FeedbackQueries;

/**
 *
 * @author Ishan
 */
public class FeedbackRepository {
    public Connection getConnection() {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();

        return con;
    }
    
    public boolean insertFeedback(Feedback feedback) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(FeedbackQueries.INSERT_FEEDBACK);
            pst.setString(1, feedback.getTelephone_no());
            pst.setString(2, feedback.getFb_type());
            pst.setString(3, feedback.getFb_desc());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }

    public Feedback getFeedback(int id) {
        Connection con = getConnection();
        ResultSet result = null;
        Feedback feedback = new Feedback();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(FeedbackQueries.GET_FEEDBACK);
            pst.setInt(1, id);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                feedback.setFeedback_Id(result.getInt(1));
                feedback.setTelephone_no(result.getString(2));
                feedback.setFb_type(result.getString(3));
                feedback.setFb_desc(result.getString(4));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return feedback;
    }

    public boolean updateFeedback(Feedback feedback) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(FeedbackQueries.UPDATE_FEEDBACK);
            pst.setString(1, feedback.getTelephone_no());
            pst.setString(2, feedback.getFb_type());
            pst.setString(3, feedback.getFb_desc());
            pst.setInt(4, feedback.getFeedback_Id());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }

    public boolean deleteFeedback(int id) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(FeedbackQueries.DELETE_FEEDBACK);
            pst.setInt(1, id);
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }
    
    
    public List<Feedback> getAllFeedbacks() {
        Connection con = getConnection();
        ResultSet result = null;
        List<Feedback> feedbackList = new ArrayList<>();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(FeedbackQueries.GET_ALL_FEEDBACKS);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                Feedback feedback = new Feedback();
            
                feedback.setFeedback_Id(result.getInt(1));
                feedback.setTelephone_no(result.getString(2));
                feedback.setFb_type(result.getString(3));
                feedback.setFb_desc(result.getString(4));
                
                feedbackList.add(feedback);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FeedbackRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return feedbackList;
    }
    
    
}
