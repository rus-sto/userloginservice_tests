package by.jrr.ruslan.userlogin.service;

import by.jrr.ruslan.userlogin.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserLoginServiceTest {

    @Test
    public void loginTestReturnTrue() {
        User user= new User();
        user.setPassword("12345");
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = true;
        boolean actual = userLoginService.login(user, "12345" );
        assertEquals(expected,actual);
    }
    @Test
    public void loginTestReturnFalse() {
        User user= new User();
        user.setPassword("12345");
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = false;
        boolean actual = userLoginService.login(user, "1234" );
        assertEquals(expected,actual);
    }
    @Test
    public void checkIfPasswordEqualsUserPasswordReturnTrue() {
        User user= new User();
        user.setPassword("12345");
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = true;
        boolean actual = userLoginService.checkIfPasswordEqualsUserPassword(user, "12345" );
        assertEquals(expected,actual);
    }
    @Test
    public void checkIfPasswordEqualsUserPasswordReturnFalse() {
        User user= new User();
        user.setPassword("1234");
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = false;
        boolean actual = userLoginService.checkIfPasswordEqualsUserPassword(user, "12345" );
        assertEquals(expected,actual);
    }
    @Test
    public void dropNumberEntryAttemptLeftTest() {
        User user= new User();
        user.setNumberEntryAttemptLeft(1);
        UserLoginService userLoginService = new UserLoginService();
        User updatedUser = userLoginService.dropNumberEntryAttemptLeft(user);
        int expected = 3;
        int actual = updatedUser.getNumberEntryAttemptLeft();
        assertEquals(expected,actual);
    }
    @Test
    public void isUserBlockedTestReturnTrue() {
        User user= new User();
        user.setUserIsBlocked(true);
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = true;
        boolean actual = userLoginService.isUserBlocked(user);
        assertEquals(expected,actual);
    }
    @Test
    public void isUserBlockedTestReturnFalse() {
        User user= new User();
        user.setUserIsBlocked(false);
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = false;
        boolean actual = userLoginService.isUserBlocked(user);
        assertEquals(expected,actual);
    }
    @Test
    public void decrementNumberEntryAttemptLeft() {
        User user= new User();
        user.setNumberEntryAttemptLeft(3);
        UserLoginService userLoginService = new UserLoginService();
        int expected = 2;
        userLoginService.decrementNumberEntryAttemptLeft(user);
        int actual = user.getNumberEntryAttemptLeft();
        assertEquals(expected,actual);
    }
    @Test
    public void blockUserTest(){
        User user = new User();
        user.setUserIsBlocked(false);
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = true;
        userLoginService.blockUser(user);
        boolean actual = user.isUserIsBlocked();
        assertEquals(expected, actual);
    }
    @Test
    public void  ifNumberEntryAttemptLeftLeftTestTrue(){
        User user = new User();
        user.setNumberEntryAttemptLeft(1);
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = true;
        user.getNumberEntryAttemptLeft();
        boolean actual = userLoginService.ifNumberEntryAttemptLeftLeft(user);
        assertEquals(expected,actual);
    }
    @Test
    public void  ifNumberEntryAttemptLeftLeftTestFalse(){
        User user = new User();
        user.setNumberEntryAttemptLeft(0);
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = false;
        user.getNumberEntryAttemptLeft();
        boolean actual = userLoginService.ifNumberEntryAttemptLeftLeft(user);
        assertEquals(expected,actual);
    }
    @ Test
    public void loginShouldBlockUserTest(){
        User user =new User();
        user.setNumberEntryAttemptLeft(1);
        user.setPassword("12345");
        user.setUserIsBlocked(false);
        UserLoginService userLoginService = new UserLoginService();
        userLoginService.login(user, "123");
        boolean expected = true;
        boolean actual = user.isUserIsBlocked();
        assertEquals(expected, actual);
    }
    @Test
    public void loginShouldNotGoOn (){
        User user= new User();
        user.setNumberEntryAttemptLeft(0);
        user.setPassword("1234");
        user.setUserIsBlocked(true);
        UserLoginService userLoginService = new UserLoginService();
        boolean expected = false;
        boolean actual = userLoginService.login(user,"1234");
        assertEquals(expected,actual);

    }
}