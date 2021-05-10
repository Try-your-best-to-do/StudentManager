package com.ssm.domain;

import java.io.Serializable;

public class Businesscard implements Serializable {
    private String student_id;
    private String student_id1;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_id1() {
        return student_id1;
    }

    public void setStudent_id1(String student_id1) {
        this.student_id1 = student_id1;
    }

    @Override
    public String toString() {
        return "Businesscard{" +
                "student_id='" + student_id + '\'' +
                ", student_id1='" + student_id1 + '\'' +
                '}';
    }
}
