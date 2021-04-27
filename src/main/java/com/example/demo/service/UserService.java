package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.exception.UserNotFoundException;
import com.example.demo.model.requests.UserRequest;
import com.example.demo.repository.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUserById(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public List<User> findAllUsers(int pageNumber, int pageSize, String sortBy) {
        final Integer newPageNumber = pageNumber != 0 ? --pageNumber : pageNumber;
        Pageable pageable = PageRequest.of(newPageNumber, pageSize, Sort.by(sortBy));
        Page<User> pagedResult = repository.findAll(pageable);
        return pagedResult.getContent();
    }

    public User findUserByEmail(String email) throws UserNotFoundException {
        return repository.findUserByEmail(email);
    }
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public Boolean existsUserByEmail(String email) {
        return repository.existsUserByEmail(email);
    }

    public User saveUser(UserRequest userRequest){
        User user = new User();
        user.setFirstName(userRequest.getFistName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(this.passwordEncoder.encode(userRequest.getPassword()));
        user.setEnabled(true);
        return this.repository.save(user);
    }

}
