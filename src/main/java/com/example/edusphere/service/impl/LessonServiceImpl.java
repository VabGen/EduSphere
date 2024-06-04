package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.LessonRequest;
import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.dao.service.LessonServiceDao;
import com.example.edusphere.dto.mapper.LessonMapper;
import com.example.edusphere.dto.model.LessonDto;
import com.example.edusphere.model.filter.LessonFilter;
import com.example.edusphere.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonServiceDao lessonDAO;

    @Autowired
    public LessonServiceImpl(LessonServiceDao lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LessonDto create(LessonRequest request) {
        Lesson lesson = LessonMapper.requestToEntity(request, new Lesson());
        lessonDAO.create(lesson);
        return LessonMapper.entityToDto(lesson);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LessonDto> findAll() {
        List<Lesson> lessons = lessonDAO.findAll();
        return lessons.stream().map(LessonMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LessonDto edit(LessonRequest request) {
        Lesson lesson = lessonDAO.findById(request.getId());
        if (lesson == null) {
            throw new RuntimeException("Lesson not found");
        }

        LessonMapper.requestToEntity(request, lesson);
        lessonDAO.edit(lesson);
        return LessonMapper.entityToDto(lesson);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        lessonDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public LessonDto findById(UUID id) {
        Lesson lesson = lessonDAO.findById(id);
        return LessonMapper.entityToDto(lesson);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LessonDto> findAll(LessonFilter filter, Pageable pageable) {
        Page<Lesson> lessonPage = lessonDAO.findAll(filter, pageable);
        return lessonPage.map(e -> LessonMapper.entityToDto(e, filter.getFetches()));
    }
}
