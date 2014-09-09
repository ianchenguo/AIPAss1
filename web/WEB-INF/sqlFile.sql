/*drop and create account related tables*/
drop view jdbcrealm_user;
drop view jdbcrealm_group;
drop table account;
CREATE table AIP.ACCOUNT (
    ID          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    GROUPNAME   VARCHAR(255)NOT NULL,
    USERNAME    VARCHAR(255)NOT NULL UNIQUE, 
    PASSWORD    VARCHAR(255)NOT NULL,
    FULLNAME    VARCHAR(255)NOT NULL,
    EMPLOYEEID  VARCHAR(255)NOT NULL UNIQUE,
    EMAIL       VARCHAR(255)NOT NULL);

CREATE VIEW JDBCREALM_USER(USERNAME,PASSWORD) AS
SELECT USERNAME,PASSWORD
FROM AIP.ACCOUNT;

CREATE VIEW JDBCREALM_GROUP(USERNAME,GROUPNAME) AS
SELECT USERNAME,GROUPNAME
FROM AIP.ACCOUNT;

select * from JDBCREALM_GROUP;
select * from JDBCREALM_user;

/*drop and create activity related tables*/
DROP TABLE AIP.PILOTTRAINING;
DROP TABLE AIP.JOYFLIGHT;
DROP TABLE AIP.ACTIVITY;


CREATE table AIP.ACTIVITY (
    ID          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    TITLE       VARCHAR(255)NOT NULL, 
    ACTIVITYTYPE        VARCHAR(255) NOT NULL,
    PROVIDER      VARCHAR(255) NOT NULL,
    AIRCRAFT     VARCHAR(255) NOT NULL,
    ACTIVITYSTATE   VARCHAR(255) NOT NULL,
    ACTIVITYDESC    VARCHAR(255) NOT NULL
);


CREATE TABLE AIP.PILOTTRAINING (
    ID  INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    ACTIVITYID  INTEGER NOT NULL,
    CERTIFICATE    VARCHAR(255)NOT NULL,
    DURATION    VARCHAR(255)NOT NULL,
    CONSTRAINT ACTIVITY_PILOTTRAINING_FK
    FOREIGN KEY (ACTIVITYID)
        REFERENCES AIP.ACTIVITY(ID) ON DELETE CASCADE);

CREATE TABLE AIP.JOYFLIGHT (
    ID  INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    ACTIVITYID  INTEGER NOT NULL,
    CAPACITY    INTEGER NOT NULL,
    CONSTRAINT ACTIVITY_JOYFLIGHT_FK
    FOREIGN KEY (ACTIVITYID)
        REFERENCES AIP.ACTIVITY(ID) ON DELETE CASCADE);


/* test scripts
select activity.id,title,activitytype,provider,aircraft,activitystate,activitydesc,capacity 
from aip.activity, aip.joyflight 
where aip.activity.id = aip.joyflight.activityid;

select activity.id,title,activitytype,provider,aircraft,activitystate,activitydesc,certificate,duration 
from aip.activity, aip.pilottraining 
where aip.activity.id = aip.pilottraining.activityid;

insert into aip.activity (title,activitytype,provider,aircraft,activitystate,activitydesc) values ('joy1','JOYFLIGHT','provider1','z11','UPCOMING','activity desc');
insert into aip.joyflight (activityid,capacity) values (1,1);
insert into aip.activity (title,activitytype,provider,aircraft,activitystate,activitydesc) values ('train1','PILOTTRAINING','provider2','f22','EXPIRED','activity desc');
insert into aip.pilottraining (activityid,certificate,duration) values (2,'fighter pilot','3 months');

insert into aip.activity (title,activitytype,provider,aircraft,activitystate,activitydesc) values ('testjoy1','JOYFLIGHT','provider1','y10','UPCOMING','activity desc');

select activity.id,title,activitytype,provider,aircraft,activitystate,activitydesc,capacity 
from aip.activity, aip.joyflight 
where aip.activity.id = aip.joyflight.activityid
and activity.id = 1;*/