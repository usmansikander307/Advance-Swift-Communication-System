<?php
require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();
 
function getProducts(){
	$db = new DbConnect();
	$con = $db->connect();
 
    
    // array for json response
    $response = array();
    $response["feedbacks"] = array();
   
     
    // Mysql select query
    $result = mysqli_query($con, "SELECT * FROM feedback");
     
    if(!empty($result)){
        while($row = mysqli_fetch_array($result)){
        // temporary array to create single category
        $tmp = array();
        $tmp["id"] = $row["f_id"];
        $tmp["q1"] = $row["Q1_ans"];
        $tmp["q2"] = $row["Q2_ans"];
        $tmp["q3"] = $row["Q3_ans"];
		$tmp["q4"] = $row["Q4_ans"];
		$tmp["q5"] = $row["Q5_ans"];
		$tmp["q6"] = $row["Q6_ans"];
		$tmp["date"] = $row["Date"];
		$tmp["arid"] = $row["aridnum"];
		$tmp["clas"] = $row["class"];
        $response["success"] = 1;
        // push category to final json array
        array_push($response["feedbacks"], $tmp);
        }
         
        // keeping response header to json
        header('Content-Type: application/json');
         
        // echoing json result
        echo json_encode($response);
    }
    else{
      // no product found
    $response["success"] = 0;
    $response["message"] = "No Record found";
    // echo no users JSON
    echo json_encode($response);
    }
}
 
getProducts();
?>