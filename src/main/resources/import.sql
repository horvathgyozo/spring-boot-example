insert into student (first_name, last_name, neptun) values ('John', 'Wick', 'abcdef1');
insert into student (first_name, last_name, neptun) values ('John', 'Doe', 'abcdef2');
insert into student (first_name, last_name, neptun) values ('Johnathan', 'Apple', 'abcdef3');
insert into student (first_name, last_name, neptun) values ('Bob', null, 'abcdef4');
insert into student (first_name, last_name, neptun) values ('Ian', 'Thorne', 'abcdef5');

insert into user (username, password, email, role) values ('admin', 'a', 'gyozke@alma.hu', 'ADMIN');
insert into user (username, password, email, role) values ('user', 'b', 'alma@alma.hu', 'USER');


insert into issue (user_id, description, location, status, timestamp) values (1, 'a', 'a', 'ADDED', current_timestamp);
insert into issue (user_id, description, location, status, timestamp) values (1, 'b', 'b', 'ADDED', current_timestamp);
insert into issue (user_id, description, location, status, timestamp) values (1, 'c', 'c', 'ADDED', current_timestamp);
insert into issue (user_id, description, location, status, timestamp) values (2, 'd', 'd', 'ADDED', current_timestamp);
insert into issue (user_id, description, location, status, timestamp) values (2, 'e', 'e', 'ADDED', current_timestamp);


insert into message (issue_id, user_id, text) values (1, 1, 'alma');
insert into message (issue_id, user_id, text) values (1, 2, 'korte');
insert into message (issue_id, user_id, text) values (2, 1, 'alma');
insert into message (issue_id, user_id, text) values (2, 1, 'korte');
insert into message (issue_id, user_id, text) values (2, 2, 'szilva');
insert into message (issue_id, user_id, text) values (3, 1, 'alma');
insert into message (issue_id, user_id, text) values (3, 2, 'korte');
insert into message (issue_id, user_id, text) values (4, 1, 'alma');
insert into message (issue_id, user_id, text) values (5, 1, 'alma');
