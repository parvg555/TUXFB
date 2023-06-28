package com.hus23.assignment.socialmediaplatform.services;

import com.hus23.assignment.socialmediaplatform.data.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final commentsRepository commentRepository;
    private final followsRepository followRepository;

    private  final PostsRepository postRepository;
    private final UserRepository userRepository;

    public UserService(commentsRepository commentRepository, followsRepository followRepository, PostsRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.followRepository = followRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    public void addUser(User guest) {
        Iterable<User> guests = this.userRepository.findAll();
        User guest1 = new User();
//        guest1.setGuestId(guest.getGuestId());
        guest1.setUsername(guest.getUsername());
        guest1.setFirstName(guest.getFirstName());
        guest1.setLastName(guest.getLastName());
        guest1.setEmailAddress(guest.getEmailAddress());
        guest1.setPass(guest.getPass());
        guest1.setCreatedat(guest.getCreatedat());
        userRepository.save(guest1);
    }

    public List<?> getUsers() {
        Iterable<User> users = this.userRepository.findAll();
        List<User> userList= new ArrayList<>();
        users.forEach(userList::add);
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getLastName().equals(o2.getLastName())){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return userList;
    }
    public void deleteUser(long userId) {
        List<User> users= this.userRepository.findAll();
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == userId) {
                iterator.remove();
            }
        }
    }

    public List<?> loginuserdetails(long userID) {
//        Iterable<User> users = this.userRepository.findAll();
        Optional<Posts> posts = this.postRepository.findById(userID);
        List<Posts> postList= new ArrayList<>();

        
        postList.sort(new Comparator<Posts>() {
            @Override
            public int compare(Posts o1, Posts o2) {
                if (o1.getCreatedat().equals(o2.getCreatedat())){
                    return o1.getCreatedat().compareTo(o2.getCreatedat());
                }
                return o1.getCreatedat().compareTo(o2.getCreatedat());
            }
        });
        return postList;

    }
}
