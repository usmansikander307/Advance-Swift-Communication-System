<?php
 require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();



$q1 = $_POST['q1'];
$q2= $_POST['q2'];
$q3 = $_POST['q3'];
$q4= $_POST['q4'];
$q5= $_POST['q5'];
$q6 = $_POST['q6'];
$date = $_POST['date'];
$arid = $_POST['arid'];
$clas = $_POST['clas'];




$response = array();
$query = mysqli_query($con, "INSERT INTO feedback (Q1_ans, Q2_ans, Q3_ans ,Q4_ans, Q5_ans, Q6_ans,Date,aridnum,class) VALUES ('$q1','$q2','$q3','$q4','$q5','$q6','$date','$arid','$clas')");

if($query){
  $response['error'] = 'false';
  $response['message'] = 'Data Inserted Successfully';
}else{
  $response['error'] = 'true';
  $response['message'] = 'Data Insertion Failed';
}

echo json_encode($response);
?>
