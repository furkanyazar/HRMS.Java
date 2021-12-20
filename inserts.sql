INSERT INTO cities(name) VALUES ('İstanbul');

INSERT INTO cities(name)VALUES ('Ankara');
  
INSERT INTO cities(name)VALUES ('İzmir');
  
INSERT INTO departments(name)VALUES ('Yazılım Mühendisliği');
  
INSERT INTO departments(name)VALUES ('Bilgisayar Mühendisliği');
  
INSERT INTO departments(name)VALUES ('Bilgisayar Programcılığı');
  
INSERT INTO jobs(name)VALUES ('Yazılım Geliştirici');
  
INSERT INTO jobs(name)VALUES ('Grafik Tasarımcı');
  
INSERT INTO jobs(name)VALUES ('Gereksinim Analisti');
  
INSERT INTO languages(name)VALUES ('Türkçe');
  
INSERT INTO languages(name)VALUES ('İngilizce');
  
INSERT INTO languages(name)VALUES ('Almanca');
  
INSERT INTO schools(name)VALUES ('İstanbul Teknik Üniversitesi');
  
INSERT INTO schools(name)VALUES ('Orta Doğu Teknik Üniversitesi');
  
INSERT INTO schools(name)VALUES ('Ege Üniversitesi');
  
INSERT INTO skills(name)VALUES ('Java');
  
INSERT INTO skills(name)VALUES ('C#');
  
INSERT INTO skills(name)VALUES ('React');

INSERT INTO working_times(name)VALUES ('Tam Zamanlı');

INSERT INTO working_times(name)VALUES ('Yarı Zamanlı');

INSERT INTO workplaces(name)VALUES ('İş Yerinden');

INSERT INTO workplaces(name)VALUES ('Uzaktan');

INSERT INTO users(email, password)VALUES ('admin@mail.com', '12345678');

INSERT INTO system_workers(user_id, name, surname)VALUES (1, 'admin', 'mail');

INSERT INTO photos(user_id, photo_link)VALUES (1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/2048px-User_icon_2.svg.png');
