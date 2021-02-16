CREATE DATABASE IF NOT EXISTS `codelytv_scala_api`;
CREATE DATABASE IF NOT EXISTS `codelytv_scala_api_acceptance_tests`;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'c0d3ly';
GRANT ALL ON *.* TO 'root'@'%';
