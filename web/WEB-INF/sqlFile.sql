
DROP TABLE AIP.ADMIN;
CREATE table AIP.ADMIN (
    ID          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    USERNAME    VARCHAR(255)NOT NULL UNIQUE, 
    PASSWORD    VARCHAR(255)NOT NULL,
    FULLNAME    VARCHAR(255)NOT NULL,
    EMPLOYEEID  VARCHAR(255)NOT NULL UNIQUE,
    EMAIL       VARCHAR(255)NOT NULL);
/*
DROP TABLE AIP.PILOGTRAININGPROPERTY;
DROP TABLE AIP.JOYFLIGHTPROPERTY;
DROP TABLE AIP.ACTIVITY;
DROP TABLE AIP.ACTIVITYTYPE;
DROP TABLE AIP.AIRCRAFT;
DROP TABLE AIP.ACTIVITYPROVIDER;


CREATE TABLE AIP.ACTIVITYTYPE (
    ID          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    TYPENAME    VARCHAR(255) NOT NULL);


CREATE TABLE AIP.AIRCRAFT (
    ID          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    MODEL    VARCHAR(255) NOT NULL);


CREATE TABLE AIP.ACTIVITYPROVIDER (
    ID          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    NAME    VARCHAR(255) NOT NULL);


CREATE table AIP.ACTIVITY (
    ID          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    TITLE       VARCHAR(255)NOT NULL, 
    TYPEID      INTEGER NOT NULL,
    PROVIDERID      INTEGER NOT NULL,
    AIRCRAFTID      INTEGER NOT NULL,
    ACTIVITYSTATE   VARCHAR(255) NOT NULL,
    ACTIVITYDESC    VARCHAR(255) NOT NULL,
    FOREIGN KEY (TYPEID)
        REFERENCES AIP.ACTIVITYTYPE (ID),
    FOREIGN KEY (PROVIDERID)
        REFERENCES AIP.ACTIVITYPROVIDER (ID),
    FOREIGN KEY (AIRCRAFTID)
        REFERENCES AIP.AIRCRAFT(ID)
);


CREATE TABLE AIP.PILOGTRAININGPROPERTY (
    ACTIVITYID  INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    CERTIFICATE    VARCHAR(255)NOT NULL,
    DURATION    VARCHAR(255)NOT NULL,
    FOREIGN KEY (ACTIVITYID)
        REFERENCES AIP.ACTIVITY(ID));

CREATE TABLE AIP.JOYFLIGHTPROPERTY (
    ACTIVITYID  INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    CAPACITY    INTEGER NOT NULL,
    FOREIGN KEY (ACTIVITYID)
        REFERENCES AIP.ACTIVITY(ID));
*/
DROP TABLE AIP.PILOTTRAINING;
DROP TABLE AIP.JOYFLIGHT;
DROP TABLE AIP.ACTIVITY;
DROP TABLE AIP.ACTIVITYTYPE;
DROP TABLE AIP.AIRCRAFT;
DROP TABLE AIP.ACTIVITYPROVIDER;

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
    FOREIGN KEY (ACTIVITYID)
        REFERENCES AIP.ACTIVITY(ID));

CREATE TABLE AIP.JOYFLIGHT (
    ID  INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
    ACTIVITYID  INTEGER NOT NULL,
    CAPACITY    INTEGER NOT NULL,
    FOREIGN KEY (ACTIVITYID)
        REFERENCES AIP.ACTIVITY(ID));

truncate table joyflight;
truncate table pilottraining;
truncate table activity;


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