package adapter;

public class Main {

    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setDay(7);
        date.setMonth(4);   // April
        date.setYear(2026);

        System.out.println("Initial date:");
        printDate(date);

        date.advanceDays(10);
        System.out.println("\nAfter advancing 10 days:");
        printDate(date);

        date.advanceDays(30);
        System.out.println("\nAfter advancing 30 more days:");
        printDate(date);
    }

    private static void printDate(NewDateInterface date) {
        System.out.println(
                date.getDay() + "-" +
                        date.getMonth() + "-" +
                        date.getYear()
        );
    }
}
