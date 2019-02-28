package bg.sofia.uni.fmi.mjt.carstore.enums;

import java.util.Random;

public enum Region {

    SOFIA("CA"),
    BURGAS("A"),
    VARNA("B"),
    PLOVDIV("PB"),
    RUSE("P"),
    GABROVO("EB"),
    VIDIN("BH"),
    VRATSA("BP");

    private final String prefix;

    private Region(String str){
        prefix = str;
    }

    public String getPrefix(){
        return prefix;
    }

    public String getRegNumber() {
        return String.format("%s%d%c%c", prefix, current++, getRandomChar(), getRandomChar());
    }

    private char getRandomChar() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'A');
    }

    private int current = 1000;
}
