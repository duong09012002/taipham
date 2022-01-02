/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_doan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tài
 */
public class QLNhanVien {

    private final Scanner sc = new Scanner(System.in);

    public ArrayList<NhanVien> ReadFileNV() {
        BufferedReader br = null;
        ArrayList<NhanVien> ds = new ArrayList<>();
        File f = new File("D:\\Code_JAVA\\nhanvien.txt");
        try {
            br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split("#");
                NhanVien NV = new NhanVien(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
                ds.add(NV);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
        return ds;
    }
    private ArrayList<NhanVien> dsnv = new ArrayList<>(ReadFileNV());

    public void WriteFileNV() {
        File file = new File("D:\\Code_JAVA\\nhanvien.txt");
        try {
            try (FileWriter f = new FileWriter(file, StandardCharsets.UTF_8)) {
                for (NhanVien nv : dsnv) {
                    f.write(nv.toString() + "\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NhapNV() {
        ArrayList<NhanVien> ds = new ArrayList<>();
        String ktr;
        do {
            NhanVien g = new NhanVien();
            g.NhapNV();
            dsnv.add(g);
            System.out.println("Nhập phím bất kỳ để tiếp tục hoặc nhấp Enter để kết thúc: ");
            ktr = sc.nextLine().trim();
            if (ktr.equals("")) {
                break;
            }
        } while (true);
        System.out.println("Nhập xong!");
        System.out.println("\n Nhấn Enter để tiếp tục! ");
        String s = sc.nextLine();
    }

    public void HienThiNV() {
        System.out.println("Danh sách thông tin nhân viên");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaNhanVien", "TenNhanVien", "NgaySinh", "DiaChi", "GioiTinh", "SoDienThoai");
        for (int i = 0; i < dsnv.size(); i++) {
            dsnv.get(i).HienThiNV();
        }
    }

    public void XoaNV() {
        String mnv = "";
        HienThiNV();
        dsnv = ReadFileNV();
        do {
            int cs = -1;
            System.out.println("Nhập mã nhân viên muốn xóa hoặc nhấn Enter để kết thúc xóa: ");
            mnv = sc.nextLine();
            if (mnv.equals("")) {
                break;
            }
            for (int i = 0; i < dsnv.size(); i++) {
                if (dsnv.get(i).getMaNV().equals(mnv)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dsnv.remove(cs);
            } else {
                System.out.println("Mã nhân viên không tồn tại! Mời nhập lại: ");
            }
        } while (true);
        System.out.println("Xóa thông tin nhân viên");
        System.out.println("\n Nhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }

    public void SuaNV() {
        String s = "";
        HienThiNV();
        do {
            int cs = -1;
            System.out.println("Nhập mã nhân viên muốn sửa hoặc Enter để kết thúc sửa: ");
            s = sc.nextLine().trim();
            if (s.equals("")) {
                break;
            }
            for (int i = 0; i < dsnv.size(); i++) {
                if (dsnv.get(i).getMaNV().equals(s)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dsnv.get(cs).UpdateNV();
            } else {
                System.out.println("Mã nhân viên không tồn tại! Vui lòng nhập lại!");
            }
        } while (true);
        System.out.println("Sửa thông tin nhân viên xong! ");
        System.out.println("\nNhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }

    public void TKNVTM() {
        ArrayList<NhanVien> ds = ReadFileNV();
        System.out.print("Nhập mã nhân viên cần tìm kiếm: ");
        String MaNV = sc.nextLine().toLowerCase().toUpperCase();
        System.out.println("Thông tin nhân viên là: ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaNhanVien", "TenNhanVien", "NgaySinh", "DiaChi", "GioiTinh", "SoDienThoai");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaNV().contains(MaNV)) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dsnv.get(i).getMaNV(), dsnv.get(i).getTenNV(), dsnv.get(i).getNgaySinh(), dsnv.get(i).getDiaChi(), dsnv.get(i).getGioiTinh(), dsnv.get(i).getSDT());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy mã: " + MaNV);
        }
    }

    public void TKNVTT() {
        ArrayList<NhanVien> ds = ReadFileNV();
        System.out.print("Nhập tên nhân viên cần tìm kiếm: ");
        String TenNV = sc.nextLine();
        System.out.println("Thông tin nhân viên là: ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaNhanVien", "TenNhanVien", "NgaySinh", "DiaChi", "GioiTinh", "SoDienThoai");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getTenNV().toLowerCase().contains(TenNV.toLowerCase())) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dsnv.get(i).getMaNV(), dsnv.get(i).getTenNV(), dsnv.get(i).getNgaySinh(), dsnv.get(i).getDiaChi(), dsnv.get(i).getGioiTinh(), dsnv.get(i).getSDT());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy tên: " + TenNV);
        }
    }

    public void MenuTK() {

        do {
            System.out.println("|-------------------------------------------|");
            System.out.println("|        Chọn phương thức tìm kiếm.         |");
            System.out.println("|1. Tìm kiếm khách hàng theo mã.            |");
            System.out.println("|2. Tìm kiếm khách hàng theo tên.           |");
            System.out.println("|0. Exit                                    |");
            System.out.println("|-------------------------------------------|");
            System.out.println("Chọn chức năng tìm kiếm: ");
            String chon = sc.nextLine();

            switch (chon) {
                case "1":
                    TKNVTM();
                    break;
                case "2":
                    TKNVTT();
                    break;
                case "0": 
                    return;
                default:
                    System.out.println("Chương trình không có chức năng này, vui lòng nhập lại.");
                    break;
            }
        } while (true);
    }

    public void QLDSNV() {
        QLNhanVien ds = new QLNhanVien();
        Scanner cv = new Scanner(System.in);
        ChucNang n = new ChucNang();
        do {
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.printf("\n| Menu:                                                    |");
            System.out.printf("\n| 1. Nhập một nhân viên mới.                               |");
            System.out.printf("\n| 2. Hiển thị danh sách nhân viên.                         |");
            System.out.printf("\n| 3. Sửa thông tin nhân viên có mã được nhập từ bàn phím.  |");
            System.out.printf("\n| 4. Tìm kiếm thông tin nhân viên.                         |");
            System.out.printf("\n| 5. Xóa thông tin nhân viên theo mã.                      |");
            System.out.printf("\n| 0. Thoát khỏi chương trình.                              |");
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.print("\nBạn nhập vào chức năng: ");
            String chon = cv.nextLine();
            System.out.flush();
            switch (chon) {
                case "1": {
                    System.out.print("\n1. Nhập nhân viên mới.\n");
                    ds.NhapNV();
                    ds.WriteFileNV();
                    break;
                }
                case "2": {
                    System.out.print("\n2. Hiển danh sách nhân viên.\n");
                    ds.HienThiNV();
                    break;
                }
                case "3": {
                    System.out.print("\n3. Sửa thông tin nhân viên có mã nhân viên được nhập từ bàn phím.\n");
                    ds.SuaNV();
                    ds.WriteFileNV();
                    break;
                }
                case "4": {
                    System.out.print("\n4. Tìm kiếm thông tin nhân viên theo mã nhân viên.\n");
                    ds.MenuTK();
                    break;
                }
                case "5": {
                    System.out.print("\n5. Xóa thông tin nhân viên theo mã nhân viên.\n");
                    ds.XoaNV();
                    ds.WriteFileNV();
                    break;
                }
                case "0": {
                    return;
                }
                default: {
                    System.out.println("Chương trình không có chức năng này, vui lòng nhập lại.");
                    break;
                }
            }
        } while (true);
    }
}
