CREATE TABLE IF NOT EXISTS `users` (
  `id` int AUTO_INCREMENT PRIMARY_KEY,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
);

INSERT INTO users (ID, firstName, lastName)
VALUES (1, "john", "doe");
