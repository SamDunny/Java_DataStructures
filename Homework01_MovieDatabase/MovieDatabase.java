package Homework01_MovieDatabase;

public class MovieDatabase {

    // instance variables
    private GenLinkedList<String> movies;

    // default constructor
    public MovieDatabase() {
        this.movies = new GenLinkedList<String>();
    }

    // no parameterized constructor

    // Add a movie function
    public void addMovie(String aTitle) {
        movies.add(aTitle);
    }

    // Remove a movie by title function
    public void removeMovie(String aTitle) {
        if (movies.isInList(aTitle) == false) {
            System.out.println(aTitle + " is NOT in database");
            return;
        }
        movies.remove(aTitle);
    }

    // Search the movie by title. Returns true if it is found
    public boolean inDatabase(String aTitle) {
        return movies.isInList(aTitle);
    }

    // Print out all the movies to the console
    public void print() {
        movies.print();
    }
}
