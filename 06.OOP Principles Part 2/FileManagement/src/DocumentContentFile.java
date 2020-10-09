import java.time.LocalDateTime;

public class DocumentContentFile extends ContentFile{
    private final static char CHECK_SYMBOL='\u2713';
    public DocumentContentFile(String name, String location, LocalDateTime creationDate, String content,
                               LocalDateTime lastModifiedDate) {
        super(name, location, creationDate, content, lastModifiedDate);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void execute() {
        System.out.print(CHECK_SYMBOL);
        System.out.print(CHECK_SYMBOL);
        System.out.print(CHECK_SYMBOL);
        System.out.println(this.getLocation()+"/"+this.getName()+"\n"+this.getContent());

    }





}
