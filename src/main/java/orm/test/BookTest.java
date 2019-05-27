package orm.test;

import java.util.Scanner;
import orm.dao.BookDAOImpl;
import orm.model.Book;

public class BookTest {

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
        BookDAOImpl dao = new BookDAOImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------");
        System.out.println("1. 新增 Book 資料");
        System.out.println("2. 查詢 Book 資料(by id)");
        System.out.println("3. 查詢 Book 資料(全部)");
        System.out.println("4. 修改 Book 資料");
        System.out.println("5. 刪除 Book 資料");
        System.out.println("6. Exit");
        System.out.println("------------------");
        System.out.println("請選擇:");

        switch (sc.nextInt()) {
            case 1:
                Book book = new Book();
                System.out.println("請輸入書名:");
                book.setName(sc.next());
                System.out.println("請輸入價格");
                book.setPrice(sc.nextInt());
                System.out.println("新增: " + dao.create(book));
                break;
            case 2:
                System.out.println("請輸入要查詢的ID: ");
                System.out.println(dao.get(sc.nextInt()));
                break;
            case 3:
                System.out.println(dao.queryAll());
                break;
            case 4:
                System.out.println("請輸入要修改的資料ID: ");
                Book update_book = dao.get(sc.nextInt());
                System.out.println(update_book);
                System.out.println("請輸入修改後的書名: ");
                update_book.setName(sc.next());
                System.out.println("請輸入修改後的價格: ");
                update_book.setPrice(sc.nextInt());
                System.out.println("修改後: "+ dao.update(update_book));
                break;
            case 5:
                System.out.println("請輸入要刪除的資料ID: ");
                Book del_Book = dao.get(sc.nextInt());
                System.out.println(del_Book);
                System.out.println("確認刪除(y/n)");
                if(sc.next().equalsIgnoreCase("y")){
                    System.out.println("刪除: "+dao.delete(del_Book.getId()));
                }
                break;
            case 6:
                System.exit(0);
                break;
        }
        menu();

    }

}
