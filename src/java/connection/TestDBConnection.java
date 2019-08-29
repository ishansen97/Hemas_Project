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
        String test = "R00000123";
        String idParts1[] = test.split("R");
        int index = idParts1[1].lastIndexOf("0");
        String value = idParts1[1].substring(index + 1);
        
        int number = Integer.parseInt(value);
        
        System.out.println(idParts1[1]);
        System.out.println(number);
    }
}
