package com.serv;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;

/**
 * Servlet implementation class PdfGen
 */
@WebServlet("/PdfGen")
public class PdfGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfGen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//float acreage=Float.parseFloat(request.getParameter("acreage"));
		//try {
			//Date date = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).parse(request.getParameter("date"));
		//} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
	        
		try {

	        ByteArrayOutputStream output = new ByteArrayOutputStream();
	        output = createPDF();

	        response.addHeader("Content-Type", "application/force-download"); 
	        response.addHeader("Content-Disposition", "attachment; filename=\"yourFile.pdf\"");
	        response.getOutputStream().write(output.toByteArray());

	    } catch (Exception ex) {            
	        ex.printStackTrace();
	    }   
		
	}

	public ByteArrayOutputStream createPDF() throws IOException, COSVisitorException {

	    PDDocument document;
	    PDPage page;
	    PDFont font;
	    PDPageContentStream contentStream;
	    PDJpeg front;
	    PDJpeg back;

	    InputStream inputFront;
	    InputStream inputBack;
	    ByteArrayOutputStream output = new ByteArrayOutputStream(); 

	    // Creating Document
	    document = new PDDocument();

	    // Creating Pages
	    for(int i=0; i<2; i++) {

	        page = new PDPage();

	        // Adding page to document
	        document.addPage(page); 

	        // Adding FONT to document
	        font = PDType1Font.HELVETICA;           


	        // Next we start a new content stream which will "hold" the to be created content.
	        contentStream = new PDPageContentStream(document, page);                

	        // Let's define the content stream
	        contentStream.beginText();
	        contentStream.setFont(font, 8);
	        contentStream.moveTextPositionByAmount(10, 770);
	        contentStream.drawString("Amount: $1.00");
	        contentStream.endText();

	        contentStream.beginText();
	        contentStream.setFont(font, 8);
	        contentStream.moveTextPositionByAmount(200, 770);
	        contentStream.drawString("Sequence Number: 123456789");
	        contentStream.endText();

	        contentStream.beginText();
	        contentStream.setFont(font, 8);
	        contentStream.moveTextPositionByAmount(10, 760);
	        contentStream.drawString("Account: 123456789");
	        contentStream.endText();

	        contentStream.beginText();
	        contentStream.setFont(font, 8);
	        contentStream.moveTextPositionByAmount(200, 760);
	        contentStream.drawString("Captura Date: 04/25/2011");
	        contentStream.endText();

	        contentStream.beginText();
	        contentStream.setFont(font, 8);
	        contentStream.moveTextPositionByAmount(10, 750);
	        contentStream.drawString("Bank Number: 123456789");
	        contentStream.endText();

	        contentStream.beginText();
	        contentStream.setFont(font, 8);
	        contentStream.moveTextPositionByAmount(200, 750);
	        contentStream.drawString("Check Number: 123456789");
	        contentStream.endText();            

	        // Let's close the content stream       
	        contentStream.close();

	    }

	    // Finally Let's save the PDF
	    document.save(output);
	    document.close();

	    return output;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
