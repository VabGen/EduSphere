package com.example.edusphere.controller;

import com.example.edusphere.controller.model.request.StudentRequest;
import com.example.edusphere.dto.model.StudentDto;
import com.example.edusphere.model.filter.StudentFilter;
import com.example.edusphere.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.create(request));
    }

    @PutMapping
    public ResponseEntity<StudentDto> update(@RequestBody StudentRequest request) {
        StudentDto updatedStudent = studentService.edit(request);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> get(@PathVariable UUID id) {
        StudentDto findStudent = studentService.findById(id);
        return ResponseEntity.ok(findStudent);
    }

    @GetMapping
    public ResponseEntity<Page<StudentDto>> filter(@ModelAttribute StudentFilter filter,
                                                   @PageableDefault(sort = {"lastName"}, direction = Sort.Direction.ASC)
                                                   Pageable pageable) {
        Page<StudentDto> filterStudent = studentService.findAll(filter, pageable);
        return ResponseEntity.ok(filterStudent);
    }
}