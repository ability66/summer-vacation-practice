package com.example.summer.service;

import com.example.summer.entity.Terminology;
import com.example.summer.mapper.TerminologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminologyService {
    @Autowired
    private TerminologyMapper terminologyMapper;
    public String selectTer_nameByTer_no(int ter_no){
        return terminologyMapper.selectTer_nameByTer_no(ter_no);
    }
    public int selectTer_noByTer_name(String ter_name){
        return terminologyMapper.selectTer_noByTer_name(ter_name);
    }
    public void insertTerminology(Terminology terminology){
        terminologyMapper.insertTerminology(terminology);
    }
    public void deletTerminologyByTer_no(int ter_no){
        terminologyMapper.deletTerminologyByTer_no(ter_no);
    }
}
