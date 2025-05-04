package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProjectController {

    private Map<Integer, Project> projects = new HashMap<Integer, Project>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.projects.put(1, new Project(1, "DevOps Pipeline", "Implementierung einer CI/CD-Pipeline", "In Bearbeitung", "2025-05-30"));
        this.projects.put(2, new Project(2, "Microservices", "Migration zu Microservices-Architektur", "Geplant", "2025-06-15"));
        this.projects.put(3, new Project(3, "Kubernetes", "Einführung von Kubernetes für Container-Orchestrierung", "Geplant", "2025-07-01"));
        this.projects.put(4, new Project(4, "Monitoring", "Implementierung von Monitoring-Tools", "In Bearbeitung", "2025-05-15"));
        this.projects.put(5, new Project(5, "Security Audit", "Sicherheitsüberprüfung der Infrastruktur", "Abgeschlossen", "2025-04-10"));
        System.out.println("Init Project Data");
    }

    @GetMapping("/services/project")
    public List<PathListEntry<Integer>> project() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var project : this.projects.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(project.getId(), "projectKey");
            entry.setName(project.getName());
            entry.getDetails().add("Status: " + project.getStatus());
            entry.getDetails().add("Deadline: " + project.getDeadline());
            entry.setTooltip(project.getDescription());
            
            // Farbe je nach Status setzen
            if ("Abgeschlossen".equals(project.getStatus())) {
                entry.setColor("green");
            } else if ("In Bearbeitung".equals(project.getStatus())) {
                entry.setColor("orange");
            } else {
                entry.setColor("blue");
            }
            
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/project/{key}")
    public Project getProject(@PathVariable Integer key) {
        return this.projects.get(key);
    }

    @PostMapping("/services/project")
    public void createProject(@RequestBody Project project) {
        Integer newId = this.projects.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        project.setId(newId);
        this.projects.put(newId, project);
    }

    @PutMapping("/services/project/{id}")
    public void updateProject(@PathVariable Integer id, @RequestBody Project project) {
        project.setId(id);
        this.projects.put(id, project);
    }

    @DeleteMapping("/services/project/{key}")
    public Project deleteProject(@PathVariable Integer key) {
        return this.projects.remove(key);
    }
}