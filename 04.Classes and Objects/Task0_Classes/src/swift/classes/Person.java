package swift.classes;


public class Person {
	String name;
    int age;

    public Person() {
        name = "No name";
        age = -1;
    }

    public Person(String personName) {
        name = personName;
        age = -1;
    }

    public Person(String personName, int personAge) {
        name = personName;
        age = personAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid name value.");
        } else {
            this.name = name;
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0 || age > 150) {
            System.out.println("Wrong type");
        } else {
            this.age = age;
        }
      
    }

    public void presentYourself() {

        if(name != null &&!name.trim().isEmpty()&& !"No name".equals(name)&&age>=0){
            System.out.println("Hello,I am " + name + ".I am " + age+".");

        }else if(name != null &&!name.trim().isEmpty()&& !"No name".equals(name)&&age<0){
            System.out.println("Hello,I am " + name+".");
        }else if((name==null||name.trim().isEmpty()||"No name".equals(name)&&age<0)){
            System.out.println("I am John Doe.");
        }


    }

    public static void main(String[] args) {
        Person person = new Person("Ivan", 15);
        Person personTwo = new Person("Ivan");
        Person personThree = new Person();

        person.presentYourself();
        personTwo.presentYourself();
        personThree.presentYourself();

    }
}
