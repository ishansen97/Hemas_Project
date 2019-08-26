/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;

/**
 *
 * @author Ishan
 */
public class TestDBConnection {
    
    public static void main(String[] args) {
        DBConnection dbcon = DBConnection.getInstance();
        Connection con = dbcon.getCon();
        
        if (con != null) {
            System.out.println("connected");
        }
        else {
            System.out.println("not connected");
        }
    }
}
