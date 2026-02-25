CREATE DATABASE citycare;
USE citycare;

CREATE TABLE complaints (
  id INT AUTO_INCREMENT PRIMARY KEY,
  issue_type VARCHAR(50),
  description TEXT,
  location VARCHAR(100),
  image VARCHAR(200),
  after_image VARCHAR(200),
  status VARCHAR(20)
);

