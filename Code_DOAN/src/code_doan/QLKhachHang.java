/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_doan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class QLKhachHang {

    private final Scanner sc = new Scanner(System.in);

    public ArrayList<KhachHang> ReadFileKH() {
        BufferedReader br = null;
        ArrayList<KhachHang> ds = new ArrayList<>();
        File f = new File("D:\\Code_JAVA\\khachhang.txt");
        try {
            br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split("#");
                KhachHang KH = new KhachHang(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                ds.add(KH);
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
    private ArrayList<KhachHang> dskh = new ArrayList<>(ReadFileKH());

    public void WriteFileKH() {
        File file = new File("D:\\Code_JAVA\\khachhang.txt");
        try {
            try (FileWriter f = new FileWriter(file, StandardCharsets.UTF_8)) {
                for (KhachHang kh : dskh) {
                    f.write(kh.toString() + "\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NhapKH() {
        ArrayList<KhachHang> ds = new ArrayList<>();
        String ktr;
        do {
            KhachHang k = new KhachHang();
            k.NhapKH();
            dskh.add(k);
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

    public void HienThiKH() {
        System.out.println("Danh sách thông tin khách hàng");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaKhachHang", "TenKhachHang", "NgaySinh", "GioiTinh", "SoDIenThoai", "DiaChi", "ChungMinhThu");
        for (int i = 0; i < dskh.size(); i++) {
            dskh.get(i).HienThiKH();
        }
    }

    public void XoaKH() {
        String mkh = "";
        HienThiKH();
        dskh = ReadFileKH();
        do {
            int cs = -1;
            System.out.println("Nhập mã khách hàng muốn xóa hoặc nhấn Enter để kết thúc xóa: ");
            mkh = sc.nextLine();
            if (mkh.equals("")) {
                break;
            }
            for (int i = 0; i < dskh.size(); i++) {
                if (dskh.get(i).getMaKH().equals(mkh)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dskh.remove(cs);
            } else {
                System.out.println("Mã khách hàng không tồn tại! Mời nhập lại: ");
            }
        } while (true);
        System.out.println("Xóa thông tin khách hàng");
        System.out.println("\n Nhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }

    public void SuaKH() {
        String s = "";
        HienThiKH();
        do {
            int cs = -1;
            System.out.println("Nhập mã khách hàng muốn sửa hoặc Enter để kết thúc sửa: ");
            s = sc.nextLine().trim();
            if (s.equals("")) {
                break;
            }
            for (int i = 0; i < dskh.size(); i++) {
                if (dskh.get(i).getMaKH().equals(s)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dskh.get(cs).UpdateKH();
            } else {
                System.out.println("Mã khách hàng không tồn tại! Vui lòng nhập lại!");
            }
        } while (true);
        System.out.println("Sửa thông tin khách hàng xong! ");
        System.out.println("\nNhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }

    public void TKKHTM() {
        ArrayList<KhachHang> ds = ReadFileKH();
        System.out.print("Nhập mã khách hàng cần tìm kiếm : ");
        String MaKH = sc.nextLine().toLowerCase().toUpperCase().trim();
        System.out.println("Thông tin khách hàng là : ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaKhachHang", "TenKhachHang", "NgaySinh", "GioiTinh", "DiaChi", "SoDienThoai", "ChungMinhThu");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaKH().contains(MaKH)) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dskh.get(i).getMaKH(), dskh.get(i).getTenKH(), dskh.get(i).getNgaySinh(), dskh.get(i).getGioiTinh(), dskh.get(i).getDiaChi(), dskh.get(i).getSDT(), dskh.get(i).getCMT());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy mã : " + MaKH);
        }
    }

    public void TKKHTT() {
        ArrayList<KhachHang> ds = ReadFileKH();
        System.out.print("Nhập tên khách cần tìm kiếm: ");
        String TenKH = sc.nextLine();
        System.out.println("Thông tin khách hàng là: ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaKhachHang", "TenKhachHang", "NgaySinh", "GioiTinh", "SoDienThoai", "DiaChi", "ChungMinhThu");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getTenKH().toLowerCase().contains(TenKH.toLowerCase().toUpperCase())) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dskh.get(i).getMaKH(), dskh.get(i).getTenKH(), dskh.get(i).getNgaySinh(), dskh.get(i).getGioiTinh(), dskh.get(i).getSDT(), dskh.get(i).getDiaChi(), dskh.get(i).getCMT());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy tên : " + TenKH);
        }
    }

    public void TKKHTCmt() {
        ArrayList<KhachHang> ds = ReadFileKH();
        System.out.print("Nhập chứng minh thư cần tìm kiếm!");
        String CMT = sc.nextLine();
        System.out.println("Thông tin khách hàng là : ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaKhachHang", "TenKhachHang", "NgaySinh", "GioiTinh", "SoDIenThoai", "DiaChi", "ChungMinhThu");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getCMT().contains(CMT)) {

                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dskh.get(i).getMaKH(), dskh.get(i).getTenKH(), dskh.get(i).getNgaySinh(), dskh.get(i).getGioiTinh(), dskh.get(i).getSDT(), dskh.get(i).getDiaChi(), dskh.get(i).getCMT());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy chứng minh thư: " + CMT);
        }
    }

    public void MenuTK() {
        do {
            System.out.println("|-------------------------------------------|");
            System.out.println("|        Chọn phương thức tìm kiếm.         |");
            System.out.println("|1. Tìm kiếm khách hàng theo mã.            |");
            System.out.println("|2. Tìm kiếm khách hàng theo tên.           |");
            System.out.println("|3. Tìm kiếm khách hàng theo chứng minh thư.|");
            System.out.println("|0. Exit                                    |");
            System.out.println("|-------------------------------------------|");
            System.out.println("Chọn chức năng tìm kiếm : ");

            String chon = sc.nextLine();

            switch (chon) {
                case "1":
                    TKKHTM();
                    break;
                case "2":
                    TKKHTT();
                    break;
                case "3":
                    TKKHTCmt();
                    break;           
                case "0":
                    return;
                default:
                    System.out.println("Chương trình không có chức năng này, vui lòng nhập lại.");
                    break;
            }
        } while (true);
    }

    public void QLDSKH() {
        QLKhachHang ds = new QLKhachHang();
        Scanner cv = new Scanner(System.in);
        ChucNang n = new ChucNang();
        do {
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.printf("\n| Menu:                                                    |");
            System.out.printf("\n| 1. Nhập một khách hàng mới.                              |");
            System.out.printf("\n| 2. Hiển thị danh sách khách hàng.                        |");
            System.out.printf("\n| 3. Sửa thông tin khách hàng có mã được nhập từ bàn phím. |");
            System.out.printf("\n| 4. Tìm kiếm thông tin khách hàng.                        |");
            System.out.printf("\n| 5. Xóa thông tin khách hàng theo mã.                     |");
            System.out.printf("\n| 0. Thoát khỏi chương trình.                              |");
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.print("\nBạn nhập vào chức năng: ");
            String chon = cv.nextLine();
            System.out.flush();
            switch (chon) {
                case "1": {
                    System.out.print("\n1. Nhập khách hàng mới.\n");
                    ds.NhapKH();
                    ds.WriteFileKH();
                    break;
                }
                case "2": {
                    System.out.print("\n2. Hiển danh sách khách hàng.\n");
                    ds.HienThiKH();
                    break;
                }
                case "3": {
                    System.out.print("\n3. Sửa thông tin khách hàng có mã khách hàng được nhập từ bàn phím.\n");
                    ds.SuaKH();
                    ds.WriteFileKH();
                    break;
                }
                case "4": {
                    System.out.print("\n4. Tìm kiếm thông tin khách hàng theo mã khách hàng.\n");
                    ds.MenuTK();
                    break;
                }
                case "5": {
                    System.out.print("\n5. Xóa thông tin khách hàng theo mã khách hàng.\n");
                    ds.XoaKH();
                    ds.WriteFileKH();
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
