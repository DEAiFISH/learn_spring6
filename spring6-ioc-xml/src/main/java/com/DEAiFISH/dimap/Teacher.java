package com.DEAiFISH.dimap;

public class Teacher {
    private String tId;
    private String tName;

    public Teacher() {
    }

    public Teacher(String tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                '}';
    }
}
