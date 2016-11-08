package filesystem;

import java.util.ArrayList;
import java.util.Date;

public class FileSystem {

    public class file {
        private String name;
        private long size;
        private Date timeStamp;
        private file currentDir;
        private file parentDir;

        // a directory is also a file containing reference to other files
        private boolean isDirectory;
        public ArrayList<file> subfiles;

        // Advanced class members if required
        private boolean[] permissions;
        private String owner;
        private String group;
           
        public file(String name, file currentDir, boolean isDir) {
            this.name = name;
            this.currentDir = currentDir;
            this.timeStamp = new Date();
            this.isDirectory = isDir;
            this.size = 0; // initial size
            this.parentDir = currentDir.getParentDirectory();
            if (isDir == true)
                this.subfiles = new ArrayList<file>();
        }
        
        public void updateTimeStamp() {
            this.timeStamp = new Date();
        }
        
        public file getParentDirectory() {
            return this.parentDir;
        }
        
        public void rename(String name) {
            this.name = name;
        }
    
    }
    
    private file root; // root folder

    public FileSystem() {
        // every file system should have a root folder
        this.root = new file("root", null, true);
    }
    
    public void createFile(String name, file curDir, boolean isDir) {
        file f = new file(name, curDir, isDir);
        curDir.subfiles.add(f);
    }
}
