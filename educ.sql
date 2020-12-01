--Удаляем схему если есть, со всем содержимым
drop schema if exists education CASCADE;

--Создаём схему
create schema education;
--Подтверждаем транзакцию 
commit;

--Создаём таблицу
create table education.teachers (id int not null primary key, name varchar(50), lastname varchar(50));
--Объявляем уникальный ключ
alter table education.teachers add CONSTRAINT teachers_ukey unique (name, lastname);

--Добавляем 3 записи
insert into education.teachers (id, name, lastname)
values (1, 'Джон', 'Голд'), (2, 'Бетти', 'ОХара'), (3, 'Джон', 'Смит')
--если есть повторяющиеся значения id в таблице, то происходит обновление значений
ON CONFLICT on CONSTRAINT teachers_pkey do update set name = excluded.name, lastname = excluded.lastname
;

--Создаём таблицу
create table education.lessons (
  id int not null primary key,
  subject varchar(50),
  teacher int,
  start timestamp,
  finish timestamp,
  --внешний ключ, проверка что id преподавателя существует в таблице teachers
  FOREIGN KEY (teacher) REFERENCES education.teachers (id),
  --проверка, время начала меньше времени окончания
  CHECK (start < finish)
  );
  --создаём вычисляемую колонку колонку
  alter table education.lessons add column duration interval GENERATED ALWAYS AS (finish - start) STORED;
--alter table education.lessons add CONSTRAINT FOREIGN KEY (teacher) REFERENCES education.teachers (id);

--Добавление значений, лекции
insert into education.lessons (id, subject, teacher, start, finish)
values
(1, 'Литература', 1, '2020-11-14 09:01:00', '2020-11-14 10:30:00'),
(2, 'Литература', 1, '2020-11-14 12:00:00', '2020-11-14 13:30:00'),
(3, 'Литература', 1, '2020-11-15 09:00:00', '2020-11-15 10:30:00'),
(4, 'Литература', 1, '2020-11-15 11:30:00', '2020-11-15 13:00:00'),
(5, 'Литература', 1, '2020-11-15 15:30:00', '2020-11-15 17:00:00');
insert into education.lessons (id, subject, teacher, start, finish)
values
(6, 'Математика', 3, '2020-11-14 09:05:00', '2020-11-14 10:30:00'),
(7, 'Математика', 3, '2020-11-14 12:15:00', '2020-11-14 13:30:00'),
(8, 'Математика', 3, '2020-11-15 09:13:00', '2020-11-15 10:30:00'),
(9, 'Математика', 3, '2020-11-15 11:55:00', '2020-11-15 13:00:00'),
(10, 'Математика', 3, '2020-11-15 15:33:00', '2020-11-15 17:00:00');

--пример запроса, с аналитическими функциями через join
select teachers.id, --id учителя
       name,        --имя
       lastname,    --фамилия
       duration,    --длительность лекции
       avg_dur,     --средняя продолжительность лекции в общем и целом
       avg_dur_t,   --средняя продолжительность лекции по учителям
       extract(epoch from duration)/extract(epoch from avg_dur)*100 prcnt_of_avg_all, --процент длительности лекции от общей средней длительности
       extract(epoch from duration)/extract(epoch from avg_dur_t)*100 prcnt_of_avg_by_teacher--процент длительности лекции от средней длительности для учителя
 from education.teachers --таблица педагогов
--присоединение
inner join education.lessons --таблица журнала лекций
   on teachers.id = lessons.teacher --присоединение по ID учителя
--присоединение - простое декартово произведение
cross join (
  select avg(duration) as avg_dur --средняя продолжительность лекции по всему журналу
    from education.lessons --таблица журнала лекций
    ) t1 --вложенный запрос с псевдонимом t1
--присоединение
inner join (
  select teacher,--id учителя
         avg(duration) as avg_dur_t --средняя продолжительность лекции для учителя
    from education.lessons --таблица журнала лекций
   group by teacher --группируем по id учителя, для каждого значения будет одна уникальная строка
   ) t2 --вложенный запрос с псевдонимом t2
  on teachers.id = t2.teacher --присоединение по ID учителя
order by teachers.id, start; --сотировка сначала по учителю, потом по началу лекции

--пример запроса, аналог предыдущего, с оконными аналитическими функциями
select teachers.id, --id учителя
       name,        --имя
       lastname,    --фамилия
       duration,    --длительность лекции
       --средняя продолжительность лекции в общем и целом, окно не определено, а значит на все данные итогового вывода
       avg(duration) over () avg_all,
       --средняя продолжительность лекции для учителя, окно id учителя, все данные с одинаковым id учителя
       avg(duration) over (partition by teachers.id) as avg_teach,
       --процент длительности лекции от общей средней длительности
       extract(epoch from duration)/extract(epoch from avg(duration) over ())*100 prcnt_of_avg_all,
       --процент длительности лекции от средней длительности для учителя
       extract(epoch from duration)/extract(epoch from avg(duration) over (partition by teachers.id))*100 prcnt_of_avg_by_teacher,
       start,       --начало лекции
       lag(start) over (partition by teachers.id order by start) prev_lession_start, --начало предыдущей лекции у учителя (lag - предыдущая строка)
       lead(start) over (partition by teachers.id order by start) next_lession_start --начало следующей лекции у учителя (lead -следующая строка)
 from education.teachers --таблица педагогов
--присоединение
inner join education.lessons --таблица журнала лекций
   on teachers.id = lessons.teacher --присоединение по ID учителя
order by teachers.id, start; --сотировка сначала по учителю, потом по началу лекции

--sql cte - Common Table Expressions
with t /*псевдоним t для следующего запроса*/ as (
select 3000 as value, '2020-01-01'::timestamp as start, '2020-02-01'::timestamp as finish --строка с 3 значениями 
union  --объединение
select 5000, '2020-01-05'::timestamp, '2020-01-15'::timestamp --строка с 3 значениями 
union  --объединение
select 7000, '2020-01-17'::timestamp, '2020-01-30'::timestamp --строка с 3 значениями 
), --таблица-журнал, сумма, когда взяли в долг, когда отдали
q /*псевдоним q для следующего запроса*/ as (
select start as date, value --дата когда взяли в долг, и сумма
from t --из таблицы с псевдонимом t
union
select finish as date, -value as value --дата когда отдали долг, и отрицательная сумма
from t --из таблицы с псевдонимом t
),--таблица, отражающая журнал займов в виде списка "проводок" по датам с зачислением сумм и их списанием
res /*псевдоним res для следующего запроса*/ as (
select date, --дата изменеия баланса
       value, --сумма прихода или расхода
       sum(value) over (order by date) --баланс (сумма прихода/расхода наростающим итогом)
from q --из таблицы с псевдонимом q
order by date --сортируем по дате
)--таблица, отражающая журнал займов в виде списка "проводок" по датам с зачислением сумм и их списанием и балансом на момент проводки

--запрос выводит интервал времени с максимальным общим долгом по всем займам
select * from
  (select date dt_from, --дата изменения баланса
          lead(date) over (order by date) dt_to, --дата следующего изменения баланса
          sum  --баланс
   from res) r --псевдоним
where sum = (select max(sum) from res /*запрос с максимальным значением баланса, максимальный долг*/)
;

--таблица авторов
create table education.authors (id serial primary key, name varchar(60), lastname varchar(60), patronym varchar(60));
--добавляем авторов
insert into education.authors (name, lastname, patronym) values
('Лев','Толстой','Николаевич'),
('Фёдор','Достоевский','Михайлович'),
('Максим','Горький',''),
('Иван','Тургенев','Сергеевич');

--таблица книг
create table education.books (author int, caption varchar(600), FOREIGN KEY (author) REFERENCES education.authors (id));
--добавляем книги
insert into education.books (author, caption) values
((select id from education.authors where lastname like 'Толстой'), 'Война и Мир'),
((select id from education.authors where lastname like 'Толстой'), 'Анна Каренина'),
((select id from education.authors where lastname like 'Толстой'), 'Живой труп'),
((select id from education.authors where lastname like 'Достоевский'), 'Братья Карамазовы'),
((select id from education.authors where lastname like 'Достоевский'), 'Идиот'),
((select id from education.authors where lastname like 'Достоевский'), 'Бесы'),
((select id from education.authors where lastname like 'Горький'), 'На дне'),
((select id from education.authors where lastname like 'Горький'), 'Старуха Изергиль'),
((select id from education.authors where lastname like 'Горький'), 'Фома Гордеев'),
((select id from education.authors where lastname like 'Тургенев'), 'Отцы и дети');

--запрос книг автора с id = 1
select * from education.books
left join education.authors on books.author = authors.id
where id = 1;

--создание таблицы на основе запроса
create table education.t1 as
--запрос книг автора с id = 2
select * from education.books
full join education.authors on books.author = authors.id
where id = 2;

--пример работы с курсором в цикле в транзакции, выполненной как анонимный блок, procedure SQL
DO $$
<<sql_anon_block>>
DECLARE
  --объявляем курсор от запроса
  q cursor for select caption from education.books;
  --объявляем строковую переменную
  cap varchar(60);
BEGIN --начинаем транзакцию
  open q; --открываем курсор
  loop --начинаем цикл по курсору
    fetch q into cap;    --возвращаем значение из курсора в переменную
    exit when not found; --выходим из цикла, если курсор ничего не вернул
    insert into education.t1 (caption) values (cap); --вставляем значение переменной в таблицу
  end loop; --завершаем цикл по курсору
  close q; --закрываем курсор
END sql_anon_block $$;
