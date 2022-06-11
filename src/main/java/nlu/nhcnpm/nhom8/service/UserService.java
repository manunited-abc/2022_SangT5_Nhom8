package nlu.nhcnpm.nhom8.service;

import nlu.nhcnpm.nhom8.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public boolean isEmailExist(String email);
    public boolean isPasswordCorrect(String email, String password);
}
