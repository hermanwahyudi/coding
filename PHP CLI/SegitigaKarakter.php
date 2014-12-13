<?php
	$N=trim(fgets(STDIN));
	$str=trim(fgets(STDIN));
	$result=""; $space="";
	if($N==1)
		$result=$str[0];
	else if($N==2)
		$result = $str[0] . "\n" . $str[0].$str[2];
	else {
		$result = $str[0] . "\n" . $str[0].$str[2]."\n";
		for($i=1;$i<=$N-2;$i++) {
			for($j=0;$j<$i;$j++) {
				if($i==$N-2) 
					$result = $result . $str[1];
				else
					$space .= " "; 
			}
			if($i!=$N-2)
				$result = $result . $str[0].$space.$str[2]."\n";
			else 
				$result=$result.$str[1].$str[2];
			$space = "";
		}
	}
	echo $result;
	