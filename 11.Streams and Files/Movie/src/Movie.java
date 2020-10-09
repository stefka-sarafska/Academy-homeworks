import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Movie implements Serializable {
    String title;
    String director;
    List<String> actors;
    LocalDate releaseDate;

    public Movie(String title, String director, List<String> actors, LocalDate releaseDate) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie :" + title + "\nDirector: " + director + "\nActors: " + actors + "\nReleaseDate: "
                + releaseDate;
    }
}
