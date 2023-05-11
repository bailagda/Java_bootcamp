--CREATE TABLE

CREATE TABLE IF NOT EXISTS users_table (
   id serial PRIMARY KEY,
   Login VARCHAR ( 50 ) UNIQUE NOT NULL,
   Password VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE IF NOT EXISTS chatrooms_table (
   id serial PRIMARY KEY,
   name VARCHAR ( 50 ) UNIQUE NOT NULL,
   owner INTEGER references users_table(id)
);

CREATE TABLE IF NOT EXISTS messages_table (
   id serial PRIMARY KEY,
   author_id INTEGER references users_table(id),
   room_id INTEGER references chatrooms_table(id),
   text VARCHAR not null ,
   message_date timestamp
);