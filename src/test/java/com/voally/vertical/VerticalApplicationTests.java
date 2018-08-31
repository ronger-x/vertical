package com.voally.vertical;

import com.voally.vertical.util.GlobalFunc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VerticalApplicationTests {

    @Test
    public void contextLoads() {
        try {
            GlobalFunc.getTimeAgo(1535420978321L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
