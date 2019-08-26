/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Feedback;
import entity.TestUser;
import java.util.ArrayList;
import java.util.List;
import model.DeleteFeedbackRequest;
import model.DeleteUserRequest;
import model.GetFeedbackRequest;
import model.GetFeedbackResponse;
import model.GetUserRequest;
import model.GetUserResponse;
import model.InsertFeedbackRequest;
import model.InsertUserRequest;
import model.UpdateFeedbackRequest;
import model.UpdateUserRequest;
import repository.FeedbackRepository;
import repository.UserRepository;

/**
 *
 * @author Ishan
 */
public class FeedbackService {
    
     public static FeedbackRepository feedbackRepo = new FeedbackRepository();
    
    public static boolean insertFeedback(InsertFeedbackRequest request) {
        Feedback feedback = new Feedback();
        
        feedback.setTelephone_no(request.getTelephone_no());
        feedback.setFb_type(request.getFb_type());
        feedback.setFb_desc(request.getFb_desc());
        
        return feedbackRepo.insertFeedback(feedback);
    }
    
    public static GetFeedbackResponse getUser(GetFeedbackRequest request) {
        GetFeedbackResponse response = new GetFeedbackResponse();
        int id = request.getFeedback_Id();
        
        Feedback feedback = feedbackRepo.getFeedback(id);
        
        response.setFeedback_Id(feedback.getFeedback_Id());
        response.setTelephone_no(feedback.getTelephone_no());
        response.setFb_type(feedback.getFb_type());
        response.setFb_desc(feedback.getFb_desc());
        
        return response;
    }
    
    public static boolean updateUser(UpdateFeedbackRequest request) {
        Feedback feedback = new Feedback();
        
        feedback.setFeedback_Id(request.getFeedback_Id());
        feedback.setTelephone_no(request.getTelephone_no());
        feedback.setFb_type(request.getFb_type());
        feedback.setFb_desc(request.getFb_desc());
        
        return feedbackRepo.updateFeedback(feedback);
    }
    
    public static boolean deleteUser(DeleteFeedbackRequest request) {
        int id = request.getFeedback_Id();
        
        return feedbackRepo.deleteFeedback(id);
    }
    
    
    public static List<GetFeedbackResponse> getAllFeedbacks() {
        List<Feedback> feedbackList = feedbackRepo.getAllFeedbacks();
        List<GetFeedbackResponse> responseList = new ArrayList<>();
        
        for (Feedback feedback: feedbackList) {
            GetFeedbackResponse response = new GetFeedbackResponse();
            
            response.setFeedback_Id(feedback.getFeedback_Id());
            response.setTelephone_no(feedback.getTelephone_no());
            response.setFb_type(feedback.getFb_type());
            response.setFb_desc(feedback.getFb_desc());
            
            responseList.add(response);
        }
        
        return responseList;
    }
}
