package com.example.Url;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.Map;

@RestController
@RequestMapping("/api/url")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private ShortService shortService;


    @PostMapping("/encurtar")
    public ResponseEntity<Map<String, String>> encurtar(@RequestParam String url) {
        String code = shortService.encurtar(url, null);
        if (code == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "URL inválida"));
        }
        return ResponseEntity.ok(Map.of("code", code));
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<?> redirecionar(@PathVariable String codigo) {
        String originalUrl = shortService.rescue(codigo);
        if (originalUrl != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", originalUrl);
            return new ResponseEntity<>(headers, HttpStatus.FOUND); // 302
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Código inválido ou expirado!");
        }
    }
}
