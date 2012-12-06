/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FaceBack;
import FaceBack.*;

/**
 *
 * @author Stuart Townsend
 */
public class FPTestNetwork {
	
        FacePamphletDatabase testDB = new FacePamphletDatabase();
        FacePamphletProfile testUser = new FacePamphletProfile("You. Yes, you!");
        FacePamphletProfile timmy = new FacePamphletProfile("You. Yes, you!");        
        FacePamphletProfile jimmy = new FacePamphletProfile("You. Yes, you!");
        FacePamphletProfile mom = new FacePamphletProfile("Your Mother");
        FacePamphletProfile dad = new FacePamphletProfile("Your Father");
        FacePamphletProfile stuart = new FacePamphletProfile("Stuart Townsend");
        FacePamphletProfile rocco = new FacePamphletProfile("Cameron Ross");
        FacePamphletProfile will = new FacePamphletProfile("Will Stone");
    
        public FPTestNetwork()
        {
        	addPeeps();
        	birthdays();
        	linkFriends();
        }

        public FacePamphletDatabase testDatabaseWithUsers()
        {
        	return testDB;
        }
        
        public void birthdays()
        {
        	testUser.setBirthday(1, 3);
        	rocco.setBirthday(5, 23);
        	stuart.setBirthday(9, 6);
        	will.setBirthday(8, 12);
        }
        
        
        public void addPeeps()
        {
            testDB.addProfile(testUser);
            testDB.addProfile(timmy);
            testDB.addProfile(jimmy);
            testDB.addProfile(mom);
            testDB.addProfile(dad);
            testDB.addProfile(stuart);
            testDB.addProfile(rocco);
            testDB.addProfile(will);
        }
        public void linkFriends()
        {
        	testUser.addFriend(rocco);
        	testUser.addFriend(stuart);
        	testUser.addFriend(will);
        	testUser.addFriend(mom);
        	testUser.addFriend(dad);
        	rocco.addFriend(stuart);
        	rocco.addFriend(will);
        	rocco.addFriend(testUser);
        	will.addFriend(rocco);
        	will.addFriend(stuart);
        	will.addFriend(testUser);
        	will.addFriend(timmy);
        	will.addFriend(jimmy);
        	timmy.addFriend(jimmy);
        	jimmy.addFriend(timmy);
        }
}