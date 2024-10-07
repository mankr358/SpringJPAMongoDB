package com.journalapp.journalApp.Controller;

import com.journalapp.journalApp.Entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntityController {

    private Map<Long, JournalEntity> journalEntities = new HashMap<>();

    @GetMapping
    //methods inside a controller class invoked be public so that
    //they can be accessed and invoked by SBF or external http requests niche ka public
    public List<JournalEntity> getAll(){
return  new ArrayList<>(journalEntities.values());
    }
    @PostMapping
    //resourse create krna h woh postman me body me hoga as JSON format me
    //@ResquestBody -> Hey Spring take my data from request and turn it into java
    //object that i can used in my code. Jornal Entry ka instance ban jayega
    public boolean createEntry(@RequestBody JournalEntity myEntry){
journalEntities.put(myEntry.getId(),myEntry);
return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntity getJournalEntryById(@PathVariable Long myId){
       return journalEntities.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntity deleteJournalEntryById(@PathVariable Long myId){
        return journalEntities.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntity updateJournalById(@PathVariable Long id,@RequestBody JournalEntity myEntry){
        return journalEntities.put(id,myEntry);
    }
}
