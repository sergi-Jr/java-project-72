drop table if exists urls cascade;
drop table if exists url_checks;

create table urls(
    id bigint generated by default as identity not null,
    name varchar(150) unique not null,
    created_at timestamp not null,
    constraint pr_url primary key (id)
);

create table url_checks(
    id bigint generated by default as identity not null,
    url_id bigint not null,
    status_code int,
    title varchar(255),
    h1 varchar(255),
    description text,
    created_at timestamp not null,
    constraint pr_url_checks primary key (id)
);

alter table url_checks
    add constraint fk_url_checks_url_id foreign key (url_id) references urls (id) on delete restrict on update restrict;