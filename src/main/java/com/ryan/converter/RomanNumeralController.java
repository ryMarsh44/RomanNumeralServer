package com.ryan.converter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralController {

    @RequestMapping("/romannumeral")
    public String toRomanNumeral(@RequestParam(value="query") int number) {
        return new RomanNumeralConverter().toRoman(number);
    }
}
