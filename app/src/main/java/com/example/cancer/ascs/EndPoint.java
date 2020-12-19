package com.example.cancer.ascs;

public class EndPoint {
    public static final String ROOT_URL = "http://192.168.10.17:80/ASCS/API/";
    public static final String URL_ADD= ROOT_URL + "StudentRegister.php";
    public static final String URL_SHOW= ROOT_URL + "AllStudentData.php";
    public static final String URL_UPDATE= ROOT_URL + "update.php";
    public static final String URL_SINGLE= ROOT_URL + "select_id.php";
    public static final String URL_DELETE= ROOT_URL + "DeleteStudent.php";

    public static final String URL_ADDTEACHER= ROOT_URL + "RegisterTeacher.php";
    public static final String URL_SHOWTEACHER= ROOT_URL + "AllTeacherData.php";
    public static final String URL_UPDATETEACHER= ROOT_URL + "updateteacher.php";
    public static final String URL_SINGLETEACHER= ROOT_URL + "Teacherbyid.php";
    public static final String URL_DELETETEACHER= ROOT_URL + "DeleteTeacher.php";

    public static final String URL_ADDDO= ROOT_URL + "RegisterDo.php";
    public static final String URL_SHOWDO= ROOT_URL + "AllDataoperator.php";
    public static final String URL_UPDATEDO= ROOT_URL + "updatedo.php";
    public static final String URL_SINGLEDO= ROOT_URL + "DObyid.php";
    public static final String URL_DELETEDO= ROOT_URL + "DeleteDo.php";

    public static final String STUDENT_LOGIN = ROOT_URL + "Student_Login.php";
    public static final String TEACHER_LOGIN = ROOT_URL + "Teacher_Login.php";
    public static final String ADMIN_LOGIN = ROOT_URL + "Admin_Login.php";
    public static final String DO_LOGIN = ROOT_URL + "DO_Login.php";
    public static final String TEACHERS_NAME = ROOT_URL + "SelectTeacher.php";
    public static final String SHOW_STATUS = ROOT_URL + "SelectTeacherStatus.php";
    public static final String SHOW_TIMETABLE = ROOT_URL + "SelectTimetable.php";
    public static final String UPDATE_STATUS = ROOT_URL + "updatestatus.php";
    public static final String TAKE_ATTENDANCE= ROOT_URL + "Attandance.php";
    public static final String Insert_Notification= ROOT_URL + "InsertNotification.php";
    public static final String SelectAdmin= ROOT_URL + "SelectAdmin.php";
    public static final String InsertResult= ROOT_URL + "resultupload.php";
    public static final String SelectStudent= ROOT_URL + "SelectStudent.php";
    public static final String viewresult= ROOT_URL + "viewresult.php";
    public static final String SHOW_NOTIFICATION= ROOT_URL + "ViewNotification.php";
    public static final String Room= ROOT_URL + "selectroom.php";
    public static final String Subject= ROOT_URL + "selectsubjects.php";
    public static final String insertSchedule= ROOT_URL + "uploadschedule.php";
    public static final String Feedback= ROOT_URL + "givefeedback.php";
    public static final String FeedbackView= ROOT_URL + "managefeedback.php";
}
