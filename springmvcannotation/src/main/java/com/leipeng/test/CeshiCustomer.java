package com.leipeng.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CeshiCustomer {

    final String mapperUrl = "com.leipeng/CustomerMapper";

    @Test
    public void testFind() throws IOException {
        SqlSession sqlSession = getSqlSession();
        Map map = new HashMap<String, String>();
        map.put("customerName", "charies");
        List<Map> customers = sqlSession.selectList(mapperUrl + ".find", map);
        for (Map<String, Object> customer : customers) {
            System.out.println("customer = name: " + customer.get("name") + " sn: " + customer.get("sn") + " remark: " + customer.get("remark"));
        }
    }

    private SqlSession getSqlSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }
}
