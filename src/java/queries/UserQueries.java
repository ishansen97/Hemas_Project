/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

/**
 *
 * @author Sandeepa Fernando
 */
public class UserQueries {
    public static final String INSERT_USER = "Insert Into registered (telephone_no, Name, Staff_ID, NIC, Vehicle_No, Email) Values (?,?,?,?,?,?)";
    public static final String CUSTOMER = "Insert Into customer (telephone_no) Values (?)";
    public static final String GET_ALL_USER = "Select * From registered";
    public static final String GET_USER_BY_ID = "Select * From registered Where telephone_no = ?";
    public static final String UPDATE_USER = "Update registered Set Name = ?, Staff_ID = ?, NIC = ?, Vehicle_No = ?, Email = ? Where telephone_no = ?";
    public static final String DELETE_USER = "Delete From registered Where telephone_no = ?";
    public static final String DELETE_CUSTOMER = "Delete From customer Where telephone_no = ?";
}
