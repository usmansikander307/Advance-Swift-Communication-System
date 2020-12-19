<?php
 
$response = array();
header('Content-Type: application/json');
 
require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();
 
// check for post data
if (isset($_POST['arid'])&& isset ($_POST['class']) ){
    $arid = $_POST['arid'];
	$class= $_POST['class'];
 
    // get a product from products table
    $sql = "SELECT * FROM result WHERE S_arid = '$arid' AND Class='$class' ";
    $result = $con->query($sql);
 
    if (!empty($result)) {
        // check for empty result
        if ($result->num_rows > 0) {
 
            $result = $result->fetch_assoc();
 
            $student = array();
            $student["Rid"] = $result["R_id"];
            $student["name"] = $result["S_name"];
            $student["class"] = $result["Class"];
            $student["shift"] = $result["Shift"];
            $student["sub1"] = $result["Cr1"];
            $student["sub1obt"] = $result["Cr1_obtmarks"];
			$student["sub2"] = $result["Cr2"];
            $student["sub2obt"] = $result["Cr2_obtmarks"];
			$student["sub3"] = $result["Cr3"];
            $student["sub3obt"] = $result["Cr3_obtmarks"];
			$student["sub4"] = $result["Cr4"];
            $student["sub4obt"] = $result["Cr4_obtmarks"];
			$student["sub5"] = $result["Cr5"];
            $student["sub5obt"] = $result["Cr5_obtmarks"];
			$student["sub6"] = $result["Cr6"];
            $student["sub6obt"] = $result["Cr6_obtmarks"];
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
            $response["message"] = "No Record found";
 
            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No Record found";
 
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