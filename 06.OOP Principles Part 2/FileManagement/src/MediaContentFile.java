import java.time.LocalDateTime;

public class MediaContentFile extends ContentFile{
    private final static char MUSIC_NOTE='\u266B';
    public MediaContentFile(String name, String location, LocalDateTime creationDate, String content,
                            LocalDateTime lastModifiedDate) {
        super(name, location, creationDate, content, lastModifiedDate);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void execute() {
        System.out.print(MUSIC_NOTE);
        System.out.print(MUSIC_NOTE);
        System.out.print(MUSIC_NOTE);
        System.out.println(this.getLocation()+"/"+this.getName()+"\n"+this.getContent());
    }



}
