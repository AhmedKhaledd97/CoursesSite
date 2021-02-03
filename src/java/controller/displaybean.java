
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import models.DB;
import models.course;

@ManagedBean
public class displaybean {
    List<course> courses;
    private static String cname;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEduction() {
        return eduction;
    }

    public void setEduction(String eduction) {
        this.eduction = eduction;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    private String phone;
    private String mail;
    private String eduction;
    private String msg;
    DB db = new DB();

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    public List<course> getCourses(){
        
        courses = db.selectallcourses();
        
        return courses;
    }
    public String applypage(String cname){
    
        this.cname = cname;
        return "applycourse";
    }
    public void addstudent(){
    
        boolean f = db.addstudent(name, phone, mail, eduction, cname);
        if(f==true){
           
           msg= "Student added";
       }
       else{
          msg = "Error in added";
          
       }
    }
}
