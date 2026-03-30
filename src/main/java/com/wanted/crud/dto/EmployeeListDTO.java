package com.wanted.crud.dto;

import java.sql.Date;

public class EmployeeListDTO {
    private int emp_id;
    private String emp_name;
    private String emp_no;
    private String email;
    private String phone;
    private String dept_code;
    private String job_code;
    private int salary;
    private Date hire_Date;
    private String ent_yn;


    public EmployeeListDTO(int empId, String empName, String email, String phone, String deptTitle, String jobName, double salary, String entYn) {}

    public EmployeeListDTO(int emp_id, String emp_name, String emp_no, String email, String phone, String dept_code, String job_code, int salary, Date hire_Date, String ent_yn) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_no = emp_no;
        this.email = email;
        this.phone = phone;
        this.dept_code = dept_code;
        this.job_code = job_code;
        this.salary = salary;
        this.hire_Date = hire_Date;
        this.ent_yn = ent_yn;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
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

    public String getJob_code() {
        return job_code;
    }

    public void setJob_code(String job_code) {
        this.job_code = job_code;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getHire_Date() {
        return hire_Date;
    }

    public void setHire_Date(Date hire_Date) {
        this.hire_Date = hire_Date;
    }

    public String getEnt_yn() {
        return ent_yn;
    }

    public void setEnt_yn(String ent_yn) {
        this.ent_yn = ent_yn;
    }

    @Override
    public String toString() {
        return "EmployeeListDTO{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_no='" + emp_no + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dept_code='" + dept_code + '\'' +
                ", job_code='" + job_code + '\'' +
                ", salary=" + salary +
                ", hire_Date=" + hire_Date +
                ", ent_yn='" + ent_yn + '\'' +
                '}';
    }
}
