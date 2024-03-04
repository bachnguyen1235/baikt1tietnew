package view;

import entities.User;
import service.BigMenu;
import service.MenuDangNhapService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMain {

    public void menuDangNhapDangKy(Scanner scanner, MenuDangNhapService menuDangNhapService, BigMenu bigMenu, ArrayList<User> users) {

        System.out.println("==========DANG NHAP==========");
        System.out.println("1 -Dang nhap");
        System.out.println("2 -Dang ky");
        System.out.println("lua chon cua ban la:");
        int pick = menuDangNhapService.nhapSoTuNhien(scanner, 1, 2);
        String pock = String.valueOf(pick);
        bigMenu.bigmenu(pock, scanner, menuDangNhapService, users);
    }


    public void dangNhap(Scanner scanner, MenuDangNhapService menuDangNhapService, ArrayList<User> users) {
        System.out.println("==========DANG NHAP==========");
        while (true) {
            System.out.println("moi nhap user:");
            String user = scanner.nextLine();
            System.out.println("moi nhap password");
            String pass = scanner.nextLine();
            boolean status = menuDangNhapService.kiemTraDangNHap(user, pass, users, scanner, menuDangNhapService);
            if (status == true) {
                System.out.println("dang nhap thanh cong");
                dangNhapThanhCong(scanner, user, users);
                break;
            }
        }


    }

    public void taotaikhoan(Scanner scanner, MenuDangNhapService menuDangNhapService, ArrayList<User> users) {
        User user = new User();
        System.out.println("==========Tạo tài khoản===========");
        System.out.println("nhap user name:");
        user.setUsername(menuDangNhapService.kiemTraUserOfList(scanner, users));
        System.out.println("nhap password:");
        System.out.println("password co do dai tu 7 den 15 ky tu, chua it nhat 1 ky tu hoa va 1 ky tu dac biet (. , - _ ;)");
        user.setPassword(menuDangNhapService.nhapLaiPass(scanner));
        System.out.println("nhap email:");
        user.setEmail(menuDangNhapService.kiemTraGmail(scanner, users));
        users.add(user);
        System.out.println("tao tai khoan thanh cong, hay dang nhap");
        dangNhap(scanner, menuDangNhapService, users);
    }


    public boolean menuDangNhapSai(Scanner scanner) {
        MenuDangNhapService menuDangNhapService = new MenuDangNhapService();
        System.out.println("hay chon 1 trong 2 lua chon sau:");
        System.out.println("1. Dang nhap lai");
        System.out.println("2. Quen mat khau");
        System.out.println("lua chon cua ban la");
        int choose = menuDangNhapService.nhapSoTuNhien(scanner, 1, 2);
        if (choose == 1) {
            return false;
        } else {
            return true;
        }
    }

    public void dangNhapThanhCong(Scanner scanner, String userName, ArrayList<User> users) {
        MenuDangNhapService menuDangNhapService = new MenuDangNhapService();
        BigMenu bigMenu = new BigMenu();
        System.out.println("==========Chao mung " + userName + "==========");
        while (true) {
            System.out.println("ban co the thuc hien cac cong viec sau:");
            System.out.println("1. Thay doi Username:");
            System.out.println("2. Thay doi passwork:");
            System.out.println("3. Thay doi email:");
            System.out.println("4. Dang xuat.");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("lua chon cua ban la:");
            int choose = menuDangNhapService.nhapSoTuNhien(scanner, 0, 4);
            users= bigMenu.menuChucNangChinh(scanner, choose, userName, users, menuDangNhapService);
            scanner.nextLine();
            System.out.println("ban co muon chon nua khong? (y/n)");
            String chon = scanner.nextLine();
            if (chon.equalsIgnoreCase("N")){
                break;
            }
        }
    }
}