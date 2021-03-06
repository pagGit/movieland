INSERT INTO movie(movie_id, name_ru, name_orig, release_year, country, rating, price, description, picture_path) VALUES(1, 'Побег из Шоушенка', 'The Shawshank Redemption', 1994, 'США', 8.9, 123.45, 'Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg');
INSERT INTO movie(movie_id, name_ru, name_orig, release_year, country, rating, price, description, picture_path) VALUES(2, 'Зеленая миля', 'The Green Mile', 1999, 'США', 8.9, 134.67, 'Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg');

INSERT INTO genre(genre_id, genre_name) VALUES(1,'драма');
INSERT INTO genre(genre_id, genre_name) VALUES(2,'криминал');

INSERT INTO movie_genre(mg_id, movie_id, genre_id) VALUES(1, 1, 1);
INSERT INTO movie_genre(mg_id, movie_id, genre_id) VALUES(2, 1, 2);
INSERT INTO movie_genre(mg_id, movie_id, genre_id) VALUES(3, 2, 1);

INSERT INTO country (country_id, country_name) VALUES (1, 'Великобритания');
INSERT INTO country (country_id, country_name) VALUES (2, 'Италия');