/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

/**
 *
 * @author m_nou
 */
public class Bike extends Vehicles{
    
    Bike(String name,String number_plate,String capacity,String off_id,String slot_num)
    {
            this.setName(name);
            this.setCapacity(capacity);
            this.setVehicle_no_plate(number_plate);
            this.setVehice_id(this.ID_Generator("bike"));
            this.setPatients_saved(0);
            this.setAvailable(true);
            this.setStatus(false);
            this.setSlot_num(Integer.parseInt(slot_num));
            this.setType(this.getType());        
    }

    public Bike() {
    }
    
    
    @Override
    public String getType() {
        return "Bike";
    }
    
    private String ID_Generator(String amb)
    {
        AmbulanceManagemenrSystem ams = AmbulanceManagemenrSystem.driver_instance();
        ams.setVehicle_instances();
        String id = "";
        id = id + amb + "-" + ams.getVehicle_instances();
        System.out.print(id);
        return id;
    }
    
}
