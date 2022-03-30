/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import DataStructures.LinkedList;
import DataStructures.RBTree;
import java.awt.Color;
import DataStructures.LinkedList;
import java.io.*;
import java.util.Scanner;
import DataStructures.Queue;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author m_nou
 */
public class AmbulanceManagemenrSystem {

    private static AmbulanceManagemenrSystem AMS;

    //private RBTree profiles_tree = new RBTree();
    private LinkedList<Person> person_list = new LinkedList<>();
    private LinkedList<Resues_offices> res_off_list = new LinkedList<>();
    private LinkedList<InitialTest> IniTest = new LinkedList();
    private Queue<Person> ApliQueue = new Queue();
    private int vehicle_instances = 0;
    private int employee_instances = 0;
    private Call_Center center = Call_Center.get_CallCenterInstance();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        AmbulanceManagemenrSystem ams = AmbulanceManagemenrSystem.driver_instance();

        Admin.readadmin();
        load_person();
        load_apply();
        ams.readOffices();
        
        LoginFrame g = new LoginFrame();
        g.setVisible(true);

    }

    public static AmbulanceManagemenrSystem driver_instance() {
        if (AMS == null) {
            AMS = new AmbulanceManagemenrSystem();
        }
        return AMS;
    }

    private AmbulanceManagemenrSystem() {
    }

    public static String getPersonType(String email) {
        try {
            String[] arr = email.split("\\@");
            String[] arr2 = arr[1].split("\\.");
            return arr2[0];
        } catch (Exception e) {
            return "null";
        }

    }
    
    public void save_apply() throws IOException
    {
        File file = new File(
                    "..\\Ambulance Managemenr System\\src\\DataStored\\applyData");
        FileOutputStream filee = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(filee);
              
            // Method for serialization of object
            out.writeObject(this.ApliQueue);
              
            out.close();
            filee.close();
    }
    
    public static void load_apply() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        File file = new File(
                    "..\\Ambulance Managemenr System\\src\\DataStored\\applyData");
            FileInputStream filee = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(filee);
              
            // Method for deserialization of object
            AmbulanceManagemenrSystem ams = AmbulanceManagemenrSystem.driver_instance();
            ams.ApliQueue = (Queue < Person >)in.readObject();
              
            in.close();
            filee.close();
    }
    
    public void save_person() throws IOException
    {
        File file = new File(
                    "..\\Ambulance Managemenr System\\src\\DataStored\\personsData");
        FileOutputStream filee = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(filee);
              
            // Method for serialization of object
            out.writeObject(this.person_list);
              
            out.close();
            filee.close();
    }
    public static void load_person() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        File file = new File(
                    "..\\Ambulance Managemenr System\\src\\DataStored\\personsData");
            FileInputStream filee = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(filee);
              
            // Method for deserialization of object
            AmbulanceManagemenrSystem ams = AmbulanceManagemenrSystem.driver_instance();
            ams.person_list = (LinkedList<Person>)in.readObject();
              
            in.close();
            filee.close();
    }

    public LinkedList getIniTest() {
        return IniTest;
    }

//    public RBTree getProfiles_tree() {
//        return profiles_tree;
//    }
    public LinkedList<Resues_offices> getRes_off_list() {
        return res_off_list;
    }

    public int getVehicle_instances() {
        return vehicle_instances;
    }

    public int getEmployee_instances() {
        return employee_instances;
    }

    public void setVehicle_instances() {
        this.vehicle_instances++;
    }

    public void setEmployee_instances() {
        this.employee_instances++;
    }
    public void decEmployee_instance()
    {
        this.employee_instances--;
    }

    public LinkedList<Person> getPerson_list() {
        return person_list;
    }

    public void deleteAllTableRows(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    while( model.getRowCount() > 0 ){
        model.removeRow(0);
    }
    }
    public void readOffices() {
        try {
            File file = new File(
                    "..\\Ambulance Managemenr System\\src\\DataStored\\Res_Offices.txt");
            Scanner myReader = new Scanner(file);
            String data = myReader.nextLine();
            String[] parts = data.split("=");
            Resues_offices res = new Resues_offices();
            while (myReader.hasNextLine()) {

                    res = new Resues_offices();
                    res.reset();
                    res.setName(parts[1]);
                    res.setAddress(parts[2]);
                    res.setRescue_off_id(parts[3]);
                    res.setManager_id(parts[4]);
                    res.setAmbulance_limit(Integer.parseInt(parts[5]));
                                  
                    res.setBike_limit(Integer.parseInt(parts[6]));
                                  
                    res.setFire_limit(Integer.parseInt(parts[7]));
                                   
                    res.setDrivers_limit(Integer.parseInt(parts[8]));
                                   
                    res.setEmts_limit(Integer.parseInt(parts[9]));
                                   
                    System.out.println(res.getRescue_off_id());
                    data = myReader.nextLine();
                    parts = data.split("=");
                    LinkedList<Vehicles> ve = new LinkedList<>();
                    while (parts[0].equals("Vehicle")) {

                        if (parts[8].equals("Ambulance")) {

                            Vehicles veh = new Ambulances();
                            veh.setName(parts[1]);

                            veh.setVehicle_no_plate(parts[2]);
                            veh.setVehice_id(parts[3]);
                            veh.setCapacity(parts[4].toString());
                            veh.setPatients_saved(Integer.parseInt(parts[5]));
                            veh.setStatus(Boolean.parseBoolean(parts[6]));
                            veh.setPatients_saved(Integer.parseInt(parts[7]));
                            ve.insert(veh);
                        } else if (parts[8].equals("Bike")) {
                            Vehicles veh = new Bike();
                            veh.setName(parts[1]);
                            veh.setVehicle_no_plate(parts[2]);
                            veh.setVehice_id(parts[3]);
                            veh.setCapacity(parts[4].toString());
                            veh.setPatients_saved(Integer.parseInt(parts[5]));
                            veh.setStatus(Boolean.parseBoolean(parts[6]));
                            veh.setPatients_saved(Integer.parseInt(parts[7]));

                            ve.insert(veh);
                        } else {
                            Vehicles veh = new Ambulances();
                            veh.setName(parts[1]);
                            veh.setVehicle_no_plate(parts[2]);
                            veh.setVehice_id(parts[3]);
                            veh.setCapacity(parts[4].toString());
                            veh.setPatients_saved(Integer.parseInt(parts[5]));
                            veh.setStatus(Boolean.parseBoolean(parts[6]));
                            veh.setPatients_saved(Integer.parseInt(parts[7]));

                            ve.insert(veh);
                        }

                        data = myReader.nextLine();
                        parts = data.split("=");

                    }
                    res.setVehi_detail(ve);
                    System.out.println(res.getRescue_off_id());
                    AMS.res_off_list.insert(res);

                
            }
            myReader.close();
        } catch (Exception e) {

            System.out.println(e);
        }

    }

    public Queue<Person> getApliQueue() {
        return ApliQueue;
    }

    public Call_Center getCenter() {
        return center;
    }
    
}
