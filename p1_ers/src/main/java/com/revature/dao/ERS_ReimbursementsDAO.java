package com.revature.dao;

import com.revature.models.ERS_Reimbursements;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ERS_ReimbursementsDAO implements ERS_ReimbursementsDAO_Interface{
    @Override
    public ArrayList<ERS_Reimbursements> getReimbursements() {
        return null;
    }

    @Override
    public ERS_Reimbursements insertReimbursement(ERS_Reimbursements reimburs) {
        try(Connection conn = ConnectionUtil.getConnection()){
            //create a sql string. Insert statement
            String sql = "insert into ers_reimbursements (reimbursement_amount,reimbursement_description, user_id_fk) values (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            //fill in each wildcard using the reimbursements object
            ps.setInt(1, reimburs.getReimbursement_amount());
            ps.setString(2, reimburs.getReimbursement_description());
            ps.setInt(3, reimburs.getUser_id_fk());
            //we need to move through a role to get to its variables
            //we get a role, and then we get the role's id
            ps.executeUpdate();
            // no result set because we are not returning any data
            return reimburs;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
