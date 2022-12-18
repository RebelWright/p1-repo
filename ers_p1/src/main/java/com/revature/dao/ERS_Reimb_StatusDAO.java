package com.revature.dao;

import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ERS_Reimb_StatusDAO implements ERS_Reimb_StatusDAO_Interface{

    @Override
    public boolean approveReimb_Status(int reimb_status, int reimb_id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            //create our SQL String (to be filled with values from the method arguments)
            String sql = "update ers_reimbursements set reimb_status_fk = 2 where role_title = ?;";

            //Prepared statement so that we can fill appropriate values
            PreparedStatement ps = conn.prepareStatement(sql);

            //using ps.setXZY we can fill the wildcards (?) in our SQL statement
            ps.setInt(1, reimb_id);

            //execute the update!
            ps.executeUpdate();

            //if we get this far in the try block, we can assume nothing went wrong. return true.
            return true;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean denyReimb_Status(int reimb_status, int reimb_id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            //create our SQL String (to be filled with values from the method arguments)
            String sql = "update ers_reimbursements set reimb_status_fk = 3 where reimb_id = ?;";

            //Prepared statement so that we can fill appropriate values
            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setInt(1, reimb_id);

            //execute the update!
            ps.executeUpdate();

            //if we get this far in the try block, we can assume nothing went wrong. return true.
            return true;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
