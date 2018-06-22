\c inspiration_db

CREATE TABLE quotations(
  index int NOT NULL UNIQUE,
  author varchar(255) NOT NULL,
  quote varchar(1000) NOT NULL
);

INSERT INTO quotations (index, author, quote) VALUES (1, 'Brian Tracy', 'Make your life a masterpiece, imagine no limitations on what you can be, have or do.');
INSERT INTO quotations (index, author, quote) VALUES (2, 'Maya Angelou', 'We may encounter many defeats but we must not be defeated.');
INSERT INTO quotations (index, author, quote) VALUES (3, 'Stephen Covey', 'I am not a product of my circumstances. I am a product of my decisions.');
INSERT INTO quotations (index, author, quote) VALUES (4, 'Joseph Campbell', 'We must let go of the life we have planned, so as to accept the one that is waiting for us.');
INSERT INTO quotations (index, author, quote) VALUES (5, 'Theodore Roosevelt', 'Believe you can and you''re halfway there.');
INSERT INTO quotations (index, author, quote) VALUES (6, 'William Shakespeare', 'We know what we are, but know not what we may be.');
INSERT INTO quotations (index, author, quote) VALUES (7, 'Ronald Reagan', 'We can''t help everyone, but everyone can help someone.');
INSERT INTO quotations (index, author, quote) VALUES (8, 'Carol Burnett', 'When you have a dream, you''ve got to grab it an never let go.');
INSERT INTO quotations (index, author, quote) VALUES (9, 'Nido Quebein', 'Your present circumstances don''t determine where you can go; they merely determine where you start.');
INSERT INTO quotations (index, author, quote) VALUES (10, 'Plato', 'Thinking: the talking of the soul with itself.');
