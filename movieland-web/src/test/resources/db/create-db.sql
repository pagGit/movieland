create table movie
(
	movie_id bigserial not null,
	name_ru text not null,
	name_orig text not null,
	release_year integer not null,
	description text,
	rating numeric,
	price numeric not null,
	picture_path text
)
;

create table genre
(
	genre_id bigserial not null,
	genre_name text not null
)
;

create table movie_genre
(
	mg_id bigserial not null,
	movie_id bigint not null,
	genre_id bigint not null
)
;

create table movie_review
(
	review_id bigserial not null,
	movie_id bigint not null,
	user_id bigint not null,
	text text not null
)
;

create table users
(
	user_id bigserial not null,
	email text not null,
	password text not null,
	role text not null,
	first_name text not null,
	last_name text not null,
	nick_name text
)
;
create table country
(
	country_id serial not null
		constraint country_pkey
			primary key,
	country_name varchar(256) not null
)
;

create table movie_country
(
	mc_id bigserial not null
		constraint movie_country_pkey
			primary key,
	movie_id integer not null,
	country_id integer not null
)
;


