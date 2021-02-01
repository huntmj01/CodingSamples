<?php
       
    require_once 'db_connect.php';
       
	//connect to DB
	$connection= connect_to_db();

	

    function insertContactForm(){
       
        echo"
            <div class='container'>
            <br>
            <div class='container-fluid bg-grey' style='margin-top:6%'>
                
                <div class='page-title text-center'>
                    <h1>Get in touch with us!</h1>
                    <hr class='pg-titl-bdr-btm' style='background-color:blue'></hr>
                </div>
                
                <div class='row' style='margin-top:3%'>
                    
                    <div class='col-sm-4'>
                        <p>Contact us and we'll get back to you within 24 hours.</p>
                        <p><span class='glyphicon glyphicon-map-marker'></span> Fort Wayne, US</p>
                        <p><span class='glyphicon glyphicon-phone'></span> +00 1515151515</p>
                        <p><span class='glyphicon glyphicon-envelope'></span> myemail@something.com</p>
                    </div>
                    
                    <div class='col-sm-7'>
                        <form action='".$_SERVER['PHP_SELF']."' method='post'>
                            <div class='row'>
                                <div class='col-sm-6 form-group'>
                                    <input class='form-control' id='name' name='name' placeholder='Name' type='text' required>
                                </div>
                                <div class='col-sm-6 form-group'>
                                    <input class='form-control' id='email' name='email' placeholder='Email' type='email' required>
                                </div>
                                <div class='col-sm-12 form-group'>
                                    <input class='form-control' id='subject' name='subject' placeholder='Subject' type='text' required>
                                </div>
                            </div>
                            
                            <textarea class='form-control' id='message' name='message' placeholder='Message' rows='5'></textarea><br>
                            
                            <div class='row'>
                                <div class='col-sm-12 form-group'>
                                    <button class='btn btn-default pull-right' type='submit' id='sendContact'>Send</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
        ";
    }
    //if username and password were submitted, check them
	if(isset($_POST["name"])&&isset($_POST["email"])&&isset($_POST["message"])){
		//prepare sql
		$sql=sprintf("INSERT INTO contact VALUES (uuid(),'%s', '%s', '%s', '%s','".date("Y-m-d H:i:s")."', '1');",
						$connection->real_escape_string($_POST["name"]),
						$connection->real_escape_string($_POST["email"]),
						$connection->real_escape_string($_POST["subject"]),
						$connection->real_escape_string($_POST["message"]));
		
		//execute query
		$result=$connection->query($sql) or die(mysqli_error($connection));
		
		// TODO: Make this not suck
		 echo "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js\"></script>
        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css\">";
		echo "<script type=\"text/javascript\">sweetAlert(\"Your message has been submitted!\",\"We will contact you within 2-3 business days.\",\"success\")</script>";
	} 
?>