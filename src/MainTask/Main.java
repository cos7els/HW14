package MainTask;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private final static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        start();
        in.close();
    }

    private static void start() {
        int choice = 0;
        do {
            System.out.print("""
                    --------------------------------------------------------------------------------------------------\s
                    Choose\s
                    1 - for get day of week by date\s
                    2 - for get date of next tuesday by date\s
                    0 - for exit\s
                    """);
            try {
                choice = in.nextInt();

            } catch (Exception e) {
                System.out.println("Incorrect value");
            }
            System.out.println("--------------------------------------------------------------------------------------------------\s");
            switch (choice) {
                case 1 -> dayOfWeek();
                case 2 -> nextTuesday();
            }
        } while (choice != 0);
    }

    private static void dayOfWeek() {
        LocalDate localDate = getDate();
        DayOfWeek localDay = localDate.getDayOfWeek();
        System.out.printf("%s it's %s\n", localDate.format(pattern), localDay.toString().toLowerCase());
    }

    private static void nextTuesday() {
        LocalDate localDate = getDate();
        LocalDate nextTuesday = null;
        switch (localDate.getDayOfWeek()) {
            case TUESDAY -> nextTuesday = localDate.plusDays(7);
            case WEDNESDAY -> nextTuesday = localDate.plusDays(6);
            case THURSDAY -> nextTuesday = localDate.plusDays(5);
            case FRIDAY -> nextTuesday = localDate.plusDays(4);
            case SATURDAY -> nextTuesday = localDate.plusDays(3);
            case SUNDAY -> nextTuesday = localDate.plusDays(2);
            case MONDAY -> nextTuesday = localDate.plusDays(1);
        }
        System.out.printf("The next tuesday date is %s\n", nextTuesday.format(pattern));
    }

    private static LocalDate getDate() {
        String date;
        LocalDate localDate = null;
        do {
            System.out.print("Enter the date in format dd.MM.yyyy: ");
            date = in.next();
            try {
                localDate = LocalDate.parse(date, pattern);
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect date format, let's try again");
            }
        } while (localDate == null);
        return localDate;
    }

}
