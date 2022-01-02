/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_doan;

import java.util.Scanner;

/**
 *
 * @author Tài
 */
public class ThongKe {

    public void ThongKeSoLuongCon() {
        QLPhuTung qldspt = new QLPhuTung();
        System.out.println("Số lượng phụ tùng còn là: ");
        System.out.printf("\n%-20s\t%-20s\t%-20s\n", "MaPhuTung", "TenPhuTung", "SoLuong");
        for (PhuTung pt : qldspt.ReadFilePT()) {
            System.out.printf("\n%-20s\t%-20s\t%-20s\n", pt.getMaPT(), pt.getTenPT(), pt.getSoLuong());
        }
    }

    public void TongThu() {
        Scanner sc = new Scanner(System.in);
        double tong = 0;
        System.out.println("Nhập tháng/năm: ");
        String thang = sc.nextLine();
        QLHoaDonSC qlhdsc = new QLHoaDonSC();
        HoaDonSCCT qlhdscct = new HoaDonSCCT();
        for (HoaDonSC hoaDonSC : qlhdsc.ReadFileHDSC()) {
            if (hoaDonSC.getNgayLapHD().contains(thang)) {
                for (HoaDonSCCT hd : qlhdscct.LayDSSCCT(hoaDonSC.getMaHD())) {
                    tong += (hd.getSoLuong()*hd.getDonGia());
                }
            }
        }
        System.out.println("Tổng tiền theo " + thang + " là: " + tong);
    }
}
