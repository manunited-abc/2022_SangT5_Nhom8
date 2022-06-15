package nlu.nhcnpm.nhom8.test;

import nlu.nhcnpm.nhom8.entity.City;
import nlu.nhcnpm.nhom8.entity.Theatre;
import nlu.nhcnpm.nhom8.repository.CityRepository;
import nlu.nhcnpm.nhom8.repository.TheatreRepository;
import nlu.nhcnpm.nhom8.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUnit {
    @Autowired
    static TheatreRepository theatreRepository;
    @Autowired
    static CityRepository cityRepository;
    public static void main(String[] args) {

    }
}
