## **Упражнение 4.**
### Многопоточность и синхронизация
1. Напечатать все свойства текущего потока.
2. Создать новый поток и дождаться его окончания в первичном потоке.
3. Создать 3 новых потока и дождаться окончания их всех в первичном потоке. Для
каждого потока создать свой собственный класс.
4. В основном потоке создать ArrayList<Integer>. Запустить 2 потока на базе разных
классов, один поток 10000 раз добавляет в список случайное целое число, другой
10000 раз удаляет элемент по случайному индексу. Использовать внешний
synchronized блок
5. То же самое, но оба потока на базе одного и того же класса, использовать
synchronized методы.
6. То же самое. использовать метод Collections.synchronizedList
7. “Ping Pong”, задача заключается в том, чтобы бесконечно выводить на консоль
сообщения “ping” или “pong” из двух разных потоков. При этом сообщения обязаны
чередоваться, т.е. не может быть ситуации, когда ping или pong появляется в
консоли более одного раза подряд.
8. Переписать пункт 4 этого упражнения, используя ReentrantLock
9. “Ping Pong” на базе ReentrantLock и Conditional переменной.
10. *Написать свой класс, аналогичный ConcurrentHashMap , используя
ReadWriteLock. Будет ли эта реализация хуже ConcurrentHashMap, и если да, то
почему?
11. Написать класс Formatter, с методом format(Date date), форматирующим датувремя. Использовать для форматирования класс SimpleDateFormat. В основном
потоке создается единственный экземпляр класса Formatter. Создать 5 потоков,
каждому потоку передается при инициализации этот экземпляр. Потоки должны
корректно форматировать дату-время, синхронизация не разрешается.
12. *Написать класс Message, содержащий 4 текстовых поля: emailAddress, sender,
subject, body, и класс Transport, с методом send(Message message), отсылающий
письмо на некий SMTP-сервер. Реализовать массовую рассылку одного и того же
текста, email адреса берутся из текстового файла. Имейте в виду, что отправка
одного письма требует довольно много времени (установление соединения с
сервером, отсылка, получение ответа), поэтому последовательная отправка писем
не является хорошим решением. Порядок отправки писем произвольный и не
обязан совпадать с порядком email адресов в файле.
Примечание 1. Реальную отправку писем производить не надо, вместо
этого достаточно выводить их в некоторый файл.
Примечание 2. Если все же есть желание произвести реальную отсылку,
подключите javax.mail-api с помощью maven и используйте классы
MimeMessage и Transport. Ответственность за возможные последствия
целиком возлагается на Вас :-).
13. *Реализовать очередь данных. Данные - экземпляр класса Data с единственным
методом int[] get(). Потоки-писатели ставят в очередь экземпляры Data, потоки -
читатели берут их из очереди и распечатывают. Количество тех и других потоков
может быть любым и задается через командную строку main. Рекомендуется для
парсинга командной строки поискать подходящий пакет в Интернете и подключить
его через pom.xml.
14. *Реализовать очередь задач. Задача - экземпляр класса Task или его наследника,
имплементирующего Executable - свой интерфейс с единственным методом void
execute(). Потоки - разработчики ставят в очередь экземпляры Task, потоки -
исполнители берут их из очереди и исполняют. Количество тех и других потоков
может быть любым и задается через командную строку main. Предусмотреть
вариант, когда число потоков конфигурируется автоматически.
15. *Реализовать очередь многостадийных задач. Многостадийная задача - экземпляр
класса Task, имеющего список из стадий - List<Executable>, где Executable -
интерфейс из задания 16. Потоки - разработчики ставят в очередь экземпляры
Task, потоки - исполнители берут из очереди задачу, исполняют очередную ее
стадию, после чего, если это не последняя стадия, ставят задачу обратно в
очередь. Единственный поток - наблюдатель периодически распечатывает
информацию о задачах, которые в настоящее время исполняются (имя задачи,
номер текущей стадии, количество стадий) Количество тех и других потоков может
быть любым и задается через командную строку main. Предусмотреть вариант,
когда число потоков конфигурируется автоматически.