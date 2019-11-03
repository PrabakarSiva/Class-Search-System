CREATE DATABASE /*!32312 IF NOT EXISTS*/ courseData;

USE courseData;

DROP TABLE IF EXISTS courses;

CREATE TABLE courses (
	coursesID INT NOT NULL AUTO_INCREMENT,
	professors varchar (25) NOT NULL,
	classNum varchar (8) NOT NULL,
	roomNum varchar (6) NOT NULL,
	classTimes varchar (25) NOT NULL,
	meetingDays varchar (25) NOT NULL,
	classNames varchar (60) NOT NULL,
	PRIMARY KEY (coursesID)
) 
;

insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Anas Salah Eddin','1101-1','9-521','TuTh 12:30 PM-4:45 PM','2019-05-29 to 2019-06-27','Electrical Circuit Analysis I')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Zekeriya Aliyazicioglu','2101-1','9-423','MW 8:00 AM-10:05 AM','2019-05-29 to 2019-08-01','Electrical Circuit Analysis II')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Saeed Monemi','2101L-1','9-147','MW 12:30 PM-4:45 PM','2019-05-29 to 2019-06-27','Electrical Circuit Analysis II Laboratory')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Brita Olson','2200-1','9-405','MW 12:30 AM-2:35 PM','2019-05-29 to 2019-08-01','Introduction to Microelectronics Circuits')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Brita Olson','2200L-1','9-431','M 5:00 PM–9:15 PM','2019-05-29 to 2019-08-01','	Introduction to Microelectronics Circuits Laboratory')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Mohamed Aly','2300-1','9-423','MTuWTh 2:45 PM–4:50 PM','2019-05-29 to 2019-06-27','Digital Logic Design')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Mohamed Aly','2300L-1','9-435','MTu 5:00 PM–9:15 PM','2019-05-29 to 2019-06-27','Digital Logic Design Laboratory')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('James Kang','3101-1','9-401','TuTh 10:15 AM–12:20 PM','2019-05-29 to 2019-08-01','Signals and Systems')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Brita Olson','3101-2','9-401','MW 10:15 AM–12:20 PM','2019-05-29 to 2019-08-01','Signals and Systems')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Zekeriya Aliyazicioglu','3101L-1','9-503','W 12:30 PM–4:45 PM','2019-05-29 to 2019-08-01','Signals and Systems Laboratory')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Brita Olson','3200-1','9-401','MW 8:00 AM–10:05 AM','2019-05-29 to 2019-08-01','Microelectronic Devices and Circuits')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Brita Olson','3200L-1','9-431','W 5:00 PM–9:15 PM','2019-05-29 to 2019-08-01','Analog Microelectronics Laboratory')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('James Kang','3250-1','9-401','TuTh 2:45 PM–4:50 PM','2019-05-29 to 2019-08-01','Electromagnetic Fields')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Mohamed Rafiquzzaman','3301-1','9-521','MW 12:30 PM–2:35 PM','2019-05-29 to 2019-08-01','Introduction to Microcontrollers')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Mohamed Rafiquzzaman','3301L-1','9-507','MW 2:45 PM–4:50 PM','2019-05-29 to 2019-08-01','Introduction to Microcontrollers Laboratory')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Hong-Chuan Linn','3715-1','9-423','TuTh 5:00 PM–7:05 PM','2019-05-29 to 2019-08-01','Probability, Statistics, and Random Processes')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Anas Salah Eddin','3715-2','9-401','MW 12:30 PM–4:45 PM','2019-05-29 to 2019-06-27','Probability, Statistics, and Random Processes')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Saeed Monemi','4064-2','9-117','M 5:00 PM–7:50 PM','2019-05-29 to 2019-06-27','Professional Engineering Practice')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Mohamed Aly','4300-1','9-521','MW 8:00 AM–12:15 PM','2019-05-29 to 2019-06-27','Computer Architecture')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Hong-Chuan Lin','4319-1','9-205','TuTh 2:45 PM–4:50 PM','2019-05-29 to 2019-08-01','Application Development Using JAVA')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Zekeriya Aliyazicioglu','4705-1','9-423','MW 10:15 AM–12:20 PM','2019-05-29 to 2019-08-01','Communication Systems')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('Zekeriya Aliyazicioglu','4705L-1','9-523','M 12:30 PM–4:45 PM','2019-05-29 to 2019-08-01','Communication Systems Laboratory')
;
insert into courses (professors,classNum,roomNum,classTimes,meetingDays,classNames) values ('James Kang','4708-1','9-401','MW 5:00 PM–7:05 PM','2019-05-29 to 2019-08-01','Digital Signal Processing')
;
