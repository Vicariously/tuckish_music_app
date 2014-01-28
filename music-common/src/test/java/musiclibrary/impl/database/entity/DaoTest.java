package musiclibrary.impl.database.entity;

import static org.junit.Assert.assertNotNull;
import musiclibrary.impl.common.dao.SongDao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Ignore
@ContextConfiguration(value = "classpath:testcontexts/music-common-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {

	private final static Logger logger = Logger.getLogger(DaoTest.class);
	private Session session;

	@Autowired
	private SongDao songDao;

	@Before
	public void pre() {
		logger.info("....Pre DAO Test: Testing Session Factory....");
		this.session = this.songDao.getSessionFactory().openSession();
		assertNotNull(session);
	}

	@Test
	@Transactional
	public void testDaos() {
		logger.info("....Testing the DAO Queries for Meghan's Awesome Music Application....");
		assertNotNull(this.songDao.findAll());
	}

	@After
	public void post() {
		this.session.close();
	}
}
