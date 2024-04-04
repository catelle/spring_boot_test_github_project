package com.example.tptest1.controler;



import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.tptest1.model.greetings;
import com.example.tptest1.service.greetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

   @Autowired
    private greetingService great;

    @RequestMapping(method = RequestMethod.GET,value="/greeting/{id}")
    public greetings greeting(@PathVariable int id) {
        return great.getCars(id);
    }
    @RequestMapping(method = RequestMethod.GET,value="/greet")
    public List<greetings> getgreet(){
        return great.getGreet();
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/remove/{id}")
    public void removegreet(@PathVariable int id){
        great.deletegreeting(id);
    }
    @RequestMapping(method = RequestMethod.POST, value="/add")
    public void addgreet( @RequestBody greetings greet){
        great.addgreeting( greet);
    }
    @RequestMapping(method = RequestMethod.PUT, value="/put/{id}")
    public void update (@RequestBody greetings greet, @PathVariable int id){
        great.updategreeting(greet,id);
    }
}