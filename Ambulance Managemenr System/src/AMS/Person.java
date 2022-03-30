/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import java.io.Serializable;

/**
 *
 * @author m_nou
 */
public class Person implements Serializable {
    private String name;
    private String Fathername;
    private String Cnic;
    private String DOB;
    private String gender;
    private String email;
    private String salary;
    private String id_number;
    private String password;
    private String type;
    private int Employe_number;

    public int getEmploye_number() {
        return Employe_number;
    }

    public String getName() {
        return name;
    }

    public String getFathername() {
        return Fathername;
    }

    public String getCnic() {
        return Cnic;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getSalary() {
        return salary;
    }

    public String getId_number() {
        return id_number;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFathername(String Fathername) {
        this.Fathername = Fathername;
    }

    public void setCnic(String Cnic) {
        this.Cnic = Cnic;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmploye_number(int Employe_number) {
        this.Employe_number = Employe_number;
    }
    
    
    
}
