<?php

require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';

$db = new DbConnect();
$con = $db->connect();
$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST')
{
	if(isset($_POST['name']) && isset($_POST['email']) && isset($_POST['password']) && isset($_POST['rollno']))
	{
		$db = new DbOperation();

		$name = $_POST['name'];
		$email = $_POST['email'];
		$password = $_POST['password'];
		$rollno = $_POST['rollno'];

		$result = $db->createStudent($name,$email,$password,$rollno);

		if($result == 1)
		{
			$response['error'] = false;
			$response['message'] = "Registration Successful";
		}
		else if($result == 2)
		{
			$response['error'] = true;
			$response['message'] = "Registration Not Successful";
		}
		else if($result == 0)
		{
			$response['error'] = false;
			$response['message'] = "Email Already Exists";
		}
	}
}
else
	{
		$response['error'] = true;
		$response['message'] = "Invalid Request Method";
		
	}
	echo json_encode($response);