<?php

require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

$response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['email']) && isset($_POST['password']))
	{
		$db = new DbOperation();
$funcResponse=$db->teacherLogin($_POST['email'],$_POST['password']);
		if($funcResponse)
		{
			$response['error'] = false;
			$response['message'] = "login Successful";
			$response['data'] = $funcResponse;
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
