import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailDashboardTest {

    @Test
    void testGenerateDashboard_NoEmails() {
        List<Email> emails = new ArrayList<>();
        List<EmailOperationDuration> expectedDurations = new ArrayList<>();

        generateDashboard(emails);

        assertEquals(expectedDurations, durations);
    }

    @Test
    void testGenerateDashboard_SingleEmailWithAllOperations() {
        List<Email> emails = new ArrayList<>();
        Email email = new Email("sender@example.com", "recipient@example.com", "Subject", "Body");
        email.setReceivedTime(LocalDateTime.now().minusDays(3));
        email.setReadTime(LocalDateTime.now().minusDays(2));
        email.setPrintedTime(LocalDateTime.now().minusDays(1));
        email.setDeletedTime(LocalDateTime.now());
        emails.add(email);

        List<EmailOperationDuration> expectedDurations = new ArrayList<>();
        expectedDurations.add(new EmailOperationDuration("Deleted", Duration.between(email.getReceivedTime(), email.getDeletedTime())));
        expectedDurations.add(new EmailOperationDuration("Printed", Duration.between(email.getReceivedTime(), email.getPrintedTime())));
        expectedDurations.add(new EmailOperationDuration("Read", Duration.between(email.getReceivedTime(), email.getReadTime())));

        generateDashboard(emails);

        assertEquals(expectedDurations, durations);
    }

    @Test
    void testGenerateDashboard_MultipleEmailsWithDifferentOperations() {
        List<Email> emails = new ArrayList<>();
        Email email1 = new Email("sender1@example.com", "recipient1@example.com", "Subject1", "Body1");
        email1.setReceivedTime(LocalDateTime.now().minusDays(3));
        email1.setReadTime(LocalDateTime.now().minusDays(2));
        emails.add(email1);

        Email email2 = new Email("sender2@example.com", "recipient2@example.com", "Subject2", "Body2");
        email2.setReceivedTime(LocalDateTime.now().minusDays(3));
        email2.setPrintedTime(LocalDateTime.now().minusDays(1));
        emails.add(email2);

        Email email3 = new Email("sender3@example.com", "recipient3@example.com", "Subject3", "Body3");
        email3.setReceivedTime(LocalDateTime.now().minusDays(3));
        email3.setDeletedTime(LocalDateTime.now());
        emails.add(email3);

        List<EmailOperationDuration> expectedDurations = new ArrayList<>();
        expectedDurations.add(new EmailOperationDuration("Deleted", Duration.between(email3.getReceivedTime(), email3.getDeletedTime())));
        expectedDurations.add(new EmailOperationDuration("Printed", Duration.between(email2.getReceivedTime(), email2.getPrintedTime())));
        expectedDurations.add(new EmailOperationDuration("Read", Duration.between(email1.getReceivedTime(), email1.getReadTime())));

        generateDashboard(emails);

        assertEquals(expectedDurations, durations);
    }
}