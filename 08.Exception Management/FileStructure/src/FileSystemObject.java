
public class FileSystemObject {
	private Object parent;
	private String name;

	
	public FileSystemObject(Object parent, String name) {
		this.parent = parent;
		this.name = name;
	}
	public FileSystemObject(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
public String getParentName() {
	if(parent instanceof FileObject) {
		return ((FileObject) parent).getName();
	}else if(parent instanceof FolderObject) {
		return ((FolderObject) parent).getName();
	}
	return null;
}
	
	
	

}
