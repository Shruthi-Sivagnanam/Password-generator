package PasswordGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Password {
    String uppercase;
    String lowercase;
    String numbers;
    String specialCharacters;
    Random rand;
    public Password(){
        uppercase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowercase="abcdefghijklmnopqrstuvwxyz";
        numbers="1234567890";
        specialCharacters=".,@!#$%^&*()_-+:;";
        rand = new Random();
    }
    public String generate(int lowerlen,int upperlen,int speciallen,int numberlen){
        String password="";
        ArrayList<String> passwordsList=new ArrayList<>();
        int num;
        for(int i=0;i<lowerlen;i++){
            num=rand.nextInt(lowercase.length());
            passwordsList.add(lowercase.charAt(num)+"");
        }
        for(int i=0;i<upperlen;i++){
            num=rand.nextInt(uppercase.length());
            passwordsList.add(uppercase.charAt(num)+"");
        }
        for(int i=0;i<numberlen;i++){
            num=rand.nextInt(numbers.length());
            passwordsList.add(numbers.charAt(num)+"");
        }
        for(int i=0;i<speciallen;i++){
            num=rand.nextInt(specialCharacters.length());
            passwordsList.add(specialCharacters.charAt(num)+"");
        }
        Collections.shuffle(passwordsList);
        password="";
        for(String pass : passwordsList)
            password=password+pass;
        return password;
    }
}
