package com.company;


import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
       File file=new File("C:\\Users\\Евгений\\IdeaProjects\\ToC_1\\F1.txt");
       File file2=new File("C:\\Users\\Евгений\\IdeaProjects\\ToC_1\\F2.txt");
       FileReader reader = new FileReader(file);
       FileReader reader2 = new FileReader(file2);

       ArrayList<Character> characters=new ArrayList<>();
       ArrayList<Character> characters2=new ArrayList<>();

        rewrite(reader,characters);
        rewrite(reader2,characters2);

        String text=getStringRepresentation(characters);
        String text2=getStringRepresentation(characters2);

        //System.out.println(text);
        calcEnthropy(text,"a");
        calcEnthropy(text,"sc");
        calcEnthropy(text,"und");

        System.out.println();

        //System.out.println(text2);
        calcEnthropy(text2,"a");
        calcEnthropy(text2,"qw");
        calcEnthropy(text2,"qee");

    }
    public static String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
    public static void rewrite(FileReader reader,ArrayList<Character> characters) throws IOException {
        int ch;
        while(reader.ready()){
            ch = reader.read();
            characters.add((char)ch);
        }
    }
    public static void showInfo(ArrayList<Character> characters){
        for(Character i:characters){
            System.out.print(i);
        }
        System.out.println();
    }
    public static void calcEnthropy(String text,String str){

        float res;
        int reps=0;
        int fromIndex=0;
        while ((fromIndex = text.indexOf(str, fromIndex)) != -1 ){
            reps++;
            fromIndex++;
        }
        res= (float) (Math.log(reps)/Math.log(2));
        System.out.println("For "+str+" we have : "+reps+" Capacity of enthropy is: "+ res);
    }
}

