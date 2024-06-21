import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        if (parts.length!= 3) {
            throw new RuntimeException("Invalid input");
        }
        String str1 = parts[0].replace("\"", "");
        String operation = parts[1];
        String str2 = parts[2].replace("\"", "");

        if (!str1.matches("[a-zA-Z0-9-!?,.]+") || str1.length() > 10) {
            throw new RuntimeException("Invalid string");
        }

        if (operation.equals("+")) {
            System.out.println(concatenate(str1, str2));
        } else if (operation.equals("-")) {
            System.out.println(subtract(str1, str2));
        } else if (operation.equals("*")) {
            int num;
            try {
                num = Integer.parseInt(str2);
                if (num < 1 || num > 10) {
                    throw new RuntimeException("Number must be between 1 and 10");
                }
                System.out.println(multiply(str1, num));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid number");
            }
        } else if (operation.equals("/")) {
            int num;
            try {
                num = Integer.parseInt(str2);
                if (num < 1 || num > 10) {
                    throw new RuntimeException("Number must be between 1 and 10");
                }
                System.out.println(divide(str1, num));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid number");
            }
        } else {
            throw new RuntimeException("Invalid operation");
        }
    }

    private static String concatenate(String str1, String str2) {
        String result = str1 + str2;
        if (result.length() > 40) {
            return result.substring(0, 40) + "...";
        }
        return result;
    }

    private static String subtract(String str1, String str2) {
        String result = str1.replace(str2, "");
        if (result.endsWith(" ")) {
            result = result.trim();
        }
        if (result.length() > 40) {
            return result.substring(0, 40) + "...";
        }
        return result;
    }

    private static String multiply(String str, int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(str);
        }
        String resultStr = result.toString();
        if (resultStr.length() > 40) {
            return resultStr.substring(0, 40) + "...";
        }
        return resultStr;
    }

    private static String divide(String str, int num) {
        if (str.length() < num) {
            return "";
        }
        String result = str.substring(0, str.length() / num);
        if (result.length() > 40) {
            return result.substring(0, 40) + "...";
        }
        return result;
    }
}