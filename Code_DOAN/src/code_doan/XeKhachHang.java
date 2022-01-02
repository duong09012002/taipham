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
public class XeKhachHang {

    private String MaXe, TenXe, MauXe, BienSo, LoaiXe, HangXe;
    private int SoLuong;

    public XeKhachHang(String MaXe, String TenXe, String MauXe, String BienSo, String LoaiXe, String HangXe, int SoLuong) {
        this.MaXe = MaXe;
        this.TenXe = TenXe;
        this.MauXe = MauXe;
        this.BienSo = BienSo;
        this.LoaiXe = LoaiXe;
        this.HangXe = HangXe;
        this.SoLuong = SoLuong;
    }

    public XeKhachHang(XeKhachHang xkh) {
        this.MaXe = xkh.MaXe;
        this.TenXe = xkh.TenXe;
        this.MauXe = xkh.MauXe;
        this.BienSo = xkh.BienSo;
        this.LoaiXe = xkh.LoaiXe;
        this.HangXe = xkh.HangXe;
        this.SoLuong = xkh.SoLuong;
    }

    public XeKhachHang(String line) {
        String[] xkh = new String[7];
        xkh = line.split("#");
        this.MaXe = xkh[0];
        this.TenXe = xkh[1];
        this.MauXe = xkh[2];
        this.BienSo = xkh[3];
        this.LoaiXe = xkh[4];
        this.HangXe = xkh[5];
        this.SoLuong = Integer.parseInt(xkh[6]);
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public String getMauXe() {
        return MauXe;
    }

    public void setMauXe(String MauXe) {
        this.MauXe = MauXe;
    }

    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    public String getLoaiXe() {
        return LoaiXe;
    }

    public void setLoaiXe(String LoaiXe) {
        this.LoaiXe = LoaiXe;
    }

    public String getHangXe() {
        return HangXe;
    }

    public void setHangXe(String HangXe) {
        this.HangXe = HangXe;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public XeKhachHang() {
        this.MaXe = "";
        this.TenXe = "";
        this.MauXe = "";
        this.BienSo = "";
        this.LoaiXe = "";
        this.HangXe = "";
        this.SoLuong = 0;
    }

    @Override
    public String toString() {
        return MaXe + "#" + TenXe + "#" + MauXe + "#" + BienSo + "#" + LoaiXe + "#" + HangXe + "#" + SoLuong;
    }

    public void NhapXKH() {
        Scanner sc = new Scanner(System.in);
        QLXeKhachHang a = new QLXeKhachHang();
        ArrayList<XeKhachHang> dsxkh = new ArrayList<>();
        boolean kt;
        do {
            kt = true;
            int m = 0;
            System.out.print("Nhập mã xe khách hàng: ");
            MaXe = sc.nextLine().trim();
            for (XeKhachHang xkh : dsxkh) {
                if (xkh.getMaXe().trim().equalsIgnoreCase(MaXe)) {
                    System.out.println("Mã đã tồn tại, mời nhập lại: ");
                    break;
                } else {
                    m++;
                }
            }
            if (m == dsxkh.size()) {
                kt = false;
            }
        } while (kt);
        System.out.print("Nhập tên xe khách hàng: ");
        do {
            TenXe = sc.nextLine();
            if ("".equals(TenXe)) {
                System.out.println("Tên xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(TenXe));
        System.out.print("Nhập màu xe khách hàng: ");
        do {
            MauXe = sc.nextLine();
            if ("".equals(MauXe)) {
                System.out.println("Màu xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(MauXe));
        System.out.print("Nhập biển số xe khách hàng: ");
        do {
            BienSo = sc.nextLine();
            if ("".equals(BienSo)) {
                System.out.println("Biển số xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(BienSo));
        System.out.print("Nhập loại xe khách hàng: ");
        do {
            LoaiXe = sc.nextLine();
            if ("".equals(LoaiXe)) {
                System.out.println("Loại xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(LoaiXe));
        System.out.print("Nhập hãng xe khách hàng: ");
        do {
            HangXe = sc.nextLine();
            if ("".equals(HangXe)) {
                System.out.println("Hãng xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(HangXe));
        System.out.print("Nhập số lượng xe khách hàng: ");
        do {
            SoLuong = Integer.parseInt(sc.nextLine());
            if (SoLuong < 0 || "".equals(SoLuong)) {
                System.out.println("Số lượng xe khách hàng phải lớn hơn 0, vui lòng nhập lại : ");
            }
        } while (SoLuong < 0 || "".equals(SoLuong));
    }

    public void HienThiXKH() {
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", MaXe, TenXe, MauXe, BienSo, LoaiXe, HangXe, SoLuong);
    }

    public void UpdateXKH() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên xe khách hàng: ");
        do {
            TenXe = sc.nextLine();
            if ("".equals(TenXe)) {
                System.out.println("Tên xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(TenXe));
        System.out.print("Nhập màu xe khách hàng: ");
        do {
            MauXe = sc.nextLine();
            if ("".equals(MauXe)) {
                System.out.println("Màu xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(MauXe));
        System.out.print("Nhập biển số xe khách hàng: ");
        do {
            BienSo = sc.nextLine();
            if ("".equals(BienSo)) {
                System.out.println("Biển số xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(BienSo));
        System.out.print("Nhập loại xe khách hàng: ");
        do {
            LoaiXe = sc.nextLine();
            if ("".equals(LoaiXe)) {
                System.out.println("Loại xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(LoaiXe));
        System.out.print("Nhập hãng xe khách hàng: ");
        do {
            HangXe = sc.nextLine();
            if ("".equals(HangXe)) {
                System.out.println("Hãng xe khách hàng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(HangXe));
        System.out.print("Nhập số lượng xe khách hàng: ");
        do {
            SoLuong = Integer.parseInt(sc.nextLine());
            if (SoLuong < 0 || "".equals(SoLuong)) {
                System.out.println("Số lượng xe khách hàng phải lớn hơn 0, vui lòng nhập lại : ");
            }
        } while (SoLuong < 0 || "".equals(SoLuong));
    }
}
