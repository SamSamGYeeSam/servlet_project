package com.wanted.crud.dto;

public class EmployeeListDTO {
    private Long emp_id;
    private String emp_name;
    private String email;
    private String phone;
    private String dept_title;
    private String job_name;
    private String salary;
    private String workingstatus;


    public EmployeeListDTO() {
    }

    public EmployeeListDTO(Long emp_id, String emp_name, String email, String phone, String dept_title, String job_name, String salary, String workingstatus) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.email = email;
        this.phone = phone;
        this.dept_title = dept_title;
        this.job_name = job_name;
        this.salary = salary;
        this.workingstatus = workingstatus;
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

    public String getDept_title() {
        return dept_title;
    }

    public void setDept_title(String dept_title) {
        this.dept_title = dept_title;
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

    public String getWorkingstatus() {
        return workingstatus;
    }

    public void setWorkingstatus(String workingstatus) {
        this.workingstatus = workingstatus;
    }

    @Override
    public String toString() {
        return "EmployeeListDTO{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dept_title='" + dept_title + '\'' +
                ", job_name='" + job_name + '\'' +
                ", salary='" + salary + '\'' +
                ", workingstatus='" + workingstatus + '\'' +
                '}';
    }
}
