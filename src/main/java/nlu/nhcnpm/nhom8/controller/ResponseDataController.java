package nlu.nhcnpm.nhom8.controller;


import nlu.nhcnpm.nhom8.model.dto.TheatreDto;
import nlu.nhcnpm.nhom8.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/responseData")
public class ResponseDataController {
    @Autowired
    TheatreService theatreService;
    @GetMapping("/theatres/{id}")
    public ResponseEntity<?> getTheatre(@PathVariable int id){
        List<TheatreDto> result = theatreService.getTheatreByCityId(id);
        return ResponseEntity.ok(result);
    }

}
