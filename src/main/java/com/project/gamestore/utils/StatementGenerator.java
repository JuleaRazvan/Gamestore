package com.project.gamestore.utils;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import org.springframework.stereotype.Component;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.project.gamestore.entities.Transaction;
import com.project.gamestore.repositories.TransactionRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class StatementGenerator {

        private TransactionRepository transactionRepository;

        public void generateDailyStatment() throws FileNotFoundException {
                LocalDate currentDate = LocalDate.now();
                LocalDateTime startDateTime = LocalDateTime.of(currentDate, LocalTime.MIN);
                LocalDateTime endDateTime = LocalDateTime.of(currentDate.plusDays(1), LocalTime.MIN);

                Instant startDate = startDateTime.toInstant(ZoneOffset.UTC);
                Instant endDate = endDateTime.toInstant(ZoneOffset.UTC);

                String path = "invoice.pdf";
                PdfWriter pdfWriter = new PdfWriter(path);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                pdfDocument.setDefaultPageSize(PageSize.A4);
                Document document = new Document(pdfDocument);
                float fourcol = 142.5f;
                float twocol = 285f;
                float twocol150 = twocol + 150f;
                float twocolumnWidth[] = { twocol150, twocol };
                float fourColumnWidth[] = { fourcol, fourcol, fourcol, fourcol };
                float fullwidth[] = { fourcol * 4 };

                Table table = new Table(twocolumnWidth);
                table.addCell(new Cell().add("GameStore").setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
                Table nestedTable = new Table(new float[] { twocol / 2 });
                nestedTable.addCell(new Cell().add("Statement Date").setBold().setBorder(Border.NO_BORDER));
                nestedTable.addCell(new Cell().add(startDateTime.toString()).setBorder(Border.NO_BORDER));

                table.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));

                Border gb = new SolidBorder(Color.GRAY, 2f);
                Table divider = new Table(fullwidth);
                divider.setBorder(gb);
                document.add(table);
                document.add(divider);
                Paragraph producPara = new Paragraph("Transactions");

                document.add(producPara.setBold());
                Table transactionTable = new Table(fourColumnWidth);
                transactionTable.setBackgroundColor(Color.BLACK, 0.7f);

                transactionTable
                                .addCell(new Cell().add("UserId").setBold()
                                                .setFontColor(Color.WHITE)
                                                .setBorder(Border.NO_BORDER));
                transactionTable.addCell(new Cell().add("GameId").setBold()
                                .setFontColor(Color.WHITE)
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBorder(Border.NO_BORDER));
                transactionTable.addCell(new Cell().add("Type").setBold()
                                .setFontColor(Color.WHITE)
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBorder(Border.NO_BORDER));
                transactionTable.addCell(new Cell().add("Value").setBold()
                                .setFontColor(Color.WHITE)
                                .setTextAlignment(TextAlignment.RIGHT)
                                .setBorder(Border.NO_BORDER)
                                .setMarginRight(15f));
                document.add(transactionTable);

                Table transactionDataTable = new Table(fourColumnWidth);
                transactionDataTable.setBackgroundColor(Color.WHITE);

                List<Transaction> transactions = transactionRepository.findTransactionsByDateRange(startDate, endDate);
                transactions.forEach(transaction -> {
                        transactionDataTable.addCell(new Cell()
                                        .add(transaction.getUser().getPublicIdentifier().toString())
                                        .setFontSize(12f)
                                        .setBorder(Border.NO_BORDER));
                        transactionDataTable.addCell(new Cell()
                                        .add(transaction.getGame().getPublicIdentifier().toString())
                                        .setTextAlignment(TextAlignment.CENTER)
                                        .setFontSize(12f)
                                        .setBorder(Border.NO_BORDER));
                        transactionDataTable.addCell(new Cell().add(transaction.getType().toString())
                                        .setTextAlignment(TextAlignment.CENTER)
                                        .setFontSize(12f)
                                        .setBorder(Border.NO_BORDER));
                        transactionDataTable.addCell(new Cell().add(transaction.getPrice().toString())
                                        .setTextAlignment(TextAlignment.RIGHT)
                                        .setFontSize(12f)
                                        .setBorder(Border.NO_BORDER).setMarginRight(15f));
                });
                document.add(transactionDataTable);

                double totalSales = 0;
                for (Transaction t : transactions) {
                        switch (t.getType()) {
                                case BUY -> {
                                        totalSales += t.getPrice().doubleValue();
                                }
                                case REFUND -> {
                                        totalSales -= t.getPrice().doubleValue();
                                }
                        }
                }

                float oneTwo[] = { fourcol * 4, fourcol * 3 };
                Table transactionTotalSectionTable = new Table(oneTwo);
                transactionTotalSectionTable.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
                transactionTotalSectionTable.addCell(divider).setBorder(Border.NO_BORDER);
                document.add(transactionTotalSectionTable);

                Table transactionTotalTable = new Table(fourColumnWidth);
                transactionTotalTable.setBackgroundColor(Color.WHITE);
                transactionTotalTable.addCell(new Cell()
                                .add("")
                                .setBorder(Border.NO_BORDER));
                transactionTotalTable.addCell(new Cell()
                                .add("")
                                .setBorder(Border.NO_BORDER));
                transactionTotalTable.addCell(new Cell()
                                .add("Total")
                                .setTextAlignment(TextAlignment.CENTER)
                                .setFontSize(12f)
                                .setBorder(Border.NO_BORDER));
                transactionTotalTable.addCell(new Cell()
                                .add(String.valueOf(totalSales))
                                .setTextAlignment(TextAlignment.RIGHT)
                                .setFontSize(12f)
                                .setBorder(Border.NO_BORDER).setMarginRight(15f));
                document.add(transactionTotalTable);
                document.close();
        }
}
