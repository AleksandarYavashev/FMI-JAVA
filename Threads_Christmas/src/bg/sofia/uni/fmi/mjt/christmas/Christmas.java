package bg.sofia.uni.fmi.mjt.christmas;

public class Christmas {

    private Workshop workshop;

    /**
     * The number of kids that are going to send wishes to Santas's workshop.
     **/
    private int numberOfKids;

    /**
     * Christmas will start in {@code christmasTime} milliseconds.
     **/
    private static int christmasTime;

    public Christmas(Workshop workshop, int numberOfKids, int christmasTime) {
        this.workshop = workshop;
        this.numberOfKids = numberOfKids;
        this.christmasTime = christmasTime;
    }

    public static void main(String[] args) {
        Christmas christmas = new Christmas(new Workshop(), 100, 2000);
        christmas.celebrate();
    }

    public void celebrate() {
        Thread[] kids = new Thread[numberOfKids];
        for (int i = 0; i < numberOfKids; ++i) {
            kids[i] = new Thread(new Kid(workshop));
            kids[i].start();
        }

        try {
            Thread.sleep(christmasTime);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        getWorkshop().makeChristmas();

        synchronized (workshop) {
            workshop.makeChristmas();
            workshop.notifyAll();
        }


        System.out.println("Total gifts made: " + getWorkshop().getWishCount());
    }

    public Workshop getWorkshop() {
        return workshop;
    }
}