<?php

require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

$response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'GET')
{
	$db = new DbOperation();
	$TArr = array();
	$TArr = $db->selectTeacher();
	if($TArr)
	{
		$response['TeacherArray'] = $TArr;
		$response['error'] = false;
		$response['message'] = "Found Record";		
	}
	else
	{
		$response['TeacherArray'] = NULL;
		$response['error'] = true;
		$response['message'] = "No Record found.";
	}
	
}
else
{
	$response['userArray'] = NULL;
	$response['error'] = true;
	$response['message'] = "Invalid Request Method!";
}
echo json_encode($response);
