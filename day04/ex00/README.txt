Из папки ех00 запустить следующие команды:

1. javac ImagesToChar/src/java/edu/school21/printer/app/Program.java - для компиляции файла

2. java ImagesToChar.src.java.edu.school21.printer.app.Program -w=<arg1> -b=<arg2> <path_to_image> -
для выполнения программы, где:
- arg1 - символ для белого цвета,
- arg2 - символ для черного,
- path_to_image - абсолютный путь к файлу изображения

Пример:
java ImagesToChar.src.java.edu.school21.printer.app.Program -w=. -b=O /Users/bailagda/Desktop/java_bootcamp/day04/ex00/it.bmp