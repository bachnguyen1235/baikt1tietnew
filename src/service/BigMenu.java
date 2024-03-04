package service;

import entities.User;
import view.MenuMain;

import java.util.ArrayList;
import java.util.Scanner;

public class BigMenu {
    public void bigmenu(String pick, Scanner scanner, MenuDangNhapService menuDangNhapService, ArrayList<User> users) {
        MenuMain menuMain = new MenuMain();
        switch (pick) {
            case "1":
                menuMain.dangNhap(scanner, menuDangNhapService, users);
                break;
            case "2":
                menuMain.taotaikhoan(scanner, menuDangNhapService, users);
                break;
        }
    }

//    public ArrayList<User> menuChucNangChinh(Scanner scanner, int choose, String userName, ArrayList<User> users, MenuDangNhapService menuDangNhapService) {
//        switch (choose) {
//            case 1:
//                System.out.println("username cũ của bạn là: " + userName);
//                System.out.println("Nhập username mới: ");
//                String newUsername = scanner.nextLine();
//                for (User user : users) {
//                    if (user.getUsername().equals(userName)) {
//                        user.setUsername(newUsername);
//                        userName = newUsername; // Cập nhật username của người dùng
//                        System.out.println("Username mới của bạn là: " + userName);
//                        break; // Sau khi tìm thấy và cập nhật username, thoát khỏi vòng lặp
//                    }
//                }
//                break;
//            case 2:
//                System.out.println("Nhập mật khẩu mới:");
//                String newPassword = menuDangNhapService.nhapLaiPass(scanner);
//                for (User user : users) {
//                    if (user.getUsername().equals(userName)) {
//                        user.setPassword(newPassword);
//                        System.out.println("Mật khẩu mới đã được cập nhật.");
//                        break;
//                    }
//                }
//                break;
//
//            case 3:
//                System.out.println("Nhập email mới:");
//                String newEmail = menuDangNhapService.kiemTraGmail(scanner, users);
//                for (User user : users) {
//                    if (user.getUsername().equals(userName)) {
//                        user.setEmail(newEmail);
//                        System.out.println("Email mới đã được cập nhật.");
//                        break;
//                    }
//                }
//                break;
//
//            case 4:
//                System.out.println("Bạn đã đăng xuất.");
//                MenuMain menuMain = new MenuMain();
//                menuMain.dangNhap(scanner, menuDangNhapService, users);
//                break;
//
//            case 0:
//                System.out.println("Thoát chương trình.");
//                System.exit(0);
//                break;
//        }
//        return users;
//    }
}
