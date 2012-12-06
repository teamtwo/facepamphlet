package FaceBack;

/*
 * File: FacePamphletDatabase.java
 * -------------------------------
 * This class keeps track of the profiles of all users in the
 * FacePamphlet application.  Note that profile names are case
 * sensitive, so that "ALICE" and "alice" are NOT the same name.
 */

import java.util.*;
import javax.swing.JOptionPane;

public class FacePamphletDatabase implements FacePamphletConstants {

	private TreeMap<String, FacePamphletProfile> profileMap = new TreeMap<String, FacePamphletProfile>();

	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the database.
	 */

	public FacePamphletDatabase() 
	{
		//
	}


	/**
	 * 
	 * @author - Will Stone
	 *  
	 * This method adds the given profile to the database.  If the 
	 * name associated with the profile is the same as an existing 
	 * name in the database, the existing profile is replaced by 
	 * the new profile passed in.
	 */
	public void addProfile(FacePamphletProfile profile) 
	{
		try
		{
			if(!(profileMap.containsValue(profile)))
			{
				profileMap.put(profile.getName(), profile);
			}
			else
			{
				profileMap.remove(profile.getName());
				//profileMap.put(profile.getName(), profile);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, we couldn't add the desired profile!");
		}
	}


	/** 
	 * 
	 * @author - Will Stone
	 * 
	 * This method returns the profile associated with the given name 
	 * in the database.  If there is no profile in the database with 
	 * the given name, the method returns null.
	 */
	public FacePamphletProfile getProfile(String name) 
	{
		try
		{
			if(profileMap.containsKey(name))
			{
				return profileMap.get(name);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, we couldn't find the desired profile!");
		}
		return null;
	}

	
	
	
	/** 
	 * 
	 * @author - Will Stone
	 * 
	 * This method removes the profile associated with the given name
	 * from the database.  It also updates the list of friends of all
	 * other profiles in the database to make sure that this name is
	 * removed from the list of friends of any other profile.
	 * 
	 * If there is no profile in the database with the given name, then
	 * the database is unchanged after calling this method.
	 */
	public void deleteProfile(String name) {
		try
		{
			if(profileMap.containsKey(name))
			{
				profileMap.remove(name);
				for(FacePamphletProfile curr: profileMap.values())
				{
					if(curr.getFriendMap().containsKey(name))
					{
						curr.removeFriend(name);
					}
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong, we couldn't find the desired profile!");
		}
	}


	/** 
	 * 
	 * @author - Will Stone
	 * 
	 * This method returns true if there is a profile in the database 
	 * that has the given name.  It returns false otherwise.
	 */
	public boolean containsProfile(String name) 
	{
		boolean isThere = false;
		try
		{
			if(profileMap.containsKey(name))
			{
				isThere = true;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong... Terribly, terribly wrong...");
		}
		return isThere;
	}

	/**
	 * @author - Will Stone
	 * 
	 * @return
	 */
	public ArrayList<String> getSecondOrderFriends(FacePamphletProfile currUser, String desUser)
	{
		ArrayList<String> listOfSecondFriends = new ArrayList<String>();
		for(FacePamphletProfile friend: currUser.getFriendMap().values())
		{
			for(FacePamphletProfile friends: friend.getFriendMap().values())
			{
				listOfSecondFriends.add(friends.getName());
				if(friends.getName().equalsIgnoreCase(desUser))
				{
					listOfSecondFriends.add('*'+friend.getName());
				}
			}
		}
		return listOfSecondFriends;
	}
}