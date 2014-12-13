<?php
	class Latihan {

		public function palindrome($str) {
			$len = strlen($str);
			$i = 0;
			$start = 0;
			$end = $len-1;
			while($i < $len/2) {
				if($str[$start] == $str[$end]) {
					$start++; $end--;
				} else return false;
				$i++;
			}
			return true;
		}
		public function bubbleSort($srr) {

		} 
		public function reverse($str) {

		}
		public function fibonacci($arr) {

		} 
		public function search($arr) {

		}
		public function count4x6($N) {
			$i=0;
			$k=1;
			while($i<$N) {
				if($k%4 == 0 && $k%6 == 0) {
					echo $k . "\n";
					$i++;
				}
				$k++;
			}
		}
 	}
	$input = trim(fgets(STDIN));
	$obj = new Latihan;
	echo $obj->palindrome("Herman");
	//echo $obj->reverse("Herman");
	//echo substr($input, 1, 2);
	$obj->count4x6($input); 
	