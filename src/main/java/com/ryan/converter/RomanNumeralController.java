package com.ryan.converter;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralController implements ErrorController {

    /**
     * Converts number to Roman Numeral
     *
     * @param number The integer of the roman numeral.
     * @return HTTP status: OK(roman numeral), Err(...)
     */
    @RequestMapping("/romannumeral")
    public ResponseEntity toRomanNumeral(@RequestParam(value="query") int number) {
        try {
            return ResponseEntity.ok(new RomanNumeralConverter().toRoman(number));
        } catch (IllegalArgumentException x) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.toString());
        }
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ResponseEntity error() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST -> incorrect type -> expected int");
    }
}
