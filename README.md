# DevOps 06 Quality

## Lernjournal

Um Woche 6 zu erledigen, wurde der Stand von Woche 3 in dieses Repo kopiert.

### Lint-Warnung anhand HTML-Beispiel erzeugt, wieder behoben und dokumentiert

Fehler wurden für die Lint-Behandlung ergänzt. Die Vermerke im abgebildeten HTML zeigt, was verändert wurde und hoffentlich durch Lint erkennt wird:

![command](assets\picture1.png)

Um nun Lint starten zu können wurde der Folder "frontend" als Workspace geöffnet

![command](assets\picture3.png)

und Lint laufen gelassen:

![command](assets\picture4.png)

und wir sehen folgendes:
- L2 - lang wurde glöscht --> nicht entdeckt
- L7 - <p> wurde nicht geschlossen --> wurde entdeckt, aber in Line 12 vermerkt
- L10 - </link> wurde hinzugefügt --> wurde entdeckt
- L15 - angeblich falsche Selbstschliessung --> nicht entdeckt
- L31 - src gross geschrieben --> wurde entdeckt

Danach wurde das HTML korrigiert

![command](assets\picture5.png)

und nochmals ausgeführt:

![command](assets\picture6.png)

### Sonar Report für eigenes DevOpsDemo-Projekt erstellen und dokumentieren (Backend und Frontend)



### Backend: Code/Test-Änderung vornehmen und Report-Änderung dokumentieren (Commits, neuer Report, Code Coverage)

### Backend: Issue finden, beheben und Report-Änderung dokumentiert (Commits, neuer Report)


• Selenium *.side-Test für beliebige Webseite erstellt, Ausführung dokumentiert, *.side auf GitHub abgelegt
• Screencasts mittels Selenium Grid erstellt, dokumentiert, auf GitHub abgelegt