package com.example.edusphere.controller;

import com.example.edusphere.controller.model.request.TeacherRequest;

import com.example.edusphere.dto.model.TeacherDto;
import com.example.edusphere.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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
        TeacherDto updatedTeacher = teacherService.update(request);
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

//    @GetMapping
//    public ResponseEntity<List<TeacherDto>> filter(@ModelAttribute TeacherFilter filter,
//                                                    @RequestParam(defaultValue = "0") int page,
//                                                    @RequestParam(defaultValue = "1000") int size) {
//        List<TeacherDto> filterTeacher = teacherService.filter(filter, page, size);
//        return ResponseEntity.ok(filterTeacher);
//    }
}
