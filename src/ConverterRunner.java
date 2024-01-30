import java.util.Scanner;

class ConverterRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.println("1. Convert a number from Base 2, 8, 10, or 16 to other bases");
        System.out.println("2. Convert a Base 10 number to any base (1-64)");
        System.out.print("Choose an option (1 or 2): ");
        int option = scanner.nextInt();

        if (option == 1) {
            System.out.print("Enter the base of your number (2, 8, 10, or 16): ");
            int base = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter your number: ");
            String number = scanner.nextLine();
            NumberConverter nc = new NumberConverter(number, base);

            System.out.println("Converted Numbers:");
            if (base != 10) System.out.println("Decimal: " + nc.convertToDecimal());
            if (base != 2) System.out.println("Binary: " + nc.convertToBinary());
            if (base != 8) System.out.println("Octal: " + nc.convertToOctal());
            if (base != 16) System.out.println("Hexadecimal: " + nc.convertToHex());


        } else if (option == 2) {
            System.out.print("Enter a Base 10 number: ");
            String number = scanner.next();
            System.out.print("Enter the new base (1-64): ");
            int newBase = scanner.nextInt();
            NumberConverter nc = new NumberConverter(number, 10);
            System.out.println("Converted Number: " + nc.convertToBase(newBase));
        } else {
            System.out.println("Invalid option.");
        }
        scanner.close();
    }
}
