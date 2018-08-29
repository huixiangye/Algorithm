package leetcode.HashMap.简单的HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yehuixiang on 8/23/18.
 * Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.

 A group of duplicate files consists of at least two files that have exactly the same content.

 A single directory info string in the input list has the following format:

 "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

 It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

 The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

 "directory_path/file_name.txt"

 Example 1:
 Input:
 ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 Output:
 [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 */
public class FindDuplicateFileinSystem_609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();

        if(paths == null || paths.length == 0)
            return res;

        HashMap<String,List<String>> map = new HashMap<>();

        for(String path : paths){
            //去掉首位空格
            path = path.trim();
            String[] array = path.split(" ");
            String root = array[0];
            StringBuffer sb = new StringBuffer();
            for(int i = 1;i < array.length;i++){
                String key = array[i].substring(array[i].indexOf("(")+1,array[i].indexOf(")"));
                String value = array[i].substring(0,array[i].indexOf("("));
                sb = new StringBuffer();
                sb.append(root);
                sb.append("/");
                sb.append(value);
                System.out.println(sb.toString());
                if(map.containsKey(key)){
                    // 如何更新HashMap的值
                    List<String> temp = map.get(key);
                    temp.add(new String(sb.toString()));
                    map.put(key,temp);
                }else{
                    List<String> list = new ArrayList<>();
                    list.add(new String(sb.toString()));
                    map.put(key,list);
                }
            }
        }
        //  如何进行HashMap的遍历
        for (Map.Entry<String,List<String>> entry : map.entrySet()) {
            if(entry.getValue().size() > 1){
                res.add(new ArrayList<String>(entry.getValue()));
            }
        }

        return res;
    }
}
