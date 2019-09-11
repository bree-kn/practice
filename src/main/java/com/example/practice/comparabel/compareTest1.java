package com.example.practice.comparabel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections.sort(list);
 */
public class compareTest1 implements Comparable<compareTest1> {
    private Integer age;
    private Double price;
    private BigDecimal money;
    private String rate;
    private String orderByName;
    @Override
    public int compareTo(compareTest1 o) {
        int flag = 0;
        //int排序
       if("age".equalsIgnoreCase(orderByName)){
         flag = this.age - o.age;
         return flag;
       }
       //double排序
       if("price".equalsIgnoreCase(orderByName)){
           flag = this.price.compareTo(o.price);
           return flag;
       }
       if("money".equalsIgnoreCase(orderByName)){
           flag =this.money.compareTo(o.money);
           return flag;
       }
       if("rate".equalsIgnoreCase(orderByName)){
           BigDecimal thisa = new BigDecimal(this.rate.substring(0,this.rate.lastIndexOf("%")));
           BigDecimal oa = new BigDecimal(o.rate.substring(0,o.rate.lastIndexOf("%")));
           flag = thisa.compareTo(oa);
           return flag;
       }
       return flag;
    }

    public compareTest1(Integer age, Double price, BigDecimal money, String rate, String orderByName) {
        this.age = age;
        this.price = price;
        this.money = money;
        this.rate = rate;
        this.orderByName = orderByName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getOrderByName() {
        return orderByName;
    }

    public void setOrderByName(String orderByName) {
        this.orderByName = orderByName;
    }

    @Override
    public String toString() {
        return "compareTest1{" +
                "age=" + age +
                ", price=" + price +
                ", money=" + money +
                ", rate='" + rate + '\'' +
                ", orderByName='" + orderByName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String orderByName = "rate";
        List<compareTest1> list = new ArrayList<compareTest1>();
        list.add(new compareTest1(1,11.2,new BigDecimal(43.2),"22.2%",orderByName));
        list.add(new compareTest1(6,1.2,new BigDecimal(1.2),"99.22%",orderByName));
        list.add(new compareTest1(88,44.2,new BigDecimal(44.2),"44.2%",orderByName));
        list.add(new compareTest1(33,11.7,new BigDecimal(11.7),"32.2%",orderByName));
        list.add(new compareTest1(2,11.3,new BigDecimal(43.2),"22.6%",orderByName));
        list.add(new compareTest1(66,99.2,new BigDecimal(99.2),"2.2%",orderByName));
        list.add(new compareTest1(7,33.2,new BigDecimal(43.2),"92.2%",orderByName));
        Collections.sort(list);
        System.out.println(list);
    }
}
