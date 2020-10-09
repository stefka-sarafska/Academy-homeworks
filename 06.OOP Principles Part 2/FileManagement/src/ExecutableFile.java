import java.time.LocalDateTime;

public class ExecutableFile extends File {
    private LocalDateTime lastExecutionDate;
    private File[] requiredResources;

    public ExecutableFile(String name, String location, LocalDateTime creationDate,LocalDateTime lastExecutionDate,File[] requiredResources) {
        super(name, location, creationDate, false);
        this.lastExecutionDate=lastExecutionDate;
        this.requiredResources=requiredResources;
    }

    @Override
    public File copy(String newLocation) {
        if (!newLocation.equals(getLocation())) {
            ExecutableFile copyOfFile = new ExecutableFile(getName(), newLocation, getCreationDate(),this.lastExecutionDate,this.requiredResources);
            return copyOfFile;
        }
        return null;
    }

    @Override
    public void execute() {
        System.out.printf("Executing%s/%s%n",this.getLocation(),this.getName());
        for(File c:requiredResources) {
            if(c instanceof MediaContentFile) {
                c.execute();
            }else if(c instanceof DocumentContentFile) {
                c.execute();
            }else if(c instanceof ExecutableFile){
                c.execute();
            }
        }
    }

    @Override
    public void getInfo() {
        if (this.isDeleted()) {
            System.out.printf("Name: %s/%s [DELETED]%nCreation date:%s%n", this.getLocation(), this.getName(),
                    this.getCreationDate());
            System.out.printf("Last execution date:%s%n", this.getLastExecutionDate());
            System.out.println("Required resources:");
            File[] resources = this.getRequiredResources();
            for (File s : resources) {
                System.out.println(s.getName());
            }
            System.out.println();
        } else {
            System.out.printf("Name: %s/%s%nCreation date:%s%n", this.getLocation(), this.getName(),
                    this.getCreationDate());
            System.out.printf("Last execution date:%s%n", this.getLastExecutionDate());
            System.out.println("Required resources:");
            File[] resources = this.getRequiredResources();
            for (File s : resources) {
                System.out.printf("%15s %n",s.getName());
            }
            System.out.println();
        }
    }


    public LocalDateTime getLastExecutionDate() {
        return lastExecutionDate;
    }

    public File[] getRequiredResources() {
        return requiredResources;
    }

}
