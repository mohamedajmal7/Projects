import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeTest {

    @Test
    void getDay() throws Exception{
        DateTime testDate=new DateTime(11,2,2020);
        assertEquals(11,testDate.getDay());

    }

    @Test
    void getMonth() {
        DateTime testDate=new DateTime(11,2,2020);
        assertEquals(2,testDate.getMonth());

    }

    @Test
    void getYear() {
        DateTime testDate=new DateTime(11,2,2020);
        assertEquals(2020,testDate.getYear());

    }
}