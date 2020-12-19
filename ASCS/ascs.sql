-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2019 at 12:10 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ascs`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Adm_id` int(20) NOT NULL,
  `Adm_name` varchar(50) NOT NULL,
  `Adm_pass` varchar(20) NOT NULL,
  `Adm_email` varchar(20) NOT NULL,
  `Adm_cont` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Adm_id`, `Adm_name`, `Adm_pass`, `Adm_email`, `Adm_cont`) VALUES
(1, 'Usman Sikander', 'cancer795', 'usman795@gmail.com', '03461547442');

-- --------------------------------------------------------

--
-- Table structure for table `dataoperator`
--

CREATE TABLE `dataoperator` (
  `Do_id` int(20) NOT NULL,
  `Do_name` varchar(50) NOT NULL,
  `Do_email` varchar(20) NOT NULL,
  `Do_pass` varchar(20) NOT NULL,
  `Do_cont` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dataoperator`
--

INSERT INTO `dataoperator` (`Do_id`, `Do_name`, `Do_email`, `Do_pass`, `Do_cont`) VALUES
(1, 'Junaid Mehboob', 'junaid795@gmail.com', 'junaid795', '03007955656');

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `Dept_id` int(20) NOT NULL,
  `Dept_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`Dept_id`, `Dept_name`) VALUES
(1, 'BSIT-7B');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `Nt_id` int(20) NOT NULL,
  `A_name` varchar(20) NOT NULL,
  `Nt_date` date NOT NULL,
  `Nt_body` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`Nt_id`, `A_name`, `Nt_date`, `Nt_body`) VALUES
(103, 'Usman Sikander', '2019-07-09', 'Exams will be held on 2019-08-09'),
(106, 'Usman Sikander', '2019-05-05', 'Hi Students'),
(108, 'Usman Sikander', '2019-12-12', 'Exam are coming');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `R_id` int(20) NOT NULL,
  `S_name` varchar(50) NOT NULL,
  `S_arid` varchar(20) NOT NULL,
  `Class` varchar(20) NOT NULL,
  `Shift` varchar(20) NOT NULL,
  `Cr1` varchar(20) NOT NULL,
  `Cr1_obtmarks` float NOT NULL,
  `Cr2` varchar(20) NOT NULL,
  `Cr2_obtmarks` float NOT NULL,
  `Cr3` varchar(20) NOT NULL,
  `Cr3_obtmarks` float NOT NULL,
  `Cr4` varchar(20) NOT NULL,
  `Cr4_obtmarks` float NOT NULL,
  `Cr5` varchar(20) NOT NULL,
  `Cr5_obtmarks` float NOT NULL,
  `Cr6` varchar(20) NOT NULL,
  `Cr6_obtmarks` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`R_id`, `S_name`, `S_arid`, `Class`, `Shift`, `Cr1`, `Cr1_obtmarks`, `Cr2`, `Cr2_obtmarks`, `Cr3`, `Cr3_obtmarks`, `Cr4`, `Cr4_obtmarks`, `Cr5`, `Cr5_obtmarks`, `Cr6`, `Cr6_obtmarks`) VALUES
(3, 'Usman Sikander', '15-Arid-1286', 'BSIT_7B', 'Morning', 'Java', 20, 'Computer', 30, 'C++', 20, 'SE_2', 30, 'English', 20, 'C Language', 20),
(5, 'Raza', '15-Arid-1258', 'BS', 'Mor', 'Ja', 1, 'ha', 2, 'ha', 3, 'ha', 3, 'hl', 2, 'fg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `r_id` int(10) NOT NULL,
  `r_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`r_id`, `r_name`) VALUES
(1, 'CL-4');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Std_id` int(20) NOT NULL,
  `Std_name` varchar(20) NOT NULL,
  `Std_email` varchar(30) NOT NULL,
  `Std_cont` varchar(20) NOT NULL,
  `Std_pass` varchar(20) NOT NULL,
  `Std_arid` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Std_id`, `Std_name`, `Std_email`, `Std_cont`, `Std_pass`, `Std_arid`) VALUES
(17, 'Raza Sikander', 'Raza@gmail.com', '03007567060', '12345', '15-Arid-1285');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `Sub_id` int(20) NOT NULL,
  `Sub_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`Sub_id`, `Sub_name`) VALUES
(1, 'JAVA');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `T_id` int(11) NOT NULL,
  `T_name` varchar(20) NOT NULL,
  `T_email` varchar(26) NOT NULL,
  `T_cont` varchar(20) NOT NULL,
  `T_pass` varchar(14) NOT NULL,
  `T_Qual` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`T_id`, `T_name`, `T_email`, `T_cont`, `T_pass`, `T_Qual`) VALUES
(1, 'DR.YASIR HAFEEZ', 'yasir.edu@gmail.com', '03461547442', 'asdf32', 'MSCS'),
(2, 'Saif-ur-Rehman', 'Saif@gmail.com', 'asd', 'asd', 'MSSE');

-- --------------------------------------------------------

--
-- Table structure for table `teacherstatus`
--

CREATE TABLE `teacherstatus` (
  `status_id` int(11) NOT NULL,
  `T_id` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacherstatus`
--

INSERT INTO `teacherstatus` (`status_id`, `T_id`, `date`, `status`) VALUES
(1, 2, '1234', ' Available'),
(2, 1, '23/2/2', 'Not Available');

-- --------------------------------------------------------

--
-- Table structure for table `timetable`
--

CREATE TABLE `timetable` (
  `t_id` int(10) NOT NULL,
  `teacher_id` int(10) NOT NULL,
  `r_id` int(10) NOT NULL,
  `t_time` varchar(25) NOT NULL,
  `t_shift` varchar(12) NOT NULL,
  `t_section` varchar(12) NOT NULL,
  `t_day` varchar(12) NOT NULL,
  `t_course` varchar(25) NOT NULL,
  `t_degree` varchar(12) NOT NULL,
  `t_department` varchar(25) NOT NULL,
  `t_semester` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timetable`
--

INSERT INTO `timetable` (`t_id`, `teacher_id`, `r_id`, `t_time`, `t_shift`, `t_section`, `t_day`, `t_course`, `t_degree`, `t_department`, `t_semester`) VALUES
(6, 2, 1, '2019-05-07', 'Morning', 'A', 'Monday', 'CS', 'BS', 'IT', 8),
(7, 1, 1, '2019-05-07', 'Morning', 'A', 'Monday', 'JAVA', 'BS', 'IT', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Adm_id`);

--
-- Indexes for table `dataoperator`
--
ALTER TABLE `dataoperator`
  ADD PRIMARY KEY (`Do_id`);

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`Dept_id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`Nt_id`),
  ADD KEY `A_id` (`A_name`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`R_id`),
  ADD UNIQUE KEY `S_arid` (`S_arid`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`r_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Std_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`Sub_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`T_id`);

--
-- Indexes for table `teacherstatus`
--
ALTER TABLE `teacherstatus`
  ADD PRIMARY KEY (`status_id`),
  ADD KEY `T_id` (`T_id`);

--
-- Indexes for table `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`t_id`),
  ADD UNIQUE KEY `teacher_id_2` (`teacher_id`,`r_id`),
  ADD KEY `teacher_id` (`teacher_id`,`r_id`),
  ADD KEY `teacher_id_3` (`teacher_id`,`r_id`),
  ADD KEY `r_id` (`r_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Adm_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `dataoperator`
--
ALTER TABLE `dataoperator`
  MODIFY `Do_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `Dept_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `Nt_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `R_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `r_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `Std_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `Sub_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `T_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `teacherstatus`
--
ALTER TABLE `teacherstatus`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `timetable`
--
ALTER TABLE `timetable`
  MODIFY `t_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `teacherstatus`
--
ALTER TABLE `teacherstatus`
  ADD CONSTRAINT `teacherstatus_ibfk_1` FOREIGN KEY (`T_id`) REFERENCES `teacher` (`T_id`);

--
-- Constraints for table `timetable`
--
ALTER TABLE `timetable`
  ADD CONSTRAINT `timetable_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`T_id`),
  ADD CONSTRAINT `timetable_ibfk_2` FOREIGN KEY (`r_id`) REFERENCES `room` (`r_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
