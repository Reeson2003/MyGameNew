package ru.reeson2003.model.characters.items;


import ru.reeson2003.model.characters.creatures.Parameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by reeson on 05.12.16.
 */
public class Equipment {
    public interface EquipmentListener {
        void putOnEvent();
        void putOffEvent();
    }
    private List<EquipmentListener> equipmentListeners;
    private Map<EquipType, Equip> equipment;
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

    public Equip putOn(Equip equip) {
        Equip result = equipment.put(equip.getEquipType(), equip);
        if (result != null)
            parameters = parameters.subtractParameters(result.getParameters());
        parameters = parameters.addParameters(equip.getParameters());
        notifyListenersPutOn();
        return result;
    }

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
