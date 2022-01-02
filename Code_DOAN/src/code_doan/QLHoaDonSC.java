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
public class QLHoaDonSC {

    private final Scanner sc = new Scanner(System.in);

    public ArrayList<HoaDonSC> ReadFileHDSC() {
        BufferedReader br = null;
        ArrayList<HoaDonSC> ds = new ArrayList<>();
        File f = new File("D:\\Code_JAVA\\hoadonsuachua.txt");
        try {
            br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split("#");
                HoaDonSC hd = new HoaDonSC(arr[0], arr[1], arr[2], arr[3]);
                ds.add(hd);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(QLHoaDonSC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
        return ds;
    }
    private ArrayList<HoaDonSC> dshdsc = new ArrayList<>(ReadFileHDSC());

    public void WriteFileHDSC() {
        File file = new File("D:\\Code_JAVA\\hoadonsuachua.txt");
        try {
            try (FileWriter f = new FileWriter(file)) {
                for (HoaDonSC hd : dshdsc) {
                    f.write(hd.toString() + "\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(QLHoaDonSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NhapHDSC() {
        String ktr;
        QLHoaDonSCCT qlhdct = new QLHoaDonSCCT();
        HoaDonSC c;
        do {
            c = new HoaDonSC();
            c.NhapHDSC();
            dshdsc.add(c);
            WriteFileHDSC();
            System.out.println("Nhập phím bất kỳ để tiếp tục nhập hóa đơn sửa chữa chi tiết hoặc nhấp Enter để kết thúc: ");
            ktr = sc.nextLine().trim();
            if (ktr.equals("")) {
                break;
            }
            qlhdct.NhapHDSCCT(c.getMaHD());
        } while (true);

        System.out.println("Nhập xong!");
        System.out.println("\n Nhấn Enter để tiếp tục! ");
        String s = sc.nextLine();
    }

    public void HienThiHDSC() {
        System.out.println("Danh sách thông tin hóa đơn sửa chữa");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\n", "MaHoaDon", "MaNhanVien", "MaXe", "NgayLapHoaDOn");
        for (int i = 0; i < dshdsc.size(); i++) {
            dshdsc.get(i).HienThiHDSC();
        }
        System.out.println("Nhập mã hóa đơn muốn xem: ");
        String mhd = sc.nextLine();
        HoaDonSCCT hdct = new HoaDonSCCT();
        ArrayList<HoaDonSCCT> hdcts = hdct.LayDSSCCT(mhd);
        if (hdcts.size() > 0) {
            long tong = 0;
            for (HoaDonSCCT a : hdcts) {
                HienHDSCCT(a);
                tong += (a.getDonGia() * a.getSoLuong());
            }
            System.out.println("Tổng thanh toán là: " + tong);
        } else {
            System.out.println("Không tồn tại mã này");
        }
    }
    
    public void XoaHD() {
        String mhd = "";
        HienThiHDSC();
        dshdsc = ReadFileHDSC();
        do {
            int cs = -1;
            System.out.println("Nhập mã hóa đơn muốn xóa hoặc nhấn Enter để kết thúc xóa: ");
            mhd = sc.nextLine();
            if (mhd.equals("")) {
                break;
            }
            for (int i = 0; i < dshdsc.size(); i++) {
                if (dshdsc.get(i).getMaNV().equals(mhd)) {
                    cs = i;
                }
            }
            if (cs != -1) {
                dshdsc.remove(cs);
            } else {
                System.out.println("Mã hóa đơn không tồn tại! Mời nhập lại: ");
            }
        } while (true);
        System.out.println("Xóa thông tin hóa đơn xong");
        System.out.println("\n Nhấn Enter để tiếp tục! ");
        String c = sc.nextLine();
    }
    
    public void HienHDSCCT(HoaDonSCCT hdscct) {
        QLPhuTung qlpt = new QLPhuTung();
        PhuTung pt = qlpt.GetPhuTung(hdscct.getMaPT());
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaHoaDonChiTiet", "TenPT", "DonGia", "SoLuong", "ThanhTien");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", hdscct.getMaHDCT(), pt.getTenPT(), hdscct.getDonGia(), hdscct.getSoLuong(), hdscct.getDonGia() * hdscct.getSoLuong());
    }
    
    public void TKHDTM() {
        ArrayList<HoaDonSC> ds = ReadFileHDSC();
        System.out.print("Nhập mã hóa đơn cần tìm kiếm: ");
        String MaHD = sc.nextLine().toLowerCase().toUpperCase();
        System.out.println("Thông tin hóa đơn là: ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\n", "MaHoaDon", "MaNhanVien", "MaXe", "NgayLapHoaDOn");
        int cs = -1;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaHD().contains(MaHD)) {
                System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\n", dshdsc.get(i).getMaHD(), dshdsc.get(i).getMaNV(), dshdsc.get(i).getMaXe(), dshdsc.get(i).getNgayLapHD());
                cs = i;
            }
        }
        if (cs == -1) {
            System.out.println("Không tìm thấy mã: " + MaHD);
        }
    }
    
    public void QLDSHDSC() {
        QLHoaDonSC ds = new QLHoaDonSC();
        Scanner sc = new Scanner(System.in);
        ChucNang n = new ChucNang();
        do {
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.printf("\n| Menu:                                                    |");
            System.out.printf("\n| 1. Nhập một hóa đơn mới                                  |");
            System.out.printf("\n| 2. Hiển thị danh sách hoá đơn.                           |");
            System.out.printf("\n| 3. Xóa hóa đơn sửa chữa theo mã.                         |");
            System.out.printf("\n| 4. Tìm kiếm hóa đơn sửa chữa theo mã.                    |");
            System.out.printf("\n| 0. Exit                                                  |");
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.print("\nBạn nhập vào chức năng: ");
            String chon = sc.nextLine();
            System.out.flush();
            switch (chon) {
                case "1": {
                    System.out.print("\n1. Nhập một hóa đơn mới.\n");
                    ds.NhapHDSC();
                    ds.WriteFileHDSC();
                    break;
                }
                case "2": {
                    System.out.print("\n2. Hiển thị danh sách hóa đơn.\n");
                    ds.HienThiHDSC();
                    break;
                }
                case "3": {
                    System.out.print("\n2. Xóa hóa đơn sửa chữa theo mã.\n");
                    ds.XoaHD();
                    break;
                }
                case "4": {
                    System.out.print("\n2. Tìm kiếm hóa đơn sửa chữa theo mã.\n");
                    ds.TKHDTM();
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
