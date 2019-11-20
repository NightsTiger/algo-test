package gsontest;

import java.util.Optional;


/**
 * @author : dingwenqiang
 * @date : 2019/9/6 00:04
 */
public class ATest {

    public static void main(String[] args) {
        Person p = null;
        Optional<Person> optional = Optional.ofNullable(p);


        String s = optional.map(Person::getName).get();


        System.out.println(s);

    }
    
    private static class Person{
        private String name;

        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
    
}
