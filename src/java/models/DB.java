/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed
 */
public class DB {
    
    private static Connection conn(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/courses","root","root");
        } catch (ClassNotFoundException ex) {
            System.out.println("conn error");
            
        } catch (SQLException ex) {
            
            System.out.println("url error");
        }
    return con;
    }
    
    
     public  boolean usersearch(String username,String pass){
    
        boolean flag=false;
        try {
            PreparedStatement ps=conn().prepareStatement("select * from users where username=? and pass=?");
            ps.setString(1, username);
            ps.setString(2, pass);
            
           ResultSet set= ps.executeQuery();
           if(set.next()){
           flag=true;
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
      return flag;
    }
     
     
     
     public  boolean addcourse(String cname,String cdetails,String cdate,String chour,String cteacher,String clocation){
    
        boolean flag=false;
        try {
            String sql="insert into course (cname , cdeatails, cdate,chour,cteacher,clocation) values (? ,?,?,?,?,?)";
            PreparedStatement ps=conn().prepareStatement(sql);
            ps.setString(1, cname);
            ps.setString(2, cdetails);
            ps.setString(3, cdate);
            ps.setString(4, chour);
            ps.setString(5, cteacher);
            ps.setString(6, clocation);
            
            int x=ps.executeUpdate();
           
           if(x==0){
           flag=false;
           }
           else{
           flag =true;
           }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return flag;
    }
     
     
     public    List<course> selectallcourses(){
        ResultSet set=null;
        List<course> list =new ArrayList<course>();
        try {
            String sql="select * from course";
            PreparedStatement ps=conn().prepareStatement(sql);
            
            set=ps.executeQuery();
            while(set.next()){
            course c=new course();
            c.setId(set.getInt(1));
            c.setCname(set.getString(2));
            c.setCdetails(set.getString(3));
            c.setCdate(set.getString(4));
            c.setChour(set.getString(5));
            c.setCteacher(set.getString(6));
            c.setClocation(set.getString(7));
            c.setIsedit(false);
            System.out.println("ok");
            list.add(c);
            
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return list;
    
    }
     public  int editecourse(course c){
        int x=0;
        try {
            
            
            String sql="update course set cname=? , cdeatails=? ,cdate=?,chour=?,cteacher=? ,clocation=? where id =?";
            PreparedStatement ps=conn().prepareStatement(sql);
            
            ps.setString(1, c.getCname());
            ps.setString(2, c.getCdetails());
            ps.setString(3, c.getCdate());
            ps.setString(4, c.getChour());
            ps.setString(5, c.getCteacher());
            ps.setString(6, c.getClocation());
            
            ps.setInt(7, c.getId());
            x=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return x;
    
    }
     
     public  int deletecourse(int id){
        int x=0;
        try {
            String sql="delete  from course where id =?";
            PreparedStatement ps=conn().prepareStatement(sql);
            ps.setInt(1, id);
            x=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return x;
    
    }
     
     public  boolean addstudent(String name,String phone,String mail,String eduction,String cname){
    
        boolean flag=false;
        try {
            String sql="insert into student (name , phone, mail,education,cname) values (? ,?,?,?,?)";
            PreparedStatement ps=conn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, mail);
            ps.setString(4, eduction);
            ps.setString(5, cname);
            
            
            int x=ps.executeUpdate();
           
           if(x==0){
           flag=false;
           }
           else{
           flag =true;
           }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return flag;
    }
  
      
     public    List<String> selectCnames(){
        ResultSet set=null;
        List<String> list =new ArrayList<String>();
        try {
            String sql="select cname from course";
            PreparedStatement ps=conn().prepareStatement(sql);
            
            set=ps.executeQuery();
            while(set.next()){
            
            System.out.println("ok");
            list.add(set.getString(1));
            
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return list;
    
    }
     
     public    List<student> selectstudent(String cname){
        ResultSet set=null;
        List<student> list =new ArrayList<student>();
        try {
            String sql="select * from student where cname =?";
            PreparedStatement ps=conn().prepareStatement(sql);
            ps.setString(1, cname);
            set=ps.executeQuery();
            while(set.next()){
            student s=new student();
            s.setId(set.getInt(1));
            s.setName(set.getString(2));
            s.setPhone(set.getString(3));
            s.setMail(set.getString(4));
            s.setEduction(set.getString(5));
            
            System.out.println("ok");
            list.add(s);
            
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return list;
    
    }
     
      public  int deletestudent(int id){
        int x=0;
        try {
            String sql="delete  from student where id =?";
            PreparedStatement ps=conn().prepareStatement(sql);
            ps.setInt(1, id);
            x=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return x;
    
    }
}

