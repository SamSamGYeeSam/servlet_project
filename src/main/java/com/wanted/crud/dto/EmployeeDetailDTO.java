package com.wanted.crud.dto;

import java.util.Date;

public class EmployeeDetailDTO {
    private Long emp_id;
    private String emp_name;
    private String email;
    private String phone;
    private String dept_code;
    private String dept_title;
    private String job_code;
    private String job_name;
    private String salary;
    private Date hire_Date;
    private String quitstatus;

    public EmployeeDetailDTO() {
    }

    public EmployeeDetailDTO(Long emp_id, String emp_name, String email, String phone, String dept_code, String dept_title, String job_code, String job_name, String salary, Date hire_Date, String quitstatus) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.email = email;
        this.phone = phone;
        this.dept_code = dept_code;
        this.dept_title = dept_title;
        this.job_code = job_code;
        this.job_name = job_name;
        this.salary = salary;
        this.hire_Date = hire_Date;
        this.quitstatus = quitstatus;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDept_title() {
        return dept_title;
    }

    public void setDept_title(String dept_title) {
        this.dept_title = dept_title;
    }

    public String getJob_code() {
        return job_code;
    }

    public void setJob_code(String job_code) {
        this.job_code = job_code;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getHire_Date() {
        return hire_Date;
    }

    public void setHire_Date(Date hire_Date) {
        this.hire_Date = hire_Date;
    }

    public String getQuitstatus() {
        return quitstatus;
    }

    public void setQuitstatus(String quitstatus) {
        this.quitstatus = quitstatus;
    }

    @Override
    public String toString() {
        return "EmployeeDetailDTO{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dept_code='" + dept_code + '\'' +
                ", dept_title='" + dept_title + '\'' +
                ", job_code='" + job_code + '\'' +
                ", job_name='" + job_name + '\'' +
                ", salary='" + salary + '\'' +
                ", hire_Date=" + hire_Date +
                ", quitstatus='" + quitstatus + '\'' +
                '}';
    }
}
