/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author ThanhTung
 */
public class CanBo implements Serializable{

    private String hoten;
    private float he_so_luong;
   

    public CanBo() {

    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public float getHe_so_luong() {
        return he_so_luong;
    }

    public void setHe_so_luong(float he_so_luong) {
        this.he_so_luong = he_so_luong;
    }

    @Override
    public String toString() {
        return "CanBo{" + "hoten=" + hoten + ", he_so_luong=" + he_so_luong + '}';
    }
    
    public  void display(){
        System.out.println(toString());
    }
}
