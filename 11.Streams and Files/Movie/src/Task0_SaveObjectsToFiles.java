import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task0_SaveObjectsToFiles {
    private static Scanner sp = new Scanner(System.in);
    private static List<String> actors = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {


        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("movie.txt"));
        out.writeObject(createMovieObject());
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("movie.txt"));
        Movie readenMovie = (Movie) in.readObject();
        System.out.println(readenMovie);
        in.close();


    }

    private static Movie createMovieObject() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Enter movie name: ");
        String title = sp.nextLine();
        System.out.println("Enter director of movie: ");
        String director = sp.nextLine();
        System.out.println("Enter actors delimiter with \",\" : ");
        String[] actorsIn = sp.nextLine().split(", ");
        actors.addAll(Arrays.asList(actorsIn));
        System.out.println("Enter date i format d/MM/yyyy: ");
        String date = sp.nextLine();
        LocalDate localDate = LocalDate.parse(date, formatter);
        return new Movie(title, director, actors, localDate);

    }

}
