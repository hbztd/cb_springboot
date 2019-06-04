package edu.hbuas.cb.common;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 18:38
 **/
public interface Const {
    String WAY_TYPE= "TYPE";
    String WAY_SEARCH = "SEARCH";
    int PEER_PAGE_LENGTH = 10;

    enum ResponseCode {
        SUCCESS(0, "SUCCESS"),
        ERROR(1, "ERROR");

        private final int code;
        private final String desc;

        ResponseCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
