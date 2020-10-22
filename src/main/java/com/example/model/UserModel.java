package com.example.model;

public class UserModel {
    private String id;
    private String surname;
    private String name;
    private String Command;
    private String Group;
    private String Project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }
}
