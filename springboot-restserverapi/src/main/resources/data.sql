
DELETE FROM USER_ROLE;
DELETE FROM UTILISATEUR;
DELETE FROM ROLE;

INSERT INTO ROLE(ROLE_ID,ROLE_NAME) VALUES (1,'ROLE_ADMIN');
INSERT INTO ROLE(ROLE_ID,ROLE_NAME) VALUES (2,'ROLE_USER');

INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD,USER_ACTIVE) values (1, 'admin', 'admin', 1);
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD,USER_ACTIVE) values (2, 'user', 'user', 1);
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD,USER_ACTIVE) values (3, 'user1', 'user1', 0);
INSERT INTO UTILISATEUR(USER_ID, LOGIN, USER_PASSWORD,USER_ACTIVE) values (4, 'bouzga', '1234', 0);

INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (1,2);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (2,2);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (3,2);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (4,1);
INSERT INTO USER_ROLE(USER_ID,ROLE_ID) VALUES (4,2);
--COMMIT;