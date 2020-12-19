<?php
 require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();


$name = $_POST['T_name'];
$email = $_POST['T_email'];
$cont = $_POST['T_cont'];
$pass= $_POST['T_pass'];
$arid= $_POST['T_Qual'];

$response = array();
$query = mysqli_query($con, "INSERT INTO teacher (T_name, T_email, T_cont, T_pass, T_Qual) VALUES ('$name','$email','$cont','$pass','$arid')");

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Data Inserted Successfully';
}else{
  $response['success'] = 'false';
  $response['message'] = 'Data Insertion Failed';
}

echo json_encode($response);
?>
