package FaceBack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import panels.ImagePanel;

import acm.graphics.GImage;


public class FacePamphletHackingTest {
	private FacePamphletProfile profile;

	@Before
	public void setUp() throws Exception {
		profile = new FacePamphletProfile("Andy Derple");
	}

	/**
	 * Tests for the autohacking mode.
	 * Tests enabling, disabling, and ensures a "hack"
	 * occurs eventually.
	 * @author Cameron Ross
	 */
	@Test
	public void test() {
		try {
			profile.setHackMode();
		} catch (Exception e) {
			fail("Could not enable hacking mode");
		}
		try {
			profile.clearHackMode();
		} catch (Exception e) {
			fail("Could not disable hacking mode");
		}
		
		profile.setHackMode();
		String oldStatus = profile.getStatus();
		ImagePanel oldImage = profile.getImage();
		int nextHackTmp;
		while (profile.timeToNextHack() >= 0) {
			nextHackTmp = profile.timeToNextHack();
			profile.privateMessage("HACKTEST", "Empty");
			if (profile.timeToNextHack() == nextHackTmp)
				fail("Time to next hack did not change (" + profile.timeToNextHack() + ", " + nextHackTmp + ")");
			if (profile.timeToNextHack() > nextHackTmp)
				break;
		}
		assertFalse(profile.getStatus().equals(oldStatus));
		
	}

}
