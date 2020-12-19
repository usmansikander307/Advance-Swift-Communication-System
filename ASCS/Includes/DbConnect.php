<?php

class DbConnect
{
	private $con;

	function connect()
	{
		include_once dirname(__FILE__).'/Config.php';
		$this->con = new mysqli(DB_HOST,DB_USER,DB_PASSWORD,DB_NAME);

		if(mysqli_connect_error())
		{
			echo "Failed to connect datebase".mysqli_connect_err();
		}

		return $this->con;
	}
}