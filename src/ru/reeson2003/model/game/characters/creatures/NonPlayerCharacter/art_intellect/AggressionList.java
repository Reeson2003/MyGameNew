package ru.reeson2003.model.game.characters.creatures.NonPlayerCharacter.art_intellect;

import ru.reeson2003.model.game.characters.creatures.Creature;

import java.util.*;

/**
 * Created by nimtego_loc on 06.01.2017.
 */
public class AggressionList {
    private Map<Creature, Integer> aggressionMap;
    private Creature key;

    public AggressionList() {
        aggressionMap = new HashMap<>();
    }

    public Map<Creature, Integer> getAggressionMap() {
        return aggressionMap;
    }

    public void setAggressionMap(Map<Creature, Integer> aggressionMap) {
        this.aggressionMap = aggressionMap;
    }

    public void addAggressor(final Creature creature) {
        aggressionMap.put(creature, 0);
    }

    public void changeAggression(final Creature creature, final int amount) {
        if (!aggressionMap.containsKey(creature)) {
            aggressionMap.put(creature, amount);
        } else
            aggressionMap.put(creature, aggressionMap.get(creature) + amount);
    }

    public Creature getMostAggressor() {
        Map<Creature, Integer> map = sortMapByValue(aggressionMap);
        key = map.entrySet().iterator().next().getKey();
        return key;
    }

    public Creature getRandomAggressor() {
        Random random = new Random(new Date().getTime());
        int n = aggressionMap.size();
        int rnd = random.nextInt(n);
        Iterator<Map.Entry<Creature, Integer>> iterator = aggressionMap.entrySet().iterator();
        Creature result = null;
        for (int i = 0; i < rnd; i++) {
            result = iterator.next().getKey();
        }
        return result;
    }

    /**
     * Creates new {@code TreeMap} sorted by value
     * @param map {@code Map} to sort
     * @return {@code TreeMap} sorted by value
     */
    private TreeMap<Creature, Integer> sortMapByValue(Map<Creature, Integer> map) {
        Comparator<Creature> comparator = new ValueComparator(map);
        /*TreeMap is a map sorted by its keys.
        The comparator is used to sort the TreeMap by keys. */
        TreeMap<Creature, Integer> result = new TreeMap<>(comparator);
        result.putAll(map);
        return result;
    }

    /**
     * {@code ValueComparator} used to sort {@code HashMap} by value
     */
    private class ValueComparator implements Comparator<Creature> {
        /**
         * {@code Map} to sort
         */
        HashMap<Creature, Integer> map = new HashMap<>();

        /**
         * Creates new {@code ValueComparator}
         * @param map {@code Map} to sort
         */
        public ValueComparator(Map<Creature, Integer> map) {
            this.map.putAll(map);
        }

        /**
         * Gets values by argument keys and compares them
         * @param o1 {@code Creature}
         * @param o2 {@code Creature}
         * @return {@code int} value of subtraction value of {@code o2} key
         * from value of {@code o1} key
         */
        @Override
        public int compare(Creature o1, Creature o2) {
            return map.get(o1) - map.get(o2);
        }
    }
}
