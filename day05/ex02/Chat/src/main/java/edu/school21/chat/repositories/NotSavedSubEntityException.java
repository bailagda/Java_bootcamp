package edu.school21.chat.repositories;

public class NotSavedSubEntityException extends RuntimeException {
    @Override
    public String toString() {
        return "Author or room have no ID existing, or these IDs are null\n";
    }
}
