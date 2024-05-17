import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmailDashboard {

    public static void main(String[] args) {
        List<Email> emails = new ArrayList<>();
        
        // Create mock data with timestamps spread over 3 days
        Email email1 = new Email("sender1@example.com", "recipient1@example.com", "Subject1", "Email body1");
        email1.setReceivedTime(LocalDateTime.now().minusDays(3));
        email1.setReadTime(LocalDateTime.now().minusDays(2));
        email1.setPrintedTime(LocalDateTime.now().minusDays(1));
        email1.setDeletedTime(LocalDateTime.now());

        Email email2 = new Email("sender2@example.com", "recipient2@example.com", "Subject2", "Email body2");
        email2.setReceivedTime(LocalDateTime.now().minusDays(3));
        email2.setReadTime(LocalDateTime.now().minusDays(1));
        email2.setPrintedTime(LocalDateTime.now());

        Email email3 = new Email("sender3@example.com", "recipient3@example.com", "Subject3", "Email body3");
        email3.setReceivedTime(LocalDateTime.now().minusDays(3));
        email3.setReadTime(LocalDateTime.now().minusDays(2));

        emails.add(email1);
        emails.add(email2);
        emails.add(email3);

        
        generateDashboard(emails);
    }

    public static void generateDashboard(List<Email> emails) {
        List<EmailOperationDuration> durations = new ArrayList<>();

        for (Email email : emails) {
            if (email.isRead()) {
                durations.add(new EmailOperationDuration("Read", Duration.between(email.getReceivedTime(), email.getReadTime())));
            }
            if (email.isPrinted()) {
                durations.add(new EmailOperationDuration("Printed", Duration.between(email.getReceivedTime(), email.getPrintedTime())));
            }
            if (email.isDeleted()) {
                durations.add(new EmailOperationDuration("Deleted", Duration.between(email.getReceivedTime(), email.getDeletedTime())));
            }
        }

        durations.sort(Comparator.comparing(EmailOperationDuration::getDuration).reversed());

        System.out.println("Email Operation Durations (Highest to Lowest):");
        for (EmailOperationDuration duration : durations) {
            System.out.println(duration);
        }
    }
}

class EmailOperationDuration {
    private String operation;
    private Duration duration;

    public EmailOperationDuration(String operation, Duration duration) {
        this.operation = operation;
        this.duration = duration;
    }

    public String getOperation() {
        return operation;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Operation: " + operation + ", Duration: " + duration.toHours() + " hours";
    }
}

class Email {
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

    public void setReceivedTime(LocalDateTime receivedTime) {
        this.receivedTime = receivedTime;
    }

    public void setReadTime(LocalDateTime readTime) {
        this.readTime = readTime;
        this.isRead = true;
    }

    public void setPrintedTime(LocalDateTime printedTime) {
        this.printedTime = printedTime;
        this.isPrinted = true;
    }

    public void setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
        this.isDeleted = true;
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
}