/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import DataStructures.LinkedList;
import DataStructures.RBTree;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;

/**
 *
 * @author m_nou
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminFrame
     */
    AmbulanceManagemenrSystem ams;
    String a;
    public AdminFrame() {
        initComponents();
        ams = AmbulanceManagemenrSystem.driver_instance();
        DisplayProfile();
        ok.setVisible(false);
        ok1.setVisible(false);
        oldPassword.setVisible(false);
        NewPassword.setVisible(false);
        OTP.setVisible(false);
        hidden.setVisible(false);
        CVnamePickerManger.setVisible(false);
        Recruit.setVisible(false);
    }

    private void DisplayProfile() {
        Admin a = Admin.admin_instance();
        NameLbl.setText(a.getName());
        Qualifcation.setText(a.getQualification());
        Salary.setText(a.getSalary());
        ContactNo.setText(a.getNumber());
        Email.setText(a.getEmail());
        Password.setText(a.getPassword());
        DOB1.setText(a.getDOB());
        Gender.setText(a.getGender());
        CNIC.setText(a.getCnic());
        int size = ams.getRes_off_list().size();
        TotalOffices.setText(size + "");
        int allot = 0;
        int free = 0;
        for (int i = 0; i < size; i++) {
            if (!ams.getRes_off_list().get(i).getManager_id().equals("-")) {
                allot++;
            } else {
                free++;
            }
        }
        
        File f = new File("..\\Ambulance Managemenr System\\src\\Images\\StaffPhoto\\"+a.getPic());
        try{
            BufferedImage img = null;
            img = ImageIO.read(new File(f.getAbsolutePath()));
            Image img1= img.getScaledInstance(jLabel15.getWidth(),jLabel15.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            jLabel15.setIcon(format);
        }
        catch(Exception e)
        {
        }
        Alloted.setText(allot + "");
        Available.setText(free + "");

    }

    // Method for edit
    private void ForEdit(int no) {
        if (no == 1) {
            NameLbl.setEditable(true);
            Qualifcation.setEditable(true);
            Salary.setEditable(true);
            ContactNo.setEditable(true);
            Email.setEditable(true);
            //Password.setEditable(true);
            DOB1.setEditable(true);
            Gender.setEditable(true);
            CNIC.setEditable(true);
            Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
            NameLbl.setBorder(border);
            Qualifcation.setBorder(border);
            Salary.setBorder(border);
            ContactNo.setBorder(border);
            Email.setBorder(border);
            DOB1.setBorder(border);
            Gender.setBorder(border);
            CNIC.setBorder(border);
            Password.setBorder(border);
        } else {
            NameLbl.setBorder(null);
            Qualifcation.setBorder(null);
            Salary.setBorder(null);
            ContactNo.setBorder(null);
            Email.setBorder(null);
            DOB1.setBorder(null);
            Gender.setBorder(null);
            CNIC.setBorder(null);
            //Password.setBorder(null);
        }

    }

    public String setProfilephoto(JLabel labl, String path) {

        JFileChooser chooser = new JFileChooser();
        Admin ad = Admin.admin_instance();
        FileFilter filter = new FileNameExtensionFilter("files", ImageIO.getReaderFileSuffixes());
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        
        File f = chooser.getSelectedFile();
        try {
            BufferedImage img = null;
            img = ImageIO.read(new File(f.getAbsolutePath()));
            Image img1 = img.getScaledInstance(labl.getWidth(), labl.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            labl.setIcon(format);
            String filePath = f.getAbsolutePath();
            //System.out.println(filePath);
            String fie = filePath.replace("\\", "/");
            //System.out.println(fie);
            String[] filename = fie.split("/");
            int size = filename.length;
            String Fname = filename[size - 1];
            
            ImageIO.write(img, "jpeg", new File("..\\Ambulance Managemenr System\\src\\Images\\StaffPhoto\\" + Fname));
            CVnamePickerManger.setText(Fname);
            hidden.setText(Fname);
            return Fname;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);

        }
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        BtnPanel = new javax.swing.JPanel();
        JobapplyBtn = new javax.swing.JLabel();
        JobapplyBtn1 = new javax.swing.JLabel();
        JobapplyBtn2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JobapplyBtn6 = new javax.swing.JLabel();
        LoginButtom2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ProfilePanel = new javax.swing.JPanel();
        LoginLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        DelPic = new javax.swing.JLabel();
        AddPic = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        TotalOffices = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        Alloted = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Available = new javax.swing.JLabel();
        LoginLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        EditInfo = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Qualifcation = new javax.swing.JTextField();
        NameLbl = new javax.swing.JTextField();
        Salary = new javax.swing.JTextField();
        CNIC = new javax.swing.JTextField();
        ContactNo = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Password = new javax.swing.JTextField();
        DOB1 = new javax.swing.JTextField();
        Gender = new javax.swing.JTextField();
        ok = new javax.swing.JLabel();
        chngPass = new javax.swing.JLabel();
        OTP = new javax.swing.JTextField();
        oldPassword = new javax.swing.JTextField();
        NewPassword = new javax.swing.JTextField();
        ok1 = new javax.swing.JLabel();
        hidden = new javax.swing.JLabel();
        Manager_panel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        LoginButtom1 = new javax.swing.JLabel();
        JobapplyBtn3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        RecruiteManager = new javax.swing.JPanel();
        jTextField26 = new javax.swing.JTextField();
        jSeparator47 = new javax.swing.JSeparator();
        jTextField27 = new javax.swing.JTextField();
        jSeparator48 = new javax.swing.JSeparator();
        jTextField28 = new javax.swing.JTextField();
        jSeparator49 = new javax.swing.JSeparator();
        jTextField29 = new javax.swing.JTextField();
        jSeparator50 = new javax.swing.JSeparator();
        jTextField22 = new javax.swing.JTextField();
        jSeparator43 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jSeparator46 = new javax.swing.JSeparator();
        jTextField23 = new javax.swing.JTextField();
        jSeparator45 = new javax.swing.JSeparator();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        LoginLabel1 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jSeparator52 = new javax.swing.JSeparator();
        JobapplyBtn4 = new javax.swing.JLabel();
        AttachFileLabel = new javax.swing.JLabel();
        AttachBttn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CVnamePickerManger = new javax.swing.JLabel();
        ViewManager = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        LoginLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        JobapplyBtn5 = new javax.swing.JLabel();
        Call_operator_panel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        LoginButtom3 = new javax.swing.JLabel();
        JobapplyBtn7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        RecruiteCallOper = new javax.swing.JPanel();
        Name = new javax.swing.JTextField();
        jSeparator51 = new javax.swing.JSeparator();
        lastName = new javax.swing.JTextField();
        jSeparator53 = new javax.swing.JSeparator();
        Cnic = new javax.swing.JTextField();
        jSeparator54 = new javax.swing.JSeparator();
        DOB = new javax.swing.JTextField();
        jSeparator55 = new javax.swing.JSeparator();
        ContcatNo = new javax.swing.JTextField();
        jSeparator44 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jSeparator56 = new javax.swing.JSeparator();
        salary1 = new javax.swing.JTextField();
        jSeparator57 = new javax.swing.JSeparator();
        jComboBox3 = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        LoginLabel4 = new javax.swing.JLabel();
        Email1 = new javax.swing.JTextField();
        jSeparator58 = new javax.swing.JSeparator();
        JobapplyBtn8 = new javax.swing.JLabel();
        AttachFileLabel1 = new javax.swing.JLabel();
        AttachBttn1 = new javax.swing.JButton();
        CancelBtn1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Recruit = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        ViewEditCall = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        LoginLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        JobapplyBtn9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(970, 540));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnPanel.setBackground(new java.awt.Color(29, 42, 53));
        BtnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JobapplyBtn.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn.setText("LogOut");
        JobapplyBtn.setOpaque(true);
        JobapplyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtnMouseExited(evt);
            }
        });
        BtnPanel.add(JobapplyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 180, 57));

        JobapplyBtn1.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn1.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn1.setText("Call Operators");
        JobapplyBtn1.setOpaque(true);
        JobapplyBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn1MouseExited(evt);
            }
        });
        BtnPanel.add(JobapplyBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 180, 57));

        JobapplyBtn2.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn2.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn2.setText("Reports");
        JobapplyBtn2.setOpaque(true);
        JobapplyBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn2MouseExited(evt);
            }
        });
        BtnPanel.add(JobapplyBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 180, 57));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-ambulance-90.png"))); // NOI18N
        BtnPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 110));

        JobapplyBtn6.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn6.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn6.setText("Chat Box");
        JobapplyBtn6.setOpaque(true);
        JobapplyBtn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn6MouseExited(evt);
            }
        });
        BtnPanel.add(JobapplyBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 180, 57));

        LoginButtom2.setBackground(new java.awt.Color(29, 42, 53));
        LoginButtom2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LoginButtom2.setForeground(new java.awt.Color(255, 255, 255));
        LoginButtom2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButtom2.setText("Manager");
        LoginButtom2.setOpaque(true);
        LoginButtom2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtom2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButtom2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginButtom2MouseExited(evt);
            }
        });
        BtnPanel.add(LoginButtom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 180, 57));

        getContentPane().add(BtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 180, 500));

        jPanel2.setBackground(new java.awt.Color(21, 32, 47));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ambulance Management System");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 235, 30));

        jLabel3.setBackground(new java.awt.Color(29, 42, 53));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 40, 40));

        jLabel6.setBackground(new java.awt.Color(29, 42, 53));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 52)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("-");
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 30, 40));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-users-30.png"))); // NOI18N
        jLabel17.setText("Profile");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 0, 90, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 40));

        ProfilePanel.setBackground(new java.awt.Color(255, 255, 255));
        ProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginLabel.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        LoginLabel.setForeground(new java.awt.Color(51, 51, 51));
        LoginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/id-cards.png"))); // NOI18N
        LoginLabel.setText("About");
        LoginLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        ProfilePanel.add(LoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 90, -1));
        ProfilePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 780, 10));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(153, 153, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DelPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        DelPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelPicMouseClicked(evt);
            }
        });
        jPanel4.add(DelPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 30, 30));

        AddPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/photo (1).png"))); // NOI18N
        AddPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddPicMouseClicked(evt);
            }
        });
        jPanel4.add(AddPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 30, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-users-30.png"))); // NOI18N
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 140));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel16.setText("Total Rescue_Offices");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 20));

        TotalOffices.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        TotalOffices.setText("00");
        jPanel7.add(TotalOffices, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 40, 30));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 240, 70));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel18.setText("Alloted Rescue_Offices");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 20));

        Alloted.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Alloted.setText("00");
        jPanel6.add(Alloted, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 40, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 240, 70));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel12.setText("Free Rescue_Offices");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 20));

        Available.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Available.setText("00");
        jPanel5.add(Available, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 40, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 240, 70));

        ProfilePanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 430));

        LoginLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        LoginLabel3.setForeground(new java.awt.Color(51, 51, 51));
        LoginLabel3.setText("Admin Profile");
        ProfilePanel.add(LoginLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, -1));

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Phone:");
        ProfilePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 50, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/location.png"))); // NOI18N
        jLabel10.setText(" Lahore, Punjab");
        ProfilePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel14.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Basic Informaation");
        ProfilePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 140, -1));

        jLabel20.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(111, 197, 197));
        jLabel20.setText("Projram Admin");
        ProfilePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 140, -1));

        jLabel21.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Email:");
        ProfilePanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 50, -1));

        jLabel23.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Password:");
        ProfilePanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 80, -1));

        jLabel25.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setText("Contact Informaation");
        ProfilePanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 140, -1));

        jLabel26.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("DOB:");
        ProfilePanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 50, -1));

        jLabel29.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Gender:");
        ProfilePanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 50, -1));

        jLabel30.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("CNIC:");
        ProfilePanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 50, -1));

        EditInfo.setBackground(new java.awt.Color(29, 42, 53));
        EditInfo.setFont(new java.awt.Font("Courier New", 3, 14)); // NOI18N
        EditInfo.setForeground(new java.awt.Color(255, 255, 255));
        EditInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EditInfo.setText("Edit Info.");
        EditInfo.setOpaque(true);
        EditInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditInfoMouseExited(evt);
            }
        });
        ProfilePanel.add(EditInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 90, 30));

        jLabel32.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Qualification:");
        ProfilePanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        jLabel34.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Salary:");
        ProfilePanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        Qualifcation.setEditable(false);
        Qualifcation.setBackground(new java.awt.Color(255, 255, 255));
        Qualifcation.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Qualifcation.setForeground(new java.awt.Color(111, 197, 197));
        Qualifcation.setText("Masters");
        Qualifcation.setBorder(null);
        Qualifcation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QualifcationActionPerformed(evt);
            }
        });
        ProfilePanel.add(Qualifcation, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 160, 20));

        NameLbl.setEditable(false);
        NameLbl.setBackground(new java.awt.Color(255, 255, 255));
        NameLbl.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        NameLbl.setForeground(new java.awt.Color(102, 102, 102));
        NameLbl.setText("Shrjel Ahmad");
        NameLbl.setBorder(null);
        NameLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameLblActionPerformed(evt);
            }
        });
        ProfilePanel.add(NameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 160, 20));

        Salary.setEditable(false);
        Salary.setBackground(new java.awt.Color(255, 255, 255));
        Salary.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Salary.setForeground(new java.awt.Color(111, 197, 197));
        Salary.setText("1M");
        Salary.setBorder(null);
        Salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaryActionPerformed(evt);
            }
        });
        ProfilePanel.add(Salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 160, 20));

        CNIC.setEditable(false);
        CNIC.setBackground(new java.awt.Color(255, 255, 255));
        CNIC.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        CNIC.setForeground(new java.awt.Color(111, 197, 197));
        CNIC.setText("3410169543321");
        CNIC.setBorder(null);
        CNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNICActionPerformed(evt);
            }
        });
        ProfilePanel.add(CNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 160, 20));

        ContactNo.setEditable(false);
        ContactNo.setBackground(new java.awt.Color(255, 255, 255));
        ContactNo.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        ContactNo.setForeground(new java.awt.Color(111, 197, 197));
        ContactNo.setText("+9231565428896");
        ContactNo.setBorder(null);
        ContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactNoActionPerformed(evt);
            }
        });
        ProfilePanel.add(ContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 160, 20));

        Email.setEditable(false);
        Email.setBackground(new java.awt.Color(255, 255, 255));
        Email.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Email.setForeground(new java.awt.Color(111, 197, 197));
        Email.setText("man_83jh@gmail.com");
        Email.setBorder(null);
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        ProfilePanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 160, 20));

        Password.setEditable(false);
        Password.setBackground(new java.awt.Color(255, 255, 255));
        Password.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Password.setForeground(new java.awt.Color(111, 197, 197));
        Password.setText("aksk#k5");
        Password.setBorder(null);
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        ProfilePanel.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 140, 20));

        DOB1.setEditable(false);
        DOB1.setBackground(new java.awt.Color(255, 255, 255));
        DOB1.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        DOB1.setForeground(new java.awt.Color(111, 197, 197));
        DOB1.setText("11-03-2000");
        DOB1.setBorder(null);
        DOB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOB1ActionPerformed(evt);
            }
        });
        ProfilePanel.add(DOB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 160, 20));

        Gender.setEditable(false);
        Gender.setBackground(new java.awt.Color(255, 255, 255));
        Gender.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        Gender.setForeground(new java.awt.Color(111, 197, 197));
        Gender.setText("MALE");
        Gender.setBorder(null);
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        ProfilePanel.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 160, 20));

        ok.setBackground(new java.awt.Color(29, 42, 53));
        ok.setFont(new java.awt.Font("Courier New", 3, 14)); // NOI18N
        ok.setForeground(new java.awt.Color(255, 255, 255));
        ok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ok.setText("Ok");
        ok.setOpaque(true);
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okMouseExited(evt);
            }
        });
        ProfilePanel.add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 90, 30));

        chngPass.setBackground(new java.awt.Color(29, 42, 53));
        chngPass.setFont(new java.awt.Font("Courier New", 3, 14)); // NOI18N
        chngPass.setForeground(new java.awt.Color(255, 255, 255));
        chngPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chngPass.setText("ChangePassword");
        chngPass.setOpaque(true);
        chngPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chngPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chngPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chngPassMouseExited(evt);
            }
        });
        ProfilePanel.add(chngPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 120, 30));

        OTP.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        OTP.setForeground(new java.awt.Color(102, 102, 102));
        OTP.setText("Enter OTP");
        OTP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        OTP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OTPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OTPFocusLost(evt);
            }
        });
        OTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OTPActionPerformed(evt);
            }
        });
        ProfilePanel.add(OTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 160, 20));

        oldPassword.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        oldPassword.setForeground(new java.awt.Color(102, 102, 102));
        oldPassword.setText("Enter old password");
        oldPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        oldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                oldPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                oldPasswordFocusLost(evt);
            }
        });
        oldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPasswordActionPerformed(evt);
            }
        });
        ProfilePanel.add(oldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 160, 20));

        NewPassword.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        NewPassword.setForeground(new java.awt.Color(102, 102, 102));
        NewPassword.setText("Enter new password");
        NewPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        NewPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NewPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NewPasswordFocusLost(evt);
            }
        });
        NewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPasswordActionPerformed(evt);
            }
        });
        ProfilePanel.add(NewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 160, 20));

        ok1.setBackground(new java.awt.Color(29, 42, 53));
        ok1.setFont(new java.awt.Font("Courier New", 3, 14)); // NOI18N
        ok1.setForeground(new java.awt.Color(255, 255, 255));
        ok1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ok1.setText("Ok");
        ok1.setOpaque(true);
        ok1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ok1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ok1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ok1MouseExited(evt);
            }
        });
        ProfilePanel.add(ok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 160, 20));

        hidden.setText("ds");
        ProfilePanel.add(hidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 80, -1));

        jTabbedPane1.addTab("tab1", ProfilePanel);

        Manager_panel.setBackground(new java.awt.Color(255, 255, 255));
        Manager_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        LoginButtom1.setBackground(new java.awt.Color(29, 42, 53));
        LoginButtom1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LoginButtom1.setForeground(new java.awt.Color(255, 255, 255));
        LoginButtom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButtom1.setText("Recruit Manager");
        LoginButtom1.setOpaque(true);
        LoginButtom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtom1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButtom1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginButtom1MouseExited(evt);
            }
        });

        JobapplyBtn3.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn3.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn3.setText("View/Edit manager");
        JobapplyBtn3.setOpaque(true);
        JobapplyBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn3MouseExited(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(29, 42, 53));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(LoginButtom1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(JobapplyBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginButtom1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JobapplyBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Manager_panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 790, 80));

        RecruiteManager.setBackground(new java.awt.Color(255, 255, 255));
        RecruiteManager.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField26.setText("Full Name");
        jTextField26.setBorder(null);
        jTextField26.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField26FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField26FocusLost(evt);
            }
        });
        RecruiteManager.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 260, 30));

        jSeparator47.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteManager.add(jSeparator47, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 260, 10));

        jTextField27.setText("Father Name");
        jTextField27.setBorder(null);
        jTextField27.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField27FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField27FocusLost(evt);
            }
        });
        RecruiteManager.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 260, 30));

        jSeparator48.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteManager.add(jSeparator48, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 260, 10));

        jTextField28.setText("CNIC");
        jTextField28.setBorder(null);
        jTextField28.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField28FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField28FocusLost(evt);
            }
        });
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        RecruiteManager.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 260, 30));

        jSeparator49.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteManager.add(jSeparator49, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 260, 10));

        jTextField29.setText("Date of Birth (DD-MM-YYYY)");
        jTextField29.setBorder(null);
        jTextField29.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField29FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField29FocusLost(evt);
            }
        });
        RecruiteManager.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 260, 30));

        jSeparator50.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteManager.add(jSeparator50, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 260, 10));

        jTextField22.setText("Contact Number");
        jTextField22.setBorder(null);
        jTextField22.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField22FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField22FocusLost(evt);
            }
        });
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        RecruiteManager.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 260, 30));

        jSeparator43.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteManager.add(jSeparator43, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 260, 10));

        jLabel1.setText("Gender:");
        RecruiteManager.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        RecruiteManager.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 50, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        RecruiteManager.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 60, -1));

        jSeparator46.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteManager.add(jSeparator46, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 260, 10));

        jTextField23.setText("Salary");
        jTextField23.setBorder(null);
        jTextField23.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField23FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField23FocusLost(evt);
            }
        });
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        RecruiteManager.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 260, 30));

        jSeparator45.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteManager.add(jSeparator45, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 260, 10));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Offices" }));
        RecruiteManager.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 260, -1));

        jSeparator2.setBackground(new java.awt.Color(29, 42, 53));
        jSeparator2.setForeground(new java.awt.Color(29, 42, 53));
        RecruiteManager.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 10));

        LoginLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LoginLabel1.setText("Details:");
        RecruiteManager.add(LoginLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTextField24.setText("Email");
        jTextField24.setBorder(null);
        jTextField24.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField24FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField24FocusLost(evt);
            }
        });
        RecruiteManager.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 260, 30));

        jSeparator52.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteManager.add(jSeparator52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 260, 10));

        JobapplyBtn4.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn4.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn4.setText("Recruit");
        JobapplyBtn4.setOpaque(true);
        JobapplyBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn4MouseExited(evt);
            }
        });
        RecruiteManager.add(JobapplyBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 120, 50));

        AttachFileLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecruiteManager.add(AttachFileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 150, 120));

        AttachBttn.setText("Attach");
        AttachBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttachBttnActionPerformed(evt);
            }
        });
        RecruiteManager.add(AttachBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, 20));

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        RecruiteManager.add(CancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel4.setText("Attach CV Here");
        RecruiteManager.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Manager has been added");
        RecruiteManager.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, -1));
        RecruiteManager.add(CVnamePickerManger, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 140, -1));

        jTabbedPane2.addTab("tab1", RecruiteManager);

        ViewManager.setBackground(new java.awt.Color(255, 255, 255));
        ViewManager.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Num", "Name", "CNIC", "Salary", "Rescue Office"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        ViewManager.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 720, 160));

        LoginLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LoginLabel2.setText("Details:");
        ViewManager.add(LoginLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(29, 42, 53));
        jSeparator3.setForeground(new java.awt.Color(29, 42, 53));
        ViewManager.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 10));

        JobapplyBtn5.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn5.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn5.setText("Delete");
        JobapplyBtn5.setOpaque(true);
        JobapplyBtn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn5MouseExited(evt);
            }
        });
        ViewManager.add(JobapplyBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 120, 50));

        jTabbedPane2.addTab("tab2", ViewManager);

        Manager_panel.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 790, 450));

        jTabbedPane1.addTab("tab2", Manager_panel);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        LoginButtom3.setBackground(new java.awt.Color(29, 42, 53));
        LoginButtom3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LoginButtom3.setForeground(new java.awt.Color(255, 255, 255));
        LoginButtom3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButtom3.setText("Recruit Call Oper.");
        LoginButtom3.setOpaque(true);
        LoginButtom3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtom3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButtom3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginButtom3MouseExited(evt);
            }
        });

        JobapplyBtn7.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn7.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn7.setText("View/Edit ");
        JobapplyBtn7.setOpaque(true);
        JobapplyBtn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn7MouseExited(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(29, 42, 53));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(LoginButtom3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(JobapplyBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButtom3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JobapplyBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RecruiteCallOper.setBackground(new java.awt.Color(255, 255, 255));
        RecruiteCallOper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setText("First Name");
        Name.setBorder(null);
        Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameFocusLost(evt);
            }
        });
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 260, 30));

        jSeparator51.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteCallOper.add(jSeparator51, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 260, 10));

        lastName.setText("Last Name");
        lastName.setBorder(null);
        lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameFocusLost(evt);
            }
        });
        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 260, 30));

        jSeparator53.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteCallOper.add(jSeparator53, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 260, 10));

        Cnic.setText("CNIC");
        Cnic.setBorder(null);
        Cnic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CnicFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CnicFocusLost(evt);
            }
        });
        Cnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CnicActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(Cnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 260, 30));

        jSeparator54.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteCallOper.add(jSeparator54, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 260, 10));

        DOB.setText("Date of Birth (DD-MM-YYYY)");
        DOB.setBorder(null);
        DOB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DOBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DOBFocusLost(evt);
            }
        });
        RecruiteCallOper.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 260, 30));

        jSeparator55.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteCallOper.add(jSeparator55, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 260, 10));

        ContcatNo.setText("Contact Number");
        ContcatNo.setBorder(null);
        ContcatNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ContcatNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ContcatNoFocusLost(evt);
            }
        });
        ContcatNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContcatNoActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(ContcatNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 260, 30));

        jSeparator44.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteCallOper.add(jSeparator44, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 260, 10));

        jLabel9.setText("Gender:");
        RecruiteCallOper.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Male");
        RecruiteCallOper.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 50, -1));

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Female");
        RecruiteCallOper.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 60, -1));

        jSeparator56.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteCallOper.add(jSeparator56, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 260, 10));

        salary1.setText("Salary");
        salary1.setBorder(null);
        salary1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                salary1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                salary1FocusLost(evt);
            }
        });
        salary1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salary1ActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(salary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 260, 30));

        jSeparator57.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteCallOper.add(jSeparator57, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 260, 10));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Evening", "Night" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 260, -1));

        jSeparator4.setBackground(new java.awt.Color(29, 42, 53));
        jSeparator4.setForeground(new java.awt.Color(29, 42, 53));
        RecruiteCallOper.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 10));

        LoginLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LoginLabel4.setText("Details:");
        RecruiteCallOper.add(LoginLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        Email1.setText("Email");
        Email1.setBorder(null);
        Email1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Email1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Email1FocusLost(evt);
            }
        });
        RecruiteCallOper.add(Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 260, 30));

        jSeparator58.setForeground(new java.awt.Color(0, 0, 0));
        RecruiteCallOper.add(jSeparator58, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 260, 10));

        JobapplyBtn8.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn8.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn8.setText("Recruit");
        JobapplyBtn8.setOpaque(true);
        JobapplyBtn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn8MouseExited(evt);
            }
        });
        RecruiteCallOper.add(JobapplyBtn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 120, 50));

        AttachFileLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecruiteCallOper.add(AttachFileLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 150, 120));

        AttachBttn1.setText("Attach");
        AttachBttn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttachBttn1ActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(AttachBttn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, 20));

        CancelBtn1.setText("Cancel");
        CancelBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtn1ActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(CancelBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel11.setText("Profile Photo");
        RecruiteCallOper.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, -1, -1));

        Recruit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Recruit.setForeground(new java.awt.Color(75, 167, 75));
        Recruit.setText("Call Oper. has been added");
        RecruiteCallOper.add(Recruit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FSc", "MSc" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        RecruiteCallOper.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 260, -1));

        jTabbedPane3.addTab("tab1", RecruiteCallOper);

        ViewEditCall.setBackground(new java.awt.Color(255, 255, 255));
        ViewEditCall.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Num", "Name", "CNIC", "Employee ID", " Office Name"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        ViewEditCall.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 720, 160));

        LoginLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LoginLabel5.setText("Details:");
        ViewEditCall.add(LoginLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(29, 42, 53));
        jSeparator5.setForeground(new java.awt.Color(29, 42, 53));
        ViewEditCall.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 10));

        JobapplyBtn9.setBackground(new java.awt.Color(29, 42, 53));
        JobapplyBtn9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        JobapplyBtn9.setForeground(new java.awt.Color(255, 255, 255));
        JobapplyBtn9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JobapplyBtn9.setText("Delete");
        JobapplyBtn9.setOpaque(true);
        JobapplyBtn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobapplyBtn9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JobapplyBtn9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JobapplyBtn9MouseExited(evt);
            }
        });
        ViewEditCall.add(JobapplyBtn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 120, 50));

        jTabbedPane3.addTab("tab2", ViewEditCall);

        javax.swing.GroupLayout Call_operator_panelLayout = new javax.swing.GroupLayout(Call_operator_panel);
        Call_operator_panel.setLayout(Call_operator_panelLayout);
        Call_operator_panelLayout.setHorizontalGroup(
            Call_operator_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Call_operator_panelLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
            .addGroup(Call_operator_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Call_operator_panelLayout.createSequentialGroup()
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
        );
        Call_operator_panelLayout.setVerticalGroup(
            Call_operator_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Call_operator_panelLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 422, Short.MAX_VALUE))
            .addGroup(Call_operator_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", Call_operator_panel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 790, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JobapplyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        LoginFrame g = new LoginFrame();
        g.setVisible(true);
    }//GEN-LAST:event_JobapplyBtnMouseClicked

    private void JobapplyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtnMouseEntered
        // TODO add your handling code here:
        JobapplyBtn.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_JobapplyBtnMouseEntered

    private void JobapplyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtnMouseExited
        // TODO add your handling code here:
        JobapplyBtn.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_JobapplyBtnMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        LoginFrame ab = new LoginFrame();
        ab.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        jLabel3.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:

        this.setState(LoginFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
        jLabel6.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_jLabel6MouseExited

    private void JobapplyBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn1MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_JobapplyBtn1MouseClicked

    private void JobapplyBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn1MouseEntered
        // TODO add your handling code here:

        JobapplyBtn1.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_JobapplyBtn1MouseEntered

    private void JobapplyBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn1MouseExited
        // TODO add your handling code here:

        JobapplyBtn1.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_JobapplyBtn1MouseExited

    private void JobapplyBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn2MouseClicked

    private void JobapplyBtn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn2MouseEntered
        // TODO add your handling code here:

        JobapplyBtn2.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_JobapplyBtn2MouseEntered

    private void JobapplyBtn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn2MouseExited
        // TODO add your handling code here:
        JobapplyBtn2.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_JobapplyBtn2MouseExited

    private void LoginButtom1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtom1MouseEntered

    private void LoginButtom1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtom1MouseExited


    private void JobapplyBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn3MouseClicked
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(1);
        ams.deleteAllTableRows(jTable1);
        //LinkedList<Person> list = RBTree.GetNodeOfSameType("Manager", ams.getProfiles_tree().getRoot());
        for (int i = 0; i < ams.getPerson_list().size(); i++) {
            if (ams.getPerson_list().get(i).getType().equals("Manager")) {
                Manager mr = (Manager) ams.getPerson_list().get(i);
                String emp_num = mr.getEmploye_number() + "";
                String data[] = {emp_num, mr.getName(), mr.getCnic(), mr.getSalary(), mr.getRes_off_id()};
                DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();

                tblmodel.addRow(data);
            }

        }
        //jTable1.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_JobapplyBtn3MouseClicked

    private void JobapplyBtn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn3MouseEntered

    private void JobapplyBtn3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn3MouseExited

    private void jTextField26FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField26FocusGained
        // TODO add your handling code here:
        if (jTextField26.getText().equals("Full Name")) {
            jTextField26.setText("");
        }
    }//GEN-LAST:event_jTextField26FocusGained

    private void jTextField26FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField26FocusLost
        // TODO add your handling code here:
        if (jTextField26.getText().equals("")) {
            jTextField26.setText("Full Name");
        }
    }//GEN-LAST:event_jTextField26FocusLost

    private void jTextField27FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField27FocusGained
        // TODO add your handling code here:
        if (jTextField27.getText().equals("Father Name")) {
            jTextField27.setText("");
        }
    }//GEN-LAST:event_jTextField27FocusGained

    private void jTextField27FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField27FocusLost
        // TODO add your handling code here:
        if (jTextField27.getText().equals("")) {
            jTextField27.setText("Father Name");
        }
    }//GEN-LAST:event_jTextField27FocusLost

    private void jTextField28FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField28FocusGained
        // TODO add your handling code here:
        if (jTextField28.getText().equals("CNIC")) {
            jTextField28.setText("");
        }
    }//GEN-LAST:event_jTextField28FocusGained

    private void jTextField28FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField28FocusLost
        // TODO add your handling code here:
        if (jTextField28.getText().equals("")) {
            jTextField28.setText("CNIC");
        }
    }//GEN-LAST:event_jTextField28FocusLost

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField29FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField29FocusGained
        // TODO add your handling code here:
        if (jTextField29.getText().equals("Date of Birth (DD-MM-YYYY)")) {
            jTextField29.setText("");
        }
    }//GEN-LAST:event_jTextField29FocusGained

    private void jTextField29FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField29FocusLost
        // TODO add your handling code here:
        if (jTextField29.getText().equals("")) {
            jTextField29.setText("Date of Birth (DD-MM-YYYY)");
        }
    }//GEN-LAST:event_jTextField29FocusLost

    private void jTextField22FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusGained
        // TODO add your handling code here:
        if (jTextField22.getText().equals("Contact Number")) {
            jTextField22.setText("");
        }
    }//GEN-LAST:event_jTextField22FocusGained

    private void jTextField22FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusLost
        // TODO add your handling code here:
        if (jTextField22.getText().equals("")) {
            jTextField22.setText("Contact Number");
        }
    }//GEN-LAST:event_jTextField22FocusLost

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField23FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField23FocusGained
        // TODO add your handling code here:
        if (jTextField23.getText().equals("Salary")) {
            jTextField23.setText("");
        }
    }//GEN-LAST:event_jTextField23FocusGained

    private void jTextField23FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField23FocusLost
        // TODO add your handling code here:
        if (jTextField23.getText().equals("")) {
            jTextField23.setText("Salary");
        }
    }//GEN-LAST:event_jTextField23FocusLost

    private void jTextField24FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField24FocusGained
        // TODO add your handling code here:
        if (jTextField24.getText().equals("Email")) {
            jTextField24.setText("");
        }
    }//GEN-LAST:event_jTextField24FocusGained

    private void jTextField24FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField24FocusLost
        // TODO add your handling code here:
        if (jTextField24.getText().equals("")) {
            jTextField24.setText("Email");
        }
    }//GEN-LAST:event_jTextField24FocusLost

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void JobapplyBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn4MouseClicked
        // TODO add your handling code here:

        String name = jTextField26.getText();
        String fathername = jTextField27.getText();
        String cnin = jTextField28.getText();
        String dob = jTextField29.getText();
        String number = jTextField22.getText();
        String email = jTextField24.getText();
        String salary = jTextField23.getText();
        String gender;
        if (jRadioButton1.isSelected()) {
            gender = jRadioButton1.getText();
        } else {
            gender = jRadioButton2.getText();
        }
        String[] offs = jComboBox2.getSelectedItem().toString().split(",");
        String off_id = offs[1];

        if (name != "Full Name" && fathername != "Father Name" && cnin != "CNIC" && dob != "Date of Birth (DD-MM-YYYY)" && number != "Contact Number"
                && email != "Email" && salary != "Salary") {
            Person pr = new Manager(name, fathername, cnin, dob, number, email, salary, off_id,this.a);

            for (int i = 0; i < ams.getRes_off_list().size(); i++) {
                if (ams.getRes_off_list().get(i).getRescue_off_id().equals(off_id)) {
                    ams.getRes_off_list().get(i).setManager_id(pr.getId_number());
                    break;
                }
            }
            System.out.println(pr.getName());
            System.out.println(pr.getEmploye_number());
            Manager n = (Manager) pr;
            for (int i = 0; i < ams.getRes_off_list().size(); i++) {
            if (ams.getRes_off_list().get(i).getManager_id().equals("-")) {
                String ss = ams.getRes_off_list().get(i).getName() + "," + ams.getRes_off_list().get(i).getRescue_off_id();
                jComboBox2.addItem(ss);
            }
        }
            System.out.println(n.getRes_off_id());
            ams.getPerson_list().insert(pr);
            jLabel7.setVisible(true);
            jLabel7.setForeground(new java.awt.Color(41, 168, 72));
            jLabel7.setText("Manager Has Been Added");
            jTextField26.setText("Full Name");
            jTextField27.setText("Father Name");
            jTextField28.setText("CNIC");
            jTextField29.setText("Date of Birth (DD-MM-YYYY)");
            jTextField22.setText("Contact Number");
            jTextField23.setText("Salary");
            jTextField24.setText("Email");
        }
    }//GEN-LAST:event_JobapplyBtn4MouseClicked

    private void JobapplyBtn4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn4MouseEntered

    private void JobapplyBtn4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn4MouseExited

    private void LoginButtom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom1MouseClicked
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(0);
        jComboBox2.removeAllItems();
        for (int i = 0; i < ams.getRes_off_list().size(); i++) {
            if (ams.getRes_off_list().get(i).getManager_id().equals("-")) {
                String ss = ams.getRes_off_list().get(i).getName() + "," + ams.getRes_off_list().get(i).getRescue_off_id();
                jComboBox2.addItem(ss);
            }
        }
    }//GEN-LAST:event_LoginButtom1MouseClicked

    private void AttachBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttachBttnActionPerformed
        // TODO add your handling code here:
        String path = "StaffPhoto";
        String picname = setProfilephoto(AttachFileLabel, path);
        this.a = picname;
        
    }//GEN-LAST:event_AttachBttnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:

        AttachFileLabel.setIcon(null);
        String io = CVnamePickerManger.getText();
        File f = new File("..\\Ambulance Managemenr System\\src\\Images\\" + io);
        f.delete();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void JobapplyBtn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn5MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRowCount() == 1) {
            int rowIndex = jTable1.getSelectedRow();
            int emp_num = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
            String off_id = model.getValueAt(rowIndex, 4).toString();
            ams.getPerson_list().remove(emp_num - 1);
            //ams.getProfiles_tree().deleteNode(emp_num);
            model.removeRow(rowIndex);
            for (int i = 0; i < ams.getRes_off_list().size(); i++) {
                if (ams.getRes_off_list().get(i).getRescue_off_id().equals(off_id)) {
                    ams.getRes_off_list().get(i).setRescue_off_id("");
                    break;
                }
            }

        }

    }//GEN-LAST:event_JobapplyBtn5MouseClicked

    private void JobapplyBtn5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn5MouseEntered

    private void JobapplyBtn5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn5MouseExited

    private void JobapplyBtn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn6MouseClicked

    private void JobapplyBtn6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn6MouseEntered

    private void JobapplyBtn6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn6MouseExited

    private void LoginButtom2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom2MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        jComboBox2.removeAllItems();
        for (int i = 0; i < ams.getRes_off_list().size(); i++) {
            if (ams.getRes_off_list().get(i).getManager_id().equals("-")) {
                String ss = ams.getRes_off_list().get(i).getName() + "," + ams.getRes_off_list().get(i).getRescue_off_id();
                jComboBox2.addItem(ss);
            }
        }
    }//GEN-LAST:event_LoginButtom2MouseClicked

    private void LoginButtom2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom2MouseEntered
        // TODO add your handling code here:
        LoginButtom2.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_LoginButtom2MouseEntered

    private void LoginButtom2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom2MouseExited
        // TODO add your handling code here:
        LoginButtom2.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_LoginButtom2MouseExited

    private void EditInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditInfoMouseClicked
        // TODO add your handling code here:
        ForEdit(1);
        ok.setVisible(true);
    }//GEN-LAST:event_EditInfoMouseClicked

    private void EditInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditInfoMouseEntered
        // TODO add your handling code here:
        EditInfo.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_EditInfoMouseEntered

    private void EditInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditInfoMouseExited
        // TODO add your handling code here:
        EditInfo.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_EditInfoMouseExited

    private void QualifcationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QualifcationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QualifcationActionPerformed

    private void NameLblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameLblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameLblActionPerformed

    private void SalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalaryActionPerformed

    private void CNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNICActionPerformed

    private void ContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactNoActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void DOB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOB1ActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseClicked
        // TODO add your handling code here:
        // SAving updated data in the adminn 
        Admin a = Admin.admin_instance();
        a.setName(NameLbl.getText());
        a.setDOB(DOB1.getText());
        a.setCnic(CNIC.getText());
        a.setEmail(Email.getText());
        a.setGender(Gender.getText());
        a.setSalary(Salary.getText());
        //a.setPassword(Password.getText());
        a.setNumber(ContactNo.getText());
        a.setQualification(Qualifcation.getText());
        ok.setVisible(false);
        NameLbl.setEditable(false);
        DOB1.setEditable(false);
        CNIC.setEditable(false);
        Email.setEditable(false);
        Gender.setEditable(false);
        Salary.setEditable(false);
        //Password.setEditable(false);
        ContactNo.setEditable(false);
        Qualifcation.setEditable(false);
        ForEdit(2);
        System.out.println("Admin's info successfuly updated!");
    }//GEN-LAST:event_okMouseClicked

    private void okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseEntered
        // TODO add your handling code here:
        ok.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_okMouseEntered

    private void okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseExited
        // TODO add your handling code here:
        ok.setBackground(new java.awt.Color(29, 12, 53));
    }//GEN-LAST:event_okMouseExited

    private void chngPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chngPassMouseClicked
        // TODO add your handling code here:
        oldPassword.setVisible(true);
        NewPassword.setVisible(true);
        OTP.setVisible(true);
        ok1.setVisible(true);


    }//GEN-LAST:event_chngPassMouseClicked

    private void chngPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chngPassMouseEntered
        // TODO add your handling code here:
        chngPass.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_chngPassMouseEntered

    private void chngPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chngPassMouseExited
        // TODO add your handling code here:
        chngPass.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_chngPassMouseExited

    private void OTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OTPActionPerformed

    private void oldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPasswordActionPerformed

    private void NewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewPasswordActionPerformed

    private void ok1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok1MouseClicked
        // TODO add your handling code here:
        Admin a = Admin.admin_instance();
        String pas = a.getPassword();
        if (oldPassword.getText().equals(pas) && OTP.getText().equals("1234")) {
            String neww = NewPassword.getText();
            a.setPassword(neww);
            System.out.println("New Password updated");
        }
        oldPassword.setVisible(false);
        NewPassword.setVisible(false);
        OTP.setVisible(false);
        ok1.setVisible(false);
    }//GEN-LAST:event_ok1MouseClicked

    private void ok1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok1MouseEntered
        // TODO add your handling code here:
        ok1.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_ok1MouseEntered

    private void ok1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok1MouseExited
        // TODO add your handling code here:
        ok1.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_ok1MouseExited

    private void oldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldPasswordFocusGained
        // TODO add your handling code here:
        if (oldPassword.getText().equals("Enter old password")) {
            oldPassword.setText("");
        }
    }//GEN-LAST:event_oldPasswordFocusGained

    private void oldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldPasswordFocusLost
        // TODO add your handling code here:
        if (oldPassword.getText().equals("")) {
            oldPassword.setText("Enter old password");
        }
    }//GEN-LAST:event_oldPasswordFocusLost

    private void NewPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewPasswordFocusGained
        // TODO add your handling code here:
        if (NewPassword.getText().equals("Enter new password")) {
            NewPassword.setText("");
        }
    }//GEN-LAST:event_NewPasswordFocusGained

    private void NewPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewPasswordFocusLost
        // TODO add your handling code here:
        if (NewPassword.getText().equals("")) {
            NewPassword.setText("Enter new password");
        }
    }//GEN-LAST:event_NewPasswordFocusLost

    private void OTPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OTPFocusGained
        // TODO add your handling code here:
        if (OTP.getText().equals("Enter OTP")) {
            OTP.setText("");
        }
    }//GEN-LAST:event_OTPFocusGained

    private void OTPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OTPFocusLost
        // TODO add your handling code here:
        if (OTP.getText().equals("")) {
            OTP.setText("Enter OTP");
        }
    }//GEN-LAST:event_OTPFocusLost

    private void AddPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPicMouseClicked
        // TODO add your handling code here:
        
        Admin ad = Admin.admin_instance();
        String path = "AdminPhoto";
        String picname = setProfilephoto(jLabel15, path);
        ad.setPic(picname);
        
    }//GEN-LAST:event_AddPicMouseClicked

    private void DelPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelPicMouseClicked
        // TODO add your handling code here:
        String iok = hidden.getText();
        //System.out.println(io);
        File f = new File("..\\Ambulance Managemenr System\\src\\Images\\AdminPhoto\\" + iok);
        f.delete();
        hidden.setText("");
        jLabel15.setIcon(null);
    }//GEN-LAST:event_DelPicMouseClicked

    private void LoginButtom3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom3MouseClicked
        // TODO add your handling code here:
        jTabbedPane3.setSelectedIndex(0);
    }//GEN-LAST:event_LoginButtom3MouseClicked

    private void LoginButtom3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom3MouseEntered
        // TODO add your handling code here:
        LoginButtom3.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_LoginButtom3MouseEntered

    private void LoginButtom3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom3MouseExited
        // TODO add your handling code here:
        LoginButtom3.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_LoginButtom3MouseExited

    private void JobapplyBtn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn7MouseClicked
        // TODO add your handling code here:
        jTabbedPane3.setSelectedIndex(1);
        ams.deleteAllTableRows(jTable2);
        for (int i = 0; i < ams.getCenter().getCall_operators().size(); i++) {
            Call_operator cal = (Call_operator) ams.getCenter().getCall_operators().get(i);
            String arr[] = {cal.getEmploye_number() + "", cal.getName(), cal.getCnic(), cal.getId_number(), ams.getCenter().getCenter_name()};
            DefaultTableModel tblmodel = (DefaultTableModel) jTable2.getModel();
            tblmodel.addRow(arr);
        }
    }//GEN-LAST:event_JobapplyBtn7MouseClicked

    private void JobapplyBtn7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn7MouseEntered
        // TODO add your handling code here:
        JobapplyBtn7.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_JobapplyBtn7MouseEntered

    private void JobapplyBtn7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn7MouseExited
        // TODO add your handling code here:
        JobapplyBtn7.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_JobapplyBtn7MouseExited

    private void NameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFocusGained
        // TODO add your handling code here:
        if (Name.getText().equals("First Name")) {
            Name.setText("");
        }
    }//GEN-LAST:event_NameFocusGained

    private void NameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFocusLost
        // TODO add your handling code here:
        if (Name.getText().equals("")) {
            Name.setText("First Name");
        }
    }//GEN-LAST:event_NameFocusLost

    private void lastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFocusGained
        // TODO add your handling code here:
        if (lastName.getText().equals("Last Name")) {
            lastName.setText("");
        }
    }//GEN-LAST:event_lastNameFocusGained

    private void lastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFocusLost
        // TODO add your handling code here:
        if (lastName.getText().equals("")) {
            lastName.setText("Last Name");
        }
    }//GEN-LAST:event_lastNameFocusLost

    private void CnicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CnicFocusGained
        // TODO add your handling code here:
        if (Cnic.getText().equals("CNIC")) {
            Cnic.setText("");
        }
    }//GEN-LAST:event_CnicFocusGained

    private void CnicFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CnicFocusLost
        // TODO add your handling code here:
        if (Cnic.getText().equals("")) {
            Cnic.setText("CNIC");
        }
    }//GEN-LAST:event_CnicFocusLost

    private void CnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CnicActionPerformed

    private void DOBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DOBFocusGained
        // TODO add your handling code here:
        if (DOB.getText().equals("Date of Birth (DD-MM-YYYY)")) {
            DOB.setText("");
        }
    }//GEN-LAST:event_DOBFocusGained

    private void DOBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DOBFocusLost
        // TODO add your handling code here:
        if (DOB.getText().equals("")) {
            DOB.setText("Date of Birth (DD-MM-YYYY)");
        }
    }//GEN-LAST:event_DOBFocusLost

    private void ContcatNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContcatNoFocusGained
        // TODO add your handling code here:
        if (ContcatNo.getText().equals("Contact Number")) {
            ContcatNo.setText("");
        }
    }//GEN-LAST:event_ContcatNoFocusGained

    private void ContcatNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContcatNoFocusLost
        // TODO add your handling code here:
        if (ContcatNo.getText().equals("")) {
            ContcatNo.setText("Contact Number");
        }
    }//GEN-LAST:event_ContcatNoFocusLost

    private void ContcatNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContcatNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContcatNoActionPerformed

    private void salary1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salary1FocusGained
        // TODO add your handling code here:
        if (salary1.getText().equals("Salary")) {
            salary1.setText("");
        }
    }//GEN-LAST:event_salary1FocusGained

    private void salary1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salary1FocusLost
        // TODO add your handling code here:
        if (salary1.getText().equals("")) {
            salary1.setText("Salary");
        }
    }//GEN-LAST:event_salary1FocusLost

    private void salary1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salary1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salary1ActionPerformed

    private void Email1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email1FocusGained
        // TODO add your handling code here:
        if (Email1.getText().equals("Email")) {
            Email1.setText("");
        }
    }//GEN-LAST:event_Email1FocusGained

    private void Email1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email1FocusLost
        // TODO add your handling code here:
        if (Email1.getText().equals("")) {
            Email1.setText("Email");
        }
    }//GEN-LAST:event_Email1FocusLost

    private void JobapplyBtn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn8MouseClicked
        // TODO add your handling code here:
        String name = Name.getText();
        String fathername = lastName.getText();
        String cnin = Cnic.getText();
        String dob = DOB.getText();
        String number = ContcatNo.getText();
        String email = Email1.getText();
        String salary = salary1.getText();
        String gender;
        if (jRadioButton3.isSelected()) {
            gender = jRadioButton3.getText();
        } else {
            gender = jRadioButton4.getText();
        }
        String offs = (String) jComboBox3.getSelectedItem();
        String qual = (String) jComboBox4.getSelectedItem();
        System.out.println(offs);
        String cert = hidden.getText();
        ams.setEmployee_instances();
        int emNo = ams.getEmployee_instances();
        if (name != "First Name" && fathername != "Last Name" && cnin != "CNIC" && dob != "Date of Birth (DD-MM-YYYY)" && number != "Contact Number"
                && email != "Email" && salary != "Salary") {
            Person pr = new Call_operator(name, fathername, cnin, email, dob, salary, cert, qual, number, offs, gender, emNo);
            System.out.println(pr.getName());
            System.out.println(pr.getEmploye_number());
            Call_operator cop = (Call_operator) pr;
            String ID = cop.ID_Generator(name, emNo);
            String PAS = cop.Password_generator();
            pr.setPassword(PAS);
            pr.setId_number(ID);
            ams.getCenter().getCall_operators().insert(pr);
            Recruit.setVisible(true);
            Recruit.setForeground(new java.awt.Color(75, 167, 75));
            Recruit.setText("Call Oper.Has Been Added");
            Name.setText("Full Name");
            lastName.setText("Father Name");
            Cnic.setText("CNIC");
            DOB.setText("Date of Birth (DD-MM-YYYY)");
            ContactNo.setText("Contact Number");
            salary1.setText("Salary");
            Email1.setText("Email");
            ContcatNo.setText("Contact Number");
            Recruit.setVisible(false);
            AttachFileLabel1.setIcon(null);

        }
    }//GEN-LAST:event_JobapplyBtn8MouseClicked

    private void JobapplyBtn8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn8MouseEntered

    private void JobapplyBtn8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JobapplyBtn8MouseExited

    private void AttachBttn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttachBttn1ActionPerformed
        // TODO add your handling code here:
        String path = "StaffPhoto";
        setProfilephoto(AttachFileLabel1, path);
    }//GEN-LAST:event_AttachBttn1ActionPerformed

    private void CancelBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtn1ActionPerformed
        // TODO add your handling code here:
        String iok = hidden.getText();
        //System.out.println(io);
        File f = new File("..\\Ambulance Managemenr System\\src\\Images\\StaffPhoto\\" + iok);
        f.delete();
        hidden.setText("");
        AttachFileLabel1.setIcon(null);
    }//GEN-LAST:event_CancelBtn1ActionPerformed

    private void JobapplyBtn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn9MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        if (jTable2.getSelectedRowCount() == 1) {
            int rowIndex = jTable2.getSelectedRow();
            // int emp_num =Integer.parseInt(model.getValueAt(rowIndex, 0).toString()) ;
            //String off_id =  model.getValueAt(rowIndex, 4).toString();
            String man_id = model.getValueAt(rowIndex, 3).toString();
            //ams.getPerson_list().remove_person(man_id);
            ams.getCenter().getCall_operators().remove_person(man_id);

            //ams.getProfiles_tree().deleteNode(emp_num);
            model.removeRow(rowIndex);
//            for (int i = 0; i < ams.getRes_off_list().size(); i++) {
//            if (ams.getRes_off_list().get(i).getRescue_off_id().equals(off_id)) {
//                ams.getRes_off_list().get(i).setManager_id("-");
//                break;
//            }
//        }
        }
    }//GEN-LAST:event_JobapplyBtn9MouseClicked

    private void JobapplyBtn9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn9MouseEntered
        // TODO add your handling code here:
        JobapplyBtn9.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_JobapplyBtn9MouseEntered

    private void JobapplyBtn9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobapplyBtn9MouseExited
        // TODO add your handling code here:
        JobapplyBtn9.setBackground(new java.awt.Color(23, 42, 53));
    }//GEN-LAST:event_JobapplyBtn9MouseExited

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        DisplayProfile();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddPic;
    private javax.swing.JLabel Alloted;
    private javax.swing.JButton AttachBttn;
    private javax.swing.JButton AttachBttn1;
    private javax.swing.JLabel AttachFileLabel;
    private javax.swing.JLabel AttachFileLabel1;
    private javax.swing.JLabel Available;
    private javax.swing.JPanel BtnPanel;
    private javax.swing.JTextField CNIC;
    private javax.swing.JLabel CVnamePickerManger;
    private javax.swing.JPanel Call_operator_panel;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton CancelBtn1;
    private javax.swing.JTextField Cnic;
    private javax.swing.JTextField ContactNo;
    private javax.swing.JTextField ContcatNo;
    private javax.swing.JTextField DOB;
    private javax.swing.JTextField DOB1;
    private javax.swing.JLabel DelPic;
    private javax.swing.JLabel EditInfo;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Email1;
    private javax.swing.JTextField Gender;
    private javax.swing.JLabel JobapplyBtn;
    private javax.swing.JLabel JobapplyBtn1;
    private javax.swing.JLabel JobapplyBtn2;
    private javax.swing.JLabel JobapplyBtn3;
    private javax.swing.JLabel JobapplyBtn4;
    private javax.swing.JLabel JobapplyBtn5;
    private javax.swing.JLabel JobapplyBtn6;
    private javax.swing.JLabel JobapplyBtn7;
    private javax.swing.JLabel JobapplyBtn8;
    private javax.swing.JLabel JobapplyBtn9;
    private javax.swing.JLabel LoginButtom1;
    private javax.swing.JLabel LoginButtom2;
    private javax.swing.JLabel LoginButtom3;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel LoginLabel1;
    private javax.swing.JLabel LoginLabel2;
    private javax.swing.JLabel LoginLabel3;
    private javax.swing.JLabel LoginLabel4;
    private javax.swing.JLabel LoginLabel5;
    private javax.swing.JPanel Manager_panel;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField NameLbl;
    private javax.swing.JTextField NewPassword;
    private javax.swing.JTextField OTP;
    private javax.swing.JTextField Password;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JTextField Qualifcation;
    private javax.swing.JLabel Recruit;
    private javax.swing.JPanel RecruiteCallOper;
    private javax.swing.JPanel RecruiteManager;
    private javax.swing.JTextField Salary;
    private javax.swing.JLabel TotalOffices;
    private javax.swing.JPanel ViewEditCall;
    private javax.swing.JPanel ViewManager;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel chngPass;
    private javax.swing.JLabel hidden;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator48;
    private javax.swing.JSeparator jSeparator49;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator50;
    private javax.swing.JSeparator jSeparator51;
    private javax.swing.JSeparator jSeparator52;
    private javax.swing.JSeparator jSeparator53;
    private javax.swing.JSeparator jSeparator54;
    private javax.swing.JSeparator jSeparator55;
    private javax.swing.JSeparator jSeparator56;
    private javax.swing.JSeparator jSeparator57;
    private javax.swing.JSeparator jSeparator58;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel ok;
    private javax.swing.JLabel ok1;
    private javax.swing.JTextField oldPassword;
    private javax.swing.JTextField salary1;
    // End of variables declaration//GEN-END:variables
}
