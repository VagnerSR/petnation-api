create table users (
    id bigint not null auto_increment,
    email varchar(100) not null,
    password varchar(255) not null,
    name varchar(100) not null,
    phone_number varchar(100),
    is_visible boolean not null default 0,
    verification_code varchar(100),

    primary key(id)
)