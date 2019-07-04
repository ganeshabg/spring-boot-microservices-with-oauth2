
create table  oauth_client_details (
  client_id varchar(255) not null,
  client_secret varchar(255) not null,
  web_server_redirect_uri varchar(2048) not null,
  scope varchar(255) not null,
  access_token_validity int(11) not null,
  refresh_token_validity int(11) not  null,
  resource_ids varchar(1024) not  null,
  authorized_grant_types varchar(1024) not null,
  authorities varchar(1024) default null,
  additional_information varchar(4096) not  null,
  autoapprove varchar(255) default null,
  primary key (client_id)
);

create TABLE  oauth_client_token (
  token_id VARCHAR(256),
  token CLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);


create TABLE oauth_access_token (
  token_id VARCHAR(256),
  token CLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication CLOB,
  refresh_token VARCHAR(256)
);

create TABLE  oauth_refresh_token (
  token_id VARCHAR(256),
  token CLOB,
  authentication CLOB
);

create TABLE oauth_code (
  code VARCHAR(256),
  authentication CLOB
);

create TABLE   oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);


create table ROLE (
    id integer not null,
    name varchar(20) not null,
    primary key(id),
    unique (name)
);



create table PERMISSION (
    id integer not null ,
    name varchar(20) not null,
    primary  key(id),
    unique (name)
);


create table  ROLE_PERMISSION (
    role_id integer not null,
    permission_id integer not null,
    primary key(role_id, permission_id),
    constraint permission_role_ibfk_1 foreign key (permission_id) references permission (id),
    constraint permission_role_ibfk_2 foreign key (role_id) references role (id)
);

create table   user (
  id int(11) not null auto_increment,
  username varchar(100) not null,
  password varchar(1024) not null,
  email varchar(1024) not null,
  enabled number(4) not null,
  accountNonExpired number(4) not null,
  credentialsNonExpired number(4) not null,
  accountNonLocked number(4) not null,
  primary key (id),
  unique key username (username)
);

create table  ROLE_USER (
  role_id number default null,
  user_id number default null,
  primary key (user_id,user_id),
  constraint role_user_ibfk_1 foreign key (role_id) references role (id),
  constraint role_user_ibfk_2 foreign key (user_id) references user (id)
);