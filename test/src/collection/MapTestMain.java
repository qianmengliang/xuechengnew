package collection;

import java.util.*;

/**
 * Map
 * @author zsy
 * @version 1.0
 * @date 2020/5/20 0020 下午 3:17
 */
public class MapTestMain {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Bob", 78));
        list.add(new Student("Alice", 85));
        list.add(new Student("Brush", 66));
        list.add(new Student("Newton", 99));
        Students holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
    }
}

class Students {
    List<Student> list;
    Map<String, Integer> cache;

    Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            score = findInList(name);
            this.cache.put(name,score);
        }else{
            System.out.println("从缓存中获取");
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (Student ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
