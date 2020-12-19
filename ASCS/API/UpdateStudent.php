<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
require_once '../Includes/DbConnect.php';
$db = new DbConnect();
	$con = $db->connect();
	 $S_name = $_POST['StudentName'];
 $S_Email = $_POST['StudentEmail'];
 $S_Cont = $_POST['StudentContact'];
  $S_Pass = $_POST['StudentPassword'];
   $S_Arid = $_POST['StudentArid'];

    $id = $_POST['StudentID'];
   $Sql_Query = "UPDATE student SET Std_name= '$S_name', Std_email = '$S_Email', Std_cont = '$S_Cont',Std_pass='$S_Pass',Std_arid='$S_Arid' WHERE Std_id = $id";

 if(mysqli_query($con,$Sql_Query))
{
	 $response["message"] = "Updated";
  echo json_encode($response);
    } else {
       $response["message"] = "Failed";
    // echo no users JSON
    echo json_encode($response);
    }
}
else {
    echo "Student id missing";
}
?>