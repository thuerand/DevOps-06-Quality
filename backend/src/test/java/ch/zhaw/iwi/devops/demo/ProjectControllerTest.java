package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProjectControllerTest {
    
    @Test
    public void testCreate() {
        var controller = new ProjectController();
        controller.init(); // Initialisieren mit Testdaten
        
        // Neues Projekt erstellen
        var project = new Project(0, "Test Project", "Test Description", "Geplant", "2025-12-31");
        controller.createProject(project);
        
        // Prüfen, ob das Projekt korrekt erstellt wurde
        var projects = controller.project();
        assertEquals(6, projects.size()); // 5 initiale + 1 neues Projekt
        
        // Projekt aktualisieren
        project.setName("Updated Project");
        controller.updateProject(project.getId(), project);
        
        // Prüfen, ob das Projekt korrekt aktualisiert wurde
        var updatedProject = controller.getProject(project.getId());
        assertEquals("Updated Project", updatedProject.getName());
        
        // Projekt löschen
        controller.deleteProject(project.getId());
        
        // Prüfen, ob das Projekt korrekt gelöscht wurde
        projects = controller.project();
        assertEquals(5, projects.size());
    }
}