package by.jrr.ruslan.userlogin.service;

import by.jrr.ruslan.userlogin.bean.User;

public class UserLoginService {

    public boolean login(User user, String password) {
        if (checkIfPasswordEqualsUserPassword(user, password)){
            if (!isUserBlocked(user)){
                dropNumberEntryAttemptLeft(user);
             return true;
        }
            return  false;
    } else {
            decrementNumberEntryAttemptLeft(user);
            if (!ifNumberEntryAttemptLeftLeft(user)){
                blockUser(user);
            }

        }
    return false;
}
    public boolean checkIfPasswordEqualsUserPassword(User user, String password){
        return user.getPassword().equals(password);
    }
    public User dropNumberEntryAttemptLeft(User user){
         user.setNumberEntryAttemptLeft(3);
        return user;
    }
    public  boolean isUserBlocked(User user){
        return user.isUserIsBlocked();
           }
    public User decrementNumberEntryAttemptLeft(User user){
        user.setNumberEntryAttemptLeft(user.getNumberEntryAttemptLeft()-1);
        return user;
    }
    public User blockUser(User user){
         user.setUserIsBlocked(true);
                 return user;
    }
    public boolean ifNumberEntryAttemptLeftLeft (User user){
        return user.getNumberEntryAttemptLeft()>0;
    }

}
