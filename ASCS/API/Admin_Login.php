<?php

require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

$response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['email']) && isset($_POST['pass']))
	{
		$db = new DbOperation();

		if($db->adminLogin($_POST['email'],$_POST['pass']))
		{
			$response['error'] = false;
			$response['message'] = "Login Successful";
		}
		else
		{
			$response['error'] = true;
			$response['message'] = "Wrong Email, Password.";
		}
	}
	else
	{
		$response['error'] = true;
		$response['message'] = "Parameter are Missing!";
	}
}
else
{
	$response['error'] = true;
	$response['message'] = "Invalid Request Method!";
}
echo json_encode($response);
