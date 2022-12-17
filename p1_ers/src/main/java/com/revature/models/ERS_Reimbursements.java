package com.revature.models;

public class ERS_Reimbursements {
    private int ers_reimbursement_id;
    private int reimbursement_amount;
    private String reimbursement_description;
    private int user_id_fk;
    private int reimbursement_type_fk;
    private int reimbursement_status_fk;

    public ERS_Reimbursements() {
    }

    public ERS_Reimbursements(int ers_reimbursement_id, int reimbursement_amount, String reimbursement_description, int user_id_fk, int reimbursement_type_fk, int reimbursement_status_fk) {
        this.ers_reimbursement_id = ers_reimbursement_id;
        this.reimbursement_amount = reimbursement_amount;
        this.reimbursement_description = reimbursement_description;
        this.user_id_fk = user_id_fk;
        this.reimbursement_type_fk = reimbursement_type_fk;
        this.reimbursement_status_fk = reimbursement_status_fk;
    }

    public ERS_Reimbursements(int reimbursement_amount, String reimbursement_description) {
        this.reimbursement_amount = reimbursement_amount;
        this.reimbursement_description = reimbursement_description;
    }

    public int getErs_reimbursement_id() {
        return ers_reimbursement_id;
    }

    public void setErs_reimbursement_id(int ers_reimbursement_id) {
        this.ers_reimbursement_id = ers_reimbursement_id;
    }

    public int getReimbursement_amount() {
        return reimbursement_amount;
    }

    public void setReimbursement_amount(int reimbursement_amount) {
        this.reimbursement_amount = reimbursement_amount;
    }

    public String getReimbursement_description() {
        return reimbursement_description;
    }

    public void setReimbursement_description(String reimbursement_description) {
        this.reimbursement_description = reimbursement_description;
    }

    public int getUser_id_fk() {
        return user_id_fk;
    }

    public void setUser_id_fk(int user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

    public int getReimbursement_type_fk() {
        return reimbursement_type_fk;
    }

    public void setReimbursement_type_fk(int reimbursement_type_fk) {
        this.reimbursement_type_fk = reimbursement_type_fk;
    }

    public int getReimbursement_status_fk() {
        return reimbursement_status_fk;
    }

    public void setReimbursement_status_fk(int reimbursement_status_fk) {
        this.reimbursement_status_fk = reimbursement_status_fk;
    }

    @Override
    public String toString() {
        return "ERS_Reimbursements{" +
                "ers_reimbursement_id=" + ers_reimbursement_id +
                ", reimbursement_amount=" + reimbursement_amount +
                ", reimbursement_description='" + reimbursement_description + '\'' +
                ", user_id_fk=" + user_id_fk +
                ", reimbursement_type_fk=" + reimbursement_type_fk +
                ", reimbursement_status_fk=" + reimbursement_status_fk +
                '}';
    }
}
