package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.service.PorudzbinaService;

@RestController
public class PorudzbinaRestController {


    @Autowired
    private PorudzbinaService porudzbinaService;
}
