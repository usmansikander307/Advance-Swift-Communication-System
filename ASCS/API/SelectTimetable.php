<?php

require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

$response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['t_shift']) && isset($_POST['t_section']) && isset($_POST['t_day']) && isset($_POST['t_degree']) && isset($_POST['t_department']) && isset($_POST['t_semester']))
	{
		$db = new DbOperation();
		$TimetableArr = array();
		$TimetableArr = $db->selectTimetable($_POST['t_shift'], $_POST['t_section'], $_POST['t_day'], $_POST['t_degree'], $_POST['t_department'], $_POST['t_semester']);
		if($TimetableArr)
		{
			$response['TimetableArray'] = $TimetableArr;
			$response['error'] = false;
			$response['message'] = "Found Record";		
		}
		else
		{
			$response['TimetableArray'] = NULL;
			$response['error'] = true;
			$response['message'] = "No Record found.";
		}
	}
	else
	{
		$response['TimetableArray'] = NULL;
		$response['error'] = true;
		$response['message'] = "Parameter are Missing!";
	}
}
else
{
	$response['TimetableArray'] = NULL;
	$response['error'] = true;
	$response['message'] = "Invalid Request Method!";
}
echo json_encode($response);
