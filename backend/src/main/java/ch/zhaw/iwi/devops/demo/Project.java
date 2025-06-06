package ch.zhaw.iwi.devops.demo;

public class Project {

    private int id;
    private String name;
    private String description;
    private String status;
    private String deadline;

    public Project() {
    }
    
    public Project(int id, String name, String description, String status, String deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
