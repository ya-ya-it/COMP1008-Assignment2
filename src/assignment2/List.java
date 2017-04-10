package assignment2;

import java.util.ArrayList;

/**
 *
 * @author Daria Davydenko 
 * Student number: 200335788
 */

public class List {
    private String name;
    private Boolean isDone;
    private ArrayList<String> list;

    /**
     * This is a constructor for List class
     * @param name
     * @param isDone 
     */
    
    public List(String name) {
        this.name = name;
        this.isDone = false;
        list = new ArrayList<>();
    }
    
    /**
     * This method receives items and add it to a list
     * @param item 
     */
    
    public void addToList(String item){
        list.add(item);
    }
    
    /**
     * This method shows the list separated with comma
     * @return 
     */
    
    public String showList() {
        StringBuilder sb = new StringBuilder(list.size());
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        String items = sb.toString();
        return items;
    }
    
    /**
     * This method override toString method
     * @return name
     */

    @Override
    public String toString() {
        return name;
    }

    /**
     * This method sets the isDone variable as true
     */
    
    public void setIsDone() {
        this.isDone = true;
    }
    
    //Getters and Setters
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public ArrayList<String> getList() {
        return list;
    }
    
}
