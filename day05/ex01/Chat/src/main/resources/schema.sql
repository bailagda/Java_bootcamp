--CREATE TABLE

CREATE TABLE [IF NOT EXISTS] users_table (
   id serial PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   Login VARCHAR ( 50 ) UNIQUE NOT NULL,
   Password VARCHAR ( 50 ) NOT NULL,
   rooms_own INTEGER,
   socializes INTEGER
);

CREATE TABLE [IF NOT EXISTS] chatrooms_table (
   id serial PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   name VARCHAR ( 50 ) UNIQUE NOT NULL,
   owner INTEGER,
   message_id INTEGER
);

CREATE TABLE [IF NOT EXISTS] messages_table (
   id serial PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   author INTEGER,
   room INTEGER,
   text VARCHAR,
   message_date DATE
);