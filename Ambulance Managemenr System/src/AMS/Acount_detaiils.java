/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import java.io.Serializable;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author m_nou
 */
public class Acount_detaiils implements Serializable {
    private String Acc_name;
    private String Acc_num;
    private String bank_name;

    public String getAcc_name() {
        return Acc_name;
    }

    public String getAcc_num() {
        return Acc_num;
    }

    public String getBank_name() {
        return bank_name;
    }

    public Acount_detaiils(String Acc_name, String Acc_num, String bank_name) {
        this.Acc_name = Acc_name;
        this.Acc_num = Acc_num;
        this.bank_name = bank_name;
    }

    public Acount_detaiils() {
    }

    void setAcc_name(String Acc_name) {
        this.Acc_name = Acc_name;
    }

    void setAcc_num(String Acc_num) {
        this.Acc_num = Acc_num;
    }
    void setBank_name(String Bname) {
        this.bank_name = bank_name;
    }
    
        // method to swnd email
    public static void SendMail(String recepient) throws Exception
    {
        System.out.println("Preparing to send Message");
        Properties prop = new Properties(); 
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        
        String account = "vampiresheri33@gmail.com";
        String pass = "33Vampiresheri";
        
       Session session = Session.getInstance(prop, new Authenticator() {
       @Override
       protected PasswordAuthentication getPasswordAuthentication(){
           return new PasswordAuthentication(account,pass); 
               }
       });
       
        Message mesage= prepareMessage(session,account,recepient);
        Transport.send(mesage);
        System.out.println("Message sent Successfully");
    }
    private static Message prepareMessage(Session session,String myaccount,String recepient)
    {
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myaccount));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Your OTP for changing Passwoed");
            message.setText("Here is your OTP,\n Look down here ");
            return message;
            
        } catch (Exception ex) {
            Logger.getLogger(Acount_detaiils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
