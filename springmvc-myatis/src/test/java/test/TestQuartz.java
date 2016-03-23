package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath*:beans/**/*.xml")
@ContextConfiguration(locations = "classpath*:/spring/quartz.xml")
public class TestQuartz {
	@Test
	public void testJobq() throws InterruptedException{
		Thread.sleep(2000000);
	}
}
