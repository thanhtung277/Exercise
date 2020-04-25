/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.Start;
import entity.CanBo;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThanhTung
 */
public class ManHinhChinh {

    public static void main(String[] args) {
        Start start = new Start();
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();

        //  do {
        while (true) {
            System.out.println("University Staff Management 1.0");
            System.out.println("\t1.Add staff");
            System.out.println("\t2.Search staff by name ");
            System.out.println("\t3.Search staff by department/falculty");
            System.out.println("\t4.Display all staff");
            System.out.println("\t5.Save Data");
            System.out.println("\t6.Read Data");
            System.out.println("\t7.Exit");
            System.out.printf("Select function (1,2,3,4,5,6 or 7): ");
            int choose;

            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    start.addStaff();

                    break;
                case 2:
                    System.out.println("Enter name to search: ");
                    String searchString = sc.nextLine();
                    ArrayList<CanBo> dsNhanVienTimThay = start.searchInforByName(searchString);
                    start.showDsNhanVien(dsNhanVienTimThay);
                    break;

                case 3:
                    System.out.println("Enter Dep/Fac to search: ");
                    String departmentString = sc.nextLine();
                    start.searchInforByDepartment(departmentString);
                    ArrayList<CanBo> bophantimthay = start.searchInforByDepartment(departmentString);
                    start.showDsNhanVien(bophantimthay);
                    break;

                case 4:

                    start.hienThiTatCa();
                    break;
                case 5://save file >> output
                    FileOutputStream fileOutput = null;
                    ObjectOutputStream objOutput = null;

                    try {
                        fileOutput = new FileOutputStream("thucai.dat");
                        objOutput = new ObjectOutputStream(fileOutput);
                        objOutput.writeObject(start.canBoList);
                    } catch (Exception e) {

                    } finally {

                        try {
                            if (fileOutput != null) {
                                fileOutput.close();
                            }
                            if (objOutput != null) {
                                objOutput.close();
                            }
                        } catch (Exception e) {
                        }
                    }
                    break;

                case 6://readfile
                    FileInputStream input = null;
                    ObjectInputStream objectIn = null;

                    try {
                        input = new FileInputStream("thucai.dat");
                        objectIn = new ObjectInputStream(input);
                        
                        start.canBoList = (ArrayList<CanBo>) objectIn.readObject();
                        
                    } catch (Exception e) {

                    } finally {

                        try {
                            if (input != null) {
                                input.close();
                            }
                            if (objectIn != null) {
                                objectIn.close();
                            }
                        } catch (Exception e) {
                        }
                    }
                    for (int i = 0; i <start.canBoList.size(); i++) {
                        start.canBoList.get(i).display();
                    }
                    break;

                case 7:
                    break;

            }

            //    } while (choose != 5);
        }
    }
}
