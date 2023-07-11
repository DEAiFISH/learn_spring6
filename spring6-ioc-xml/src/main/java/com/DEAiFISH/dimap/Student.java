package com.DEAiFISH.dimap;

import java.util.List;
import java.util.Map;

public class Student {
    private String sId;
    private String sName;
    private Map<String, Teacher> teacherMap;
    private List<Course> courseList;

    public Student() {
    }

    public void run() {
        System.out.println("学生编号：" + sId + "\t学生名称:" + sName);
        System.out.println(teacherMap);
        System.out.println(courseList);
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
