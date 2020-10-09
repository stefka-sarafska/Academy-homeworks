import java.io.File;

public class FolderObject extends FileSystemObject {
	private static int childrenCount = 0;
	private FileSystemObject[] children = new FileSystemObject[50];

	public FolderObject(Object parent, String name) {
		super(parent, name);
	}

	public FolderObject(String name, FileSystemObject[] children) {
		super(name);
		this.children = children;
	}

	public FolderObject(String name) {
		super(name);
	}

	public void setChildren(FileSystemObject file) {
		if (file != null) {
			children[childrenCount] = file;
			childrenCount++;
		}
	}

}
