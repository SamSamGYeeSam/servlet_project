package com.wanted.crud.dto;

import java.sql.Date;

public class EmployeeUpdateDTO {

    private String emp_Id;         // EMP_ID
    private String emp_Name;     // EMP_NAME
    private String emp_No;       // EMP_NO
    private String email;       // EMAIL
    private String phone;       // PHONE
    private String dept_Code;    // DEPT_CODE
    private String job_Code;     // JOB_CODE
    private String sal_level;
    private int salary;
    private int bonus;
    private int manager_id;
    private Date hire_date;
    private Date ent_date;
    private String ent_yn;


    public EmployeeUpdateDTO() {
    }

    public EmployeeUpdateDTO(String emp_Id, String emp_Name, String emp_No, String email, String phone, String dept_Code, String job_Code, String sal_level, int salary, int bonus, int manager_id, Date hire_date, Date ent_date, String ent_yn) {
        this.emp_Id = emp_Id;
        this.emp_Name = emp_Name;
        this.emp_No = emp_No;
        this.email = email;
        this.phone = phone;
        this.dept_Code = dept_Code;
        this.job_Code = job_Code;
        this.sal_level = sal_level;
        this.salary = salary;
        this.bonus = bonus;
        this.manager_id = manager_id;
        this.hire_date = hire_date;
        this.ent_date = ent_date;
        this.ent_yn = ent_yn;
    }

    public String getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(String emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public String getEmp_No() {
        return emp_No;
    }

    public void setEmp_No(String emp_No) {
        this.emp_No = emp_No;
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

    public String getDept_Code() {
        return dept_Code;
    }

    public void setDept_Code(String dept_Code) {
        this.dept_Code = dept_Code;
    }

    public String getJob_Code() {
        return job_Code;
    }

    public void setJob_Code(String job_Code) {
        this.job_Code = job_Code;
    }

    public String getSal_level() {
        return sal_level;
    }

    public void setSal_level(String sal_level) {
        this.sal_level = sal_level;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getbonus() {
        return bonus;
    }

    public void setbonus(int bonus) {
        bonus = bonus;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Date getEnt_date() {
        return ent_date;
    }

    public void setEnt_date(Date ent_date) {
        this.ent_date = ent_date;
    }

    public String getEnt_yn() {
        return ent_yn;
    }

    public void setEnt_yn(String ent_yn) {
        this.ent_yn = ent_yn;
    }

    @Override
    public String toString() {
        return "EmployeeUpdateDTO{" +
                "emp_Id=" + emp_Id +
                ", emp_Name='" + emp_Name + '\'' +
                ", emp_No='" + emp_No + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dept_Code='" + dept_Code + '\'' +
                ", job_Code='" + job_Code + '\'' +
                ", sal_level='" + sal_level + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", manager_id=" + manager_id +
                ", hire_date=" + hire_date +
                ", ent_date=" + ent_date +
                ", ent_yn='" + ent_yn + '\'' +
                '}';
    }

}