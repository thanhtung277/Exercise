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
public class GiangVien extends CanBo {

    private String khoa;
    private EPosition trinh_do;
    private int so_tiet_trong_thang;
    private float phu_cap;
    private float luong;

    public GiangVien() {

    }

    public GiangVien(String khoa, EPosition trinh_do, int so_tiet_trong_thang, float phu_cap, float luong) {
        this.khoa = khoa;
        this.trinh_do = trinh_do;
        this.so_tiet_trong_thang = so_tiet_trong_thang;
        this.phu_cap = phu_cap;
        this.luong = luong;
    }
    

    public float getLuong() {
        //Lương giảng viên được tính như sau: Hệ số lương*730+phụ cấp+số tiết dạy*45.
        this.luong = luong;
        luong = (this.getHe_so_luong() * 730) + phu_cap + (so_tiet_trong_thang * 45);
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }



    public String getKhoa() {
        return khoa;
    }

    public float getPhu_cap() {
        this.phu_cap = phu_cap;
        if (this.trinh_do == EPosition.BACHELOR) {
            phu_cap = 300;
        } else if (this.trinh_do == EPosition.MASTER) {
            phu_cap = 500;
        } else if (this.trinh_do == EPosition.DOCTOR) {
            phu_cap = 1000;
        }
        return phu_cap;
    }

    public void setPhu_cap(float phu_cap) {
        this.phu_cap = phu_cap;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public EPosition getTrinh_do() {
        return trinh_do;
    }

    public void setTrinh_do(EPosition trinh_do) {
        this.trinh_do = trinh_do;
    }
    

 

    public int getSo_tiet_trong_thang() {
        return so_tiet_trong_thang;
    }

    public void setSo_tiet_trong_thang(int so_tiet_trong_thang) {
        this.so_tiet_trong_thang = so_tiet_trong_thang;
    }
    
    @Override
     public String toString() {
        String S=getHoten()+", "+getKhoa()+", "+getTrinh_do()+", "+
                getHe_so_luong()+", "+getPhu_cap()+", "+getSo_tiet_trong_thang()+
                ", "+getLuong();
        return S;

}
}