CREATE INDEX idx_lesson_lesson_time ON lesson (lesson_time);
CREATE INDEX idx_lesson_group_id ON lesson (group_id);
CREATE INDEX idx_lesson_subject_id ON lesson (subject_id);
CREATE INDEX idx_lesson_teacher_id ON lesson (teacher_id);

CREATE INDEX idx_student_group_id ON student (group_id);
CREATE INDEX idx_student_leader ON student (leader);
CREATE INDEX idx_student_first_name ON student (first_name);
CREATE INDEX idx_student_middle_name ON student (middle_name);
CREATE INDEX idx_student_last_name ON student (last_name);
CREATE INDEX idx_student_enrollment_date ON student (enrollment_date);
CREATE INDEX idx_student_modification_date ON student (modification_date);

CREATE INDEX idx_student_group_course ON student_group (course);
CREATE INDEX idx_student_group_name ON student_group (name);
CREATE INDEX idx_student_group_curator_id ON student_group (curator_id);
CREATE INDEX idx_student_group_leader_id ON student_group (leader_id);

CREATE INDEX idx_subject_name ON subject (name);

CREATE INDEX idx_teacher_first_name ON teacher (first_name);
CREATE INDEX idx_teacher_middle_name ON teacher (middle_name);
CREATE INDEX idx_teacher_last_name ON teacher (last_name);
CREATE INDEX idx_teacher_hire_date ON teacher (hire_date);
CREATE INDEX idx_teacher_modification_date ON teacher (modification_date);
CREATE INDEX idx_teacher_dismissed ON teacher (dismissed);
CREATE INDEX idx_teacher_curator ON teacher (curator);
CREATE INDEX idx_teacher_subject_id ON teacher (subject_id);

CREATE INDEX idx_teacher_id ON teacher_subject (teacher_id);
CREATE INDEX idx_subject_id ON teacher_subject (subject_id);