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
public class QLXeKhachHang {

    private final Scanner sc = new Scanner(System.in);

    public ArrayList<XeKhachHang> ReadFileXKH() {
        BufferedReader br = null;
        ArrayList<XeKhachHang> ds = new ArrayList<>();
        File f = new File("D:\\Code_JAVA\\xekhachhang.txt");
        try {
            br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split("#");
                XeKhachHang XKH = new XeKhachHang(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], Integer.parseInt(arr[6]));
                ds.add(XKH);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
        return ds;
    }
    private ArrayList<XeKhachHang> dsxkh = new ArrayList<>(ReadFileXKH());

//hàm này
    public void WriteFileXKH() {

        File file = new File("D:\\Code_JAVA\\xekhachhang.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (XeKhachHang xkh : dsxkh) {
                fileWriter.write(xkh.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(QLXeKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void NhapXKH() {
        ArrayList<XeKhachHang> ds = new ArrayList<>();
        String ktr;
        do {
            XeKhachHang l = new XeKhachHang();
            l.NhapXKH();
            dsxkh.add(l);
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

    public void HienThiXKH() {
        System.out.println("Danh sách thông tin xe khách hàng");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaXe", "TenXe", "MauXe", "BienSo", "LoaiXe", "HangXe", "SoLuong");
        for (int i = 0; i < dsxkh.size(); i++) {
            dsxkh.get(i).HienThiXKH();
        }
    }

    public void XoaXKH() {
        String mxkh = "";
        HienThiXKH();
        dsxkh = ReadFileXKH();
        do {
            int cs = -1;
            System.out.println("Nhập mã xe khách hàng muốn xóa hoặc nhấn Enter để kết thúc xóa: ");
            mxkh = sc.nextLine();
            if (mxkh.equals("")) {
                break;
            }
            for (int i = 0; i < dsxkh.size(); i++) {
                if (dsxkh.get(i).getMaXe().equals(mxkh)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dsxkh.remove(cs);
            } else {
                System.out.println("Mã xe khách hàng không tồn tại! Mời nhập lại: ");
            }
        } while (true);
        System.out.println("Xóa thông tin xe khách hàng");
        System.out.println("\n Nhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }

    public void SuaXKH() {
        String s = "";
        HienThiXKH();
        do {
            int cs = -1;
            System.out.println("Nhập mã xe khách hàng muốn sửa hoặc Enter để kết thúc sửa: ");
            s = sc.nextLine().trim();
            if (s.equals("")) {
                break;
            }
            for (int i = 0; i < dsxkh.size(); i++) {
                if (dsxkh.get(i).getMaXe().equals(s)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dsxkh.get(cs).UpdateXKH();
            } else {
                System.out.println("Mã xe khách hàng không tồn tại! Vui lòng nhập lại!");
            }
        } while (true);
        System.out.println("Sửa thông tin xe khách hàng xong! ");
        System.out.println("\nNhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }

    public void TKXKHTM() {
        ArrayList<XeKhachHang> ds = ReadFileXKH();
        System.out.print("Nhập mã xe khách hàng cần tìm kiếm : ");
        String MaXKH = sc.nextLine().toLowerCase().toUpperCase();
        System.out.println("Thông tin xe khách hàng là : ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaXe", "TenXe", "MauXe", "BienSo", "LoaiXe", "HangXe", "SoLuong");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaXe().contains(MaXKH)) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dsxkh.get(i).getMaXe(), dsxkh.get(i).getTenXe(), dsxkh.get(i).getMauXe(), dsxkh.get(i).getBienSo(), dsxkh.get(i).getLoaiXe(), dsxkh.get(i).getHangXe(), dsxkh.get(i).getSoLuong());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy mã xe: " + MaXKH);
        }
    }

    public void TKXKHTT() {
        ArrayList<XeKhachHang> ds = ReadFileXKH();
        System.out.print("Nhập tên xe khách cần tìm kiếm: ");
        String TenXKH = sc.nextLine();
        System.out.println("Thông tin xe khách hàng là: ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaXe", "TenXe", "MauXe", "BienSo", "LoaiXe", "HangXe", "SoLuong");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getTenXe().toLowerCase().contains(TenXKH.toLowerCase())) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dsxkh.get(i).getMaXe(), dsxkh.get(i).getTenXe(), dsxkh.get(i).getMauXe(), dsxkh.get(i).getBienSo(), dsxkh.get(i).getLoaiXe(), dsxkh.get(i).getHangXe(), dsxkh.get(i).getSoLuong());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy tên xe: " + TenXKH);
        }
    }

    public void TKXKHTH() {
        ArrayList<XeKhachHang> ds = ReadFileXKH();
        System.out.print("Nhập hãng xe cần tìm kiếm!");
        String HX = sc.nextLine();
        System.out.println("Thông tin xe khách hàng là : ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaXe", "TenXe", "MauXe", "BienSo", "LoaiXe", "HangXe", "SoLuong");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getHangXe().contains(HX)) {

                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dsxkh.get(i).getMaXe(), dsxkh.get(i).getTenXe(), dsxkh.get(i).getMauXe(), dsxkh.get(i).getBienSo(), dsxkh.get(i).getLoaiXe(), dsxkh.get(i).getHangXe(), dsxkh.get(i).getSoLuong());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy hãng xe: " + HX);
        }
    }

    public void MenuTK() {
        do {
            System.out.println("|-------------------------------------------|");
            System.out.println("|        Chọn phương thức tìm kiếm.         |");
            System.out.println("|1. Tìm kiếm xe khách hàng theo mã xe       |");
            System.out.println("|2. Tìm kiếm xe khách hàng theo tên xe.     |");
            System.out.println("|3. Tìm kiếm xe khách hàng theo hãng xe.    |");
            System.out.println("|0. Exit                                    |");
            System.out.println("|-------------------------------------------|");
            System.out.println("Chọn chức năng tìm kiếm : ");

            String chon = sc.nextLine();

            switch (chon) {
                case "1":
                    TKXKHTM();
                    break;
                case "2":
                    TKXKHTT();
                    break;
                case "3":
                    TKXKHTH();
                    break;
                case "0": 
                    return;
                default:
                    System.out.println("Chương trình không có chức năng này, vui lòng nhập lại.");
                    break;
            }
        } while (true);
    }

    public void QLDSXKH() {
        QLXeKhachHang ds = new QLXeKhachHang();
        Scanner ip = new Scanner(System.in);
        ChucNang n = new ChucNang();
        do {
            System.out.printf("\n|-------------------------------------------------------------|");
            System.out.printf("\n| Menu:                                                       |");
            System.out.printf("\n| 1. Nhập một xe khách hàng mới.                              |");
            System.out.printf("\n| 2. Hiển thị danh sách xe khách hàng.                        |");
            System.out.printf("\n| 3. Sửa thông tin xe khách hàng có mã được nhập từ bàn phím. |");
            System.out.printf("\n| 4. Tìm kiếm thông tin xe khách hàng .                       |");
            System.out.printf("\n| 5. Xóa thông tin xe khách hàng theo mã.                     |");
            System.out.printf("\n| 0. Thoát khỏi chương trình                                  |");
            System.out.printf("\n|-------------------------------------------------------------|");
            System.out.print("\nBạn nhập vào chức năng: ");
            String chon = ip.nextLine();
            System.out.flush();
            switch (chon) {
                case "1": {
                    System.out.print("\n1. Nhập xe khách hàng mới.\n");
                    ds.NhapXKH();
                    ds.WriteFileXKH();
                    break;
                }
                case "2": {
                    System.out.print("\n2. Hiển danh sách xe khách hàng.\n");
                    ds.HienThiXKH();
                    break;
                }
                case "3": {
                    System.out.print("\n3. Sửa thông tin xe khách hàng có mã xe khách hàng được nhập từ bàn phím.\n");
                    ds.SuaXKH();
                    ds.WriteFileXKH();
                    break;
                }
                case "4": {
                    System.out.print("\n4. Tìm kiếm thông tin xe khách hàng theo mã xe khách hàng.\n");
                    ds.MenuTK();
                    break;
                }
                case "5": {
                    System.out.print("\n5. Xóa thông tin xe khách hàng.\n");
                    ds.XoaXKH();
                    ds.WriteFileXKH();
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
