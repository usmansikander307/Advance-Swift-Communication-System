<?php
 require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();

if ($_SERVER['REQUEST_METHOD']=='POST') {
    $pid = $_POST['sid'];
    $name = $_POST['sname'];
    $email = $_POST['semail'];
    $cont = $_POST['scont'];
	$pass = $_POST['spass'];
	$arid = $_POST['squal'];
 
  
 
 $db = new DbConnect();
	$con = $db->connect();
    //escpae the strings to be inserted to DB
    $escapedname = mysqli_real_escape_string($con, $name);
    $escapedemail = mysqli_real_escape_string($con, $email);
    $escapedcont = mysqli_real_escape_string($con, $cont);
	 $escapedpass = mysqli_real_escape_string($con, $pass);
    $escapedarid = mysqli_real_escape_string($con, $arid);
 
    // mysql update row with matched pid
    $sql = "UPDATE teacher SET T_name = '$escapedname', T_email = '$escapedemail', T_cont = '$escapedcont', T_pass = '$escapedpass', T_Qual = '$escapedarid' WHERE T_id = $pid";
 
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