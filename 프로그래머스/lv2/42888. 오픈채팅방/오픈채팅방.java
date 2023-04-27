import java.util.*;
import java.util.Map.*;

class Solution {
    
    static String DEFAULT_INCOME  = "님이 들어왔습니다.";
    static String DEFAULT_LEAVE = "님이 나갔습니다.";
    
    static class Command{
        int idx;
        String name;
        String type;
        
        public Command(int idx, String type){
            this.idx = idx;
            this.type = type;
        }
        
        public void setName(String name){
            this.name = name;
        }
        
        public String getFullCommand(){
            if(type.equals("Enter")) return this.name+DEFAULT_INCOME;
            else if(type.equals("Leave")) return this.name+DEFAULT_LEAVE;
            
            return null;
        }
        
        @Override
        public String toString(){
            return this.idx+"  "+type+"  "+this.name+"   "+this.getFullCommand();
        }
        
        
    }
    static class User{
        String id;
        String alias;
        List<Command> commnads;
        
        public User(String id, String alias){
            this.id = id;
            this.alias = alias;
            this.commnads= new LinkedList<>();
        }
        
        public List<Command> getCmds(){
            
            for(Command c : this.commnads){
                c.setName(this.alias);
            }
            return this.commnads;
            
        }
        public void changeName(String changeName){
            this.alias = changeName;
        }
        
        public void addCommand(Command cmd){
            this.commnads.add(cmd);
        }
    }
    
    
    Map<String, User> log;
    
    public List<String> solution(String[] records) {
        
        log = new HashMap<>();
        
        for(int i=0; i<records.length; i++){
           
            String record = records[i]; 
            
            String[] commands = record.split(" ");
            
            String action = commands[0];
            
            Command cmd = new Command(i,action);

            if(action.equals("Enter")){
                
                String userId = commands[1];
                String alias = commands[2];
                
                
                if(!log.containsKey(userId)){
                  
                    User newUser = new User(userId,alias);
                    newUser.addCommand(cmd);

                    log.put(userId, newUser);
                }else{
                    
                    User user = log.get(userId);
                    
                    if(!user.alias.equals(alias)){
                        user.changeName(alias);
                    }
                    
                    user.addCommand(cmd);
                }
                
            }else if(action.equals("Leave")){
                
                String userId = commands[1];
                User leftUser = log.get(userId);
                
                leftUser.addCommand(cmd);
                
                
            }else if(action.equals("Change")){
                
                String userId = commands[1];
                String changeName = commands[2];
                
                User changeUser = log.get(userId);
                changeUser.addCommand(cmd);
                changeUser.changeName(changeName);
                
            }
        }
        
        List<Command> list = new ArrayList<>();
        
        for (Entry<String, User> entrySet : log.entrySet()) {
            
            User user = entrySet.getValue();
            List<Command> lists = user.getCmds();
            
            list.addAll(lists);
            
        }
        
        list.sort((t1,t2)->Integer.compare(t1.idx,t2.idx));
        
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<list.size(); i++){
            Command c = list.get(i);
            if(c.type.equals("Change")) continue;
            result.add(c.getFullCommand());
        }
        
    
        return result;
    }
}