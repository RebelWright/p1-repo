package com.revature.dao;

import com.revature.models.ERS_Reimbursements;
import com.revature.models.ERS_User_Roles;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ERS_ReimbursementsDAO implements ERS_ReimbursementsDAO_Interface{
    @Override
    public ArrayList<ERS_Reimbursements> getReimbursements() {
        try(Connection conn = ConnectionUtil.getConnection()){
            // a string that rep our sql statement
            String sql = "select * from ers_reimbursements;";
            //no variables needed in the query above
            //so instead of a prepared statement we'll use a regular statement
            //if we don't have wildcard or variables, we only need Statement not Prepared Statement
            Statement s = conn.createStatement();
            //now execute the query and save the results in a ResultSet
            ResultSet rs = s.executeQuery(sql);
            //this time before while loop, instantiate an empty arraylist to store our Employee objects
            ArrayList<ERS_Reimbursements> reimbList= new ArrayList();
            //rs.next iterates through the incoming data. returns false when there is no more new data
            while(rs.next()){
                //for every employee returned from the database we'll make a new employee object
                ERS_Reimbursements reimb = new ERS_Reimbursements(
                        rs.getInt("reimb_id"),
                        rs.getInt("reimb_amount"),
                        rs.getString("reimb_description"),
                        rs.getInt("creator_id_fk"),
                        rs.getInt("resolver_id_fk"),
                        rs.getInt("reimb_type_fk"),
                        rs.getInt("reimb_status_fk")
                );
                //use our getRoleById method that we created
                int roleFK = rs.getInt("role_id_fk");
                //instantiate RoleDAO object then use it and getRoleById to get our role_id foreign key
                ERS_User_RolesDAO rDAO = new ERS_User_RolesDAO();
                ERS_User_Roles r = rDAO.getRoleById(roleFK);
                //use the setter of our employee object and assign it the role we made above
                reimb.s(r);
                //now thanks to our setter we have a fully initialized employee object
                //now we can add it to the arraylist
                reimbList.add(reimb);
            }
            return reimbList;
        }
        catch(SQLException e){
            e.printStackTrace(); //very helpful. tells us what and where went wrong
        }
        return null;
    }

    @Override
    public ERS_Reimbursements insertReimbursement(ERS_Reimbursements reimburs) {
        try(Connection conn = ConnectionUtil.getConnection()){
            //create a sql string. Insert statement
            String sql = "insert into ers_reimbursements (reimb_amount,reimb_description, creator_id_fk) values (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            //fill in each wildcard using the reimbursements object
            ps.setInt(1, reimburs.getReimb_amount());
            ps.setString(2, reimburs.getReimb_description());
            ps.setInt(3, reimburs.getCreator_id_fk());
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
