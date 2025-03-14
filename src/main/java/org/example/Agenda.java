package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Creamos una agenda de contactos donde se pueden agregar, eliminar y modificar números de teléfono.
 * @author Alejandro Bermúdez
 * @version 1.0
 * @since   14/03/25
 */
public class Agenda {

    /** lista de contactos */
    private List<Persona> contacts;

    /**
     * Creamos agenda nueva
     */
    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Agregamos un nuevo contacto a la agenda. Si el contacto ya existe, añadimos un nuevo número de teléfono a la lista
     *
     * @param name  Nombre del contacto.
     * @param phone Número de teléfono a agregar.
     */
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Persona newContact = new Persona(name, phone);
            contacts.add(newContact);
        }
    }

    /**
     * Eliminamos un contacto de la agenda
     *
     * @param name Nombre del contacto que eleminimamos
     */
    public void removeContact(String name) {
        Iterator<Persona> it = contacts.iterator();

        while (it.hasNext()) {
            Persona c = it.next();

            if (c.getName().equalsIgnoreCase(name)) {
                it.remove();
            }
        }
    }

    /**
     * Modificamos el número de teléfono de un contacto de la lista
     *
     * @param name     Nombre del contacto
     * @param oldPhone Número de teléfono antiguo
     * @param newPhone Nuevo número de teléfono nuevo
     */
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                List<String> phones = c.getPhones();

                int index = phones.indexOf(oldPhone);

                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

    /**
     * Obtenemos la lista de contactos de la Agenda
     *
     * @return Lista de contactos
     */
    public List<Persona> getContacts() {
        return this.contacts;
    }
}