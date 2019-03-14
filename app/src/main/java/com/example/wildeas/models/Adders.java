package com.example.wildeas.models;

public class Adders {
        String title;
        String date;
        String description;

        //Constructeurs

    public Adders(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }


        //getter et setter title
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        //getter et setter date
        public String getDate() {
        return date;
        }

        public void setDate(String date) {
        this.date = date;
        }


        //getter et setter description
        public String getDescription() {
            return description;
        }


        public void setDescription(String description) {
            this.description = description;
        }
    }


