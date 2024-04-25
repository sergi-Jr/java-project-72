drop table if exists urls;

create table urls(
    id bigint generated always as identity primary key,
    name varchar(150) unique not null,
    created_at timestamp not null
);