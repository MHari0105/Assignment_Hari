CREATE DATABASE UniversityExam;
USE UniversityExam;

CREATE TABLE course (
	course_id INT PRIMARY KEY, 
    name VARCHAR(30),
    dept VARCHAR(5),
    c_num INT
);

CREATE TABLE section (
    section_id INT PRIMARY KEY,
    s_number INT,
    enrollment INT,
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

CREATE TABLE room (
    room_number INT PRIMARY KEY,
    capacity INT,
    building VARCHAR(20)
);

CREATE TABLE exam (
    exam_id INT PRIMARY KEY,
    time DATETIME,
    room_number INT,
    course_id INT,
    FOREIGN KEY (room_number) REFERENCES room(room_number),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

-- weak entity
CREATE TABLE dependent (
    dependent_id INT PRIMARY KEY,
    dependent_attribute VARCHAR(255),
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);
