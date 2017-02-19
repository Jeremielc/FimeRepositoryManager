use 'remandb'

set foreign_key_checks=0;
DROP TABLE IF EXISTS `USERS` CASCADE;
DROP TABLE IF EXISTS `TOOLS` CASCADE;
DROP TABLE IF EXISTS `CREDENTIALS` CASCADE;
set foreign_key_checks=0;

CREATE TABLE `USERS` (
	uid INT(5) NOT NULL AUTO_INCREMENT,
	firstname VARCHAR(64) NOT NULL,
	lastname VARCHAR(64) NOT NULL,
	grp VARCHAR(64) NOT NULL,
	role VARCHAR(64) NOT NULL,
	mail VARCHAR(128) NOT NULL,
	CONSTRAINT `PK_USERS` PRIMARY KEY (uid)
)ENGINE=InnoDB;

CREATE TABLE `TOOLS` (
	tid INT(10) NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	version VARCHAR(32) NOT NULL,
	state VARCHAR(64) NOT NULL,
	archived BOOLEAN NOT NULL,
	qualified BOOLEAN NOT NULL,
	toolPath VARCHAR(256) NOT NULL,
	qualifReportPath VARCHAR(256),
	publicationDate VARCHAR(19) NOT NULL,
	CONSTRAINT `PK_TOOLS` PRIMARY KEY (tid)
)ENGINE=InnoDB;

CREATE TABLE `CREDENTIALS` (
	id INT(10) NOT NULL AUTO_INCREMENT,
	uid INT(10) NOT NULL,
	cuid VARCHAR(8) NOT NULL,
	passHash VARCHAR(64) NOT NULL,
	CONSTRAINT `PK_CREDENTIALS` PRIMARY KEY (id),
	CONSTRAINT `FK_CREDENTIALS_USERS` FOREIGN KEY (uid) REFERENCES `USERS`(uid)
)ENGINE=InnoDB;

INSERT INTO `USERS`(`firstname`, `lastname`, `grp`, `role`, `mail`)
VALUES ('Jérémie', 'Leclerc', 'Card', 'Developer', 'jeremielc@orange.fr'),
	   ('Pierrick', 'Hue', 'Reader', 'User',  'lesurferdusud@hotmail.fr');
	   
INSERT INTO `CREDENTIALS`(`uid`, `cuid`, `passHash`)
VALUES (1, 'HRNS9487', 'a8bf259129936884fbd23e03592e31df555ee9f467e98f74faa86651d160dcec'),
	   (2, 'NJWQ6874', '26c1acecdc8a71a771123cf1c1b7679a975c3df7e3345968be7bf5d774f6ed67');
	   
INSERT INTO `TOOLS`(`name`, `version`, `state`, `archived`, `qualified`, `toolPath`, `qualifReportPath`, `publicationDate`)
VALUES ('testTool', '1.0', 'stable', TRUE, TRUE, 'testTool-v1.0-stable.zip', 'C17QUA14-02-1.odt', '2017/02/01 13:30:15'),
	   ('testTool', '2.0', 'stable', FALSE, FALSE, 'testTool-v2.0-stable.zip', ' ', '2017/02/01 13:30:15'),
	   ('archiveTestTool', '1.0', 'stable', TRUE, FALSE, 'archiveTestTool-v1.0-stable.zip', ' ', '2017/02/01 13:30:15'),
	   ('RemanWsProjectTest', '1.0', 'stable', TRUE, TRUE, 'RemanWsProjectTest-v1.0-stable.zip', 'RemanWsProjectTest_C17QUA19-02-1.pdf', '2017/02/20 00:45:30'),
	   ('RemanWsProjectTest', '2.0', 'stable', FALSE, TRUE, 'RemanWsProjectTest-v2.0-stable.zip', 'RemanWsProjectTest_C17QUA19-02-2.pdf', '2017/02/20 00:45:44');
