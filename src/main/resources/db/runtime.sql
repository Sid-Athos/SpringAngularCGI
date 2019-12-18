-- Queries that'll be run at launch

INSERT INTO public.post(title, author,content) VALUES ('LOTR 1', 'JR
Tolkien',
'Nein');
INSERT INTO public.post(title, author,content) VALUES ('LOTR 2', 'JR Tolkien',
'nein');
INSERT INTO public.post(title, author,content) VALUES ('LOTR 3', 'JR Tolkien',
'da');
INSERT INTO public.post(title, author,content) VALUES ('Lorem Ipsum', 'John doe',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque et lorem elit. Aliquam dictum dui vel sapien ultrices aliquet. Aenean facilisis justo accumsan semper dapibus. Curabitur id ex mollis, dictum leo ultrices.');

INSERT INTO public.user( name, pwd,mail)
VALUES ('Il', 'JRTolkien','Nein@da.com');
INSERT INTO public.user( name, pwd,mail)
VALUES ('fait', 'JRTolkien','Nein@ya.com');
INSERT INTO public.user( name, pwd,mail)
VALUES ( 'soif', 'JRTolkien','Nein@fuck.com');

INSERT INTO public.comment(date, author,content,post_id) VALUES (CURRENT_TIMESTAMP,'John Doe',
'le comment has arrived', 1);

INSERT INTO public.comment(date, author,content,post_id) VALUES (CURRENT_TIMESTAMP,'Zozo El Toto',
'sa ses vraies', 4);

INSERT INTO public.comment(date, author,content,post_id) VALUES (CURRENT_TIMESTAMP,'AAAAAAA',
'ui', 4);
