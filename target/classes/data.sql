INSERT INTO USERS (user_name,last_name,email,password,created_at,first_name) VALUES ('AbhinaySingh','Singh','abhinays@gmail.com','Bhai@123',current_timestamp,'Abhinay');
INSERT INTO USERS (user_name,last_name,email,password,created_at,first_name) VALUES ('akanksha','singh','akanksha@gmail.com','hihi@123',current_timestamp,'akkku');
INSERT INTO USERS (user_name,last_name,email,password,created_at,first_name) VALUES ('AshimaPal','Pal','ashimas@gmail.com','CRY@123',current_timestamp,'ashipal');
INSERT INTO USERS (user_name,last_name,email,password,created_at,first_name) VALUES ('AlmariSingh','Singh','jcb@gmail.com','khdaai@123',current_timestamp,'Allu');
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