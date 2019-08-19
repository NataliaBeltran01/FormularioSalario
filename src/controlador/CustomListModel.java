/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.*;
import java.util.*;
/**
 * Clase CustomListModel desde donde se manipulan las listas con los nombres de las personas
 * @author Natalia Beltran
 * @version 1.0
 */
public class CustomListModel<E> extends AbstractListModel<E> {
    protected List<E> list;
 
    public CustomListModel(List<E> list) {
        this.list = list;
    }
 /**
 * Los siguientes metodos es en donde se añaden, enlistan y organizan 
 * los nombres contenidos en la lista
 * @since version 1.0
 */
    public void addElement(E element) {
        list.add(element);
        int index = list.size();
        fireContentsChanged(element, index, index);
    }
 
    public void fireDataChanged() {
        int index = list.size();
        fireContentsChanged(list.get(index - 1), index, index);
    }
 
    @Override
    public int getSize() {
        return list.size();
    }
 
    @Override
    public E getElementAt(int index) {
        return list.get(index);
    }
}