 <?php

if($_SERVER['REQUEST_METHOD']=='POST'){
require_once '../Includes/DbConnect.php';
$db = new DbConnect();
	$con = $db->connect();
	 $StudentID= $_POST['StudentID'];
	$sql = "SELECT * FROM student where Std_id = '$StudentID'" ;

$result = $con->query($sql);

if ($result->num_rows >0) {
 
 
 while($row[] = $result->fetch_assoc()) {
 
 $tem = $row;
 
 $json = json_encode($tem);
 
 }
 
} else {
 echo "No Results Found.";
}
 echo $json;

$con->close();
}
?>