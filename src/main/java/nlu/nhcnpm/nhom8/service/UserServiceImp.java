package nlu.nhcnpm.nhom8.service;

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
    public boolean isPasswordCorrect(String email, String password) {
        String checkPassword = userRepository.findByPassword(email, password);
        if (checkPassword != null) {
            return true;
        }
        return false;
    }
}
