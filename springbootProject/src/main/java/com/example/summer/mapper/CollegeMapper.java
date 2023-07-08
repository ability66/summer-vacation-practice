package com.example.summer.mapper;

import com.example.summer.entity.College;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeMapper {
    String selectCo_nameByCo_no(int co_no);
    int selectCo_noByCo_name(String co_name);
    void insertCollege(College college);
    void deleteCollegeByCo_name(String name);
}
