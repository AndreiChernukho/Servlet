import entity.Car;

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
    public void create(Car car) {
        CAR_MAP.put(car.getId(), car);
    }

    @Override
    public void update(Car car) {
        CAR_MAP.put(car.getId(), car);
    }

    @Override
    public void delete(Long id) {
        CAR_MAP.remove(id);
    }
}
