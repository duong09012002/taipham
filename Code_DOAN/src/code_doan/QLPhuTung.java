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
public class QLPhuTung {
    private final Scanner sc = new Scanner(System.in);

    //hàm này
    public ArrayList<PhuTung> ReadFilePT() {
        BufferedReader br = null;
        ArrayList<PhuTung> ds = new ArrayList<>();
        File f = new File("D:\\Code_JAVA\\phutung.txt");
        try {
            br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split("#");
                PhuTung pt = new PhuTung(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Double.parseDouble(arr[4]));
                ds.add(pt);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(QLPhuTung.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
        return ds;
    }
    public ArrayList<PhuTung> dspt = new ArrayList<>(ReadFilePT());

    public void WriteFilePT() {
        File file = new File("D:\\Code_JAVA\\phutung.txt");
        try {
            try (FileWriter f = new FileWriter(file)) {
                for (PhuTung pt : dspt) {
                    f.write(pt.toString() + "\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(QLPhuTung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NhapPT() {
        ArrayList<PhuTung> ds = new ArrayList<>();
        String ktr;
        do {
            PhuTung h = new PhuTung();
            h.NhapPT();
            dspt.add(h);
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

    public void HienThiPT() {
        System.out.println("Danh sách thông tin phụ tùng");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaPhuTung", "TenPhuTung", "Loai", "DonGia", "SoLuong");
        for (int i = 0; i < dspt.size(); i++) {
            dspt.get(i).HienThiPT();
        }
    }

    public void XoaKH() {
        String mpt = "";
        HienThiPT();
        dspt = ReadFilePT();
        do {
            int cs = -1;
            System.out.println("Nhập mã phụ tùng muốn xóa hoặc nhấn Enter để kết thúc xóa: ");
            mpt = sc.nextLine();
            if (mpt.equals("")) {
                break;
            }
            for (int i = 0; i < dspt.size(); i++) {
                if (dspt.get(i).getMaPT().equals(mpt)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dspt.remove(cs);
            } else {
                System.out.println("Mã phụ tùng không tồn tại! Mời nhập lại: ");
            }
        } while (true);
        System.out.println("Xóa thông tin phụ tùng");
        System.out.println("\n Nhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }
    public void UpDateSL(int SoLuong, String MaPT){
        int cs = -1;
        
        for (int i = 0; i < dspt.size(); i++) {
                if (dspt.get(i).getMaPT().equalsIgnoreCase(MaPT)) {
                    cs = i;
                }
            }
        PhuTung pt = dspt.get(cs);
        pt.setSoLuong(SoLuong + pt.getSoLuong());
        dspt.set(cs, pt);
        WriteFilePT();
    }
    public boolean ktsl(int SoLuong, String MaPT){
        boolean ktpt = false;
        for (int i = 0; i < dspt.size(); i++) {
                if (dspt.get(i).getMaPT().equalsIgnoreCase(MaPT)) {
                     if (SoLuong < dspt.get(i).getSoLuong()){
                         ktpt = true;
                     }
                }
            }
        return ktpt;
    }
    public void SuaPT() {
        String s = "";
        HienThiPT();
        do {
            int cs = -1;
            System.out.println("Nhập mã phụ tùng muốn sửa hoặc Enter để kết thúc sửa: ");
            s = sc.nextLine().trim();
            if (s.equals("")) {
                break;
            }
            for (int i = 0; i < dspt.size(); i++) {
                if (dspt.get(i).getMaPT().equals(s)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dspt.get(cs).UpdatePT();
            } else {
                System.out.println("Mã phụ tùng không tồn tại! Vui lòng nhập lại!");
            }
        } while (true);
        System.out.println("Sửa thông tin phụ tùng xong! ");
        System.out.println("\nNhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }

    public void TKPTTM() {
        ArrayList<PhuTung> ds = ReadFilePT();
        System.out.print("Nhập mã phụ tùng cần tìm kiếm : ");
        String MaPT = sc.nextLine().toLowerCase().toUpperCase();
        System.out.println("Thông tin phụ tùng là : ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaPhuTung", "TenPhuTung", "Loai", "DonGia", "SoLuong");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaPT().contains(MaPT)) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dspt.get(i).getMaPT(), dspt.get(i).getTenPT(), dspt.get(i).getLoai(), dspt.get(i).getDonGia(), dspt.get(i).getSoLuong());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy mã : " + MaPT);
        }
    }

    public void TKPTTT() {
        ArrayList<PhuTung> ds = ReadFilePT();
        System.out.print("Nhập tên phụ tùng tìm kiếm: ");
        String TenPT = sc.nextLine();
        System.out.println("Thông tin phụ tùng là: ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaPhuTung", "TenPhuTung", "Loai", "DonGia", "SoLuong");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getTenPT().toLowerCase().contains(TenPT.toLowerCase())) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dspt.get(i).getMaPT(), dspt.get(i).getTenPT(), dspt.get(i).getLoai(), dspt.get(i).getDonGia(), dspt.get(i).getSoLuong());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy tên : " + TenPT);
        }
    }
    public PhuTung GetPhuTung(String mapt){
        PhuTung pt = null;
        for(PhuTung phuTung:ReadFilePT()){
            if(phuTung.getMaPT().equals(mapt)){
                pt = phuTung;
            }
        }
        return pt;
    }
    public void TKPTTDG() {
        ArrayList<PhuTung> dspt = ReadFilePT();
        System.out.print("Nhập khoảng đơn giá phụ tùng cần tìm kiếm!");
        System.out.print("Từ :");
        Double a = sc.nextDouble();
        System.out.print("Đến : ");
        Double b = sc.nextDouble();
        System.out.println("Thông tin phụ tùng là : ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaPhuTung", "TenPhuTung", "Loai", "DonGia", "SoLuong");
        int cs = -1;
        for (int i = 0; i < dspt.size(); i++) {
            if (dspt.get(i).getDonGia() >= a && dspt.get(i).getDonGia() <= b) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", dspt.get(i).getMaPT(), dspt.get(i).getTenPT(), dspt.get(i).getLoai(), dspt.get(i).getDonGia(), dspt.get(i).getSoLuong());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy khoảng giá từ: " + a + "đến" + b);
        }
    }
    public void MenuTK() {
        do {
            System.out.println("|-------------------------------------------|");
            System.out.println("|        Chọn phương thức tìm kiếm.         |");
            System.out.println("|1. Tìm kiếm phụ tùng theo mã.              |");
            System.out.println("|2. Tìm kiếm phụ tùng theo tên.             |");
            System.out.println("|3. Tìm kiếm phụ tùng theo đơn giá.         |");
            System.out.println("|0. Exit                                    |");
            System.out.println("|-------------------------------------------|");
            System.out.println("Chọn chức năng tìm kiếm: ");

            String chon = sc.nextLine();

            switch (chon) {
                case "1":
                    TKPTTM();
                    break;
                case "2":
                    TKPTTT();
                    break;
                case "3":
                    TKPTTDG();
                    break;
                case "0": 
                    return;
                default:
                    System.out.println("Chương trình không có chức năng này, vui lòng nhập lại.");
                    break;
            }
        } while (true);
    }

    public void QLDSPT() {
        QLPhuTung ds = new QLPhuTung();
        Scanner sc = new Scanner(System.in);
        ChucNang n = new ChucNang();
        do {
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.printf("\n| Menu:                                                    |");
            System.out.printf("\n| 1. Nhập một phụ tùng mới.                                |");
            System.out.printf("\n| 2. Hiển thị danh sách phụ tùng.                          |");
            System.out.printf("\n| 3. Sửa thông tin phụ tùng có mã được nhập từ bàn phím.   |");
            System.out.printf("\n| 4. Tìm kiếm thông tin phụ tùng.                          |");
            System.out.printf("\n| 5. Xóa thông tin phụ tùng theo mã.                       |");
            System.out.printf("\n| 0. Thoát khỏi chương trình.                              |");
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.print("\nBạn nhập vào chức năng: ");
            String chon = sc.nextLine();
            System.out.flush();
            switch (chon) {
                case "1": {
                    System.out.print("\n1. Nhập phụ tùng mới.\n");
                    ds.NhapPT();
                    ds.WriteFilePT();
                    break;
                }
                case "2": {
                    System.out.print("\n2. Hiển danh sách phụ tùng.\n");
                    ds.HienThiPT();
                    break;
                }
                case "3": {
                    System.out.print("\n3. Sửa thông tin phụ tùng có mã phụ tùng được nhập từ bàn phím.\n");
                    ds.SuaPT();
                    ds.WriteFilePT();
                    break;
                }
                case "4": {
                    System.out.print("\n4. Tìm kiếm thông tin phụ tùng theo mã phụ tùng.\n");
                    ds.MenuTK();
                    break;
                }
                case "5": {
                    System.out.print("\n5. Xóa thông tin phụ tùng theo mã phụ tùng.\n");
                    ds.XoaKH();
                    ds.WriteFilePT();
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
