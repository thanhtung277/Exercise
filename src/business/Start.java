/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.CanBo;
import entity.EPosition;
import entity.GiangVien;
import entity.NhanVienHanhChinh;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ThanhTung
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    //private CanBo[] list_nhan_vien;
    public ArrayList<CanBo> canBoList = new ArrayList<CanBo>();

    public Start() {

    }

    public void addStaff() {
        System.out.println("Do you want to create a Staff or Teacher (Enter S for Staff, otherwise for Teacher) ? ");
        Scanner sc = new Scanner(System.in);
        String check;
        check = sc.nextLine();
        // chyen ve equal de so sanh
        
        if (check == "S") {
            NhanVienHanhChinh nvhc = new NhanVienHanhChinh();
            //name
            System.out.print("Name: ");
            nvhc.setHoten(sc.nextLine());
            // khoa
            System.out.println("Salary ratio: ");
            nvhc.setHe_so_luong(sc.nextFloat());
            System.out.println("Department: ");
            nvhc.setPhong_ban(sc.nextLine());
            System.out.println("Position (1=HEAD; 2=VICE HEAD; 3=STAFF : )");
            int check_positon;
            check_positon = sc.nextInt();
            if (check_positon == 1) {
                nvhc.setChuc_vu(EPosition.HEAD);
            } else if (check_positon == 2) {
                nvhc.setChuc_vu(EPosition.VICE_HEAD);
            } else if (check_positon == 3) {
                nvhc.setChuc_vu(EPosition.STAFF);
            }
            System.out.println("Number working day: ");
            nvhc.setSo_ngay_cong(sc.nextInt());
            
            canBoList.add(nvhc);

        } else {
            GiangVien gv = new GiangVien();
            System.out.print("Name: ");
            gv.setHoten(sc.nextLine());
            System.out.println("Salary ratio: ");
            gv.setHe_so_luong(sc.nextFloat());
            sc.nextLine();// de bo qua ki tu rong sau khi nhap  ben tren
            System.out.println("Department: ");
            //   nvhc.setHe_so_luong()=sc.nextFloat();
            gv.setKhoa(sc.nextLine());
            System.out.println("Position (1=BACHELOR; 2=MASTER; 3=DOCTOR : )");
            int check_positon;
            check_positon = sc.nextInt();
            if (check_positon == 1) {
                gv.setTrinh_do(EPosition.BACHELOR);
            } else if (check_positon == 2) {
                gv.setTrinh_do(EPosition.MASTER);
            } else if (check_positon == 3) {
                gv.setTrinh_do(EPosition.DOCTOR);
            }
            System.out.println("Number working day: ");
            gv.setSo_tiet_trong_thang(sc.nextInt());
            canBoList.add(gv);
        }

    }
    
    public void hienThiTatCa() {
        showDsNhanVien(canBoList);
    }

    public void showDsNhanVien(ArrayList<CanBo> dsnv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Result: ");
        System.out.printf("Name, Fact/dept, Deg/Pos, Sal Ratio, Allowance, T.Hour/W.days, Salary\n");
        for (int i = 0; i < dsnv.size(); i++) {
            System.out.println(dsnv.get(i).toString());
        }
    }

    public ArrayList<CanBo> searchInforByName(String searchString) {
        ArrayList<CanBo> rs = new ArrayList<>();
        for(CanBo cb : canBoList) {
            if(cb.getHoten().toLowerCase().contains(searchString.toLowerCase())) {
                rs.add(cb);
            }
        }
       return rs;
    }
    public ArrayList<CanBo> searchInforByDepartment(String departmentString){
       ArrayList<CanBo> dps =new ArrayList<>();
       for(CanBo cb : canBoList){
          // khong get duoc den phong ban bo phan, can phai ep kieu
           if (cb instanceof NhanVienHanhChinh) {
              NhanVienHanhChinh nvhc = (NhanVienHanhChinh)cb;
               if (((NhanVienHanhChinh) cb).getPhong_ban().toLowerCase().contains(departmentString.toLowerCase())) {
                   dps.add(cb);
               }
           }
           else if (cb instanceof GiangVien) {
               GiangVien gv = (GiangVien)cb;
               if (((GiangVien) cb).getKhoa().toLowerCase().contains(departmentString.toLowerCase())) {
                   dps.add(cb);
               }
           }
       }
       return dps;
    }
   
}
