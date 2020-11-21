package com.han.utils.mail.pojo;

import java.io.File;

// 邮件对象
public class Mail {
    // 邮件发送方
    private String from;
    // 邮件发送至
    private String to;
    // 标题
    private String subject;
    // 内容
    private String content;
    // 附件
    private File file;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
