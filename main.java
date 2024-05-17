import java.time.LocalDateTime;

public class Email {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private LocalDateTime receivedTime;
    private LocalDateTime readTime;
    private LocalDateTime printedTime;
    private LocalDateTime deletedTime;
    private boolean isRead;
    private boolean isPrinted;
    private boolean isDeleted;

    public Email(String sender, String recipient, String subject, String body) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.receivedTime = LocalDateTime.now();
        this.isRead = false;
        this.isPrinted = false;
        this.isDeleted = false;
    }

    public void markAsRead() {
        if (!isRead) {
            this.readTime = LocalDateTime.now();
            this.isRead = true;
        }
    }

    public void markAsPrinted() {
        if (!isPrinted) {
            this.printedTime = LocalDateTime.now();
            this.isPrinted = true;
        }
    }

    public void markAsDeleted() {
        if (!isDeleted) {
            this.deletedTime = LocalDateTime.now();
            this.isDeleted = true;
        }
    }

    public LocalDateTime getReceivedTime() {
        return receivedTime;
    }

    public LocalDateTime getReadTime() {
        return readTime;
    }

    public LocalDateTime getPrintedTime() {
        return printedTime;
    }

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public boolean isRead() {
        return isRead;
    }

    public boolean isPrinted() {
        return isPrinted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    @Override
    public String toString() {
        return "Email{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", receivedTime=" + receivedTime +
                ", readTime=" + readTime +
                ", printedTime=" + printedTime +
                ", deletedTime=" + deletedTime +
                ", isRead=" + isRead +
                ", isPrinted=" + isPrinted +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public static void main(String[] args) {
        Email email = new Email("sender@example.com", "recipient@example.com", "Subject", "Email body");
        System.out.println(email);

        email.markAsRead();
        System.out.println("Email read at: " + email.getReadTime());

        email.markAsPrinted();
        System.out.println("Email printed at: " + email.getPrintedTime());

        email.markAsDeleted();
        System.out.println("Email deleted at: " + email.getDeletedTime());

        System.out.println(email);
    }
}