package Cafetera;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarbageTankTest {

    @Test void shouldFillTheMaximumCapacity(){
        int capacity = 50;
        GarbageTank borraTank = new GarbageTank(capacity);
        assertTrue( borraTank.canFillUp( capacity ));
    }

    @Test void shouldNotFillMoreThanTheCapacity(){
        int capacity = 50;
        GarbageTank borraTank = new GarbageTank(capacity);
        borraTank.fillUp(capacity);
        assertFalse( borraTank.canFillUp(10));
    }

    @Test void shouldNotFillTankIfItsFull(){
        int capacity = 50;
        GarbageTank borraTank = new GarbageTank(capacity);
        borraTank.fillUp(capacity);
        assertFalse( borraTank.fillUp(1 ));
    }

}