/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persondatabase;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.File;

/**
 * //Wajeeha Kashif   Roll No:18L-1204    Section: BCS-6A
//This program is address book that adds, deletes search and update person data
 */
public class PersonDatabase extends JFrame implements ActionListener {
 
    JFrame f;
    JLabel Heading,Name, Cnic, Gender, Address, Phone,PreviousName;
    JTextField Nametxt, Cnictxt, Gendertxt, Addresstxt, Phonetxt,PreviousNametxt;
    JButton InsertButton,DeleteButton,SearchName,SearchCNIC,UpdateButton,Insert,Delete,Search,Update,SearchByNameButton,SearchByCNICButton;
    
    public void HomePage(){

        ImageIcon iconA = new ImageIcon("background.jpg");
        //getContentPane().setBackground(new Color(20,37,64));
        Image image = iconA.getImage(); // transform it
        Image newimg = image.getScaledInstance(850, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        iconA = new ImageIcon(newimg);

        setContentPane(new JLabel(iconA));
        
        Heading = new JLabel("WHAT DO YOU WANT TO CHOOSE");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        Insert = new JButton("Insert");
        Insert.setBounds(230, 100, 100, 20);
        Insert.addActionListener(this);
        
        Delete = new JButton("Delete");
        Delete.setBounds(230, 200, 100, 20);
        Delete.addActionListener(this);
        
        Search = new JButton("Search");
        Search.setBounds(230, 300, 100, 20);
        Search.addActionListener(this);
        
        Update = new JButton("Update");
        Update.setBounds(230, 400, 100, 20);
        Update.addActionListener(this);
        

        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(Insert);
        add(Delete);
        add(Search);
        add(Update);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        
    }
    
    public void insertRecord(){

        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("INSERT RECORDS INTO DATABASE");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        Name = new JLabel("Enter Name:");
        Name.setBounds(20, 90, 100, 20);
        Name.setForeground(Color.white);
        Nametxt = new JTextField(20);
        Nametxt.setBounds(130, 90, 200, 20);

        Cnic = new JLabel("Enter CNIC");
        Cnic.setForeground(Color.white);
        Cnic.setBounds(20, 120, 100, 20);
        Cnictxt = new JTextField(50);
        Cnictxt.setBounds(130, 120, 200, 20);

        Gender = new JLabel("Enter Gender:");
        Gender.setForeground(Color.white);
        Gender.setBounds(20, 150, 100, 20);
        Gendertxt = new JTextField(100);
        Gendertxt.setBounds(130, 150, 200, 20);

        Address = new JLabel("Enter Address:");
        Address.setForeground(Color.white);
        Address.setBounds(20, 180, 100, 20);
        Addresstxt = new JTextField(50);
        Addresstxt.setBounds(130, 180, 200, 20);

        Phone = new JLabel("Enter Phone:");
        Phone.setForeground(Color.white);
        Phone.setBounds(20, 210, 100, 20);
        Phonetxt = new JTextField(50);
        Phonetxt.setBounds(130, 210, 100, 20);

        InsertButton = new JButton("Insert");
        InsertButton.setBounds(130, 300, 100, 20);
        InsertButton.addActionListener(this);

        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(Name);
        add(Nametxt);
        add(Cnic);
        add(Cnictxt);
        add(Gender);
        add(Gendertxt);
        add(Address);
        add(Addresstxt);
        add(Phone);
        add(Phonetxt);
        add(InsertButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    public void deleteRecord(){

        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("DELETE RECORDS FROM DATABASE");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        Name = new JLabel("Enter Name:");
        Name.setBounds(20, 90, 100, 20);
        Name.setForeground(Color.white);
        Nametxt = new JTextField(20);
        Nametxt.setBounds(130, 90, 200, 20);


        DeleteButton = new JButton("Delete");
        DeleteButton.setBounds(130, 180, 100, 20);
        DeleteButton.addActionListener(this);

        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(Name);
        add(Nametxt);
        add(DeleteButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    //asks the user whether to search by name or by cnic
    public void SearchRecord(){
    
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("HOW DO YOU WANT TO SEARCH? ");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        SearchByNameButton = new JButton("SearchByName");
        SearchByNameButton.setBounds(230, 180, 200, 20);
        SearchByNameButton.addActionListener(this);
        
        SearchByCNICButton = new JButton("SearchByCNIC");
        SearchByCNICButton.setBounds(230, 280, 200, 20);
        SearchByCNICButton.addActionListener(this);

        setLayout(null);
        
        //Add components to the JFrame
        add(Heading);
        add(SearchByNameButton);
        add(SearchByCNICButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void SearchRecordByName(){

        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("SEARCH RECORDS IN DATABASE");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        Name = new JLabel("Enter Name:");
        Name.setBounds(20, 90, 100, 20);
        Name.setForeground(Color.white);
        Nametxt = new JTextField(20);
        Nametxt.setBounds(130, 90, 200, 20);


        SearchName = new JButton("Search");
        SearchName.setBounds(130, 180, 100, 20);
        SearchName.addActionListener(this);

        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(Name);
        add(Nametxt);
        add(SearchName);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void SearchRecordByCNIC(){

        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("SEARCH RECORDS IN DATABASE");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        Cnic = new JLabel("Enter CNIC:");
        Cnic.setBounds(20, 90, 100, 20);
        Cnic.setForeground(Color.white);
        Cnictxt = new JTextField(20);
        Cnictxt.setBounds(130, 90, 200, 20);


        SearchCNIC = new JButton("Search");
        SearchCNIC.setBounds(130, 180, 100, 20);
        SearchCNIC.addActionListener(this);

        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(Cnic);
        add(Cnictxt);
        add(SearchCNIC);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
     public void displayRow(String s,int i)
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel(s);
        Heading.setBounds(280, 220+i, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        add(Heading);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }

    
    public void displayFound()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("FOUND!!");
        Heading.setBounds(280, 220, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        add(Heading);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void displayNotFound()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("NOT FOUND!!");
        Heading.setBounds(275, 220, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        add(Heading);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    //updates record of person
    public void updateRecords(){

        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("UPDATE RECORDS OF DATABASE");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        PreviousName = new JLabel("Enter Previous Name:");
        PreviousName.setBounds(20, 60, 100, 20);
        PreviousName.setForeground(Color.white);
        PreviousNametxt = new JTextField(20);
        PreviousNametxt.setBounds(130, 60, 200, 20);

        Name = new JLabel("Enter Name:");
        Name.setBounds(20, 90, 100, 20);
        Name.setForeground(Color.white);
        Nametxt = new JTextField(20);
        Nametxt.setBounds(130, 90, 200, 20);

        Cnic = new JLabel("Enter CNIC");
        Cnic.setBounds(20, 120, 100, 20);
        Cnic.setForeground(Color.white);
        Cnictxt = new JTextField(50);
        Cnictxt.setBounds(130, 120, 200, 20);

        Gender = new JLabel("Enter Gender:");
        Gender.setForeground(Color.white);
        Gender.setBounds(20, 150, 100, 20);
        Gendertxt = new JTextField(100);
        Gendertxt.setBounds(130, 150, 200, 20);

        Address = new JLabel("Enter Address:");
        Address.setBounds(20, 180, 100, 20);
        Address.setForeground(Color.white);
        Addresstxt = new JTextField(50);
        Addresstxt.setBounds(130, 180, 200, 20);

        Phone = new JLabel("Enter Phone:");
        Phone.setBounds(20, 210, 100, 20);
        Phone.setForeground(Color.white);
        Phonetxt = new JTextField(50);
        Phonetxt.setBounds(130, 210, 100, 20);

        UpdateButton = new JButton("Update");
        UpdateButton.setBounds(130, 300, 100, 20);
        UpdateButton.addActionListener(this);

        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(PreviousName);
        add(PreviousNametxt);
        add(Name);
        add(Nametxt);
        add(Cnic);
        add(Cnictxt);
        add(Gender);
        add(Gendertxt);
        add(Address);
        add(Addresstxt);
        add(Phone);
        add(Phonetxt);
        add(UpdateButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    //@Override
    public void actionPerformed(ActionEvent e) {
        Object choice = e.getSource();
        if(choice==Insert)
        {
          insertRecord();  
        }
        if(choice==Delete)
        {
           deleteRecord(); 
        }
        if(choice==Search)
        {
           SearchRecord();
        }
        if(choice==SearchByNameButton)
        {
           SearchRecordByName();
        }
        if(choice==SearchByCNICButton)
        {
           SearchRecordByCNIC();
        }
        if(choice==Update)
        {
           updateRecords();
        }
        if(choice == InsertButton)
        {
            try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database1.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql = "INSERT INTO ex (CNIC, Name_emp, Address, Gender,Phone) VALUES (?, ?, ?, ?,?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, Cnictxt.getText());
                statement.setString(2, Nametxt.getText());
                statement.setString(3, Addresstxt.getText());
                statement.setString(4, Gendertxt.getText());
                statement.setString(5, Phonetxt.getText());


                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0)
                    System.out.println("A new Record is inserted successfully!");

                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else if(choice == DeleteButton)
        {
            try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database1.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql2 = "DELETE FROM ex WHERE Name_emp=?";
                PreparedStatement statement2 = con.prepareStatement(sql2);
                statement2.setString(1, Nametxt.getText());
                int rowsdeleted = statement2.executeUpdate();
                
                if (rowsdeleted > 0)
                    System.out.println("Deleted successfully!");

                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else if(choice == SearchName)
        {
            try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database1.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql3 = "Select * FROM ex WHERE Name_emp=?";
                PreparedStatement statement3 = con.prepareStatement(sql3);

                statement3.setString(1, Nametxt.getText());
                ResultSet rs = statement3.executeQuery();
                if(rs.next()){
                    String ss;
                   ss=rs.getString("Name_emp");
                    System.out.println(ss);
                   String ss1;
                   ss1=rs.getString("CNIC");
                    System.out.println(ss1);
                   String ss2;
                   ss2=rs.getString("Address");
                    System.out.println(ss2);
                   String ss3;
                   ss3=rs.getString("Gender");
                    System.out.println(ss3);
                   int ps;
                   ps=rs.getInt("Phone");
                    System.out.println(ps);
                    JOptionPane.showMessageDialog(null,"Name "+ss+" CNIC "+ss1+" Address "+ss2+" Gender "+ss3+" Phone "+ps);
                    displayFound();
                    int i=0;
                    //displayRow(ss+ss1+ss2+ss3+ps,i);
                   // i=i+100;
                while(rs.next()){
                   String s;
                   s=rs.getString("Name_emp");
                    System.out.println(s);
                   String s1;
                   s1=rs.getString("CNIC");
                    System.out.println(s1);
                   String s2;
                   s2=rs.getString("Address");
                    System.out.println(s2);
                   String s3;
                   s3=rs.getString("Gender");
                    System.out.println(s3);
                   int p;
                   p=rs.getInt("Phone");
                    System.out.println(p);
                    JOptionPane.showMessageDialog(null,"Name "+s+" CNIC "+s1+" Address "+s2+" Gender "+s3+" Phone "+p);
                    displayFound();
                    //displayRow(s+s1+s2+s3+p,i);
                    //i=i+100;
                }
                }
                else
                    displayNotFound();
                   // System.out.println("Not Found");


                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else if(choice == SearchCNIC)
        {
            try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database1.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql3 = "Select * FROM ex WHERE CNIC=?";
                PreparedStatement statement3 = con.prepareStatement(sql3);

                statement3.setString(1, Cnictxt.getText());
                ResultSet rs = statement3.executeQuery();
                rs.getObject(sql3);
                if(rs.next()){
                    String ss;
                   ss=rs.getString("Name_emp");
                    System.out.println(ss);
                   String ss1;
                   ss1=rs.getString("CNIC");
                    System.out.println(ss1);
                   String ss2;
                   ss2=rs.getString("Address");
                    System.out.println(ss2);
                   String ss3;
                   ss3=rs.getString("Gender");
                    System.out.println(ss3);
                   int ps;
                   ps=rs.getInt("Phone");
                    System.out.println(ps);
                    JOptionPane.showMessageDialog(null,"Name "+ss+" CNIC "+ss1+" Address "+ss2+" Gender "+ss3+" Phone "+ps);
                    displayFound();
                    while(rs.next()){
                   String s;
                   s=rs.getString("Name_emp");
                    System.out.println(s);
                   String s1;
                   s1=rs.getString("CNIC");
                    System.out.println(s1);
                   String s2;
                   s2=rs.getString("Address");
                    System.out.println(s2);
                   String s3;
                   s3=rs.getString("Gender");
                    System.out.println(s3);
                   int p;
                   p=rs.getInt("Phone");
                    System.out.println(p);
                    JOptionPane.showMessageDialog(null,"Name "+s+" CNIC "+s1+" Address "+s2+" Gender "+s3+" Phone "+p);
                    displayFound();
                    }
                }
                else
                    displayNotFound();


                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        
        else if(choice == UpdateButton)
        {
            try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database1.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql = "UPDATE ex SET CNIC=?, Name_emp=?, Address=?,Gender=?,Phone=? WHERE CNIC=?";

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, Cnictxt.getText());
                statement.setString(2, Nametxt.getText());
                statement.setString(3, Addresstxt.getText());
                statement.setString(4, Gendertxt.getText());
                statement.setString(5, Phonetxt.getText());
                statement.setString(6, Cnictxt.getText());


                int rowsInserted = statement.executeUpdate();
                System.out.println(rowsInserted);


                if (rowsInserted > 0)
                    System.out.println("Updated successfully!");

                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    PersonDatabase()
    {
        HomePage();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new PersonDatabase();
    }
    
}
