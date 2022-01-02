/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_doan;

//import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tài
 */
public class PhuTung {

    private String MaPT, TenPT, Loai;
    private int SoLuong;
    private Double DonGia;

    @Override
    public String toString() {
        return MaPT + "#" + TenPT + "#" + Loai + "#" + SoLuong + "#" + DonGia;
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

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Double getDonGia() {
        return DonGia;
    }

    public void setDonGia(Double DonGia) {
        this.DonGia = DonGia;
    }
//    DecimalFormat formatter = new DecimalFormat("###,###,###");
//
//    System.out.println (formatter.format()+" VNĐ");
    public PhuTung(String MaPT, String TenPT, String Loai, int SoLuong, Double DonGia) {
        this.MaPT = MaPT;
        this.TenPT = TenPT;
        this.Loai = Loai;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;

    }

    public PhuTung() {

    }

    public PhuTung(String line) {
        String[] pt = new String[5];
        pt = line.split("#");
        this.MaPT = pt[0];
        this.TenPT = pt[1];
        this.Loai = pt[2];
        this.SoLuong = Integer.parseInt(pt[3]);
        this.DonGia = Double.parseDouble(pt[4]);
    }

    public PhuTung(PhuTung pt) {
        this.MaPT = pt.MaPT;
        this.TenPT = pt.TenPT;
        this.Loai = pt.Loai;
        this.SoLuong = pt.SoLuong;
        this.DonGia = pt.DonGia;

    }

    public void NhapPT() {
        Scanner sc = new Scanner(System.in);
        QLPhuTung c = new QLPhuTung();
        ArrayList<PhuTung> dspt = c.ReadFilePT();
        boolean kt;
        do {
            kt = true;
            int n = 0;
            System.out.print("Nhập mã phụ tùng: ");
            MaPT = sc.nextLine().trim();
            for (PhuTung pt : dspt) {
                if (pt.getMaPT().trim().equalsIgnoreCase(MaPT)) {
                    System.out.println("Mã đã tồn tại, mời nhập lại: ");
                    break;
                } else {
                    n++;
                }
            }
            if (n == dspt.size()) {
                kt = false;
            }
        } while (kt);
        System.out.print("Nhập tên phụ tùng: ");
        do {
            TenPT = sc.nextLine();
            if ("".equals(TenPT)) {
                System.out.println("Tên phụ tùng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(TenPT));
        System.out.print("Nhập loại phụ tùng: ");
        do {
            Loai = sc.nextLine();
            if ("".equals(Loai)) {
                System.out.println("Loại phụ tùng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(Loai));
        System.out.print("Nhập đơn giá phụ tùng: ");
        do {
            DonGia = Double.parseDouble(sc.nextLine());
            if (DonGia < 0) {
                System.out.println("Đơn giá phụ tùng phải lớn hơn 0, vui lòng nhập lại : ");
            }
        } while (DonGia < 0);
        System.out.print("Nhập so luong phụ tùng: ");
        do {
            SoLuong = Integer.parseInt(sc.nextLine());
            if (SoLuong < 0) {
                System.out.println("So luong phụ tùng phải lớn hơn 0, vui lòng nhập lại : ");
            }
        } while (SoLuong < 0);
    }

    public void HienThiPT() {
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", MaPT, TenPT, Loai, DonGia, SoLuong);
    }

    public ArrayList<PhuTung> LayDSPT(String MaPT) {
        QLPhuTung c = new QLPhuTung();
        ArrayList<PhuTung> dspt = c.ReadFilePT();
        ArrayList<PhuTung> ds = new ArrayList<>();
        for (PhuTung pt : dspt) {
            if (pt.MaPT.equals(MaPT)) {
                ds.add(pt);
            }
        }
        return ds;
    }

    public void UpdatePT() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên phụ tùng: ");
        do {
            TenPT = sc.nextLine();
            if ("".equals(TenPT)) {
                System.out.println("Tên phụ tùng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(TenPT));
        System.out.print("Nhập loại phụ tùng: ");
        do {
            Loai = sc.nextLine();
            if ("".equals(Loai)) {
                System.out.println("Loại phụ tùng không được để trống, vui lòng nhập lại : ");
            }
        } while ("".equals(Loai));
        System.out.print("Nhập đơn giá phụ tùng: ");
        do {
            DonGia = Double.parseDouble(sc.nextLine());
            if (DonGia < 0) {
                System.out.println("Đơn giá phụ tùng phải lớn hơn 0, vui lòng nhập lại : ");
            }
        } while (DonGia < 0);
        System.out.print("Nhập số lượng phụ tùng: ");
        do {
            SoLuong = Integer.parseInt(sc.nextLine());
            if (SoLuong < 0 || "".equals(SoLuong)) {
                System.out.println("Số lượng phụ tùng phải lớn hơn 0 và không được để trống, vui lòng nhập lại : ");
            }
        } while (SoLuong < 0 || "".equals(SoLuong));
    }
}
