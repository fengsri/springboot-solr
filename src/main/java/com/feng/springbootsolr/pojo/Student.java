package com.feng.springbootsolr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @Description 学生
 * @Author fengwen
 * @Date 2019/12/8 19:43
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = -2221755230808487993L;

    /**
     * 学生id
     */
    @Field("id")
    private String id;

    /**
     * 学生姓名
     */
    @Field("studentName")
    private String studentName;

    /**
     * 学生年龄
     */
    @Field("studentAge")
    private Integer studentAge;

    /**
     * 学生性别
     */
    @Field("studentGrander")
    private Integer studentGrander;

}
