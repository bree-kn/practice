package com.example.practice.enumpackage;

/*public enum Weekday {
    SUN(0),MON(1),TUS(2),WED(3),THU(4),FRI(5),SAT(6);
    private int value;
    private Weekday(int value){
        this.value = value;
    }

    public static Weekday getNextDay(Weekday nowDay){
        int nextDayValue = nowDay.value;

        if(++nextDayValue == 7){
            nextDayValue = 0;
        }

        return getWeekdayByValue(nextDayValue);
    }

    public static Weekday getWeekdayByValue(int value){
        for(Weekday c : Weekday.values()){
            if(c.value == value){
                return c;
            }
        }
        return null;
    }
}*/
public enum  Weekday{
    SPRING("春天"),SUMMER("夏天"),FALL("秋天"),WINTER("冬天");
    private String name;
    private Weekday(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Weekday getWeekdayByValue(String name){
        for(Weekday c : Weekday.values()){
            if(name.equals(c.name)){
                return c;
            }
        }
        return null;
    }

}

class Test2{
    public static void main(String[] args) {
//        System.out.println(Weekday.FRI);
//        System.out.println(Weekday.FRI.ordinal());
//        System.out.println(Weekday.getNextDay(Weekday.SAT));
//        System.out.println(Weekday.FRI);
        System.out.println(Weekday.getWeekdayByValue(Weekday.FALL.getName()));
    }
}