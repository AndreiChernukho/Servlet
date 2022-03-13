import entity.Car;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarServiceImpl implements CarService {
    private static final Map<Long, Car> CAR_MAP = new HashMap<>();

    @Override
    public List<Car> getAll() {
        return new ArrayList<>(CAR_MAP.values());
    }

    @Override
    public Car get(int id) {
        return CAR_MAP.get(id);
    }

    @Override
    public void create(Long id, String carModel) {
        Car car = new Car(id, carModel, LocalDateTime.now());
        CAR_MAP.put(id, car);
    }

    @Override
    public void update(Long id, String carModel) {
        Car car = new Car(id, carModel, LocalDateTime.now());
        CAR_MAP.put(id, car);
    }

    @Override
    public void delete(Long id) {
        CAR_MAP.remove(id);
    }
}
