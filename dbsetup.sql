\c inspiration_db

CREATE TABLE quotations(
  index serial,
  author varchar(255) NOT NULL,
  quote varchar(1000) NOT NULL
);

INSERT INTO quotations (author, quote) VALUES ('Brian Tracy', 'Make your life a masterpiece, imagine no limitations on what you can be, have or do.');
INSERT INTO quotations (author, quote) VALUES ('Maya Angelou', 'We may encounter many defeats but we must not be defeated.');
INSERT INTO quotations (author, quote) VALUES ('Stephen Covey', 'I am not a product of my circumstances. I am a product of my decisions.');
INSERT INTO quotations (author, quote) VALUES ('Joseph Campbell', 'We must let go of the life we have planned, so as to accept the one that is waiting for us.');
INSERT INTO quotations (author, quote) VALUES ('Theodore Roosevelt', 'Believe you can and you''re halfway there.');
INSERT INTO quotations (author, quote) VALUES ('William Shakespeare', 'We know what we are, but know not what we may be.');
INSERT INTO quotations (author, quote) VALUES ('Ronald Reagan', 'We can''t help everyone, but everyone can help someone.');
INSERT INTO quotations (author, quote) VALUES ('Carol Burnett', 'When you have a dream, you''ve got to grab it an never let go.');
INSERT INTO quotations (author, quote) VALUES ('Nido Quebein', 'Your present circumstances don''t determine where you can go; they merely determine where you start.');
INSERT INTO quotations (author, quote) VALUES ('Plato', 'Thinking: the talking of the soul with itself.');
