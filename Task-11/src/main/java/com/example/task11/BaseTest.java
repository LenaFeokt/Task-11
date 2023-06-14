package com.example.task11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseTest {
    ArrayList<Qweston> test=new ArrayList<>();

    public BaseTest() {

        load("C:\\Users\\user\\Desktop\\Java2сем\\Task-11\\src\\main\\resources\\com\\example\\task11\\tests.txt");
    }
    public ArrayList<Qweston> createtest(int numberqwest){
        ArrayList<Qweston> currenttest=new ArrayList<>();
        ArrayList<Qweston> test1=new ArrayList<>();
        test1.addAll(test);
        for(int i = 0; i< numberqwest; i++){
            int index;
            index = (int)(Math.random()*test1.size());
            if(index == test1.size())index --;
            currenttest.add(test1.get(index));
            test1.remove(index);
        }
        return currenttest;
    }

    public ArrayList<Qweston> getTest() {
        return test;
    }
    private void load(String filename) {

        String temp;
        Qweston qtemp;
        FileReader fin;
        try {
            fin=new FileReader("C:\\Users\\user\\Desktop\\Java2сем\\Task-11\\src\\main\\resources\\com\\example\\task11\\tests.txt");
        } catch (FileNotFoundException e) {
            System.out.println("нет файла");
            return;

        }
        Scanner scanner = new Scanner(fin);
        scanner.useDelimiter("\\n");
        while (scanner.hasNextLine()) {
            qtemp=new Qweston("");
            temp=scanner.nextLine();
            qtemp.SetQuest(temp);

            while(!(temp=scanner.nextLine()).equalsIgnoreCase("#bad")){
                qtemp.addTrue(temp);
            }

            while(!(temp=scanner.nextLine()).equalsIgnoreCase("#vopros")){
                qtemp.addFalse(temp);
            }

            test.add(qtemp);
        }
        System.out.println("файл считан"+test.size());
    }
}
