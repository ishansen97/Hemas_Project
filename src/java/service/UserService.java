/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import repository.UserRepository;
import entity.RegisteredUser;
import java.util.ArrayList;
import java.util.List;
import model.DeleteUserRequest;
import model.GetUserRequest;
import model.GetUserResponse;
import model.InsertUserRequest;
import model.UpdateUserRequest;

/**
 *
 * @author Sandeepa Fernando
 */
public class UserService {

    public static UserRepository userRepo = new UserRepository();

    public static boolean insertUser(InsertUserRequest request) {
        RegisteredUser user = new RegisteredUser();

        user.setFname(request.getFname());
        user.setNic(request.getNic());
        user.setStaffid(request.getStaffid());
        user.setEmail(request.getEmail());
        user.setVehicalno(request.getVehicalno());
        user.setTelephone(request.getTelephone());

        return userRepo.insertUser(user);
    }

    public static List<GetUserResponse> getUserResponses() {
        List<RegisteredUser> userList = userRepo.getAllUsers();
        List<GetUserResponse> responseList = new ArrayList<>();

        for (RegisteredUser users : userList) {
            GetUserResponse response = new GetUserResponse();

            response.setFname(users.getFname());
            response.setNic(users.getNic());
            response.setStaffid(users.getStaffid());
            response.setEmail(users.getEmail());
            response.setVehicalno(users.getVehicalno());
            response.setTelephone(users.getTelephone());

            responseList.add(response);
        }

        return responseList;
    }

    public static GetUserResponse getUser(GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        int id = request.getTelephone();

        RegisteredUser user = userRepo.getUser(id);

        response.setTelephone(user.getTelephone());
        response.setFname(user.getFname());
        response.setStaffid(user.getStaffid());
        response.setNic(user.getNic());
        response.setVehicalno(user.getVehicalno());
        response.setEmail(user.getEmail());

        return response;
    }

    public static boolean updateUser(UpdateUserRequest request) {
        RegisteredUser user = new RegisteredUser();

        user.setTelephone(request.getTelephone());
        user.setFname(request.getFname());
        user.setStaffid(request.getStaffid());
        user.setNic(request.getNic());
        user.setVehicalno(request.getVehicalno());
        user.setEmail(request.getEmail());

        return userRepo.updateUser(user);
    }

    public static boolean deleteUser(DeleteUserRequest request) {
        int id = request.getTelephone();

        return userRepo.deleteUser(id);
    }
}
