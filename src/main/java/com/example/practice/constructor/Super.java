package com.example.practice.constructor;

/**
 * this，当前对象的引用，指这个对象在调用的方法，变量；在方法中存在this时指调用这个方法的对象
 * super，父类对象的引用
 * 子类构造方法第一行默认调用父类构造方法，如果不写，则默认调用父类无参构造，如果此时父类没有无参构造，则报错，
 * 可以在子类构造方法第一行写父类有参构造方法即可不报错，super(age)
 * 1.子类构造方法为什么会调用父类构造方法？
 * 因为子类继承父类，继承了父类的数据，则调用子类构造对子类进行初始化时，需要调用父类对父类的数据进行初始化。
 * 2.不能在其他方法中调用构造方法，只能在构造方法中调用。
 * 3.this(),super()构造方法只能在构造方法中写，不能在其他方法中写
 *   this.name,super.name,this.say(),super.say()可以在其他方法中写，也可以在构造方法中写。
 * 4.static静态变量不能放在（静态方法和非静态方法）里边，
 * 方法中的变量都是局部变量，static方法中的变量是局部变量只在这个static方法里边有效，而在方法中声明的static变量属于类，整个声明周期都存在。
 * --1.因为static属于类，而方法属于对象，如果将static放在方法里边，
 * --调用的时候就需要用new对象来调用这个方法，来访问这个变量，那岂不是成了这个变量属于这个对象了。
 * --2.static只能修饰成员变量或成员方法，不能修饰局部变量。
 * --方法在执行完了之后就会被释放了，但是static的是不能释放的，所以矛盾。
 * 5.static方法中不能有this,super?
 * --因为static属于类，通过类调用，不需要依赖对象，而this放在一个方法里边指代调用这个方法的对象，而此时没有对象，所有不能存在this；
 * --super在这个方法里边指代调用父类对象的东西，但是这个静态方法先存在，而这个父类的对象还不存在呢，所以不能写super.
 * 而this，super都是对象的，但是static方法中都没有对象，所有不能存在this，super。
 */

public class Super{
    public  int age;

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
    public static void A(){
//        static int a;//静态方法，变量不能定义在方法里边，因为static属于类，而方法属于对象，静态的东西需要在类加载的时候加载，但是方法在创建对象才能访问。
//        super.say();
//        this.say();
//        System.out.println(this.age);
//        System.out.println(super.age);
    }

    public static void main(String[] args) {
//        SuperSon superSon = new SuperSon();
//        System.out.println(superSon);
//        SuperSon superSon1 = new SuperSon(12,3);
//        System.out.println(superSon1);

        SuperSon superSon2 = new SuperSon(1,2,"1");
        System.out.println();
        A();
    }
}