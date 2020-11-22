package com.example.ngoapp;

public class Event {
    private String name;
    private String organizer;
    private String description;
    private int participants;

    Event(String name, String organizer, String description, int participants) {
        this.name = name;
        this.organizer = organizer;
        this.description = description;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
}
