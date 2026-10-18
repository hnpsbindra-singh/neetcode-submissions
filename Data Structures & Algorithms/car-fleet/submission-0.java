
class Solution {
    class car{
        int position;
        int speed;
        public car(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new car(position[i], speed[i]));
        }
        Collections.sort(cars, (a, b)-> b.position-a.position);
        double maxTime = 0;
        int fleet = 0;
        for (int i = 0; i < cars.size(); i++) {
            double time = (target - cars.get(i).position)/(double)cars.get(i).speed;
            if (time>maxTime){
                maxTime = time;
                fleet++;
            }
        }
        return fleet;
    }
}