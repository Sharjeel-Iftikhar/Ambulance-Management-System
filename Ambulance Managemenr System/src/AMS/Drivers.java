/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import java.security.SecureRandom;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author m_nou
 */
public class Drivers extends Person{
    private String driving_licence;
    private int recruit_test_marks;
    private String Number;
    private String vehicle_id;
    private String off_id; 
    private boolean status;
    private boolean  verify;
    private String shift;
    private Stack<payment> paydetails;
    private Queue<Attendence> attend_details;
    private Acount_detaiils acc;

    public Drivers(String type,String name,String fname,String cnic,String dob,String gender,String email,String Number,String pic) {
        AmbulanceManagemenrSystem ams = AmbulanceManagemenrSystem.driver_instance();
        
        this.Number = Number;
        this.setType(this.getType());
        this.setName(name);
        this.setFathername(fname);
        this.setCnic(cnic);
        this.setDOB(dob);
        this.setGender(gender);
        this.setEmail(email);
        this.verify =false;
        this.vehicle_id="-";
        //int CN = Integer.parseInt(cnic);
        this.setId_number(IdGenerator("Driver",cnic));
        //String pas = getPass();
        //this.setPassword(pas);
        this.driving_licence = pic;
    }
    
    public Drivers(String shift,String name,String fname,String cnic,String dob,String gender,String email,String Number,String pic,int a) {
        AmbulanceManagemenrSystem ams = AmbulanceManagemenrSystem.driver_instance();
        ams.setEmployee_instances();
        this.Number = Number;
        this.setType(this.getType());
        this.setName(name);
        this.setFathername(fname);
        this.setCnic(cnic);
        this.setDOB(dob);
        this.setGender(gender); 
        this.setEmail(email);
        this.verify =false;
        this.status = false;
        this.vehicle_id="-";
        this.setEmploye_number(ams.getEmployee_instances());
        //int CN = Integer.parseInt(cnic);
        this.setId_number(Id_Generator(ams.getEmployee_instances()));
        String pas = getPass();
        this.setPassword(pas);
        this.driving_licence = pic;
        this.shift = shift;
    }
    
    private String Id_Generator(int a)
    {
        String id = "";
        id = id  + "dri-" + a + "@dri.com" ;
        return id;
    }
    
   // Method for id generator
    private String IdGenerator(String dri,String cnic)
    {
        String id = "";
        id = id + dri + "/"+cnic;
        return id;
    }
    // Method for password
    private String getPass()
    {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String spe = "@#%^&*_-";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        
        int randomm = random.nextInt(spe.length()); // to choose a special character from SPE.
        sb.append(spe.charAt(randomm));
        
        for (int i = 0; i < 5; i++)                 // This Loop will choose 5 random Digits or characters.
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        
        String pass = "";
        pass = "Dri" + sb;
        System.out.println("Driver Password = "+pass);
        return pass;
    }

    public void setOff_id(String off_id) {
        this.off_id = off_id;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
    
    public String getShift() {
        return shift;
    }
    
    
    public void setDriving_licence(String driving_licence) {
        this.driving_licence = driving_licence;
    }

    public void setRecruit_test_marks(int recruit_test_marks) {
        this.recruit_test_marks = recruit_test_marks;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public void setPaydetails(Stack<payment> paydetails) {
        this.paydetails = paydetails;
    }

    public void setAttend_details(Queue<Attendence> attend_details) {
        this.attend_details = attend_details;
    }

    public void setAcc(Acount_detaiils acc) {
        this.acc = acc;
    }

    
    public String getDriving_licence() {
        return driving_licence;
    }

    public int getRecruit_test_marks() {
        return recruit_test_marks;
    }

    public String getNumber() {
        return Number;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isVerify() {
        return verify;
    }

    public Stack<payment> getPaydetails() {
        return paydetails;
    }

    public Queue<Attendence> getAttend_details() {
        return attend_details;
    }

    public Acount_detaiils getAcc() {
        return acc;
    }
    @Override
    public String getType() {
        return "Driver";
    }
    
}
