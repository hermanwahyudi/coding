using System;
using MySql.Data.MySqlClient;

class Latihan_3
{
	public static void Main() {
		string cs = @"server=localhost;userid=root;password=;database=herman_corp";
		MySqlConnection conn = null;
		
		try {
			conn = new MySqlConnection(cs);
			conn.Open();
			Console.WriteLine("{0}", conn.ServerVersion);
		} catch (MySqlException ex) {
			Console.WriteLine("Error: {0}", ex.ToString());
		}
		
		finally {
			if(conn != null) {
				conn.Close();
			}
		}
	}
}