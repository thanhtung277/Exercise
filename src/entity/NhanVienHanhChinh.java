/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ThanhTung
 */
public class NhanVienHanhChinh extends CanBo {

    private String phong_ban;
    private int so_ngay_cong;
    private EPosition chuc_vu;
    private float phu_cap;
    private float luong;

    public NhanVienHanhChinh(){
        
    }
    
    public float getLuong() {
        this.luong = luong;
        luong = (this.getHe_so_luong() * 730) + phu_cap + (so_ngay_cong * 30);
        return luong;
    }

    public void setLuong(float luong) {

    }

    public float getPhu_cap() {
        this.phu_cap = phu_cap;
        if (this.chuc_vu == EPosition.HEAD) {
            phu_cap = 2000;
        } else if (this.chuc_vu == EPosition.VICE_HEAD) {
            phu_cap = 1000;
        } else if (this.chuc_vu == EPosition.STAFF) {
            phu_cap = 500;
        }

        return phu_cap;
    }

    public void setPhu_cap(float phu_cap) {
        this.phu_cap = phu_cap;
    }

    public EPosition getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(EPosition chuc_vu) {
        this.chuc_vu = chuc_vu;
    }

    public NhanVienHanhChinh(String phong_ban, int so_ngay_cong, String chuc_vu) {
        this.phong_ban = phong_ban;
        this.so_ngay_cong = so_ngay_cong;

    }

    public String getPhong_ban() {
        return phong_ban;
    }

    public void setPhong_ban(String phong_ban) {
        this.phong_ban = phong_ban;
    }

    public int getSo_ngay_cong() {
        return so_ngay_cong;
    }

    public void setSo_ngay_cong(int so_ngay_cong) {
        this.so_ngay_cong = so_ngay_cong;
    }
     @Override
    public String toString() {
        String S=getHoten()+", "+getPhong_ban()+", "+getChuc_vu()+", "+
                getHe_so_luong()+", "+getPhu_cap()+", "+getSo_ngay_cong()+
                ", "+getLuong();
        return S;
        
        
    }

}
