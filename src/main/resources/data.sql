DROP TABLE IF EXISTS customer;
 
CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  userId VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);
 
INSERT INTO customer (userId, password) VALUES
  ('test', 'test123'),
  ('visu', 'visu123'),
  ('sample', 'sample123');
