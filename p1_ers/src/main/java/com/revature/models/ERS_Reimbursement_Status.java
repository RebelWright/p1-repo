package com.revature.models;

public class ERS_Reimbursement_Status {
    private int reimbursement_status_id;
    private String reimbursement_status;

    public ERS_Reimbursement_Status() {
    }

    public ERS_Reimbursement_Status(int reimbursement_status_id, String reimbursement_status) {
        this.reimbursement_status_id = reimbursement_status_id;
        this.reimbursement_status = reimbursement_status;
    }

    public ERS_Reimbursement_Status(String reimbursement_status) {
        this.reimbursement_status = reimbursement_status;
    }

    public int getReimbursement_status_id() {
        return reimbursement_status_id;
    }

    public void setReimbursement_status_id(int reimbursement_status_id) {
        this.reimbursement_status_id = reimbursement_status_id;
    }

    public String getReimbursement_status() {
        return reimbursement_status;
    }

    public void setReimbursement_status(String reimbursement_status) {
        this.reimbursement_status = reimbursement_status;
    }

    @Override
    public String toString() {
        return "ERS_Reimbursement_Status{" +
                "reimbursement_status_id=" + reimbursement_status_id +
                ", reimbursement_status='" + reimbursement_status + '\'' +
                '}';
    }
}
