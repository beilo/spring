package com.leipeng.service;

import com.leipeng.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService { // 模拟内存数据库,准备数据
    // 声明一个容器
    private static Map<Integer, Person> map = new HashMap<Integer, Person>();
    // 初始化id
    private static Integer id = 1;

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId(i);
            person.setName("leipeng" + i);
            person.setAge(10 + i);
            map.put(i, person);
        }
    }

    // 获取人员列表
    public ArrayList<Person> findAll() {
        return new ArrayList<Person>(map.values());
    }

    // 新增人员信息
    public void insert(Person person) {
        id++;
        person.setId(id);
        map.put(id, person);
    }

    // 获取人员信息
    public Person get(Integer id) {
        return map.get(id);
    }

    // 修改人员信息
    public void update(Person person) {
        map.put(person.getId(), person);
    }

    public void remove(Integer id){
        map.remove(id);
    }
}
