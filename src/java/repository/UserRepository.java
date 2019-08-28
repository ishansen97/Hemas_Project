/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import connection.DBConnection;
import entity.TestUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.TestUserQueries;

/**
 *
 * @author Ishan
 */
public class UserRepository {
    
    public Connection getConnection() {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();

        return con;
    }
    
    public boolean insertUser(TestUser user) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(TestUserQueries.INSERT_USER);
            pst.setString(1, user.getFname());
            pst.setString(2, user.getLname());
            pst.setInt(3, user.getAge());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }

    public TestUser getUser(int id) {
        Connection con = getConnection();
        ResultSet result = null;
        TestUser user = new TestUser();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(TestUserQueries.GET_USER);
            pst.setInt(1, id);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                user.setId(result.getInt(1));
                user.setFname(result.getString(2));
                user.setLname(result.getString(3));
                user.setAge(result.getInt(4));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return user;
    }

    public boolean updateUser(TestUser user) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(TestUserQueries.UPDATE_USER);
            pst.setString(1, user.getFname());
            pst.setString(2, user.getLname());
            pst.setInt(3, user.getAge());
            pst.setInt(4, user.getId());
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }

    public boolean deleteUser(int id) {
        Connection con = getConnection();
        int result = 0;
        
        try {
           
            PreparedStatement pst = con.prepareStatement(TestUserQueries.DELETE_USER);
            pst.setInt(1, id);
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return (result > 0);
    }

    
}
