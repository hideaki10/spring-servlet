package org.lanqiao.service.impl;

import org.lanqiao.dao.IStudentDao;
import org.lanqiao.dao.im.StudentDaoImpl;
import org.lanqiao.service.IStudentService;

public class StudentServceImpl implements IStudentService {

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    IStudentDao studentDao ;
    @Override
    public String queryStudentID() {
        return studentDao.queryStudentById();
    }
}
