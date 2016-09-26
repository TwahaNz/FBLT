package FBLT.domain;

/**
 * Created by Brandonhome on 2016/09/26.
 */
public class PersistenceTestClass {
    private String id;
    private String name;
    private int age;

    public PersistenceTestClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
