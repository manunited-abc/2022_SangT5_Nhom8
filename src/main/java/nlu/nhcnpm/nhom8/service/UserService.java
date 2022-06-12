package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    public boolean isEmailExist(String email);
    public User isPasswordCorrect(String email, String password);
    public boolean insertUser(String email, String password);
}
