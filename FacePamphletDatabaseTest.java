import static org.junit.Assert.*;

import org.junit.Test;


public class FacePamphletDatabaseTest {

	@Test
	public void testAddProfile() {
		FacePamphletDatabase test = new FacePamphletDatabase();
		test.addProfile(new FacePamphletProfile("Test Profile"));
		assertTrue(test.containsProfile("Test Profile"));
	}

	@Test
	public void testGetProfile() {
		FacePamphletDatabase test = new FacePamphletDatabase();
		FacePamphletProfile testProfile = new FacePamphletProfile("Test Profile");
		test.addProfile(testProfile);
		assertTrue(test.getProfile("Test Profile").equals(testProfile));
	}

	@Test
	public void testDeleteProfile() {
		FacePamphletDatabase test = new FacePamphletDatabase();
		FacePamphletProfile testProfile = new FacePamphletProfile("Test Profile");
		test.addProfile(testProfile);
		test.deleteProfile("Test Profile");
		assertFalse(test.containsProfile("Test Profile"));
		
	}

	
	//NOT QUITE SURE HOW TO TEST THIS.
	//OTHER METHODS DEPEND ON IT, THOUGH.
	@Test
	public void testContainsProfile() {
		fail("Not yet implemented");
	}

}
