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
public class Fire_brigade extends Vehicles{
    
    
    Fire_brigade(String name,String number_plate,String capacity,String off_id,String slot_num)
    {
            this.setName(name);
            this.setCapacity(capacity);
            this.setVehicle_no_plate(number_plate);
            this.setVehice_id(this.ID_Generator("Fire"));
            this.setPatients_saved(0);
            this.setStatus(false);
            this.setAvailable(true);
            this.setSlot_num(Integer.parseInt(slot_num));
            this.setType(this.getType());        
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
    
    @Override
    public String getType() {
        return "Fire Brigade";
    }
}
