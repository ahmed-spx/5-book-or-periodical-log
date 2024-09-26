import java.util.ArrayList;
import java.util.Scanner;

abstract class Item{
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Item(){
        title = "";
    }
    public Item(String title){
        this.title = title;
    }
    public abstract String getListing();

    @Override
    public String toString() {
        return getTitle();
    }
}
class Book extends Item{
    private String isbn_number;
    private String author;

    public String getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(String isbn_number) {
        this.isbn_number = isbn_number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Book(){
        super();
        isbn_number = "";
        author = "";
    }
    public Book(String isbn_number, String author, String title){
        super(title);
        this.isbn_number = isbn_number;
        this.author = author;
    }
    @Override
    public String getListing() {
        return "\nBook Name - " + getTitle() +"\nAuthor - " + getAuthor() + "\nISBN# - " + getIsbn_number();
    }
}
class Periodical extends Item{
private String issueNum;
    public String getIssueNum() {
        return issueNum;
    }
    public void setIssueNum(String issueNum) {
        this.issueNum = issueNum;
    }
    public Periodical(){
        super();
        issueNum = "";
    }
    public Periodical(String title, String issueNum){
        super(title);
        this.issueNum = issueNum;
    }
    @Override
    public String getListing() {
        return "\nPeriodical Title - " + getTitle() + "\nIssue # - " + getIssueNum();
    }
}
public class Lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();
        String output = "";
        for (int i = 0; i<5; i++){
            System.out.println("Please enter B for Book or P for Periodical");
            String response = sc.next();
            if (response.equals("B")){
                System.out.println("Please enter the name of the Book");
                String bookName = sc.next();
                System.out.println("Please enter the author of the Book");
                String bookAuthor = sc.next();
                System.out.println("Please enter the ISBN of the Book");
                String bookISBN = sc.next();
                Book book = new Book(bookISBN,bookAuthor,bookName);
                book.setTitle(bookName);
                book.setAuthor(bookAuthor);
                book.setIsbn_number(bookISBN);
                items.add(book);
                output += book.getListing();
            } else if (response.equals("P")) {
                System.out.println("Please enter the name of the Periodical");
                String periodicalName = sc.next();
                System.out.println("Please enter the issue number");
                String periodicalIssue = sc.next();
                Periodical periodical = new Periodical(periodicalName,periodicalIssue);
                periodical.setTitle(periodicalName);
                periodical.setIssueNum(periodicalIssue);
                items.add(periodical);
                output += periodical.getListing();
            } else System.out.println("Invalid response!");
        }

        System.out.println("Your items: \n" + output);
    }
}
