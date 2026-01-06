package com.example.demo.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;
import java.nio.file.*;

@Component
public class MappingWatcherService {

    private final XsdGeneratorService xsdService;

    // resources 中的 mapping.json
    private static final String MAPPING_JSON = "mapping.json";
    private static final String XSD_DIR = "src/main/resources/xsd_versions/";

    public MappingWatcherService(XsdGeneratorService xsdService) {
        this.xsdService = xsdService;
    }

    /**
     * 手動生成 XSD
     */
    public void generateXsd() {
        try {
            File versionedFile = new File(XSD_DIR + "generated_" + System.currentTimeMillis() + ".xsd");

            // 用 ClassPathResource + InputStream 讀取 JSON（jar-safe）
            ClassPathResource resource = new ClassPathResource(MAPPING_JSON);
            try (InputStream inputStream = resource.getInputStream()) {
                xsdService.generateXsdFromJson(inputStream, versionedFile, "Response", "N5107");
            }

            System.out.println("XSD generated: " + versionedFile.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 監控 resources 目錄的 JSON 檔案（開發模式可用）
     * jar 包中監控不起作用，建議開發時用
     */
    @PostConstruct
    public void watchMappingFile() {
        Thread thread = new Thread(() -> {
            try {
                Path path = Paths.get("src/main/resources/");
                WatchService watchService = FileSystems.getDefault().newWatchService();
                path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

                while (true) {
                    WatchKey key = watchService.take(); // 阻塞等待
                    for (WatchEvent<?> event : key.pollEvents()) {
                        Path changed = (Path) event.context();
                        if (changed.toString().endsWith(".json")) {
                            System.out.println("Mapping file changed: " + changed);

                            File versionedFile = new File(XSD_DIR + "generated_" + System.currentTimeMillis() + ".xsd");

                            // jar-safe 方式
                            ClassPathResource resource = new ClassPathResource(changed.toString());
                            try (InputStream inputStream = resource.getInputStream()) {
                                xsdService.generateXsdFromJson(inputStream, versionedFile, "Response", "N5107");
                            }

                            System.out.println("New XSD generated: " + versionedFile.getName());
                        }
                    }
                    key.reset();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
