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
public class QLThongKe {
    public void QLDSTK() {
        ThongKe tk = new ThongKe();
        Scanner sc = new Scanner(System.in);
        ChucNang n = new ChucNang();
        do {
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.printf("\n| Menu:                                                    |");
            System.out.printf("\n| 1. Danh sách phụ tùng còn trong kho.                     |");
            System.out.printf("\n| 2. Thống kê thu nhập theo tháng.                         |");
            System.out.printf("\n| 0. Exit                                                  |"); 
            System.out.printf("\n|----------------------------------------------------------|");
            System.out.print("\nBạn nhập vào chức năng: ");
            String chon = sc.nextLine();
            System.out.flush();
            switch (chon) {
                case "1": {
                    System.out.print("\n1. Danh sách phụ tùng còn trong kho.\n");
                    tk.ThongKeSoLuongCon();
                    break;
                }
                case "2": {
                    System.out.print("\n2. Thống kê thu nhập theo tháng.\n");
                    tk.TongThu();
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
