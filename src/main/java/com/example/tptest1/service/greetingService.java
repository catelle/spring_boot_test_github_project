package com.example.tptest1.service;

import com.example.tptest1.model.greetings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class greetingService {
    static private ArrayList<greetings> great= new ArrayList<greetings>(Arrays.asList(

            new greetings(23,"stream"),
            new greetings(24,"stream"),
            new greetings(25,"stream")

    ));
    public List<greetings> getGreet(){
        return great;
    }

      public greetings getCars(int i){
          return great.stream().filter(greetings -> greetings.getId() == i).findFirst().orElse(null);
      }
      public void deletegreeting(int id){
        great.removeIf(greetings -> greetings.getId() == id);
      }
      public void addgreeting(greetings greet){
        great.add(greet);
      }
      public void updategreeting(greetings greet, int id){
        great.forEach(greetings1 ->{
            if(greetings1.getId() == id){
                great.set(great.indexOf(greetings1),greet);
            }
        } );
      }
}
