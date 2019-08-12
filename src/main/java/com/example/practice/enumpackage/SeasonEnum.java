package com.example.practice.enumpackage;

/**
 * 枚举和静态变量：
 * 枚举类型的每一个值都将映射到protected Enum构造函数中，每个值的名称都被转换成一个字符串
 * 枚举更直观，类型安全，比起静态常量
 *1. 枚举默认继承了枚举Enum，可以实现一个或多个接口
 *2.所有实例必须放在第一行，不需用new关键字，无需显式调用构造器，自动添加public static final
 *3.使用enum定义，非抽象的枚举类默认使用final修饰，不可以被继承
 *4.枚举类的构造器只能是私有的(目的是不能再别处申明此类的对象了，枚举类应该设置为不可变类，属性不应该
 * 被改变，才会更安全，所有属性，构造方法都为private)
 */
public enum SeasonEnum {
  SPRING("春天"),SUMMER("夏天"),FALL("秋天"),WINTER("冬天");
  private final String name;
  private SeasonEnum(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }
  public static void main(String[] args) {
    System.out.println(SeasonEnum.FALL.getName());
  }
}


