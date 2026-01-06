package com.example.demo;

public class Section {
    private Long id;
    private String title;
    private String content;
    private String fileName;      // 檔名
    private byte[] fileData;      // 上傳檔案資料

    public Section(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // getters / setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getFileName() { return fileName; }
    public byte[] getFileData() { return fileData; }

    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setFileData(byte[] fileData) { this.fileData = fileData; }
}
