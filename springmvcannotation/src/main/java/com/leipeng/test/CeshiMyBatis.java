package com.leipeng.test;

import com.leipeng.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CeshiMyBatis {

    final String mapperUrl = "com.leipeng/mapper.UserMapper";

    @Test
    public void ceshi() throws IOException {
        SqlSession sqlSession = getSqlSession();

        List<Person> personList = sqlSession.selectList("com.leipeng/mapper.UserMapper.findAll");
        for (Person person : personList) {
            System.out.println("person = " + person);
        }
    }


    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = getSqlSession();
        Person person = new Person();
        person.setId(5);
        person.setAge(15);
        person.setName("leipeng" + 5);
        person.setPhotoPath("dddd");
        sqlSession.insert("com.leipeng/mapper.UserMapper.insert", person);
        sqlSession.commit();
    }

    @Test
    public void testGet() throws IOException {
        SqlSession sqlSession = getSqlSession();
        Person person = sqlSession.selectOne("com.leipeng/mapper.UserMapper.get", 2);
        System.out.println("person = " + person);
    }

    @Test
    public void testUpdate() throws IOException {
        Person person = new Person();
        person.setId(2);
        person.setName("卧槽  狗币脱鞋");
        person.setAge(22);
        person.setPhotoPath("md 日了狗了");
        SqlSession sqlSession = getSqlSession();
        sqlSession.update("com.leipeng/mapper.UserMapper.updatePerson", person);
        sqlSession.commit();
    }

    @Test
    public void testDeletePerson() throws IOException {
        SqlSession sqlSession = getSqlSession();
        sqlSession.delete("com.leipeng/mapper.UserMapper.deletePerson", 2);
        sqlSession.commit();
    }


    @Test
    public void testQuery() throws IOException {
        SqlSession sqlSession = getSqlSession();
        Person person = new Person();
        person.setAge(11);
        List<Person> persons = sqlSession.selectList("com.leipeng/mapper.UserMapper.queryAll", person);
        for (Person person1 : persons) {
            System.out.println("person1 = " + person1);
        }
    }

    @Test
    public void testUpdate1() throws IOException {
        Person person = new Person();
        person.setId(0);
        person.setName("雷鹏3号");
        // person.setAge(111);
        SqlSession sqlSession = getSqlSession();
        sqlSession.update(mapperUrl + ".updatePerson1",person);
        sqlSession.commit();
    }


    @Test
    public void testDelete1() throws IOException {
        SqlSession sqlSession = getSqlSession();
        sqlSession.delete(mapperUrl + ".deletePerson1",new Integer[]{2,3,4});
        sqlSession.commit();
    }

    @Test
    public void testDelete2() throws IOException {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(2);
        integers.add(3);
        integers.add(4);
        SqlSession sqlSession = getSqlSession();
        sqlSession.delete(mapperUrl + ".deletePerson2",integers);
        sqlSession.commit();
    }
    private SqlSession getSqlSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }
}
