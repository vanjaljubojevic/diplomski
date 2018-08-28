/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AlbumSlicice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AlbumSlicice.dto.KorisnikDTO;
import rs.ac.bg.fon.silab.AlbumSlicice.service.KorisnikService;

/**
 *
 * @author ComTech
 */
@RestController

public class KorisnikRestController {
    
    @Autowired
    KorisnikService korisnikService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody
    Object login(@RequestBody KorisnikDTO korisnik){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(korisnikService.authenticate(korisnik));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown user.");
        }
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object register(@RequestBody KorisnikDTO korisnik){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(korisnikService.registracija(korisnik));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Greska.");
        }
    }
    
}
