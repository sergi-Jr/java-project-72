drop table if exists urls;

create table urls(
    id bigint generated always as identity primary key,
    name varchar(150) unique not null,
    created_at timestamp not null
);

drop table if exists url_checks;

create table url_checks(
    id bigint generated always as identity primary key,
    status_code int not null,
    title varchar(150),
    h1 varchar(150),
    description text,
    url_id bigint references urls(id),
    created_at timestamp not null
);