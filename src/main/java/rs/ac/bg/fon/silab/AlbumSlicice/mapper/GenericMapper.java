/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AlbumSlicice.mapper;

import rs.ac.bg.fon.silab.AlbumSlicice.dto.KorisnikDTO;
import rs.ac.bg.fon.silab.AlbumSlicice.entities.Korisnik;
import org.mapstruct.Mapper;
/**
 *
 * @author ComTech
 */
@Mapper(componentModel = "spring")
public interface GenericMapper {
    
    public Korisnik korisnikDTOtoKorisnik(KorisnikDTO korisnikDto);
    public KorisnikDTO korisnikToKorisnikDTO(Korisnik korisnik);
    
}
