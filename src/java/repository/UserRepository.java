/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.RegisteredUser;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.UserQueries;

/**
 *
 * @author Sandeepa Fernando
 */
public class UserRepository {

    public Connection getConnection() {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();

        return con;
    }

    public boolean insertUser(RegisteredUser user) {
        Connection con = getConnection();
        int result = 0;
        int resultCus = 0;

        try {
            PreparedStatement pst1 = con.prepareStatement(UserQueries.CUSTOMER);
            pst1.setInt(1, user.getTelephone());
            resultCus = pst1.executeUpdate();

            if (resultCus > 0) {

                PreparedStatement pst = con.prepareStatement(UserQueries.INSERT_USER);
                pst.setString(2, user.getFname());
                pst.setString(4, user.getNic());
                pst.setInt(3, user.getStaffid());
                pst.setString(6, user.getEmail());
                pst.setString(5, user.getVehicalno());
                pst.setInt(1, user.getTelephone());

                result = pst.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return (result > 0);
    }

    public List<RegisteredUser> getAllUsers() {
        Connection con = getConnection();
        ResultSet result = null;
        List<RegisteredUser> userList = new ArrayList<>();

        try {

            PreparedStatement pst = con.prepareStatement(UserQueries.GET_ALL_USER);

            result = pst.executeQuery();

            while (result.next()) {
                RegisteredUser registeredUser = new RegisteredUser();

                registeredUser.setTelephone(result.getInt(1));
                registeredUser.setFname(result.getString(2));
                registeredUser.setStaffid(result.getInt(3));
                registeredUser.setNic(result.getString(4));
                registeredUser.setVehicalno(result.getString(5));
                registeredUser.setEmail(result.getString(6));

                userList.add(registeredUser);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return userList;
    }

    public RegisteredUser getUser(int id) {
        Connection con = getConnection();
        ResultSet result = null;
        RegisteredUser user = new RegisteredUser();

        try {

            PreparedStatement pst = con.prepareStatement(UserQueries.GET_USER_BY_ID);
            pst.setInt(1, id);

            result = pst.executeQuery();

            while (result.next()) {
                user.setTelephone(result.getInt(1));
                user.setFname(result.getString(2));
                user.setStaffid(result.getInt(3));
                user.setNic(result.getString(4));
                user.setVehicalno(result.getString(5));
                user.setEmail(result.getString(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return user;
    }

    public boolean updateUser(RegisteredUser user) {
        Connection con = getConnection();
        int result = 0;

        try {

            PreparedStatement pst = con.prepareStatement(UserQueries.UPDATE_USER);
            pst.setString(1, user.getFname());
            pst.setInt(2, user.getStaffid());
            pst.setString(3, user.getNic());
            pst.setString(4, user.getVehicalno());
            pst.setString(5, user.getEmail());
            pst.setInt(6, user.getTelephone());

            result = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return (result > 0);
    }

    public boolean deleteUser(int id) {
        Connection con = getConnection();
        int result = 0;
        int resultCus = 0;

        try {
            PreparedStatement pst1 = con.prepareStatement(UserQueries.DELETE_CUSTOMER);
            pst1.setInt(1, id);

            resultCus = pst1.executeUpdate();

            if (resultCus > 0) {

                PreparedStatement pst = con.prepareStatement(UserQueries.DELETE_USER);
                pst.setInt(1, id);

                result = pst.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return (result > 0);
    }

}
