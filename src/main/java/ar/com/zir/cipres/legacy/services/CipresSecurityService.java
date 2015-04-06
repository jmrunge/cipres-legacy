/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.zir.cipres.legacy.services;

import ar.com.zir.cipres.legacy.api.security.Usuario;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jmrunge
 */
@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CipresSecurityService {
    @PersistenceContext(unitName = "cipresLegacyPU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Usuario getCipresAdminUser() {
        return em.find(Usuario.class, new Short("1"));
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Usuario> getUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Usuario getUsuarioById(Short id) {
        return em.find(Usuario.class, id);
    }
    
}
