package com.feng.springbootsolr.controller;

import com.feng.springbootsolr.pojo.Student;
import com.feng.springbootsolr.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/12/8 19:48
 * @Version V1.0
 */
@RestController
@RequestMapping("student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 保存学生
     *
     * @param student
     * @return
     */
    @PostMapping("save")
    public String saveStudent(Student student) {
        boolean result = studentService.saveStudent(student);
        if (!result) {
            return "保存失败";
        }
        return "保存成功";
    }

    /**
     * 通过id查询学生
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Student getById(@PathVariable("id") String id) {
        Student student = studentService.queryById(id);
        return student;
    }

    /**
     * 通过条件查询学生
     *
     * @param param
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    @GetMapping("query")
    public List<Student> queryStudent( String param,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(required = false,defaultValue = "5") Integer pageSize,
                                      @RequestParam(required = false,defaultValue = "id desc") String sort) {
        List<Student> studentList = studentService.queryStudent(param, pageNum, pageSize, sort);
        return studentList;
    }
}
