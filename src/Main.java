import entities.User;
import service.BigMenu;
import service.MenuDangNhapService;
import view.MenuMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuDangNhapService menuDangNhapService = new MenuDangNhapService();
        Scanner scanner = new Scanner(System.in);
        MenuMain menuMain = new MenuMain();
        BigMenu bigMenu = new BigMenu();
        ArrayList<User> users = new ArrayList<>();
        menuMain.menuDangNhapDangKy(scanner, menuDangNhapService, bigMenu,users);
    }
}