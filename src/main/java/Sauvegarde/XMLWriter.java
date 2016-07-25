/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sauvegarde;

import Domaine.Partie;
import Domaine.PartieIA;
import Domaine.Table;
import com.thoughtworks.xstream.XStream;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class XMLWriter {

    public static void conversionStringXML(Partie partie, String fichier) throws IOException {

        XStream xstream = new XStream();
        String xml = xstream.toXML(partie);

        ecritureFichier(xml, fichier);
    }

    public static void ecritureFichier(String xml, String fichier) throws IOException {

        java.io.FileWriter fw = new java.io.FileWriter(fichier + ".xml");
        fw.write(xml);
        fw.close();
    }

}
