/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Sandeepa Fernando
 */
public class RegisteredUser {
    private String fname;
    private String nic;
    private int staffid;
    private String email;
    private String vehicalno;
    private int telephone;

    public RegisteredUser(String fname, int staffid, String email, String vehicalno, int telephone) {
        this.fname = fname;
        this.staffid = staffid;
        this.email = email;
        this.vehicalno = vehicalno;
        this.telephone = telephone;
    }
    
    public RegisteredUser(){
    }

    public String getFname() {
        return fname;
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

    public String getVehicalno() {
        return vehicalno;
    }

    public void setVehicalno(String vehicalno) {
        this.vehicalno = vehicalno;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    

}
