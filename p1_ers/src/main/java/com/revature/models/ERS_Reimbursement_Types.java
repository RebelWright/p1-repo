package com.revature.models;

public class ERS_Reimbursement_Types {
    private int reimbursement_type_id;
    private String reimbursement_type;

    public ERS_Reimbursement_Types() {
    }

    public ERS_Reimbursement_Types(int reimbursement_type_id, String reimbursement_type) {
        this.reimbursement_type_id = reimbursement_type_id;
        this.reimbursement_type = reimbursement_type;
    }

    public ERS_Reimbursement_Types(String reimbursement_type) {
        this.reimbursement_type = reimbursement_type;
    }

    public int getReimbursement_type_id() {
        return reimbursement_type_id;
    }

    public void setReimbursement_type_id(int reimbursement_type_id) {
        this.reimbursement_type_id = reimbursement_type_id;
    }

    public String getReimbursement_type() {
        return reimbursement_type;
    }

    public void setReimbursement_type(String reimbursement_type) {
        this.reimbursement_type = reimbursement_type;
    }

    @Override
    public String toString() {
        return "ERS_Reimbursement_Types{" +
                "reimbursement_type_id=" + reimbursement_type_id +
                ", reimbursement_type='" + reimbursement_type + '\'' +
                '}';
    }
}
