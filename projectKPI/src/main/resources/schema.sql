drop table if exists BOOKINGS;
create table BOOKINGS(ID serial, FIRST_NAME varchar(5) NOT NULL);
DROP TABLE IF EXISTS MPP_TASKS;
CREATE TABLE MPP_TASKS
(
  ID INT AUTO_INCREMENT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  BusinessProject varchar(255),
  ProductManager varchar(255),
  Version varchar(255),
  ProjectManager varchar(255),
  JiraID varchar(255),
  TaskName varchar(255),
  Start datetime,
  Finish datetime,
  CompletePercent TINYINT,
  Deadline datetime,
  BufferOrDelay float,
  Communicated TINYINT(1),
  Work float,
  InitialWork float,
  TaskId varchar(255),
  Important TINYINT(1),
  IsSummary TINYINT(1),
  OutlineNumber varchar(255),
  OutlineLevel INT
);