package com.liuencier.csp.core.component;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class ProducePDF {

    Document document = null;// 建立一个Document对象
    private static Font headFont;
    private static Font keyFont;
    private static Font textfont_H;
    private static Font textfont_B;
    int maxWidth = 520;

    static {
        BaseFont bfChinese_H;
        try {
            /**
             * 新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀
             * UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H 代表文字版式是 横版， 相应的 V 代表竖版
             */
            bfChinese_H = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

            headFont = new Font(bfChinese_H, 10, Font.NORMAL);
            keyFont = new Font(bfChinese_H, 18, Font.BOLD);
            textfont_H = new Font(bfChinese_H, 10, Font.NORMAL);
            textfont_B = new Font(bfChinese_H, 12, Font.NORMAL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置页面属性
     *
     * @param file
     */
    public ProducePDF(File file) {

        //自定义纸张
        Rectangle rectPageSize = new Rectangle(350, 620);

        // 定义A4页面大小
        //Rectangle rectPageSize = new Rectangle(PageSize.A4);
        rectPageSize = rectPageSize.rotate();// 加上这句可以实现页面的横置
        document = new Document(rectPageSize, 10, 150, 10, 40);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 建表格(以列的数量建)
     *
     * @param colNumber
     * @return
     */
    public PdfPTable createTable(int colNumber) {
        PdfPTable table = new PdfPTable(colNumber);
        try {
            //table.setTotalWidth(maxWidth);
            //table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
            table.setSpacingBefore(10);
            table.setWidthPercentage(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 建表格(以列的宽度比建)
     *
     * @param widths
     * @return
     */
    public PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        try {
            //table.setTotalWidth(maxWidth);
            //table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
            table.setSpacingBefore(10);
            table.setWidthPercentage(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }


    /**
     * 表格中单元格
     *
     * @param value
     * @param font
     * @param align
     * @return
     */
    public PdfPCell createCell(String value, Font font, int align) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 表格中单元格
     *
     * @param value
     * @param font
     * @param align
     * @param colspan
     * @param rowspan
     * @return
     */
    public PdfPCell createCell(String value, Font font, int align_v, int align_h, int colspan, int rowspan) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(align_v);
        cell.setHorizontalAlignment(align_h);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 建短语
     *
     * @param value
     * @param font
     * @return
     */
    public Phrase createPhrase(String value, Font font) {
        Phrase phrase = new Phrase();
        phrase.add(value);
        phrase.setFont(font);
        return phrase;
    }

    /**
     * 建段落
     *
     * @param value
     * @param font
     * @param align
     * @return
     */
    public Paragraph createParagraph(String value, Font font, int align) {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Phrase(value, font));
        paragraph.setAlignment(align);
        return paragraph;
    }


    public void generatePDF() throws Exception {

        for (int i = 0; i < 3; i++) {


            //页头信息
            document.add(createParagraph("西安" + i, headFont, Element.ALIGN_LEFT));
            document.add(createParagraph("签  购  单", keyFont, Element.ALIGN_CENTER));
            document.add(createParagraph("编号：XD201602000003", headFont, Element.ALIGN_RIGHT));

            //表格信息
            float[] widths = {4f, 10f, 10f, 20f, 15f, 8f, 11f, 12f, 10f};
            PdfPTable table = createTable(widths);

            table.addCell(createCell("顾客信息", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 4));

            table.addCell(createCell("顾客名称", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));
            table.addCell(createCell("XXXX有限公司", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 6, 1));

            table.addCell(createCell("编码/税号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));
            table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 6, 1));

            table.addCell(createCell("联系地址", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));
            table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 6, 1));

            table.addCell(createCell("采购经办人", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 2, 1));
            table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("经办人电话", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 1));
            table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));
            table.addCell(createCell("经办人手机", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 1));
            table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));


            table.addCell(createCell("产品订购清单", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 8));

            table.addCell(createCell("序号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 1));
            table.addCell(createCell("产品信息", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 2, 1));
            table.addCell(createCell("规格型号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 1));
            table.addCell(createCell("单位", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 1));
            table.addCell(createCell("单价", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 1));
            table.addCell(createCell("数量", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 1));
            table.addCell(createCell("小计", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 1));

            table.addCell(createCell("1", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("塑料纸", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));
            table.addCell(createCell("小号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("个", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("20", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("20", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("400", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));

            table.addCell(createCell("2", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("塑料纸", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));
            table.addCell(createCell("小号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("个", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("20", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("20", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("400", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));

            table.addCell(createCell("3", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("塑料纸", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));
            table.addCell(createCell("小号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("个", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("20", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("20", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("400", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));


            table.addCell(createCell("4", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("合计", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));
            table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("20", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("60", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));
            table.addCell(createCell("1200", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 1, 1));


            table.addCell(createCell("合计金额（元）", textfont_B, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 3, 1));
            table.addCell(createCell("壹仟俩佰元", textfont_B, Element.ALIGN_MIDDLE, Element.ALIGN_RIGHT, 6, 1));


            table.addCell(createCell("顾客确认", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, 1, 3));

            table.addCell(createCell("注：本人已充分了解订购产品的功能用途，是根据实际需要自愿购买的。", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 8, 1));

            table.addCell(createCell("采购经办人签字：", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 6, 1));
            table.addCell(createCell("盖章：", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 2, 1));

            table.addCell(createCell("签字日期", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, 8, 1));

            document.add(table);
            document.newPage();
        }
        document.close();
    }

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/liuenci/ticket.pdf");
        file.createNewFile();
        new ProducePDF(file).generatePDF();
        System.out.println("PDF生产完成");
    }
}