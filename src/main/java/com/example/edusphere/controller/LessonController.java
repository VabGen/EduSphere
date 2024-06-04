package com.example.edusphere.controller;

import com.example.edusphere.controller.model.request.LessonRequest;
import com.example.edusphere.dto.model.LessonDto;
import com.example.edusphere.model.filter.LessonFilter;
import com.example.edusphere.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/lesson")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public ResponseEntity<LessonDto> create(@RequestBody LessonRequest request) {
        return ResponseEntity.ok(lessonService.create(request));
    }

    @PutMapping
    public ResponseEntity<LessonDto> update(@RequestBody LessonRequest request) {
        LessonDto updatedLesson = lessonService.edit(request);
        return ResponseEntity.ok(updatedLesson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        lessonService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> get(@PathVariable UUID id) {
        LessonDto findLesson = lessonService.findById(id);
        return ResponseEntity.ok(findLesson);
    }

    @GetMapping
    public ResponseEntity<Page<LessonDto>> filter(@ModelAttribute LessonFilter filter,
                                                  @PageableDefault(sort = {"lessonTime"}, direction = Sort.Direction.ASC)
                                                  Pageable pageable) {
        Page<LessonDto> filterLesson = lessonService.findAll(filter, pageable);
        return ResponseEntity.ok(filterLesson);
    }
}
