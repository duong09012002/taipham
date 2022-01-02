/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_doan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tài
 */
public class HoaDonSCCT {

    private String MaHDCT, MaHD, MaPT, TenPT;
    private int SoLuong;
    private double DonGia, ThanhTien;

    @Override
    public String toString() {
        return MaHDCT + "#" + MaHD + "#" + MaPT + "#" + TenPT + "#" + SoLuong + "#" + DonGia + "#" + ThanhTien;
    }

    public String getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(String MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaPT() {
        return MaPT;
    }

    public void setMaPT(String MaPT) {
        this.MaPT = MaPT;
    }

    public String getTenPT() {
        return TenPT;
    }

    public void setTenPT(String TenPT) {
        this.TenPT = TenPT;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public HoaDonSCCT(String MaHDCT, String MaHD, String MaPT, String TenPT, int SoLuong, double DonGia, double ThanhTien) {
        this.MaHDCT = MaHDCT;
        this.MaHD = MaHD;
        this.MaPT = MaPT;
        this.TenPT = TenPT;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
    }

    public HoaDonSCCT() {
        
    }

    public HoaDonSCCT(String line) {
        String[] l = new String[7];
        l = line.split("#");
        this.MaHDCT = l[0];
        this.MaHD = l[1];
        this.MaPT = l[2];
        this.TenPT = l[3];
        this.SoLuong = Integer.parseInt(l[4]);
        this.DonGia = Double.parseDouble(l[5]);
        this.ThanhTien = Double.parseDouble(l[6]);
    }

    public boolean kthd(String MaHD) {
        boolean kthd = false;
        QLHoaDonSC qlhd = new QLHoaDonSC();
        for (HoaDonSC hd : qlhd.ReadFileHDSC()) {
            if (hd.getMaHD().equalsIgnoreCase(MaHD)) {
                kthd = true;
            }
        }
        return kthd;
    }

    public boolean ktpt(String MaPT) {
        boolean ktpt = false;
        QLPhuTung qlpt = new QLPhuTung();
        for (PhuTung pt : qlpt.ReadFilePT()) {
            if (pt.getMaPT().equalsIgnoreCase(MaPT)) {
                ktpt = true;
            }
        }
        return ktpt;
    }

    public ArrayList<HoaDonSCCT> LayDSSCCT(String mhd) {
        QLHoaDonSCCT e = new QLHoaDonSCCT();
        ArrayList<HoaDonSCCT> dshdct = e.ReadFileHDSCCT();
        ArrayList<HoaDonSCCT> ds = new ArrayList<>();
        for (HoaDonSCCT hdct : dshdct) {
            if (hdct.MaHD.equalsIgnoreCase(mhd)) {
                ds.add(hdct);
            }
        }
        return ds;
    }

    public void NhapHDSCCT(ArrayList<PhuTung> pt) {
        Scanner sc = new Scanner(System.in);
        QLHoaDonSCCT e = new QLHoaDonSCCT();
        ArrayList<HoaDonSCCT> dshdct = e.ReadFileHDSCCT();
        boolean kt;
        do {
            kt = true;
            int n = 0;
            System.out.print("Nhập mã hóa đơn chi tiết: ");
            MaHDCT = sc.nextLine().trim();
            for (HoaDonSCCT hdct : dshdct) {
                if (hdct.getMaHD().trim().contains(MaHDCT)) {
                    System.out.println("Mã đã tồn tại, mời nhập lại: ");
                    break;
                } else {
                    n++;
                }
            }
            if (n == dshdct.size()) {
                kt = false;
            }
        } while (kt);
        System.out.print("Nhập mã phụ tùng: ");
        MaPT = sc.nextLine();
        while ("".equals(MaPT) || !ktpt(MaPT)) {
            System.out.println("Mã phụ tùng không được để trống hoặc không tồn tại, vui lòng nhập lại : ");
            MaHD = sc.nextLine();

        }
        System.out.print("Nhập số lượng: ");
        do {
            SoLuong = Integer.parseInt(sc.nextLine());
            if (SoLuong < 0) {
                System.out.println("Số lượng phải lớn hơn 0, vui lòng nhập lại: ");
            }
        } while (SoLuong < 0);

        QLPhuTung qlpt = new QLPhuTung();
        while (!qlpt.ktsl(SoLuong, MaPT)) {
            System.out.println("Số lượng phụ tùng không dủ vui lòng nhập lại");
            System.out.print("Nhập số lượng: ");
            do {
                SoLuong = Integer.parseInt(sc.nextLine());
                if (SoLuong < 0 || "".equals(SoLuong)) {
                    System.out.println("Số lượng phải lớn hơn 0 và không được để trống, vui lòng nhập lại: ");
                }
            } while (SoLuong < 0 || "".equals(SoLuong));
        }
        qlpt.UpDateSL(-SoLuong, MaPT);
        System.out.print("Nhập đơn giá: ");
        do {
            DonGia = Double.parseDouble(sc.nextLine());
            if (DonGia < 0) {
                System.out.println("Đơn giá phải lớn hơn 0, vui lòng nhập lại: ");
            }
        } while (DonGia < 0);
    }

    public void HienThiHDSCCT() {
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", MaHDCT, MaHD, MaPT, TenPT, SoLuong, DonGia, ThanhTien);
    }

    public void UpdatePT() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: ");
        do {
            MaHD = sc.nextLine();
            if ("".equals(MaHD)) {
                System.out.println("Mã hóa đơn không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(MaHD));
        System.out.print("Nhập mã phụ tùng: ");
        do {
            MaPT = sc.nextLine();
            if ("".equals(MaPT)) {
                System.out.println("Mã phụ tùng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(MaPT));
        System.out.print("Nhập số lượng: ");
        do {
            SoLuong = Integer.parseInt(sc.nextLine());
            if (SoLuong < 0) {
                System.out.println("Đơn giá phải lớn hơn 0, vui lòng nhập lại: ");
            }
        } while (SoLuong < 0);
        System.out.print("Nhập đơn giá: ");
        do {
            DonGia = Double.parseDouble(sc.nextLine());
            if (DonGia < 0) {
                System.out.println("Đơn giá phải lớn hơn 0, vui lòng nhập lại: ");
            }
        } while (DonGia < 0);
    }
}
