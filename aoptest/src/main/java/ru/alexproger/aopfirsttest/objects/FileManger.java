package ru.alexproger.aopfirsttest.objects;

import org.springframework.stereotype.Component;
import ru.alexproger.aopfirsttest.annotations.ShowResult;
import ru.alexproger.aopfirsttest.annotations.ShowTime;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Component
public class FileManger {
    @ShowTime
    @ShowResult
    public Set<String> getExtensionList(String folder) {
        File dir = new File(folder);

        Set<String> extList = new TreeSet<>();

        for (String fileName : dir.list()) {

            File file = new File(dir.getAbsolutePath() + "/" + fileName);

            int i = fileName.lastIndexOf(".");
            if (file.isFile() && i != -1) {
                extList.add(fileName.substring(i + 1, fileName.length()).toLowerCase());
            }
        }

        return extList;

    }

    @ShowTime
    @ShowResult
    public Map<String, Integer> getExtensionCount(String folder) {

        File dir = new File(folder);

        Map<String, Integer> map = new HashMap<>();

        for (String ext : getExtensionList(folder)) {
            FilenameFilter filter = new CustomFileFilter(ext);
            map.put(ext, dir.listFiles(filter).length);
        }

        return map;

    }
}
