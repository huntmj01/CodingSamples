/**
*
* CONTACT
*
**/
TRUNCATE TABLE contact;

DROP procedure insert_contact_test_data;

DELIMITER $$
CREATE PROCEDURE insert_contact_test_data()
BEGIN
  DECLARE i INT DEFAULT 1;

  WHILE i < 100 DO
		INSERT INTO contact (id, name, email, subject, message, time_stamp, active) 
		VALUES (uuid(), Concat('userWithMessage',i), Concat('userWithMessage', i,'@gmail.com'),Concat('question ',i), CONCAT('message ', i), 
        FROM_UNIXTIME(
        UNIX_TIMESTAMP(now()) - FLOOR(0 + (RAND() * 604800))
    )
        , 1) ;
        
        SET i = i + 1;
  END WHILE;
END$$
DELIMITER ;

CALL insert_test_data();

SELECT * FROM docdashDB.contact;


/**
*
* Entry Log
*
**/
TRUNCATE TABLE entry_log;

DROP procedure insert_entrylog_test_data;

DELIMITER $$
CREATE PROCEDURE insert_entrylog_test_data()
BEGIN
  DECLARE i INT DEFAULT 1;

  WHILE i < 100 DO
		INSERT INTO entry_log (id, msg, stacktrace, time_stamp, caller_page, user, level) 
		VALUES (uuid(), Concat('error message ',i), Concat('stacktrace ', i),
        FROM_UNIXTIME(
			UNIX_TIMESTAMP(now()) - FLOOR(0 + (RAND() * 604800))
		),
		Concat('caller page ',i), '183ccd4d-d20f-11e7-bd0c-06d328de5d72', CONCAT('level ', i));
        SET i = i + 1;
  END WHILE;
END$$
DELIMITER ;

CALL  insert_entrylog_test_data();

SELECT * FROM docdashDB.entry_log;