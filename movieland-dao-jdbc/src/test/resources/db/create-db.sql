create table movie
(
	movie_id bigserial not null,
	name_ru text not null,
	name_orig text not null,
	release_year integer not null,
	country text,
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

