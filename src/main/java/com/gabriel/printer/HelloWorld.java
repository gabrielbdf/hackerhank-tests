package com.gabriel.printer;

import java.io.IOException;

import javax.print.PrintService;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.escpos.Style.ColorMode;
import com.github.anastaciocintra.escpos.Style.FontName;
import com.github.anastaciocintra.output.PrinterOutputStream;

public class HelloWorld {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Usage: java -jar escpos-simple.jar (\"printer name\")");
            System.out.println("Printer list to use:");
            String[] printServicesNames = PrinterOutputStream.getListPrintServicesNames();
            for (String printServiceName : printServicesNames) {
                System.out.println(printServiceName);
            }

            // System.exit(0);
        }

        PrintService printService = PrinterOutputStream
                .getPrintServiceByName("STMicroelectronics USB Portable Printer 2");
        PrinterOutputStream printerOutputStream = new PrinterOutputStream(printService);
        EscPos escpos = new EscPos(printerOutputStream);

        Style title = new Style()
                .setFontSize(Style.FontSize._2, Style.FontSize._2)
                .setJustification(EscPosConst.Justification.Center);
        Style number = new Style()
                .setFontSize(Style.FontSize._3, Style.FontSize._3)
                .setJustification(EscPosConst.Justification.Center)
                .setBold(true);

        Style bold = new Style(escpos.getStyle()).setBold(true);

        escpos
                .writeLF(title, "UA KIDS")
                .feed(2)
                .writeLF(number, "3493")
                .feed(2)
                .write(bold, "Nome: ")
                .writeLF("Yuri Bernardo")
                .write(bold, "Data de Nascimento: ")
                .writeLF("04/08/2013")
                .write(bold, "Turma: ")
                .writeLF("Juniores")
                .feed(3)
                .cut(EscPos.CutMode.FULL);
        escpos.close();
    }
}
