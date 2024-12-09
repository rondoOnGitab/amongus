package Classes;

import java.util.HashMap;
import java.util.Map;

public enum MyState {
    KILLED,   // Stato del personaggio quando è morto (fantasma)
    ALIVE,    // Stato del personaggio quando è vivo
    HIDDEN;   // Stato del personaggio quando è nascosto (per esempio in una botola)

    private final Map<String, Boolean> behavior;

    // Costruttore per ogni stato
    MyState() {
        this.behavior = new HashMap<>();
        initializeBehavior();
    }

    // Metodo per inizializzare i comportamenti
    private void initializeBehavior() {
        switch (this) {
            case ALIVE:
                behavior.put("task", true); // Può fare task
                behavior.put("solid", true); // Può interagire con oggetti fisici
                behavior.put("interactable", true); // Può interagire con altri giocatori
                behavior.put("spy", false); // Non può osservare invisibilmente (è visibile)
                behavior.put("vote", true); // Può votare
                behavior.put("report", true); // Può segnalare corpi
                behavior.put("kill", true); // Può uccidere
                break;

            case KILLED:
                behavior.put("task", false); // Non può fare task (è morto)
                behavior.put("solid", false); // Non può interagire con oggetti fisici
                behavior.put("interactable", false); // Non può interagire direttamente con altri giocatori
                behavior.put("spy", true); // Può osservare (come se fosse un fantasma)
                behavior.put("vote", false); // Non può votare (è morto, non più attivo)
                behavior.put("report", false); // Non può segnalare (è morto)
                behavior.put("kill", false); // Non può uccidere (è morto)
                break;

            case HIDDEN:
                behavior.put("task", false); // Non può fare task (è nascosto)
                behavior.put("solid", false); // Non può interagire con oggetti fisici
                behavior.put("interactable", false); // Non può interagire con altri giocatori direttamente
                behavior.put("spy", true); // Può osservare (come se fosse un fantasma)
                behavior.put("vote", false); // Non può votare (è nascosto, fuori dalla scena)
                behavior.put("report", false); // Non può segnalare (è nascosto)
                behavior.put("kill", false); // Non può uccidere (è nascosto)
                break;

            default:
                throw new IllegalStateException("ERR: Stato non disponibile: " + this);
        }
    }

    // Ottieni un comportamento per una specifica azione
    public Boolean getBehavior(String action) {
        return behavior.getOrDefault(action, false); // Restituisce false se l'azione non è definita
    }
}
