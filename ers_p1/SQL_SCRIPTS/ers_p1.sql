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
	reimb_amount int not null,
	reimb_description TEXT not null,
	creator_id_fk int REFERENCES ers_users(user_id),
	resolver_id_fk int REFERENCES ers_users(user_id),
	reimb_type_fk int REFERENCES ers_reimb_type(reimb_type_id),
	reimb_status_fk int REFERENCES ers_reimb_status(reimb_status_id)
);
INSERT INTO ers_user_roles(user_role) VALUES ('Employee'), ('Manager');
INSERT INTO ers_reimb_status(reimb_status) VALUES ('Pending'),('Approved'),('Denied');
INSERT into ers_reimb_type (reimb_type) VALUES ('Lodging'), ('Travel'), ('Food'), ('Other');
SELECT * FROM ers_user_roles;
SELECT * FROM ers_reimb_status;
SELECT * FROM ers_reimb_type;
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_role_id_fk)
VALUES ('Twright', 'wootl337', 'Trent', 'Wright', 1);
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_role_id_fk)
VALUES ('Bboss', 'password', 'Big', 'Boss', 2);
SELECT * FROM ers_users;