create table technic
(
    id           int auto_increment primary key,
    name         varchar(128) not null,
    producer     varchar(128) not null,
    produce_date date         not null,
    service_date date         not null,
    cost         double       not null
);

create table employee
(
    id           int auto_increment primary key,
    name         varchar(128) not null,
    surname      varchar(128) not null,
    position     varchar(128) not null,
    phone_number varchar(128)
);

create table surrender_technic
(
    id             int primary key auto_increment,
    user_id        int references employee (id),
    technic_id     int references technic (id),
    surrender_date date default null
);
