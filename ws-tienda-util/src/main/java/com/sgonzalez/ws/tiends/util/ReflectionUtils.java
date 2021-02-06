/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ws.tiends.util;

import java.lang.reflect.Field;

/**
 *
 * @author sam
 */
public class ReflectionUtils {
    public static Field obtenerCampoAnotado(Class o, Class claseAnotacion) {
        Field fieldSeleccionado = null;
        for (Field field : o.getDeclaredFields()) {
            field.setAccessible(true); // You might want to set modifier to public first.
            if (field.isAnnotationPresent(claseAnotacion)) {
                fieldSeleccionado = field;
                break;
            }

        }
        return fieldSeleccionado;
    }
}
