package bg.sofia.uni.fmi.mjt.christmas;

import java.util.LinkedList;
import java.util.Queue;

public class Workshop {

    private static final int elfCount = 5;

    private int elfID = 0;
    private int wishCount = 0;
    private boolean christmasTime = false;

    private Queue<Gift> wishes = new LinkedList<>();
    private Elf[] elves;


    public Workshop() {
        elves = new Elf[elfCount];
        startElves();
    }

    private void startElves() {
        for (int i = 0; i < elfCount; ++i) {
            elves[i] = new Elf(elfID++, this);
            elves[i].start();
        }
    }

    /**
     * Adds a gift to the elves' backlog.
     **/
    public synchronized void postWish(Gift gift) {
        wishes.add(gift);
        wishCount++;

        this.notify();
    }

    /**
     * Returns the next gift from the elves' backlog that has to be manufactured.
     **/
    public synchronized Gift nextGift() {
        while (!isChristmasTime() && wishes.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        return (wishes.isEmpty()) ? null : wishes.poll();
    }

    /**
     * Returns an array of the elves working in Santa's workshop.
     **/
    public Elf[] getElves() {
        return elves;
    }

    /**
     * Returns the total number of wishes sent to Santa's workshop by the kids.
     **/
    public int getWishCount() {
        return wishCount;
    }

    public boolean isChristmasTime() {
        return christmasTime;
    }


    public void makeChristmas() {
        christmasTime = true;
    }
}
