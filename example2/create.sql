CREATE TABLE classes(
class_id int(10) NOT NULL,
name varchar(20) NOT NULL,
PRIMARY KEY(class_id)
);
CREATE TABLE students (
student_id int(10) NOT NULL,
name varchar(20) NOT NULL,
last_name varchar(20) NOT NULL,
class_id int(10) NOT NULL,
average_grade DECIMAL(10, 3),
PRIMARY KEY(student_id),
FOREIGN KEY(class_id) REFERENCES classes (class_id)
);
INSERT INTO classes VALUES(1, "1A");
INSERT INTO classes VALUES(2, "1B");
INSERT INTO classes VALUES(3, "1C");
INSERT INTO classes VALUES(4, "2A");
INSERT INTO classes VALUES(5, "2B");
INSERT INTO classes VALUES(6, "2C");
INSERT INTO students VALUES(1, "Alex", "Str", 1, 7.333);
INSERT INTO students VALUES(2, "Yan", "Qwe", 1, 7.333);
INSERT INTO students VALUES(3, "Boris", "Asd", 1, 7.333);
INSERT INTO students VALUES(4, "Nikita", "Rty", 2, 7.333);
INSERT INTO students VALUES(5, "Yulia", "Nbu", 2, 7.333);
INSERT INTO students VALUES(6, "Katya", "Dre", 2, 7.333);
INSERT INTO students VALUES(7, "Olga", "Tru", 3, 7.333);
INSERT INTO students VALUES(8, "Ivan", "Str", 3, 7.333);
INSERT INTO students VALUES(9, "Petr", "Cot", 3, 7.333);
INSERT INTO students VALUES(10, "Oleg", "Svet", 4, 7.333);
INSERT INTO students VALUES(11, "Masha", "Netet", 4, 7.333);
INSERT INTO students VALUES(12, "Tanya", "Tur", 4, 7.333);
INSERT INTO students VALUES(13, "Kirill", "Ivanov", 5, 7.333);
INSERT INTO students VALUES(14, "Alex", "Lenta", 1, 7.333);
INSERT INTO students VALUES(15, "Alex", "Nuu", 1, 7.333);

