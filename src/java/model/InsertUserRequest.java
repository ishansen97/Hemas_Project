/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sandeepa Fernando
 */
public class InsertUserRequest {

    private String fname;
    private String nic;
    private int staffid;
    private String email;
    private String vehicalno;
    private int telephone;

    public String getFname() {
        return fname;
    }

    public String getVehicalno() {
        return vehicalno;
    }

    public void setVehicalno(String vehicalno) {
        this.vehicalno = vehicalno;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
        
    }


}
