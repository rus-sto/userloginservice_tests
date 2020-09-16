package by.jrr.ruslan.userlogin.bean;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getLogin() {
        User user = new User();
        user.setLogin("Mama");
        String expected = "Mama";
        String actual = user.getLogin();
        assertEquals(expected,actual);
    }

    @Test
    public void getPassword() {
        User user = new User();
        user.setPassword("1234");
        String expected = "1234";
        String actual = user.getPassword();
        assertEquals(expected,actual);
    }


    @Test
    public void isUserIsBlockedTrue() {
            User user = new User();
            user.setUserIsBlocked(true);
            boolean expected = true;
            boolean actual = user.isUserIsBlocked();
            assertEquals(expected,actual);
        }
    @Test
    public void isUserIsBlockedFalse() {
        User user = new User();
        user.setUserIsBlocked(false);
        boolean expected = false;
        boolean actual = user.isUserIsBlocked();
        assertEquals(expected,actual);
    }

    @Test
    public void getNumberEntryAttemptLeft() {
        User user = new User();
        user.setNumberEntryAttemptLeft(2);
        int expected = 2;
        int actual = user.getNumberEntryAttemptLeft();
        assertEquals(expected,actual);
    }

    @Test
    public void testEqualsTrue() {
        User user1 = new User("Mama","123");
//        user1.setNumberEntryAttemptLeft(2);
//        user1.setPassword("123");
//        user1.setLogin("Mama");
//        user1.setUserIsBlocked(false);

        User user2 = new User("Mama","123");
//        user2.setNumberEntryAttemptLeft(2);
//        user2.setPassword("123");
//        user2.setLogin("Mama");
//        user2.setUserIsBlocked(false);

        boolean expected = true;
        boolean actual = user1.equals(user2);
    }
    @Test
    public void testEqualsFalse() {
        User user1 = new User("Mama","123");
//        user1.setNumberEntryAttemptLeft(2);
//        user1.setPassword("123");
//        user1.setLogin("Mama");
//        user1.setUserIsBlocked(false);

        User user2 = new User("Mama","1234");
//        user2.setNumberEntryAttemptLeft(2);
//        user2.setPassword("123");
//        user2.setLogin("Mam");
//        user2.setUserIsBlocked(false);

        boolean expected = false;
        boolean actual = user1.equals(user2);
    }

    @Test
    public void testHashCode() {
        User user = new User();
        user.setNumberEntryAttemptLeft(2);
        user.setPassword("123");
        user.setLogin("Mama");
        user.setUserIsBlocked(false);
        int expected =-1748326472;
        int actual= user.hashCode();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        User user = new User();
        user.setNumberEntryAttemptLeft(2);
        user.setPassword("123");
        user.setLogin("Mama");
        user.setUserIsBlocked(false);
        String expected ="User{login='Mama', password='123', userIsBlocked=false, numberEntryAttemptLeft=2}";
        String actual=user.toString();
       assertEquals(expected, actual);
    }
}