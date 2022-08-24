package com.example.mentorship.Chat;

public class Message {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFromme() {
        return isFromme;
    }

    public void setFromme(boolean fromme) {
        isFromme = fromme;
    }

    public Message(String message, boolean isFromme) {
        this.message = message;
        this.isFromme = isFromme;
    }

    public String message;
    public boolean isFromme;
}
