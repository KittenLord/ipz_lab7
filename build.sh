rm -rf ./out/*
javac -d ./out $(find . -name "*.java")
jar --create --file=./out/Build.jar --main-class=work7.Main -C ./out .
java -jar ./out/Build.jar $@
