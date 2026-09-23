class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isBorrowed;
    private int dayReturn;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.dayReturn = 0;
    }

    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " 借阅成功！");
        } else {
            System.out.println(title + " 已被借出，无法借阅。");
        }
    }

    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            dayReturn = 0;
            System.out.println(title + " 归还成功！");
        } else {
            System.out.println(title + " 未被借出，无需归还。");
        }
    }

    public String getInfo() {
        return "ID: " + itemId + ", 标题: " + title + ", 作者: " + author +
                ", 状态: " + (isBorrowed ? "已借出(剩余" + dayReturn + "天)" : "可借阅");
    }

    // 访问器和修改器
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }
    public int getDayReturn() { return dayReturn; }
    public void setDayReturn(int dayReturn) { this.dayReturn = dayReturn; }
}

class Book extends LibraryItem {
    private String ISBN;
    private int pageCount;
    private String genre;

    public Book(String itemId, String title, String author, String ISBN, int pageCount, String genre) {
        super(itemId, title, author);
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.genre = genre;
    }

    @Override
    public void borrow() {
        if (!isBorrowed()) {
            setBorrowed(true);
            setDayReturn(30);
            System.out.println("《" + getTitle() + "》书籍借阅成功，借阅期30天。");
        } else {
            System.out.println("《" + getTitle() + "》已被借出。");
        }
    }

    public void renew() {
        if (isBorrowed()) {
            int newDays = getDayReturn() + 15;
            setDayReturn(newDays);
            System.out.println("《" + getTitle() + "》续借成功，延长15天，当前剩余 " + newDays + " 天。");
        } else {
            System.out.println("《" + getTitle() + "》未被借出，无法续借。");
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | ISBN: " + ISBN + ", 页数: " + pageCount + ", 类型: " + genre;
    }

    // 访问器和修改器
    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}

class Magazine extends LibraryItem {
    private int issueNumber;
    private String publicationDate;
    private boolean isCurrentIssue;

    public Magazine(String itemId, String title, String author, int issueNumber, String publicationDate, boolean isCurrentIssue) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.isCurrentIssue = isCurrentIssue;
    }

    @Override
    public void borrow() {
        if (!isBorrowed()) {
            setBorrowed(true);
            setDayReturn(7);
            System.out.println("《" + getTitle() + "》杂志借阅成功，借阅期7天。");
        } else {
            System.out.println("《" + getTitle() + "》已被借出。");
        }
    }

    public void reserve() {
        if (isCurrentIssue) {
            System.out.println("《" + getTitle() + "》最新一期预约成功！");
        } else {
            System.out.println("《" + getTitle() + "》不是最新一期，无法预约。");
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | 期号: " + issueNumber + ", 出版日期: " + publicationDate +
                ", 最新一期: " + (isCurrentIssue ? "是" : "否");
    }

    // 访问器和修改器
    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }
    public String getPublicationDate() { return publicationDate; }
    public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }
    public boolean isCurrentIssue() { return isCurrentIssue; }
    public void setCurrentIssue(boolean currentIssue) { isCurrentIssue = currentIssue; }
}

public class Expr4_2 {
    public static void main(String[] args) {
        Book book = new Book("B001", "Java编程思想", "Bruce Eckel", "978-7-111-21382-6", 880, "计算机科学");
        book.borrow();
        System.out.println(book.getInfo());
        book.renew();
        System.out.println(book.getInfo());
        book.returnItem();
        System.out.println(book.getInfo());

        Magazine magazine = new Magazine("M001", "国家地理", "国家地理学会", 202, "2023-10", true);
        magazine.borrow();
        System.out.println(magazine.getInfo());
        magazine.reserve();
        System.out.println(magazine.getInfo());
        magazine.returnItem();
        System.out.println(magazine.getInfo());

        LibraryItem[] items = {
                new Book("B002", "深入理解计算机系统", "Randal E. Bryant", "978-7-111-54493-7", 700, "计算机科学"),
                new Book("B003", "活着", "余华", "978-7-5063-6543-7", 191, "文学"),
                new Magazine("M002", "读者", "读者杂志社", 500, "2023-11", false),
                new Magazine("M003", "科幻世界", "科幻世界杂志社", 300, "2023-12", true)
        };
        for (LibraryItem item : items) {
            System.out.println(item.getInfo());
        }
    }
}
