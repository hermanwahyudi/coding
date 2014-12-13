<?php 
	echo "Type your name: ";
	$name = trim(fgets(STDIN));
	echo "Hallo " . $name;
	
	mysql_connect("localhost", "root", "");
	mysql_select_db("db_pegawai");
	$query = mysql_query("SELECT * FROM TB_DAFTAR_NAMA WHERE nama LIKE '%$name%'");
	if(mysql_num_rows($query) > 0) echo "Yeah!";
	while($row=mysql_fetch_array($query)) {
		echo $row['nama'] . "\n";
	}
?>