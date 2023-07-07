package com.example.summer.service;

import com.example.summer.mapper.TerminologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminologyService {
    @Autowired
    private TerminologyMapper terminologyMapper;

}
