package com.steven.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRespository schoolRespository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRespository schoolRespository, SchoolMapper schoolMapper) {
        this.schoolRespository = schoolRespository;
        this.schoolMapper = schoolMapper;
    }
    public SchoolResponseDto saveSchool(SchoolDto dto){
        var school=schoolMapper.toSchool(dto);
        var savedSchool=schoolRespository.save(school);
        return schoolMapper.toSchoolResponseDto(savedSchool);
    }
    public List<SchoolResponseDto> findAllSchools(){
        return schoolRespository.findAll()
                .stream()
                .map(schoolMapper::toSchoolResponseDto)
                .collect(Collectors.toList());
    }
}

