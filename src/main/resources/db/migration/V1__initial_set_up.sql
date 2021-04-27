drop schema if exists sale_ads;
create schema sale_ads;

create table sale_ads.statuses (
    id int primary key ,
    name text
);
insert into sale_ads.statuses(id, name) values (0, 'ACTIVE'), (1, 'EXPIRED');

drop table if exists sale_ads.categories;
create table sale_ads.categories
(
    id bigserial primary key,
    name text not null
);

drop table if exists sale_ads.items;
create table sale_ads.items(
    id bigserial primary key,
    name text not null,
    photo text,
    sale_price int not null,
    old_price int not null,
    category_id bigint,

    constraint category_fk foreign key (category_id) references sale_ads.categories(id)
);

drop table if exists sale_ads.tags;
create table sale_ads.tags(
    id bigserial primary key,
    name text not null
);

drop table if exists sale_ads.item_tags;
create table sale_ads.item_tags(
    id bigserial primary key,
    item_id bigint ,
    tag_id bigint,

    constraint item_fk foreign key (item_id) references sale_ads.items(id),
    constraint tag_fk foreign key (tag_id) references sale_ads.tags(id)
);

drop table if exists sale_ads.places;
create table sale_ads.places(
    id bigserial primary key,
    name text not null
);

drop table if exists sale_ads.markets;
create table sale_ads.markets(
    id bigserial primary key,
    name text not null,
    place_id bigint,

    constraint places_fk foreign key (place_id) references sale_ads.places(id)
);

drop table if exists sale_ads.subscribers;
create table sale_ads.subscribers(
    id bigserial primary key,
    first_name text not null,
    lastName text not null,
    email text not null,
    phone text not null
);

drop table if exists sale_ads.users;
create table sale_ads.users(
    id bigserial primary key,
    first_name text not null,
    last_name text not null,
    email text not null,
    password text not null,
    is_enabled bool not null,
    role_id int,
    market_id bigint,

    constraint market_fk foreign key (market_id) references sale_ads.markets(id)
);

drop table if exists sale_ads.sales;
create table sale_ads.sales(
    id bigserial primary key,
    status_id int references sale_ads.statuses (id),
    start_date timestamp with time zone,
    end_date timestamp with time zone,
    market_id bigint,
    item_id bigint,

    constraint market_fk foreign key (market_id) references sale_ads.markets(id),
    constraint item_fk foreign key (item_id) references sale_ads.items(id)
);
