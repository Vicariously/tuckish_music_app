package context.application;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value="classpath:music-application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringContextTest {

	private static final Logger logger = Logger.getLogger(SpringContextTest.class);
	
	@Before
	public void pre(){
		logger.info("...........Testing the Production Application Context for Meghan's Awesome Music Application................");
	}
	
	@Test
	public void testContext() {
		//todo later
	}
}
