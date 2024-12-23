package Classes;

import java.util.HashMap;
import java.util.Map;

public enum MyState {
    KILLED,   // Stato del personaggio quando è morto 
    ALIVE,    // Stato del personaggio quando è vivo
    HIDDEN;   // Stato del personaggio quando è nascosto (per esempio in una botola)
    //KICKED;   //Ipotetico 4 stato per l'impostore perchè il this.behavior task è true da killed

    private final Map<String, Boolean> behavior;

    MyState() {
        this.behavior = new HashMap<>();
        initializeBehavior();
    }

    // Metodo per inizializzare i comportamenti
    private void initializeBehavior() {
        switch (this) {
            case ALIVE:
                this.behavior.put("task", true); // Può fare task
                this.behavior.put("solid", true); // Può interagire con oggetti fisici
                this.behavior.put("interactable", true); // Può interagire con altri giocatori
                this.behavior.put("spy", false); // Non può osservare invisibilmente (è visibile)
                this.behavior.put("vote", true); // Può votare
                this.behavior.put("report", true); // Può segnalare corpi
                this.behavior.put("kill", true); // Può uccidere
                break;

            case KILLED:
                this.behavior.put("task", true); //Può fare le task da morto
                this.behavior.put("solid", false); // Non può interagire con oggetti fisici
                this.behavior.put("interactable", false); // Non può interagire direttamente con altri giocatori
                this.behavior.put("spy", true); // Può osservare (come se fosse un fantasma)
                this.behavior.put("vote", false); // Non può votare (è morto, non più attivo)
                this.behavior.put("report", false); // Non può segnalare (è morto)
                this.behavior.put("kill", false); // Non può uccidere (è morto)
                break;

            case HIDDEN:
                this.behavior.put("task", false); // Non può fare task (è nascosto)
                this.behavior.put("solid", false); // Non può interagire con oggetti fisici
                this.behavior.put("interactable", false); // Non può interagire con altri giocatori direttamente
                this.behavior.put("spy", true); // Può osservare (come se fosse un fantasma)
                this.behavior.put("vote", false); //Può votare (se il cadavere è segnalato quando lui è in botola)
                this.behavior.put("report", false); // Non può segnalare (è nascosto)
                this.behavior.put("kill", false); // Non può uccidere (è nascosto)
                break;

            default:
                throw new IllegalStateException("ERR: Stato non disponibile: " + this);
        }
    }

    // Ottieni un comportamento per una specifica azione
    public Boolean getBehavior(String action) {
        return this.behavior.getOrDefault(action, false); // Restituisce false se l'azione non è definita
    }
}
