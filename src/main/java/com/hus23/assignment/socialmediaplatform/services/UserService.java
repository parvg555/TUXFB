package com.hus23.assignment.socialmediaplatform.services;

import com.hus23.assignment.socialmediaplatform.data.*;
import com.hus23.assignment.socialmediaplatform.pojo.PasswordChangeVO;
import com.hus23.assignment.socialmediaplatform.pojo.UserAndPostsVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PostsRepository postsRepository;

    private final FollowsRepository followsRepository;

    public UserService(
            UserRepository userRepository,
            PostsRepository postsRepository,
            FollowsRepository followsRepository
    ) {
        this.userRepository = userRepository;
        this.postsRepository= postsRepository;
        this.followsRepository = followsRepository;
    }
    public User addUser(User guest) {
        User guest1 = new User();
        guest1.setUsername(guest.getUsername());
        guest1.setFirstName(guest.getFirstName());
        guest1.setLastName(guest.getLastName());
        guest1.setEmailAddress(guest.getEmailAddress());
        guest1.setPass(guest.getPass());
        LocalDateTime now = LocalDateTime.now();
        guest1.setCreatedat(now);
        userRepository.save(guest1);
        return guest1;
    }

    public void updateUser(User updatedUser, Integer userId){
        userRepository.updateUser(
                    updatedUser.getUsername(),
                    updatedUser.getFirstName(),
                    updatedUser.getLastName(),
                    updatedUser.getEmailAddress(),
                    userId
        );
    }

    public String updatePassword(PasswordChangeVO passwordChangeVO, Integer userId){
        try{
            if(!Objects.equals(passwordChangeVO.getConfirmPassword(), passwordChangeVO.getPassword())){
                return "password and confirm password does not match!";
            }
            try {
                User user = userRepository.getById((long) userId);
                if(!Objects.equals(user.getPass(), passwordChangeVO.getOldPassword())){
                    return "old password incorrect!";
                }
            }catch(Exception e){
                return "invalid user id";
            }
            userRepository.updatePassword(passwordChangeVO.getPassword(), userId);
        }catch(Exception e){
            return "Internal Server Error!";
        }
        return "Password Updated!";
    }

    public void deleteUser(Integer userId){
        userRepository.deleteById((long) userId);
    }

    public UserAndPostsVO getDetails(Integer userId){
        UserAndPostsVO details = new UserAndPostsVO();
        User userDetails = new User();
        try{
            User user = userRepository.getById((long) userId);
            userDetails.setId(user.getId());
            userDetails.setUsername(user.getUsername());
            userDetails.setFirstName(user.getFirstName());
            userDetails.setLastName(user.getLastName());
            userDetails.setCreatedat(user.getCreatedat());
            userDetails.setEmailAddress(user.getEmailAddress());
            details.setUser(userDetails);
        }catch (Exception e){
            throw e;
        }
        details.setPosts(postsRepository.getPostsByUserId(userId));
        return details;
    }

    public List<User> getUsers(String query){
        try{
            List<User> users = userRepository.getUsersByQuery(query);
            for(int i=0;i<users.size();++i){
                users.get(i).setPass(null);
            }
            return users;
        }catch(Exception e){
            throw e;
        }
    }

    public void follow(Integer followerId, Integer followingId){
        try{
            Follows follows = new Follows();
            follows.setFollower_id(followerId);
            follows.setFollowing_id(followingId);
            followsRepository.save(follows);
        }catch(Exception e){
            throw e;
        }
    }

    public void unFollow(Integer followerId, Integer followingId){
        try{
            followsRepository.unfollow(followerId,followingId);
        }catch(Exception e){
            throw e;
        }
    }

}
