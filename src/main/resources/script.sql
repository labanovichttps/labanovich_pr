create table technic
(
    id           int auto_increment
        primary key,
    name         varchar(128)              not null,
    producer     varchar(128)              not null,
    produce_date date                      not null,
    service_date date                      not null,
    cost         double                    not null,
    isSurrender  varchar(20) default 'Нет' not null
);

create table employee
(
    id           int auto_increment
        primary key,
    name         varchar(128) not null,
    surname      varchar(128) not null,
    position     varchar(128) not null,
    phone_number varchar(128) null
);

create table surrender_technic
(
    id             int auto_increment
        primary key,
    user_id        int  null,
    technic_id     int  null,
    surrender_date date not null,
    receive_date   date null,
    constraint surrender_technic_employee_id_fk
        foreign key (user_id) references employee (id),
    constraint surrender_technic_technic_id_fk
        foreign key (technic_id) references technic (id)
);
