import java.util.*;
import java.util.stream.Collectors;

 class Main {

    public static void main(String[] args) {

        int[] arr = {2, 8, 4, 3, 2};
        Main solution1 = new Main();
        System.out.println("Max waiting time " + solution1.solution(arr,10,14,6));     
        //(arr, 2,8,1) for -1 
        //(arr, 7,11, 3) for 8
        //(arr, 10,14,6) for 4
    }
    public int solution(int[] arr, int x, int y, int z) {
        GasStationG gasStation = new GasStationG();
        gasStation.addPumpsWithCap(x,y,z);
        
        List<Car> resolvedCars = new ArrayList<>();
        List<Car> carStack = new ArrayList<>();
        
		for(int c : arr) carStack.add(new Car(c,0));
        
        Pump freePump = null;
        int index = 0;
        boolean deadlock = false;
        
        while(index < carStack.size() ) {
            System.out.println(index);
            // if more cars waiting but none of the pump has capacity
            if (!gasStation.pumpHasCapacity(carStack.get(index).fuelNeed)) {
                    deadlock = true;
                    break;              
                }
                       
            freePump = gasStation.getFreePump(carStack.get(index).fuelNeed);
            System.out.println("fuelneed :"+carStack.get(index).fuelNeed);
        

            if (null != freePump) {
                freePump.car = carStack.get(index);
                freePump.car.pumpId = freePump.pumpId;
                System.out.println("freepump :" +freePump.pumpId);
            } else {

                Integer minFuelNeed = gasStation.getMinimumFuelNeed();
                //System.out.println("filledCars"+minFuelNeed);
                List<Car> filledCars = gasStation.resolveFilledCars(minFuelNeed);
                for (int counter = index; counter< carStack.size(); counter++) {
                    carStack.get(counter).waitTime += minFuelNeed;
                }
                
                index --;
                resolvedCars.addAll(filledCars);
            }
            index++;
        }
        
        if (deadlock == false){
        IntSummaryStatistics max = carStack.stream().map(car ->
                car.waitTime).mapToInt(Integer::intValue).summaryStatistics();

        return max.getMax();
        }
        else return -1;

    }
}


class Car {
    Integer fuelNeed;
    Integer waitTime;
    Integer pumpId;

    public Car(int fuelNeed, int waitTime) {
        this.fuelNeed = fuelNeed;
        this.waitTime = waitTime;
        pumpId = -1;
    }
}


class Pump {
    Integer pumpId;
    Integer fuelCapacity;
    Car car;
    public Pump(int id, int fuelCapacity, Car car) {
        this.pumpId = id;
        this.fuelCapacity = fuelCapacity;
        car = car;
    }
}


class GasStationG{
    public List<Pump> pumpList = new ArrayList<>();

    public GasStationG(){ }

    public void addPumpsWithCap(int x, int y, int z) {
        pumpList.add(new Pump(1,x,null));
        pumpList.add(new Pump(2,y,null));
        pumpList.add(new Pump(3,z,null));

    }

    public Boolean pumpHasCapacity(Integer fuelNeeded) {
        for(Pump pump: pumpList) {
            if (pump.fuelCapacity >= fuelNeeded) {
                return true;
            }
        }
        return false;
    }

    public Pump getFreePump(Integer fuelRequired){
        for(Pump pump: pumpList) {
            if (pump.fuelCapacity >= fuelRequired && null == pump.car) {
                return pump;
            }
        }
        return null;
    }

    public List<Car> resolveFilledCars(Integer minFuelNeed) {
        List<Car> carsFueled = new ArrayList<>();

        for(Pump pump: pumpList) {
            if (null != pump.car) {
                pump.car.fuelNeed -= minFuelNeed;
                pump.fuelCapacity -= minFuelNeed;
                if (pump.car.fuelNeed <=0){
                    carsFueled.add(pump.car);
                    pump.car = null;
                }
            }
        }

        return carsFueled;

    }

    public Integer getMinimumFuelNeed() {
        IntSummaryStatistics summaryStatistics = pumpList.stream()
                .filter(pump -> null != pump.car).map(pump -> pump.car.fuelNeed)
                .mapToInt(Integer::intValue).summaryStatistics();
                
        return summaryStatistics.getMin();
    }
}
