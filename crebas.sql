/*==============================================================*/
/* Table: CLUSTER                                               */
/*==============================================================*/
create table CLUSTER
(
   CLUSTER_NAME         varchar(20) not null,
   GRID_NAME            varchar(20),
   OWNER                varchar(20),
   LATLONG              varchar(20),
   URL                  varchar(20),
   primary key (CLUSTER_NAME)
) character set = utf8;

/*==============================================================*/
/* Table: DATA                                                  */
/*==============================================================*/
create table DATA
(
   METRIC_NAME          varchar(20) not null,
   HOST_NAME            varchar(20) not null,
   REPORTED             datetime not null,
   VAL                  varchar(50),
   primary key (METRIC_NAME, REPORTED, HOST_NAME)
) character set = utf8;

/*==============================================================*/
/* Table: GRID                                                  */
/*==============================================================*/
create table GRID
(
   GRID_NAME            varchar(20) not null,
   AUTHORITY            varchar(60),
   primary key (GRID_NAME)
) character set = utf8;

/*==============================================================*/
/* Table: HOST                                                  */
/*==============================================================*/
create table HOST
(
   HOST_NAME            varchar(20) not null,
   CLUSTER_NAME         varchar(20),
   IP                   varchar(20),
   LOCATION             varchar(20),
   TAGS                 varchar(10),
   primary key (HOST_NAME)
) character set = utf8;

/*==============================================================*/
/* Table: METRIC                                                */
/*==============================================================*/
create table METRIC
(
   METRIC_NAME          varchar(20) not null,
   TYPE                 varchar(15),
   UNIT                 varchar(10),
   primary key (METRIC_NAME)
)character set = utf8;

create table USERS
(
   USER_ID              int(11) not null auto_increment,
   USER_NAME            varchar(30),
   USER_PASSWORD        varchar(30),
   primary key (USER_ID)
)character set = utf8;

alter table CLUSTER add constraint FK_Reference_1 foreign key (GRID_NAME)
      references GRID (GRID_NAME) on delete restrict on update cascade;

alter table DATA add constraint FK_Reference_4 foreign key (METRIC_NAME)
      references METRIC (METRIC_NAME) on delete restrict on update cascade;

alter table HOST add constraint FK_Reference_2 foreign key (CLUSTER_NAME)
      references CLUSTER (CLUSTER_NAME) on delete restrict on update cascade;


