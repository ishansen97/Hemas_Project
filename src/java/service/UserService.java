/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.TestUser;
import model.InsertUserRequest;
import model.DeleteUserRequest;
import model.GetUserRequest;
import model.GetUserResponse;
import model.UpdateUserRequest;
import repository.UserRepository;

/**
 *
 * @author Ishan
 */
public class UserService {
    
    public static UserRepository userRepo = new UserRepository();
    
    public static boolean insertUser(InsertUserRequest request) {
        TestUser user = new TestUser();
        
        user.setFname(request.getFname());
        user.setLname(request.getLname());
        user.setAge(request.getAge());
        
        return userRepo.insertUser(user);
    }
    
    public static GetUserResponse getUser(GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        int id = request.getId();
        
        TestUser user = userRepo.getUser(id);
        
        response.setId(user.getId());
        response.setFname(user.getFname());
        response.setLname(user.getLname());
        response.setAge(user.getAge());
        
        return response;
    }
    
    public static boolean updateUser(UpdateUserRequest request) {
        TestUser user = new TestUser();
        
        user.setId(request.getId());
        user.setFname(request.getFname());
        user.setLname(request.getLname());
        user.setAge(request.getAge());
        
        return userRepo.updateUser(user);
    }
    
    public static boolean deleteUser(DeleteUserRequest request) {
        int id = request.getId();
        
        return userRepo.deleteUser(id);
    }
}
