package com.gxzy.bigdata.scree;

import com.gxzy.bigdata.utils.Result;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * Description: 卷接产量数据导出
 * Created by wwquan on 2019/7/30 19:24
 * 代码过程参数可变，还可以进行优化。
 * 代码分层可以更规范化，还可以优化，现在只是将功能全流程跑通，且只有70机型的流程。
 */
@CrossOrigin(origins = "http://localhost:9528", maxAge = 3600)
@RestController
@RequestMapping(value = "${bigData.api.excelUri}")
public class ReadDocController {

    private static final Logger logger = LoggerFactory.getLogger(ReadDocController.class);

    /**
     * 导出卷接机数据为excel
     *
     * @return 卷接机产量报告等
     */
    @GetMapping("${bigData.api.getSHIFTUri}")
    @ResponseBody
    public ResponseEntity<Resource> getSHIFT(HttpServletRequest request, HttpServletResponse response, String path, String dateS, String dateE) {
        Result result = new Result();
        try {
//            path = "D:\\wwquan\\normal\\广西中烟\\软件\\卷接大数据软件基础研究\\01数据\\20190729第一次数据处理\\";
            String fromType = "ini";
            String to = "txt";
            logger.info("开始读取文件名称及更改后缀 fromType:{},to:{}", fromType, to);
            reName(path, fromType, to);

            List<Map<String, String>> mapList1 = new ArrayList<>();
            logger.info("开始筛选{}-{}的数据", dateS, dateE);
            List<Map<String, String>> mapList = readName(path, mapList1, dateS, dateE);
            logger.info("分析返回{}条数据", mapList.size());

            ClassPathResource cpr = new ClassPathResource("/templates/" + "J.xlsx");
            InputStream is = cpr.getInputStream();
            Workbook workbook = new XSSFWorkbook(is);
            org.apache.poi.ss.usermodel.Sheet sheet0 = workbook.getSheetAt(0);
            sheet0.setForceFormulaRecalculation(true);
            logger.info("读取模板完毕，正在填充数据...");
            for (int mi = 0; mi < mapList.size(); mi++) {
                if (mapList.get(mi).isEmpty()) {
                    continue;
                } else {
                    Row row = sheet0.createRow(mi + 2);
                    row.createCell(0).setCellValue(mapList.get(mi).get("machineNO"));
                    row.createCell(1).setCellValue(mapList.get(mi).get("time"));
                    row.createCell(2).setCellValue(mapList.get(mi).get("team"));

                    String lastData = mapList.get(mi).get("LastData");
                    String lineT = lastData.substring(lastData.indexOf("=") + 1, lastData.length());
                    String[] as = lineT.split(",");//针对以逗号分隔的数据进行处理和返回结果，暂时不做成工具，等其他地方用到再做
                    for (int i = 0; i < as.length; i++) {
                        row.createCell(i + 3).setCellValue(as[i]);
                    }
                    row.createCell(as.length + 3).setCellValue(mapList.get(mi).get("AL"));
                    row.createCell(as.length + 4).setCellValue(mapList.get(mi).get("LOS"));
                    row.createCell(as.length + 5).setCellValue(mapList.get(mi).get("MF"));
                    row.createCell(as.length + 6).setCellValue(mapList.get(mi).get("MAN"));
                    row.createCell(as.length + 7).setCellValue(mapList.get(mi).get("WAS"));
                    row.createCell(as.length + 8).setCellValue(mapList.get(mi).get("AL[2]"));
                    row.createCell(as.length + 9).setCellValue(mapList.get(mi).get("LOS[2]"));
                    row.createCell(as.length + 10).setCellValue(mapList.get(mi).get("MF[2]"));
                    row.createCell(as.length + 11).setCellValue(mapList.get(mi).get("MAN[2]"));
                    row.createCell(as.length + 12).setCellValue(mapList.get(mi).get("WAS[2]"));

                }
            }
            String fileName = "卷接产量数据报告" + ".xlsx";
            logger.info("填充完毕，返回下载：{}", fileName);
            downLoadExcel(fileName, response, workbook);

        } catch (Exception e) {
            result.setCode("-1");
            result.setMsg("操作失败");
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity<Resource>(HttpStatus.OK);
    }

    public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> readName(String path, List<Map<String, String>> mapList, String dateS, String dateE) {
//        int days = 1;//开发测试时作为调整时间跨度和固定某天的数据
//        Date L = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * days);
//        SimpleDateFormat sp = new SimpleDateFormat("yyyyMMdd");
//        String timeL = sp.format(L);
//        String timeT = sp.format(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * (days - 1));
        int timeL = Integer.parseInt(dateS);
        int timeT = Integer.parseInt(dateE);
        File f = new File(path);
        File[] fs = f.listFiles();
        for (File subFile : fs) {
            if (subFile.isDirectory()) {
                mapList = readName(subFile.getPath(), mapList, dateS, dateE);
            } else {
                Map<String, String> sx = new HashMap<>();//读文件的数据集合，按照名称和数据分开，以等号作为标准
                if (subFile.getParent().length() > 20 && subFile.getName().equals("ShiftData.txt")) {//第一个比较是文件夹长度少于20长度的直接忽略，现在只读这个文件，后面如果要修改再换方案
                    String machineNO = subFile.getParent().substring(subFile.getParent().length() - 13, subFile.getParent().length() - 10);//剪切的方式获取机台号、时间、班组
                    String timeString = subFile.getParent().substring(subFile.getParent().length() - 9, subFile.getParent().length() - 1);
                    if (timeString.indexOf("-") != -1 || timeString.indexOf("\\") != -1) {
                        continue;
                    }
                    int time = Integer.parseInt(timeString);
                    String team = subFile.getParent().substring(subFile.getParent().length() - 1, subFile.getParent().length());
                    if (time >= timeL && time <= timeT) {
                        //选昨天的a:白班，c:零点
                        if (team.equals("a") || team.equals("c")) {
                            sx = readFile(subFile.getPath());//读一个文件全部内容，优化想读什么内容就读什么内容。第一步放入map，不按顺序，每个名称不重复。
                            mapList.add(sx);
                            sx.put("time", String.valueOf(time));
                        } else if (team.equals("b")) {
                            //今天的选b：中班，主要是今天的中班统计时间为凌晨，所以实际产量是昨天的中班。16:20~00:50
                            sx = readFile(subFile.getPath());
                            mapList.add(sx);
                            sx.put("time", String.valueOf(Integer.valueOf(time) - 1));
                        }
                    }
                    sx.put("machineNO", machineNO);
                    sx.put("team", team);
                }
            }
        }
        return mapList;
    }

    /**
     * 读入TXT文件
     */
    public static Map<String, String> readFile(String pathname) {
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；
        Map<String, String> smap = new HashMap<>();
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            int rows = 0;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                if (line.indexOf("=") != -1) {
                    int dt = 0;
                    dt = line.indexOf("=");
                    smap.put(line.substring(0, dt), line.substring(dt + 1, line.length()));
                }
                rows++;
                if (rows > 35) {
                    break;
                }
            }
            return smap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return smap;
    }

    public static void reName(String path, String from, String to) {

        File f = new File(path);
        File[] fs = f.listFiles();
        for (File subFile : fs) {
            // 如果文件是文件夹则递归调用批量更改文件后缀名的函数
            if (subFile.isDirectory()) {
                reName(subFile.getPath(), from, to);
            } else {
                String name = subFile.getName();
                if (name.endsWith(from)) {

                    subFile.renameTo(new File(subFile.getParent() + "/" + name.substring(0, name.indexOf(from)) + to));
                    /*
                     * 可在Java API中的File类中查询renameTo的方法
                     * renameTo可以用来给File改名字,改路径
                     * 他需要的参数也是一个File对象,表示要把当前文件重命名(移动)为哪个文件
                     * 如果目标文件存在,则此方法返回false
                     *
                     * renameTo不会产生新文件,他只是把文件移动一下,或者改个名字
                     *
                     * 实际上,这个方法的具体表现与操作系统,和文件系统都有关系.
                     * 它不能把一个文件从一个文件系统移动到另一个文件系统,例如: 不能把c:\a.txt renameTo 为
                     * d:\a.txt 因为c: d:属于不同的盘(文件系统) 但可以把c:\a.txt renameTo
                     * c:\system\bb.txt (路径,文件名都可以变,但还是在同一个分区)
                     * linux,unix的分区也是同样的道理,只不过不像Windows这么明显一眼就看出来不是同一个分区
                     *
                     * 你可以在系统中试一下: 在同一个分区内,剪切一个文件 ,在粘贴到另一个位置,这是瞬间完成的,无论文件多么大.
                     * 实际上没有copy操作,java的renameTo就是这个意思 不同分区的话,那就得先复制,然后删除源文件
                     */
                }
            }
        }
    }
}
