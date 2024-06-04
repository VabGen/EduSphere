CREATE TABLE teacher_subject
(
    id         UUID PRIMARY KEY,
    teacher_id UUID NOT NULL,
    subject_id UUID NOT NULL,
    CONSTRAINT teacher_subject_teacher_fk FOREIGN KEY (teacher_id) REFERENCES teacher (id),
    CONSTRAINT teacher_subject_subject_fk FOREIGN KEY (subject_id) REFERENCES subject (id)
);