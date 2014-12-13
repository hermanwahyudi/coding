<?php
	class Uang 
	{
		function solve($uang) {
			$arr = [1, 2, 5, 10, 20, 50, 100, 200, 500, 1000];
			$hasilBagi=0;
			$str="";
			$i=0;
			while($uang > 0) {
				if($uang>=$arr[9]) $i=9;
				else if($uang>=$arr[8]) $i=8;
				else if($uang>=$arr[7]) $i=7;
				else if($uang>=$arr[6]) $i=6;
				else if($uang>=$arr[5]) $i=5;
				else if($uang>=$arr[4]) $i=4;
				else if($uang>=$arr[3]) $i=3;
				else if($uang>=$arr[2]) $i=2;
				else if($uang>=$arr[1]) $i=1;
				else $i=0;
				$hasilBagi=intval($uang/$arr[$i]);
				$uang=$uang%$arr[$i];
				$str.=$arr[$i]." ".$hasilBagi . "\n";
			}
			return $str;
		} 
	}
	$obj=new Uang;
	$in=trim(fgets(STDIN));
	echo $obj->solve($in);