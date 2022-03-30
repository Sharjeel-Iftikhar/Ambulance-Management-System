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
public class Vehicles {
    private String name;
    private String vehicle_no_plate;
    private String vehice_id;
    private String capacity;
    private int patients_saved;
    private boolean status;
    private boolean available;
    private String type;
    private int slot_num;

    public int getSlot_num() {
        return slot_num;
    }

    public void setSlot_num(int slot_num) {
        this.slot_num = slot_num;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isAvailable() {
        return available;
    }

    
    public String getName() {
        return name;
    }

    public String getVehicle_no_plate() {
        return vehicle_no_plate;
    }

    public String getVehice_id() {
        return vehice_id;
    }

    public int getPatients_saved() {
        return patients_saved;
    }

    public String getType() {
        return type;
    }

    public String getCapacity() {
        return capacity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setVehicle_no_plate(String vehicle_no_plate) {
        this.vehicle_no_plate = vehicle_no_plate;
    }

    public void setVehice_id(String vehice_id) {
        this.vehice_id = vehice_id;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setPatients_saved(int patients_saved) {
        this.patients_saved = patients_saved;
    }


    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
