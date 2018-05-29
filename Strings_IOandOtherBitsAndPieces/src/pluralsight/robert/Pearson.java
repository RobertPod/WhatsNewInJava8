package pluralsight.robert;

import java.util.PrimitiveIterator;

public class Pearson {
    private String name;
    private int age;
    private String gender;

    public Pearson() {
    }

    public Pearson(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pearson pearson = (Pearson) o;

        if (age != pearson.age) return false;
        if (name != null ? !name.equals(pearson.name) : pearson.name != null) return false;
        return gender != null ? gender.equals(pearson.gender) : pearson.gender == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pearson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
