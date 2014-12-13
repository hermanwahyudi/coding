<?php
	class Caesar {
		function solve($N, $str) {
			$result = "";
			$i=0;
			while($i<strlen($str)) {
				if($str[$i] == " ") $str[$i] = " ";
				else $str[$i] = chr((ord($str[$i])+$N));
				$i++;
			}
			return $str . "\n";
		}
	}
	$obj = new Caesar;
	$N = trim(fgets(STDIN));
	$str =  trim(fgets(STDIN));
	echo $obj->solve($N, $str);


