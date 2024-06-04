package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.GroupRequest;
import com.example.edusphere.dto.model.GroupDto;
import com.example.edusphere.model.filter.GroupFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GroupService {

    GroupDto create(GroupRequest request);

    List<GroupDto> findAll();

    GroupDto edit(GroupRequest request);

    void delete(UUID id);

    GroupDto findById(UUID id);

    Page<GroupDto> findAll(GroupFilter filter, Pageable pageable);
}
