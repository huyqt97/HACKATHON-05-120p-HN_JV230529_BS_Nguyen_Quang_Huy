package ra.run;

import ra.bussiness.IBook;
import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    static Scanner sc = new Scanner(System.in);
    private static List<Book> books = new ArrayList<>();
    static {
        books.add(new Book(1,"Đắc Nhân Tâm","tâm lý học",200,190000,210000,20000,true));
        books.add(new Book(2,"Hành trình phương đông","chiết lý",200,190000,210000,20000,true));
        books.add(new Book(3,"10 Vạn câu hỏi vì sao","hỏi hơi ngu",200,190000,210000,20000,true));
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách [15 điểm]\n" +
                    "2. Hiển thị thông tin các sách [15 điểm]\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần [15 điểm]\n" +
                    "4. Xóa sách theo mã sách [10 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi trạng thái của sách theo mã sách [10 điểm]\n" +
                    "7. Thoát [05 điểm]");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBook();
                    break;
                case 3:
                    sortBookList();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    bookStatus();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không hợp lệ mời nhập lại!");
            }
        }
    }


    public static void addBook() {
        boolean check = true;
        Book newBook = new Book();
        System.out.println("Nhập số lợp Sách thêm mới:");
        while (check) {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) {
                System.out.println("Không hợp lệ mời nhập lại!");
            } else {
                for (int i = 0; i < choice; i++) {
                    System.out.println("Quyển thứ " + i + 1);
                    newBook.inputData();
                    books.add(newBook);
                }
                System.out.println("Thêm mới thành công!");
                check = false;
            }
        }
    }

    public static void displayBook() {
        if (books == null) {
            System.out.println("Không có quyển sách nào!");
        } else {
            for (int i = 0; i < books.size(); i++) {
                books.get(i).displayData();
            }
        }
    }

    public static void sortBookList() {
        if (books.isEmpty()) {
            System.out.println("Không có sách để sắp xếp.");
        } else {
            Collections.sort(books);
            System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần:");
            displayBook();
        }
    }

    public static void deleteBook() {
        System.out.println("Nhập mã sản phẩm muốn xóa :");
        int id = Integer.parseInt(sc.nextLine());
        if (findById(id)!= null) {
            books.remove(findById(id));
        }else {
            System.out.println("Không tìm thấy sách muốn xóa!");
        }
    }
    public static void searchBook(){
        System.out.println("Nhập tên sách muốn tìm kiếm :");
        String str = sc.nextLine();
        boolean check  = false;
        for (Book book: books) {
            if(book.getBookName().contains(str)){
                book.displayData();
                check = true;
            }
        }
        if(!check){
            System.out.println("Không Tìm thấy quyển sách nào!");
        }
    }
    public static void bookStatus(){
        System.out.println("Nhập Mã sách :");
        int id = Integer.parseInt(sc.nextLine());
        Book book = findById(id);
        if(book!= null){
            System.out.println("Sách : " + book.getBookName());
            System.out.println("Trạng thái cũ : " + (book.isBookStatus()? "còn hàng!" : "hết hàng!"));
            book.setBookStatus(!book.isBookStatus());
            System.out.println("Cập Nhập trạng thái thành công!");
            book.displayData();
        }else {
            System.out.println("Không tìm thấy sách!");
        }
    }
    public static Book findById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == id) {
                return books.get(i);
            }
        }
        return null;
    }
}
