/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import DataStructures.LinkedList;
/**
 *
 * @author m_nou
 */
public class Resues_offices {
    private String name;
    private String address;
    private String rescue_off_id;
    private String manager_id;
    private int ambulance_limit;
    private int bike_limit;
    private int fire_limit;
    private int drivers_limit;
    private int emts_limit;
    private LinkedList<Vehicles> vehi_detail;

    public void reset()
    {
        this.rescue_off_id = null;
    }
    public Resues_offices()
    {
        this.ambulance_limit = 0;
        this.bike_limit = 0;
        this.fire_limit = 0;
        this.rescue_off_id = null;
    }
    public Resues_offices(int a) {
        this.name = "asdads";
        this.rescue_off_id = "Res-123";
        this.manager_id = "";
    }
    public Resues_offices(String a) {
        this.name = "qwe";
        this.rescue_off_id = "Res-456";
        this.manager_id = "";
    }
    
    public void incre_amb()
    {
    this.ambulance_limit++;
    }
    public void incre_bike()
    {
    this.ambulance_limit++;
    }
    public void incr_fire()
    {
    this.ambulance_limit++;
    }
public void updateVehicle(Vehicles ve)
{
    this.vehi_detail.insert(ve);
}
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRescue_off_id() {
        return rescue_off_id;
    }

    public String getManager_id() {
        return manager_id;
    }

    public int getAmbulance_limit() {
        return ambulance_limit;
    }

    public int getBike_limit() {
        return bike_limit;
    }

    public int getFire_limit() {
        return fire_limit;
    }

    public int getDrivers_limit() {
        return drivers_limit;
    }

    public int getEmts_limit() {
        return emts_limit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRescue_off_id(String rescue_off_id) {
        this.rescue_off_id = rescue_off_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public void setAmbulance_limit(int ambulance_limit) {
        this.ambulance_limit = ambulance_limit;
    }

    public void setBike_limit(int bike_limit) {
        this.bike_limit = bike_limit;
    }

    public void setFire_limit(int fire_limit) {
        this.fire_limit = fire_limit;
    }

    public void setDrivers_limit(int drivers_limit) {
        this.drivers_limit = drivers_limit;
    }

    public void setEmts_limit(int emts_limit) {
        this.emts_limit = emts_limit;
    }

    public void setVehi_detail(LinkedList<Vehicles> vehi_detail) {
        this.vehi_detail = vehi_detail;
    }

    
    public LinkedList<Vehicles> getVehi_detail() {
        return vehi_detail;
    }
    
    public boolean update_vehicle(Vehicles v,String index)
    {
        for(int i=0;i< this.vehi_detail.size(); i++)
        {
            Vehicles vv = this.vehi_detail.get(i);
            if(v.getVehice_id().equals(index))
            {
                System.out.println("hello");
                this.vehi_detail.set(v,i);
            }
        }
    return true;
    }
    
    
}
