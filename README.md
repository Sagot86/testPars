Парсер CSV-файла, написанный в соответствии с ТЗ: https://github.com/revkov/JAVA.CSV.TEST

После запуска программы парсится файл test_case.csv, заливается в postgresql (Таблица и sequence создаются в базе отдельно, так как создание таблиц из кода - плохая практика).
Далее результаты всех трех запросов доступны в JSON формате по ссылкам http://127.0.0.1:8080/restresult/ (/1, /2 и /3 соответственно).
Сами странички с обработанными и помещенными в html-таблицы значениями расположены по ссылкам http://127.0.0.1:8080/reports (/1, /2 и /3 соответственно).

Некоторые пояснения по запросам:

1. В первом запросе не отображаются пользователи, у которых не удалось идентифицировать ssoid или formid.
2. Второй запрос выполнен, исходя из предположения, что у каждой формы по три шага (начало, середина, конец), а так же интуитивно понятные названия для первого и последнего шагов на форме (start, before и send, success, after, sent, done для начала и конца соответственно). Так же не учитываются формы, на которых невозможно определить текущий этап выполнения (поле data_subtype пустое).
3. В выдаче третьего запроса игнорируются результаты, название формы у которых установить не удалось (поле formid пустое).
