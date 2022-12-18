package com.revature.models;

public class ERS_Reimbursements {
    private int reimb_id;
    private int reimb_amount;
    private String reimb_description;
    private int creator_id_fk;
    private int resolver_id_fk;
    private int reimb_type_fk;
    private int reimb_status_fk;

    public ERS_Reimbursements() {
    }

    public ERS_Reimbursements(int reimb_id, int reimb_amount, String reimb_description, int creator_id_fk, int resolver_id_fk, int reimb_type_fk, int reimb_status_fk) {
        this.reimb_id = reimb_id;
        this.reimb_amount = reimb_amount;
        this.reimb_description = reimb_description;
        this.creator_id_fk = creator_id_fk;
        this.resolver_id_fk = resolver_id_fk;
        this.reimb_type_fk = reimb_type_fk;
        this.reimb_status_fk = reimb_status_fk;
    }

    public int getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(int reimb_id) {
        this.reimb_id = reimb_id;
    }

    public int getReimb_amount() {
        return reimb_amount;
    }

    public void setReimb_amount(int reimb_amount) {
        this.reimb_amount = reimb_amount;
    }

    public String getReimb_description() {
        return reimb_description;
    }

    public void setReimb_description(String reimb_description) {
        this.reimb_description = reimb_description;
    }

    public int getCreator_id_fk() {
        return creator_id_fk;
    }

    public void setCreator_id_fk(int creator_id_fk) {
        this.creator_id_fk = creator_id_fk;
    }

    public int getResolver_id_fk() {
        return resolver_id_fk;
    }

    public void setResolver_id_fk(int resolver_id_fk) {
        this.resolver_id_fk = resolver_id_fk;
    }

    public int getReimb_type_fk() {
        return reimb_type_fk;
    }

    public void setReimb_type_fk(int reimb_type_fk) {
        this.reimb_type_fk = reimb_type_fk;
    }

    public int getReimb_status_fk() {
        return reimb_status_fk;
    }

    public void setReimb_status_fk(int reimb_status_fk) {
        this.reimb_status_fk = reimb_status_fk;
    }

    @Override
    public String toString() {
        return "ERS_Reimbursements{" +
                "reimb_id=" + reimb_id +
                ", reimb_amount=" + reimb_amount +
                ", reimb_description='" + reimb_description + '\'' +
                ", creator_id_fk=" + creator_id_fk +
                ", resolver_id_fk=" + resolver_id_fk +
                ", reimb_type_fk=" + reimb_type_fk +
                ", reimb_status_fk=" + reimb_status_fk +
                '}';
    }
}
