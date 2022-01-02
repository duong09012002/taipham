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
public class KhachHang {

    private String MaKH, TenKH, NgaySinh;
    private String GioiTinh, SDT, DiaChi, CMT;

    @Override
    public String toString() {
        return MaKH + "#" + TenKH + "#" + NgaySinh + "#" + GioiTinh + "#" + SDT + "#" + DiaChi + "#" + CMT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getCMT() {
        return CMT;
    }

    public void setCMT(String CMT) {
        this.CMT = CMT;
    }

    public KhachHang(String MaKH, String TenKH, String NgaySinh, String GioiTinh, String SDT, String DiaChi, String CMT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.CMT = CMT;
    }

    public KhachHang() {
        MaKH = "";
        TenKH = "";
        NgaySinh = "";
        GioiTinh = "";
        DiaChi = "";
        SDT = "";
        CMT = "";
    }

    public KhachHang(String line) {
        String[] kh = new String[7];
        kh = line.split("#");
        this.MaKH = kh[0];
        this.TenKH = kh[1];
        this.NgaySinh = kh[2];
        this.GioiTinh = kh[3];
        this.DiaChi = kh[4];
        this.SDT = kh[5];
        this.CMT = kh[6];
    }

    public KhachHang(KhachHang kh) {
        this.MaKH = kh.MaKH;
        this.TenKH = kh.TenKH;
        this.NgaySinh = kh.NgaySinh;
        this.GioiTinh = kh.GioiTinh;
        this.SDT = kh.SDT;
        this.DiaChi = kh.DiaChi;
        this.CMT = kh.CMT;
    }

    public void NhapKH() {
        Scanner sc = new Scanner(System.in);
        QLKhachHang a = new QLKhachHang();
        ArrayList<KhachHang> dskh = a.ReadFileKH();
        boolean kt;
        do {
            kt = true;
            int m = 0;
            System.out.print("Nhập mã khách hàng: ");
            MaKH = sc.nextLine().trim();
            for (KhachHang kh : dskh) {
                if (kh.getMaKH().trim().equalsIgnoreCase(MaKH)) {
                    System.out.println("Mã đã tồn tại, mời nhập lại: ");
                    break;
                } else {
                    m++;
                }
            }
            if (m == dskh.size()) {
                kt = false;
            }
        } while (kt);
        System.out.print("Nhập tên khách hàng: ");
        do {
            TenKH = sc.nextLine();
            if ("".equals(TenKH)) {
                System.out.println("Tên khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(TenKH));
        System.out.print("Nhập ngày sinh khách hàng: ");
        do {
            NgaySinh = sc.nextLine();
            if ("".equals(NgaySinh)) {
                System.out.println("Ngày sinh khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(NgaySinh));
        System.out.print("Nhập giới tính khách hàng: ");
        do {
            GioiTinh = sc.nextLine();
            if ("".equals(GioiTinh) && "Nam".equals(GioiTinh) && "Nữ".equals(GioiTinh)) {
                System.out.println("Giới tính khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(GioiTinh));
        System.out.print("Nhập số điện thoại khách hàng: ");
        do {
            SDT = sc.nextLine();
            if ("".equals(SDT)) {
                System.out.println("Số điện thoại khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(SDT));
        System.out.print("Nhập địa chỉ khách hàng: ");
        do {
            DiaChi = sc.nextLine();
            if ("".equals(DiaChi)) {
                System.out.println("Địa chỉ khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(DiaChi));
        System.out.print("Nhập chứng minh thư khách hàng: ");
        do {
            CMT = sc.nextLine();
            if ("".equals(CMT)) {
                System.out.println("Chứng minh thư khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(CMT));
    }

    public void HienThiKH() {
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", MaKH, TenKH, NgaySinh, GioiTinh, SDT, DiaChi, CMT);
    }

    public void UpdateKH() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên khách hàng: ");
        do {
            TenKH = sc.nextLine();
            if ("".equals(TenKH)) {
                System.out.println("Tên khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(TenKH));
        System.out.print("Nhập ngày sinh khách hàng: ");
        do {
            NgaySinh = sc.nextLine();
            if ("".equals(NgaySinh)) {
                System.out.println("Ngày sinh khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(NgaySinh));
        System.out.print("Nhập giới tính khách hàng: ");
        do {
            GioiTinh = sc.nextLine();
            if ("".equals(GioiTinh)) {
                System.out.println("Giới tính khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(GioiTinh));
        System.out.print("Nhập số điện thoại khách hàng: ");
        do {
            SDT = sc.nextLine();
            if ("".equals(SDT)) {
                System.out.println("Số điện thoại khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(SDT));
        System.out.print("Nhập địa chỉ khách hàng: ");
        do {
            DiaChi = sc.nextLine();
            if ("".equals(DiaChi)) {
                System.out.println("Địa chỉ khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(DiaChi));
        System.out.print("Nhập Chứng minh thư khách hàng: ");
        do {
            CMT = sc.nextLine();
            if ("".equals(CMT)) {
                System.out.println("Chứng minh thư khách hàng không được để trống, vui lòng nhập lại: ");
            }
        } while ("".equals(CMT));
    }
}
