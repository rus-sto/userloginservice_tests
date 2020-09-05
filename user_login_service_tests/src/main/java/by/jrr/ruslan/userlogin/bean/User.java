package by.jrr.ruslan.userlogin.bean;

import java.util.Objects;

public class User {
    private String login;
    private String  password;
    private boolean userIsBlocked;
    private int numberEntryAttemptLeft;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserIsBlocked() {
        return userIsBlocked;
    }

    public void setUserIsBlocked(boolean userIsBlocked) {
        this.userIsBlocked = userIsBlocked;
    }

    public int getNumberEntryAttemptLeft() {
        return numberEntryAttemptLeft;
    }

    public void setNumberEntryAttemptLeft(int numberEntryAttemptLeft) {
        this.numberEntryAttemptLeft = numberEntryAttemptLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userIsBlocked == user.userIsBlocked &&
                numberEntryAttemptLeft == user.numberEntryAttemptLeft &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, userIsBlocked, numberEntryAttemptLeft);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userIsBlocked=" + userIsBlocked +
                ", numberEntryAttemptLeft=" + numberEntryAttemptLeft +
                '}';
    }


}
