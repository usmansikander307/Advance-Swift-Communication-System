<?php
 
$response = array();
header('Content-Type: application/json');
 
require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();
 
// check for post data
if (isset($_POST['pid'])) {
    $pid = $_POST['pid'];
 
    // get a product from products table
    $sql = "SELECT * FROM student WHERE Std_id = '$pid' ";
    $result = $con->query($sql);
 
    if (!empty($result)) {
        // check for empty result
        if ($result->num_rows > 0) {
 
            $result = $result->fetch_assoc();
 
            $student = array();
            $student["pid"] = $result["Std_id"];
            $student["name"] = $result["Std_name"];
            $student["email"] = $result["Std_email"];
            $student["cont"] = $result["Std_cont"];
            $student["pass"] = $result["Std_pass"];
            $student["arid"] = $result["Std_arid"];
            // success
            $response["success"] = 1;
 
            // user node
            $response["student"] = array();
 
            array_push($response["student"], $student);
 
            // echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No student found";
 
            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No student found";
 
        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>