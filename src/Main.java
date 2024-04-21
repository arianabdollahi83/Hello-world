
import test.pack1.Person;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  // Import the Scanner class
public class Main {
    public static void main(String[] args){
        System.out.println(1);
        Scanner scanner=new Scanner(System.in);
        Country country=new Country();
       // while (true){
            String text=scanner.next();
            if(text.contains("avalin bare")==true){
                System.out.println(1);
                country.names.add(text.split(" ")[3]);

            }
            System.out.println(country.names);
            //hellow world
        System.out.println("i made some changes ")
       // }
    }
}
