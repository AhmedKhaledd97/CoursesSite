/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Administrator
 */
public class test {
    public static void main(String[] args) {
        boolean f;
        DB db = new DB();
        f = db.usersearch("ahmed", "12");
        if(f==true){
            System.out.println("OK");
        }else{
            System.out.println("No");
        }
    }
}
