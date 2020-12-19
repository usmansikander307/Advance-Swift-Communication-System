<?php

class DbOperation
{
	private $con;
	private $id, $name, $email, $password;

	function __construct()
	{
		require_once '../Includes/DbConnect.php';
		$db = new DbConnect();
		$this->con = $db->connect();
	}
public function selectTeacher()
	{
		$stmt = $this->con->prepare("SELECT * FROM teacher");
		//$stmt->bind_param("s", $email);
		if ($stmt->execute()) {
		    $result = $stmt->get_result();
		    $TeacherArr = array();
		    while ($Teacher = $result->fetch_assoc()){
		        $TeacherArr[] = $Teacher;
		    }
		    $stmt->close();
		    //print_r($TeacherArr);
		    return $TeacherArr;
		} else {
		    return NULL;
		}
	}
	public function selectStatus($f_name)
	{
		$stmt = $this->con->prepare("SELECT teacherstatus.status FROM teacher,teacherstatus where teacherstatus.T_id=teacher.T_id AND T_name=?");
		$stmt->bind_param("s", $f_name);
		if ($stmt->execute()) {
		    $result = $stmt->get_result();
		    $status = $result->fetch_assoc();
		    $stmt->close();
		    //print_r(current($status));
		    if($status)
		    	return current($status);
		    else
		    	return NULL;

		} else {
		    return NULL;
		}
	}

	public function createStudent($name,$email,$password,$rollno)
	{
		if($this->isEmailExists($email))
		{
			return 0;
		}
		else
		{
			$pass = md5($password);
			$stmt = $this->con->prepare("INSERT INTO `student` (`std_id`,`std_name`,`std_email`,`std_password`,`std_rollNo`) VALUES (NULL,?,?,?,?)");	
			$stmt->bind_param("ssss",$name, $email, $pass, $rollno);	
			if($stmt->execute())
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
	}

	public function studentLogin($email, $pass)
	{
		//$password = md5($pass);
		$stmt = $this->con->prepare("SELECT * FROM student WHERE Std_email = ? AND Std_pass = ?");
		$stmt->bind_param("ss", $email,$pass);
		$stmt->execute();
		$stmt->store_result();

		return $stmt->num_rows > 0;
	}
	
	public function studentDelete($id)
	{
		//$password = md5($pass);
		$stmt = $this->con->prepare("DELETE FROM student WHERE Std_id=?");
		$stmt->bind_param("s", $id);
		$stmt->execute();
		$stmt->store_result();

		return $stmt->num_rows > 0;
	}
	
	public function adminLogin($email, $pass)
	{
		//$password = md5($pass);
		$stmt = $this->con->prepare("SELECT * FROM admin WHERE Adm_email = ? AND Adm_pass = ?");
		$stmt->bind_param("ss", $email,$pass);
		$stmt->execute();
		$stmt->store_result();

		return $stmt->num_rows > 0;
	}
	public function doLogin($email, $pass)
	{
		//$password = md5($pass);
		$stmt = $this->con->prepare("SELECT * FROM dataoperator WHERE Do_email = ? AND Do_pass = ?");
		$stmt->bind_param("ss", $email,$pass);
		$stmt->execute();
		$stmt->store_result();

		return $stmt->num_rows > 0;
	}
		public function GetAdmin()
	{
		//$password = md5($pass);
		$stmt = $this->con->prepare("SELECT Adm_id,Adm_name FROM admin");
		//$stmt->bind_param("ss", $email,$pass);
		$stmt->execute();
	$result=$stmt->get_result();
		$AdminArr = array();
		    while ($Admin = $result->fetch_assoc()){
		        $AdminArr[] = $Admin;
		    }
		    $stmt->close();
		    //print_r($TeacherArr);
		    return $AdminArr;

		//return $stmt->num_rows > 0;
	}
	
	
	public function GetStudent()
	{
	
		$stmt = $this->con->prepare("SELECT * FROM student");
		$stmt->execute();
	$result=$stmt->get_result();
		$StudentArr = array();
		    while ($Student = $result->fetch_assoc()){
		        $StudentArr[] = $Student;
		    }
		    $stmt->close();
		  
		    return $StudentArr;

	
	}
	
	public function teacherLogin($email, $password)
	{
		//$password = md5($pass);
		$stmt = $this->con->prepare("SELECT teacherstatus.status,teacher.T_name,teacher.T_id FROM teacher,teacherstatus WHERE (T_email = ? AND T_pass = ?) AND teacherstatus.T_id=teacher.T_id");
		$stmt->bind_param("ss", $email,$password);
		$stmt->execute();
		$result=$stmt->get_result();
		$TeacherArr = array();
		    while ($Teacher = $result->fetch_assoc()){
		        $TeacherArr[] = $Teacher;
		    }
		    $stmt->close();
		    //print_r($TeacherArr);
		    return $TeacherArr;

		//return $stmt->num_rows > 0;
	}
	public function updateStatus($status, $name)
	{
		//$password = md5($pass);
		$stmt = $this->con->prepare("Update teacherstatus,teacher SET teacherstatus.status=? WHERE teacherstatus.T_id=teacher.T_id AND teacher.T_name=?");
		$stmt->bind_param("ss", $status,$name);
		$stmt->execute();
		$result=$stmt->Store_result();
		return $result;
	}

		public function selectTimetable($shift, $section, $day, $degree, $department, $semester)
	{
		$stmt = $this->con->prepare("SELECT teacher_name, r_name,t_time,t_course,t_date FROM schedule  
			WHERE t_shift = ? AND t_section = ? AND t_day = ? AND t_degree = ? AND t_department = ? AND t_semester = ?");
		$stmt->bind_param("sssssi", $shift, $section, $day, $degree, $department, $semester);
		if ($stmt->execute()) {
		    $result = $stmt->get_result();
		    $TimetableArr = array();
		    while ($Timetable = $result->fetch_assoc()){
		        $TimetableArr[] = $Timetable;
		    }
		    $stmt->close();
		    //print_r($TeacherArr);
		    return $TimetableArr;
		} else {
		    return NULL;
		}
	}
	
	public function takeAttendance($dept, $sub, $student, $date, $status){
		$stmt = $this->con->prepare("INSERT INTO `attendance` (`Atnd_id`, `Dept_id`, `Sub_id`, `Std_id`, `Date`, `Status`) VALUES (NULL,?,?,?,?,?)");
		$stmt->bind_param("sssss", $dept, $sub, $student, $date, $status);
		$stmt->execute();
		$result=$stmt->Store_result();
		return $result;
	}
	
	public function insertresult($name,$arid, $class, $shift, $cr1,$crobt, $cr2,$cr2obt, $cr3,$cr3obt, $cr4,$cr4obt, $cr5,$cr5obt, $cr6,$cr6obt){
		
		
		$stmt = $this->con->prepare("INSERT INTO `result` (`R_id`, `S_name`,`S_arid`,`Class`, `Shift`, `Cr1`,`Cr1_obtmarks`, `Cr2`, `Cr2_obtmarks`, `Cr3`, `Cr3_obtmarks`,`Cr4`,`Cr4_obtmarks`, `Cr5`, `Cr5_obtmarks`, `Cr6`, `Cr6_obtmarks`) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		$stmt->bind_param("ssssssssssssssss",$name,$arid, $class, $shift, $cr1,$crobt, $cr2,$cr2obt, $cr3,$cr3obt, $cr4,$cr4obt, $cr5,$cr5obt, $cr6,$cr6obt);
		$stmt->execute();
		$result=$stmt->Store_result();
		return $result;
	}
		public function inserttimetable($tname,$rname,$time,$shift,$sec,$day,$cours,$deg,$dep,$sem,$date){
		
		
		$stmt = $this->con->prepare("INSERT INTO `schedule` (`t_id`, `teacher_name`,`r_name`,`t_time`, `t_shift`, `t_section`,`t_day`, `t_course`, `t_degree`, `t_department`, `t_semester`,`t_date`) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)");
		$stmt->bind_param("sssssssssis",$tname,$rname, $time, $shift, $sec,$day, $cours,$deg, $dep,$sem, $date);
		$stmt->execute();
		$result=$stmt->Store_result();
		return $result;
	}
	
	public function givefeedback($ans1,$ans2,$ans3,$ans4,$ans5,$ans6){
		
		
		$stmt = $this->con->prepare("INSERT INTO `feedback` (`f_id`, `Q1_ans`,`Q2_ans`,`Q3_ans`, `Q4_ans`,`Q5_ans`, `Q6_ans`) VALUES (NULL,?,?,?,?,?,?)");
		$stmt->bind_param("ssssss",$ans1,$ans2, $ans3, $ans4, $ans5,$ans6);
		$stmt->execute();
		$result=$stmt->Store_result();
		return $result;
	}
	public function insertNotification($name, $date, $body){
	
		$stmt = $this->con->prepare("INSERT INTO `notification` (`Nt_id`, `A_name`, `Nt_date`, `Nt_body`) VALUES (NULL,?,?,?)");
		$stmt->bind_param("sss", $name, $date, $body);
		$stmt->execute();
		$result=$stmt->Store_result();
		return $result;
	}
	public function ViewNotification(){
	
		$stmt = $this->con->prepare("SELECT * FROM notification");
			$stmt->execute();
	$result=$stmt->get_result();
		$NotificationArr = array();
		    while ($Notification = $result->fetch_assoc()){
		        $NotificationArr[] = $Notification;
		    }
		    $stmt->close();
		  
		    return $NotificationArr;
	}

	public function getStudentByEmail($email)
	{
		$stmt = $this->con->prepare("SELECT std_id,std_name,std_email,std_password FROM student WHERE std_email = ?");
		$stmt->bind_param("s", $email);
		if ($stmt->execute()) {
		    $result = $stmt->get_result();
		    $usersArr = array();
		    while ($user = $result->fetch_assoc()){
		        $usersArr[] = $user;
		    }
		    $stmt->close();

		    //print_r($usersArr);
		    return $usersArr;
		} else {
		    return NULL;
		}

		
	}

	private function isEmailExists($email)
	{
		$stmt = $this->con->prepare("SELECT std_email FROM student WHERE std_email = ?");
		$stmt->bind_param("s",$email);
		$stmt->execute();
		$stmt->store_result();

		return $stmt->num_rows > 0;
		//$stmt->close();
	}
	

}
?>