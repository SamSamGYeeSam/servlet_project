package com.wanted.crud.dto;

public class EmployeeDeleteDTO {

    private int empId;

    public EmployeeDeleteDTO() {
    }


    public EmployeeDeleteDTO(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "EmployeeDeleteDTO{" +
                "empId=" + empId +
                '}';
    }
}