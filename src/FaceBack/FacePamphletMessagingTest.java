package FaceBack;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FacePamphletMessagingTest {
	private FacePamphletProfile profile;
	private FacePamphletDatabase database;
	@Before
	public void setUp() throws Exception {
		database = new FacePamphletDatabase();
		profile = new FacePamphletProfile("Andy Derple");
	}
	/**
	 * Tests the public messaging system.
	 * Covers the basics of receiving a public message,
	 * as well as clearing public messages.
	 * @author Cameron Ross
	 */
	@Test
	public void publicMessageTest() {
		try {
			profile.publicMessage("Brobert", "Howdy");
		} catch (Exception e) {
			fail("Could not receive message: " + e.getMessage());
		}
		assertTrue(profile.publicMessages().size() > 0);
		assertArrayEquals(profile.publicMessages().get("Brobert").toArray(), new String[] { "Howdy" });
		try {
			profile.clearPublicMessages();
		} catch (Exception e) {
			fail("Could not clear public messages: " + e.getMessage());
		}
		assertNull(profile.publicMessages().get("Brobert"));
	}

	/**
	 * Tests the private messaging system.
	 * Covers the basics of receiving a private message,
	 * as well as clearing private messages.
	 * @author Cameron Ross
	 */
	@Test
	public void privateMessageTest() {
		try {
			profile.privateMessage("Brobert", "Howdy");
		} catch (Exception e) {
			fail("Could not receive message: " + e.getMessage());
		}
		assertTrue(profile.privateMessages().size() > 0);
		assertArrayEquals(profile.privateMessages().get("Brobert").toArray(), new String[] { "Howdy" });
		try {
			profile.clearPrivateMessages();
		} catch (Exception e) {
			fail("Could not clear private messages: " + e.getMessage());
		}
		assertNull(profile.privateMessages().get("Brobert"));
	}

}
