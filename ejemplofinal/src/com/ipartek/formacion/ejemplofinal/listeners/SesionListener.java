package com.ipartek.formacion.ejemplofinal.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.ejemplofinal.entidades.Carrito;

/**
 * Representa la creación de un nuevo carrito vacío para asignarlo a un nuevo usuario al iniciar sesión
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@WebListener
public class SesionListener implements HttpSessionListener{
	
	/**
	 * Creación de la nueva sesión y asignación del carrito
	 * @param se	evento
	 */
	@Override
    public void sessionCreated(HttpSessionEvent se)  { 
    	Carrito carrito = new Carrito();
    	se.getSession().setAttribute("carrito", carrito);
    }

	/**
	 * Fin de la sesión iniciada
	 * @param se	evento
	 */
    @Override
	public void sessionDestroyed(HttpSessionEvent se)  { 
    	// No es necesario
    }
}
