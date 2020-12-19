<?php

require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

	$response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{

	if(isset($_POST['f_name']))
	{
		$db = new DbOperation();
		$status = $db->selectStatus($_POST['f_name']);
		if($status)
		{
			
			$response['status'] = $status;
			$response['error'] = false;
			$response['message'] = "Found Record";		
		}
		else
		{
			$response['status'] = NULL;
			$response['error'] = true;
			$response['message'] = "No Record found.";
		}
	}
	else
	{
		$response['status'] = NULL;
		$response['error'] = true;
		$response['message'] = "Parameter are Missing!";
	}
}
else
{
	$response['status'] = NULL;
	$response['error'] = true;
	$response['message'] = "Invalid Request Method!";
}
echo json_encode($response);
