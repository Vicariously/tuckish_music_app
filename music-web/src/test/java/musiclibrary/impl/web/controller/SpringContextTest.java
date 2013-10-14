package src.test.java.musiclibrary.impl.web.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:test-music-application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringContextTest {
	private static final Logger LOG = Logger.getLogger(SpringContextTest.class);

	@Test
	public void testContext() {
		LOG.info("Loaded applciation context");
	}
}
