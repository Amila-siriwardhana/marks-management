public class Data {
    private int count;
    private Student[] data;
    private String filepath;

    private static Data instance;

    private Data() {}

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Student[] getData() {
        return data;
    }

    public void setData(Student[] data) {
        this.data = data;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    
    
}
