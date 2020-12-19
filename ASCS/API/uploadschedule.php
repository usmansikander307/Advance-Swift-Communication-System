<?php
require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

     $response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['tname']) && isset($_POST['rname']) && isset($_POST['time']) && isset($_POST['shift']) && isset($_POST['sec']) && isset ($_POST['day']) && isset($_POST['crs']) && isset($_POST['deg']) && isset($_POST['dep']) && isset($_POST['sem']) && isset($_POST['timer']))
	{
		$db = new DbOperation();

		if($db->inserttimetable($_POST['tname'],$_POST['rname'],$_POST['time'],$_POST['shift'],$_POST['sec'],$_POST['day'],$_POST['crs'],$_POST['deg'],$_POST['dep'],$_POST['sem'],$_POST['timer']))
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
