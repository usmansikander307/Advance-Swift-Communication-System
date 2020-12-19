<?php
 
 
if ($_SERVER['REQUEST_METHOD']=='POST') {
    $pid = $_POST['pid'];
 require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();

 
    // mysql update row with matched pid
    $sql = "DELETE FROM dataoperator WHERE Do_id = $pid";
 
    // check if row inserted or not
    if (mysqli_query($con, $sql)) {
       $response["message"] = "Deleted";
    // echo no users JSON
    echo json_encode($response);
    } else {
       $response["message"] = "Failed";
    // echo no users JSON
    echo json_encode($response);
    }
}
else {
    echo "Teacher id missing";
}
?>