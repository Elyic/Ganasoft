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
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            Datos="\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + Datos;
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
    
    public void crearReporte(String semoviente) throws DocumentException, SQLException{
        
        FileOutputStream elpdf= null;
        Modelo.Conexion conexion = new Modelo.Conexion();
        try {
            int entonces = 0;
            Document documento= new Document(PageSize.LEGAL.rotate());
            elpdf = new FileOutputStream("Datos de "+semoviente+".pdf");
            PdfWriter.getInstance(documento, elpdf);
            documento.open();
            Paragraph p1 = new Paragraph();
            Font fonT= new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
            p1.add(new Phrase("Datos totales del registro "+semoviente+": ",fonT));
            p1.setAlignment(Element.ALIGN_CENTER);
            p1.add(new Phrase(Chunk.NEWLINE));
            p1.add(new Phrase(Chunk.NEWLINE));
            documento.add(p1);
            
            Paragraph p2 = new Paragraph();
                p2.add(new Phrase("Datos generales:"
                        + "\n"
                        + "\n",fonT));
                p2.add(new Phrase(Chunk.NEWLINE));
                documento.add(p2);
            
            PdfPTable tabla = new PdfPTable(9);
            PdfPTable tabla2 = new PdfPTable(10);
            PdfPCell celda1 = new PdfPCell(new Paragraph("ID",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));       
            PdfPCell celda2 = new PdfPCell(new Paragraph("Descripción",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("Raza",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("Tipo",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda5 = new PdfPCell(new Paragraph("Fecha Nac.",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda6 = new PdfPCell(new Paragraph("Edad",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda7 = new PdfPCell(new Paragraph("Lote",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda8 = new PdfPCell(new Paragraph("Procedencia",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda9 = new PdfPCell(new Paragraph("Categoría",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda10 = new PdfPCell(new Paragraph("No. Hijos",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda11 = new PdfPCell(new Paragraph("Peso",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda12 = new PdfPCell(new Paragraph("Padre",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda13 = new PdfPCell(new Paragraph("Madre",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda14 = new PdfPCell(new Paragraph("Fecha muerte",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda15 = new PdfPCell(new Paragraph("ubicación",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda16 = new PdfPCell(new Paragraph("Precio compra",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda17 = new PdfPCell(new Paragraph("Precio venta",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda18 = new PdfPCell(new Paragraph("Estado",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda19 = new PdfPCell(new Paragraph("Sexo",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            
            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);
            tabla.addCell(celda6);
            tabla.addCell(celda7);
            tabla.addCell(celda8);
            tabla.addCell(celda9);
            tabla2.addCell(celda10);
            tabla2.addCell(celda11);
            tabla2.addCell(celda12);
            tabla2.addCell(celda13);
            tabla2.addCell(celda14);
            tabla2.addCell(celda15);
            tabla2.addCell(celda16);
            tabla2.addCell(celda17);
            tabla2.addCell(celda18);
            tabla2.addCell(celda19);
            Connection conecta = conexion.getConexion();
            Statement st=null;
            ResultSet rs=null;
            st=(Statement) conecta.createStatement();
            rs= st.executeQuery("SELECT *\n" +
            "FROM ANIMAL A\n" +
            "WHERE ID_ANIMAL="+semoviente+"");
            if (conecta!=null){
                while(rs.next()){ 
                tabla.addCell(rs.getString("ID_ANIMAL"));
                tabla.addCell(rs.getString("DESCRIPCION"));
                tabla.addCell(rs.getString("RAZA"));
                tabla.addCell(rs.getString("TIPO"));
                tabla.addCell(rs.getString("FECHA_NACIMIENTO"));
                tabla.addCell(Integer.toString(rs.getInt("EDAD")));
                tabla.addCell(rs.getString("NO_LOTE")); 
                tabla.addCell(rs.getString("PROCEDENCIA")); 
                tabla.addCell(rs.getString("CATEGORIA"));
                tabla2.addCell(Integer.toString(rs.getInt("NO_HIJOS")));
                tabla2.addCell(Float.toString(rs.getFloat("PESO"))); 
                tabla2.addCell(rs.getString("PADRE"));
                tabla2.addCell(rs.getString("MADRE"));
                tabla2.addCell(rs.getString("FECHA_MUERTE"));
                tabla2.addCell(rs.getString("UBICACION"));
                tabla2.addCell(Float.toString(rs.getFloat("PRECIO_COMPRA")));
                tabla2.addCell(Float.toString(rs.getFloat("PRECIO_VENTA")));
                tabla2.addCell(rs.getString("ESTADO"));
                tabla2.addCell(rs.getString("SEXO"));
                entonces=1;
                }
            }if(entonces == 0){
                tabla.addCell("-");
                tabla.addCell("-");
                tabla.addCell("-");
                tabla.addCell("-");
                tabla.addCell("-");
                tabla.addCell("-");
                tabla.addCell("-");
                tabla.addCell("-");
                tabla.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
                tabla2.addCell("-");
            }
            
            entonces=0;
            documento.add(tabla);
            documento.add(tabla2);
            //
        Paragraph p3 = new Paragraph();
                p3.add(new Phrase("\n"
                        + "Datos de carne:"
                        + "\n"
                        + "\n",fonT));
                p3.add(new Phrase(Chunk.NEWLINE));
                documento.add(p3);
            
            PdfPTable tabla3 = new PdfPTable(5);
            PdfPCell celda20 = new PdfPCell(new Paragraph("ID carne",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));       
            PdfPCell celda21 = new PdfPCell(new Paragraph("Estado",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda22 = new PdfPCell(new Paragraph("Calidad",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda23 = new PdfPCell(new Paragraph("Fecha de revisión",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda24 = new PdfPCell(new Paragraph("Obsevaciones",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            tabla3.addCell(celda20);
            tabla3.addCell(celda21);
            tabla3.addCell(celda22);
            tabla3.addCell(celda23);
            tabla3.addCell(celda24);
            
            rs= st.executeQuery("SELECT *\n" +
            "FROM CARNE\n" +
            "WHERE ID_ANIMAL="+semoviente+"");
            if (conecta!=null){
                while(rs.next()){ 
                tabla3.addCell(rs.getString("ID_CARNE"));
                tabla3.addCell(rs.getString("ESTADO"));
                tabla3.addCell(rs.getString("CALIDAD"));
                tabla3.addCell(rs.getString("FECHA_REVISION"));
                tabla3.addCell(rs.getString("OBSERVACIONES"));
                entonces=1;
                }
            }if(entonces == 0){
                tabla3.addCell("-");
                tabla3.addCell("-");
                tabla3.addCell("-");
                tabla3.addCell("-");
                tabla3.addCell("-");
            }
            
            entonces=0;
            documento.add(tabla3); //
            
                Paragraph p4 = new Paragraph();
                p4.add(new Phrase("\n"
                        + "Datos de fertilidad:"
                        + "\n"
                        + "\n",fonT));
                p4.add(new Phrase(Chunk.NEWLINE));
                documento.add(p4);
            
            PdfPTable tabla4 = new PdfPTable(5);
            PdfPCell celda25 = new PdfPCell(new Paragraph("ID fertilidad",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));       
            PdfPCell celda26 = new PdfPCell(new Paragraph("Calidad",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda27 = new PdfPCell(new Paragraph("Cantidad",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda28 = new PdfPCell(new Paragraph("Fecha de revisión",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda29 = new PdfPCell(new Paragraph("Obsevaciones",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            tabla4.addCell(celda25);
            tabla4.addCell(celda26);
            tabla4.addCell(celda27);
            tabla4.addCell(celda28);
            tabla4.addCell(celda29);
            
            rs= st.executeQuery("SELECT *\n" +
            "FROM FERTILIDAD\n" +
            "WHERE ID_ANIMAL="+semoviente+"");
            if (conecta!=null){
                while(rs.next()){ 
                tabla4.addCell(Integer.toString(rs.getInt("ID_FERTILIDAD")));
                tabla4.addCell(rs.getString("CALIDAD"));
                tabla4.addCell(rs.getString("CANTIDAD"));
                tabla4.addCell(rs.getString("FECHA_REVISION"));
                tabla4.addCell(rs.getString("OBSERVACIONES"));
                entonces=1;
                }
            }if(entonces == 0){
                tabla4.addCell("-");
                tabla4.addCell("-");
                tabla4.addCell("-");
                tabla4.addCell("-");
                tabla4.addCell("-");
            }
            
            entonces=0;
            documento.add(tabla4);
            
            Paragraph p5 = new Paragraph();
                p5.add(new Phrase("\n"
                        + "Datos de Leche:"
                        + "\n"
                        + "\n",fonT));
                p5.add(new Phrase(Chunk.NEWLINE));
                documento.add(p5);
            
            PdfPTable tabla5 = new PdfPTable(5);
            PdfPCell celda30 = new PdfPCell(new Paragraph("ID leche",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));       
            PdfPCell celda31 = new PdfPCell(new Paragraph("Calidad",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda32 = new PdfPCell(new Paragraph("Cantidad producida",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda33 = new PdfPCell(new Paragraph("Fecha de revisión",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda34 = new PdfPCell(new Paragraph("Obsevaciones",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            tabla5.addCell(celda30);
            tabla5.addCell(celda31);
            tabla5.addCell(celda32);
            tabla5.addCell(celda33);
            tabla5.addCell(celda34);
            
            rs= st.executeQuery("SELECT *\n" +
            "FROM LECHE\n" +
            "WHERE ID_ANIMAL="+semoviente+"");
            if (conecta!=null){
                while(rs.next()){ 
                tabla5.addCell(Integer.toString(rs.getInt("ID_LECHE")));
                tabla5.addCell(rs.getString("CALIDAD"));
                tabla5.addCell(rs.getString("CANTIDAD_PRODUCIDA"));
                tabla5.addCell(rs.getString("FECHA_REVISION"));
                tabla5.addCell(rs.getString("OBSERVACIONES"));
                entonces=1;
                }
            }if(entonces == 0){
                tabla5.addCell("-");
                tabla5.addCell("-");
                tabla5.addCell("-");
                tabla5.addCell("-");
                tabla5.addCell("-");
            }
            
            entonces=0;
            documento.add(tabla5);
            
            Paragraph p6 = new Paragraph();
                p6.add(new Phrase("\n"
                        + "Datos de Parto:"
                        + "\n"
                        + "\n",fonT));
                p6.add(new Phrase(Chunk.NEWLINE));
                documento.add(p6);
            
            PdfPTable tabla6 = new PdfPTable(4);
            PdfPCell celda35 = new PdfPCell(new Paragraph("ID parto",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));       
            PdfPCell celda36 = new PdfPCell(new Paragraph("Fecha de parto",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda37 = new PdfPCell(new Paragraph("Estado",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda38 = new PdfPCell(new Paragraph("Observaciones",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            tabla6.addCell(celda35);
            tabla6.addCell(celda36);
            tabla6.addCell(celda37);
            tabla6.addCell(celda38);
            
            rs= st.executeQuery("SELECT *\n" +
            "FROM PARTO\n" +
            "WHERE ID_ANIMAL="+semoviente+"");
            if (conecta!=null){
                while(rs.next()){ 
                tabla6.addCell(Integer.toString(rs.getInt("ID_PARTO")));
                tabla6.addCell(rs.getString("FECHA_PARTO"));
                tabla6.addCell(rs.getString("ESTADO"));
                tabla6.addCell(rs.getString("OBSERVACIONES"));
                entonces=1;
                }
            }if(entonces == 0){
                tabla6.addCell("-");
                tabla6.addCell("-");
                tabla6.addCell("-");
                tabla6.addCell("-");
            }
            
            entonces=0;
            documento.add(tabla6);
            
            Paragraph p7 = new Paragraph();
                p7.add(new Phrase("\n"
                        + "Datos de Vacunación:"
                        + "\n"
                        + "\n",fonT));
                p7.add(new Phrase(Chunk.NEWLINE));
                documento.add(p7);
            
            PdfPTable tabla7 = new PdfPTable(5);
            PdfPCell celda39 = new PdfPCell(new Paragraph("ID Vacunación",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));       
            PdfPCell celda40 = new PdfPCell(new Paragraph("Fecha de vacunación",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda41 = new PdfPCell(new Paragraph("Medicina",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda42 = new PdfPCell(new Paragraph("Cantidad de medicina",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda43 = new PdfPCell(new Paragraph("Observaciones",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            tabla7.addCell(celda39);
            tabla7.addCell(celda40);
            tabla7.addCell(celda41);
            tabla7.addCell(celda42);
            tabla7.addCell(celda43);
            
            rs= st.executeQuery("SELECT *\n" +
            "FROM VACUNACION\n" +
            "WHERE ID_ANIMAL="+semoviente+"");
            if (conecta!=null){
                while(rs.next()){ 
                tabla7.addCell(Integer.toString(rs.getInt("ID_VACUNACION")));
                tabla7.addCell(rs.getString("FECHA_VACUNACION"));
                tabla7.addCell(rs.getString("MEDICINA"));
                tabla7.addCell(rs.getString("CANTIDAD_MEDICINA"));
                tabla7.addCell(rs.getString("OBSERVACIONES"));
                entonces=1;
                }
            }if(entonces == 0){
                tabla7.addCell("-");
                tabla7.addCell("-");
                tabla7.addCell("-");
                tabla7.addCell("-");
                tabla7.addCell("-");
            }
            
            entonces=0;
            documento.add(tabla7);
            
            conecta.close();
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
    String url = "QR-"+ID+".pdf";
        
        ProcessBuilder abrir=new ProcessBuilder();
        abrir.command("cmd.exe","/c",url);
        try {
            abrir.start();
        } catch (IOException ex) {
            Logger.getLogger(MetodosReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
 
public void mostrarReporte(String ID){
    String url = "Datos de "+ID+".pdf";
        
        ProcessBuilder abrir=new ProcessBuilder();
        abrir.command("cmd.exe","/c",url);
        try {
            abrir.start();
        } catch (IOException ex) {
            Logger.getLogger(MetodosReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}

}
