/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.faces.context.FacesContextImpl;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
@ManagedBean
public class logoutbean {
    
    
    public String logout(){
    
    
        HttpSession ss = (HttpSession) FacesContextImpl.getCurrentInstance().getExternalContext().getSession(false);
        ss.invalidate();
        return "displaycourses?faces-redirect=true";
    
    }
    
}
