CREATE TABLE lesson
(
    id          UUID NOT NULL,
    group_id    UUID,
    lesson_time TIME,
    subject_id  UUID,
    teacher_id  UUID,
    primary key (ID)
);

CREATE TABLE student
(
    id                UUID         NOT NULL,
    dismissed         BOOL DEFAULT FALSE,
    leader            BOOL DEFAULT FALSE,
    enrollment_date   TIMESTAMP(6) WITH TIME ZONE,
    first_name        VARCHAR(255) NOT NULL,
    gender_type       VARCHAR(10)  NOT NULL,
    group_id          UUID,
    last_name         VARCHAR(255) NOT NULL,
    middle_name       VARCHAR(255) NOT NULL,
    modification_date TIMESTAMP(6) WITH TIME ZONE,
    primary key (id)
);

CREATE TABLE student_group
(
    id         UUID         NOT NULL,
    course     INTEGER      NOT NULL,
    curator_id UUID,
    name       VARCHAR(255) NOT NULL,
    leader_id  UUID,
    primary key (id)
);

CREATE TABLE subject
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    primary key (id)
);

CREATE TABLE teacher
(
    id                UUID         NOT NULL,
    dismissed         BOOL DEFAULT FALSE,
    curator           BOOL DEFAULT FALSE,
    first_name        VARCHAR(255) NOT NULL,
    gender_type       VARCHAR(10)  NOT NULL,
    hire_date         TIMESTAMP(6) WITH TIME ZONE,
    last_name         VARCHAR(255) NOT NULL,
    middle_name       VARCHAR(255) NOT NULL,
    modification_date TIMESTAMP(6) WITH TIME ZONE,
    subject_id        UUID,
    primary key (id)
);

ALTER TABLE student_group
    ADD CONSTRAINT student_group_student_fk FOREIGN KEY (leader_id) REFERENCES student (id);
ALTER TABLE student_group
    ADD CONSTRAINT student_group_teacher_fk FOREIGN KEY (curator_id) REFERENCES teacher (id);
ALTER TABLE lesson
    ADD CONSTRAINT lesson_teacher_fk FOREIGN KEY (teacher_id) REFERENCES teacher (id);
ALTER TABLE lesson
    ADD CONSTRAINT lesson_subject_fk FOREIGN KEY (subject_id) REFERENCES subject (id);
ALTER TABLE lesson
    ADD CONSTRAINT lesson_student_group_fk FOREIGN KEY (group_id) REFERENCES student_group (id);
ALTER TABLE student
    ADD CONSTRAINT student_student_group_fk FOREIGN KEY (group_id) REFERENCES student_group (id);