package bg.sofia.uni.fmi.mjt.cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class MemCacheTest {


    private MemCache<Integer, Integer> memCache;

    @Before
    public void setup() throws CapacityExceededException{
        memCache = new MemCache<>();
        LocalDateTime time = LocalDateTime.of(2020, Month.APRIL, 1, 1, 1);
        memCache.set(1, 111, time);
    }
    @Test
    public void getAndSet() {
        assertEquals((Integer)111, (Integer)memCache.get(1));
        assertNull(memCache.get(2));
    }

    @Test
    public void getExpiration() {
        LocalDateTime time = LocalDateTime.of(2020, Month.APRIL, 1, 1, 1);
        assertEquals(time, memCache.getExpiration(1));
    }

    @Test
    public void remove() {
        assertFalse(memCache.remove(2));
        assertTrue(memCache.remove(1));
    }

    @Test
    public void size() throws CapacityExceededException {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr){
            memCache.set(i, i, LocalDateTime.now());
        }

        assertEquals(5, memCache.size());
    }

    @Test
    public void clear() throws CapacityExceededException{
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr){
            memCache.set(i, i, LocalDateTime.now());
        }
        assertEquals(5, memCache.size());
        memCache.clear();
        assertEquals(0, memCache.size());
        assertEquals(0, memCache.getHitRate(), 0.0001);
    }

    @Test
    public void getHitRate() {

    }
}