Zum Kompilieren gibt es zwei Möglichkeiten:
1. Setzen des CLASSPATH:
Führe in der Konsole den Befehl "export CLASSPATH=[junitfile]:.", um die [junitfile] und den aktuellen Ordner zum Klassenpfad hinzuzufügen.
Kompilieren und Ausführen des Programms funktioniert dann über
javac [files]
java org.junit.runner.JUnitCore [testclass]

2. Ohne Setzen des CLASSPATH:
Der Klassenpfad muss explizit als Parameter (-cp) übergeben werden.
Kompilieren und Ausführen des Programms funktioniert dann über
javac -cp [junitfile]:. [files]
java -cp [junitfile]:. org.junit.runner.JUnitCore [testclass]


Beachte:
Ist die Testklasse in einem package, muss dieses auch angegeben werden. Ausführen geht dann über
java -cp [junitfile]:. org.junit.runner.JUnitCore [packagename].[testclass]



Weitere Informationen zu Kompilieren und Ausführen:
* -cp ist eine Option für java und javac. Kurzform für classpath, worüber Pfade zu Klassen angegeben werden können. Mehrere Pfade werden durch einen Doppelpunkt getrennt (:) getrennt.
* org.junit.runner.JUnitCore ist die Klasse, die über java ausgeführt wird. [packagename].[testclass] ist dann ein Parameter für JUnitCore. JUnit sucht dann in der Klasse des übergebenen Parameters alle mit @Test annotierten Methoden und führt diese aus.