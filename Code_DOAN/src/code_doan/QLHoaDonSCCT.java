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
public class QLHoaDonSCCT {

    private final Scanner sc = new Scanner(System.in);

    //hàm này
    public ArrayList<HoaDonSCCT> ReadFileHDSCCT() {
        BufferedReader br = null;
        ArrayList<HoaDonSCCT> ds = new ArrayList<>();
        File f = new File("D:\\Code_JAVA\\hoadonsuachuachitiet.txt");
        try {
            br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split("#");
                HoaDonSCCT hdct = new HoaDonSCCT(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
                ds.add(hdct);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(QLHoaDonSCCT.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
        return ds;
    }
    private final ArrayList<HoaDonSCCT> dshdscct = new ArrayList<>(ReadFileHDSCCT());

    public void WriteFileHDSCCT() {

        File file = new File("D:\\Code_JAVA\\hoadonsuachuachitiet.txt");
        try {
            try (FileWriter f = new FileWriter(file)) {
                for (HoaDonSCCT hdct : dshdscct) {
                    f.write(hdct.toString() + "\n");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(QLHoaDonSCCT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NhapHDSCCT(String MaHD) {
        QLPhuTung qlpt = new QLPhuTung();
        String ktr;
        ArrayList<PhuTung> dspt = qlpt.ReadFilePT();
        do {
            HoaDonSCCT d = new HoaDonSCCT();

            d.NhapHDSCCT(dspt);
            d.setMaHD(MaHD);
            dshdscct.add(d);
            WriteFileHDSCCT();
            System.out.println("Nhập phím bất kỳ để tiếp tục hoặc nhấp Enter để kết thúc: ");
            ktr = sc.nextLine().trim();
            if (ktr.equals("")) {
                break;
            }
        } while (true);
    }

    public void HienThiHDSCCT() {
        System.out.println("Danh sách thông tin hóa đơn sửa chữa chi tiết");
        System.out.printf("\n%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n", "MaHoaDonSuaChuaChiTiet", "MaHoaDon", "MaPhuTung", "SoLuong", "DonGia");
        for (int i = 0; i < dshdscct.size(); i++) {
            dshdscct.get(i).HienThiHDSCCT();
        }
    }

    public void QLDSHDSCCT() {
        QLHoaDonSCCT ds = new QLHoaDonSCCT();
        Scanner sc = new Scanner(System.in);
        ChucNang n = new ChucNang();
        do {
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.printf("\n| Menu:                                                    |");
            System.out.printf("\n| 1. Nhập một hoa don chi tiet                             |");
            System.out.printf("\n| 2. Hiển thị danh sách hoa don chi tiet.                  |");
            System.out.printf("\n| 0. Exit.                                                 |");
            System.out.print("\nBạn nhập vào chức năng: ");
            String chon = sc.nextLine();
            System.out.flush();
            switch (chon) {
                case "2": {
                    System.out.print("\n2. Hiển danh sách hoa don chi tiet.\n");
                    ds.ReadFileHDSCCT();
                    ds.HienThiHDSCCT();
                    break;
                }
                case "0":{
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
