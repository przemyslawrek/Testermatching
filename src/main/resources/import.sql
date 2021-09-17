--INSERT INTO tester (tester_id, first_name, last_name, country,last_login) VALUES ( 2, 'Zofia', 'Rek', 'PL',NOW() );
--INSERT INTO tester (tester_id, first_name, last_name, country,last_login) VALUES ( SELECT * FROM CSVREAD('data/testers.csv', );
INSERT INTO TESTER(TESTER_ID, FIRST_NAME, LAST_NAME, COUNTRY, LAST_LOGIN) SELECT * FROM CSVREAD('classpath:/testers.csv');
INSERT INTO DEVICE(device_Id, description) SELECT * FROM CSVREAD('classpath:/devices.csv');
INSERT INTO BUG(bug_Id, device_ID, tester_Id) SELECT * FROM CSVREAD('classpath:/bugs.csv');
INSERT INTO tester_device(tester_Id, device_Id) SELECT testerId AS tester_id, deviceId as device_id FROM CSVREAD('classpath:/tester_device.csv');
