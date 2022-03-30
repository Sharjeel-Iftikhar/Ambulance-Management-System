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
public class Attendence implements Serializable{
    private String date;
    private String time;
    private boolean attend;

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public boolean isAttend() {
        return attend;
    }
    
    
}
