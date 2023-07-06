package com.system.summervacationpractice;


import com.system.summervacationpractice.entity.*;
import com.system.summervacationpractice.entity.Class;
import com.system.summervacationpractice.mapper.ClassMapper;

import com.system.summervacationpractice.mapper.ClassTableMapper;
import com.system.summervacationpractice.mapper.GradeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Mybatis 快速入门代码
 */
public class MyBatisDemo {

    public static void main(String[] args) throws IOException {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        //true开启自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 执行sql

        //4. 释放资源
        sqlSession.close();
//efheiuyfeyfjehkjfe
    }
}
