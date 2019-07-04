create table  customer (
  id number(10) not null,
  name varchar(255) not null,
  email_id varchar(255) not null,
  primary key (id)
);

create table address (
    c_id number(10) not null,
    id number(10) not null,
    address_first_line varchar(25) not null,
    address_last_line varchar(25) not null,
    pincode varchar(10) not null,
    primary key(id)
);