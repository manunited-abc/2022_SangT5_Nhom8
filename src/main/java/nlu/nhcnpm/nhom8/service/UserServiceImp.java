package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
    public String encryptPassword(String password) {
        String encryptPassword = password;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptPassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptPassword;
    }

    @Override
    public boolean insertUser(String email, String password, String role) {
        User user = new User(email, password, role);
        userRepository.save(user);
        return true;
    }
}
