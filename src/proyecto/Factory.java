package proyecto;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;


public class Factory {
    private static Factory instance;
    private HashMap<String,Command> cache;
    public Factory(){
        cache=new HashMap<String,Command>();
    }
    public static Factory getInstance(){
        if (instance==null) instance=new Factory();
        return instance;
    }
    public Command getCommand (String cmd) throws Exception {
        Command c= cache.get(cmd);

        if(c==null){
            Class cl=Class.forName("proyecto."+cmd);
            c= (Command) cl.newInstance();
            cache.put(cmd,c);
        }
        return c;
    }
}
