package xyz.somersames.job;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.somersames.BaseTest;

import static org.junit.Assert.*;

public class JStatTaskTest extends BaseTest {

    @Autowired
    JStatTask jStatTask;

    @Test
    public void start() {
        jStatTask.start();
    }
}