CREATE TABLE Task_definition (
  id integer(20) NOT NULL,
  name varchar(100) NOT NULL,
  Description varchar(50) DEFAULT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Task_definition_mirror (
  id integer(20) NOT NULL,
  name varchar(100) NOT NULL,
  Description varchar(50) DEFAULT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
