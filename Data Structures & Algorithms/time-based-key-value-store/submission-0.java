
class TimeMap {
    class pair{
        String value;
        int timestamp;

        public pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    HashMap<String, List<pair>> map = new HashMap<>();
    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<pair> list = map.get(key);
        if (list == null) {
            return "";
        }
        int start = 0;
        int end = list.size() - 1;
        String ans = "";
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
}
