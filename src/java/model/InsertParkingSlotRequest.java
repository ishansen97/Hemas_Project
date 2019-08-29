/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ishan
 */
public class InsertParkingSlotRequest {
    private int parking_slot_no;
    private String p_name;
    private String location;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
