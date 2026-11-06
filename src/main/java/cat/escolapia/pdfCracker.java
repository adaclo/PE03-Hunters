package cat.escolapia;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class pdfCracker {

    public static boolean comprovarPassword(String rutaPdf, String password) {
        File pdfFile = new File(rutaPdf);

        try (PDDocument document = Loader.loadPDF(pdfFile, password)) {
            // La pass és correcta
            return true;
        } catch (org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException e) {
            // Pass incorrecta
            return false;
        } catch (IOException e) {
            System.out.println("Error llegint el PDF: " + e.getMessage());
            return false;
        }
    }
}