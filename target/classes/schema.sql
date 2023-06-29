CREATE TABLE USERS(
    id bigserial primary key,
    user_name varchar(20) not null unique,
--    display_name varchar(255) NOT NULL,
    last_name varchar(20) not null,
    email varchar(20) NOT NULL unique,
    password varchar(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    first_name varchar(20) NOT NULL
);

CREATE TABLE posts(
    id bigserial primary key,
    user_id bigserial not null,
    content varchar(255) not null,
    location varchar(255) not null,
    created_at timestamp default current_timestamp
);
CREATE TABLE comments(
    id bigserial primary key,
    post_id bigserial not null,
    user_id bigserial not null,
    content varchar(255) not null,
    created_at timestamp default current_timestamp
);

CREATE TABLE follows(
    id bigserial primary key,
    follower_id bigserial not null,
    following_id bigserial not null,
    created_at timestamp default current_timestamp
);

ALTER TABLE POSTS
    ADD FOREIGN KEY (USER_ID)
    REFERENCES USERS(ID)
ON DELETE CASCADE;

ALTER TABLE COMMENTS
    ADD FOREIGN KEY (USER_ID)
    REFERENCES USERS(ID)
ON DELETE CASCADE;

ALTER TABLE COMMENTS
    ADD FOREIGN KEY (POST_ID)
    REFERENCES POSTS(ID)
ON DELETE CASCADE;

ALTER TABLE FOLLOWS
    ADD FOREIGN KEY (FOLLOWER_ID)
    REFERENCES USERS(ID)
ON DELETE CASCADE;

ALTER TABLE FOLLOWS
    ADD FOREIGN KEY (FOLLOWING_ID)
    REFERENCES USERS(ID)
ON DELETE CASCADE;

