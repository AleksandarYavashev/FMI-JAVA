package bg.sofia.uni.fmi.mjt.christmas;

import java.util.Random;

public class Kid implements Runnable{

    private final static int MAX_TIME = 4000;

    private Workshop workshop;
    private Random random = new Random();

    public Kid(Workshop workshop) {
        this.workshop = workshop;
    }

    /**
     * Sends a wish for the given gift to Santa's workshop.
     **/
    public void makeWish() {
        if(!workshop.isChristmasTime()){
            Gift gift = Gift.getGift();
            workshop.postWish(gift);
        }
    }

    @Override
    public void run(){
        try{
            Thread.sleep(random.nextInt(MAX_TIME));
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }

        makeWish();
    }

}
