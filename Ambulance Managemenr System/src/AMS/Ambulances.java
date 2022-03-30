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
public class Ambulances extends Vehicles{
    
    Ambulances(String name,String number_plate,String capacity,String off_id,String slot_num)
    {
            this.setName(name);
            this.setCapacity(capacity);
            this.setVehicle_no_plate(number_plate);
            this.setVehice_id(this.ID_Generator("amb"));
            this.setPatients_saved(0);
            this.setStatus(false);
            this.setAvailable(true);
            this.setSlot_num(Integer.parseInt(slot_num));
            this.setType(this.getType()); 
            System.out.println(this.getSlot_num());
            System.out.println("in ambulance constructor");
    }

    public Ambulances() {
        //this.setName("asdasd");
        this.setVehice_id(this.ID_Generator("amb"));
    }
    
    
    @Override
    public String getType() {
        return "Ambulance";
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
