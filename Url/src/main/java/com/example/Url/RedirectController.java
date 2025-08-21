package com.example.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RedirectController {

    @Autowired
    private ShortService shortService;

    @GetMapping("{codigo}")
    public ResponseEntity<?> redirecionar(@PathVariable String codigo) {
        String originalUrl = shortService.rescue(codigo);
        if (originalUrl != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", originalUrl);
            return new ResponseEntity<>(headers, HttpStatus.FOUND); // 302 redirect
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Código inválido ou expirado!");
        }
    }
}