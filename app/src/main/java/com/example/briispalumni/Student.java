package com.example.briispalumni;

public class Student {
    private String name;
    private String description;
    private int year;
    private String periodOfStudy;
    private String imageUrl;
    private String facebookLink;
    private String linkedInLink;
    private String githubLink;

    // Constructor
    public Student(String name, String description, int year, String periodOfStudy,
                   String imageUrl, String facebookLink, String linkedInLink, String githubLink) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.periodOfStudy = periodOfStudy;
        this.imageUrl = imageUrl;
        this.facebookLink = facebookLink;
        this.linkedInLink = linkedInLink;
        this.githubLink = githubLink;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public String getPeriodOfStudy() {
        return periodOfStudy;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public String getGithubLink() {
        return githubLink;
    }
}
