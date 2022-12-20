package com.revature.dao;

import com.revature.models.ERS_Reimbursements;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ERS_ReimbursementsDAO implements ERS_ReimbursementsDAO_Interface{
    @Override
    public ArrayList<ERS_Reimbursements> getAllReimbursements() {
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
    public ERS_Reimbursements insertReimbursement(ERS_Reimbursements reimb) {
        try(Connection conn = ConnectionUtil.getConnection()){
            //create a sql string. Insert statement
            String sql = "insert into ers_reimbursements (reimb_amount, reimb_description, creator_id_fk, resolver_id_fk, reimb_type_fk, reimb_status_fk) " +
                    "values (?,?,?,null,?,1);";
            PreparedStatement ps = conn.prepareStatement(sql);
            //fill in each wildcard using the reimbursements object
            ps.setInt(1, reimb.getReimb_amount());
            ps.setString(2, reimb.getReimb_description());
            ps.setInt(3, reimb.getCreator_id_fk());
            //ps.setInt(4,reimb.getResolver_id_fk(0));
            ps.setInt(4, reimb.getReimb_type_fk());
            //ps.setInt(6, reimb.getReimb_status_fk(1));
            ArrayList<ERS_Reimbursements> pendingList = new ArrayList();
            pendingList.add(reimb);

            //we need to move through a role to get to its variables
            //we get a role, and then we get the role's id
            ps.executeUpdate();
            // no result set because we are not returning any data
            return reimb;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ERS_Reimbursements> viewPendingReimbursements() {
        try(Connection conn = ConnectionUtil.getConnection()){
            // a string that rep our sql statement
            String sql = "select * from ers_reimbursements where reimb_status_fk = 1;";
            //no variables needed in the query above
            //so instead of a prepared statement we'll use a regular statement
            //if we don't have wildcard or variables, we only need Statement not Prepared Statement
            Statement s = conn.createStatement();
            //now execute the query and save the results in a ResultSet
            ResultSet rs = s.executeQuery(sql);
            //this time before while loop, instantiate an empty arraylist to store our Employee objects
            ArrayList<ERS_Reimbursements> pendingList= new ArrayList();
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

                pendingList.add(reimb);
            }
            return pendingList;
        }
        catch(SQLException e){
            e.printStackTrace(); //very helpful. tells us what and where went wrong
        }
        return null;
    }

    @Override
    public ArrayList<ERS_Reimbursements> viewApprovedReimbursements() {
        try(Connection conn = ConnectionUtil.getConnection()){
            // a string that rep our sql statement
            String sql = "select * from ers_reimbursements where reimb_status_fk = 2;";
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
    public ArrayList<ERS_Reimbursements> viewDeniedReimbursements() {
        try(Connection conn = ConnectionUtil.getConnection()){
            // a string that rep our sql statement
            String sql = "select * from ers_reimbursements where reimb_status_fk = 3;";
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
    public ArrayList<ERS_Reimbursements> viewUserReimbursements(int user_id) {

        try(Connection conn = ConnectionUtil.getConnection()){
            // a string that rep our sql statement
            String sql = "select * from ers_reimbursements where creator_id_fk = ?";
            //no variables needed in the query above
            //so instead of a prepared statement we'll use a regular statement
            //if we don't have wildcard or variables, we only need Statement not Prepared Statement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            //now execute the query and save the results in a ResultSet
            ResultSet rs = ps.executeQuery(sql);
            //this time before while loop, instantiate an empty arraylist to store our Employee objects
            ArrayList<ERS_Reimbursements> reimbList= new ArrayList();
            //rs.next iterates through the incoming data. returns false when there is no more new data
            while(rs.next()){
                //for every user reimb returned from the database we'll make a new employee object
                ERS_Reimbursements reimb = new ERS_Reimbursements(
                        rs.getInt("reimb_id"),
                        rs.getInt("reimb_amount"),
                        rs.getString("reimb_description"),
                        rs.getInt("creator_id_fk"),
                        rs.getInt("resolver_id_fk"),
                        rs.getInt("reimb_type_fk"),
                        rs.getInt("reimb_status_fk")
                );

                reimbList.add(reimb);
            }
            return reimbList;
        }
        catch(SQLException e){
            e.printStackTrace(); //very helpful. tells us what and where went wrong
        }
        return null;
    }
}
