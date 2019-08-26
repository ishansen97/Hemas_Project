/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

/**
 *
 * @author Ishan
 */
public class FeedbackQueries {
    public static final String INSERT_FEEDBACK = "Insert Into feedback (telephone_no, fb_type, fb_desc) Values (?,?,?)";
    public static final String GET_FEEDBACK = "Select * From feedback Where feedback_Id = ?";
    public static final String UPDATE_FEEDBACK = "Update feedback Set telephone_no = ?, fb_type = ?, fb_desc = ? Where feedback_Id = ?";
    public static final String DELETE_FEEDBACK = "Delete From feedback Where feedback_Id = ?";
    public static final String GET_ALL_FEEDBACKS= "Select * From feedback";
}
