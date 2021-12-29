find * -name "*.java" > sources.txt
javac @sources.txt
java src.MainApp scenario.txt
rm -f src/*.class src/aircraft/*.class