<?php

    require_once('db_con.php');    
    
    $connection = connect_to_db();
    
    $sql = "SELECT * FROM review;";
    
    // execute query
     $result = $connection->query($sql) or die(mysqli_error($connection));        
    
    echo "<br><table border=1>";
    echo "<tr><th>ID</th><th>Name</th><th>Email</th><th>Referrer</th><th>Rating</th><th>Comments</th></tr>";

    // check whether we found a row
    while ($course = $result->fetch_assoc())
    {
        echo "<tr><td>" . $course['id'] . "</td><td>". $course['name'] ."</td><td>". $course['email'] ."</td><td>". $course['referrer'] ."</td><td>". $course['rating'] ."</td><td>". $course['comments'] ."</td></tr>\n";
    }
    echo "</table>\n";
    
?>

