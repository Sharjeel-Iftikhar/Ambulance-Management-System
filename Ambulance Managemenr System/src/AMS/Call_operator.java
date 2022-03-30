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
public class Call_operator extends Person{
    private String certificate;
    private String Qualification;
    private String Number;
    private String shift;
    private boolean  verify;
    private Stack<Calls> call_data;
    private Stack<payment> paydetails;
    private Queue<Attendence> attend_details;
    private Acount_detaiils acc;

    public String getCertificate() {
        return certificate;
    }

    public String getQualification() {
        return Qualification;
    }

    public String getNumber() {
        return Number;
    }

    public boolean isVerify() {
        return verify;
    }

    public Stack<Calls> getCall_data() {
        return call_data;
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

    public Call_operator(String name, String FatherNAme,String CNIC,String email,String DOB,String salary,String certificate, String Qualification, String Number, String shift,String Gender,int no) {
        this.certificate = certificate;
        this.Qualification = Qualification;
        this.Number = Number;
        this.shift = shift;
        this.setName(name);
        this.setFathername(FatherNAme);
        this.setCnic(CNIC);
        this.setDOB(DOB);
        this.setEmail(email);
        this.setSalary(salary);
        this.setGender(Gender);
        this.setEmploye_number(no);
    }
    
        public String ID_Generator(String man,int num)
    {
        String id = "";
        id = id + man + "-" + num + "@callopertor.com";
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
    
    
    @Override
    public String getType() {
        return "Call Operator";
    }
}
