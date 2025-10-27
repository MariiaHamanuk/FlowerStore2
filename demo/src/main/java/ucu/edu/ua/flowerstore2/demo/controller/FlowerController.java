package ucu.edu.ua.flowerstore2.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucu.edu.ua.flowerstore2.demo.flower.Flower;
import ucu.edu.ua.flowerstore2.demo.flower.FlowerColor;
import ucu.edu.ua.flowerstore2.demo.flower.FlowerType;

@RestController
@RequestMapping("api/flowers")
public class FlowerController {
    @GetMapping
    public List<Flower> getFlowers() {
        return List.of(
            new Flower(98274,FlowerColor.BLUE, 1411.9, FlowerType.LILY)
        );
    } 
}
