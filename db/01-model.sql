BEGIN TRANSACTION;

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (
    pk bigserial NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    birthdate date NOT NULL,
    UNIQUE (email),
    PRIMARY KEY (pk)
);


DROP TABLE IF EXISTS teachers CASCADE;
CREATE TABLE teachers (
    pk bigserial NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    birthdate date NOT NULL,
    UNIQUE (email),
    PRIMARY KEY (pk)
);


DROP TABLE IF EXISTS courses CASCADE;
CREATE TABLE courses (
    pk bigserial NOT NULL,
    teacher_fk bigint NOT NULL,
    code varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    FOREIGN KEY (teacher_fk) REFERENCES teachers(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (code),
    PRIMARY KEY (pk)
);



DROP TABLE IF EXISTS exams CASCADE;
CREATE TABLE exams (
    pk bigserial NOT NULL,
    exam_date date NOT NULL DEFAULT NOW(),
    name varchar(255) NOT NULL,
    course_fk bigint NOT NULL,
    FOREIGN KEY (course_fk) REFERENCES courses(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (name, course_fk),
    PRIMARY KEY (pk)
);


DROP TABLE IF EXISTS evaluations CASCADE;
CREATE TABLE evaluations (
    pk bigserial NOT NULL,
    exam_fk bigint NOT NULL,
    student_fk bigint NOT NULL,
    score numeric(2,1),
    FOREIGN KEY (exam_fk) REFERENCES exams(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (student_fk) REFERENCES students(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (exam_fk, student_fk),
    CHECK (score >= 1),
    CHECK (score <= 7),
    PRIMARY KEY (pk)
);

COMMIT;
