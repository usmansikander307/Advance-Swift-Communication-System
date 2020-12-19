<?php
require_once '../Includes/DbConnect.php';
  $db = new DbConnect();
	$con = $db->connect();
 
function getProducts(){
	$db = new DbConnect();
	$con = $db->connect();
 
    
    // array for json response
    $response = array();
    $response["students"] = array();
   
     
    // Mysql select query
    $result = mysqli_query($con, "SELECT * FROM admin");
     
    if(!empty($result)){
        while($row = mysqli_fetch_array($result)){
        // temporary array to create single category
        $tmp = array();
        $tmp["id"] = $row["Adm_id"];
        $tmp["name"] = $row["Adm_name"];
        $tmp["email"] = $row["Adm_pass"];
        $tmp["cont"] = $row["Adm_email"];
		$tmp["arid"] = $row["Adm_cont"];
	
        $response["success"] = 1;
        // push category to final json array
        array_push($response["students"], $tmp);
        }
         
        // keeping response header to json
        header('Content-Type: application/json');
         
        // echoing json result
        echo json_encode($response);
    }
    else{
      // no product found
    $response["success"] = 0;
    $response["message"] = "No student found";
    // echo no users JSON
    echo json_encode($response);
    }
}
 
getProducts();
?>