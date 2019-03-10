package bg.sofia.uni.fmi.mjt.christmas;

public class Elf extends Thread{

    private Workshop workshop;
    public int ID;
    private int giftCount;

    public Elf(int id, Workshop workshop) {
        ID = id;
        this.workshop = workshop;
    }

    /**
     * Gets a wish from the backlog and creates the wanted gift.
     **/
    public void craftGift() {
        Gift gift = null;
        try{
            while((gift = workshop.nextGift()) != null){
                Thread.sleep(gift.getCraftTime());
                ++giftCount;
            }
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("Elf #" + ID +": " + giftCount + " gifts created.");
    }

    /**
     * Returns the total number of gifts that the given elf has crafted.
     **/
    public int getTotalGiftsCrafted() {
        return giftCount;
    }

    @Override
    public void run() {
        craftGift();
    }
}
