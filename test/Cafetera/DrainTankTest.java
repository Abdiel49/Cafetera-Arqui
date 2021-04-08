package Cafetera;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrainTankTest {

    @Test void shouldNotDrainIfTankIsEmpty(){
        int capacity = 1500;
        DrainTank drainTank = new DrainTank(capacity);
        assertFalse( drainTank.drain(250));
    }

    @Test void fillCapacityAndDrainAQuantity(){
        int capacity = 1500;
        DrainTank drainTank = new DrainTank(capacity);
        drainTank.fillTank();
        assertTrue( drainTank.drain(capacity));
    }

    @Test void shouldBeAbleToDrainAnAmountIfPossible(){
        int capacity = 1500;
        DrainTank drainTank = new DrainTank(capacity);
        drainTank.fillTank();
        assertTrue( drainTank.canDrain(capacity));
    }

    @Test void shouldNotBeAbleToEmptyMoreThanItContains(){
        int capacity = 1500;
        DrainTank drainTank = new DrainTank(capacity);
        drainTank.fillTank();
        assertFalse( drainTank.canDrain(capacity + 1));
    }
}