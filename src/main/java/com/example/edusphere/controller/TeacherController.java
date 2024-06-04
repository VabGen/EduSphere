package com.example.edusphere.controller;

import com.example.edusphere.controller.model.request.TeacherRequest;
import com.example.edusphere.dto.model.TeacherDto;
import com.example.edusphere.model.filter.TeacherFilter;
import com.example.edusphere.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherDto> create(@RequestBody TeacherRequest request) {
        return ResponseEntity.ok(teacherService.create(request));
    }

    @PutMapping
    public ResponseEntity<TeacherDto> update(@RequestBody TeacherRequest request) {
        TeacherDto updatedTeacher = teacherService.edit(request);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        teacherService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> get(@PathVariable UUID id) {
        TeacherDto findTeacher = teacherService.findById(id);
        return ResponseEntity.ok(findTeacher);
    }

    @GetMapping
    public ResponseEntity<Page<TeacherDto>> filter(@ModelAttribute TeacherFilter filter,
                                                   @PageableDefault(sort = {"lastName"}, direction = Sort.Direction.ASC)
                                                   Pageable pageable) {
        Page<TeacherDto> filterTeacher = teacherService.findAll(filter, pageable);
        return ResponseEntity.ok(filterTeacher);
    }
}