CREATE TABLE users (
                       id                  bigserial PRIMARY KEY,
                       username            varchar(30)  NOT NULL UNIQUE,
                       password            varchar(255) NOT NULL,
                       email               varchar(50)  NOT NULL UNIQUE,
                       created_at          timestamp    NOT NULL DEFAULT current_timestamp,
                       updated_at          timestamp    NOT NULL DEFAULT current_timestamp,
                       registration_status varchar(20)  NOT NULL, -- Исправлено с boolean на varchar
                       last_login          timestamp,
                       is_deleted          boolean      NOT NULL DEFAULT false
);

CREATE TABLE posts (
                       id         bigserial PRIMARY KEY,
                       author_id  bigint       NOT NULL REFERENCES users(id), -- Добавлена связь
                       title      varchar(255) NOT NULL UNIQUE,
                       content    text         NOT NULL,
                       created_at timestamp    NOT NULL DEFAULT current_timestamp,
                       updated_at timestamp    NOT NULL DEFAULT current_timestamp,
                       is_deleted boolean      NOT NULL DEFAULT false,
                       likes      integer      NOT NULL DEFAULT 0
);
INSERT INTO users (username, password, email, registration_status, last_login, is_deleted)
VALUES
    ('user2', 'password1', 'user1@gmail.com', 'ACTIVE', current_timestamp, false),
    ('user3', 'password2', 'user2@gmail.com', 'ACTIVE', current_timestamp, false),
    ('user4', 'password3', 'user3@gmail.com', 'ACTIVE', current_timestamp, false);

INSERT INTO posts (author_id, title, content, likes, is_deleted)
VALUES
    (1, 'post1', 'post content 1', 125, false),
    (2, 'post2', 'post content 2', 89, false),
    (3, 'post3', 'post content 3', 256, false);