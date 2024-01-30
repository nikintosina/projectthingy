public class NumberConverter {
    private int[] digits;
    private int base;
    private static final String BASE_64_DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

    public NumberConverter(String number, int base) {
        this.base = base;
        this.digits = new int[number.length()];

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (base == 16) {
                if (c >= '0' && c <= '9') {
                    digits[i] = c - '0';
                } else if (c >= 'A' && c <= 'F') {
                    digits[i] = 10 + c - 'A';
                } else {
                    throw new IllegalArgumentException("Invalid hexadecimal number");
                }
            } else {
                if (c < '0' || c > '9') {
                    throw new IllegalArgumentException("Invalid number for base " + base);
                }
                digits[i] = c - '0';
            }
        }
    }

    public int convertToDecimal() {
        int decimal = 0;
        for (int i = 0; i < digits.length; i++) {
            decimal = decimal * base + digits[i];
        }
        return decimal;
    }

    public String convertToBinary() {
        return convertBase(2);
    }

    public String convertToOctal() {
        return convertBase(8);
    }

    public String convertToHex() {
        return convertBase(16);
    }

    private String convertBase(int targetBase) {
        int decimal = convertToDecimal();
        StringBuilder result = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % targetBase;
            if (remainder < 10) {
                result.insert(0, (char) ('0' + remainder));
            } else {
                result.insert(0, (char) ('A' + remainder - 10));
            }
            decimal = decimal / targetBase;
        }

        if (result.length() == 0) {
            return "0";
        } else {
            return result.toString();
        }
    }

    public String convertToBase(int newBase) {
        if (newBase < 1 || newBase > 64) {
            throw new IllegalArgumentException("Invalid base, must be between 1 and 64");
        }
        int decimal = convertToDecimal();
        StringBuilder result = new StringBuilder();
        while (decimal > 0) {
            int index = decimal % newBase;
            result.insert(0, BASE_64_DIGITS.charAt(index));
            decimal = decimal / newBase;
        }

        if (result.length() == 0) {
            return "0";
        } else {
            return result.toString();
        }
    }
}
