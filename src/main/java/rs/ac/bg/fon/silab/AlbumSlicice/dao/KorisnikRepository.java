/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AlbumSlicice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.AlbumSlicice.entities.Korisnik;

/**
 *
 * @author ComTech
 */
@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
    
    @Query("SELECT k FROM Korisnik k WHERE k.email = ?1")
    public Korisnik login(String email);
    
    
}
