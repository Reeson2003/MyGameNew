package ru.reeson2003.model.game.characters.creatures;


import ru.reeson2003.model.game.characters.items.Equip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Equipment class contains interface for put on and put off
 * notification.
 */
public class Equipment {
    public interface EquipmentListener {
        void putOnEvent();
        void putOffEvent();
    }

    /**
     * Listeners of put on and put off events.
     */
    private List<EquipmentListener> equipmentListeners;
    /**
     * Equip container. Contains an unique type of equip.
     */
    private Map<EquipType, Equip> equipment;
    /**
     * total parameters of equipment.
     */
    private Parameters parameters;

    public Equipment() {
        parameters = new Parameters.ParametersBuilder().build();
        equipment = new HashMap<>();
        equipmentListeners = new ArrayList<>();
    }

    public void addListener(EquipmentListener listener) {
        if (!equipmentListeners.contains(listener))
            equipmentListeners.add(listener);
    }

    public void removeListener(EquipmentListener e) {
        if (equipmentListeners.contains(e))
            equipmentListeners.remove(e);
    }

    private void notifyListenersPutOn() {
        for (EquipmentListener e : equipmentListeners)
            e.putOnEvent();
    }

    private void notifyListenersPutOff() {
        for (EquipmentListener e : equipmentListeners) {
            e.putOffEvent();
        }
    }

    /**
     * Put on method.
     * Puts the Equip in the container and change total parameters.
     * Notify listeners of put on event.
     * @param equip
     * @return current Equip if exists or null if not exists.
     */
    public Equip putOn(Equip equip) {
        Equip result = equipment.put(equip.getEquipType(), equip);
        if (result != null)
            parameters = parameters.subtractParameters(result.getParameters());
        parameters = parameters.addParameters(equip.getParameters());
        notifyListenersPutOn();
        return result;
    }

    /**
     * Put off method.
     * Remove the Equip from container and change total parameters.
     * Notify listeners of put off event.
     * @param equipType the type of equip to put off.
     * @return current Equip if exists or null if not exists.
     */
    public Equip putOff(EquipType equipType) {
        Equip result = equipment.remove(equipType);
        if (result != null)
            parameters = parameters.subtractParameters(result.getParameters());
        notifyListenersPutOff();
        return result;
    }

    public Parameters getParameters() {
        return parameters;
    }

}
