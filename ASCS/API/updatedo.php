<?php
 require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();

if ($_SERVER['REQUEST_METHOD']=='POST') {
    $pid = $_POST['sid'];
    $name = $_POST['sname'];
    $email = $_POST['semail'];
	$pass = $_POST['spass'];
    $cont = $_POST['scont'];
	
 
  
 
 $db = new DbConnect();
	$con = $db->connect();
    //escpae the strings to be inserted to DB
    $escapedname = mysqli_real_escape_string($con, $name);
    $escapedemail = mysqli_real_escape_string($con, $email);
	$escapedpass = mysqli_real_escape_string($con, $pass);
    $escapedcont = mysqli_real_escape_string($con, $cont);
	 
  
 
    // mysql update row with matched pid
    $sql = "UPDATE dataoperator SET Do_name = '$escapedname', Do_email = '$escapedemail', Do_pass = '$escapedpass', Do_cont = '$escapedcont' WHERE Do_id = $pid";
 
    // check if row inserted or not
    if (mysqli_query($con, $sql)) {
   $response["message"] = "Updated";
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