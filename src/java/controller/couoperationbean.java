
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.DB;
import models.course;

@ManagedBean
@SessionScoped
public class couoperationbean {
    DB db = new DB();
    private int cid;
    private String msg;
    public couoperationbean() {
        
        courses = db.selectallcourses();
    }
    List<course> courses;
    public List<course> getCourses(){
        
        
        return courses;
    }
    public void edit(course cour){
        for(course c : courses){
            if(c.getId() == cour.getId()){
               cid= c.getId() ;
                c.setIsedit(true);
            }
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void save(){
        for(course c: courses){
            if(cid==c.getId()){
                int f = db.editecourse(c);
                if(f==0){
                    msg="Ubdatetd not complete";
                }else{
                msg="Ubdated complete";
                c.setIsedit(false);
            }
                return;
            }
        }
    }
    public void delete(course c){
        int f = db.deletecourse(c.getId());
        if(f==0){
                    msg="Deleted not complete";
                }else{
                msg="Deleted complete";
                courses.remove(c);
            }
    }
    public void refresh(){
        courses = db.selectallcourses();
    }
}
