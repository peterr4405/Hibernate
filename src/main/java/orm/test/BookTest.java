package orm.test;

import java.util.Scanner;
import orm.dao.BookDAOImpl;
import orm.model.Book;

public class BookTest {

    public static void main(String[] args) {
        BookDAOImpl dao = new BookDAOImpl();
        Scanner sc = new Scanner(System.in);

        Book book = new Book();
        System.out.println("請輸入書名:");
        book.setName(sc.next());
        System.out.println("請輸入價格:");
        book.setPrice(sc.nextInt());
        System.out.println("新增 : " + dao.create(book));

    }

}
