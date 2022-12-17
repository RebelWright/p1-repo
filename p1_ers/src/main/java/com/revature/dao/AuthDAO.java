package com.revature.dao;

import com.revature.models.ERS_Users;
import com.revature.models.ERS_User_Roles;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {
    //for this  method we don't have username/password, we'll use first_name, last_name
    //change it accordingly for our own project. username/password for projects
    public ERS_Users login (String ers_username, String ers_password) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from ers_users where ers_username = ? and ers_password = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ers_username);
            ps.setString(2, ers_password);
            ResultSet rs = ps.executeQuery();
            //since we're only expecting one record. we can use an if instead of while statement
            if(rs.next()){
                ERS_Users u = new ERS_Users(
                        rs.getInt("user_id"),
                        rs.getString("ers_username"),
                        rs.getString("ers_password"),
                        rs.getString("ers_first_name"),
                        rs.getString("ers_last_name"),
                        null

                );
                int roleFk = rs.getInt("user_role_id_fk");
                RoleDAO rDAO = new RoleDAO();
                ERS_User_Roles r = rDAO.getRoleById(roleFk);
                u.setRole(r);
                return u;

            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
