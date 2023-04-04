
import org.junit.*;

public class ClockTest {

    @Test
    public void testCreateClock(){
        int hours = 12;
        int minutes = 23;
        int seconds = 59;

        Clock c1 = new Clock(hours,minutes,seconds);
        Assert.assertNotNull(c1);

        Assert.assertEquals(hours,c1.getHours());
        Assert.assertEquals(minutes,c1.getMinutes());
        Assert.assertEquals(seconds,c1.getSeconds());

    }

    @Test
    public void testCheckDefaultClock(){
        int hours = 12;
        int minutes = 0;
        int seconds = 0;

        Clock c1 = new Clock();
        Assert.assertNotNull(c1);

        Assert.assertEquals(hours, c1.getHours());
        Assert.assertEquals(minutes,c1.getMinutes());
        Assert.assertEquals(seconds,c1.getSeconds());
    }

    @Test
    public void testCheckOnlySecondsClock(){
        // 12800sec
        int hours = 3;
        int minutes = 33;
        int seconds = 20;

        Clock c1 = new Clock(12800);
        Assert.assertNotNull(c1);

        Assert.assertEquals(hours, c1.getHours());
        Assert.assertEquals(minutes, c1.getMinutes());
        Assert.assertEquals(seconds, c1.getSeconds());

    }


    @Test(expected = IllegalArgumentException.class)
    public void testHandlingWrongParams(){
        int hours = 25;
        int minutes = 30;
        int seconds = 62;
        Clock c1 = new Clock(hours,minutes,seconds);
        Assert.assertNotNull(c1);

    }

    @Test
    public void testTick(){
        int hours = 22;
        int minutes = 59;
        int seconds = 59;

        Clock c1 = new Clock(hours,minutes,seconds);
        Assert.assertNotNull(c1);

        c1.tick();
        Assert.assertEquals(hours+1,c1.getHours());
        Assert.assertEquals(0,c1.getMinutes());
        Assert.assertEquals(0,c1.getSeconds());

    }

    @Test
    public void testTickDown(){
        int hours = 22;
        int minutes = 0;
        int seconds = 0;

        Clock c1 = new Clock(hours,minutes,seconds);
        Assert.assertNotNull(c1);

        c1.tickDown();
        Assert.assertEquals(hours-1,c1.getHours());
        Assert.assertEquals(59,c1.getMinutes());
        Assert.assertEquals(59,c1.getSeconds());

    }

    @Test
    public void testToStringMethodFormat(){
        String expected = "12:39:59";
        int hours = 12;
        int minutes = 39;
        int seconds = 59;

        Clock c1 = new Clock(hours,minutes,seconds);
        Assert.assertNotNull(c1);

        Assert.assertEquals(expected, c1.toString());
    }

}
