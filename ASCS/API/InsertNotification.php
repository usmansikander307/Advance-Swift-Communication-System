<?php
require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

$response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['name']) && isset($_POST['date']) && isset($_POST['body']))
	{
		$db = new DbOperation();

		if($db->insertNotification($_POST['name'],$_POST['date'],$_POST['body']))
		{
			$response['error'] = false;
			$response['message'] = "success";
		}
		else
		{
			$response['error'] = true;
			$response['message'] = "failure.";
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
