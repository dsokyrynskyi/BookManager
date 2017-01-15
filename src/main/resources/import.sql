INSERT INTO author (id, name, birth_date) VALUES (101, 'George Raymond Richard Martin', '20-09-1948');
INSERT INTO author (id, name, birth_date) VALUES (102, 'Joanne Rowling', '31-07-1965');
INSERT INTO author (id, name, birth_date) VALUES (103, 'Martin Odersky', '05-09-1958');
INSERT INTO author (id, name, birth_date) VALUES (104, 'Joshua Bloch', '28-08-1961');
INSERT INTO author (id, name, birth_date) VALUES (105, 'Chuck Palahniuk', '21-02-1962');
INSERT INTO author (id, name, birth_date) VALUES (106, 'Ilya Ilf', '15-10-1897');
INSERT INTO author (id, name, birth_date) VALUES (107, 'Yevgeny Petrov', '13-12-1903');

INSERT INTO book (id, name, isbn) VALUES (101, 'Fight Club', '0393327345');
INSERT INTO book (id, name, isbn) VALUES (102, 'Harry Potter and the Cursed Child', '123ef23u345');
INSERT INTO book (id, name, isbn) VALUES (103, 'Programming in Scala', 'abc33wd7345');
INSERT INTO book (id, name, isbn) VALUES (104, 'Effective Java', '1393327hgf');
INSERT INTO book (id, name, isbn) VALUES (105, 'A Song of Ice and Fire', '0j5l387345');
INSERT INTO book (id, name, isbn) VALUES (106, 'The Twelve Chairs', '98765fr21');
INSERT INTO book (id, name, isbn) VALUES (107, 'The Golden Calf', '111122cool7');

INSERT INTO book_author (books_id, authors_id) VALUES (101, 105);
INSERT INTO book_author (books_id, authors_id) VALUES (102, 102);
INSERT INTO book_author (books_id, authors_id) VALUES (103, 103);
INSERT INTO book_author (books_id, authors_id) VALUES (104, 104);
INSERT INTO book_author (books_id, authors_id) VALUES (105, 101);
INSERT INTO book_author (books_id, authors_id) VALUES (106, 106);
INSERT INTO book_author (books_id, authors_id) VALUES (106, 107);
INSERT INTO book_author (books_id, authors_id) VALUES (107, 106);
INSERT INTO book_author (books_id, authors_id) VALUES (107, 107);
