<?php

require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

$response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['status']) && isset($_POST['name']))
	{
		$db = new DbOperation();
		$data=$db->updateStatus($_POST['status'],$_POST['name']);
		if($data)
		{
			$response['status']=$data;
			$response['error'] = false;
			$response['message'] = "Update Successfully";
			
		}
		else
		{
			$response['status']=$data;
			$response['error'] = true;
			$response['message'] = "Not Valid Credential";
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
