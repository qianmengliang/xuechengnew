package com.xuecheng.manage_cms.web.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.dom4j.DocumentException;

import java.awt.*;
import java.io.*;

/**
 * @ClassName test
 * @Description: TODO
 * @Author qianml
 * @Date 2020/5/14
 * @Version V1.0
 **/
public class test {
   /* public static void main(String[] args) {
        String s="0.0002";
       // s=  String.format("%f", s);
        double v = Double.parseDouble(s);
        System.out.println(v+"");
    }*/

//    public static ByteArrayOutputStream T_LOG_RECORD_PREPAIDPDF(String burks,String gonssi,String date){
//        Document document = new Document();
//        Rectangle pageSize = new Rectangle(PageSize.A4.getHeight(),PageSize.A4.getWidth());
//        pageSize.rotate();
//        document.setPageSize(pageSize);//设置文件纸张大小
//        PdfWriter writer=null;
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);//设置字体
//            Font titlefont = new Font(bfChinese,14, Font.BOLD);//字体样式
//            Font companyfont = new Font(bfChinese,10,Font.NORMAL);//字体样式
//            Font rowfont = new Font(bfChinese,10,Font.NORMAL);//字体样式
//            PDFBuilder pdfBuilder = new PDFBuilder();
//            writer = PdfWriter.getInstance(document,os);
//            writer.setPageEvent(pdfBuilder);
//            document.open();
//            Double TAX_FREE_AMT=0.0;
//            Double AMORTIZE_MONTH_ACCOUNT=0.0;
//            Double CURRENT_MONTH_ACCOUNT=0.0;
//            Double TOTAL_AMORTIZE_ACCOUNT=0.0;
//            Double AMORTIZE_BALANCE=0.0;
//
//            PdfPTable pdfPTable2 = new PdfPTable(13);
//            float[] columnWidth={55,50,50,110,50,50,50,85,50,50,60,80,80};
//            pdfPTable2.setTotalWidth(columnWidth);
//            pdfPTable2.setLockedWidth(true);
//
//            document.newPage();
//            //抬头信息
//            document.add(  pdfPTable2.addCell(createCell("费用明细表", 1, 13, titlefont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.0f)));
//            document.add(  pdfPTable2.addCell(createCell("公司名称", 1, 1, companyfont,Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.0f)));
//            document.add(  pdfPTable2.addCell(createCell(gonssi, 1, 12, companyfont,Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.0f)));
//
//            //表头数据
//            pdfPTable2.addCell(createCell("单据号", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("凭证编号", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("凭证日期", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("费用明细名称", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("开始日期", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("结束日期", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("待摊期间", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("发票无税金额", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("月摊销额", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("本月摊销", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("已摊销月数", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("累计摊销金额", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("待摊余额", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            //表体数据
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("123456".toString(), 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));//发票无税金额
//            TAX_FREE_AMT+=Double.parseDouble("123456");
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));//月摊销金额
//            AMORTIZE_MONTH_ACCOUNT+=Double.parseDouble("123456");
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));//本月摊销金额
//            CURRENT_MONTH_ACCOUNT+=Double.parseDouble("123456");
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));//累计摊销金额
//            TOTAL_AMORTIZE_ACCOUNT+=Double.parseDouble("123456");
//            pdfPTable2.addCell(createCell("123456", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));//待摊余额
//            AMORTIZE_BALANCE+=Double.parseDouble("123456");
//            pdfPTable2.addCell(createCell("合计", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("  ", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("  ", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("  ", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("  ", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("  ", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("  ", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell(TAX_FREE_AMT.toString(), 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell(AMORTIZE_MONTH_ACCOUNT.toString(), 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell(CURRENT_MONTH_ACCOUNT.toString(), 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell("  ", 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell(TOTAL_AMORTIZE_ACCOUNT.toString(), 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            pdfPTable2.addCell(createCell(AMORTIZE_BALANCE.toString(), 1, 1, rowfont, Element.ALIGN_LEFT, Element.ALIGN_CENTER,0.5f));
//            document.add(pdfPTable2);
//            document.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return os;
//    }
//
//    /**
//     * 多要求创建一行一列
//     * @param cellName
//     * @param row
//     * @param col
//     * @param font
//     * @param shuiping
//     * @param chuizhi
//     * @param f
//     * @return
//     * @throws DocumentException
//     * @throws IOException
//     */
//    public static PdfPCell createCell(String cellName, Integer row, Integer col, Font font, int shuiping, int chuizhi, float f) throws DocumentException, IOException{
//        PdfPCell cell = new PdfPCell(new Phrase(cellName, font));
//        cell.setUseBorderPadding(true);
//        cell.setBorderWidth(f);
//        cell.setVerticalAlignment(chuizhi);//垂直居中
//        System.out.println(col);
//        if(row!=null){
//            cell.setRowspan(row);
//        }
//        if(col!=null&&col>1){
//            cell.setHorizontalAlignment(shuiping);//水平居中
//            cell.setColspan(col);
//        }else{
//            cell.setHorizontalAlignment(shuiping);
//        }
//        return cell;
//    }
//
//    /**
//     * Description: 向FTP服务器上传文件
//     * @param host FTP服务器hostname
//     * @param port FTP服务器端口
//     * @param username FTP登录账号
//     * @param password FTP登录密码
//     * @param basePath FTP服务器基础目录
//     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
//     * @param filename 上传到FTP服务器上的文件名
//     * @param input 输入流
//     * @return 成功返回true，否则返回false
//     */
//    public static  boolean uploadFile(  String basePath,String filePath, String filename, InputStream input) {
//        boolean result = false;
//        try{
//            if (!ftp.changeWorkingDirectory("F://")) {
//                String[] dirs = filePath.split("/");
//                String tempPath = basePath;
//                for (String dir : dirs) {
//                    if (null == dir || "".equals(dir)) continue;
//                    tempPath += "/" + dir;
//                    if (!ftp.changeWorkingDirectory(tempPath)) {
//                        if (!ftp.makeDirectory(tempPath)) {
//                            return result;
//                        } else {
//                            ftp.changeWorkingDirectory(tempPath);
//                        }
//                    }
//                }
//
//            }
//            ftp.setFileType(FTP.BINARY_FILE_TYPE);
//            if (!ftp.storeFile(filename, input)) {
//
//                return result;
//            }else{
//                result=true;
//                System.out.println("上传成功");
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        ByteArrayOutputStream OS = T_LOG_RECORD_PREPAIDPDF("1","123","456");
//        //保存文件到本地
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream("F:\\aaaaa.pdf");
//            fileOutputStream.write(OS.toByteArray());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //上传至ftp服务器
//        //登陆ftp服务器
//        try {
//            connect();
//            InputStream Input = new ByteArrayInputStream(OS.toByteArray());
//            uploadFile("","","",Input);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            ftp.logout();
//            System.out.println("FTP服务器退出成功");
//        } catch (IOException e) {
//            System.out.println("FTP服务器退出失败");
//            e.printStackTrace();
//        }finally{
//            if(ftp.isConnected()){
//                try {
//                    ftp.disconnect();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    /**
//     * 登陆ftp服务器
//     * @throws Exception
//     */
//    public static void connect() throws Exception {
//        try {
//            ftp.setDefaultPort(8080);//port
//            ftp.connect("127.0.0.1");//host
//            ftp.setDataTimeout(60000000);// 10分钟超时
//            ftp.setConnectTimeout(60000000);
//            ftp.login("FTP_USER", "FTP_PWD");
//            int reply = ftp.getReplyCode();
//            if (!FTPReply.isPositiveCompletion(reply)) {
//                ftp.disconnect();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }
}
