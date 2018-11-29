package com.example.edz.mvpretrofit.Bean;

import java.util.List;

public class TestBean {

    /**
     * code : 200
     * msg : 成功!
     * data : ["盗墓笔记续9","盗墓笔记续集","盗墓笔记之寻龙图","盗墓笔记12终极解密","盗墓笔记之迷途","盗墓笔记之寻仙","盗墓笔记之咒语","盗墓笔记续","盗墓笔记薄"]
     */

    private int code;
    private String msg;
    private List<String> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
