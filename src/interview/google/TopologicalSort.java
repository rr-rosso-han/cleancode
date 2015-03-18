package interview.google;

import java.util.*;

/**
 * Created by jiahan on 3/4/15.
 */
class JavaFileOrigin {
    String name;
    Set<String> info; //file path set
    public JavaFileOrigin() {
        this.name = null;
        this.info = new HashSet<>();
    }
    public JavaFileOrigin(String name, Set<String> info) {
        this.name = name;
        this.info = info;
    }
}

public class TopologicalSort {
    class JavaFile {
        String name;
        Set<JavaFile> info;
        public JavaFile(String name) {
            this.name = name;
        }
        public JavaFile(String name, Set<String> info) {
            this.name = name;
            this.info = new HashSet<JavaFile>();
            for (String n : info) {
                this.info.add(new JavaFile(n));
            }
        }
    }

    public List<JavaFile> sort(List<JavaFileOrigin> files) {
        Map<JavaFile, Integer> indegrees = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        List<JavaFile> result = new LinkedList<>();
        if (files == null || files.size() == 0) {
            return result;
        }
        Set<JavaFile> newFiles = new HashSet<JavaFile>();

        for (JavaFileOrigin jfo : files) {
            newFiles.add(new JavaFile(jfo.name, jfo.info));
        }
        for (JavaFile jf : newFiles) {
            indegrees.put(jf, 0);
            visited.put(jf.name, false);
        }
        //init indegrees
        for (JavaFile jf : newFiles) {
            for (JavaFile item : jf.info) {
                indegrees.put(item, indegrees.get(item) + 1);
            }
        }
        Queue<JavaFile> queue = new LinkedList<>();
        for (JavaFile jf : newFiles) {
            if (indegrees.get(jf) == 0) {
                queue.offer(jf);
            }
        }
        while (!queue.isEmpty()) {
            JavaFile javafile = queue.poll();
            visited.put(javafile.name, true);
            if (indegrees.get(javafile) == 0) {
                result.add(javafile);
            }
            for (JavaFile file : javafile.info) {
                if (visited.get(file.name)) {
                    break;
                }
                indegrees.put(file, indegrees.get(file.name) - 1);
                if (indegrees.get(file) == 0) {
                    queue.offer(file);
                }
            }
        }
        return result;
    }
}
