package com.wallofshame.controller;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class JsonView implements View {
    private String json;

    public JsonView(String json) {
        this.json = json;
    }

    public String getContentType() {
        return "text/x-json";
    }

    public void render(Map<String, ?> stringMap, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.write(this.json);
        printWriter.flush();
        printWriter.close();
    }
}
