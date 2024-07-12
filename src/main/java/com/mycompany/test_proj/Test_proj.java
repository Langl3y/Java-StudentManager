/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.test_proj;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Hieu
 */
public class Test_proj {
    public static void main(String[] args) {
        Scanner scanner_obj = new Scanner(System.in);
//        System.out.println("Enter the number of sv:");
        int find_id;
        SinhVien find_sv = null;
        int choice;
//        int n = scanner_obj.nextInt();
//        scanner_obj.nextLine();

//        for (int i = 0; i < n; i++) {
//            System.out.println("Enter " + (i + 1) + " sv's name:");
//            String name = scanner_obj.nextLine();
//
//            System.out.println("Enter " + (i + 1) + " sv's ID:");
//            int ID = scanner_obj.nextInt();
//            scanner_obj.nextLine();
//
//            System.out.println("Enter " + (i + 1) + " sv's mark:");
//            double mark = scanner_obj.nextDouble();
//            scanner_obj.nextLine();
//
//            SinhVien sinhvien = new SinhVien(name, ID, mark);
//            sv_list.add(sinhvien); // Add SinhVien object to the list
//        }
        List<SinhVien> sv_list = readJsonFile();

        // Displaying student information
        for (int i = 0; i < sv_list.size(); i++) {
            System.out.println("--------------------------");
            System.out.println("Student " + (i + 1) + "'s info:");
            sv_list.get(i).getSV();
        }

        while (true) {
            System.out.println("Log in using a student ID:");
            find_id = scanner_obj.nextInt();
            scanner_obj.nextLine();
            find_sv = findSV(find_id, sv_list);

            if (find_sv != null) {
                System.out.println("What do you want to do with this student?");
                System.out.println("1. Update Student's mark");
                System.out.println("2. Delete Student from the list");
                System.out.println("3. Check the student list");
                System.out.println("4. Exit the program");
                System.out.println("--------------------------");
                System.out.println("Choose an option:");
                choice = scanner_obj.nextInt();
                scanner_obj.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new mark for the student:");
                        double m = scanner_obj.nextDouble();
                        scanner_obj.nextLine();
                        find_sv.setMark(m);
                        find_sv.getSV();
                        break;
                    case 2:
                        // Remove student from the list
                        sv_list.remove(find_sv);
                        System.out.println("Student removed successfully!");
                        break;
                    case 3:
                        // Display student list
                        System.out.println("Displaying student list:");
                        for (SinhVien sv : sv_list) {
                            sv.getSV();
                            System.out.println("--------------------------");
                        }
                        break;
                    case 4:
                        System.exit(0);
                }
            } else {
                break;
            }
        }
    }
    
    public static List<SinhVien> readJsonFile() {
        List<SinhVien> sv_list = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File("C:/Users/Hieu/Documents/NetBeansProjects/test_proj/src/main/java/com/mycompany/test_proj/student.json");

            // Read JSON file into List<SinhVien>
            sv_list = mapper.readValue(jsonFile, new TypeReference<List<SinhVien>>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sv_list;
    }
    
    public static boolean removeSVFromList(int ID, int n, SinhVien[] sv_list){
        int i = 0;
        while (sv_list[i].getID() != ID){
            i = i + 1;
        }
        sv_list[i] = null;
        return true;
    }
    
    public static void getSVList(int n, SinhVien[] sv_list){
        int i = 0;
        while (true){
            try{
                if (sv_list[i] != null){
                    System.out.println("--------------------------");
                    System.out.println("Student" + (i + 1) + "'s info: "); 
                    sv_list[i].getSV();
                }
                i = i + 1;
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
    }
    
    public static SinhVien findSV(int ID, List<SinhVien> sv_list){
        for (SinhVien sv : sv_list) {
            if (sv != null && sv.getID() == ID) {
                return sv;
            }
        }
        System.out.println("No student with ID " + ID + " found");
        return null;
    }
}
