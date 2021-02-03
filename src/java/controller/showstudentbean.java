/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import models.DB;
import models.student;

/**
 *
 * @author ahmed
 */
@ManagedBean
public class showstudentbean {
    
    private List<String> cnames;
    private List<student> students;
    private String cname;
    
    DB db=new DB();

    public showstudentbean() {
        
        cnames=db.selectCnames();
        cname=cnames.get(0);
        students=db.selectstudent(cnames.get(0));
        
    }

    public List<String> getCnames() {
        return cnames;
    }

    public List<student> getStudents() {
        return students;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    
    
    public void showstudent(){
    students=db.selectstudent(cname);
    
    }
    
    
    
    
}
