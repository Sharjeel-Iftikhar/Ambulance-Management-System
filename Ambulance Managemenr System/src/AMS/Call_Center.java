/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;
import java.util.*;
import DataStructures.LinkedList;
/**
 *
 * @author m_nou
 */
public class Call_Center {
    
    private String center_name;
    private String center_id;
    private LinkedList<Person> call_operators= new LinkedList();
    private static Call_Center callCenter;
    
    private Call_Center()
    {
        this.center_name = "LHR_CallCenter";
        this.center_id = "LHR_Main07";
    }
    public static Call_Center get_CallCenterInstance()
    {
        if(callCenter==null)
        {
            callCenter=new Call_Center();
        }
        return callCenter;
    }

    public String getCenter_name() {
        return center_name;
    }

    public String getCenter_id() {
        return center_id;
    }

    public LinkedList<Person> getCall_operators() {
        return call_operators;
    }
    
    
}
