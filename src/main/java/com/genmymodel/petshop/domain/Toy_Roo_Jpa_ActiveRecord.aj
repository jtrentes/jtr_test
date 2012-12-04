// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.genmymodel.petshop.domain;

import com.genmymodel.petshop.domain.Toy;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Toy_Roo_Jpa_ActiveRecord {
    
    public static long Toy.countToys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Toy o", Long.class).getSingleResult();
    }
    
    public static List<Toy> Toy.findAllToys() {
        return entityManager().createQuery("SELECT o FROM Toy o", Toy.class).getResultList();
    }
    
    public static Toy Toy.findToy(Long id) {
        if (id == null) return null;
        return entityManager().find(Toy.class, id);
    }
    
    public static List<Toy> Toy.findToyEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Toy o", Toy.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public Toy Toy.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Toy merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
