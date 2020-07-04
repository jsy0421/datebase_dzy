/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/3 14:28:17                            */
/*==============================================================*/


drop table if exists address;

drop table if exists administrator;

drop table if exists category;

drop table if exists commodity;

drop table if exists decrease;

drop table if exists details;

drop table if exists discount;

drop table if exists evaluate;

drop table if exists limittime;

drop table if exists menu;

drop table if exists thingorder;

drop table if exists purchase;

drop table if exists recommend;

drop table if exists relationship;

drop table if exists user;

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
create table address
(
   address_id           int not null,
   user_id              int,
   address_province     varchar(10) not null,
   address_city         varchar(10) not null,
   address_area         varchar(10) not null,
   address_details      varchar(100) not null,
   address_people       varchar(20) not null,
   address_phone        varchar(11) not null,
   primary key (address_id)
);

/*==============================================================*/
/* Table: administrator                                         */
/*==============================================================*/
create table administrator
(
   administrator_id     int not null,
   administrator_name   varchar(20) not null,
   administrator_password varchar(20) not null,
   primary key (administrator_id)
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   category_id          int not null,
   category_name        varchar(50) not null,
   category_describe    varchar(100),
   primary key (category_id)
);

/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
create table commodity
(
   commodity_id         int not null,
   category_id          int,
   commodity_name       varchar(20) not null,
   commodity_price      decimal(5,2) not null,
   commodity_club       decimal(5,2) not null,
   commodity_number     int not null,
   commodity_standard   varchar(50) not null,
   commodity_details    varchar(100) not null,
   primary key (commodity_id)
);

/*==============================================================*/
/* Table: decrease                                              */
/*==============================================================*/
create table decrease
(
   decrease_id          int not null,
   decrease_details     varchar(100) not null,
   decrease_count       int not null,
   decrease_discount    decimal(5,2) not null,
   decrease_startdate   datetime not null,
   decrease_finishdate  datetime not null,
   primary key (decrease_id)
);

/*==============================================================*/
/* Table: details                                               */
/*==============================================================*/
create table details
(
   order_id             int not null,
   commodity_id         int not null,
   decrease_id          int not null,
   details_count        int not null,
   details_price        decimal(5,2) not null,
   details_discount     decimal(5,2) not null,
   primary key (order_id, commodity_id, decrease_id)
);

/*==============================================================*/
/* Table: discount                                              */
/*==============================================================*/
create table discount
(
   discount_id          int not null,
   discount_details     varchar(100) not null,
   discount_usemoney    decimal(5,2) not null,
   discount_minusmoney  decimal(5,2) not null,
   discount_startdate   datetime not null,
   discount_finishdate  datetime not null,
   primary key (discount_id)
);

/*==============================================================*/
/* Table: evaluate                                              */
/*==============================================================*/
create table evaluate
(
   commodity_id         int not null,
   user_id              int not null,
   evaluate_details     varchar(100) not null,
   evaluate_date        datetime not null,
   evaluate_star        int not null,
   evaluate_picture     longblob not null,
   primary key (commodity_id, user_id)
);

/*==============================================================*/
/* Table: limittime                                               */
/*==============================================================*/
create table limittime
(
   limit_id             int not null,
   commodity_id         int,
   limit_price          decimal(5,2) not null,
   limit_count          int not null,
   limit_startdate      datetime not null,
   limit_finishdate     datetime not null,
   primary key (limit_id)
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   menu_id              int not null,
   menu_name            varchar(20) not null,
   menu_use             varchar(100) not null,
   menu_step            varchar(100) not null,
   menu_picture         longblob not null,
   primary key (menu_id)
);

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table thingorder
(
   order_id             int not null,
   user_id              int,
   address_id           int,
   discount_id          int,
   order_original       decimal(5,2) not null,
   order_final          decimal(5,2) not null,
   order_time           datetime not null,
   order_state          varchar(4) not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: purchase                                              */
/*==============================================================*/
create table purchase
(
   purchase_id          int not null,
   commodity_id         int,
   administrator_id     int,
   purchase_count       int not null,
   purchase_state       varchar(4) not null,
   primary key (purchase_id)
);

/*==============================================================*/
/* Table: recommend                                             */
/*==============================================================*/
create table recommend
(
   commodity_id         int not null,
   menu_id              int not null,
   recommend_describe   varchar(100) not null,
   primary key (commodity_id, menu_id)
);

/*==============================================================*/
/* Table: relationship                                          */
/*==============================================================*/
create table relationship
(
   commodity_id         int not null,
   decrease_id          int not null,
   relationship_startdate datetime not null,
   relationship_finishdate datetime not null,
   primary key (commodity_id, decrease_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null,
   user_name            varchar(20) not null,
   user_sex             varchar(2) not null,
   user_password        varchar(20) not null,
   user_phone           varchar(11) not null,
   user_email           varchar(50) not null,
   user_city            varchar(20) not null,
   user_registration    datetime not null,
   user_member          varchar(2) not null,
   user_deadline        datetime not null,
   primary key (user_id)
);

alter table address add constraint FK_address foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table commodity add constraint FK_classify foreign key (category_id)
      references category (category_id) on delete restrict on update restrict;

alter table details add constraint FK_details foreign key (order_id)
      references thingorder (order_id) on delete restrict on update restrict;

alter table details add constraint FK_details2 foreign key (commodity_id)
      references commodity (commodity_id) on delete restrict on update restrict;

alter table details add constraint FK_details3 foreign key (decrease_id)
      references decrease (decrease_id) on delete restrict on update restrict;

alter table evaluate add constraint FK_evaluate foreign key (commodity_id)
      references commodity (commodity_id) on delete restrict on update restrict;

alter table evaluate add constraint FK_evaluate2 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table limittime add constraint FK_limit foreign key (commodity_id)
      references commodity (commodity_id) on delete restrict on update restrict;

alter table thingorder add constraint FK_discount foreign key (discount_id)
      references discount (discount_id) on delete restrict on update restrict;

alter table thingorder add constraint FK_order foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table thingorder add constraint FK_order_address foreign key (address_id)
      references address (address_id) on delete restrict on update restrict;

alter table purchase add constraint FK_buy foreign key (administrator_id)
      references administrator (administrator_id) on delete restrict on update restrict;

alter table purchase add constraint FK_purchase foreign key (commodity_id)
      references commodity (commodity_id) on delete restrict on update restrict;

alter table recommend add constraint FK_recommend foreign key (commodity_id)
      references commodity (commodity_id) on delete restrict on update restrict;

alter table recommend add constraint FK_recommend2 foreign key (menu_id)
      references menu (menu_id) on delete restrict on update restrict;

alter table relationship add constraint FK_relationship foreign key (commodity_id)
      references commodity (commodity_id) on delete restrict on update restrict;

alter table relationship add constraint FK_relationship2 foreign key (decrease_id)
      references decrease (decrease_id) on delete restrict on update restrict;

