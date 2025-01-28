DROP TABLE IF EXISTS book;

CREATE TABLE book(
    id int auto_increment not null,
    title varchar(70) not null,
    isbn varchar(17) not null,
    edition int not null,
    publish_date date not null,
    chapters int not null,
    pages int not null,
    PRIMARY KEY (id)
)ENGINE=Innodb;