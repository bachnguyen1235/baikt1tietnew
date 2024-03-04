package service;

import entities.User;
import view.MenuMain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuDangNhapService {
    public int nhapSoTuNhien(Scanner scanner, int min, int max) {
        int pick = 0;
        while (true) {
            try {
                pick = Integer.parseInt(scanner.nextLine());
                if (pick >= min || pick <= max)
                    break;
                else
                    System.out.println("chi dc chon tu "+min+" den "+max);
            } catch (NumberFormatException e) {
                System.out.println("phai nhap so nguyen");
            }
        }
        return pick;
    }

    public boolean kiemTraDangNHap(String user, String pass, ArrayList<User> users, Scanner scanner, MenuDangNhapService menuDangNhapService) {

        if (users == null) {
            users = new ArrayList<>();
        }
        MenuMain menuMain = new MenuMain();

        for (User item : users) {
            if (item.getUsername().equals(user)) {
                if (item.getPassword().equals(pass)) {
                    return true;
                } else {
                    System.out.println("sai mat khau");
                    boolean dangNhapSai = menuMain.menuDangNhapSai(scanner);
                    if (dangNhapSai == false) {
                        return false;
                    } else {
                        while (true) {
                            System.out.println("nhap email de khoi phuc tai khoan:");
                            String emailName = scanner.nextLine();
                            if (emailName.equals(item.getEmail())) {
                                System.out.println("email dung");
                                System.out.println("nhap mat khau moi");
                                item.setPassword(scanner.nextLine());
                                System.out.println("thay doi thanh cong, hya dang nhap lai");
                                return false;
                            } else {
                                System.out.println("email sai, hay tao tai khoan moi");
                                menuMain.taotaikhoan(scanner,menuDangNhapService,users);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("tai khoan khong ton tai");
        System.out.println("hay nhap lai user");
        return false;
    }

    public String kiemTraUserOfList(Scanner scanner, ArrayList<User> users) {

        if (users == null) {
            users = new ArrayList<>();
        }
        String username = "";
        while (true) {
            username = scanner.nextLine();
            boolean checkUserName = false;
            for (User item : users) {
                if (item.getUsername().equals(username)) {
                    System.out.println(" da ton tai, hay nhap lai");
                    checkUserName = true;
                    break;
                }
            }
            if (checkUserName == false) {
                return username;
            }
        }
    }

    public boolean kiemTraPass(String pass) {
//        check do dai
        if (pass.length() < 7 || pass.length() > 15) {
            System.out.println("do dai pass khong duung quy dinh, chi tu 7 den 15 ky tu");
            return false;
        }
//        check chu hoa
        boolean chuHoa = false;
        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) {
                chuHoa = true;
                break;
            }
        }
        if (chuHoa == false) {
            System.out.println("pass phai chua it nhat 1 chu hoa");
            return false;
        }
//        check ky tu dac biet
        String kyTuDb = ".,-_;";
        boolean coKyTuDacBiet = false;
        for (char c : pass.toCharArray()) {
            if (pass.contains(String.valueOf(c))) {
                coKyTuDacBiet = true;
                break;
            }
        }
        if (coKyTuDacBiet == false) {
            System.out.println("pass phai chua it nhat 1 ky tu dac biet");
            return false;
        }
//        pass dung dinh dang
        return true;
    }

    public String kiemTraGmail(Scanner scanner, ArrayList<User> users) {

        if (users == null) {
            users = new ArrayList<>();
        }
        String emailName = "";
        while (true) {
            emailName = scanner.nextLine();
            String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(emailName);
            boolean checkEmailTonTai = false;
            for (User item : users) {
                if (item.getUsername().equals(emailName)) {
                    System.out.println("da ton tai, hay nhap lai");
                    checkEmailTonTai = true;
                    break;
                }
            }
            if (matcher.matches()) {
                if (checkEmailTonTai == false) {
                    System.out.println("email dung dinh dang");
                    return emailName;
                } else {
                    System.out.println("hay nhap lai email");
                }
            } else {
                System.out.println("nhap sai dinh dang, hay nhap lai");
            }
        }
    }

    public String nhapLaiPass(Scanner scanner) {
        String pass = "";
        while (true) {
            pass = scanner.nextLine();
            boolean checkpass = kiemTraPass(pass);
            if (checkpass) {
                System.out.println("pass dung dinh dang");
                break;
            } else {
                System.out.println("hay nhap lai");
            }
        }
        return pass;
    }

}
