<?php 
    // enable sessions
    session_start();

    $OPTIONS = array("Google","Friend","Advert","Other");
    
    // if form was actually submitted, check for error    
    if (isset($_POST["submit"]))
    {
        if (empty($_POST["name"]) ||
        	empty($_POST["email"]) || 
	        empty($_POST["hear"]) ||
	        empty($_POST["visit"]) ||
	        empty($_POST["comments"]) ||
	        empty($_POST["updates"]))
        { 
	        $error = true;
	    }else{
	        // redirect user to confirm page, using absolute path, per
            // http://us2.php.net/manual/en/function.header.php
            $host = $_SERVER["HTTP_HOST"];
            $path = rtrim(dirname($_SERVER["PHP_SELF"]), "/\\");
            header("Location: http://$host/$path/confirm.php");
            exit;
	    }
    }
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Forms</title>
    </head>
    <body>
        <?php if (isset($error)): ?>
            <div style="color: red">You must fill out the form!</div>
      	<?php endif ?>
      	 <form action="index.php" method="post">
        <fieldset>
            <legend>Your Details:</legend>
                <label>Name: </label>
                <input name="name" type="text" value = "<?php if (isset($_POST["name"])) 
						echo htmlspecialchars($_POST["name"]); ?>"/>
                <br/>
                <label>Email: </label>
                <input name="email" type="email" value = "<?php if (isset($_POST["email"])) 
						echo htmlspecialchars($_POST["email"]); ?>"/>
        </fieldset>
        <br/>
        <fieldset>
            <legend>Your review:</legend>
           
                <br/>
                <label>How did you hear about us?</label>
                <select name="hear">
                    <?php 
						foreach ($OPTIONS as $option)
						{
							if (isset($_POST["hear"]) && $_POST["hear"] == $option)
								echo "<option selected='selected' value='$option'>$option</option>";
							else
								echo "<option value='$option'>$option</option>";
					 	}
					?>
                </select>
                <br/>
                <br/>
                <label>Would you visit again?</label>
                <br/>
                <input name="visit" type="radio" value="Yes" <?php if ((isset($_POST["visit"]) && $_POST["visit"] == "Yes")) 
								echo "checked"; ?>/>
                <label>Yes</label>
                <input name="visit" type="radio" value="No" <?php if ((isset($_POST["visit"]) && $_POST["visit"] == "No")) 
								echo "checked"; ?>/>
                 <label>No</label>
                <input name="visit" type="radio" value="Maybe" <?php if ((isset($_POST["visit"]) && $_POST["visit"] == "Maybe")) 
								echo "checked"; ?>/>
                 <label>Maybe</label>
                <br/>
                <br/>
                <label>Comments: </label>
                <br/>
                <textarea id="comments" name="comments" cols=40 rows=4><?php if (isset($_POST["comments"])) echo htmlspecialchars($_POST["comments"]); ?></textarea>
                <br/>
                <br/>
                <input name="updates" type="checkbox" <?php if (isset($_POST["updates"]))
								echo "checked"; ?>/>
                <label>Sign me up for email updates </label>
                <br/>
                <input type="submit" name="submit" value="Submit Review" />
            </fieldset>
        </form>
    </body>
</html>