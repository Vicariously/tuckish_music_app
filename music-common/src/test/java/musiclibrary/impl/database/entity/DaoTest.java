package musiclibrary.impl.database.entity;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value = "classpath:/testcontexts/music-common-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {

	private final static Logger logger = Logger.getLogger(DaoTest.class);
	
	@Before
	public void pre(){
		logger.info("...........Testing the DAO Queries for Meghan's Awesome Music Application................");
	}
	
	@Test
	public void testDaos(){
		
	}
}
