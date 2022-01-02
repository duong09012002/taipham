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
public class NhanVien {
    private String MaNV, TenNV, DiaChi, GioiTinh, SDT, NgaySinh;
    
    @Override
    public String toString() {
        return MaNV + "#" + TenNV + "#" + NgaySinh + "#" + DiaChi + "#" + GioiTinh + "#" + SDT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public NhanVien(String MaNV, String TenNV, String DiaChi, String GioiTinh, String SDT, String NgaySinh) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
    }

    public NhanVien() {
        this.MaNV = "";
        this.TenNV = "";
        this.DiaChi = "";
        this.GioiTinh = "";
        this.SDT = "";
        this.NgaySinh = "";
    }
    public NhanVien(String line){
        String [] nv = new String[6];
        nv = line.split("#");
        this.MaNV = nv[0];
        this.TenNV = nv[1];
        this.DiaChi = nv[2];
        this.GioiTinh = nv[3];
        this.SDT = nv[4];
        this.NgaySinh = nv[5];
    }
    public NhanVien(NhanVien nv){
        this.MaNV = nv.MaNV;
        this.TenNV = nv.TenNV;
        this.DiaChi = nv.DiaChi;
        this.GioiTinh = nv.GioiTinh;
        this.SDT = nv.SDT;
        this.NgaySinh = nv.NgaySinh;
    }
    public void NhapNV() {
        Scanner sc = new Scanner(System.in);
        QLNhanVien d = new QLNhanVien();
        ArrayList<NhanVien> dsnv = d.ReadFileNV();
        boolean kt;
        do {
            kt = true;
            int q = 0;
            System.out.print("Nhập mã nhân viên: ");
            MaNV = sc.nextLine().trim();
            for (NhanVien nv : dsnv) {
                if (nv.getMaNV().trim().equalsIgnoreCase(MaNV)) {
                    System.out.println("Mã đã tồn tại, mời nhập lại: ");
                    break;
                } else {
                    q++;
                }
            }
            if (q == dsnv.size()) {
                kt = false;
            }
        } while (kt);
        System.out.print("Nhập tên nhân viên: ");
        do {
            TenNV = sc.nextLine();
            if ("".equals(TenNV)) {
                System.out.println("Tên nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(TenNV));
        System.out.print("Nhập ngày sinh nhân viên: ");
        do {
            NgaySinh = sc.nextLine();
            if ("".equals(NgaySinh)) {
                System.out.println("Ngày sinh nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(NgaySinh));
        System.out.print("Nhập địa chỉ nhân viên: ");
        do {
            DiaChi = sc.nextLine();
            if ("".equals(DiaChi)) {
                System.out.println("Địa chỉ nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(DiaChi));
        System.out.print("Nhập giới tính nhân viên: ");
        do {
            GioiTinh = sc.nextLine();
            if ("".equals(GioiTinh)) {
                System.out.println("Giới tính nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(GioiTinh));
        System.out.print("Nhập số điện thoại nhân viên: ");
        do {
            SDT = sc.nextLine();
            if ("".equals(SDT)) {
                System.out.println("Số điện thoại nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(SDT));
    }

    public void HienThiNV() {
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", MaNV, TenNV, NgaySinh, DiaChi, GioiTinh, SDT);
    }

    public void UpdateNV() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên nhân viên: ");
        do {
            TenNV = sc.nextLine();
            if ("".equals(TenNV)) {
                System.out.println("Tên nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(TenNV));
        System.out.print("Nhập ngày sinh nhân viên: ");
        do {
            NgaySinh = sc.nextLine();
            if ("".equals(NgaySinh)) {
                System.out.println("Ngày sinh nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(NgaySinh));
        System.out.print("Nhập địa chỉ nhân viên: ");
        do {
            DiaChi = sc.nextLine();
            if ("".equals(DiaChi)) {
                System.out.println("Địa chỉ nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(DiaChi));
        System.out.print("Nhập giới tính nhân viên: ");
        do {
            GioiTinh = sc.nextLine();
            if ("".equals(GioiTinh)) {
                System.out.println("Giới tính nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(GioiTinh));
        System.out.print("Nhập số điện thoại nhân viên: ");
        do {
            SDT = sc.nextLine();
            if ("".equals(SDT)) {
                System.out.println("Số điện thoại nhân viên không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(SDT));
    }
}
