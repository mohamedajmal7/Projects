
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class DateTime implements Serializable {
    private int day;
    private int month;
    private int year;
    Scanner myObj=new Scanner(System.in);


    public DateTime(){
    }

    public DateTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {

        if (month==2){
            if (year%4==0){
                while (day<1 || day>29){
                    System.out.println("Please enter a valid date");
                    day=myObj.nextInt();
                }
            }else{
                while (day<1||day>28){
                    System.out.println("Please enter a valid date");
                    day=myObj.nextInt();
                }

            }
        }else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            while (day>31||day<1){
                System.out.println("Please enter a valida date");
                day=myObj.nextInt();
            }
        }else {
            while (day>30||day<1){
                System.out.println("Please enter a valida date");
                day=myObj.nextInt();
            }

        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        while (month>12||month<1){
            System.out.println("Please enter a valid month");
            month=myObj.nextInt();
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString(){
        return day+"/"+month+"/"+year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTime dateTime = (DateTime) o;
        return day == dateTime.day &&
                month == dateTime.month &&
                year == dateTime.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }
}