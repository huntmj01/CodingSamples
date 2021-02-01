<?php

    require_once('db_con.php');    
    
    $connection = connect_to_db();
    
    // delete current table
    $sql = "DROP TABLE Courses;";
    
    $result = $connection->query($sql);   
    
    if ($result === false)
        echo("Table does not exist<br>");
    else
        echo "Table was deleted.<br>";    
    
    // create the table
    $sql = "CREATE TABLE Courses (
                Semester varchar(20) not null,
                Course varchar(50) primary key not null
            );";
    
    // execute query
    $result = $connection->query($sql) or die(mysqli_error($connection));    
    
    if ($result === false)
        die("Could not query database");
    else
        echo "Table was created.<br>";    
    
    // insert two records
    $sql = "INSERT INTO `Courses`(`Semester`, `Course`) 
            VALUES ('Fall 2016', 'Web Application Development'),
                   ('Spring 2016', 'Computer Networks');";
                
    // execute query
    $result = $connection->query($sql) or die(mysqli_error($connection));  

    if ($result === false)
        die("Could not query database");
    else
        echo "Records were inserted into DB.<br>";
        
    // read records from DB, and show them in a Web page.
    
    $sql = "SELECT Semester, Course FROM Courses;";
    
    // execute query
     $result = $connection->query($sql) or die(mysqli_error($connection));        
    
    echo "<br><table border=1>";
    echo "<tr><th>Semester</th><th>Course</th></tr>";
           

    // check whether we found a row
    while ($course = $result->fetch_assoc())
    {
        echo "<tr><td>" . $course['Semester'] . "</td><td>". $course['Course'] ."</td></tr>\n";
    }
    echo "</table>\n";
    
?>