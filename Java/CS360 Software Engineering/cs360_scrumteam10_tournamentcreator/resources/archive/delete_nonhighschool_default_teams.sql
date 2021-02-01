select * from default_teams;

DELETE FROM default_teams WHERE 
high_grade NOT LIKE '9' and
high_grade NOT LIKE '10' and
high_grade NOT LIKE '11' and
high_grade NOT LIKE '12';