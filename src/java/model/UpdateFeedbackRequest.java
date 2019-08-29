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
public class UpdateFeedbackRequest {
    private int feedback_Id;
    private String telephone_no;
    private String fb_type;
    private String fb_desc;

    public int getFeedback_Id() {
        return feedback_Id;
    }

    public void setFeedback_Id(int feedback_Id) {
        this.feedback_Id = feedback_Id;
    }

    public String getTelephone_no() {
        return telephone_no;
    }

    public void setTelephone_no(String telephone_no) {
        this.telephone_no = telephone_no;
    }

    public String getFb_type() {
        return fb_type;
    }

    public void setFb_type(String fb_type) {
        this.fb_type = fb_type;
    }

    public String getFb_desc() {
        return fb_desc;
    }

    public void setFb_desc(String fb_desc) {
        this.fb_desc = fb_desc;
    }
    
    
}
