package cg.park.springlotto.comm.constant;

public enum MessageEnum {

    // Success 응답 코드
     S0001 ("S0001")

    // Parameter 유효성 미검증 코드
    ,P0001 ("P0001")
    ,P0002 ("P0002")

    // Error 코드
    ,E0001 ("E0001")
    ;// 마무리 세미콜론

    private final String codeType;

    MessageEnum(String codeType) {this.codeType = codeType;}

    public String getCodeType() {
        return codeType;
    }
}
