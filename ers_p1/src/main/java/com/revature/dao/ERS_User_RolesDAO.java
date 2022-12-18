package com.revature.dao;

import com.revature.models.ERS_User_Roles;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ERS_User_RolesDAO implements ERS_User_RolesDAO_Interface{
    @Override
    public ERS_User_Roles getRoleById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            //we need a string that lays out the sql query we intend to run on the db
            //this string has a wildcard/variable/parameter
            // we have to take the user-inputted role id and put it in the statement
            String sql = "select * from ers_user_roles where role_id = ?;";
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
