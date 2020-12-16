DROP TABLE IF exists employee;

CREATE TABLE employee (
  id              int IDENTITY not null,
  CREATED_DATE TIMESTAMP,
  UPDATED_DATE TIMESTAMP,
  fname           varchar(100),
  lname           varchar(100),
  email           varchar(100),
  title           varchar(100),
  editable        varchar(100), 
  loaddate        varchar(100),
  postcreatedondate varchar(100),
  postremovedondate varchar(100),
  postupdateddate varchar(100),
  removedondate  varchar(100),
  VERSION INTEGER DEFAULT 1,
  salary          double,
  primary key (id)
  );
