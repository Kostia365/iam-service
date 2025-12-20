CREATE table posts
(
    id         bigserial primary key,
    title      varchar(255) not null,
    content    text         not null,
    created_at timestamp    not null default current_timestamp,
    likes      integer      not null default 0,
    unique (title)
);
insert into posts (title, content, created_at, likes)
values ('First post', 'This is my first post', current_timestamp, 0),
       ('Second post', 'This is my second post', current_timestamp, 10);