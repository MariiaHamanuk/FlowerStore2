package ucu.edu.flowerstore2.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucu.edu.flowerstore2.flower.Flower;
import ucu.edu.flowerstore2.flower.FlowerColor;
import ucu.edu.flowerstore2.flower.FlowerType;

@RestController
@RequestMapping("api/flowers")
public class FlowerController {
    @GetMapping
    public List<Flower> getFlowers() {
        return List.of(
            new Flower(98274.5, FlowerColor.BLUE, 1411.9, FlowerType.LILY)
        );
    } 
}
