package com.feng.springbootsolr.service;

import com.feng.springbootsolr.pojo.Student;
import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/12/8 19:48
 * @Version V1.0
 */
public interface StudentService {

    /**
     * 保存学生
     * @param student
     * @return
     */
    boolean saveStudent(Student student);

    /**
     * 根据条件查询学生
     * @param param
     * @param pagerNum
     * @param pageSize
     * @param sort
     * @return
     */
    List<Student> queryStudent(String param,int pagerNum ,int pageSize,String sort);

    /**
     * 通过id查询学生
     * @param id
     * @return
     */
    Student queryById(String id);

}
