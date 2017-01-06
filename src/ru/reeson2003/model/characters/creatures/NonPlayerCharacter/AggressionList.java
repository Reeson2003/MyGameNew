package ru.reeson2003.model.characters.creatures.NonPlayerCharacter;

import ru.reeson2003.model.service.Address;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nimtego_loc on 06.01.2017.
 */
public class AggressionList {

    private Map<Address, Integer> aggressionMap;

    public AggressionList() {
        aggressionMap = new HashMap<>();
    }
    public Map<Address, Integer> getAggressionMap() {
        return aggressionMap;
    }
    public void setAggressionMap(Map<Address, Integer> aggressionMap) {
        this.aggressionMap = aggressionMap;
    }
    public void setAggressor(final Address address) {
        aggressionMap.put(address, 0);
    }
    public void increasyAggression(final Address address, final int amount) {
        if (!aggressionMap.containsKey(address)) {
            aggressionMap.put(address, amount);
        }
        else
            aggressionMap.put(address, aggressionMap.get(address) + amount);
    }
}
