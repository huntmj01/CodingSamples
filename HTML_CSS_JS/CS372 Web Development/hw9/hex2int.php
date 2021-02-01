<?php	
	echo hexdec("1e") . "<br>";
	echo hexdec("a") . "<br>";
	echo hexdec("11ff") . "<br>";
	echo hexdec("cceeff"). "<br>". "<br>";
	
	hex2int("1e");
	hex2int("a");
	hex2int("11ff");
	hex2int("cceeff");
	
	function hex2int($hex){
		
		$hex = strrev($hex);
		$arr = str_split($hex);
		$count = 0;
		$dec = 0;
		
		foreach ($arr as $item){
			
			if ($item == "a"){
				$item = 10;
			} else if ($item == "b"){
				$item = 11;
			} else if ($item == "c") {
				$item = 12;
			} else if ($item == "d") {
				$item = 13;
			} else if ($item == "e") {
				$item = 14;
			} else if ($item == "f") {
				$item = 15;
			}
			
			$dec += (int)$item * pow(16,$count);
			$count++;
		}
		
		echo $dec. "<br>";
		
	}
?>