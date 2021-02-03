
package controller;

import com.sun.faces.context.FacesContextImpl;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;
import models.DB;

@ManagedBean
public class loginbean {
    private String name;
    private String pass;
    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

   
    public String login(){
        
        DB db = new DB();
       boolean f = db.usersearch(name, pass);
       if(f==true){
           HttpSession ss = (HttpSession) FacesContextImpl.getCurrentInstance().getExternalContext().getSession(true);
           ss.setAttribute("name", name);
           return "index?faces-redirect=true";
       }
       else{
          msg = "UserName or Password not found";
          return null;
       }
    }
}
