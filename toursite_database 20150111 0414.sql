--
-- ������ ������������ Devart dbForge Studio for MySQL, ������ 6.3.323.0
-- �������� �������� ��������: http://www.devart.com/ru/dbforge/mysql/studio
-- ���� �������: 11.01.2015 4:14:23
-- ������ �������: 5.1.73-community
-- ������ �������: 4.1
--


-- 
-- ���������� ������� ������
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- ���������� ����� SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- ��������� ���� ������ �� ���������
--
USE toursite_database;

--
-- �������� ��� ������� cart
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
-- �������� ��� ������� comment
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
-- �������� ��� ������� detail
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
-- �������� ��� ������� equipment
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
-- �������� ��� ������� language
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
-- �������� ��� ������� message
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
-- �������� ��� ������� photo
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
-- �������� ��� ������� place
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
-- �������� ��� ������� place_to_route
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
-- �������� ��� ������� portfolio
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
-- �������� ��� ������� question
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
-- �������� ��� ������� region
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
-- �������� ��� ������� role
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
-- �������� ��� ������� route
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
-- �������� ��� ������� status
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
-- �������� ��� ������� tour
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
-- �������� ��� ������� transport
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
-- �������� ��� ������� type
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
-- �������� ��� ������� user
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
-- �������� ��� ������� user_to_tour
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
-- ����� ������ ��� ������� cart
--

-- ������� toursite_database.cart �� �������� ������

-- 
-- ����� ������ ��� ������� comment
--

-- ������� toursite_database.comment �� �������� ������

-- 
-- ����� ������ ��� ������� detail
--

-- ������� toursite_database.detail �� �������� ������

-- 
-- ����� ������ ��� ������� equipment
--

-- ������� toursite_database.equipment �� �������� ������

-- 
-- ����� ������ ��� ������� language
--

-- ������� toursite_database.language �� �������� ������

-- 
-- ����� ������ ��� ������� message
--

-- ������� toursite_database.message �� �������� ������

-- 
-- ����� ������ ��� ������� photo
--

-- ������� toursite_database.photo �� �������� ������

-- 
-- ����� ������ ��� ������� place
--

-- ������� toursite_database.place �� �������� ������

-- 
-- ����� ������ ��� ������� place_to_route
--

-- ������� toursite_database.place_to_route �� �������� ������

-- 
-- ����� ������ ��� ������� portfolio
--

-- ������� toursite_database.portfolio �� �������� ������

-- 
-- ����� ������ ��� ������� question
--

-- ������� toursite_database.question �� �������� ������

-- 
-- ����� ������ ��� ������� region
--

-- ������� toursite_database.region �� �������� ������

-- 
-- ����� ������ ��� ������� role
--

-- ������� toursite_database.role �� �������� ������

-- 
-- ����� ������ ��� ������� route
--

-- ������� toursite_database.route �� �������� ������

-- 
-- ����� ������ ��� ������� status
--

-- ������� toursite_database.status �� �������� ������

-- 
-- ����� ������ ��� ������� tour
--

-- ������� toursite_database.tour �� �������� ������

-- 
-- ����� ������ ��� ������� transport
--

-- ������� toursite_database.transport �� �������� ������

-- 
-- ����� ������ ��� ������� type
--

-- ������� toursite_database.type �� �������� ������

-- 
-- ����� ������ ��� ������� user
--

-- ������� toursite_database.user �� �������� ������

-- 
-- ����� ������ ��� ������� user_to_tour
--

-- ������� toursite_database.user_to_tour �� �������� ������

-- 
-- ������������ ���������� ����� SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- ��������� ������� ������
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;