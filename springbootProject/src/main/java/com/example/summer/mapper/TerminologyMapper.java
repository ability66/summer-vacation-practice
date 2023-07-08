package com.example.summer.mapper;

import com.example.summer.entity.Terminology;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminologyMapper {
    int selectTer_noByTer_name(String ter_name);
    String selectTer_nameByTer_no(int Ter_no);
    void insertTerminology(Terminology terminology);
    void deletTerminologyByTer_name(String ter_name);
    void deletTerminologyByTer_no(int ter_no);
}
