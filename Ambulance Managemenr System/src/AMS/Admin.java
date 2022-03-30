/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import DataStructures.LinkedList;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author m_nou
 */
public class Admin extends Person {

    private String qualification;
    private String Number;
    private String pic;
    private static Admin admin;

    private Admin() {
        this.setCnic("34101-9164416-5");
        this.setDOB("21-Jan-2001");
        this.setEmail("pacsaqiirr@gmail.com");
        this.setFathername("Muhammad Nawaz");
        this.setGender("Male");
        this.setName("Saqi Nawaz");
        this.setNumber("03067628892");
        this.setSalary("70000");
        this.setId_number("admin@admin.com");
        // this.setEmploye_number(1);
        this.setPassword("1");
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public static Admin admin_instance() {
        if (admin == null) {
            admin = new Admin();
        }
        return admin;
    }

    public String getQualification() {
        return qualification;
    }

    public String getNumber() {
        return Number;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public static void writeadmin() {
        
        try {
            File file = new File(
                    "..\\Ambulance Managemenr System\\src\\DataStored\\admin.txt");
            FileWriter myWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(myWriter);
            Admin ad = Admin.admin_instance();
            System.out.println(ad.getSalary());
            writer.write(ad.getName() + "=" + ad.getFathername() + "=" + ad.getCnic() + "=" + ad.getDOB() + "=" + ad.getEmail() + "=" + ad.getGender() + "=" + ad.getNumber() + "=" + ad.getSalary() + "=" + ad.getId_number() + "=" + ad.getPassword() + "=" + ad.getType() + "=" + ad.getQualification()+"="+ad.getPic());
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readadmin() {
        try {
            File file = new File(
                    "..\\Ambulance Managemenr System\\src\\DataStored\\admin.txt");
            Scanner myReader = new Scanner(file);
            String data = myReader.nextLine();
            System.out.println(data);
            String[] parts = data.split("=");
            Admin ad = admin_instance();
            ad.setName(parts[0]);
            ad.setFathername(parts[1]);
            ad.setCnic(parts[2]);
            ad.setDOB(parts[3]);
            ad.setEmail(parts[4]);
            ad.setGender(parts[5]);
            ad.setNumber(parts[6]);
            ad.setSalary(parts[7]);
            ad.setId_number(parts[8]);
            ad.setPassword(parts[9]);
            ad.setType(parts[10]);
            ad.setQualification(parts[11]);
            ad.setPic(parts[12]);

            myReader.close();
        } catch (Exception e) {

            System.out.println(e);
        }

    }

}
