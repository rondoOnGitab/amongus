package Classes;

import java.util.Map;
import java.util.HashMap;


public enum MyState {
    KILLED(createBehavior(true, false, false,false, false, false)),
    ALIVE(createBehavior(true, true, true,true, true, true)),
    HIDDEN(createBehavior(false, false, false,false, false, false));

    private final HashMap<String,Boolean> behavior;

    MyState(HashMap<String,Boolean> behavior)
    {
        this.behavior = behavior;
    }

    private static HashMap<String,Boolean> createBehavior(boolean task, boolean solid, boolean interactable,boolean vote, boolean report, boolean kill)
    {
        HashMap<String, Boolean> behavior = new HashMap<String,Boolean>();
        behavior.put("task",task);
        behavior.put("solid",solid);
        behavior.put("interactable",interactable);
        behavior.put("vote",vote);
        behavior.put("report",report);
        behavior.put("kill",kill);
        return behavior;
    }

    public Boolean getBehavior(String action) {
        return this.behavior.getOrDefault(action, false); // Restituisce false se l'azione non è definita
    }
}
