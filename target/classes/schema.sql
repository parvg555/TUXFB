CREATE TABLE USERS(
    id bigserial primary key,
    user_name varchar(20) not null,
--    display_name varchar(255) NOT NULL,
    last_name varchar(20) not null,
    email varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    first_name varchar(20) NOT NULL
);

CREATE TABLE posts(
    id bigserial primary key,
    user_id bigserial not null,
    content varchar(255) not null,
    location varchar(255) not null,
    created_at timestamp default current_timestamp,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE comments(
    id bigserial primary key,
    post_id bigserial not null,
    user_id bigserial not null,
    content varchar(255) not null,
    created_at timestamp default current_timestamp,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);



--CREATE TABLE likes(
--    id int primary key,
--    post_id int not null,
--    user_id int not null,
--    created_at timestamp default current_timestamp,
--    FOREIGN KEY (post_id) REFERENCES posts(id),
--    FOREIGN KEY (user_id) REFERENCES users(id)
--);



CREATE TABLE follows(
    id bigserial primary key,
    follower_id bigserial not null,
    following_id bigserial not null,
    created_at timestamp default current_timestamp,
    FOREIGN KEY (follower_id) REFERENCES users(id),
    FOREIGN KEY (following_id) REFERENCES users(id)
);

