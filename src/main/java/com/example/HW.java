package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class HW {
    private HW() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] str = scn.nextLine().split(" ");
        parser(str);
    }

    public static void parser(String[] str){
        try{
            String[] data = {"","","","","",""};
            List<String> list = new ArrayList<String>(Arrays.asList(str));
            if(list.size()>5){
                if(list.size()==6){
                    int i = 0;
                    while(i<list.size()){
                        if((list.get(i).equals("f"))||(list.get(i).equals("m"))){
                            data[5] = list.get(i);
                            list.remove(i);
                            i--;
                        }
                        if((list.get(i).length() == 10)&&(list.get(i).charAt(2) == '.')&&(list.get(i).charAt(5) == '.')){
                            data[4] = list.get(i);
                            list.remove(i);
                            i--;
                        }
                        if(isNumeric(list.get(i))){
                            data[3] = list.get(i);
                            list.remove(i);
                            i--;
                        }
                        i++;
                    }
                    i=0;
                    for (String string : list) {
                        data[i] = string;
                        i++;
                    }
                    List<String> empysList = new ArrayList<>();
                    for (String string : data) {
                        if(string.equals("")){
                            empysList.add(string);
                        }
                    }
                    if(empysList.size()>0)
                        throw new EmptyElements(empysList);
                    else{
                        String path = "C:/temp/";
                        try(FileWriter writer = new FileWriter(path+data[0]+".txt", true)){
                            writer.write(String.join(" ", data));
                            writer.append('\n');
                        } catch(Exception ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                } else {
                    throw new NotEnoughData();
                }
            } else {
                throw new IncorrectAmountData();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static boolean isNumeric(String str)
    {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
