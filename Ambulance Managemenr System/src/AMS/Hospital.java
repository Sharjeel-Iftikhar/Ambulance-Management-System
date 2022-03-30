/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import java.util.Set;

/**
 *
 * @author m_nou
 */
public class Hospital {
    private String name;
    private String address;
    private String hos_id;
    private Set<beds_status> beds;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getHos_id() {
        return hos_id;
    }

    public Set<beds_status> getBeds() {
        return beds;
    }
    
    
}
