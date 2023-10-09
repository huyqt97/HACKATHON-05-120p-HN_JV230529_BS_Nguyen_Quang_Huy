package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

import static ra.run.BookManagement.findById;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách :");
        while (true) {
            int id = Integer.parseInt(sc.nextLine());
            if (findById(id) != null) {
                System.out.println("Mã sách đã tồn tại mời nhập lại!");
            } else {
                this.bookId = id;
                break;
            }
        }
        System.out.println("Nhập tên sách :");
        while (true) {
            String name = sc.nextLine();
            if (name.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.bookName = name;
                break;
            }
        }
        System.out.println("Nhập tiêu đề sách :");
        while (true) {
            String title = sc.nextLine();
            if (title.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.title = title;
                break;
            }
        }
        System.out.println("Nhập số trang sách :");
        while (true) {
            String nb = sc.nextLine();
            if (nb.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.numberOfPages = Integer.parseInt(nb);
                break;
            }
        }
        System.out.println("Nhập giá nhập của sách :");
        while (true) {
            String imp = sc.nextLine();
            if (imp.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.importPrice = Float.parseFloat(imp);
                break;
            }
        }
        System.out.println("Nhập giá bán sách :");
        while (true) {
            String exp = sc.nextLine();
            if (exp.trim().equals("")) {
                System.out.println("Không được để trống!");
            } else {
                this.exportPrice = Float.parseFloat(exp);
                break;
            }
        }
        System.out.println("Lợi nhuận :\n" + (this.exportPrice - this.importPrice));
        System.out.println("Nhập trạng thái của sách (True (Còn hàng) or false (Hết hàng)) :");
        while (true) {
            String status = sc.nextLine().toLowerCase();
            if (status.trim().equals("true") || status.trim().equals("false")) {
                this.bookStatus = Boolean.parseBoolean(status);
                break;
            }else {
                System.out.println("Không hợp lệ mời nhập lại!");
            }
        }
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách: " + this.bookId +
                " || Tên sách: " + this.bookName +
                " || Tiêu đề sách: " + this.title +
                " || Số trang sách: " + this.numberOfPages +
                "\n || Giá nhập: " + this.importPrice +
                " || Giá xuất: " + this.exportPrice +
                " || Lợi nhuận: " + this.interest +
                "\n || Trạng thái: " + (this.bookStatus ? "Còn hàng" : "Hết hàng"));
    }

    @Override
    public int compareTo(Book book) {
        if (this.interest < book.interest) {
            return 1;
        } else if (this.interest > book.interest) {
            return -1;
        } else {
            return 0;
        }
    }
}
