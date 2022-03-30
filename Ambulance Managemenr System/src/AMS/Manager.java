/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import java.security.SecureRandom;
import java.util.Stack;

/**
 *
 * @author m_nou
 */
public class Manager extends Person{
    private String Qalification;
    private String Number;
    private String Res_off_id;
    private String CV;
    private String pic;
    
    private boolean  verify;
    private Stack<payment> paydetails;
    private Acount_detaiils acc;

    
    Manager(String name,String fathername,String cnin,String dob,String number,String email,String salary,String off_id,String pic)
    {
        AmbulanceManagemenrSystem ams = AmbulanceManagemenrSystem.driver_instance();
        ams.setEmployee_instances();
        this.setName(name);
        this.setFathername(fathername);
        this.setCnic(cnin);
        this.setDOB(dob);
        this.setNumber(number);
        this.setEmail(email);
        this.setSalary(salary);
        this.setPic(pic);
        this.CV = "";
        this.Qalification = "";
        this.Res_off_id = off_id;
        this.acc = new Acount_detaiils();
        this.verify =false;
        this.setEmploye_number(ams.getEmployee_instances());
        this.setId_number(ID_Generator("man", ams.getEmployee_instances()));
        this.setPassword(Password_generator());
    }

    public Manager(int a) {
        this.setName("ads");
        this.setFathername("ads");
        this.setCnic("ads");
        this.setDOB("ads");
        this.setNumber("ads");
        this.setEmail("ads");
        this.setEmploye_number(a);
    }
    
    
    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }
    
    private String ID_Generator(String man,int num)
    {
        String id = "";
        id = id + man + "-" + num + "@manager.com";
        System.out.print(id);
        return id;
    }
    
    public String Password_generator()
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
        pass = "man" + sb;
        System.out.println("Teacher Password = "+pass);
        return pass;
    }
    
    public String getRes_off_id() {
        return Res_off_id;
    }

    
    
    public String getQalification() {
        return Qalification;
    }

    public String getNumber() {
        return Number;
    }

    public String getCV() {
        return CV;
    }

    public boolean isVerify() {
        return verify;
    }

    public Stack<payment> getPaydetails() {
        return paydetails;
    }

    public Acount_detaiils getAcc() {
        return acc;
    }

    public void setQalification(String Qalification) {
        this.Qalification = Qalification;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public void setRes_off_id(String Res_off_id) {
        this.Res_off_id = Res_off_id;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public void setPaydetails(Stack<payment> paydetails) {
        this.paydetails = paydetails;
    }

    public void setAcc(Acount_detaiils acc) {
        this.acc = acc;
    }
    
    
    @Override
    public String getType() {
        return "Manager";
    }
}
