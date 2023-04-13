Компиляция с переносом файлов .class в папку target:
javac -d ./target/ ./**/*.java

jar cf images-to-chars-printer.jar target/ex01/ImagesToChar/src/java/edu/school21/printer/app/Program.class - создание архива

mv images-to-chars-printer.jar ./target/ - перемещение архива в папку таргет
cp src/resources/* ./target/resources - перенос картинки в целевую папку