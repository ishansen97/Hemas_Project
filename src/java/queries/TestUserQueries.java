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
public class TestUserQueries {
    public static final String INSERT_USER = "Insert Into TestUser (fname, lname, age) Values (?,?,?)";
    public static final String GET_USER = "Select * From TestUser Where Id = ?";
    public static final String UPDATE_USER = "Update TestUser Set fname = ?, lname = ?, age = ? Where Id = ?";
    public static final String DELETE_USER = "Delete From TestUser Where Id = ?";
}
