package com.example.edusphere.controller;

import com.example.edusphere.controller.model.request.GroupRequest;
import com.example.edusphere.dto.model.GroupDto;
import com.example.edusphere.model.filter.GroupFilter;
import com.example.edusphere.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<GroupDto> create(@RequestBody GroupRequest request) {
        return ResponseEntity.ok(groupService.create(request));
    }

    @PutMapping
    public ResponseEntity<GroupDto> update(@RequestBody GroupRequest request) {
        GroupDto updatedGroup = groupService.edit(request);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        groupService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> get(@PathVariable UUID id) {
        GroupDto findGroup = groupService.findById(id);
        return ResponseEntity.ok(findGroup);
    }

    @GetMapping
    public ResponseEntity<Page<GroupDto>> filter(@ModelAttribute GroupFilter filter,
                                                 @PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC)
                                                 Pageable pageable) {
        Page<GroupDto> filterGroup = groupService.findAll(filter, pageable);
        return ResponseEntity.ok(filterGroup);
    }
}