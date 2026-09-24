
class RandomizedSet {

    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    public RandomizedSet() {}

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx = map.get(val);
        list.set(idx, list.get(list.size()-1));
        map.put(list.get(idx), idx);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

