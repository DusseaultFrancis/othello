/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sauvegarde;

import Domaine.Partie;
import Domaine.PartieIA;
import Domaine.Table;
import static Sauvegarde.XMLWriter.ecritureFichier;
import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class XMLReader {

    public static String[] lireFichiersRepertoire() {

        String[] dir = new java.io.File(".").list();

        return dir;
    }

    public static PartieIA lireFichierXML(String nom) throws IOException {

        String chaine = "";
        PartieIA partieIA = null;

        try {
            InputStream ips = new FileInputStream(nom);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            while ((ligne = br.readLine()) != null) {
                chaine += ligne + "\n";
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        partieIA = conversionXMLStringToPartie(chaine);
        return partieIA;

    }

    public static PartieIA conversionXMLStringToPartie(String xml) throws IOException {

        XStream xStream = new XStream();
        xStream.processAnnotations(PartieIA.class);
        PartieIA partieIA = (PartieIA) xStream.fromXML(xml);

        return partieIA;
    }

}
