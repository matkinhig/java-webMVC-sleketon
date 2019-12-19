/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Luc Nguyen by Matkinhig <lucnguyen.hcmut@gmail.com>
 * Created: Dec 19, 2019
 */

-- Create table
create table USER_ACCOUNT
(
USER_NAME VARCHAR2(30) not null,
GENDER    VARCHAR2(1) not null,
PASSWORD  VARCHAR2(30) not null,
primary key (USER_NAME)
);

-- Create table
create table PRODUCT
(
CODE  VARCHAR2(20) not null,
NAME  VARCHAR2(128) not null,
PRICE FLOAT not null,
primary key (CODE)
) ;


insert into user_account (USER_NAME, GENDER, PASSWORD)
values ('tom', 'M', 'tom001');
 
insert into user_account (USER_NAME, GENDER, PASSWORD)
values ('jerry', 'M', 'jerry001');

insert into product (CODE, NAME, PRICE)
values ('P001', 'Java Core', 100);
 
insert into product (CODE, NAME, PRICE)
values ('P002', 'C# Core', 90);
 
-- Commit
Commit;

