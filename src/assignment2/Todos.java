package assignment2;

import java.time.LocalDate;

/**
 *
 * @author Daria Davydenko
 * Student number: 200335788
 */
public class Todos extends List {

    private String description;
    private LocalDate dueDate;

    public enum LevelOfImportance {
        REALLY_IMPORTANT, IMPORTANT, NOT_IMPORTANT
    };
    private LevelOfImportance importance;

    /**
     * This is a constructor for Todos class. It extends List class.
     *
     * @param name
     * @param description
     * @param dueDate
     * @param importance
     */
    public Todos(String name, String description,
            LocalDate dueDate, LevelOfImportance importance) {
        super(name);
        this.description = description;
        setDueDate(dueDate);
        this.importance = importance;
    }

    /**
     * This method checks if the due date is later than today. If yes, the due
     * date will be set, else IllegalArgumentExeption will be thrown.
     *
     * @param dueDate
     */
    public void setDueDate(LocalDate dueDate) {
        LocalDate today = LocalDate.now();

        if (dueDate.isAfter(today)) {
            this.dueDate = dueDate;
        } else {
            throw new IllegalArgumentException("You can't change anything in your past. Sorry :c");
        }
    }

    @Override
    public String toString() {
        return getName() + ": " + description + " till " + dueDate + ". It is " + importance;
    }
    
    //Getters and Setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LevelOfImportance getImportance() {
        return importance;
    }

    public void setImportance(LevelOfImportance importance) {
        this.importance = importance;
    }
}
