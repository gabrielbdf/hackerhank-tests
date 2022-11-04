package com.gabriel.solveds.praticing;

import java.util.ArrayList;
import java.util.List;

class LanguageStudent {
    List<String> languages = new ArrayList<>();

    public void learnLanguage(String language) {
        this.languages.add(language);
    }

    public List<String> getLanguages() {
        return this.languages;
    }

}

class LanguageTeacher {
    List<String> languages = new ArrayList<>();

    public static void main(String[] args) {
        LanguageTeacher teacher = new LanguageTeacher();
        teacher.addLanguage("English");

        LanguageStudent student = new LanguageStudent();
        teacher.teach(student, "English");

        for (String language : student.getLanguages())
            System.out.println(language);
    }

    private void addLanguage(String language) {
        this.languages.add(language);
    }

    public void teach(LanguageStudent student, String language) {
        student.learnLanguage(language);
    }

}