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
public class HoaDonSC {

    private String MaHD, MaNV, MaXe, NgayLapHD;

    @Override
    public String toString() {
        return MaHD + "#" + MaNV + "#" + MaXe + "#" + NgayLapHD;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public String getNgayLapHD() {
        return NgayLapHD;
    }

    public void setNgayLapHD(String NgayLapHD) {
        this.NgayLapHD = NgayLapHD;
    }

    public HoaDonSC(String MaHD, String MaNV, String MaXe, String NgayLapHD) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaXe = MaXe;
        this.NgayLapHD = NgayLapHD;
    }

    public HoaDonSC() {
        this.MaHD = "";
        this.MaNV = "";
        this.MaXe = "";
        this.NgayLapHD = "";
    }

    public HoaDonSC(String line) {
        String[] hd = new String[4];
        hd = line.split("#");
        this.MaHD = hd[0];
        this.MaNV = hd[1];
        this.MaXe = hd[2];
        this.NgayLapHD = hd[3];
    }

    public HoaDonSC(HoaDonSC hdsc) {
        this.MaHD = hdsc.MaHD;
        this.MaNV = hdsc.MaNV;
        this.MaXe = hdsc.MaXe;
        this.NgayLapHD = hdsc.NgayLapHD;
    }

    public boolean ktnv(String MaNV) {
        boolean ktnv = false;
        QLNhanVien NV = new QLNhanVien();
        for (NhanVien nv : NV.ReadFileNV()) {
            if (nv.getMaNV().equalsIgnoreCase(MaNV)) {
                ktnv = true;
            }
        }
        return ktnv;
    }

    public boolean ktx(String MaXe) {
        boolean ktx = false;
        QLXeKhachHang qlxkh = new QLXeKhachHang();
        for (XeKhachHang x : qlxkh.ReadFileXKH()) {
            if (x.getMaXe().equalsIgnoreCase(MaXe)) {
                ktx = true;
            }
        }
        return ktx;
    }

    public void NhapHDSC() {
        Scanner sc = new Scanner(System.in);
        QLHoaDonSC e = new QLHoaDonSC();
        ArrayList<HoaDonSC> dshd = e.ReadFileHDSC();
        boolean kt;
        do {
            kt = true;
            int n = 0;
            System.out.print("Nhập mã hóa đơn: ");
            MaHD = sc.nextLine().trim();
            for (HoaDonSC hd : dshd) {
                if (hd.getMaHD().trim().equalsIgnoreCase(MaHD)) {
                    System.out.println("Mã đã tồn tại, mời nhập lại: ");
                    break;
                } else {
                    n++;
                }
            }
            if (n == dshd.size()) {
                kt = false;
            }
        } while (kt);

        System.out.print("Nhập mã nhân viên: ");
        MaNV = sc.nextLine();
        while ("".equals(MaNV) || !ktnv(MaNV)) {
            System.out.println("Mã nhân viên không được để trống hoặc không tồn tại, vui lòng nhập lại : ");
            MaNV = sc.nextLine();
        }

        System.out.print("Nhập mã xe: ");
        MaXe = sc.nextLine();
        while ("".equals(MaXe) || !ktx(MaXe)) {
            System.out.println("Mã xe không được để trống hoặc không tồn tại, vui lòng nhập lại : ");
            MaNV = sc.nextLine();
        }
        System.out.print("Nhập ngày lập hóa đơn: ");
        do {
            NgayLapHD = sc.nextLine();
            if ("".equals(NgayLapHD)) {
                System.out.println("Ngày lập hóa đơn không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(NgayLapHD));
    }

    public void HienThiHDSC() {
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\n", MaHD, MaNV, MaXe, NgayLapHD);
    }
}
