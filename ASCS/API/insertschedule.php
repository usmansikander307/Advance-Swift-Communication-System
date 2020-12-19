<?php
require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

     $response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['tid']) && isset($_POST['rid']) && isset($_POST['date']) && isset($_POST['shift']) && isset($_POST['sec']) && isset ($_POST['day']) && isset($_POST['cour']) && isset($_POST['deg']) && isset($_POST['dep']) && isset($_POST['sem']))
	{
		$db = new DbOperation();

		if($db->Schedule($_POST['tid'],$_POST['rid'],$_POST['date'],$_POST['shift'],$_POST['sec'],$_POST['day'],$_POST['cour'],$_POST['deg'],$_POST['dep'],$_POST['sem']))
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
