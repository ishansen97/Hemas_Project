/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;

/**
 *
 * @author Ishan
 */
public class InsertParkingReservationRequest {
    private String telephone_no;
    private String date;
    private String time_to_arrive;
    private int slot_no;
    private int parking_slot_no;
    private String p_name;

    public String getTelephone_no() {
        return telephone_no;
    }

    public void setTelephone_no(String telephone_no) {
        this.telephone_no = telephone_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    

    public String getTime_to_arrive() {
        return time_to_arrive;
    }

    public void setTime_to_arrive(String time_to_arrive) {
        this.time_to_arrive = time_to_arrive;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public int getParking_slot_no() {
        return parking_slot_no;
    }

    public void setParking_slot_no(int parking_slot_no) {
        this.parking_slot_no = parking_slot_no;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
}
