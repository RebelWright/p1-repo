CREATE TABLE ers_user_roles(
	user_role_id serial PRIMARY KEY,
	user_role TEXT
);
CREATE TABLE ers_users(
	user_id serial PRIMARY KEY,
	ers_username TEXT,
	ers_password TEXT,
	ers_first_name TEXT,
	ers_last_name TEXT,
	user_role_id_fk int REFERENCES ers_user_roles(user_role_id)
);
CREATE TABLE ers_reimbursement_types(
	reimbursement_type_id serial PRIMARY key,
	reimbursement_type TEXT
);
CREATE TABLE ers_reimbursement_status(
	reimbursement_status_id serial PRIMARY key,
	reimbursement_status TEXT
);
CREATE TABLE ers_reimbursements(
	ers_reimbursement_id serial PRIMARY key,
	reimbursement_amount int,
	reimbursement_description TEXT,
	user_id_fk int REFERENCES ers_users(user_id),
	reimbursement_type_fk int REFERENCES ers_reimbursement_types(reimbursement_type_id),
	reimbursement_status_fk int REFERENCES ers_reimbursement_status(reimbursement_status_id)
);