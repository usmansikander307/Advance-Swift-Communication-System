<?php
require_once '../Operation/DbOperation.php';
require_once '../Includes/DbConnect.php';
$db = new DbConnect();
	$con = $db->connect();
$query = mysqli_query($con, "SELECT * FROM student");
$data = array();
$qry_array = array();
$i = 0;
$total = mysqli_num_rows($query);
while ($row = mysqli_fetch_array($query)) {
  $data['Std_id'] = $row['Std_id'];
  $data['Std_name'] = $row['Std_name'];
  $data['Std_email'] = $row['Std_email'];
  $data['Std_cont'] = $row['Std_cont'];
  $data['Std_pass'] = $row['Std_pass'];
  $data['Std_arid'] = $row['Std_arid'];
  $qry_array[$i] = $data;
  $i++;
}

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Data Loaded Successfully';
  $response['total'] = $total;
  $response['data'] = $qry_array;
}else{
  $response['success'] = 'false';
  $response['message'] = 'Data Loading Failed';
}

echo json_encode($response);
?>
