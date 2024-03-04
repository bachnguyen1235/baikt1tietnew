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

    public ArrayList<User> menuChucNangChinh(Scanner scanner, int choose, String userName, ArrayList<User> users, MenuDangNhapService menuDangNhapService) {
        switch (choose) {
            case 1:
                System.out.println("username cu cua b la: " + userName);
                System.out.println("nhap user name moi: ");
                for (User user : users) {
                    if (user.getUsername().equals(userName)) {
                        user.setUsername(scanner.nextLine());
                        System.out.println("username moi cua b la: "+user.getUsername());
                    }
                }
                return users;
            case 2:
                System.out.println("nhap mat khau moi:");
                for (User user : users) {
                    if (user.getUsername().equals(userName)) {
                        user.setPassword(menuDangNhapService.nhapLaiPass(scanner));
                    }
                }
                return users;
            case 3:
                System.out.println("nhap email moi:");
                for (User user : users) {
                    if (user.getUsername().equals(userName)) {
                        user.setEmail(menuDangNhapService.kiemTraGmail(scanner, users));
                    }
                }
                return users;
            case 4:
                System.out.println("ban da dang xuat");
                MenuMain menuMain = new MenuMain();
                menuMain.dangNhap(scanner, menuDangNhapService, users);
                break;
            case 0:
                System.out.println("thoat chuong trinh");
                System.exit(0);
                break;
        }
        return users;
    }
}
