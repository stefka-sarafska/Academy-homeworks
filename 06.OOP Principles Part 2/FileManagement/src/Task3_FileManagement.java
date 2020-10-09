import java.time.LocalDateTime;
import java.util.Scanner;

public class Task3_FileManagement {
    private static File[] files = new File[500];
    private static int countFiles = 0;
    public static void main(String[] args) {
        Scanner sp = new Scanner(System.in);
        String line = sp.nextLine();
        String[] input = line.split(" ");
        String command = input[0];

        while (!"END".equals(command)) {
            File searchedFile =searchFileByName(input[1]);

            switch (command) {
                case "MAKE":
                    createFile(input);
                    break;
                case "MOVE":
                    if (searchedFile != null) {
                        searchedFile.move(input[2]);
                    }

                    break;
                case "MOD":
                    if (searchedFile != null) {
                        if (searchedFile instanceof ContentFile) {
                            ContentFile p = (ContentFile) searchFileByName(input[1]);
                            p.modify(input[2]);
                        }
                    }
                    break;
                case "COPY":
                    if (searchedFile != null) {
                        searchedFile.copy(input[2]);
                    }

                    break;
                case "DEL":
                    if (searchedFile != null) {
                        searchedFile.delete();
                    }
                    break;
                case "EXEC":
                    if (searchedFile != null) {
                        if (searchedFile instanceof ExecutableFile) {
                            searchedFile.execute();
                            System.out.println();
                        } else if (searchedFile instanceof MediaContentFile) {
                            searchedFile.execute();
                            System.out.println();
                        } else if (searchedFile instanceof DocumentContentFile) {
                            searchedFile.execute();
                            System.out.println();
                        }
                    }

                    break;

                case "INFO":
                    if (searchFileByName(input[1]) != null) {
                        searchFileByName(input[1]).getInfo();
                    }
                    break;

            }
            line = sp.nextLine();
            input = line.split(" ");
            command = input[0];
        }
    }

    private static File searchFileByName(String name) {
        for (File p : files) {
            if (p != null && name.equals(p.getName())) {
                return p;
            }
        }
        return null;

    }

    private static void createFile(String[] input) {
        if (isContentFile(input[3])) {
            String[] content = input[3].split("=");
            if (isMediaContentFile(input[1])) {
                files[countFiles] = new MediaContentFile(input[1], input[2], LocalDateTime.now(), content[1],
                        LocalDateTime.now());
                countFiles++;
            } else {

                files[countFiles] = new DocumentContentFile(input[1], input[2], LocalDateTime.now(), content[1],
                        LocalDateTime.now());
                countFiles++;
            }
        } else {

            files[countFiles] = new ExecutableFile(input[1], input[2], LocalDateTime.now(), LocalDateTime.now(),
                    getRequiredResources(input));
            countFiles++;

        }
    }

    private static File[] getRequiredResources(String[] input) {
        File[] resources = new File[input.length - 3];
        for (int i = 0; i < resources.length; i++) {
            if (searchFileByName(input[i + 3]) != null) {
                resources[i] = searchFileByName(input[i + 3]);
            }

        }
        return resources;

    }

    private static boolean isContentFile(String input) {
        boolean isContent = false;
        if (input != null) {
            if (input.startsWith("CONTENT")) {
                isContent = true;
            } else {
                isContent = false;
            }
        }
        return isContent;
    }

    private static boolean isMediaContentFile(String input) {
        boolean isMedia = false;
        if (input != null) {
            if ((input.endsWith(".avi") || input.endsWith(".mp3"))) {
                isMedia = true;
            } else {
                isMedia = false;
            }
        }
        return isMedia;
    }

}
