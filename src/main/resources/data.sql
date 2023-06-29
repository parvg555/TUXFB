INSERT INTO USERS (user_name,last_name,email,password,created_at,first_name) VALUES ('a','a','a@gmail.com','a',current_timestamp,'a');
INSERT INTO USERS (user_name,last_name,email,password,created_at,first_name) VALUES ('b','b','b@gmail.com','b',current_timestamp,'b');
INSERT INTO USERS (user_name,last_name,email,password,created_at,first_name) VALUES ('c','c','c@gmail.com','c',current_timestamp,'c');
INSERT INTO USERS (user_name,last_name,email,password,created_at,first_name) VALUES ('d','d','d@gmail.com','d',current_timestamp,'d');

INSERT INTO posts (user_id, content, location, created_at)
VALUES (1, 'Hello, world!', 'New York',current_timestamp),
       (2, 'This is a sample post.', 'London',current_timestamp),
       (3, 'Mock data for the win!', 'San Francisco',current_timestamp),
       (1, 'Mock data for ', 'San Fran',current_timestamp);

INSERT INTO comments (post_id, user_id, content,created_at)
VALUES (1, 2, 'Nice post!',current_timestamp),
       (1, 3, 'Keep up the good work!',current_timestamp),
       (2, 1, 'I agree with you.',current_timestamp),
       (3, 1, 'Great content.',current_timestamp),
       (3, 2, 'Interesting thoughts.',current_timestamp);
INSERT INTO follows (follower_id, following_id,created_at)
                                           VALUES (1, 2,current_timestamp),
                                                  (1, 3,current_timestamp),
                                                  (2, 3,current_timestamp);