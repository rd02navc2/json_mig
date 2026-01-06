package com.example.demo;

import org.springframework.stereotype.Service;
import com.example.demo.XmaDB;
//import com.phase1.XmaTwXsdBuilder;
import com.example.demo.MyConst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

@Service
public class HarmoService {
   public String runMultipleNX(List<String> nxLines) throws Exception {
        StringBuilder sb = new StringBuilder();

        InputStream is = getClass().getClassLoader().getResourceAsStream("settings.properties");
        if (is != null) {
            Properties props = new Properties();
            props.load(is);
            sb.append("Loaded settings.properties\n");
        } else {
            sb.append("settings.properties not found in classpath\n");
        }

        String outputDir = System.getProperty("user.dir") + "/output/";
        Files.createDirectories(Paths.get(outputDir, "common"));
        Files.createDirectories(Paths.get(outputDir, "maindoc"));
        sb.append("Output directories initialized: ").append(outputDir).append("\n");

        MyConst.msg = nxLines.stream()
                .filter(line -> !line.trim().isEmpty())
                .map(line -> line.split(",", 5))
                .toArray(String[][]::new);
        sb.append("Initialized MyConst.msg with ").append(MyConst.msg.length).append(" entries\n");

        XmaDB db = new XmaDB();
        db.openConnection();
        sb.append("DB connected\n");

        for (String[] parts : MyConst.msg) {
            if (parts.length < 5) {
                sb.append("Skipping invalid line: insufficient columns\n");
                continue;
            }
            for (int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();

            String nxCode = parts[0];
            sb.append("\nProcessing NX: ").append(nxCode).append("\n");

            try {

//              // =====================================================================
        //
//              // 檢查資料項目表 之中英文名稱, 屬性及長度與 DB 中的資料一致
                H.checkDataItemFormatetc(); //12/17 okay
//              System.out.println("************************************\n");
        //
//              // 檢查資料項目表與訊息樹狀圖中之 "資料項目" 一致
//              // 注意 :
//              // 若有兩個資料項目中文名稱相同時, 無法分辨 !!!
//              // 也無法比對 M/C, 迴圈..
            	H.checkChapter4n8(); //12/17 okay
//              System.out.println("************************************\n");
        //
//              // =====================================================================
        //
               
        		// H.mappingXsd();                    
                H.checkTree();            
                H.makeTDLDENs(); 
                
                H.makeDataItemSet();
                H.makeItemDescTemplate(); 
                H.makeMappingTree(); 
           
                File xsdFile = new File(outputDir + "maindoc/" + nxCode + ".xsd");
                xsdFile.getParentFile().mkdirs();
                try (FileOutputStream fos = new FileOutputStream(xsdFile)) {
                    fos.write(("<xsd>Dummy content for " + nxCode + "</xsd>").getBytes());
                }

                sb.append("NX ").append(nxCode).append(" done.\n");
            } catch (Exception e) {
                sb.append("Error processing ").append(nxCode).append(": ").append(e.getMessage()).append("\n");
            }
        }

        db.closeConnection();
        sb.append("DB disconnected\nAll done!\n");

        return sb.toString();
    }
}
