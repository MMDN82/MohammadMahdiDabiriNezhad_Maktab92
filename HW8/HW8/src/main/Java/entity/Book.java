package entity;

public abstract class Book {
    private String title;
    private String printYear;
    private int authorId;


    public Book() {
    }

    public Book(String title, String printYear, int authorId) {
        this.title = title;
        this.printYear = printYear;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrintYear() {
        return printYear;
    }

    public void setPrintYear(String printYear) {
        this.printYear = printYear;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
