package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isEmailExist(String email) {
        String checkEmail = userRepository.findByEmail(email);
        if (checkEmail != null) {
            return true;
        }
        return false;
    }

    @Override
    public User isPasswordCorrect(String email, String password) {
        User userSuccessLogin = userRepository.findByPassword(email, password);
        if (userSuccessLogin != null) {
            return userSuccessLogin;
        }
        return null;
    }


    @Override
    public boolean insertUser(String email, String password) {
        userRepository.insertUser(email, password);
        return true;
    }
}
