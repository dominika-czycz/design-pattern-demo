package com.patterns.demo.creational.abstractfactory.application.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Getter
public abstract class Resume implements Composable {

    @Setter
    private String personalInformation;
    @Setter
    private String objective;
    private Map<LocalDate, String> education;
    private Map<LocalDate, String> experience;
    private List<String> awards;
    private List<String> hobbies;
    private String composition;

    public void addToEducation(LocalDate date, String value) {
        this.education.put(date, value);
    }

    public void addToExperience(LocalDate date, String value) {
        this.experience.put(date, value);
    }

    public void addToAwards(List<String> value) {
        this.awards.addAll(value);
    }

    public void addToHobbies(List<String> value) {
        this.hobbies.addAll(value);
    }

    @Override
    public void compose() {
        String basicComposition = new StringJoiner(", ")
                .add("personalInformation='" + personalInformation + "'")
                .add("objective='" + objective + "'")
                .add("education=" + education)
                .add("experience=" + experience)
                .add("awards=" + awards)
                .add("hobbies=" + hobbies)
                .add("composition='" + composition + "'")
                .toString();
        this.composition = addSpecificFields(basicComposition);
    }

    protected abstract String addSpecificFields(String basicComposition);
}
