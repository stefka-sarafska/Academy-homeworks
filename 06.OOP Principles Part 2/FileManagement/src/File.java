import java.time.LocalDateTime;

public abstract class File {
    private String name;
    private String location;
    private LocalDateTime creationDate;
    private boolean isDeleted;

    public File(String name, String location, LocalDateTime creationDate, boolean isDeleted) {
        this.name = name;
        this.location = location;
        this.creationDate = creationDate;
        this.isDeleted = isDeleted;
    }

    public File(String name) {
        this.name = name;
    }

    public abstract File copy(String newLocation);

    public abstract void getInfo();

    public abstract void execute();

    public void move(String newLocation) {
        if (!newLocation.equals(this.location)) {
            setLocation(newLocation);
        }
    }

    public void delete() {
        this.isDeleted = true;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    private void setLocation(String location) {
        this.location = location;
    }
}
