-- because create drop setting is not working :(
drop table Taco_Ingredients;
drop table ingredient;
drop table Taco_Order_Tacos;
drop table Taco_Order;
drop table taco;
drop table users;
drop sequence hibernate_sequence;

create table Ingredient (
    id varchar2(4) not null,
    name varchar2(25) not null,
    type varchar2(10) not null
);
create table Taco(
id number,
name varchar2(50) not null,
createdAt date not null
);

create table Taco_Ingredients (
    TACO_ID number not null,
    INGREDIENTS_ID varchar2(4) not null
);


create table Taco_Order (
id number,
delivery_Name varchar2(50) not null,
delivery_Street varchar2(50) not null,
delivery_City varchar2(50) not null,
delivery_State varchar2(50) not null,
delivery_Zip varchar2(10) not null,
ccNumber varchar2(16) not null,
ccExpiration varchar2(5) not null,
ccCVV varchar2(3) not null,
placedAt date not null,
user_id number
);

create table Taco_Order_Tacos (
order_id number not null,
tacos_id number not null
);

ALTER TABLE taco add constraint taco_pk primary key (id);
ALTER TABLE Taco_Ingredients
ADD CONSTRAINT Taco_Ingredients_fk
  FOREIGN KEY (TACO_ID)
  REFERENCES taco(id);
  ALTER TABLE Ingredient add constraint Ingredient_pk primary key (id);
ALTER TABLE Taco_Ingredients
ADD CONSTRAINT Taco_Ingredients_fk2
  FOREIGN KEY (INGREDIENTS_ID)
  REFERENCES Ingredient(id);

ALTER TABLE Taco_Order add constraint Taco_Order_pk primary key (id);
ALTER TABLE Taco_Order_Tacos
ADD CONSTRAINT Taco_Order_Tacos_fk
  FOREIGN KEY (order_id)
  REFERENCES Taco_Order(id);

ALTER TABLE Taco_Order_Tacos
ADD CONSTRAINT Taco_Order_Tacos_fk2
  FOREIGN KEY (tacos_id)
  REFERENCES Taco(id);

create table users(
id varchar2(100),
city varchar2(100),
fullname varchar2(100),
password varchar2(100),
phone_number varchar2(100),
state varchar2(100),
street varchar2(100),
username varchar2(100),
zip varchar2(100));

CREATE SEQUENCE hibernate_sequence
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;