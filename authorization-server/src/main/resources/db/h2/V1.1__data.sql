INSERT INTO oauth_client_details (client_id,
client_secret,
web_server_redirect_uri,
scope,
access_token_validity,
refresh_token_validity,
resource_ids,
authorized_grant_types,
additional_information)
VALUES ('customer',
'{bcrypt}$2a$04$J4spVK4UGfy.7pQ3ftf5ZuRYqBZjwrGiyERZQ/AE9E0rB7Oy5uyzu',
'http://localhost:8080/customer', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO PERMISSION (id,name) VALUES
 (1,'p_create'),
 (2,'p_read'),
 (3,'p_update'),
 (4,'P_delete');

 INSERT INTO role (id,NAME) VALUES
		(1,'ROLE_admin'),(2,'ROLE_user');

 INSERT INTO ROLE_PERMISSION (PERMISSION_ID, ROLE_ID) VALUES
     (1,1),
     (2,1),
     (3,1),
     (4,1),
     (2,2),
     (3,2);
insert into user (id,
username,
password,
email,
enabled,
accountNonExpired,
credentialsNonExpired,
accountNonLocked)
VALUES ('1',
'ganesh',
'{bcrypt}$2a$04$.1AVxsjG.F3E2NjAfPhm4eWPuyag80rZK/4Eoxiay5uw56BczvE5G',
'ganeshabg@gmail.com',
'1',
'1',
'1',
'1');


INSERT INTO ROLE_USER (ROLE_ID, USER_ID) VALUES (1, 1);