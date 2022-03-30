/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import DataStructures.LinkedList;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author m_nou
 */
public class JobFrame extends javax.swing.JFrame {

    /**
     * Creates new form JobFrame
     */
    
    AmbulanceManagemenrSystem ams;
    Person per;
    int marks=0;
    int number=0;
    public JobFrame() {
        initComponents();
        ams = AmbulanceManagemenrSystem.driver_instance();
        jLabel4.setVisible(false);
        LoadQuestions("Driver");
        LoadQuestions("Emergency Medical Technician");
    }
    // Method to display the questions
    private void displayQuestion(String type,int no)
    {
    // Displaying Question
        InitialTest inn;
        Warning.setVisible(false);
        totalMarks.setVisible(false);
        int sz = ams.getIniTest().size();
        while(no!=sz)
        {
            inn=(InitialTest) ams.getIniTest().getatIndex(no);
            if(inn.getType().equals(type))
            {
                QNo.setText("Question #"+no+1);
                jTextArea1.setText(inn.getQuestion());
                opt1.setText(inn.getOp1());
                opt2.setText(inn.getOp2());
                opt3.setText(inn.getOp3());
                opt4.setText(inn.getOp4());
                int n = no+1;
                if(n<sz)
                {
                    inn = (InitialTest) ams.getIniTest().getatIndex(n);
                    if (inn.getType().equals(type)) {
                        QNo.setText("Question #" + n);
                        buttonGroup1.clearSelection();
                        break;
                    }
                    else
                    {
                      QNo.setText("Last Question");
                    buttonGroup1.clearSelection();
                    break; 
                    }
                }
                else
                {
                    QNo.setText("Last Question");
                    buttonGroup1.clearSelection();
                    break;
                }
            }
            else
            {no++;}
        }
        // Setting action command on radio btns
        String atopt1 = opt1.getText();
        String atopt2 = opt2.getText();
        String atopt3 = opt3.getText();
        String atopt4 = opt4.getText();
        opt1.setActionCommand(atopt1);
        opt2.setActionCommand(atopt2);
        opt3.setActionCommand(atopt3);
        opt4.setActionCommand(atopt4);
        
    }
    // Method to save marks of driver
    private void saveMarks(int marks)
    {
        String type = jComboBox2.getSelectedItem()+"";
        if(type.equals("Driver"))
        {
            Drivers dr = (Drivers)this.per;
            dr.setRecruit_test_marks(marks);
            ams.getApliQueue().EnQueue(per);
            System.out.println("Marks & object has been saved");
        }
        else if(type.equals("Emergency Medical Technician"))
        {
            EMT emt = (EMT)this.per;
            emt.setRecruit_test_marks(marks);
            ams.getApliQueue().EnQueue(per);
            System.out.println("Marks & object has been saved");
        }
    }
    
    // Load Questions from file
    private void LoadQuestions(String type)
    {
                InitialTest in;
        // FileHandling reading questions from csv file
        try
        {
           System.out.println(type);
           BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("..\\Ambulance Managemenr System\\src\\DataStored\\Questions.csv"),"UTF-8"));
           String line="";
           while( (line = read.readLine()) != null)
           {
              String arr[] = line.split(",");
              String t=arr[0];
              if(t.equals(type))
              {
                 in = new InitialTest(arr[1],type,arr[2],arr[3],arr[4],arr[5],arr[6]);
                 ams.getIniTest().insert(in);
              }
              
           }
        }
        catch(Exception ex)
        {
           System.out.println("File not found");
         if(this.per.getType().equals("Driver"))
        {
        Drivers dr = (Drivers)this.per;
        dr.setRecruit_test_marks(marks);
        ams.getApliQueue().EnQueue(per);
        System.out.println("Marks & object has been saved");
    
        }
        else
        {
            EMT dr = (EMT)this.per;
        dr.setRecruit_test_marks(marks);
        ams.getApliQueue().EnQueue(per);
        System.out.println("Marks & object has been saved");
    
        }
    }
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        LoginLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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
        jTextField23 = new javax.swing.JTextField();
        jSeparator45 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator46 = new javax.swing.JSeparator();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSeparator51 = new javax.swing.JSeparator();
        LoginButtom = new javax.swing.JLabel();
        LoginButtom1 = new javax.swing.JLabel();
        AttachFileLabel = new javax.swing.JLabel();
        CancelBtn = new javax.swing.JButton();
        AttachBttn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        InitailTest = new javax.swing.JPanel();
        LoginLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        LoginLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        QNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        opt1 = new javax.swing.JRadioButton();
        opt2 = new javax.swing.JRadioButton();
        opt3 = new javax.swing.JRadioButton();
        opt4 = new javax.swing.JRadioButton();
        LoginButtom2 = new javax.swing.JLabel();
        LoginButtom3 = new javax.swing.JLabel();
        Warning = new javax.swing.JLabel();
        totalMarks = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(21, 32, 47));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ambulance Management System");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 235, 30));

        jLabel3.setBackground(new java.awt.Color(29, 42, 53));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
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
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 30));

        jLabel6.setBackground(new java.awt.Color(29, 42, 53));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
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
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 30, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LoginLabel.setText("Job Apply Form");
        jPanel1.add(LoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(29, 42, 53));
        jSeparator1.setForeground(new java.awt.Color(29, 42, 53));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 10));

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
        jPanel1.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 260, 30));

        jSeparator47.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator47, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 260, 10));

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
        jPanel1.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 260, 20));

        jSeparator48.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator48, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 260, 10));

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
        jPanel1.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 260, 20));

        jSeparator49.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator49, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 260, 10));

        jTextField29.setText("Date of Birth");
        jTextField29.setBorder(null);
        jTextField29.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField29FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField29FocusLost(evt);
            }
        });
        jPanel1.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 260, 20));

        jSeparator50.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator50, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 260, 10));

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
        jPanel1.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 260, 30));

        jSeparator43.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator43, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 260, 10));

        jTextField23.setText("Email");
        jTextField23.setBorder(null);
        jTextField23.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField23FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField23FocusLost(evt);
            }
        });
        jPanel1.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 260, 30));

        jSeparator45.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator45, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 260, 10));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 50, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 60, -1));

        jLabel1.setText("Gender:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matric", "FS.c", "Bachelor", "Masters" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 260, -1));

        jSeparator46.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator46, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 260, 10));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Driver", "Emergency Medical Technician" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 260, -1));

        jSeparator51.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator51, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 260, 10));

        LoginButtom.setBackground(new java.awt.Color(29, 42, 53));
        LoginButtom.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LoginButtom.setForeground(new java.awt.Color(255, 255, 255));
        LoginButtom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButtom.setText("Back to Login");
        LoginButtom.setOpaque(true);
        LoginButtom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginButtomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginButtomMouseExited(evt);
            }
        });
        jPanel1.add(LoginButtom, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 130, 50));

        LoginButtom1.setBackground(new java.awt.Color(29, 42, 53));
        LoginButtom1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LoginButtom1.setForeground(new java.awt.Color(255, 255, 255));
        LoginButtom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButtom1.setText("Start Test");
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
        jPanel1.add(LoginButtom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 130, 50));

        AttachFileLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(AttachFileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 150, 120));

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, -1, 20));

        AttachBttn.setText("Attach");
        AttachBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttachBttnActionPerformed(evt);
            }
        });
        jPanel1.add(AttachBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, -1, 20));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 130, -1));

        jTabbedPane1.addTab("tab1", jPanel1);

        InitailTest.setBackground(new java.awt.Color(255, 255, 255));
        InitailTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InitailTestMouseClicked(evt);
            }
        });
        InitailTest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LoginLabel1.setText("Time: 300 sec");
        InitailTest.add(LoginLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(29, 42, 53));
        jSeparator2.setForeground(new java.awt.Color(29, 42, 53));
        InitailTest.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 10));

        LoginLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        LoginLabel2.setText("Initial Test:");
        InitailTest.add(LoginLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, -1));

        jSeparator3.setBackground(new java.awt.Color(29, 42, 53));
        jSeparator3.setForeground(new java.awt.Color(29, 42, 53));
        InitailTest.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 10));

        QNo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        QNo.setText("Ques:");
        InitailTest.add(QNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Question  here?\n");
        jScrollPane1.setViewportView(jTextArea1);

        InitailTest.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 610, 70));

        buttonGroup1.add(opt1);
        opt1.setText("Option # 1");
        opt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt1MouseClicked(evt);
            }
        });
        opt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1ActionPerformed(evt);
            }
        });
        InitailTest.add(opt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        buttonGroup1.add(opt2);
        opt2.setText("Option # 2");
        InitailTest.add(opt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        buttonGroup1.add(opt3);
        opt3.setText("Option # 3");
        opt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3ActionPerformed(evt);
            }
        });
        InitailTest.add(opt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        buttonGroup1.add(opt4);
        opt4.setText("Option # 4");
        InitailTest.add(opt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        LoginButtom2.setBackground(new java.awt.Color(29, 42, 53));
        LoginButtom2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LoginButtom2.setForeground(new java.awt.Color(255, 255, 255));
        LoginButtom2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButtom2.setText("Submit Test");
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
        InitailTest.add(LoginButtom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 130, 50));

        LoginButtom3.setBackground(new java.awt.Color(29, 42, 53));
        LoginButtom3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        LoginButtom3.setForeground(new java.awt.Color(255, 255, 255));
        LoginButtom3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButtom3.setText("Next Question");
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
        InitailTest.add(LoginButtom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 130, 50));

        Warning.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Warning.setForeground(new java.awt.Color(255, 0, 0));
        Warning.setText("Plz first choose any option to Proceed!");
        InitailTest.add(Warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 250, 20));

        totalMarks.setText("marks");
        InitailTest.add(totalMarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 440, 90, -1));

        jTabbedPane1.addTab("tab2", InitailTest);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
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
        if (jTextField29.getText().equals("Date of Birth")) {
            jTextField29.setText("");
        }
    }//GEN-LAST:event_jTextField29FocusGained

    private void jTextField29FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField29FocusLost
        // TODO add your handling code here:
        if (jTextField29.getText().equals("")) {
            jTextField29.setText("Date of Birth");
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
        if (jTextField23.getText().equals("Email")) {
            jTextField23.setText("");
        }
    }//GEN-LAST:event_jTextField23FocusGained

    private void jTextField23FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField23FocusLost
        // TODO add your handling code here:
        if (jTextField23.getText().equals("")) {
            jTextField23.setText("Email");
        }
    }//GEN-LAST:event_jTextField23FocusLost

    private void LoginButtomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtomMouseEntered
        // TODO add your handling code here:
        LoginButtom.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_LoginButtomMouseEntered

    private void LoginButtomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtomMouseExited
        // TODO add your handling code here:
        LoginButtom.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_LoginButtomMouseExited

    private void LoginButtom1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom1MouseEntered
        // TODO add your handling code here:
        LoginButtom1.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_LoginButtom1MouseEntered

    private void LoginButtom1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom1MouseExited
        // TODO add your handling code here:
        LoginButtom1.setBackground(new java.awt.Color(29, 42, 53));
    }//GEN-LAST:event_LoginButtom1MouseExited

    private void LoginButtomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtomMouseClicked
        // TODO add your handling code here:
        LoginFrame lo = new LoginFrame();
        lo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LoginButtomMouseClicked

    private void opt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt1ActionPerformed

    private void opt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt3ActionPerformed

    private void LoginButtom2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom2MouseEntered
        // TODO add your handling code here:
        LoginButtom2.setBackground(new java.awt.Color(102, 102, 102));

    }//GEN-LAST:event_LoginButtom2MouseEntered

    private void LoginButtom2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom2MouseExited
        // TODO add your handling code here:
        LoginButtom2.setBackground(new java.awt.Color(29, 42, 53));

    }//GEN-LAST:event_LoginButtom2MouseExited

    private void LoginButtom3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom3MouseClicked
        // TODO add your handling code here:
        try{
            
            String check = buttonGroup1.getSelection().getActionCommand();
            Warning.setVisible(false);
            String Qno = QNo.getText();
            InitialTest in;
            String typee = jComboBox2.getSelectedItem()+"";
            if (Qno != "Last Question") {
                String[] arr = Qno.split("#");
                int no = Integer.parseInt(arr[1]);
                this.number = no;
                in=(InitialTest) ams.getIniTest().getatIndex(no-1);
                String cor=in.getCorrect();
                if(check.equals(cor))
                {
                    marks = marks + 10;
                    System.out.println("Marks Added");
                }
                displayQuestion(typee,no);
            } else {
//                int size = ams.getIniTest().size();
//                displayQuestion(typee,size - 1);
                in=(InitialTest) ams.getIniTest().getatIndex(number);
                if(check.equals(in.getCorrect()))
                {
                    marks = marks+10;
                }
                LoginButtom3.setVisible(false);
            }
            String m = marks+"";
            totalMarks.setText(m);
        }
        catch(Exception ex){
             Warning.setVisible(true);
             System.out.println("Plz first select one option!!");
        }
    }//GEN-LAST:event_LoginButtom3MouseClicked

    private void LoginButtom3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom3MouseEntered
        // TODO add your handling code here:
        LoginButtom3.setBackground(new java.awt.Color(102, 102, 102));
    }//GEN-LAST:event_LoginButtom3MouseEntered

    private void LoginButtom3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom3MouseExited
        // TODO add your handling code here:
        LoginButtom3.setBackground(new java.awt.Color(29, 42, 53));

    }//GEN-LAST:event_LoginButtom3MouseExited

    private void LoginButtom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom1MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        // Displaying Questions
        String name = jTextField26.getText();
        String fname = jTextField27.getText();
        String cnic = jTextField28.getText();
        String dob = jTextField29.getText();
        String no = jTextField22.getText();
        String gender="Female";
        if(jRadioButton1.isSelected())
        {
            gender = "Male";
        }
        String email = jTextField23.getText();
        String field = jComboBox2.getItemAt(0);
        String pic = jLabel4.getText();
        String type = jComboBox2.getSelectedItem().toString();
        displayQuestion(type,0);
        if(type.equals("Driver"))
        {
            Person Apli = new Drivers(field,name,fname,cnic,dob,gender,email,no,pic);
            this.per = Apli;
        }
        else
        {
            Person Apli = new EMT(field,name,fname,cnic,dob,gender,email,no,pic);
            this.per = Apli;
        }
        
         //ams.getApliQueue().EnQueue(Apli);

        

        
    }//GEN-LAST:event_LoginButtom1MouseClicked

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        AttachFileLabel.setIcon(null);
        String io = "me.jpg";
        //BufferedImage imgg = ImageIO.read(new File("..\\Ambulance Managemenr System\\src\\Images\\"+io));
        File f = new File("..\\Ambulance Managemenr System\\src\\Images\\"+io);
        f.delete();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void AttachBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttachBttnActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("files", ImageIO.getReaderFileSuffixes());
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        try{
            BufferedImage img = null;
            img = ImageIO.read(new File(f.getAbsolutePath()));
            Image img1= img.getScaledInstance(AttachFileLabel.getWidth(),AttachFileLabel.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            AttachFileLabel.setIcon(format);
            String filePath =  f.getAbsolutePath();
            //System.out.println(filePath);
            String fie = filePath.replace("\\","/");
            //System.out.println(fie);
            String[] filename = fie.split("/");
            int size = filename.length;
            String Fname = filename[size-1];
            jLabel4.setText(Fname);
            ImageIO.write(img, "jpeg", new File("..\\Ambulance Managemenr System\\src\\Images\\"+Fname));
            
            
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
          
        }
        
        
        
    }//GEN-LAST:event_AttachBttnActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void InitailTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InitailTestMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_InitailTestMouseClicked

    private void opt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_opt1MouseClicked

    private void LoginButtom2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtom2MouseClicked
        // TODO add your handling code here:
        String ll = totalMarks.getText();
        int m = Integer.parseInt(ll);
        saveMarks(m);
        this.setVisible(false);
        LoginFrame fr = new LoginFrame();
        fr.setVisible(true);
    }//GEN-LAST:event_LoginButtom2MouseClicked

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
            java.util.logging.Logger.getLogger(JobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AttachBttn;
    private javax.swing.JLabel AttachFileLabel;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JPanel InitailTest;
    private javax.swing.JLabel LoginButtom;
    private javax.swing.JLabel LoginButtom1;
    private javax.swing.JLabel LoginButtom2;
    private javax.swing.JLabel LoginButtom3;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel LoginLabel1;
    private javax.swing.JLabel LoginLabel2;
    private javax.swing.JLabel QNo;
    private javax.swing.JLabel Warning;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator48;
    private javax.swing.JSeparator jSeparator49;
    private javax.swing.JSeparator jSeparator50;
    private javax.swing.JSeparator jSeparator51;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JRadioButton opt1;
    private javax.swing.JRadioButton opt2;
    private javax.swing.JRadioButton opt3;
    private javax.swing.JRadioButton opt4;
    private javax.swing.JLabel totalMarks;
    // End of variables declaration//GEN-END:variables
}
