CREATE TABLE ers_user_roles(
	user_role_id serial PRIMARY KEY,
	user_role TEXT
);
CREATE TABLE ers_users(
	user_id serial PRIMARY KEY,
	ers_username TEXT unique,
	ers_password TEXT,
	user_first_name TEXT,
	user_last_name TEXT,
	user_role_id_fk int REFERENCES ers_user_roles(user_role_id)
);
CREATE TABLE ers_reimb_type(
	reimb_type_id serial PRIMARY key,
	reimb_type TEXT
);
CREATE TABLE ers_reimb_status(
	reimb_status_id serial PRIMARY key,
	reimb_status TEXT
);
CREATE TABLE ers_reimbursements(
	reimb_id serial PRIMARY key,
	reimb_amount int,
	reimb_description TEXT,
	creator_id_fk int REFERENCES ers_users(user_id),
	resolver_id_fk int REFERENCES ers_users(user_id),
	reimb_type_fk int REFERENCES ers_reimb_type(reimb_type_id),
	reimb_status_fk int REFERENCES ers_reimb_status(reimb_status_id)
);
INSERT INTO ers_user_roles(user_role) VALUES ('Manager');
INSERT INTO ers_user_roles(user_role) VALUES ('Employee');
INSERT INTO ers_reimb_status(reimb_status) VALUES ('Pending');
INSERT INTO ers_reimb_status(reimb_status) VALUES ('Approved');
INSERT INTO ers_reimb_status(reimb_status) VALUES ('Denied');
INSERT into ers_reimb_type (reimb_type) VALUES ('Lodging');
INSERT into ers_reimb_type (reimb_type) VALUES ('Travel');
INSERT into ers_reimb_type (reimb_type) VALUES ('Food');
INSERT into ers_reimb_type (reimb_type) VALUES ('Other');
SELECT * FROM ers_user_roles;
SELECT * FROM ers_reimb_status;
SELECT * FROM ers_reimb_type;