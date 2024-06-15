package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.dto.UserRegisterDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private  final UserSession userSession;

    public UserService(ModelMapper modelMapper, UserRepository userRepository, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    public  boolean register(UserRegisterDTO data){

        if (!data.getPassword().equals(data.getConfirmPassword())){
            return false;
        }
        boolean isUsernameOrEmailTaken =
                userRepository.existsByUsernameOrEmail(data.getUsername(),data.getEmail());

        if (isUsernameOrEmailTaken) {
            return false;
        }
User mapped = modelMapper.map(data, User.class);

        mapped.setPassword(passwordEncoder.encode(mapped.getPassword()));

        userRepository.save(mapped);
        return true;

    }


    public boolean login(@NotNull UserLoginDTO data) {

     Optional<User>byUsername =
             userRepository.findByUsername(data.getUsername());

//     byUsername.filter()
//             .map(user -> userSession.login(user))
//             .isPresent();


     if (byUsername.isEmpty()){
         return false;
     }

     User user = byUsername.get();

     if (!passwordEncoder.matches(data.getPassword(), user.getPassword())){
         return false;
     }

     userSession.login(user);


     return true;

    }
    public void logout(){
        userSession.logout();
    }
}
