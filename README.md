# DevOps 06 Quality

## Lernjournal

Um Woche 6 zu erledigen, wurde der Stand von Woche 3 in dieses Repo kopiert.

### Lint-Warnung anhand HTML-Beispiel erzeugt, wieder behoben und dokumentiert

Fehler wurden für die Lint-Behandlung ergänzt. Die Vermerke im abgebildeten HTML zeigt, was verändert wurde und hoffentlich durch Lint erkennt wird:

![command](assets/Picture1.png)

Um nun Lint starten zu können wurde der Folder "frontend" als Workspace geöffnet

![command](assets/Picture3.png)

und Lint laufen gelassen:

![command](assets/Picture4.png)

und wir sehen folgendes:
- L2 - lang wurde glöscht --> nicht entdeckt
- L7 - <p> wurde nicht geschlossen --> wurde entdeckt, aber in Line 12 vermerkt
- L10 - </link> wurde hinzugefügt --> wurde entdeckt
- L15 - angeblich falsche Selbstschliessung --> nicht entdeckt
- L31 - src gross geschrieben --> wurde entdeckt

Danach wurde das HTML korrigiert

![command](assets/Picture5.png)

und nochmals ausgeführt:

![command](assets/Picture6.png)

### Sonar Report für eigenes DevOpsDemo-Projekt erstellen und dokumentieren (Backend und Frontend)

Zuerst wird mal SonarQube in Docker gestartet:

![command](assets/Picture7.png)

![command](assets/Picture8.png)

und SonarQube im Browser ersichtlich:

![command](assets/Picture9.png)

#### Backend:

Nun wird das Backend erstellt mittels local Project:

![command](assets/Picture10.png)

![command](assets/Picture11.png)

![command](assets/Picture12.png)

![command](assets/Picture13.png)

![command](assets/Picture14.png)

![command](assets/Picture15.png)

Durch die Erstellung des Keys kann nun Sonar verbunden werden.

![command](assets/Picture16.png)

![command](assets/Picture17.png)

Und Sonar für das Backend läuft nun einwandfrei:

![command](assets/Picture18.png)

#### Frontend:

Die gleichen Schritte in Sonar und VS Code werden nun fürs Frontend wiederholt.

Wir bekommen wieder einen Key, um das Sonar mit dem Frontend-Code zu verbinden und tragen dies im VSCode ein:

![command](assets/Picture19.png)

Achtung anderer command nötig für Frontend:

![command](assets/Picture20.png)

Nach der 4 Minütigen Execution ist dann Sonar bereit beide FrontEnd und Backend Reports zu zeigen

![command](assets/Picture21.png)

![command](assets/Picture22.png)

### Backend: Code/Test-Änderung vornehmen und Report-Änderung dokumentieren (Commits, neuer Report, Code Coverage)
Nun werden gewisse Teile des DevOpsDemo-Backend gemacht, damit Sonar bessere Zahlen liefert:

![command](assets/Picture23.png)

Einerseits sollte die Test coverage erhöht werden. Zurzeit ist diese bei 0%

![command](assets/Picture24.png)

Changes Dabei wurde lediglich das DemoAppTest ergänzt und nun ist die Coverage auf 87.7%:

![command](assets/Picture25.png)

![command](assets/Picture27.png)

Wie in der Abbildung zu beginn dieses Kapitels, waren ebenfalls 32 Maintainability Issues im Report. Nach dem Fix wurden rund 26 gezählt.

![command](assets/Picture26.png)

### Backend: Issue finden, beheben und Report-Änderung dokumentiert (Commits, neuer Report)
Hier wurden nun SeleniumTests erstellt für das DevOpsDemo.
Insgesamt wurden drei Tests erstellt:
- Login DevOpsDemo: Testet das Login und stellt anhand eines Elements fest, ob der Zugriff geklappt hat (Siehe erster Screenshot). Ablauf:
    - Öffnen der Seite
    - Anpassen der Fenstergrösse
    - Click auf das usernameField und eingabe des Usernames "Selenium"
    - Click auf das passwordField und eingabe des Usernames "Selenium"
    - Click auf den signinButton
    - Prüfen anhand eines Elements, ob das LogIn successful war
- Add NewBoard: Hier wird ein neues Board hinzugefügt und geschaut, ob man sich im Anschluss in diesem Board befindet (Siehe zweiter Screenshot). Ablauf:
    - Öffnen der Seite
    - Anpassen der Fenstergrösse
    - Click auf den Button AddField
    - Click in das Feld newBoardTitle
    - Hinzufpgen des Namens "Test"
    - auf Erstellen drücken.
    - Anhand eines Elements schauen, ob man auf das neu erstellte Board weitergeleitet wurde
- Und danach wird getestet, ob das LogOut funktioniert (Siehe dritter Screenshot). Ablauf:
    - Öffnen der Seite
    - Anpassen der Fenstergrösse
    - Clicken auf das profileIcon
    - Clicken auf "LogOut"
    - Anhand eines Elements schauen, ob man auf der LogInSeite ist

![command](assets/Picture28.png)

![command](assets/Picture29.png)

![command](assets/Picture30.png)

In der Test Suite wurden die Testfälle so angelegt, dass eine Ausführung aller Tests auf einmal möglich sind und somit dies ohne grossen Aufwand gemacht werden kann.

Für SeleniumGrid wurde nun das DockerFile so angepasst, dass das DevOpsDemo von Woche 4 gestartet werden kann und die gleichen Tests ausgeführt werden wie oben:

![command](assets/Picture31.png)

![command](assets/Picture33.png)

Das Selenium Grid zeigt momentan folgendes:

![command](assets/Picture32.png)