package AdditionalTask;

import java.util.Scanner;

public class CustomClass {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int choice = 0;
        do {
            System.out.print("""
                    --------------------------------------------------------------------------------------------------\s
                    Choose\s
                    1 - for string reverse\s
                    2 - for factorial calculate\s
                    0 - for exit\s
                    """);
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect value");
            }
            System.out.println("--------------------------------------------------------------------------------------------------\s");
            logic(choice);
        } while (choice != 0);
    }

    public static void logic(int value) {
        switch (value) {
            case 1 -> {
                CustomInterface<String> customInterface = v -> {
                    StringBuilder reverse = new StringBuilder();
                    char[] array = v.toCharArray();
                    for (int i = array.length - 1; i >= 0; i--) {
                        reverse.append(array[i]);
                    }
                    return reverse.toString();
                };
                System.out.print("Enter the string: ");
                String string = in.next();
                System.out.printf("The revers of '%s' is '%s'\n", string, customInterface.start(string));
            }
            case 2 -> {
                CustomInterface<Integer> customInterface = v -> {
                    int fact = 1;
                    for (int i = 2; i <= v; i++) {
                        fact *= i;
                    }
                    return fact;
                };
                System.out.print("Enter the integer value from 0 to 31: ");
                int fValue = in.nextInt();
                if (fValue < 32 && fValue >= 0) {
                    System.out.printf("The factorial of %d = %d\n", fValue, customInterface.start(fValue));
                } else {
                    System.out.println("Wrong value");
                }
            }
        }
    }

}
