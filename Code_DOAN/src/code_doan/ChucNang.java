
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
public class ChucNang {

    public void Run() {
        boolean kt = true;
        Scanner ip = new Scanner(System.in);
        QLKhachHang a = new QLKhachHang();
        QLXeKhachHang b = new QLXeKhachHang();
        QLHoaDonSC c = new QLHoaDonSC();
        QLPhuTung e = new QLPhuTung();
        QLNhanVien f = new QLNhanVien();
        QLThongKe g = new QLThongKe();
        do {
            System.out.println("*------------------------------------------------------------------------------*");
            System.out.println("|CHÀO MỪNG ĐẾN VỚI CHƯƠNG TRÌNH QUẢN LÝ SỮA CHỮA CHO GARA Ô TÔ LONG PHÁT CRM   |");
            System.out.println("#------------------------------------------------------------------------------#");
            System.out.println("|                  *******************************************                 |");
            System.out.println("|                  * 1. Quản lý thông tin khách hàng         *                 |");
            System.out.println("|                  * 2. Quản lý thông tin xe của khách hàng  *                 |");
            System.out.println("|                  * 3. Quản lý hóa đơn sửa chữa             *                 |");
            System.out.println("|                  * 4. Quản lý phụ tùng                     *                 |");
            System.out.println("|                  * 5. Quản lý nhân viên                    *                 |");    
            System.out.println("|                  * 6. Quản lý thống kê                     *                 |");
            System.out.println("|                  * 0. Thoát khỏi chương trình              *                 |");
            System.out.println("|                  *******************************************                 |");
            System.out.println("#------------------------------------------------------------------------------#");
            System.out.print("                     Mời bạn chọn chức năng:");
            String chon = ip.nextLine();
            switch (chon) {
                case "1": {
                    a.QLDSKH();
                    break;
                }
                case "2": {
                    b.QLDSXKH();
                    break;
                }
                case "3": {
                    c.QLDSHDSC();
                    break;
                }
                case "4": {
                    e.QLDSPT();
                    break;
                }
                case "5": {
                    f.QLDSNV();
                    break;
                }
                case "6": {
                    g.QLDSTK();
                    break;
                }
                case "0": {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Chương trình không có chức năng này.");
                    break;
            }
        } while (kt);
    }
}
