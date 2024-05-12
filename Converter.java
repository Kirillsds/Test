package Testovoe;

import java.util.TreeMap;

public class Converter {
    TreeMap<Integer, String> romeNumber = new TreeMap<>();

    public Converter() {
        romeNumber.put(50, "L");
        romeNumber.put(40, "XL");
        romeNumber.put(10, "X");
        romeNumber.put(9, "IX");
        romeNumber.put(5, "V");
        romeNumber.put(4, "IV");
        romeNumber.put(1, "I");

    }

    public String intToRoman(int number){
        StringBuilder roman = new StringBuilder();
        int arabianKey;
        while (number !=0){
            arabianKey = romeNumber.floorKey(number);
            roman.append(romeNumber.get(arabianKey));
            number -= arabianKey;
        }
        return roman.toString();
    }
}

