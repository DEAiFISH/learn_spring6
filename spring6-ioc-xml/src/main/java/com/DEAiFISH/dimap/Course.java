package com.DEAiFISH.dimap;

public class Course {
    private String cName;

    public Course() {
    }

    public Course(String cName) {
        this.cName = cName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cName='" + cName + '\'' +
                '}';
    }
}
