import java.util.ArrayList;
import java.util.List;

class TrainManagement {

    // Bogie list
    private List<String> bogies;

    // Constructor
    public TrainManagement() {
        bogies = new ArrayList<>();
    }

    // Method to add bogie
    public void addBogie(String bogieName) {
        bogies.add(bogieName);
    }

    // Search operation
    public void searchBogie(String searchName) {


        if (bogies.isEmpty()) {
            throw new IllegalStateException("Cannot perform search: No bogies available in the train.");
        }


        boolean found = false;

        for (String bogie : bogies) {
            if (bogie.equalsIgnoreCase(searchName)) {
                found = true;
                break;
            }
        }


        if (found) {
            System.out.println("Bogie found: " + searchName);
        } else {
            System.out.println("Bogie not found: " + searchName);
        }
    }


    public static void main(String[] args) {

        TrainManagement train = new TrainManagement();

        try {

            train.searchBogie("Sleeper");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }


        train.addBogie("Sleeper");
        train.addBogie("AC");
        train.addBogie("General");


        train.searchBogie("AC");
        train.searchBogie("Luxury");
    }
}