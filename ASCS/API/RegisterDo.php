<?php
 require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();


$name = $_POST['Do_name'];
$email = $_POST['Do_email'];
$pass= $_POST['Do_pass'];
$cont = $_POST['Do_cont'];



$response = array();
$query = mysqli_query($con, "INSERT INTO dataoperator (Do_name, Do_email, Do_pass, Do_cont) VALUES ('$name','$email','$pass','$cont')");

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Data Inserted Successfully';
}else{
  $response['success'] = 'false';
  $response['message'] = 'Data Insertion Failed';
}

echo json_encode($response);
?>
