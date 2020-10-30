public class Save {
    private final File f;
    private final Properties p = new Properties();

    public Save(File file) {
        f = file;
        if(file.exists()) load();
    }

    public String get(String key) {
        return p.getProperty(key);
    }

    public void set(String key, String value) {
        p.setProperty(key, value);
        saveProperties();
    }

    public void saveProperties() {
        try {
            p.store(new FileOutputStream(f), "Save File");
        } catch (IOException e) {
            System.out.println("Failed to save !");
            System.out.println(e.toString());
        }
    }

    public void load() {
        try {
            p.load(new FileInputStream(f));
        } catch (IOException e) {
            System.out.println("Failed to load !");
            System.out.println(e.toString());
        }
    }
}
