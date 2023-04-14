--INSERTS

INSERT INTO users_table(Login, Password)
VALUES
 ('milkfist', 'milkfist'),
 ('gabriela', 'gabriela'),
 ('huongchi', 'huongchi'),
 ('stevenso', 'stevenso'),
 ('dedelmir', 'dedelmir');

INSERT INTO chatrooms_table(name, owner)
VALUES
     ('Chat_1', (SELECT id FROM users_table WHERE login = 'milkfist')),
     ('Chat_2', (SELECT id FROM users_table WHERE login = 'gabriela')),
     ('Chat_3', (SELECT id FROM users_table WHERE login = 'huongchi')),
     ('Chat_4', (SELECT id FROM users_table WHERE login = 'stevenso')),
     ('Chat_5', (SELECT id FROM users_table WHERE login = 'dedelmir'));

INSERT INTO messages_table(author, room, text, message_date)
VALUES
    ((SELECT id FROM chat.users WHERE login = 'dedelmir'), 1, 'Hi, Chat_1', 2023-03-20 11:23:44),
    ((SELECT id FROM chat.users WHERE login = 'stevenso'), 2, 'Hi, Chat_2', 2023-03-20 12:23:44),
    ((SELECT id FROM chat.users WHERE login = 'huongchi'), 3, 'Hi, Chat_3', 2023-03-20 13:23:44),
    ((SELECT id FROM chat.users WHERE login = 'gabriela'), 4, 'Hi, Chat_4', 2023-03-20 14:23:44),
    ((SELECT id FROM chat.users WHERE login = 'milkfist'), 5, 'Hi, Chat_5', 2023-03-20 15:23:44);
