package DesignPatterns.DIY;
import java.util.ArrayList;
import java.util.List;

interface FileSystemNode {
    void accept(Operation operation);
    int getSize();
}


class File implements FileSystemNode {
    private int size;

    public File(int size) {
        this.size = size;
    }

    @Override
    public void accept(Operation operation) {
        operation.apply(this);
    }

    @Override
    public int getSize() {
        return size;
    }

   
}

class Directory implements FileSystemNode {
    private List<FileSystemNode> children = new ArrayList<>();

    public void add(FileSystemNode node) {
        children.add(node);
    }

    @Override
    public void accept(Operation operation) {
        operation.apply(this);
        for (var child : children)
            child.accept(operation);
    }

    @Override
    public int getSize() {
        int size = 0;
        for (var child : children)
            size += child.getSize();
        return size;
    }

    
}

interface Operation {
    void apply(File file);
    void apply(Directory directory);
}

class SizeCalculationOperation implements Operation {
    private int size;

    @Override
    public void apply(File file) {
        size += file.getSize();
    }

    @Override
    public void apply(Directory directory) {
    }

    public int getSize() {
        return size;
    }
}



public class VisitorPattern {
    public static void main(String[] args) {
        var root = new Directory();
        var file1 = new File(100);
        var file2 = new File(200);
        var subDir = new Directory();
        var file3 = new File(300);


        root.add(file1);
        root.add(file2);
        root.add(subDir);
        root.add(file3);
        

        var sizeCalculation = new SizeCalculationOperation();
        root.accept(sizeCalculation);
        System.out.println("Total size: " + sizeCalculation.getSize());
    }
}