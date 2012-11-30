
import acm.graphics.*;
import java.util.*;

import javax.swing.JOptionPane;

public class FacePamphletProfile implements FacePamphletConstants {
	
	private String NAME;
	private int BIRTHDAY_MONTH;
	private int BIRTHDAY_DATE;
	private TreeMap<String, FacePamphletProfile> friendMap = new TreeMap<String, FacePamphletProfile>();
	private HashMap<String,ArrayList<String>>[] messages;
	private ArrayList<String> notifications;
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for
	 * the profile.
	 */
	public FacePamphletProfile(String name) {
		NAME = name;
		messages = (HashMap<String,ArrayList<String>>[]) new HashMap[2];
		messages[0] = new HashMap<String,ArrayList<String>>();
		messages[1] = new HashMap<String,ArrayList<String>>();
		notifications = new ArrayList<String>();
	}
	
	/**
	 * @author Sarah
	 * 
	 * Constructor
	 * Same as above but can create a profile with a birthday
	 * 
	 */
	public FacePamphletProfile(String name, int bdayMonth, int bdayDate)
	{
		NAME = name;
		BIRTHDAY_MONTH = bdayMonth;
		BIRTHDAY_DATE = bdayDate;
		messages = (HashMap<String,ArrayList<String>>[]) new HashMap[2];
		messages[0] = new HashMap<String,ArrayList<String>>();
		messages[1] = new HashMap<String,ArrayList<String>>();
		notifications = new ArrayList<String>();
		
	}

	/** This method returns the name associated with the profile. */ 
	public String getName() {
		return NAME;
	}
	
	public TreeMap<String, FacePamphletProfile> getFriendMap()
	{
		return friendMap;
	}

	/** 
	 * This method returns the image associated with the profile.  
	 * If there is no image associated with the profile, the method
	 * returns null. */ 
	public GImage getImage() {
		// You fill this in.  Currently always returns null.
		return null;
	}

	/** This method sets the image associated with the profile. */ 
	public void setImage(GImage image) {
		// You fill this in
	}
	
	/** 
	 * This method returns the status associated with the profile.
	 * If there is no status associated with the profile, the method
	 * returns the empty string ("").
	 */ 
	public String getStatus() {
		// You fill this in.  Currently always returns the empty string.
		return "";
	}
	
	/** This method sets the status associated with the profile. */ 
	public void setStatus(String status) {
		// You fill this in
	}
	
	/**
	 * @author Sarah van der Laan
	 * @return
	 * 
	 * This method returns the birthday month associated with the profile
	 * 
	 */
	public int getBirthdayMonth(){
		return BIRTHDAY_MONTH;}
	

	/**
	 * @author Sarah van der Laan
	 * @return
	 * 
	 * This method returns the birthday date associated with the profile
	 * 
	 */
	public int getBirthdayDate(){
		return BIRTHDAY_DATE;}
	
	/**
	 * @author Sarah van der Laan
	 * 
	 * This method sets the birthday associated with the profile
	 * 
	 */
	public void setBirthday(int month, int date){
		BIRTHDAY_MONTH = month;
		BIRTHDAY_DATE = date;
		}
	
	
	/** 
	 * This method adds the named friend to this profile's list of 
	 * friends.  It returns true if the friend's name was not already
	 * in the list of friends for this profile (and the name is added 
	 * to the list).  The method returns false if the given friend name
	 * was already in the list of friends for this profile (in which 
	 * case, the given friend name is not added to the list of friends 
	 * a second time.)
	 */
	
	public boolean addFriend(String friend) {
		boolean isAdded = false;
		try
		{
			if(!(friendMap.containsKey(friend)))
			{
				friendMap.put(friend, new FacePamphletProfile(friend));
				isAdded = true;
			}
			return isAdded;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, we couldn't add the desired profile!");
			return isAdded;
		}
	}


	/** 
	 * This method removes the named friend from this profile's list
	 * of friends.  It returns true if the friend's name was in the 
	 * list of friends for this profile (and the name was removed from
	 * the list).  The method returns false if the given friend name 
	 * was not in the list of friends for this profile (in which case,
	 * the given friend name could not be removed.)
	 */
	public boolean removeFriend(String friend) {
		boolean isRemoved = true;
		try
		{
			if(friendMap.containsKey(friend))
			{
				friendMap.remove(friend);
				isRemoved = false;
			}
			return isRemoved;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, we couldn't remove the desired profile!");
			return isRemoved;
		}
	}

	/** 
	 * This method returns an iterator over the list of friends 
	 * associated with the profile.
	 * 
	 * @return an ArrayList<String> of this profile's friends' profile names
	 */ 
	public ArrayList<String> getFriends() 
	{
		ArrayList<String> friendList = new ArrayList<String>();
		for(FacePamphletProfile friend: friendMap.values())
		{
			friendList.add(friend.getName());
		}
		return friendList;
	}
	
	public ArrayList<String> getFriendsOf(FacePamphletProfile friend)
	{
		ArrayList<String> friendsList = new ArrayList<String>();
		for(FacePamphletProfile friends: friend.friendMap.values())
		{
			if(!(this.friendMap.containsKey(friends.getName()))&& !(friends.getName().equalsIgnoreCase(this.getName())))
			{
				friendsList.add(friends.getName());
			}
		}
		return friendsList;
	}
	
	public ArrayList<String> getSecondOrderFriends()
	{
		ArrayList<String> listOfSecondFriends = new ArrayList<String>();
		for(FacePamphletProfile friend: this.friendMap.values())
		{
			for(FacePamphletProfile friends: friend.friendMap.values())
			{
				
				listOfSecondFriends.add(friends.getName());
			}
		}
		return listOfSecondFriends;
	}
	

	/*ArrayList<String> friendsList = new ArrayList<String>();
	ArrayList<String> secondFriends = new ArrayList<String>();
	for(int i = 0; i < friendMap.size(); i++)
	{
		/*String friend = getFriends().get(i);
		FacePamphletProfile newFriend = friendMap.get(friend);
		friendsList = newFriend.getFriends();
		friendsList = friendMap.get(getFriends().get(i)).getFriends();
		for(int j = 0; j < friendsList.size(); j++)
		{
			//secondFriends.add(friendsList.get(j));
			System.out.println(friendsList.get(j));
		}
	}*/
	/**
	 * Internal function to receive a message from another user
	 * @param from user to receive message from
	 * @param message message being received
	 * @param isPrivate whether or not a message is a private message
	 * @author Cameron Ross
	 */
	private void addMessage(String from, String message, boolean isPrivate) {
		HashMap<String,ArrayList<String>> msgs;
		if (isPrivate)
			msgs = messages[0];
		else
			msgs = messages[1];
		if (!msgs.containsKey(from))
			msgs.put(from, new ArrayList<String>());
		msgs.get(from).add(message);
		
	}
	/**
	 * Internal function for retrieving messages sent to this user.
	 * @param isPrivate Whether or not it should retrieve private messages
	 * @return A map of users and their corresponding messages
	 * @author Cameron Ross
 	 */
	private Map<String, ArrayList<String>> getMessages(boolean isPrivate) {
		HashMap<String,ArrayList<String>> msgs;
		if (isPrivate)
			msgs = messages[0];
		else
			msgs = messages[1];
		return (Map<String, ArrayList<String>>) msgs.clone();
	}
	/**
	 * Internal function for clearing messages
	 * @param isPrivate Whether or not it should clear private messages
	 * @author Cameron Ross
	 */
	private void clearMessages(boolean isPrivate) {
		HashMap<String,ArrayList<String>> msgs;
		if (isPrivate)
			msgs = messages[0];
		else
			msgs = messages[1];
		msgs.clear();
	}
	/** 
	 * This method returns a string representation of the profile.  
	 * This string is of the form: "name (status): list of friends", 
	 * where name and status are set accordingly and the list of 
	 * friends is a comma separated list of the names of all of the 
	 * friends in this profile.
	 * 
	 * For example, in a profile with name "Alice" whose status is 
	 * "coding" and who has friends Don, Chelsea, and Bob, this method 
	 * would return the string: "Alice (coding): Don, Chelsea, Bob"
	 */ 
	public String toString() {
		return NAME+" ("+getStatus()+"): "+getFriends().toString();
	}
	/**
	 * Receive a private message.
	 * @param from User this message is originating from
	 * @param message Message to receive
	 * @author Cameron Ross
	 */
	public void privateMessage(String from, String message) {
		addMessage(from, message, true);
		addNotification("Received a private message from " + from);
	}
	/**
	 * Receive a public message. These messages will be readable
	 * by other users
	 * @param from User this message is originating from
	 * @param message Message to receive
	 * @author Cameron Ross
	 */
	public void publicMessage(String from, String message) {
		addMessage(from, message, false);
		addNotification("Received a public message from " + from);
	}
	/**
	 * Retrieve a list of private messages for this profile.
	 * @return All private messages received by this user.
	 * @author Cameron Ross
	 */
	public Map<String, ArrayList<String>> privateMessages() {
		return getMessages(true);
	}

	/**
	 * Retrieve a list of public messages for this profile.
	 * @return All public messages received by this user.
	 * @author Cameron Ross
	 */
	public Map<String, ArrayList<String>> publicMessages() {
		return getMessages(false);
	}

	/**
	 * Clear all private messages received by this user.
	 * @author Cameron Ross
	 */
	public void clearPrivateMessages() {
		clearMessages(true);
	}
	/**
	 * Clear all public messages received by this user.
	 * @author Cameron Ross
	 */
	public void clearPublicMessages() {
		clearMessages(false);
	}
	/**
	 * Add notification for this user.
	 * @param message A notification for this user to receive
	 * @author Cameron Ross
	 */
	public void addNotification(String message) {
		notifications.add(message);
	}
	/**
	 * Retrieves a list of unread notifications.
	 * @return a list of notifications for this user.
	 * @author Cameron Ross
	 */
	public List<String> getNotifications() {
		return (ArrayList<String>) notifications.clone();
	}
	/**
	 * Clear a single notification.
	 * @param id The ID number of the notification to clear.
	 * @author Cameron Ross
	 */
	public void clearNotification(int id) {
		notifications.remove(id);
	}
	/**
	 * Clears all notifications this user has received
	 * @author Cameron Ross
	 */
	public void clearAllNotifications() {
		while(notifications.size() > 0)
			clearNotification(0);
	}
	
	
	/**
	 * @author Sarah van der Laan
	 */
	public void addBirthdayNotifications(){
		for(FacePamphletProfile friend: friendMap.values())
		{
			Calendar cal = Calendar.getInstance();
			
			if(friend.getBirthdayMonth()==cal.MONTH && (friend.getBirthdayDate()-cal.DATE) < 7)
			{
				notifications.add(friend + "'s birthday is coming up on " + friend.getBirthdayMonth() + "/" + friend.getBirthdayDate() + "!!");
			}
			/**
			else if(friend.getBirthdayDate()==31 && friend.getBirthdayMonth() == cal.MONTH-1)
				notifications.add(friend + "'s birthday is coming up on " + friend.getBirthdayMonth() + "/" + friend.getBirthdayDate() + "!!");
				*/  //NEED TO COVER OTHER CASES
		}
	}

}