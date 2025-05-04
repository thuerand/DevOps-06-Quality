package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProjectTest {

    @Test
    public void testProject() {
        var project = new Project(1, "Test Project", "Test Description", "In Bearbeitung", "2025-05-30");
        assertEquals("Test Project", project.getName());
        assertEquals("Test Description", project.getDescription());
        assertEquals("In Bearbeitung", project.getStatus());
        assertEquals("2025-05-30", project.getDeadline());
        assertEquals(1, project.getId());
    }
    
}
