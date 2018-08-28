/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AlbumSlicice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AlbumSlicice.dao.KorisnikRepository;
import rs.ac.bg.fon.silab.AlbumSlicice.dto.KorisnikDTO;
import rs.ac.bg.fon.silab.AlbumSlicice.entities.Korisnik;
import rs.ac.bg.fon.silab.AlbumSlicice.mapper.GenericMapper;

/**
 *
 * @author ComTech
 */

@Service
public class KorisnikService {
    
    @Autowired
    KorisnikRepository korisnikDao;
    
    @Autowired
    GenericMapper mapper;
    
    public KorisnikDTO login(String email){
        KorisnikDTO korisnikDto = mapper.korisnikToKorisnikDTO(korisnikDao.login(email));
        return korisnikDto;
    }
    
    public String authenticate(KorisnikDTO korDTO) throws Exception{
        Korisnik user = korisnikDao.login(korDTO.getEmail());
        if (user == null) {
            throw new Exception("Unknown user.");
        }
//        String token = userDB.getKorisnickoIme();
//        return new String(Base64.encodeBase64(token.getBytes()));
        return user.getEmail();
    }
    
    public KorisnikDTO registracija(KorisnikDTO korisnik){
        Korisnik koris = mapper.korisnikDTOtoKorisnik(korisnik);
        return mapper.korisnikToKorisnikDTO(korisnikDao.save(koris));
    }
    
}
