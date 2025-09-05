package com.galaxy.bakendapirest.controller;

import com.galaxy.bakendapirest.controller.dto.PictureItem;
import com.galaxy.bakendapirest.service.PictureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/picture")
@RequiredArgsConstructor
public class PicturesController {

    // @Autowired: problemas con el testing, es mejor utilizar contruccion
    private final PictureService pictureService;

    @GetMapping
    public ResponseEntity<List<PictureItem>> list() {
        List<PictureItem> pictureItem = pictureService.list();
        return ResponseEntity.ok(pictureItem);
    }

    @PostMapping
    public ResponseEntity<Void> create (@RequestBody @Valid PictureItem item) {
        pictureService.create(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@PathVariable("id") Integer id, @RequestBody @Valid PictureItem item){ //@ Valid -> sirve para validar con la implemmetciones HTTP personalizadas
        pictureService.update(id, item);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        pictureService.delete(id);
        return ResponseEntity.ok().build();
    }
}
