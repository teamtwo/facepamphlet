

import static org.junit.Assert.*;

import org.junit.Test;
import acm.graphics.*;

public class FacePamphletProfileTest {

	@Test
	public void testGetName() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		assertTrue(test.getName().equals("Test Profile"));
	}

	@Test
	public void testGetImage() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		GImage testImage = new GImage("test");
		test.setImage(testImage);
		assertTrue(test.getImage().equals(testImage));
	}

	@Test
	public void testSetImage() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		GImage testImage = new GImage("test");
		test.setImage(testImage);
		assertEquals(testImage, test.getImage());
	}

	@Test
	public void testGetStatus() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		test.setStatus("Busy");
		assertTrue(test.getStatus().equals("Busy"));
	}

	@Test
	public void testSetStatus() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		test.setStatus("Busy");
		assertEquals("Busy", test.getStatus());
	}

	// FOR THE LAST 3, WE NEED TO HAVE SOLID IDEA OF HOW FRIENDS ARE BEING STORED
	// DID WE DECIDE ON TREEMAP?
	@Test
	public void testAddFriend() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFriend() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFriends() {
		fail("Not yet implemented");
	}

}