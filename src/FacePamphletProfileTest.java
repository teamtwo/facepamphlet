import static org.junit.Assert.*;
import java.util.*;
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
	
	@Test
	public void testAddFriend() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		FacePamphletProfile jimmy = new FacePamphletProfile("Jimmy");
		test.addFriend(jimmy.getName());
		//assertEquals(1, test.getFriends().size());
		String friend = test.getFriends().get(0);
		assertEquals("Jimmy", friend);
	}

	@Test
	public void testRemoveFriend() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		FacePamphletProfile jimmy = new FacePamphletProfile("Jimmy");
		test.addFriend(jimmy.getName());
		test.removeFriend(jimmy.getName());
		assertEquals(0, test.getFriends().size());
	}
	
	@Test
	public void testGetFriendsOf()
	{
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		FacePamphletProfile jimmy = new FacePamphletProfile("Jimmy");
		FacePamphletProfile timmy = new FacePamphletProfile("Timmy");
		FacePamphletProfile mom = new FacePamphletProfile("Your Mother");
		test.addFriend(jimmy.getName());
		jimmy.addFriend(timmy.getName());
		jimmy.addFriend(mom.getName());
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Timmy");
		testList.add("Your Mother");
		assertEquals(testList, test.getFriendsOf(jimmy));
	}
	
	@Test
	public void testGetSecondOrderFriends()
	{
		FacePamphletDatabase theBase = new FacePamphletDatabase();
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		FacePamphletProfile jimmy = new FacePamphletProfile("Jimmy");
		FacePamphletProfile timmy = new FacePamphletProfile("Timmy");
		FacePamphletProfile shimmy = new FacePamphletProfile("Shimmy");
		FacePamphletProfile joseph = new FacePamphletProfile("Joseph");
		FacePamphletProfile mom = new FacePamphletProfile("Your Mother");
		theBase.addProfile(test);
		theBase.addProfile(jimmy);
		theBase.addProfile(timmy);
		theBase.addProfile(shimmy);
		theBase.addProfile(joseph);
		theBase.addProfile(mom);
		jimmy.addFriend(timmy.getName());
		jimmy.addFriend(mom.getName());
		timmy.addFriend(shimmy.getName());
		timmy.addFriend(joseph.getName());
		timmy.addFriend(timmy.getName());
		test.addFriend(jimmy.getName());
		test.addFriend(timmy.getName());
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Timmy");
		testList.add("Shimmy");
		testList.add("Joseph");
		testList.add("Your Mother");
		assertEquals(testList, test.getSecondOrderFriends());
	}
}
