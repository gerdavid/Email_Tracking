# Email Dashboard

This Java application simulates an email dashboard that tracks the duration of various operations performed on emails, such as reading, printing, and deleting. It generates a report displaying the durations of these operations in descending order.

## Features

- Tracks the duration between receiving an email and performing operations like reading, printing, and deleting.
- Generates a report displaying the durations of email operations in descending order.
- Supports mock data generation for testing purposes.

## Classes

### EmailDashboard

The main class that contains the `main` method and the `generateDashboard` method.

- `main`: Creates mock email data and calls the `generateDashboard` method.
- `generateDashboard`: Calculates the durations for email operations, sorts them in descending order, and prints the report.

### EmailOperationDuration

A class representing the duration of an email operation (read, print, or delete).

- `operation`: The type of operation (read, print, or delete).
- `duration`: The duration between receiving the email and performing the operation.

### Email

A class representing an email with various properties and methods.

- `sender`: The email address of the sender.
- `recipient`: The email address of the recipient.
- `subject`: The subject of the email.
- `body`: The body content of the email.
- `receivedTime`: The timestamp when the email was received.
- `readTime`: The timestamp when the email was read.
- `printedTime`: The timestamp when the email was printed.
- `deletedTime`: The timestamp when the email was deleted.
- `isRead`: A flag indicating if the email has been read.
- `isPrinted`: A flag indicating if the email has been printed.
- `isDeleted`: A flag indicating if the email has been deleted.
- `markAsRead()`: Marks the email as read and sets the `readTime`.
- `markAsPrinted()`: Marks the email as printed and sets the `printedTime`.
- `markAsDeleted()`: Marks the email as deleted and sets the `deletedTime`.

## Usage

1. Clone the repository or download the source code.
2. Compile the Java files using a Java compiler.
3. Run the `EmailDashboard` class.
4. The application will generate mock email data and display the email operation durations report in the console.

## Example Output
