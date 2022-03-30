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
public class payment implements Serializable{
    private String payment_amount;
    private String payment_type;

    public String getPayment_amount() {
        return payment_amount;
    }

    public String getPayment_type() {
        return payment_type;
    }
    
    
}
