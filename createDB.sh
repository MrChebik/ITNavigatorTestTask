#!bin/sh
echo "Create database 'ITNavigatorTestTask'"
echo -n "Username: "
read username
echo -n "Password: "
read -s password
echo
mysql -u $username -p$password -e "
CREATE DATABASE IF NOT EXISTS ITNavigatorTestTask DEFAULT CHARACTER SET 'utf8' DEFAULT COLLATE 'utf8_unicode_ci';
USE ITNavigatorTestTask;
CREATE TABLE Client
(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    LastName VARCHAR(255) NOT NULL,
    FirstName VARCHAR(255) NOT NULL,
    MiddleName VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX id_uindex ON Client (id);
CREATE TABLE TelephoneNumber
(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Number VARCHAR(19) NOT NULL,
    Type VARCHAR(12) NOT NULL,
    Comment VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX TelephoneNumber_id_uindex ON TelephoneNumber (id);

INSERT INTO Client (LastName, FirstName, MiddleName)
VALUES
    ('Иванов', 'Иван', 'Иванович'),
    ('Иванов', 'Сергей', 'Олегович'),
    ('Семенчук', 'Владислав', 'Афрамович'),
    ('Фамилия', 'Имя', 'Отчество'),
    ('Смирнов', 'Олег', 'Владимирович');
INSERT INTO TelephoneNumber (Number, Type, Comment)
VALUES
    ('+380 (97) 011-11-12', 'Мобильный', 'Звоните'),
    ('555-20-10', 'Домашний', 'Все время занят'),
    ('+380 (52) 102-10-84', 'Мобильный', 'Нет комментария'),
    ('123-40-10', 'Нет сведений', 'Горячий номер'),
    ('685-25-15', 'Домашний', 'Ночью - сплю');"
echo "Done!"