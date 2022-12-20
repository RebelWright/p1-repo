package com.revature.dao;

import com.revature.models.ERS_User_Roles;
import com.revature.models.ERS_Users;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ERS_UsersDAO implements ERS_UsersDAO_Interface{
    @Override
    public ERS_Users insertEmployee(ERS_Users newUser) {
        try(Connection conn = ConnectionUtil.getConnection()){

            //we need to create our SQL string as usual
            String sql = "insert into ers_users (ers_username, ers_password, ers_first_name, ers_last_name, user_role_id_fk) values (?, ?, ?, ?, 1);";

            //Instantiate a PreparedStatement to hold our SQL and fill its variables
            PreparedStatement ps = conn.prepareStatement(sql);

            //fill in each wildcard using the Employee object in the arguments
            ps.setString(1, newUser.getErs_username());
            ps.setString(2, newUser.getErs_password());
            ps.setString(3, newUser.getErs_first_name());
            ps.setString(4, newUser.getErs_last_name());

            //now that our SQL String is populated, we can execute the update
            ps.executeUpdate();
            //not executeQuery()?? NO!!!! that's for SELECTS. we use executeUpdate for inserts, updates, deletes

            //no ResultSet because we aren't getting any data returned.

            //BUT we do want to tell the user that the data was inserted
            return newUser;
            //this is same employee inputted by the user. send it back to them to see if all goes well

        } catch(SQLException e){
            e.printStackTrace(); //tell us what went wrong
        }
        return null;
    }
    public ERS_User_Roles getRoleById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            //we need a string that lays out the sql query we intend to run on the db
            //this string has a wildcard/variable/parameter
            // we have to take the user-inputted role id and put it in the statement
            String sql = "select * from ers_users where role_id = ?;";
            //we need an object called prepared statement to fill the variable in
            //they prepare a query to get sent to the database
            PreparedStatement ps = conn.prepareStatement(sql);
            //the first wildcard will be equal to the id variable
            ps.setInt(1, id);
            //we're running the sql statement stored in the prepared statement
            //results of the sql statement will be stored in the ResultSet object
            ResultSet rs = ps.executeQuery();
            //while loop used to extract data from resultset object

            while(rs.next()){
                //we need to use the data from the result set to fill in a role all args constructor
                //we need to make a role object from the data
                //this is just a constructor that we opened up for cleaner code
                ERS_User_Roles role = new ERS_User_Roles(
                        rs.getInt("user_role_id"),
                        rs.getString("user_role")
                );
                return role;
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
