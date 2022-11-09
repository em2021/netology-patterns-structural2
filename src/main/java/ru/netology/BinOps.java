package ru.netology;

public class BinOps {
    public String sum(String a, String b) {
        if (checkIfStringIsBinary(a, b)) {
            return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
        } else {
            throw new NumberFormatException("One or more operands are not in binary format!");
        }
    }

    public String mult(String a, String b) {
        if (checkIfStringIsBinary(a, b)) {
            return Integer.toBinaryString(Integer.parseInt(a, 2) * Integer.parseInt(b, 2));
        } else {
            throw new NumberFormatException("One or more operands are not in binary format!");
        }
    }

    private static boolean checkIfStringIsBinary(String a, String b) {
        if (a.matches("[0-1]+") && b.matches("[0-1]+")) {
            return true;
        }
        return false;
    }
}
