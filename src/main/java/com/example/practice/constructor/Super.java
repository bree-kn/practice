package com.example.practice.constructor;

/**
 * 子类构造方法第一行默认调用父类构造方法，如果不写，则默认调用父类无参构造，如果此时父类没有无参构造，则报错，
 * 可以在子类构造方法第一行写父类有参构造方法即可不报错，super(age)
 * 1.子类构造方法为什么会调用父类构造方法？
 * 因为子类继承父类，继承了父类的数据，则调用子类构造对子类进行初始化时，需要调用父类对父类的数据进行初始化。
 * 2.不能在其他方法中调用构造方法，只能在构造方法中调用。
 */

public class Super{
    public int age;

    public String say(){
//        this();//其他方法不能调用构造器
        return "i am say 父类";
    }
    public Super() {
        System.out.println("i am super 父类 无参构造");
    }

    public Super(int age) {
        this.age = age;
        System.out.println("i am super 父类 有参构造");
    }
}
class SuperSon extends  Super{//此处如果本类中没有写构造方法时，默认生成一个无参构造方法，这个方法会自动调用父类无参构造，但是
                                //如果父类中没有写这个无参构造，则class SuperSon extends Super这行会报错。
    public SuperSon(){//子类无参构造方法只能调用子类无参构造方法，若父类没有，则报错。
        super();
        System.out.println("i am superson 子类 无参构造");
    }
    public SuperSon(int age) {
        super(age);//当子类用构造方法来创建对象时，会先调用父类构造方法，如果不写super则默认调用父类无参构造方法，
        // 若是父类没有写无参构造方法，则此处报错，可以写super(age)来调用父类有参构造方法即不报错。
        //super必须在第一行
        System.out.println("i am superson 子类 有参构造");
    }
    public SuperSon(int age,int grade,String name){
//        super();
        this(age);//super和this必须只能有一个，因为都必须在第一行。
        System.out.println(super.age);
        System.out.println(super.say());
        System.out.println(this.age);
        System.out.println(this.say());
//        super(age);
        System.out.println("i am superson 子类 有参构造 3个参数");
    }

    public static void main(String[] args) {
//        SuperSon superSon = new SuperSon();
//        System.out.println(superSon);
//        SuperSon superSon1 = new SuperSon(12,3);
//        System.out.println(superSon1);
        SuperSon superSon2 = new SuperSon(1,2,"1");
    }
}