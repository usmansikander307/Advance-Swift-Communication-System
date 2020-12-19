<?php
require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

     $response = array();
	$db = new DbConnect();
	$con = $db->connect();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['name']) && isset($_POST['arid']) && isset($_POST['class']) && isset($_POST['shift']) && isset($_POST['c1']) && isset ($_POST['c1num']) && isset($_POST['c2']) && isset($_POST['c2num']) && isset($_POST['c3']) && isset($_POST['c3num']) && isset($_POST['c4']) && isset($_POST['c4num']) && isset($_POST['c5']) && isset($_POST['c5num']) && isset($_POST['c6']) && isset($_POST['c6num']))
	{
		$db = new DbOperation();

		if($db->insertresult($_POST['name'],$_POST['arid'],$_POST['class'],$_POST['shift'],$_POST['c1'],$_POST['c1num'],$_POST['c2'],$_POST['c2num'],$_POST['c3'],$_POST['c3num'],$_POST['c4'],$_POST['c4num'],$_POST['c5'],$_POST['c5num'],$_POST['c6'],$_POST['c6num']))
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
