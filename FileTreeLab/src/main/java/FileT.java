import java.io.File;

public class FileT {
    public static void main(String[] args) {
        String workDir = System.getProperty("user.dir");
        File currDir = new File(workDir);
        printFileTree(currDir, 0);
    }

    private static void printFileTree(File file, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    printFileTree(child, depth + 1);
                }
            }
        }
    }
}