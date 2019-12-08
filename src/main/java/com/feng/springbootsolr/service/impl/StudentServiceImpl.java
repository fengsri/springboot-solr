package com.feng.springbootsolr.service.impl;

import com.feng.springbootsolr.pojo.Student;
import com.feng.springbootsolr.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/12/8 19:49
 * @Version V1.0
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    /**
     * 调用solr的api查询学生
     */
    @Autowired
    private SolrClient solrClient;


    /**
     * 保存学生信息
     *
     * @param student
     * @return
     */
    @Override
    public boolean saveStudent(Student student) {
        try {
            solrClient.addBean(student);
            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("保存学生信息出错：{}", student);
            return false;
        }
        return true;
    }

    @Override
    public List<Student> queryStudent(String param, int pagerNum, int pageSize, String sort) {
        SolrQuery query = new SolrQuery();
        query.set("q", param);
        query.set("start", (pagerNum - 1) * pageSize);
        query.set("rows", pageSize);
        query.set("sort", sort);

        List<Student> studentList = null;
        try {
            QueryResponse response = solrClient.query(query);
            studentList = response.getBeans(Student.class);
        } catch (Exception e) {
            log.error("查询学生信息出错：{}、{}、{}、{}", param, pagerNum, pageSize, sort);
        }
        return studentList;
    }

    @Override
    public Student queryById(String id) {
        SolrQuery query = new SolrQuery();
        String param = "id:" + id;
        query.set("q", param);

        List<Student> studentList = null;
        try {
            QueryResponse response = solrClient.query(query);
            studentList = response.getBeans(Student.class);
            if (studentList != null && studentList.size() > 0) {
                return studentList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询学生信息出错：{}", id);
        }
        return null;
    }
}
