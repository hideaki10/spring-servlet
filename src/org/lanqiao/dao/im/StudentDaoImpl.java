package org.lanqiao.dao.im;

import org.lanqiao.dao.IStudentDao;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public String queryStudentById() {
        //模拟访问DB
        System.out.println("dada");
        return "zhangsan";
    }
}
