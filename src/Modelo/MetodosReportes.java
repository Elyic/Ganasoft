/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author Andy
 */
public class MetodosReportes {
 
    public String Datos, ID;
    
    public void crearQR(String Datos) throws IOException{
    ByteArrayOutputStream out=QRCode.from(Datos).to(ImageType.PNG).stream();
    try(OutputStream output = new FileOutputStream("qr.png")) {
        out.writeTo(output);
            }catch (FileNotFoundException ex) {
            Logger.getLogger(MetodosReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearPDF() throws DocumentException{
    
        FileOutputStream elpdf= null;
        try {
            Document documento= new Document();
            elpdf = new FileOutputStream("QR-"+ID+".pdf");
            PdfWriter.getInstance(documento, elpdf);
            documento.open();
            Paragraph p1 = new Paragraph();
            Font fonT= new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
            p1.add(new Phrase("QR de registro "+ID+": ",fonT));
            p1.setAlignment(Element.ALIGN_CENTER);
            p1.add(new Phrase(Chunk.NEWLINE));
            p1.add(new Phrase(Chunk.NEWLINE));
            documento.add(p1);
            
            PdfPTable table = new PdfPTable(2);
//            table.setWidthPercentage(50);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.setWidths(new int[]{4, 4});
            table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            Paragraph p2 = new Paragraph();
            p2 = new Paragraph(Datos);
            p2.add(new Phrase(Chunk.NEWLINE));
            p2.add(new Phrase(Chunk.NEWLINE));
            p2.add(new Phrase(Chunk.NEWLINE));
            p2.add(new Phrase(Chunk.NEWLINE));
            table.addCell(p2);
            Image QR = Image.getInstance("qr.png");
//            QR.scaleAbsolute(200, 200);
            table.addCell(QR);
            documento.add(table);
               
            documento.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MetodosReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(MetodosReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MetodosReportes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                elpdf.close();
            } catch (IOException ex) {
                Logger.getLogger(MetodosReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
}

public void mostrarPDF(String ID){
    String url = "C:\\Users\\i7DELL\\Documents\\NetBeansProjects\\Ganasoft\\QR-"+ID+".pdf";
        
        ProcessBuilder abrir=new ProcessBuilder();
        abrir.command("cmd.exe","/c",url);
        try {
            abrir.start();
        } catch (IOException ex) {
            Logger.getLogger(MetodosReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
    
}
