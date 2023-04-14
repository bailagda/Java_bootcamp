Компиляция с переносом файлов .class в папку target:
javac -d ./target/ ./**/*.java

cp -R src/resources target/.- перенос картинки в целевую папку

jar cmf images-to-chars-printer.jar src/manifest.txt ./target. - создание архива

mv images-to-chars-printer.jar ./target/ - перемещение архива в папку таргет

Запуск программы из архива:

java -jar images-to-chars-printer.jar
