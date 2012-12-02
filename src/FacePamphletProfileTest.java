import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
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
	public void testGetBirthday() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		test.setBirthday(1,8);
		assertTrue(test.getBirthdayMonth()==1 && test.getBirthdayDate()==8);
		
	}
	
	@Test
	public void testSetBirthday() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		test.setBirthday(2,7);
		assertTrue(test.getBirthdayMonth()==2 && test.getBirthdayDate()==7);
	}
	
	@Test
	public void testAddFriend() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		FacePamphletProfile jimmy = new FacePamphletProfile("Jimmy");
		test.addFriend(jimmy);
		//assertEquals(1, test.getFriends().size());
		String friend = test.getFriends().get(0);
		assertEquals("Jimmy", friend);
	}

	@Test
	public void testRemoveFriend() {
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		FacePamphletProfile jimmy = new FacePamphletProfile("Jimmy");
		test.addFriend(jimmy);
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
		test.addFriend(jimmy);
		jimmy.addFriend(timmy);
		jimmy.addFriend(mom);
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
		jimmy.addFriend(timmy);
		jimmy.addFriend(mom);
		timmy.addFriend(shimmy);
		timmy.addFriend(joseph);
		timmy.addFriend(timmy);
		test.addFriend(jimmy);
		test.addFriend(timmy);
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Timmy");
		testList.add("Shimmy");
		testList.add("Joseph");
		testList.add("Your Mother");
		assertEquals(testList, test.getSecondOrderFriends());
	}
	
	@Test
	public void testAddBirthdayNotification()
	{
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		FacePamphletProfile jimmy = new FacePamphletProfile("Jimmy");
			
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("MM/dd");
		String dateNow = formatter.format(currentDate.getTime());

		jimmy.setBirthday(12,4);
		
		test.addFriend(jimmy);
		test.addBirthdayNotifications();
		
		assertTrue(test.getNotifications().contains("Jimmy's birthday is coming up on 12/4!!"));
	}
	
	
	@Test
	public void createSubProfileTest()
	{
		FacePamphletProfile test = new FacePamphletProfile("Test Profile");
		
		test.createSubProfile("Kitty");
		
		assertTrue(test.getSubProfile().equals(new FacePamphletProfile("Kitty")));
	}

		
}
