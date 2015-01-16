--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 6.3.323.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 11.01.2015 4:14:23
-- Версия сервера: 5.1.73-community
-- Версия клиента: 4.1
--


-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка базы данных по умолчанию
--
USE toursite_database;

--
-- Описание для таблицы cart
--
DROP TABLE IF EXISTS cart;
CREATE TABLE cart (
  id INT(11) NOT NULL AUTO_INCREMENT,
  user_id INT(11) DEFAULT NULL,
  admin_id INT(11) DEFAULT NULL,
  date DATETIME DEFAULT NULL,
  is_paid TINYINT(1) DEFAULT NULL,
  is_confirmed TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы comment
--
DROP TABLE IF EXISTS comment;
CREATE TABLE comment (
  id INT(11) NOT NULL AUTO_INCREMENT,
  tour_id INT(11) DEFAULT NULL,
  user_id INT(11) DEFAULT NULL,
  text VARCHAR(255) DEFAULT NULL,
  date DATETIME DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы detail
--
DROP TABLE IF EXISTS detail;
CREATE TABLE detail (
  cart_id INT(11) NOT NULL,
  tour_id INT(11) NOT NULL,
  quantity INT(11) DEFAULT NULL,
  PRIMARY KEY (cart_id, tour_id)
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы equipment
--
DROP TABLE IF EXISTS equipment;
CREATE TABLE equipment (
  tour_id INT(11) DEFAULT NULL,
  sleepbag INT(11) DEFAULT NULL,
  tent INT(11) DEFAULT NULL,
  karemat INT(11) DEFAULT NULL,
  backpack INT(11) DEFAULT NULL
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы language
--
DROP TABLE IF EXISTS language;
CREATE TABLE language (
  id INT(11) NOT NULL AUTO_INCREMENT,
  link VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы message
--
DROP TABLE IF EXISTS message;
CREATE TABLE message (
  id INT(11) NOT NULL AUTO_INCREMENT,
  type_id INT(11) DEFAULT NULL,
  sender_id INT(11) DEFAULT NULL,
  receiver_id INT(11) DEFAULT NULL,
  tour_id INT(11) DEFAULT NULL,
  message_text VARCHAR(255) DEFAULT NULL,
  date DATETIME DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы photo
--
DROP TABLE IF EXISTS photo;
CREATE TABLE photo (
  tour_id INT(11) DEFAULT NULL,
  photograph_id INT(11) DEFAULT NULL,
  photolink VARCHAR(255) DEFAULT NULL
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы place
--
DROP TABLE IF EXISTS place;
CREATE TABLE place (
  id INT(11) NOT NULL AUTO_INCREMENT,
  description VARCHAR(255) DEFAULT NULL,
  wiki VARCHAR(255) DEFAULT NULL,
  picture VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы place_to_route
--
DROP TABLE IF EXISTS place_to_route;
CREATE TABLE place_to_route (
  place_id INT(11) DEFAULT NULL,
  route_id INT(11) DEFAULT NULL
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы portfolio
--
DROP TABLE IF EXISTS portfolio;
CREATE TABLE portfolio (
  user_id INT(11) DEFAULT NULL,
  description VARCHAR(255) DEFAULT NULL,
  is_photographer TINYINT(1) DEFAULT NULL,
  is_carrier TINYINT(1) DEFAULT NULL,
  is_guide TINYINT(1) DEFAULT NULL
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы question
--
DROP TABLE IF EXISTS question;
CREATE TABLE question (
  id INT(11) NOT NULL AUTO_INCREMENT,
  user_id INT(11) DEFAULT NULL,
  character_type VARCHAR(255) DEFAULT NULL,
  temper_type VARCHAR(255) DEFAULT NULL,
  sleep_chronotype VARCHAR(255) DEFAULT NULL,
  age INT(11) DEFAULT NULL,
  living_place VARCHAR(255) DEFAULT NULL,
  is_vegetarian TINYINT(1) DEFAULT NULL,
  is_religious TINYINT(1) DEFAULT NULL,
  is_extreme TINYINT(1) DEFAULT NULL,
  people_to_spend_time_with VARCHAR(255) DEFAULT NULL,
  place_to_spend_time VARCHAR(255) DEFAULT NULL,
  working_area VARCHAR(255) DEFAULT NULL,
  is_office_worker TINYINT(1) DEFAULT NULL,
  like_to_swim TINYINT(1) DEFAULT NULL,
  like_to_pick_berries TINYINT(1) DEFAULT NULL,
  like_to_pick_mushrooms TINYINT(1) DEFAULT NULL,
  like_to_fish TINYINT(1) DEFAULT NULL,
  like_guitar_singing TINYINT(1) DEFAULT NULL,
  like_sitting_near_fire TINYINT(1) DEFAULT NULL,
  is_traveller TINYINT(1) DEFAULT NULL,
  walk_type VARCHAR(255) DEFAULT NULL,
  like_being_photographed TINYINT(1) DEFAULT NULL,
  selected_tour VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы region
--
DROP TABLE IF EXISTS region;
CREATE TABLE region (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы role
--
DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id INT(11) NOT NULL AUTO_INCREMENT,
  role_value VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы route
--
DROP TABLE IF EXISTS route;
CREATE TABLE route (
  id INT(11) NOT NULL AUTO_INCREMENT,
  region_id INT(11) DEFAULT NULL,
  description VARCHAR(255) DEFAULT NULL,
  min_duration INT(11) DEFAULT NULL,
  max_duration INT(11) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы status
--
DROP TABLE IF EXISTS status;
CREATE TABLE status (
  id INT(11) NOT NULL AUTO_INCREMENT,
  status_name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы tour
--
DROP TABLE IF EXISTS tour;
CREATE TABLE tour (
  id INT(11) NOT NULL AUTO_INCREMENT,
  guide_id INT(11) DEFAULT NULL,
  photograph_id INT(11) DEFAULT NULL,
  route_id INT(11) DEFAULT NULL,
  status_id INT(11) DEFAULT NULL,
  transport_id INT(11) DEFAULT NULL,
  name VARCHAR(50) DEFAULT NULL,
  photograph_required TINYINT(1) DEFAULT NULL,
  min_age INT(11) DEFAULT NULL,
  max_age INT(11) DEFAULT NULL,
  min_capacity INT(11) DEFAULT NULL,
  max_capacity INT(11) DEFAULT NULL,
  min_duration INT(11) DEFAULT NULL,
  max_duration INT(11) DEFAULT NULL,
  trip_days VARCHAR(255) DEFAULT NULL,
  start_date DATETIME DEFAULT NULL,
  end_date DATETIME DEFAULT NULL,
  min_price INT(11) DEFAULT NULL,
  max_price INT(11) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы transport
--
DROP TABLE IF EXISTS transport;
CREATE TABLE transport (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы type
--
DROP TABLE IF EXISTS type;
CREATE TABLE type (
  id INT(11) NOT NULL AUTO_INCREMENT,
  type_value VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы user
--
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) DEFAULT NULL,
  last_name VARCHAR(50) DEFAULT NULL,
  login VARCHAR(255) DEFAULT NULL,
  password VARCHAR(255) DEFAULT NULL,
  mail VARCHAR(50) DEFAULT NULL,
  date_of_registration DATETIME DEFAULT NULL,
  picture VARCHAR(255) DEFAULT NULL,
  is_active TINYINT(1) DEFAULT NULL,
  language_id INT(11) DEFAULT NULL,
  paycard_no INT(15) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы user_to_tour
--
DROP TABLE IF EXISTS user_to_tour;
CREATE TABLE user_to_tour (
  user_id INT(11) DEFAULT NULL,
  role_id INT(11) DEFAULT NULL,
  tour_id INT(11) DEFAULT NULL
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

-- 
-- Вывод данных для таблицы cart
--

-- Таблица toursite_database.cart не содержит данных

-- 
-- Вывод данных для таблицы comment
--

-- Таблица toursite_database.comment не содержит данных

-- 
-- Вывод данных для таблицы detail
--

-- Таблица toursite_database.detail не содержит данных

-- 
-- Вывод данных для таблицы equipment
--

-- Таблица toursite_database.equipment не содержит данных

-- 
-- Вывод данных для таблицы language
--

-- Таблица toursite_database.language не содержит данных

-- 
-- Вывод данных для таблицы message
--

-- Таблица toursite_database.message не содержит данных

-- 
-- Вывод данных для таблицы photo
--

-- Таблица toursite_database.photo не содержит данных

-- 
-- Вывод данных для таблицы place
--

-- Таблица toursite_database.place не содержит данных

-- 
-- Вывод данных для таблицы place_to_route
--

-- Таблица toursite_database.place_to_route не содержит данных

-- 
-- Вывод данных для таблицы portfolio
--

-- Таблица toursite_database.portfolio не содержит данных

-- 
-- Вывод данных для таблицы question
--

-- Таблица toursite_database.question не содержит данных

-- 
-- Вывод данных для таблицы region
--

-- Таблица toursite_database.region не содержит данных

-- 
-- Вывод данных для таблицы role
--

-- Таблица toursite_database.role не содержит данных

-- 
-- Вывод данных для таблицы route
--

-- Таблица toursite_database.route не содержит данных

-- 
-- Вывод данных для таблицы status
--

-- Таблица toursite_database.status не содержит данных

-- 
-- Вывод данных для таблицы tour
--

-- Таблица toursite_database.tour не содержит данных

-- 
-- Вывод данных для таблицы transport
--

-- Таблица toursite_database.transport не содержит данных

-- 
-- Вывод данных для таблицы type
--

-- Таблица toursite_database.type не содержит данных

-- 
-- Вывод данных для таблицы user
--

-- Таблица toursite_database.user не содержит данных

-- 
-- Вывод данных для таблицы user_to_tour
--

-- Таблица toursite_database.user_to_tour не содержит данных

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;