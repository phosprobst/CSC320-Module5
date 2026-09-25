import java.util.Scanner;

public class MonthlyTemperatures {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };

        double[] temperatures = {
            32.5, 35.8, 44.2, 52.6,
            62.3, 72.1, 78.5, 76.9,
            68.4, 55.7, 42.1, 33.8
        };

        System.out.print("Enter a month or enter \"year\" to view the entire year: ");
        String userChoice = input.nextLine();

        if (userChoice.equalsIgnoreCase("year")) {

            double total = 0;
            double highest = temperatures[0];
            double lowest = temperatures[0];

            System.out.println("\nMonthly Temperatures:");

            for (int i = 0; i < months.length; i++) {

                System.out.printf("%-10s %.1f degrees F%n",
                        months[i], temperatures[i]);

                total += temperatures[i];

                if (temperatures[i] > highest) {
                    highest = temperatures[i];
                }

                if (temperatures[i] < lowest) {
                    lowest = temperatures[i];
                }
            }

            double yearlyAverage = total / temperatures.length;

            System.out.printf("%nYearly Average: %.1f degrees F%n", yearlyAverage);
            System.out.printf("Highest Monthly Average: %.1f degrees F%n", highest);
            System.out.printf("Lowest Monthly Average: %.1f degrees F%n", lowest);

        } else {

            boolean monthFound = false;

            for (int i = 0; i < months.length; i++) {

                if (userChoice.equalsIgnoreCase(months[i])) {

                    System.out.printf("%s Average Temperature: %.1f degrees F%n",
                            months[i], temperatures[i]);

                    monthFound = true;
                    break;
                }
            }

            if (!monthFound) {
                System.out.println("Invalid month entered.");
            }
        }

        input.close();
    }
}