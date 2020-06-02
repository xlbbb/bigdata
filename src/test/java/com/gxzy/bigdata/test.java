package com.gxzy.bigdata;


import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by wwquan on 2019/6/20 21:49
 */
public class test {
    @Test
    public void test() throws IOException {
//        System.out.println(TimeUtils.getTodayDate());
//        System.out.println(TimeUtils.getTimeStamp());
//        System.out.println(SCUtils.getBatchNO());
        System.out.println("请输入要修改文件后缀名的文件夹:");
        String path = "D:\\wwquan\\normal\\广西中烟\\软件\\卷接大数据软件基础研究\\01数据\\20190729第一次数据处理\\J01\\";
        System.out.println("请输入修改前的后缀名:");
        String from = "ini";
        System.out.println("请输入修改后的后缀名:");
        String to = "txt";

        reName(path, from, to);
        System.out.println("全部修改完成!!!");

    }

    @Test
    public void test1() throws IOException {
        Map<String, String> stringStringMap =  readFile("D:\\wwquan\\normal\\广西中烟\\软件\\卷接大数据软件基础研究\\01数据\\J19\\ShiftData.txt");
        System.out.println(stringStringMap);
//        writeFile();
    }


    @Test
    public void test2() throws IOException {
        readName("D:\\wwquan\\normal\\广西中烟\\软件\\卷接大数据软件基础研究\\01数据\\20190729第一次数据处理\\");
    }

    public static void readName(String path) {

        Map<String, String> sx = new HashMap<>();//读文件的数据集合，按照名称和数据分开，以等号作为标准

        Date L = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        SimpleDateFormat sp = new SimpleDateFormat("yyyyMMdd");
        String timeL = sp.format(L);
        String timeT = sp.format(System.currentTimeMillis());


        File f = new File(path);
        File[] fs = f.listFiles();
        for (File subFile : fs) {
            if (subFile.isDirectory()) {
                readName(subFile.getPath());
            } else {
                if (subFile.getParent().length() > 70 && subFile.getName().equals("ShiftData.txt")) {
                    String time = subFile.getParent().substring(subFile.getParent().length() - 9, subFile.getParent().length() - 1);
                    String team = subFile.getParent().substring(subFile.getParent().length() - 1, subFile.getParent().length());
                    String name = subFile.getName();
                    if (time.equals(timeL)) {
                        //选a:白班，c:零点
                        if (team.equals("a") || team.equals("c")) {
                            sx = readFile(subFile.getPath());//读一个文件全部内容，优化想读什么内容就读什么内容。第一步放入map，不按顺序，每个名称不重复。
                            if (sx.isEmpty()) {
                                continue;
                            } else {
                                String lastData = sx.get("LastData");
                                String lineT = lastData.substring(lastData.indexOf("=") + 1, lastData.length());
                                System.out.println("lineT: " + lineT);
                                String[] as = lineT.split(",");//针对以逗号分隔的数据进行处理和返回结果，暂时不做成工具，等其他地方用到再做
                                for (int i = 0; i < as.length; i++) {
                                    System.out.println(as[i]);
                                }
                            }
                        }
                    } else if (time.equals(timeT)) {
                        //今天的选b：中班
                        if (team.equals("b")) {
                            readFile(subFile.getPath());
                        }
                    }
                }
            }
        }
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

    /**
     * 读入TXT文件
     */
    public static Map<String, String> readFile(String pathname) {
//        String pathname = "input.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        Map<String, String> smap = new HashMap<>();
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                if (line.indexOf("=") != -1) {
                    int dt = 0;
                    dt = line.indexOf("=");
                    smap.put(line.substring(0, dt), line.substring(dt + 1, line.length()));
                }
            }
            return smap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return smap;
    }

    /**
     * 写入TXT文件
     */
    public static void writeFile() {
        try {
            File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write("我会写入文件啦1\r\n"); // \r\n即为换行
                out.write("我会写入文件啦2\r\n"); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
