package com.example.summer.service;

import com.example.summer.entity.College;
import com.example.summer.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    public int selectCo_noByCo_name(String co_name){
        return collegeMapper.selectCo_noByCo_name(co_name);
    }
    public String selectCo_nameByCo_no(int co_no){
        return collegeMapper.selectCo_nameByCo_no(co_no);
    }
    public void insertCollege(College college){collegeMapper.insertCollege(college);}
    public void  deleteCollegeByCo_name(String co_name){
        collegeMapper.deleteCollegeByCo_name(co_name);
    }
public void updateCollegeNameByCollege(String oldName,String newName){
        collegeMapper.updateCollegeNameByCo_name(oldName,newName);
}
}
