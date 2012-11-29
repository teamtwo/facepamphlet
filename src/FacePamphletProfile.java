
import acm.graphics.*;
import java.util.*;
import javax.swing.JOptionPane;

public class FacePamphletProfile implements FacePamphletConstants {
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for
	 * the profile.
	 */
	private String NAME;
	private TreeMap<String, FacePamphletProfile> friendMap = new TreeMap<String, FacePamphletProfile>();
	/**COMMIT!!!!*/
	public FacePamphletProfile(String name) {
		NAME = name;
	}

	/** This method returns the name associated with the profile. */ 
	public String getName() {
		return NAME;
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
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, we couldn't add the desired profile!");
		}
		return isAdded;
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
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, we couldn't add the desired profile!");
		}
		return isRemoved;
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
		ArrayList<String> friendsList = new ArrayList<String>();
		for(int i = 0; i < friendMap.size(); i++)
		{
			String friend = getFriends().get(i);
			FacePamphletProfile newFriend = friendMap.get(friend);
			//System.out.println("current friend: "+friend);
			//System.out.println("outer: "+newFriend);
			//System.out.println(getFriendsOf(friendMap.get(friend)));
			for(int j = 0; j < getFriendsOf(newFriend).size(); j++) 
			{
				//System.out.println(getFriendsOf(friendMap.get(friend)).get(j));
				friendsList.add(getFriendsOf(friendMap.get(friend)).get(j));
			}
		}
		return friendsList;
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
		// You fill this in.  Currently always returns the empty string.
		return "";
	}
}