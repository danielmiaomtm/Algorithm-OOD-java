    abstract class Entry {
        protected Directory parent = null;
        protected long created;
        protected long lastUpdated;
        protected long lastAccessed;
        protected String name;

        public Entry (String name, Directory parent) {
            this.name = name;
            this.parent = parent;
            this.created = System.currentTimeMillis();
        }

        public boolean delete () {
            if (parent == null) {
                return false;
            }
            return parent.deletEntry(this);
        }

        public String getFullPath () {
            if (parent == null) {
                return name;
            } 
            return parent.getFullPath() + "/" + name;
        }
        public abstract int size();
    }

    class File extends Entry {
        private String content;
        private int size;
        public File (String name, Directory parent, int size, String content) {
            super(name, parent);
            size = size;
            content = content;
        }
        public int size () {
            return this.size;
        }
        public String getContent () {
            return this.content;
        }
    }

    class Directory extends Entry {

        protected List<Entry> contents;

        public Directory (String name, Directory parent) {
            super (name, parent);
            contents = new ArrayList<>();
        }
        protected List<Entry> getContents () {
            return contents;
        }
        public int size() {
            int size = 0;
            for (Entry e : contents) {
                size += e.size();
            }
            return size;
        }
        public int numOfFiles () {
            int count = 0;
            for (Entry e : contents) {
                if (e instanceof Directory) {
                    count++;
                    Directory d = (Directory) e;
                    count += d.numOfFiles();
                } else if (e instanceof File) {
                    count++;
                }
            }
            return count;
        }
        public void deleteEntry(Entry entry) {
            return contents.remove(entry);
        }
        public void addEntry (Entry entry) {
            contents.add(entry);
        }
    }
