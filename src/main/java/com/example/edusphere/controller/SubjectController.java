package com.example.edusphere.controller;

import com.example.edusphere.controller.model.request.SubjectRequest;
import com.example.edusphere.controller.model.request.TeacherRequest;
import com.example.edusphere.dto.model.SubjectDto;
import com.example.edusphere.dto.model.TeacherDto;
import com.example.edusphere.service.SubjectService;
import com.example.edusphere.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/subject")
public class SubjectController {

        private final SubjectService subjectService;

        @Autowired
        public SubjectController(SubjectService subjectService) {
            this.subjectService = subjectService;
        }

        @PostMapping
        public ResponseEntity<SubjectDto> create(@RequestBody SubjectRequest request) {
            return ResponseEntity.ok(subjectService.create(request));
        }

        @PutMapping
        public ResponseEntity<SubjectDto> update(@RequestBody SubjectRequest request) {
            SubjectDto updatedSubject = subjectService.update(request);
            return ResponseEntity.ok(updatedSubject);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable UUID id) {
            subjectService.delete(id);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/{id}")
        public ResponseEntity<SubjectDto> get(@PathVariable UUID id) {
            SubjectDto findSubject = subjectService.findById(id);
            return ResponseEntity.ok(findSubject);
        }

//    @GetMapping
//    public ResponseEntity<List<SubjectDto>> filter(@ModelAttribute SubjectFilter filter,
//                                                    @RequestParam(defaultValue = "0") int page,
//                                                    @RequestParam(defaultValue = "1000") int size) {
//        List<SubjectDto> filterSubject= subjectService.filter(filter, page, size);
//        return ResponseEntity.ok(filterSubject;
//    }

}
