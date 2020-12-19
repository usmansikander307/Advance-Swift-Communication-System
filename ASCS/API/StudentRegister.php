<?php
 require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();


$name = $_POST['Std_name'];
$email = $_POST['Std_email'];
$cont = $_POST['Std_cont'];
$pass= $_POST['Std_pass'];
$arid= $_POST['Std_arid'];

$response = array();
$query = mysqli_query($con, "INSERT INTO student (Std_name, Std_email, Std_cont, Std_pass, Std_arid) VALUES ('$name','$email','$cont','$pass','$arid')");

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Data Inserted Successfully';
}else{
  $response['success'] = 'false';
  $response['message'] = 'Data Insertion Failed';
}

echo json_encode($response);
?>
