import java.time.LocalDateTime;

public class ContentFile extends File {

    private String content;
    private LocalDateTime lastModifiedDate;

    public ContentFile(String name, String location, LocalDateTime creationDate, String content, LocalDateTime lastModifiedDate) {
        super(name, location, creationDate, false);
        this.content = content;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public File copy(String newLocation) {
        if (!newLocation.equals(this.getLocation())) {
            ContentFile copyOfFile = new ContentFile(this.getName(), newLocation, this.getCreationDate(), this.content, this.lastModifiedDate);
            return copyOfFile;
        }
        return null;
    }

    @Override
    public void getInfo() {
        if (this.isDeleted()) {
            System.out.printf("Name: %s/%s [DELETED]%nCreation date:%s%n", this.getLocation(), this.getName(),
                    this.getCreationDate());
            System.out.println("Last modification date: " + this.getLastModifiedDate());
            System.out.println();
        } else {
            System.out.printf("Name: %s/%s%nCreation date:%s%n", this.getLocation(), this.getName(),
                    this.getCreationDate());
            System.out.println("Last modification date: " + this.getLastModifiedDate());
        }
        System.out.println();

    }

    @Override
    public void execute() {
        System.out.println("Executing content file");
    }

    public void modify(String data) {
        this.content = data;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }


}
